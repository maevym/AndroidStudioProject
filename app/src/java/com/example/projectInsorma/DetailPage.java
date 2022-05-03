package com.example.projectinsorma_maevymarvella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class DetailPage extends AppCompatActivity implements View.OnClickListener{

    TextView name, desc, price, rating, quantity;
    ImageView img;
    Bundle extras;
    String prod_name, prod_desc, prod_price, prod_rating;
    int prod_img;
    Integer id_user, prod_id;
    Button buyButton;
    ArrayList<Transactions> temp_transaction = TransactionCollection.getList();

    void init(){
        img = findViewById(R.id.detailImage);
        name = findViewById(R.id.DetailName);
        desc = findViewById(R.id.DetailDescription);
        price = findViewById(R.id.DetailPrice);
        rating = findViewById(R.id.DetailRating);
        extras = getIntent().getExtras();
        quantity = findViewById(R.id.detailQuantity);
        buyButton = findViewById(R.id.buttonBuyFurniture);
        buyButton.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_page);

        init();
        prod_name = extras.getString("itemName", "");
        prod_desc = extras.getString("itemDesc", "");
        prod_rating = extras.getString("itemRating", "");
        prod_price = extras.getString("itemPrice", "");
        prod_img = extras.getInt("itemImage", 0);
        id_user = extras.getInt("userId", 0);
        prod_id = extras.getInt("itemId", 0);

        name.setText(prod_name);
        desc.setText(prod_desc);
        rating.setText(prod_rating);
        price.setText("Rp " + prod_price + ",00");
        img.setImageResource(prod_img);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    void goTransactionHistory(){
        Intent goTransaction = new Intent(this, TransactionHistory.class);
        goTransaction.putExtra("userId", id_user);
        startActivity(goTransaction);
    }

    void goProfile(){
        Intent goProf = new Intent(this, ProfilePage.class);
        goProf.putExtra("userIndex", id_user);
        startActivity(goProf);
    }

    void goHome(){
        Intent goHome = new Intent(this, HomePage.class);
        goHome.putExtra("userIndex", id_user);
        startActivity(goHome);
    }

    //untuk menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                goHome();
                return true;
            case R.id.transaction_history:
                goTransactionHistory();
                return true;
            case R.id.profile:
                goProfile();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static boolean qtyisEmpty(String qty){
        if(qty.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    boolean buyCheck(String qty){
        if(qty.equals("")){
            Toast.makeText(this, "Please Enter the Product Quantity", Toast.LENGTH_SHORT).show();
            return false;
        }
        if(Integer.parseInt(qty)<=0){
            Toast.makeText(this, "Please Input Product Quantity Larger Than 0", Toast.LENGTH_SHORT).show();
            return false;
        }else{
            temp_transaction.add(new Transactions(id_user, prod_id, temp_transaction.size(), TransactionCollection.getDateNow(), qty));
            return true;
        }
    }

    @Override
    public void onClick(View view) {
        if(view == buyButton){
            String qty = quantity.getText().toString();
            if(buyCheck(qty)){
                Toast.makeText(this, "Added to Transaction History", Toast.LENGTH_SHORT).show();
            }
        }
    }
}