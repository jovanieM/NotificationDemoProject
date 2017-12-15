package com.jmolas.notificationdemoproject;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button notificationBtn = findViewById(R.id.noti);

        notificationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                runNotification();
            }
        });
    }

    public void runNotification(){

        NotificationConfigBuilder notificationConfigBuilder = new NotificationConfigBuilder(getBaseContext());
        
        notificationConfigBuilder.setAutoCancel(true);
        notificationConfigBuilder.setSmallIcon(R.mipmap.ic_launcher_round);
        notificationConfigBuilder.setTickerText("Hello notification");
        notificationConfigBuilder.setWhen(System.currentTimeMillis());
        notificationConfigBuilder.setContentTitle("Content title");
        notificationConfigBuilder.setContentText("content text");
        notificationConfigBuilder.setVibratePattern(new long[]{0, 1000, 1000, 500});

        Intent intent = new Intent(this, SecondActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        notificationConfigBuilder.triggerConfiguredNotification(notificationManager, pendingIntent);

    }

}
