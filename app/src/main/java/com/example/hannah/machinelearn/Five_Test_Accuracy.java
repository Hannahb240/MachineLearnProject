package com.example.hannah.machinelearn;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Five_Test_Accuracy extends AppCompatActivity {

    TextView numberOfSamples;
    TextView reachingAccuracy;
    TextView crouchingAccuracy;
    TextView totalAccuracy;
    float result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__test__accuracy);

        result = knn.testAccuracyOfModel(knn.trainingData, knn.trainingLabels);

        //Number of training samples
        numberOfSamples = (TextView) findViewById(R.id.numberOfSamples);
        numberOfSamples.setText(Integer.toString(knn.trainingData.rows()));
        numberOfSamples.setTextColor(Color.parseColor("#000000"));

        //Accuracy of reaching
        reachingAccuracy = (TextView) findViewById(R.id.accuracyOfReaching);
        reachingAccuracy.setText(Float.toString(knn.accuracyOfReaching));
        reachingAccuracy.setTextColor(Color.parseColor("#000000"));

        //Accuracy of crouching
        crouchingAccuracy = (TextView) findViewById(R.id.accuracyOfCrouching);
        crouchingAccuracy.setText(Float.toString(knn.accuracyOfCrouching));
        crouchingAccuracy.setTextColor(Color.parseColor("#000000"));

        //Total accuracy
        totalAccuracy = (TextView) findViewById(R.id.totalAccuracy);
        totalAccuracy.setText(Float.toString(result));
        totalAccuracy.setTextColor(Color.parseColor("#000000"));
    }

    public void goBack(View view){
        this.finish();
    }
}
