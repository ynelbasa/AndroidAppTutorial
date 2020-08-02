package com.example.a1_7_intentanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

import maes.tech.intentanim.CustomIntent;

public class MainActivity extends AppCompatActivity {
    // Declare UI Elements
    private Button button;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        spinner = findViewById(R.id.spinner);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubActivity();
            }
        });
    }

    public void openSubActivity(){
        Intent intent = new Intent(this, SubActivity.class);
        startActivity(intent);
        CustomIntent.customType(this, spinner.getSelectedItem().toString());
    }
}
