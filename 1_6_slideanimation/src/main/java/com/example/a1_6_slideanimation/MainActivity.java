package com.example.a1_6_slideanimation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    // Declare UI Elements
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.buttonSub1);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openSubActivity1();
            }
        });
    }

    public void openSubActivity1() {
        Intent intent = new Intent(this, SubActivity1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }
}
