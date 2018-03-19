package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Five_GuessThePose extends AppCompatActivity {

    ImageView progresBarImageView;
    int progressBarSize = 0;

    TextView tv;

    TextView texxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__guess_the_pose);

        progresBarImageView = (ImageView) findViewById(R.id.progressBar);
        progresBarImageView.setImageResource(R.drawable.progressbar2);
        progressBarSize = 3;
        tv =(TextView) findViewById(R.id.text);
        tv.setTextSize(20);
        tv.setTextColor(Color.parseColor("#000000"));

        int tester = knn.trainingData.rows();
        texxt = (TextView) findViewById(R.id.testingText);
        texxt.setText(Integer.toString(tester));
    }

    public void tryToGuessPose(View view){
        Intent intent = new Intent(getApplicationContext(), Five_TakePhotoToGuessPose.class);
        startActivity(intent);
    }

    public void goToTrainCrouch(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainCrouch.class);
        startActivity(intent);
        updateProgressBar();
    }

    public void goToTrainStand(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainStand.class);
        startActivity(intent);
        updateProgressBar();
    }

    private void updateProgressBar(){
        switch(progressBarSize) {
            case 3:
                progresBarImageView.setImageResource(R.drawable.progressbar3);
                progressBarSize++;
                break;
            case 4:
                progresBarImageView.setImageResource(R.drawable.progressbar4);
                progressBarSize++;
                break;
            case 5:
                progresBarImageView.setImageResource(R.drawable.progressbar5);
                progressBarSize++;
                break;
            case 6:
                progresBarImageView.setImageResource(R.drawable.progressbar6);
                progressBarSize++;
                break;
            case 7:
                progresBarImageView.setImageResource(R.drawable.progressbar7);
                progressBarSize++;
                break;
            case 8:
                progresBarImageView.setImageResource(R.drawable.progressbar8);
                progressBarSize++;
                break;
            case 9:
                progresBarImageView.setImageResource(R.drawable.progressbar9);
                progressBarSize++;
                break;
            case 10:
                progresBarImageView.setImageResource(R.drawable.progressbar10);
                break;
        }
    }
}