package com.example.a7_2_soundpool;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private SoundPool soundPool;
    // Sound file Ids
    private int sound1, sound2, sound3, sound4, sound5, sound6, sound7;

    // For testing pause functionality
    private int soundStreamId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Compatibility for v21 and higher
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setMaxStreams(7)
                    .setAudioAttributes(audioAttributes)
                    .build();
        } else {
            // old class for sound pool, deprecated since v21
            soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        }

        sound1 = soundPool.load(this, R.raw.a, 1);
        sound2 = soundPool.load(this, R.raw.b, 1);
        sound3 = soundPool.load(this, R.raw.c, 1);
        sound4 = soundPool.load(this, R.raw.d, 1);
        sound5 = soundPool.load(this, R.raw.e, 1);
        sound6 = soundPool.load(this, R.raw.f, 1);
        sound7 = soundPool.load(this, R.raw.g, 1);
    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.button_sound1:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                // soundPool.pause(soundStreamId);
                // soundPool.autoPause();
                break;
            case R.id.button_sound2:
                soundPool.play(sound2, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound3:
                soundStreamId = soundPool.play(sound3, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound4:
                soundPool.play(sound4, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound5:
                soundPool.play(sound5, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound6:
                soundPool.play(sound6, 1, 1, 0, 0, 1);
                break;
            case R.id.button_sound7:
                soundPool.play(sound7, 1, 1, 0, 0, 1);
                break;
        }
    }

    // To release sound pool and offload resources
    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    }
}