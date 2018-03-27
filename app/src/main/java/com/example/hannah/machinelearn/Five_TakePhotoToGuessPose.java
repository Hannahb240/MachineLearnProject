package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
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

    Button yesButton;
    Button noButton;

    Button tryAgain;
    Button back;

    ImageView myImageView;

    ImageView pose1;
    ImageView pose2;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    TextView poseType;
    TextView initialInstructions;
    TextView instructions2;
    TextView resultOfPhoto;
     
    int resultOfKnn;
    String resultOfKnnToString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__take_photo_to_guess_pose);

        takePhoto = (Button) findViewById(R.id.takePhoto);

        next = (Button) findViewById(R.id.nextButton);
        next.setVisibility(View.INVISIBLE);

        yesButton = (Button) findViewById(R.id.yesButton);
        yesButton.setVisibility(View.INVISIBLE);
        noButton = (Button) findViewById(R.id.noButton);
        noButton.setVisibility(View.INVISIBLE);

        myImageView = (ImageView) findViewById(R.id.myImgView);

        pose1 = (ImageView) findViewById(R.id.pose1);
        pose1.setImageResource(R.drawable.guessposepic1);

        pose2 = (ImageView) findViewById(R.id.pose2);
        pose2.setImageResource(R.drawable.guessposepic2);

        initialInstructions = (TextView) findViewById(R.id.initialTextView);
        initialInstructions.setTextSize(20);
        initialInstructions.setTextColor(Color.parseColor("#000000"));
        instructions2 = (TextView) findViewById(R.id.instructions2);
        instructions2.setVisibility(View.INVISIBLE);
        instructions2.setTextSize(20);
        instructions2.setTextColor(Color.parseColor("#000000"));

        tryAgain = (Button) findViewById(R.id.tryAnotherPhoto);
        tryAgain.setVisibility(View.INVISIBLE);

        back = (Button) findViewById(R.id.goBack);
        back.setVisibility(View.INVISIBLE);

        resultOfPhoto = (TextView) findViewById(R.id.resultOfPicture);
        resultOfPhoto.setTextSize(20);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }


    public void launchCamera(View view) {
        resultOfPhoto.setVisibility(View.INVISIBLE);
        tryAgain.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        pose1.setVisibility(View.INVISIBLE);
        pose2.setVisibility(View.INVISIBLE);
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
            myImageView.setVisibility(View.VISIBLE);
            myImageView.setImageBitmap(photo);
            takePhoto.setVisibility(View.INVISIBLE);

            yesButton.setVisibility(View.VISIBLE);
            noButton.setVisibility(View.VISIBLE);
            instructions2.setVisibility(View.VISIBLE);
            initialInstructions.setVisibility(View.INVISIBLE);

//            knn knearest = new knn(this.getApplicationContext());
            //call knn with photo
            String hannah = knn.testModel(photo, knn.trainingData, knn.trainingLabels);

            resultOfKnnToString = hannah;
//            if(hannah.equals("[1]")){
//                resultOfKnnToString = "reaching for a lemon!";
//            }
//            else if(hannah.equals("[2]")){
//                resultOfKnnToString = "crouching to pick up an egg!";
//            }

            instructions2.setText("The computer guessed that your pose is " + resultOfKnnToString + " Is this correct?");
            //float hannah = knn.testAccuracyOfModel();
        }
    }

    public void correct(View view){

        resultOfPhoto.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        yesButton.setVisibility(View.INVISIBLE);
        noButton.setVisibility(View.INVISIBLE);

        instructions2.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);

        resultOfPhoto.setText("Hooray! The computer guessed correctly. Tap the back button below.");
        resultOfPhoto.setTextSize(20);
        resultOfPhoto.setTextColor(Color.parseColor("#000000"));
    }

    public void notCorrect(View view) {
        tryAgain.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);


        resultOfPhoto.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);

        instructions2.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);

        resultOfPhoto.setText("Oh no! The computer was wrong. Try taking another photo, or tap back below.");
        resultOfPhoto.setTextSize(20);
        resultOfPhoto.setTextColor(Color.parseColor("#000000"));

        yesButton.setVisibility(View.INVISIBLE);
        noButton.setVisibility(View.INVISIBLE);
        instructions2.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);

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
