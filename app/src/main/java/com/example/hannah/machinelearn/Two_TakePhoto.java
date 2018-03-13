package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Two_TakePhoto extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Button takePhoto;
    Button retakePhoto;
    Button next;

    int foundEggs;

    Bitmap imageTaken;

    ImageView myImageView;

    TextView takePhotoInstructions;
    TextView takePhotoInstructions2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two__take_photo);

        Bundle b = getIntent().getExtras();
        foundEggs = b.getInt("key");

        takePhoto = (Button) findViewById(R.id.takePhoto);

//        takePhotoInstructions = (TextView) findViewById(R.id.photoInstructions);
//        takePhotoInstructions.setTextColor(Color.parseColor("#000000"));
//        takePhotoInstructions.setText("Take a photo of your partner pretending to crouch down to pick up the egg!");


        takePhotoInstructions = (TextView) findViewById(R.id.photoInstructions);
        takePhotoInstructions.setTextColor(Color.parseColor("#000000"));
        takePhotoInstructions.setText("Take a picture of your partner pretending to pick up an egg from the floor.");
        takePhotoInstructions.setTextSize(20);

        takePhotoInstructions2 = (TextView) findViewById(R.id.photoInstructions2);
        takePhotoInstructions2.setTextColor(Color.parseColor("#000000"));

        takePhotoInstructions2.setText("You’re going to need to crouch down low! Tap the button below.");
        takePhotoInstructions2.setTextSize(20);

        next = (Button) findViewById(R.id.nextButton);
        next.setVisibility(View.INVISIBLE);

        retakePhoto = (Button) findViewById(R.id.retakePhoto);
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
            Bitmap photo = (Bitmap) extras.get("data");
            myImageView.setImageBitmap(photo);
            imageTaken = photo;
            retakePhoto.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            takePhoto.setVisibility(View.INVISIBLE);
            takePhotoInstructions.setText("If you're happy with your picture, tap next to go to the next page.");
            takePhotoInstructions.setTextSize(20);
            takePhotoInstructions2.setVisibility(View.INVISIBLE);

        }
    }
    public void goToResult(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Next")) {
//            Bundle b = new Bundle();
//            b.putInt("key", foundEggs);

            Intent intent = new Intent(getApplicationContext(), Two_ResultOfImage.class);
            intent.putExtra("BitmapImage", imageTaken);
//            intent.putExtras(b);
            startActivity(intent);
            this.finish();
        }
    }
}
