package com.apps.a8_3_handlerthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;

import static com.apps.a8_3_handlerthread.ExampleHandlerThread.EXAMPLE_TASK;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ExampleHandlerThread handlerThread = new ExampleHandlerThread();
    // private Handler threadHandler = new Handler();

    // Hold runnable for removeMessage function
    private ExampleRunnable1 runnable1 = new ExampleRunnable1();
    private Object token = new Object();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        handlerThread.start();
    }

    public void doWork(View view) {
        Message msg = Message.obtain(handlerThread.getHandler());

        msg.what = EXAMPLE_TASK;
        msg.arg1 = 23;
        msg.obj = "Obj String";

        msg.sendToTarget();
        // Other ways to messages than handler().sendMessage()
        //handlerThread.getHandler().sendMessage(msg);
        //handlerThread.getHandler().sendEmptyMessage(1);

        //
        handlerThread.getHandler().postAtTime(runnable1, token, SystemClock.uptimeMillis());
        handlerThread.getHandler().post(runnable1);
        //handlerThread.getHandler().post(new ExampleRunnable1());
        //handlerThread.getHandler().postAtFrontOfQueue(new ExampleRunnable2());

        // Sample run #1
        /*threadHandler.postDelayed(new ExampleRunnable1(), 2000);
        threadHandler.post(new ExampleRunnable2());*/

        // Sample run #2
        /*threadHandler.post(new ExampleRunnable1());
        threadHandler.post(new ExampleRunnable1());
        threadHandler.postAtFrontOfQueue(new ExampleRunnable2());*/
    }

    public void removeMessages(View view) {
        // handlerThread.getHandler().removeMessages();
        // Removes all runnable and messages, null
        // handlerThread.getHandler().removeCallbacksAndMessages(null);
        handlerThread.getHandler().removeCallbacks(runnable1, token);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Handle rotation of device, etc.
        handlerThread.quit();
    }

    // Declare runnable as static to avoid memory leaks
    static class ExampleRunnable1 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable1: " + i);
                SystemClock.sleep(1000);
            }
        }
    }

    static class ExampleRunnable2 implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 4; i++) {
                Log.d(TAG, "Runnable2: " + i);
                SystemClock.sleep(1000);
            }
        }
    }
}
