package com.example.fire1;

import android.app.Notification;
import android.app.NotificationManager;
import android.graphics.Color;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import static com.example.fire1.App.FCM_CHANNEL_ID;

public class FCMService extends FirebaseMessagingService {
    //override the three methods
//    Notification Messages:
//when the app is in background it is handled by FCM SDK
//and the app is in foreground it is handled as a part of firebase messaging service extended class in on Message Received
//Data messages:
//when the app is in background or in the foreground it is handled as a part of firebase messaging service extended class in on Message Received
//Notification and data messages:
//when the app is in background notification part is handled as part of FCM SDK, and the data is handled as a part of firebase messaging service extended class in on Message Received
//When the app is in foreground both of them needs to be handled as a part of firebase messaging service extended class in on Message Received
//Have also you might need for the notification part to be handled in the foreground to have a separate notification channel thereby utilizing which you create a new notification with icon title body
//both notification and data messages in the same payload would have to be checked for being null four get remote notification and get Data
    //If it is a notification only the notification part will be executed and if it is the data only if the data part will be executed if it contains both notification and data both the two if
// conditional statements will be executed
//but data messages are not counted as get remote notification
    //full only data message will be sent using the rest api server
    //For both delivery of the data and notification onMessage Received will be called two times one for each
    @Override
    public void onMessageReceived(@NonNull RemoteMessage remoteMessage) {
        super.onMessageReceived(remoteMessage);
        Log.d("Sel", "onMessageReceived");
        Log.d("Sel", "onMessageReceived from" + remoteMessage.getFrom());//to know from where you got it from
        if (remoteMessage.getNotification() != null) {
            String title = remoteMessage.getNotification().getTitle();
            String body = remoteMessage.getNotification().getBody();

            Notification notification = new NotificationCompat.Builder(this, FCM_CHANNEL_ID)
                    .setSmallIcon(R.drawable.ic_baseline_chat)
                    .setContentTitle(title)
                    .setContentText(body)
                    .setColor(Color.BLUE)
                    .build();
            //here is is only customizes for foreground messaging but when in back ground handled by default sdk settings
            NotificationManager notificationManager= (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
            notificationManager.notify(1002,notification);
        }
        if (remoteMessage.getData() != null) {
            Log.d("Sel","Data is" + remoteMessage.getData().toString());
        }
    }

    @Override
    public void onDeletedMessages() {
        super.onDeletedMessages();
        Log.d("Sel", "onDeletedMessages");

    }

    @Override
    public void onNewToken(@NonNull String s) {
        super.onNewToken(s);
        Log.d("Sel", "onNewToken");

    }
}
