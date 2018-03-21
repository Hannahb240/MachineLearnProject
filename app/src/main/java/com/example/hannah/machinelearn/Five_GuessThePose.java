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
    TextView texxt2;

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
        texxt2 = (TextView) findViewById(R.id.testingText2);

//        texxt.setText(Integer.toString(tester));

//        float result = knn.testAccuracyOfModel(knn.trainingData, knn.trainingLabels);
//        texxt2.setText(Float.toString(result));
    }

    public void tryToGuessPose(View view){
        Intent intent = new Intent(getApplicationContext(), Five_TakePhotoToGuessPose.class);
        startActivity(intent);
    }

    public void goToTrainCrouch(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainCrouch.class);
        startActivity(intent);
        //updateProgressBar();
    }

    public void goToTrainStand(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_TrainStand.class);
        startActivity(intent);
        //updateProgressBar();
    }

//    private void updateProgressBar1(){
//        switch(progressBarSize) {
//            case 3:
//                progresBarImageView.setImageResource(R.drawable.progressbar3);
//                progressBarSize++;
//                break;
//            case 4:
//                progresBarImageView.setImageResource(R.drawable.progressbar4);
//                progressBarSize++;
//                break;
//            case 5:
//                progresBarImageView.setImageResource(R.drawable.progressbar5);
//                progressBarSize++;
//                break;
//            case 6:
//                progresBarImageView.setImageResource(R.drawable.progressbar6);
//                progressBarSize++;
//                break;
//            case 7:
//                progresBarImageView.setImageResource(R.drawable.progressbar7);
//                progressBarSize++;
//                break;
//            case 8:
//                progresBarImageView.setImageResource(R.drawable.progressbar8);
//                progressBarSize++;
//                break;
//            case 9:
//                progresBarImageView.setImageResource(R.drawable.progressbar9);
//                progressBarSize++;
//                break;
//            case 10:
//                progresBarImageView.setImageResource(R.drawable.progressbar10);
//                break;
//        }
//    }

    public void testAccuracy(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_Test_Accuracy.class);
        startActivity(intent);
    }

    public void goToAddTrainingData(View view){
        Intent intent  = new Intent(getApplicationContext(), Five_Add_Data.class);
        startActivity(intent);
    }

    public void updateProgressBar(View view){
        float result = knn.testAccuracyOfModel(knn.trainingData, knn.trainingLabels);
        int floatToInt = Math.round(result * 100);
        texxt.setText(Float.toString(floatToInt)+ "%");

        if(floatToInt <= 30) {
            progresBarImageView.setImageResource(R.drawable.progressbar3);
        }
        else if(floatToInt <= 40){
            progresBarImageView.setImageResource(R.drawable.progressbar4);
        }
        else if(floatToInt <= 50){
            progresBarImageView.setImageResource(R.drawable.progressbar5);
        }
        else if(floatToInt <= 60){
            progresBarImageView.setImageResource(R.drawable.progressbar6);
        }
        else if(floatToInt <= 70){
            progresBarImageView.setImageResource(R.drawable.progressbar7);
        }
        else if(floatToInt <= 80){
            progresBarImageView.setImageResource(R.drawable.progressbar8);
        }
        else if(floatToInt <= 90){
            progresBarImageView.setImageResource(R.drawable.progressbar9);
        }
        else if(floatToInt <= 100){
            progresBarImageView.setImageResource(R.drawable.progressbar10);
        }
    }
}