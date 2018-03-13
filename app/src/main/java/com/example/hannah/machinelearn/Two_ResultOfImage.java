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

public class Two_ResultOfImage extends AppCompatActivity {

    Button nextButton;

    TextView takePhotosInstructions;
    TextView takePhotosInstructions2;

    Bitmap imageToDisplay;

    int foundEggs;

    ImageView myImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__result_of_image);

//        Bundle b = getIntent().getExtras();
//        foundEggs = b.getInt("key");

        Intent intent = getIntent();
        imageToDisplay = (Bitmap) intent.getParcelableExtra("BitmapImage");

        myImageView = (ImageView) findViewById(R.id.myImgView);
        myImageView.setImageBitmap(imageToDisplay);

        takePhotosInstructions = (TextView) findViewById(R.id.text1);
        takePhotosInstructions.setTextColor(Color.parseColor("#000000"));
        takePhotosInstructions.setTextSize(20);
        takePhotosInstructions.setText("Great! Now take 5 more photos the same as this one, to teach the computer how to pick up an egg from the floor. Tap next.");

        takePhotosInstructions2 = (TextView) findViewById(R.id.text2);
        takePhotosInstructions2.setTextSize(20);
        takePhotosInstructions2.setTextColor(Color.parseColor("#000000"));
//        takePhotosInstructions2.setText("Tap next below");

    }

    public void changeActivity(View view){
        Bundle b = new Bundle();
        b.putInt("key", foundEggs);
        Intent intent = new Intent(getApplicationContext(), Two_CollectTrainingData.class);
        intent.putExtras(b);
        startActivity(intent);
        this.finish();
    }


}
