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
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnNotif, btnSQLMain;
    int notificationID = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNotif=(Button)findViewById(R.id.btn_triggerPush);
        btnSQLMain =(Button)findViewById(R.id.btn_LoadSQLMain);
        btnNotif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callNotification();
            }
        });

        btnSQLMain = (Button)findViewById(R.id.btn_LoadSQLMain);
        btnSQLMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),SQL_MainActivity.class);
                startActivity(intent);
            }
        });




    }



    // this creates the notif, setup intents and shows as push in notification drawer
    // code taken from
    //  http://www.tutorialspoint.com/android/android_notifications.htm
    // additionalr ef: https://developer.android.com/training/notify-user/build-notification.html#action
    private void callNotification()
    {

        //todo: impleement a try check incase the label value is null.
        EditText eTitle, eDescrption;
        eTitle = (EditText)findViewById(R.id.txtHeader);
        String title = eTitle.getText().toString();
        eDescrption = (EditText)findViewById(R.id.txtDesc);
        String description = eDescrption.getText().toString();




        notificationID++;
        //build notificaion
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title + notificationID)
                .setContentText(description + notificationID);

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
