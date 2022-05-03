package com.example.projectinsorma_maevymarvella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class HomePage extends AppCompatActivity {

    TextView greetings, listEmptyText;
    Bundle extras;
    Integer num;
    ListView pv;
    String email, password;
    public static ArrayList<Product> products = new ArrayList<>();

    void init(){
        greetings = findViewById(R.id.greetingsText);
        extras = getIntent().getExtras();
        pv = findViewById(R.id.productView);
        listEmptyText = findViewById(R.id.ifEmpty);
        pv.setEmptyView(listEmptyText);
    }

    void generateDummyProducts(){
        products = new ArrayList<>();
        products.add(new Product("Bantal Hitam", "Bantal hitam 40x30cm dari bahan katun", "4", "20000", R.drawable.bantal_hitam, products.size()));
        products.add(new Product("Cetakan Es Krim", "Cetakan es krim untuk 6 es krim dari plastik","3", "15000", R.drawable.cetakan_es, products.size()));
        products.add(new Product("Kasur Queen Size", "Kasur ukuran besar dijamin empuk", "2", "5000000", R.drawable.kasur, products.size()));
        products.add(new Product("Lampu Lantai Dekorasi", "Lampu berdiri khusus untuk hiasan ruangan LED", "5", "1000000", R.drawable.lampu_lantai, products.size()));
        products.add(new Product("Lampu Meja Belajar", "Lampu meja belajar terang LED dan portable", "3", "10000", R.drawable.lampu_meja, products.size()));
        products.add(new Product("Matras Ranjang", "Matras ranjang empuk khusus untuk ukuran single bed", "4", "1000000", R.drawable.matras_ranjang, products.size()));
        products.add(new Product("Meja Belajar Putih", "Meja belajar ukuran 10x10cm untuk belajar", "5", "1000000", R.drawable.meja_putih, products.size()));
        products.add(new Product("Meja Rias", "Meja rias warna putih untuk makeup", "5", "123333", R.drawable.meja_rias, products.size()));
        products.add(new Product("Meja Samping Tempat Tidur", "Meja ukuran 20x30cm cocok untuk ditaruh disamping ranjang", "5", "1222200", R.drawable.meja_samping_tempat_tidur, products.size()));
        products.add(new Product("Rangkai Tempat Tidur", "Rangkai tempat tidur single bed", "5", "5000000", R.drawable.rangkai_kasur, products.size()));
    }

    public static ArrayList<Product> getProductList(){
        return products;
    }

    public static String findProductName(Integer productId){
        for (Product p: products) {
            if(productId == p.ProductId){
                return p.ProductName;
            }
        }
        return null;
    }

    public static Integer findProductPrice(Integer productId){
        for (Product p: products) {
            if(productId == p.ProductId){
                return Integer.valueOf(p.ProductPrice);
            }
        }
        return 0;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        init();
        generateDummyProducts();

//        num = extras.getInt("userIndex", 0);
        email = extras.getString("userEmail", "");
        password = extras.getString("userPassword", "");

        num = userCollection.findUserIndex(email, password);
        String uname;
        uname = userCollection.user.get(num).getUserUsername();
        greetings.setText("Hello " + uname);

        ProductAdapter pa = new ProductAdapter(this,R.layout.product_item, products);
        pv.setAdapter(pa);

        pv.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent goToDetail = new Intent(HomePage.this, DetailPage.class);
                goToDetail.putExtra("itemId", products.get(i).getProductId());
                goToDetail.putExtra("itemName", products.get(i).getProductName());
                goToDetail.putExtra("itemDesc", products.get(i).getProductDescription());
                goToDetail.putExtra("itemRating", products.get(i).getProductRating());
                goToDetail.putExtra("itemPrice", products.get(i).getProductPrice());
                goToDetail.putExtra("itemImage", products.get(i).getProductImage());
                goToDetail.putExtra("userId", num);

                startActivity(goToDetail);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    void goTransactionHistory(){
        Intent goTransaction = new Intent(HomePage.this, TransactionHistory.class);
        goTransaction.putExtra("userId", num);
        startActivity(goTransaction);
    }

    void goProfile(){
        Intent goProf = new Intent(HomePage.this, ProfilePage.class);
        goProf.putExtra("userIndex", num);
        startActivity(goProf);
    }


    //untuk menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
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