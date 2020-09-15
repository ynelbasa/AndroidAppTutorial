package com.apps.a8_3_handlerthread;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;

import static android.os.Process.THREAD_PRIORITY_BACKGROUND;
import static android.os.Process.setThreadPriority;

// Subclass of normal Java thread
public class ExampleHandlerThread extends HandlerThread {
    private static final String TAG = "ExampleHandlerThread";
    private Handler handler;
    public static final int EXAMPLE_TASK = 1;

    public ExampleHandlerThread() {
        // 1 is higher priority
        super(TAG, THREAD_PRIORITY_BACKGROUND);
        // setThreadPriority(THREAD_PRIORITY_BACKGROUND);
    }

    @SuppressLint("HandlerLeak")
    @Override
    protected void onLooperPrepared() {
        handler = new Handler() {
            @Override
            // Leak is not a problem with HandlerThread
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case EXAMPLE_TASK:
                        Log.d(TAG, "Example Task, arg1: " + msg.arg1 + ", obj: " + msg.obj);
                        for (int i = 0; i < 4; i++) {
                            Log.d(TAG, "handleMessage: " + i);
                            SystemClock.sleep(1000);
                        }
                        break;
                }
            }
        };
    }

    // Getter method
    public Handler getHandler() {
        return handler;
    }
}
