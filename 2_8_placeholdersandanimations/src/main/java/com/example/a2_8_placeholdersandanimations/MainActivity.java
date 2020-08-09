package com.example.a2_8_placeholdersandanimations;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Placeholder;

import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    private Placeholder placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        layout = findViewById(R.id.layout);
        placeholder = findViewById(R.id.placeholder);
    }

    public void swapView(View v) {
        // Animation
        TransitionManager.beginDelayedTransition(layout);

        // Replace placeholder with selected imageView
        placeholder.setContentId(v.getId());
    }
}
