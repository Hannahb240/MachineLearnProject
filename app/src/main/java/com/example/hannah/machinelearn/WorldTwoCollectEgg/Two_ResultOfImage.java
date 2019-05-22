package com.example.hannah.machinelearn.WorldTwoCollectEgg;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Two_ResultOfImage extends AppCompatActivity {


    TextView takePhotosInstructions;

    Button nextButton;

    Bitmap imageToDisplay;
    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__result_of_image);

        Intent intent = getIntent();
        imageToDisplay = (Bitmap) intent.getParcelableExtra("BitmapImage");

        myImageView = (ImageView) findViewById(R.id.myImgView);
        myImageView.setImageBitmap(imageToDisplay);

        takePhotosInstructions = (TextView) findViewById(R.id.text1);
        Utils.setInstructions(takePhotosInstructions,"Great! Now take 5 more photos the same as this one, to teach the computer how to pick up an egg from the floor. Tap next.");
    }

    public void changeActivity(View view){
        Intent intent = new Intent(getApplicationContext(), Two_CollectTrainingData.class);
        startActivity(intent);
        this.finish();
    }

}
