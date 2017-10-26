package com.example.alex.tictactoe;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean player = true;
    private String winner;
    private String[][] buttonText = new String[3][3];
    private Button[][] buttons = new Button[3][3];

    //final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.blip);

    @Override
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.button00:
                if (buttonText[0][0].equals("")) {
                    buttonText[0][0] = player?"X":"O";
                    clickButton(buttons[0][0]);
                }
                break;

            case R.id.button01:
                if (buttonText[0][1].equals("")) {
                    buttonText[0][1] = player?"X":"O";
                    clickButton(buttons[0][1]);
                }
                break;

            case R.id.button02:
                if (buttonText[0][2].equals("")) {
                    buttonText[0][2] = player?"X":"O";
                    clickButton(buttons[0][2]);
                }
                break;

            case R.id.button10:
                if (buttonText[1][0].equals("")) {
                    buttonText[1][0] = player?"X":"O";
                    clickButton(buttons[1][0]);
                }
                break;

            case R.id.button11:
                if (buttonText[1][1].equals("")) {
                    buttonText[1][1] = player?"X":"O";
                    clickButton(buttons[1][1]);
                }
                break;

            case R.id.button12:
                if (buttonText[1][2].equals("")) {
                    buttonText[1][2] = player?"X":"O";
                    clickButton(buttons[1][2]);
                }
                break;

            case R.id.button20:
                if (buttonText[2][0].equals("")) {
                    buttonText[2][0] = player?"X":"O";
                    clickButton(buttons[2][0]);
                }
                break;

            case R.id.button21:
                if (buttonText[2][1].equals("")) {
                    buttonText[2][1] = player?"X":"O";
                    clickButton(buttons[2][1]);
                }
                break;

            case R.id.button22:
                if (buttonText[2][2].equals("")) {
                    buttonText[2][2] = player?"X":"O";
                    clickButton(buttons[2][2]);
                }
                break;

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        buttonText[0][0] = "";
        buttonText[0][1] = "";
        buttonText[0][2] = "";
        buttonText[1][0] = "";
        buttonText[1][1] = "";
        buttonText[1][2] = "";
        buttonText[2][0] = "";
        buttonText[2][1] = "";
        buttonText[2][2] = "";


        buttons[0][0] = (Button) findViewById(R.id.button00);
        buttons[0][0].setOnClickListener( new View.OnClickListener(){

            public void onClick(View v) {
                if (buttonText[0][0].equals("")) {
                    buttonText[0][0] = player ? "X" : "O";
                    clickButton(buttons[0][0]);
                }
                mp.start();
            }
        });

        buttons[0][1] = (Button) findViewById(R.id.button01);
        buttons[0][1].setOnClickListener(this);

        buttons[0][2] = (Button) findViewById(R.id.button02);
        buttons[0][2].setOnClickListener(this);

        buttons[1][0] = (Button) findViewById(R.id.button10);
        buttons[1][0].setOnClickListener(this);

        buttons[1][1] = (Button) findViewById(R.id.button11);
        buttons[1][1].setOnClickListener(this);

        buttons[1][2] = (Button) findViewById(R.id.button12);
        buttons[1][2].setOnClickListener(this);

        buttons[2][0] = (Button) findViewById(R.id.button20);
        buttons[2][0].setOnClickListener(this);

        buttons[2][1] = (Button) findViewById(R.id.button21);
        buttons[2][1].setOnClickListener(this);

        buttons[2][2] = (Button) findViewById(R.id.button22);
        buttons[2][2].setOnClickListener(this);

    }

    private void clickButton(Button button) {
        if (player) {
            button.setText("X");
            //button.setTextColor(0xff000);
            button.setTextColor(Color.parseColor("#ff0000"));
        }
        else {
            button.setText("O");
            button.setTextColor(Color.parseColor("#0000ff"));
        }

        if (isGameWon()) {
            Toast.makeText(getApplicationContext(), "Winner is " + winner + "!",
                    Toast.LENGTH_SHORT).show();

        }
        if (isCatsGame()) {
            Toast.makeText(getApplicationContext(), "Cat's Game.",
                    Toast.LENGTH_SHORT).show();
        }

        player = !player;
    }

    private boolean isGameWon() {

        if (!buttonText[0][0].equals("") &&
                buttonText[0][0].equals(buttonText[0][1]) &&
                buttonText[0][0].equals(buttonText[0][2])) {
            winner = buttonText[0][0];
            return true;
        }
        if (!buttonText[1][0].equals("") &&
                buttonText[1][0].equals(buttonText[1][1]) &&
                buttonText[1][0].equals(buttonText[1][2])) {
            winner = buttonText[1][0];
            return true;
        }
        if (!buttonText[2][0].equals("") &&
                buttonText[2][0].equals(buttonText[2][1]) &&
                buttonText[2][0].equals(buttonText[2][2])) {
            winner = buttonText[2][0];
            return true;
        }

        if (!buttonText[0][0].equals("") &&
                buttonText[0][0].equals(buttonText[1][0]) &&
                buttonText[0][0].equals(buttonText[2][0])) {
            winner = buttonText[0][0];
            return true;
        }
        if (!buttonText[0][1].equals("") &&
                buttonText[0][1].equals(buttonText[1][1]) &&
                buttonText[0][1].equals(buttonText[2][1])) {
            winner = buttonText[0][1];
            return true;
        }
        if (!buttonText[0][2].equals("") &&
                buttonText[0][2].equals(buttonText[1][2]) &&
                buttonText[0][2].equals(buttonText[2][2])) {
            winner = buttonText[0][2];
            return true;
        }

        if (!buttonText[1][1].equals("") &&
                buttonText[1][1].equals(buttonText[0][0]) &&
                buttonText[1][1].equals(buttonText[2][2])) {
            winner = buttonText[1][1];
            return true;
        }
        if (!buttonText[1][1].equals("") &&
                buttonText[1][1].equals(buttonText[2][0]) &&
                buttonText[1][1].equals(buttonText[0][2])) {
            winner = buttonText[1][1];
            return true;
        }


        return false;
    }

    private boolean isCatsGame() {
        if (!buttonText[0][0].equals("") &&
            !buttonText[0][1].equals("") &&
            !buttonText[0][2].equals("") &&
            !buttonText[1][0].equals("") &&
            !buttonText[1][1].equals("") &&
            !buttonText[1][2].equals("") &&
            !buttonText[2][0].equals("") &&
            !buttonText[2][1].equals("") &&
            !buttonText[2][2].equals("") &&
            !isGameWon()) {
            return true;
        }
        return false;
    }
}
