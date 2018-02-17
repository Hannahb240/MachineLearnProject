package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Two_DisplayTrainingData extends AppCompatActivity {


    ImageView myImageView;
    Parcelable bitmapArray[] = new Bitmap[20];

    TextView displayHi;

    int hi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView displayHi;
        displayHi = (TextView) findViewById(R.id.displayhi);

        myImageView = (ImageView) findViewById(R.id.myImgView);

        Bundle b = getIntent().getExtras();

        hi = b.getInt("key");

        if(hi == 3){
            displayHi.setText("The fruit is quite near to the ground, how are you going to pick it?");
        }


//        Intent intent = getIntent();
//        Bundle extras = intent.getExtras();

//        byte[] img1 = extras.getByteArray("image1");
//        Bitmap bmp = BitmapFactory.decodeByteArray(img1, 0, img1.length);


//        byte[] byteArray = getIntent().getByteArrayExtra("image");
//        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
//
//        myImageView.setImageBitmap(bmp);



        Button returnButton;
        returnButton = (Button) findViewById(R.id.goToWorld1);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__display_training_data);
    }


    public void returnToWorldTwo(View view){
        this.finish();

    }
}
