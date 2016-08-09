package asknlearn.com.pushdemo;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.support.v7.app.NotificationCompat;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnNotif;
    int notificationID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotif=(Button)findViewById(R.id.btn_triggerPush);
        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNotification();
            }
        });




    }



    // this creates the notif, setup intents and shows as push in notification drawer
    // code taken from
    //  http://www.tutorialspoint.com/android/android_notifications.htm
    private void callNotification()
    {
        notificationID++;
        //build notificaion
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Notification Demo: " + notificationID)
                .setContentText("This is Notificaiton #" + notificationID);

        //adding action

        Intent resultIntent = new Intent(this, LoginActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(LoginActivity.class);

// Adds the Intent that starts the Activity to the top of the stack
        stackBuilder.addNextIntent(resultIntent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0,PendingIntent.FLAG_UPDATE_CURRENT);
        mBuilder.setContentIntent(resultPendingIntent);

// issue the notification
        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

// notificationID allows you to update the notification later on.
        mNotificationManager.notify(notificationID, mBuilder.build());



    }

}
