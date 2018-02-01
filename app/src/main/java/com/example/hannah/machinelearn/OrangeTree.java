package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrangeTree extends AppCompatActivity {

    Button nextButton;
    TextView orangeTreeInstructions;
    boolean clickedNextOnceAlreadyFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orange_tree);

        clickedNextOnceAlreadyFlag = false;

        //Instuctions
        orangeTreeInstructions = (TextView) findViewById(R.id.orangeInstructions);
        orangeTreeInstructions.setText("Oh no, the tree is too tall! Looks like you're going to have to jump to reach the fruit.");
        orangeTreeInstructions.setTextSize(30);
        orangeTreeInstructions.setTextColor(Color.parseColor("#000000"));

        //Next button
        nextButton = (Button) findViewById(R.id.nextButton);

    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if (!clickedNextOnceAlreadyFlag) {
                orangeTreeInstructions.setText("Act this out and take a photo!");
                clickedNextOnceAlreadyFlag = true;
            } else {
                Intent intent = new Intent(getApplicationContext(), TakePhoto.class);
                Bundle b = new Bundle();
                b.putInt("key", 2); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
            }

        }
    }
}
