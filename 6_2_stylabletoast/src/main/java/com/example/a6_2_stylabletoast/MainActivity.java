package com.example.a6_2_stylabletoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.muddzdev.styleabletoast.StyleableToast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToast(View v) {
        StyleableToast.makeText(this, "Toast using StylableToast Lib", R.style.exampleToast).show();
    }
}
