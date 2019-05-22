package com.example.hannah.machinelearn.GuessThePose;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hannah.machinelearn.Knn;
import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Five_Add_Data extends AppCompatActivity {

    TextView instructionsText;
    TextView numberSamples;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__add__data);

        instructionsText = (TextView) findViewById(R.id.textbox);
        numberSamples = (TextView) findViewById(R.id.numberOfSamples);

        Utils.setInstructions(instructionsText, "Which category would you like to add more trainng data to? Tap below");
        Utils.setInstructions(numberSamples, "Number of training photos: " + Integer.toString(Knn.trainingData.rows()));
    }

    public void goToTrainCrouch(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainCrouch.class);
        startActivity(intent);
        this.finish();
    }

    public void goToTrainStand(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainStand.class);
        startActivity(intent);
        this.finish();
    }
}
