package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Two_WorldTwo extends AppCompatActivity {

    ImageButton egg1;
    ImageButton egg2;

    ImageView myImageView;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    int setBitmapArrayElement;

    Bitmap bitmapArray[] = new Bitmap[20];




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_world_two);

        myImageView = (ImageView) findViewById(R.id.myImgView);


        //egg smashed
        egg1 = (ImageButton) findViewById(R.id.egg1);
        egg1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Two_EggSmashed.class);
                startActivity(intent);
                egg1.setVisibility(View.INVISIBLE);
            }
        });

        egg2 = (ImageButton) findViewById(R.id.egg2);
        egg2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                StrictMode.setVmPolicy(builder.build());

                takePhoto(0);
                egg2.setVisibility(View.INVISIBLE);


                //Return photo to here
                //Add it to a variable
                //open new activity with array of images
                //finish that activity
                //array is still here
                //make egg invisible
            }
        });




    }

    private void takePhoto(int bitmapArrayIndex){

        setBitmapArrayElement = bitmapArrayIndex;
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            bitmapArray[setBitmapArrayElement] = photo;



            Intent intent = new Intent(getApplicationContext(), Two_DisplayTrainingData.class);
            Bundle b = new Bundle();
            b.putInt("key", 3); //Your id
            intent.putExtras(b); //Put your id to your next Intent
            startActivity(intent);






//
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte[] byteArray = stream.toByteArray();
//
//            Intent in1 = new Intent(this, Two_DisplayTrainingData.class);
//            in1.putExtra("image",byteArray);
//            startActivity(in1);



//            //Convert to byte array
//            ByteArrayOutputStream stream = new ByteArrayOutputStream();
//            photo.compress(Bitmap.CompressFormat.PNG, 100, stream);
//            byte[] byteArray = stream.toByteArray();
//
//            Intent in1 = new Intent(this, Two_DisplayTrainingData.class);
//            Bundle extras1 = new Bundle();
//
//            extras1.putByteArray("image1", byteArray);
//
//            getIntent().putExtras(extras1);
//            startActivity(in1);



//            Intent intent = new Intent(this, MyActivity.class);
//            Bundle extras = new Bundle();
//            extras.putString("EXTRA_USERNAME","my_username");
//            extras.putString("EXTRA_PASSWORD","my_password");
//            intent.putExtras(extras);
//            startActivity(intent);




















//
//            bms.bm1 = photo;
//            ImageView myImageView;
//            myImageView = (ImageView) findViewById(R.id.myImgView);
//            myImageView.setImageBitmap(bms.getBitmap());
//
//
//
//            Intent intent = new Intent(getApplicationContext(), Two_DisplayTrainingData.class);
//            intent.putExtra("bitmaps", photo);
//
//            Bundle b=new Bundle();
//                b.putParcelableArray("key", bitmapArray);
//                intent.putExtras(b);
//            startActivity(intent);
        }
    }




}
