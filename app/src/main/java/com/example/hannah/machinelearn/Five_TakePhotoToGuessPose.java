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
    Button next;

    Button crouchButton;
    Button standButton;

    Button tryAgain;
    Button back;

    ImageView myImageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    TextView poseType;
    TextView initialInstructions;
    TextView instructions2;
    TextView resultOfPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__take_photo_to_guess_pose);

        takePhoto = (Button) findViewById(R.id.takePhoto);

        next = (Button) findViewById(R.id.nextButton);
        next.setVisibility(View.INVISIBLE);

        crouchButton = (Button) findViewById(R.id.crouchButton);
        crouchButton.setVisibility(View.INVISIBLE);
        standButton = (Button) findViewById(R.id.standButton);
        standButton.setVisibility(View.INVISIBLE);

        myImageView = (ImageView) findViewById(R.id.myImgView);
        initialInstructions = (TextView) findViewById(R.id.initialTextView);
        instructions2 = (TextView) findViewById(R.id.instructions2);
        instructions2.setVisibility(View.INVISIBLE);

        tryAgain = (Button) findViewById(R.id.tryAnotherPhoto);
        tryAgain.setVisibility(View.INVISIBLE);

        back = (Button) findViewById(R.id.goBack);
        back.setVisibility(View.INVISIBLE);

        resultOfPhoto  = (TextView) findViewById(R.id.resultOfPicture);
        resultOfPhoto.setTextSize(20);



//        poseType = (TextView) findViewById(R.id.typeOfPose);
//
//        Bundle b = getIntent().getExtras();
//        typeOfPose = b.getInt("key");
//
//       // poseType.setText(knn.hiHannah());
//

//
//        retakePhoto = (Button) findViewById(R.id.retakePhoto);
//
//        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
//
//        TextView posetype;
//        posetype = (TextView) findViewById(R.id.typeofpose);
//        posetype.setText(Integer.toString(typeOfPose));
    }
//
    public void launchCamera(View view) {
        resultOfPhoto.setVisibility(View.INVISIBLE);
        tryAgain.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }
//
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");

            myImageView.setImageBitmap(photo);
            takePhoto.setVisibility(View.INVISIBLE);

            crouchButton.setVisibility(View.VISIBLE);
            standButton.setVisibility(View.VISIBLE);
            instructions2.setVisibility(View.VISIBLE);
            initialInstructions.setVisibility(View.INVISIBLE);


//            knn knearest = new knn(this.getApplicationContext());
            //call knn with photo
//            String hannah = knearest.doKnn(photo);
           // float hannah = knn.testAccuracyOfModel();
//            poseType.setText(hannah);

        }
    }

    public void isResultCorrect(View view){

        resultOfPhoto.setVisibility(View.VISIBLE);
        tryAgain.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        crouchButton.setVisibility(View.INVISIBLE);
        standButton.setVisibility(View.INVISIBLE);
        instructions2.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);
        if(Math.random() > 0.5){
            resultOfPhoto.setText("Hooray! The classifier guessed correctly");
        }
        else {
            resultOfPhoto.setText("Oh no! The classifier was wrong.");
        }
    }

    public void goBack(View view){
        this.finish();
    }
//    public void goToResult(View view) {
//
//        Button buttonPressed = (Button) findViewById(view.getId());
//        String buttonText = buttonPressed.getText().toString();
//
//        //add bundle
//        Bundle b = new Bundle();
//        b.putInt("actual", typeOfPose);
//
//        Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessNo.class);
//            intent.putExtras(b);
//            startActivity(intent);
////
//
//        //call knn
//
////        if (buttonText.equals("Next"))
////            yesOrNo = Math.random();
//
//
////        if (yesOrNo > 0.5) {
////            Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessYes.class);
////            intent.putExtras(b);
////            startActivity(intent);
////            this.finish();
////        } else {
////            Intent intent = new Intent(getApplicationContext(), Five_ResultOfGuessNo.class);
////            intent.putExtras(b);
////            startActivity(intent);
////            this.finish();
////        }


    public void returnBack(View view){
        this.finish();
    }
}
