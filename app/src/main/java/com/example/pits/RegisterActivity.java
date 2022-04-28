package com.example.pits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    private Button register_button;
    EditText email , password ,confirm_password;
    SharedPreferences preferences;

    TextView Aleady_have_account;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getActionBar().hide();

        email= findViewById(R.id.email);
        password= findViewById(R.id.password);
        confirm_password = findViewById(R.id.confirm_password);
        preferences=getSharedPreferences("userinfo",MODE_PRIVATE);

        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String Password=password.getText().toString();
                String Confirm_password=confirm_password.getText().toString();
                if(Email.length()>1) {
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("email", Email);
                    editor.putString("password", Email);
                    editor.putString("confirm_password", Email);
                    editor.apply();
                    editor.commit();
                    Toast.makeText(RegisterActivity.this, "Ueser registered", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(RegisterActivity.this," Enter the data", Toast.LENGTH_SHORT).show();
                }

            }
        });


        Aleady_have_account= findViewById(R.id.Alreasy_have_account);
        Aleady_have_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, SigninActivity.class));

            }
        });

        register_button=findViewById(R.id.register_button);
        register_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this, SigninActivity.class));
            }
        });

    }
}