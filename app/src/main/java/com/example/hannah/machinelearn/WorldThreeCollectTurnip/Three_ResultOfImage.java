package com.example.hannah.machinelearn.WorldThreeCollectTurnip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;

public class Three_ResultOfImage extends AppCompatActivity {


    Button nextButton;
    int flagForNextSelected;
    TextView resultOfPhoto;

    ImageView turnipPic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__result_of_image);
        flagForNextSelected = 0;

        turnipPic = (ImageView) findViewById(R.id.turnipPic);
        turnipPic.setImageResource(R.drawable.turnip);

        resultOfPhoto = (TextView) findViewById(R.id.resultText);

        nextButton = (Button) findViewById(R.id.nextButton);
        resultOfPhoto.setText("Teach the computer how you collected the turnip!");

    }

    public void selectNext(View view) {
        Intent intent = new Intent(getApplicationContext(), Three_CollectTrainingData.class);
        startActivity(intent);
        this.finish();
    }
}
