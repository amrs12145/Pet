package com.example.pits;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        next=findViewById(R.id.newButton);
        next.setOnClickListener(this);


    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.newButton:
                Intent intent=new Intent(view.getContext(),OrientalCat.class);
                startActivity(intent);
            break;
        }
    }


}