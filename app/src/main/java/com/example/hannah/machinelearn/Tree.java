package com.example.hannah.machinelearn;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Tree extends AppCompatActivity {

    //Button to take a photo
    Button takePhoto;
    Button seeResult;

    ImageView myImageView;

    //Photo variables
    private String pictureImagePath = "";
    private byte[] process_data;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tree);

        takePhoto = (Button) findViewById(R.id.takePhoto);
        seeResult = (Button) findViewById(R.id.seeResult);
        seeResult.setVisibility(View.INVISIBLE);
        myImageView = (ImageView) findViewById(R.id.myImgView);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        //disable button if user has no camera
        if(!hasCamera() ) {
            takePhoto.setEnabled(false);
        }

    }

    //Check if the user has a camrea
    private boolean hasCamera() {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    //Launching the camera
    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        //Take a picture and pass results to onActivityResult
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    //return
    public void returrn(View view){
        this.finish();
    }


    //Return image captured
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            myImageView.setImageBitmap(photo);
            seeResult.setVisibility(View.VISIBLE);
            takePhoto.setText("Take another image");


        }

    }

    public void changeActivity(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Result")) {
            Intent intent = new Intent(getApplicationContext(), ResultOfImage.class);
            startActivity(intent);
            this.finish();
        }
    }


}
