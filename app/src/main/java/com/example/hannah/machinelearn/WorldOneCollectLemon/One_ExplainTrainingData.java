package com.example.hannah.machinelearn.WorldOneCollectLemon;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class One_ExplainTrainingData extends AppCompatActivity {

    TextView takePhotosInstructions;

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
        Utils.setInstructions(takePhotosInstructions, "Great! Now take 5 more photos the same as this one, to teach the computer how to collect a lemon from the tree. Tap next.");

    }

    public void changeActivity(View view){
        Intent intent = new Intent(getApplicationContext(), One_Lemon_LemonResult.class);
        startActivity(intent);
        this.finish();
    }
}
