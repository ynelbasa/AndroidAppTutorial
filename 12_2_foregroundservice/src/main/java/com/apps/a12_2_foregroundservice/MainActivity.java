package com.apps.a12_2_foregroundservice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_INPUT = "EXTRA_INPUT";
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextInput = findViewById(R.id.edit_text_input);
    }

    public void startService(View v) {
        String input = editTextInput.getText().toString();

        // Prepare data to pass to service
        Intent serviceIntent = new Intent(this, ExampleService.class);
        serviceIntent.putExtra(EXTRA_INPUT, input);

        // Works while app is open
        // startService(serviceIntent);

        // Starts service while app runs in the background
        // Checks compatibility, convenient method
        ContextCompat.startForegroundService(this, serviceIntent);
    }

    public void stopService(View v) {
        Intent serviceIntent = new Intent(this, ExampleService.class);
        stopService(serviceIntent);
    }
}
