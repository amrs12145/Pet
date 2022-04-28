package com.example.pits;

//import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NotificationCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
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

public class Home extends AppCompatActivity implements View.OnClickListener {

    private static final String FILE_NAME = "myFile";
    private Button logout_button;
    private Button myButton;

    private ArrayList<String>mWordList;
    private ArrayList<Integer>cardImage;
    private RecyclerView myRecyclerView;
    private HomeReceiver customReceiver;

    private static final String CHANNEL_ID = "notification_channel";
    private static final int NOTIFICATION_ID = 0;
    private NotificationManager mNotifyManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        //create custom toolbar rather than default Actionbar
        createCustomToolbar();

        //myRecycle View
        myRecycleView();

        //customBroadcastReceiver
        customHomeReceiver();

        //custom Notification create chanel to specify notification configrition
        createNotificationChannel();

//        moveToSignIn();

        myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(this);
    }

//    protected void moveToSignIn(){
//        Bundle b=getIntent().getExtras();
//        String email=b.getString("email");
//        logout_button= findViewById(R.id.login_button);
//        logout_button=findViewById(R.id.login_button);
//        SharedPreferences sharedPreferences=getSharedPreferences(FILE_NAME,MODE_PRIVATE);
//        String Email=sharedPreferences.getString("Email","Data not found");
//        logout_button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(getApplicationContext(),SigninActivity.class);
//                startActivity(intent);
//
//            }
//        });
//    }




    //**********//myRecycle View
    private void myRecycleView() {

        mWordList=new ArrayList<>();
        mWordList.add("Text1");
        mWordList.add("Text2");
        mWordList.add("Text3");
        mWordList.add("Text4 ");

        cardImage=new ArrayList<>();
        cardImage.add(R.drawable.im_gray2cat);
        cardImage.add(R.drawable.im_pur1cat);
        cardImage.add(R.drawable.im_read1dog);
        cardImage.add(R.drawable.im_gray2cat);



        myRecyclerView=findViewById(R.id.myrecyclerview);
        CustomAdapter myAdabter=new CustomAdapter(mWordList,cardImage);
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
                //send Notification
                sendNotification();
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
    public void createNotificationChannel()
    {
        mNotifyManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O)
        { //Because notification channels are only available in API 26 and higher

            // Create a NotificationChannel
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "custom Notification", NotificationManager
                    .IMPORTANCE_HIGH);

            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Mascot");
            mNotifyManager.createNotificationChannel(notificationChannel);
        }

    }
    private NotificationCompat.Builder getNotificationBuilder(){
        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.ic_notification_message);
        return notifyBuilder;
    }
    private void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        mNotifyManager.notify(NOTIFICATION_ID, notifyBuilder.build());
    }

    //**************OptionsMenu mytoolbar
    private void customHomeReceiver() {
        customReceiver=new HomeReceiver();

        IntentFilter filter = new IntentFilter(); //Specify type of Actions will be received by customReceiver
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_HEADSET_PLUG);


        // Register the receiver using the activity context.
        this.registerReceiver(customReceiver, filter);
    }
    //**********customHomeReceiver

    //onDestroy
    @Override
    protected void onDestroy() {
        //Unregister the receiver
        this.unregisterReceiver(customReceiver);
        super.onDestroy();
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.myButton:
                Intent intent=new Intent(view.getContext(),SigninActivity.class);
                startActivity(intent);
                break;
        }
    }


}