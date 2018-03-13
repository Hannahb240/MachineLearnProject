package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Two_GoodEgg extends AppCompatActivity {

    TextView eggInstructions;
    Button nextButton;
    int nextCount;

    int foundEggs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__good_egg);

        Bundle b = getIntent().getExtras();
        foundEggs = b.getInt("key");

        nextCount = 0;

        //Instuctions
        eggInstructions = (TextView) findViewById(R.id.eggInstructions);
        eggInstructions.setTextSize(20);
        eggInstructions.setText("Hooray! You found a perfect egg. Tap next below.");



        //Great! Now lets take a few more pictures to teach the pose to the computer.
        //Tap next below

        //Take 5 photos of you or your partner acting out picking up an egg from the gorund.

        //NEW ACTIVITY
        //Well done, you've collected an egg!
        //Go back and find the second egg.
        eggInstructions.setTextColor(Color.parseColor("#000000"));

        nextButton = (Button) findViewById(R.id.nextButton);
    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if(nextCount == 0) {
                eggInstructions.setText("How are you going to pick up the egg from the ground?");
                nextCount++;
            }
            else{
                Bundle b = new Bundle();
                b.putInt("key", foundEggs);
                Intent intent = new Intent(getApplicationContext(), Two_TakePhoto.class);
                intent.putExtras(b);
                startActivity(intent);
                this.finish();
            }

        }
    }

    public void goBack(View view){
        this.finish();
    }
}
