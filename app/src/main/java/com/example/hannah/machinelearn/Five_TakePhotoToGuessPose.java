package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Five_TakePhotoToGuessPose extends AppCompatActivity {

    int typeOfPose;

    Button takePhoto;
    Button retakePhoto;
    Button next;
    ImageView myImageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    double yesOrNo;

    TextView poseType;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__take_photo_to_guess_pose);

        poseType = (TextView) findViewById(R.id.typeOfPose);
        
        Bundle b = getIntent().getExtras();
        typeOfPose = b.getInt("key");

       // poseType.setText(knn.hiHannah());

        takePhoto = (Button) findViewById(R.id.takePhoto);
        myImageView = (ImageView) findViewById(R.id.myImgView);

        retakePhoto = (Button) findViewById(R.id.retakePhoto);
        retakePhoto.setVisibility(View.INVISIBLE);

        next = (Button) findViewById(R.id.nextButton);
        next.setVisibility(View.INVISIBLE);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        TextView posetype;
        posetype = (TextView) findViewById(R.id.typeofpose);
        posetype.setText(Integer.toString(typeOfPose));
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

            knn knearest = new knn(this.getApplicationContext());
            //call knn with photo
            String hannah = knearest.doKnn(photo);
            poseType.setText(hannah);

            //myImageView.setImageBitmap(hannah);
            retakePhoto.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            takePhoto.setVisibility(View.INVISIBLE);
        }
    }

    public void goToResult(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();

        //add bundle
        Bundle b = new Bundle();
        b.putInt("actual", typeOfPose);

        //call knn



//        if (buttonText.equals("Next"))
//            yesOrNo = Math.random();


//        if (yesOrNo > 0.5) {
//            Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessYes.class);
//            intent.putExtras(b);
//            startActivity(intent);
//            this.finish();
//        } else {
//            Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessNo.class);
//            intent.putExtras(b);
//            startActivity(intent);
//            this.finish();
//        }
    }

    public void returnBack(View view){
        this.finish();
    }
}
