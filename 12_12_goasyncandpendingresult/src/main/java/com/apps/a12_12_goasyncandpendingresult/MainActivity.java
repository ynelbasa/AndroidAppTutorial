package com.apps.a12_12_goasyncandpendingresult;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    OrderedReceiver1 orderedReceiver1 = new OrderedReceiver1();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        IntentFilter filter = new IntentFilter("EXAMPLE_ACTION");
        filter.setPriority(1);
        registerReceiver(orderedReceiver1, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(orderedReceiver1);
    }
}