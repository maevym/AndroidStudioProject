package com.example.projectinsorma_maevymarvella;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ProfilePage extends AppCompatActivity implements View.OnClickListener{

    TextView email, old_username, new_username, phoneNumber;
    Button save, edit, delete, logout;
    Bundle extras;
    Integer num;
    String uname;

    void showEdit(){
        save.setVisibility(View.INVISIBLE);
        new_username.setVisibility(View.INVISIBLE);
        edit.setVisibility(View.VISIBLE);
        old_username.setVisibility(View.VISIBLE);
    }

    void showSave(){
        edit.setVisibility(View.INVISIBLE);
        old_username.setVisibility(View.INVISIBLE);
        save.setVisibility(View.VISIBLE);
        new_username.setVisibility(View.VISIBLE);
    }

    void init(){
        email = findViewById(R.id.profile_email);
        old_username = findViewById(R.id.profile_username);
        new_username = findViewById(R.id.profile_new_username);
        phoneNumber = findViewById(R.id.profile_phone_number);
        save = findViewById(R.id.profile_button_save_changes);
        edit = findViewById(R.id.profile_button_edit_username);
        extras = getIntent().getExtras();
        delete = findViewById(R.id.profile_button_delete);
        logout = findViewById(R.id.profile_button_log_out);

        showEdit();

        save.setOnClickListener(this);
        edit.setOnClickListener(this);
        delete.setOnClickListener(this);
        logout.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);
        init();

        num = extras.getInt("userIndex", 0);
        String email_acc, username_acc, phoneNum;
        email_acc = userCollection.user.elementAt(num).UserEmailAddress;
        username_acc = userCollection.user.elementAt(num).UserUsername;
        phoneNum = userCollection.user.elementAt(num).UserPhoneNumber;
        email.setText(email_acc);
        old_username.setText(username_acc);
        phoneNumber.setText(phoneNum);
    }

    @Override
    public void onClick(View view) {
        if(view == save){
            uname = new_username.getText().toString();
            if(userCollection.usernameExist(uname)){
                Toast.makeText(this, "Username is not unique", Toast.LENGTH_SHORT).show();
            }else if(uname.equals("")){
                showEdit();
            }
            else{
                old_username.setText(uname);
                userCollection.changeUsername(num, uname);
                showEdit();
                Toast.makeText(this, "Change Username", Toast.LENGTH_SHORT).show();
            }

        }else if(view == edit){
            showSave();
        }else if(view == delete){
            userCollection.deleteUser(num);
            Intent delete_user = new Intent(ProfilePage.this, MainActivity.class);
            startActivity(delete_user);
        }else if(view == logout){
            Intent log_out = new Intent(ProfilePage.this, MainActivity.class);
            startActivity(log_out);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    void goHome(){
        Intent goHome = new Intent(this, HomePage.class);
        goHome.putExtra("userIndex", num);
        startActivity(goHome);
    }

    void goTransactionHistory(){
        Intent goTransaction = new Intent(this, TransactionHistory.class);
        goTransaction.putExtra("userId", num);
        startActivity(goTransaction);
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
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}