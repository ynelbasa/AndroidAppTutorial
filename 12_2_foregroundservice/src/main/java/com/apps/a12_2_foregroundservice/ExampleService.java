package com.apps.a12_2_foregroundservice;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;

import static com.apps.a12_2_foregroundservice.App.CHANNEL_ID;

public class ExampleService extends Service {
    @Override
    // Called only once during creation
    public void onCreate() {
        super.onCreate();
    }

    @Override
    // Called multiple times when service is started
    // Runs on UI thread
    public int onStartCommand(Intent intent, int flags, int startId) {
        // Get values passed from intent
        String input = intent.getStringExtra(MainActivity.EXTRA_INPUT);

        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,
                0, notificationIntent, 0);

        // Create notification
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setContentTitle("Example Service")
                .setContentText(input)
                .setSmallIcon(R.drawable.ic_android)
                .setContentIntent(pendingIntent)
                .build();

        startForeground(1, notification);

        // Another way to stop service after doing all heavy work in a background thread
        // Stops all instance of the service
        // stopSelf();

        // Service will begin but will not be restarted again
        return START_NOT_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    // Mandatory but only needed for bounce services
    public IBinder onBind(Intent intent) {
        return null;
    }
}