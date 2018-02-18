package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Five_StandingPose extends AppCompatActivity {

    Button takePhoto;
    Button retakePhoto;
    Button next;
    ImageView myImageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    double yesOrNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__standing_pose);

        takePhoto = (Button) findViewById(R.id.takePhoto);
        myImageView = (ImageView) findViewById(R.id.myImgView);

        retakePhoto = (Button) findViewById(R.id.retakePhoto);
        retakePhoto.setVisibility(View.INVISIBLE);

        next = (Button) findViewById(R.id.nextButton);
        next.setVisibility(View.INVISIBLE);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }

    public void launchCamera(View view) {
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
        if (buttonText.equals("Next"))
            yesOrNo = Math.random();
        if (yesOrNo > 0.5) {
            Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessYes.class);
            startActivity(intent);
            this.finish();
        } else {
            Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessNo.class);
            startActivity(intent);
            this.finish();
        }
    }

    public void returnBack(View view){
        this.finish();
    }
}
