package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Two_ResultOfImage extends AppCompatActivity {

    Button nextButton;
    TextView resultOfPhoto;

    ImageView eggPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__result_of_image);

        eggPic = (ImageView) findViewById(R.id.eggPic);
        eggPic.setImageResource(R.drawable.egg);


        resultOfPhoto = (TextView) findViewById(R.id.resultText);
        nextButton = (Button) findViewById(R.id.nextButton);
        resultOfPhoto.setText("Now teach the computer how you collected the egg!");
    }

    public void selectNext(View view) {
        Intent intent = new Intent(getApplicationContext(), Two_CollectTrainingData.class);
        startActivity(intent);
        this.finish();
    }


}
