package com.example.a1_3_senddata;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare constants
    public static final String EXTRA_NUMBER1 = "com.example.a1_3_sendata.number1";
    public static final String EXTRA_NUMBER2 = "com.example.a1_3_sendata.number2";
    public static final int REQUEST_CALCULATE = 1;

    // Declare UI Elements
    private TextView textViewOperation;
    private TextView textViewResult;
    private EditText editTextNumber1;
    private EditText editTextNumber2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewResult = findViewById(R.id.text_view_result);
        editTextNumber1 = findViewById(R.id.edit_text_number1);
        editTextNumber2 = findViewById(R.id.edit_text_number2);

        Button openSubActivity = findViewById(R.id.button);

        openSubActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sNumber1 = editTextNumber1.getText().toString();
                String sNumber2 = editTextNumber2.getText().toString();

                if(sNumber1.isEmpty() || sNumber2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please insert numbers", Toast.LENGTH_SHORT).show();
                }
                else {
                    int number1 = Integer.parseInt(sNumber1);
                    int number2 = Integer.parseInt(sNumber2);

                    Intent intent = new Intent(MainActivity.this, SubActivity.class);
                    intent.putExtra(EXTRA_NUMBER1, number1);
                    intent.putExtra(EXTRA_NUMBER2, number2);

                    startActivityForResult(intent, REQUEST_CALCULATE);
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CALCULATE){
            if(resultCode == RESULT_OK){
                String result = data.getStringExtra(SubActivity.EXTRA_RESULT);
                textViewResult.setText(result);
            }
            else if(resultCode == RESULT_CANCELED){
                textViewResult.setText("Nothing Selected");
            }
        }
    }
}
