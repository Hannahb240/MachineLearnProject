package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One_ExplainTrainingData extends AppCompatActivity {

    TextView takePhotosInstructions;
    TextView takePhotosInstructions2;

    Bitmap imageToDisplay;
    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one__explain_training_data);

        Intent intent = getIntent();
        imageToDisplay = (Bitmap) intent.getParcelableExtra("BitmapImage");

        myImageView = (ImageView) findViewById(R.id.myImgView);
        myImageView.setImageBitmap(imageToDisplay);

        takePhotosInstructions = (TextView) findViewById(R.id.text1);
        takePhotosInstructions.setTextColor(Color.parseColor("#000000"));
        takePhotosInstructions.setTextSize(20);
        takePhotosInstructions.setText("Great! Now take 5 more photos the same as this one, to teach the computer how to collect a lemon from the tree. Tap next.");

        takePhotosInstructions2 = (TextView) findViewById(R.id.text2);
        takePhotosInstructions2.setTextSize(20);
        takePhotosInstructions2.setTextColor(Color.parseColor("#000000"));
//        takePhotosInstructions2.setText("Take 5 photos of you and your partner pretending to collect the lemon from the tree. Tap next below.");

    }

    public void changeActivity(View view){
        Intent intent = new Intent(getApplicationContext(), One_Lemon_LemonResult.class);
        startActivity(intent);
    }
}
