package com.example.hannah.machinelearn.WorldTwoCollectEgg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Two_GoodEgg extends AppCompatActivity {

    TextView eggInstructions;
    Button nextButton;

    int nextCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__good_egg);

        nextCount = 0;

        eggInstructions = (TextView) findViewById(R.id.eggInstructions);
        Utils.setInstructions(eggInstructions, "Hooray! You found a perfect egg. Tap next below.");

        nextButton = (Button) findViewById(R.id.nextButton);
    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            onNext();
        }
    }

    public void onNext() {

        if(nextCount == 0) {
            eggInstructions.setText("How are you going to pick up the egg from the ground?");
            nextCount++;
        }
        else{
            Intent intent = new Intent(getApplicationContext(), Two_TakePhoto.class);
            startActivity(intent);
            this.finish();
        }

    }

    public void goBack(View view){
        this.finish();
    }
}
