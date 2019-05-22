package com.example.hannah.machinelearn.GuessThePose;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.hannah.machinelearn.Knn;
import com.example.hannah.machinelearn.R;

public class SeeAccuracy extends AppCompatActivity {

    TextView correctAnswers;
    TextView incorrectAnswers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_accuracy);

        correctAnswers = (TextView) findViewById(R.id.correctAnswers);
        correctAnswers.setTextSize(20);
        correctAnswers.setTextColor(Color.parseColor("#000000"));

        incorrectAnswers = (TextView) findViewById(R.id.incorrectAnswers);
        incorrectAnswers.setTextSize(20);
        incorrectAnswers.setTextColor(Color.parseColor("#000000"));

        correctAnswers.setText("Number of times guessed correctly: " + Knn.numberGuessedCorrectly);
        incorrectAnswers.setText("Number of times guessed incorrectly: " + Knn.numberGuessedIncorrectly);
    }



    public void onBack(View view){
        this.finish();
    }
}
