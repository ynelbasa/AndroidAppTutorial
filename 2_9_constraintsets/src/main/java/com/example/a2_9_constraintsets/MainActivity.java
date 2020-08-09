package com.example.a2_9_constraintsets;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.transition.ChangeBounds;
import android.transition.Transition;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.OvershootInterpolator;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout layout;
    // ConstraintSet hold constraints only not attributes
    private ConstraintSet constraintSetOld = new ConstraintSet();
    private ConstraintSet constraintSetNew = new ConstraintSet();
    private boolean altLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layout = findViewById(R.id.layout);

        // Set default layout
        constraintSetOld.clone(layout);
        constraintSetNew.clone(this, R.layout.activity_main_alt);
    }

    public void swapView(View v) {
        // Add custom transition
        Transition changeBounds = new ChangeBounds();
        changeBounds.setInterpolator(new OvershootInterpolator());

        // Apply transitions
        TransitionManager.beginDelayedTransition(layout, changeBounds);
        if (!altLayout) {
            // Apply alternative layout
            constraintSetNew.applyTo(layout);
            altLayout = true;
        } else {
            // Apply original layout
            constraintSetOld.applyTo(layout);
            altLayout = false;
        }
    }
}
