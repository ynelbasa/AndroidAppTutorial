package com.apps.a12_11_broadcastsender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private ExampleBroadcastReceiver exampleBroadcastReceiver2 = new ExampleBroadcastReceiver();
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("EXAMPLE_ACTION");
        localBroadcastManager.sendBroadcast(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        IntentFilter filter = new IntentFilter("EXAMPLE_ACTION");
        localBroadcastManager.registerReceiver(exampleBroadcastReceiver2, filter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        localBroadcastManager.unregisterReceiver(exampleBroadcastReceiver2);
    }
}