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

    public void getGuess(TextView tv) {
        guess = Integer.valueOf(tv.getText().toString());
    }

    public void verifyGuess() {
        String secretString = "" + secret;
        String guessString = "" + guess;
        for (int i = 0; i < 4; i++) {
            display[i] = secretString.charAt(i) == guessString.charAt(i);
        }
    }

    // return 0 for correct, 1 for too low, 2 for too high
    public int checkWin() {
        if (guess == secret)
            return 0;
        else if (guess < secret)
            return 1;
        else
            return 2;
    }

    public boolean[] getDisplay() {
        return display;
    }

}
