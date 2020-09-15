package com.apps.a8_2_looperthread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.view.View;

import static com.apps.a8_2_looperthread.ExampleHandler.TASK_A;
import static com.apps.a8_2_looperthread.ExampleHandler.TASK_B;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ExampleLooperThread looperThread = new ExampleLooperThread();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startThread(View view) {
        looperThread.start();
    }

    public void stopThread(View view) {
        looperThread.looper.quit();
        // Returns message
        // looperThread.looper.quitSafely();
    }

    public void taskA(View view) {
        // Another way to send a message instead of post below
        Message msg = Message.obtain();
        msg.what = TASK_A;
        looperThread.handler.sendMessage(msg);

        /* Runnable has possible memory leak, it has reference to the activity
             which cannot be garbage collected (implicit reference)
        Handler threadHandler = new Handler(looperThread.looper);
        threadHandler.post(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 5; i++) {
                    Log.d(TAG, "run: " + i);
                    // Similar to Thread.Sleep without the need for try catch
                    SystemClock.sleep(1000);
                }
            }
        });*/
    }

    public void taskB(View view) {
        Message msg = Message.obtain();
        msg.what = TASK_B;
        looperThread.handler.sendMessage(msg);
    }
}
