package summer19.minigame;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText numberInput;

    TextView numberGuide;

    TextView[] tvArray = new TextView[4];

    Button enterButton;

    NumberGame numGame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        numGame = new NumberGame();

        numberInput = findViewById(R.id.number_input);

        tvArray[0] = findViewById(R.id.digit_field_one);
        tvArray[1] = findViewById(R.id.digit_field_two);
        tvArray[2] = findViewById(R.id.digit_field_three);
        tvArray[3] = findViewById(R.id.digit_field_four);

        enterButton = findViewById(R.id.button_enter);

        numberGuide = findViewById(R.id.number_guide);

        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                commenceGame();
            }
        });
    }

    private void commenceGame() {
        if (!numGame.getGuess(numberInput)) {
            setGuideText("Please enter a four digit number!", Color.RED);
        } else {
            int win = numGame.checkWin();

            if (win == 0) {
                clearGame();
                Intent i = new Intent(this, WinScreen.class);
                startActivity(i);
                numGame = new NumberGame();
            } else {
                if (win == 1)
                    setGuideText("Too low :((((((", Color.BLUE);
                else
                    setGuideText("Too high :((((((", Color.RED);
                numGame.verifyGuess();
                setDisplayNumbers();
            }
        }
    }

    private void clearGame() {
        setGuideText("", Color.BLACK);
        for (TextView tv : tvArray) {
            tv.setText("");
            tv.setBackgroundColor(Color.WHITE);
        }
    }

    private void setDisplayNumbers() {
        boolean[] display = numGame.getDisplay();
        for (int i = 0; i < display.length; i++) {
            String digit = "" + numGame.getGuessStr().charAt(i);

            tvArray[i].setText(digit);

            int color = display[i] ? Color.GREEN : Color.RED;

            tvArray[i].setBackgroundColor(color);
            tvArray[i].setBackgroundTintMode(PorterDuff.Mode.OVERLAY);
        }
    }

    private void setGuideText(String message, int color) {
        numberGuide.setText(message);
        numberGuide.setTextColor(color);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
