package com.example.hannah.machinelearn.GuessThePose;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;

public class Five_GuessThePose extends AppCompatActivity {

    TextView instructionsTextView;
    Button testButton;
    Button testAccuracyButton;
    Button seeAccuracyButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__guess_the_pose);

        instructionsTextView =(TextView) findViewById(R.id.text);
        instructionsTextView.setTextSize(20);
        instructionsTextView.setTextColor(Color.parseColor("#000000"));

        //Set to visible to view statistics about the data
        testButton = (Button) findViewById(R.id.testButton);
        testAccuracyButton = (Button) findViewById(R.id.testAccuracyButton);
        seeAccuracyButton = (Button) findViewById(R.id.seeAccuracyButton);

        testButton.setVisibility(View.VISIBLE);
        testAccuracyButton.setVisibility(View.VISIBLE);

    }

    public void seeAccuracy(View view) {
        Intent intent = new Intent(getApplicationContext(), SeeAccuracy.class);
        startActivity(intent);
    }

    public void tryToGuessPose(View view){
        Intent intent = new Intent(getApplicationContext(), Five_TakePhotoToGuessPose.class);
        startActivity(intent);
    }

    public void goToTrainCrouch(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainCrouch.class);
        startActivity(intent);
    }

    public void goToTrainStand(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainStand.class);
        startActivity(intent);
    }

    public void testAccuracy(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_Test_Accuracy.class);
        startActivity(intent);
    }

    public void goToAddTrainingData(View view){
        Intent intent  = new Intent(getApplicationContext(), Five_Add_Data.class);
        startActivity(intent);
    }

}