package com.apps.a8_2_looperthread;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

/* Responsible on tasks in the message queue,
 puts the work into the queue and also executes it */
public class ExampleHandler extends Handler {
    private static final String TAG = "ExampleHandler";
    public static final int TASK_A = 1;
    public static final int TASK_B = 2;

    @Override
    public void handleMessage(Message msg) {
        switch (msg.what) {
            case TASK_A:
                Log.d(TAG, "Task A executed");
                break;
            case TASK_B:
                Log.d(TAG, "Task B executed");
                break;
        }
    }
}