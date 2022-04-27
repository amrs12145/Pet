package com.example.pits;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class OrientalCat extends AppCompatActivity {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oriental_cat);

        next=findViewById(R.id.newButton);
        next.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View view) {
                if(view !=null){
                    Intent intent=new Intent(view.getContext(),Home.class);
                    startActivity(intent);
                }

            }
        });
    }
}