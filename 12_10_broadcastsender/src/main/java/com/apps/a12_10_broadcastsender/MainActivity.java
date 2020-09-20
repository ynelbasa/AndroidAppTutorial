package com.apps.a12_10_broadcastsender;

import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.text_view);
    }

    public void sendBroadcast(View v) {
        Intent intent = new Intent("EXAMPLE_ACTION");
        intent.setPackage("com.apps.a12_10_broadcastpermission");
        Bundle extras = new Bundle();
        extras.putString("stringExtra", "Start");
        sendOrderedBroadcast(intent, Manifest.permission.WAKE_LOCK, new SenderReceiver(),
                null, 0, "Start", extras);
    }
}