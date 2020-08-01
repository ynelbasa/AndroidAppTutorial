package com.example.a1_3_senddata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SubActivity extends AppCompatActivity {

    // Declare constants
    public static final String EXTRA_RESULT = "com.example.a1_3_senddata.EXTRA_RESULT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        setTitle("Sub Activity");

        Intent intent = getIntent();
        final int number1 = intent.getIntExtra(MainActivity.EXTRA_NUMBER1, 0);
        final int number2 = intent.getIntExtra(MainActivity.EXTRA_NUMBER2,0);

        TextView textViewNumbers = findViewById(R.id.numbers);
        textViewNumbers.setText("Numbers: " + number1 + ", " + number2);

        Button buttonAdd = findViewById(R.id.button_add);
        Button buttonSubtract = findViewById(R.id.button_subtract);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = number1 + number2;

                Intent intentResult = new Intent();
                intentResult.putExtra(EXTRA_RESULT, number1 + " + " + number2 + " = " + result);

                setResult(RESULT_OK, intentResult);
                finish();
            }
        });

        buttonSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = number1 - number2;

                Intent intentResult = new Intent();
                intentResult.putExtra(EXTRA_RESULT, number1 + " - " + number2 + " = " + result);

                setResult(RESULT_OK, intentResult);
                finish();
            }
        });
    }
}