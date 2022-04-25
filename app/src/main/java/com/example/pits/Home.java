package com.example.pits;

//import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //create custom toolbar rather than default Actionbar
        createCustomToolbar();

        //myRecycle View
        myRecycleView();

    }
  //**********//myRecycle View
    private void myRecycleView() {
        ArrayList<String>mWordList;
        RecyclerView myRecyclerView;
        mWordList=new ArrayList<>();
        mWordList.add("Text1");
        mWordList.add("Text2");
        mWordList.add("Text3");
        mWordList.add("Text4 ");


        myRecyclerView=findViewById(R.id.myrecyclerview);
        CustomAdapter myAdabter=new CustomAdapter(mWordList);
        myRecyclerView.setAdapter(myAdabter);
    }
    //**********//myRecycle View

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