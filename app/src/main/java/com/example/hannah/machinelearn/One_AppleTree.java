package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class One_AppleTree extends AppCompatActivity {

    Button nextButton;
    TextView appleTreeInstructions;
    boolean clickedNextOnceAlreadyFlag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_apple_tree);
        clickedNextOnceAlreadyFlag = false;


        //Instuctions
        appleTreeInstructions = (TextView) findViewById(R.id.appleInstructions);
        appleTreeInstructions.setText("The fruit is quite near to the ground, how are you going to pick it?");
        appleTreeInstructions.setTextSize(30);
        appleTreeInstructions.setTextColor(Color.parseColor("#000000"));

        //Next button
        nextButton = (Button) findViewById(R.id.nextButton);

    }

    public void nextSection(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if (buttonText.equals("Next")) {
            if (!clickedNextOnceAlreadyFlag) {
                appleTreeInstructions.setText("Act this out and take a photo!");
                clickedNextOnceAlreadyFlag = true;
            } else {
                Intent intent = new Intent(getApplicationContext(), One_TakePhoto.class);
                Bundle b = new Bundle();
                b.putInt("key", 3); //Your id
                intent.putExtras(b); //Put your id to your next Intent
                startActivity(intent);
                this.finish();
            }

        }
    }
}