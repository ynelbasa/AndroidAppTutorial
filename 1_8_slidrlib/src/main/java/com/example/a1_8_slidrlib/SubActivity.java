package com.example.a1_8_slidrlib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.r0adkll.slidr.Slidr;
import com.r0adkll.slidr.model.SlidrInterface;

public class SubActivity extends AppCompatActivity {
    private SlidrInterface slidr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        slidr = Slidr.attach(this);
    }

    public void lockSlide(View v){
        slidr.lock();
    }

    public void unlockSlide(View v){
        slidr.unlock();
    }
}