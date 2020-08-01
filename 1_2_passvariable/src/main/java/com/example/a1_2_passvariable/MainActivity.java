package com.example.a1_2_passvariable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    // Declare UI Elements
    private Button button;

    // Declare constants
    public static final String EXTRA_TEXT = "com.example.a1_2_passvariable.EXTRA_TEXT";
    public static final String EXTRA_NUMBER = "com.example.a1_2_passvariable.EXTRA_NUMBER";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSubActivity();
            }
        });
    }

    public void openSubActivity(){
        EditText edittext1 = (EditText)findViewById(R.id.edittext1);
        String text = edittext1.getText().toString();

        EditText edittext2 = (EditText)findViewById(R.id.edittext2);
        int number = Integer.parseInt(edittext2.getText().toString());

        Intent intent = new Intent(this, SubActivity.class);
        intent.putExtra(EXTRA_TEXT, text);
        intent.putExtra(EXTRA_NUMBER, number);
        startActivity(intent);
    }
}
