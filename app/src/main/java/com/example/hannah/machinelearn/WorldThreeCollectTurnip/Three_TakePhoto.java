package com.example.hannah.machinelearn.WorldThreeCollectTurnip;

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

import com.example.hannah.machinelearn.R;

public class Three_TakePhoto extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Button takePhoto;
    Button retakePhoto;
    Button next;

    ImageView myImageView;

    TextView takePhotoInstructions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__take_photo);

        takePhoto = (Button) findViewById(R.id.takePhoto);

        takePhotoInstructions = (TextView) findViewById(R.id.photoInstructions);
        takePhotoInstructions.setTextColor(Color.parseColor("#000000"));
        takePhotoInstructions.setText("Take a photo of your partner pretending to lie down and pull the turnip out of the ground!");

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
            retakePhoto.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            takePhoto.setVisibility(View.INVISIBLE);

        }
    }

    public void goToResult(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Next")) {
            Intent intent = new Intent(getApplicationContext(), Three_ResultOfImage.class);
            startActivity(intent);
            this.finish();
        }
    }
}
