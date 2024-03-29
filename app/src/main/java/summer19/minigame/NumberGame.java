package summer19.minigame;

import android.widget.TextView;

import java.util.Random;

public class NumberGame {

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

    public boolean getGuess(TextView tv) {
        if (tv.getText().toString().length() > 0) {
            guess = Integer.valueOf(tv.getText().toString());
            return guess > 999;
        }
        return false;
    }

    public String getGuessStr() {
        return "" + guess;
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
