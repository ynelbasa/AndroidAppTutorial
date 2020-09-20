package com.apps.a12_8_explicitbroadcasts;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ExampleBroadcastReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "EBR triggered", Toast.LENGTH_SHORT).show();
    }
}