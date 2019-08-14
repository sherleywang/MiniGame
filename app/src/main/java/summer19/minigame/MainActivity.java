package summer19.minigame;

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
    TextView digitOne;
    TextView digitTwo;
    TextView digitThree;
    TextView digitFour;

    Button enterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        numberInput = findViewById(R.id.number_input);
        digitOne = findViewById(R.id.digit_field_one);
        digitTwo = findViewById(R.id.digit_field_two);
        digitThree = findViewById(R.id.digit_field_three);
        digitFour = findViewById(R.id.digit_field_four);

        enterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                runFunction();
            }
        });
    }

    private void runFunction() {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}
