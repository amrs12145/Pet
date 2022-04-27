package com.example.pits;

//import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {
    private static final String FILE_NAME = "myFile";
    private Button logout_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Bundle b=getIntent().getExtras();
        String email=b.getString("email");
        logout_button= findViewById(R.id.login_button);
        logout_button=findViewById(R.id.login_button);
        SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
        String Email=sharedPreferences.getString("Email","Data not found");
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SigninActivity.class);
                startActivity(intent);

            }
        });

        //create custom toolbar rather than default Actionbar
        createCustomToolbar();


    }

    //**************OptionsMenu mytoolbar
    public void createCustomToolbar(){

        // Find the toolbar view and set as ActionBar
        Toolbar myToolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menutoolbar, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.notification:
                Toast.makeText(this,"notification",Toast.LENGTH_LONG).show();
                return true;

            case R.id.item1:
                Toast.makeText(this,"item1",Toast.LENGTH_LONG).show();
                return true;

            default:
                // If we got here, the user's action was not recognized.
                // Invoke the superclass to handle it.
                return super.onOptionsItemSelected(item);

        }
    }
    //**************OptionsMenu mytoolbar


}