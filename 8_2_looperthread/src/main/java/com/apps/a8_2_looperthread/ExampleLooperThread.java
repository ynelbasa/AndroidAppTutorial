package com.apps.a8_2_looperthread;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* Loops through the message queue with the current timestamp then send to the handler
that also added it, then execute on current handler's thread */
public class ExampleLooperThread extends Thread {
    private static final String TAG = "ExampleLooperThread";
    public Looper looper;
    public Handler handler;

    @Override
    public void run() {
        // Handler works only on thread that has a looper
        // Adds a looper to current thread and creates a message queue
        Looper.prepare();

        // Initial with looper of the current thread
        looper = Looper.myLooper();
        handler = new ExampleHandler();

        // Starts the infinite loop
        Looper.loop();
        Log.d(TAG, "End of run()");
    }
}
