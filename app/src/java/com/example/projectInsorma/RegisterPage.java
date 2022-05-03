package com.example.projectinsorma_maevymarvella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterPage extends AppCompatActivity implements View.OnClickListener{

    TextView email, uname, phoneNum, pass;
    Button btnRegister, btnBackLogin;

    void init(){
        email = findViewById(R.id.EmailRegister);
        uname = findViewById(R.id.UsernameRegister);
        phoneNum = findViewById(R.id.PhoneNumberRegister);
        pass = findViewById(R.id.PasswordRegister);
        btnRegister = findViewById(R.id.ButtonRegister);
        btnBackLogin = findViewById(R.id.ButtonLogin);
        btnRegister.setOnClickListener(this);
        btnBackLogin.setOnClickListener(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);
        init();
    }

    boolean validateRegister(){
        if(email.getText().toString().isEmpty() || uname.getText().toString().isEmpty() || phoneNum.getText().toString().isEmpty() || pass.getText().toString().isEmpty()){
            Toast.makeText(this, "All fields are required", Toast.LENGTH_SHORT).show();
            return false;
        }
        //email address must end with '.com'
        if(!email.getText().toString().endsWith(".com")){
            Toast.makeText(this, "Email adress must end with '.com'", Toast.LENGTH_SHORT).show();
            return false;
        }
        //validate username must be between 3 and 20 characters (inclusive)
        if(uname.getText().toString().length()<3 || uname.getText().toString().length()>20){
            Toast.makeText(getApplicationContext(), "Username must be between 3 and 20 characters", Toast.LENGTH_SHORT).show();
            return false;
        }
        //validate password must contain both letters and numbers (alphanumeric)
        if(!pass.getText().toString().matches("^(?=.*[a-zA-Z])(?=.*[0-9])[A-Za-z0-9]+$")){
            Toast.makeText(this, "password must contain both letters and numbers (alphanumeric)", Toast.LENGTH_SHORT).show();
            return false;
        }
        //validate email and username is unique
        if(userCollection.emailExist(email.getText().toString())){
            Toast.makeText(this, "Email already exist", Toast.LENGTH_SHORT).show();
            return false;
        }

        if(userCollection.usernameExist(uname.getText().toString())){
            Toast.makeText(this, "Username already exist", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
     if(view == btnBackLogin){
         Intent x = new Intent(this, MainActivity.class);
         startActivity(x);
     }else if(view == btnRegister){
         //all fields must be filled
         if(validateRegister()){
             userCollection.createNewUser(email.getText().toString(), uname.getText().toString(), phoneNum.getText().toString(), pass.getText().toString());
             Toast.makeText(this, "Registration Success!", Toast.LENGTH_SHORT).show();
             Intent sukses = new Intent(this, MainActivity.class);
             startActivity(sukses);
         }
     }
    }
}