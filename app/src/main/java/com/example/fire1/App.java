package com.example.fire1;

import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;

public class App extends  Application{

    public static final String FCM_CHANNEL_ID="FCM_CHANNEL_ID";
//carete your own channel
    @Override
    public void onCreate() {
        super.onCreate();
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.O){
            NotificationChannel fcmNotificationChannel=new NotificationChannel(FCM_CHANNEL_ID,"FCM_CHANNEL", NotificationManager.IMPORTANCE_HIGH);
            NotificationManager notificationManager=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(fcmNotificationChannel);

        }
    }
}
