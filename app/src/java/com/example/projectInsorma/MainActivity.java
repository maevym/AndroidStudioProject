package com.example.projectinsorma_maevymarvella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView Email, Password;
    Button Login, Register;
    Integer userId;

    void init(){
        Email = findViewById(R.id.EmailLogin);
        Password = findViewById(R.id.PasswordLogin);
        Login = findViewById(R.id.LoginButton);
        Register = findViewById(R.id.RegisterButton);
        Login.setOnClickListener(this);
        Register.setOnClickListener(this);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userCollection.createDummyUser();
        init();
    }

    boolean validateFieldLogin(){
        //validate all fields must be filled in + error message
        if(Email.getText().toString().isEmpty() || Password.getText().toString().isEmpty()){
            Toast.makeText(this, "All fields are required!", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        if(view == Login){
            
            //else validate password must be correct based on the email address + error message
            if(validateFieldLogin()){
                if(userCollection.loginUserExist(Email.getText().toString(), Password.getText().toString())){
                    Toast.makeText(this, "Logging in", Toast.LENGTH_SHORT).show();
                    userId = userCollection.findUserID(Email.getText().toString(), Password.getText().toString());
                    Intent login = new Intent(this, HomePage.class);
                    login.putExtra("userIndex", userId);
                    login.putExtra("userEmail", Email.getText().toString());
                    login.putExtra("userPassword", Password.getText().toString());
                    startActivity(login);
                }else{
                    Toast.makeText(this, "User data is invalid", Toast.LENGTH_SHORT).show();
                }
            }

        }else if(view == Register){
            Intent i = new Intent(MainActivity.this, RegisterPage.class);
            startActivity(i);
        }
    }
}