package com.example.a3_tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Declare variable for the game
    private Button[][] buttons = new Button[3][3];
    private boolean player1Turn = true;
    private int roundCount;

    private int player1Points;
    private int player2Points;

    // Declare UI elements
    private TextView textViewPlayer1;
    private TextView textViewPlayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get UI elements
        textViewPlayer1 = findViewById(R.id.textView_p1);
        textViewPlayer2 = findViewById(R.id.textView_p2);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String buttonId = "button_" + i + j;

                // Get resourceId dynamically (R.id.buttonId)
                int resourceId = getResources().getIdentifier(buttonId, "id", getPackageName());
                buttons[i][j] = findViewById(resourceId);
                buttons[i][j].setOnClickListener(this);
            }
        }

        // Handler for reset button
        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }

    @Override
    public void onClick(View v) {

        // Checks if button has already been played
        if (!((Button) v).getText().toString().isEmpty()) {
            return;
        }

        // Take turns
        if (player1Turn) {
            ((Button) v).setText("X");
        } else {
            ((Button) v).setText("O");
        }

        roundCount++;

        if (hasWinner()) {
            if (player1Turn) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (roundCount == 9) {
            draw();
        } else {
            player1Turn = !player1Turn;
        }
    }

    private boolean hasWinner() {
        String[][] board = new String[3][3];

        // Get all values from the board and save in array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = buttons[i][j].getText().toString();
            }
        }

        // Check horizontal results
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1])
                    && board[i][0].equals(board[i][2])
                    && !board[i][0].equals("")) {
                return true;
            }
        }

        // Check vertical result
        for (int i = 0; i < 3; i++) {
            if (board[0][i].equals(board[1][i])
                    && board[0][i].equals(board[2][i])
                    && !board[0][i].equals("")) {
                return true;
            }
        }

        // Check for diagonals (Top left to bottom right)
        if (board[0][0].equals(board[1][1])
                && board[0][0].equals(board[2][2])
                && !board[0][0].equals("")) {
            return true;
        }

        // Check for diagonal (Top right to bottom left)
        if (board[0][2].equals(board[1][1])
                && board[0][2].equals(board[2][0])
                && !board[0][2].equals("")) {
            return true;
        }
        
        return false;
    }

    private void player1Wins() {
    }

    private void player2Wins() {
    }

    private void draw() {
    }
}
