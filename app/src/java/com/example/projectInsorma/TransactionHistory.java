package com.example.projectinsorma_maevymarvella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class TransactionHistory extends AppCompatActivity {

    Integer userId;
    Bundle extras;
    Integer total;
    ListView tv;
    TextView isEmptylist;
    ArrayList<Transactions> user_transaction = new ArrayList<>();
    ArrayList<Transactions> temp_transaction = TransactionCollection.getList();

    void init(){
        extras = getIntent().getExtras();
        tv = findViewById(R.id.transactionView);
        isEmptylist = findViewById(R.id.isEmptyList);
        tv.setEmptyView(isEmptylist);
    }

    void createTransactionList(Integer userId){
        user_transaction = new ArrayList<>();
        for (Transactions t: temp_transaction) {
            if(t.UserID == userId){
                user_transaction.add(new Transactions(t.UserID, t.ProductID, t.TransactionID, t.TransactionDate, t.Quantity));
            }
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transaction_history);
        init();

        userId = extras.getInt("userId", 0);
        createTransactionList(userId);

        TransactionAdapter ta = new TransactionAdapter(this,R.layout.transaction_item, user_transaction);
        tv.setAdapter(ta);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    void goHome(){
        Intent goHome = new Intent(this, HomePage.class);
        goHome.putExtra("userIndex", userId);
        startActivity(goHome);
    }

    void goTransactionHistory(){
        Intent goTransaction = new Intent(this, TransactionHistory.class);
        goTransaction.putExtra("userId", userId);
        startActivity(goTransaction);
    }

    void goProfile(){
        Intent goProf = new Intent(this, ProfilePage.class);
        goProf.putExtra("userIndex", userId);
        startActivity(goProf);
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
}