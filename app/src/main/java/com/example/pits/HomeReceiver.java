package com.example.pits;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class HomeReceiver extends BroadcastReceiver {
    int flag=0;
    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction = intent.getAction(); //Get received intent from the Android System

        if (intentAction != null) {
            String toastMessage = "unknown intent action";
            switch (intentAction){
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage = "Power connected!";
                    break;
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage = "Power disconnected!";
                    flag=0;
                    break;
                case Intent.ACTION_HEADSET_PLUG:
                    if(flag==0){
                        toastMessage = "HEADSET SUCCESSIFULY CONNECTED";
                        flag=1;
                    }else{
                        toastMessage = "HEADSET SUCCESSIFULY REMOVED";
                        flag=0;
                    }
                    break;
            }

            //Display the toast.
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }

}