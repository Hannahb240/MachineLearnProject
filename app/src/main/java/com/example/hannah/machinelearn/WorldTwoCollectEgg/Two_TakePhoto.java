package com.example.hannah.machinelearn.WorldTwoCollectEgg;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Two_TakePhoto extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Button takePhoto;
    Button retakePhoto;
    Button next;

    Bitmap imageTaken;

    ImageView myImageView;

    TextView takePhotoInstructions;
    TextView takePhotoInstructions2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__take_photo);

        takePhotoInstructions = (TextView) findViewById(R.id.photoInstructions);
        takePhotoInstructions2 = (TextView) findViewById(R.id.photoInstructions2);

        Utils.setInstructions(takePhotoInstructions, "Take a picture of your partner pretending to pick up an egg from the floor.");
        Utils.setInstructions(takePhotoInstructions2, "You’re going to need to crouch down low! Tap the button below.");

        takePhoto = (Button) findViewById(R.id.takePhoto);
        retakePhoto = (Button) findViewById(R.id.retakePhoto);
        next = (Button) findViewById(R.id.nextButton);

        next.setVisibility(View.INVISIBLE);
        retakePhoto.setVisibility(View.INVISIBLE);

        myImageView = (ImageView) findViewById(R.id.myImgView);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Get the photo
            Bundle extras = data.getExtras();
            imageTaken = (Bitmap) extras.get("data");
            myImageView.setImageBitmap(imageTaken);

            retakePhoto.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            takePhoto.setVisibility(View.INVISIBLE);

            Utils.setInstructions(takePhotoInstructions, "If you're happy with your picture, tap next to go to the next page.");
            takePhotoInstructions2.setVisibility(View.INVISIBLE);

        }
    }
    public void goToResult(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();

        if(buttonText.equals("Next")) {
            Intent intent = new Intent(getApplicationContext(), Two_ResultOfImage.class);
            intent.putExtra("BitmapImage", imageTaken);
            startActivity(intent);
            this.finish();
        }
    }
}
