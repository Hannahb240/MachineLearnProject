package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Three_GoodTurnipOne extends AppCompatActivity {

    TextView turnipInstructions;
    Button nextButton;
    boolean clickedNextOnceAlreadyFlag;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__good_turnip_one);
        clickedNextOnceAlreadyFlag = false;

        //Instuctions
        turnipInstructions = (TextView) findViewById(R.id.lemonInstructions);
        turnipInstructions.setText("Looks like you'll need to reach up to get the fruit from the tree.");
        turnipInstructions.setTextSize(30);

        nextButton = (Button) findViewById(R.id.nextButton);
    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if(!clickedNextOnceAlreadyFlag) {
                turnipInstructions.setText("Act this out and take a photo!");
                clickedNextOnceAlreadyFlag = true;
            }
            else{

                turnipInstructions.setText("clicked once");
                Intent intent = new Intent(getApplicationContext(), Three_TakePhoto.class);
                startActivity(intent);
                this.finish();
            }

        }
    }

    public void goBack(View view){
        this.finish();
    }
}
