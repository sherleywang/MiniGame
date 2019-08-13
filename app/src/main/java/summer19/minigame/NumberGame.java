package summer19.minigame;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

public class NumberGame extends AppCompatActivity {

    // instance variables
    private int secret;
    private int guess;
    private boolean[] display;

    // constructor with length as number of digits in the secret number
    public NumberGame () {
        Random rand = new Random();
        secret = rand.nextInt(9000) + 1000;
        display = new boolean[4];
    }

    public void round() {
        TextView input = findViewById(R.id.number_input);
        guess = Integer.parseInt(input.getText().toString());
        verifyGuess();
    }

    private void verifyGuess() {
        String secretString = "" + secret;
        String guessString = "" + guess;
        for (int i = 0; i < 4; i++) {
            display[i] = secretString.charAt(i) == guessString.charAt(i);
        }
    }

    public boolean checkWin() {
        for (boolean bool : display) {
            if (!bool)
                return false;
        }
        return true;
    }

    public boolean[] getDisplay() {
        return display;
    }

}
