package com.example.pits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pits.Home;
import com.example.pits.RegisterActivity;

import java.util.Locale;

public class SigninActivity extends AppCompatActivity {

    private static final String FILE_NAME = "myFile";
    private Button login_button;
    private CheckBox save;
    private EditText email;
    private EditText password;
    TextView Create_New_Account;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        getActionBar().hide();

        login_button = findViewById(R.id.login_button);
        save = findViewById(R.id.save);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        preferences = getSharedPreferences("userinfo", MODE_PRIVATE);
        // SharedPreferences preferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        // String Email =preferences.getString("Email"," ");
        // String Password =preferences.getString("Password","");
        // email.setText(Email);
        //password.setText(Password);

//localization
        Button language = findViewById(R.id.language);
        language.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SigninActivity.this, R.string.Ar, Toast.LENGTH_LONG).show();
            }
        });


        Create_New_Account = findViewById(R.id.create_new_account);
        Create_New_Account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SigninActivity.this, RegisterActivity.class);
                startActivity(intent);
//or
                startActivity(new Intent(SigninActivity.this, RegisterActivity.class));


            }
        });

        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString();
                String Password = password.getText().toString();
                //String registeredEmail=preferences("Email","");
                String registeredEmail = preferences.getString("Email", "Email");
                String registeredPassword = preferences.getString("Password", "Password");
                if (Email.equals(registeredEmail) && Password.equals(registeredPassword)) {
                    Intent intent = new Intent(getApplicationContext(), Home.class);
                    Bundle b = new Bundle();
                    b.putString("email", email.getText().toString());
                    b.putString("password", password.getText().toString());
                    intent.putExtras(b);
                    startActivity(intent);

                }
                if (save.isChecked()) {
                    preferences(Email, Password);

                }
                //    Intent intent=new Intent(getApplicationContext(),Home.class);
                //    Bundle b=new Bundle();
                //    b.putString("email",email.getText().toString());
                //   b.putString("password",password.getText().toString());
                //   intent.putExtras(b);
                // intent.putExtra("email",email.getText().toString());
                // intent.putExtra("password",password.getText().toString());
                //   startActivity(intent);

            }
        });


    }



    private void preferences(String Email, String Password) {
        SharedPreferences.Editor editor = getSharedPreferences(FILE_NAME, MODE_PRIVATE).edit();
        editor.putString("Email", Email);
        editor.putString("Password", Email);
        editor.apply();
        editor.commit();
    }
}

