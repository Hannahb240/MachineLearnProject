package com.example.hannah.machinelearn.GuessThePose;

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

import com.example.hannah.machinelearn.Knn;
import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class Five_TakePhotoToGuessPose extends AppCompatActivity {

    Button takePhoto;
    Button yesButton;
    Button noButton;
    Button tryAgain;
    Button back;
    Button next;

    ImageView myImageView;
    ImageView pose1;
    ImageView pose2;

    TextView initialInstructions;
    TextView secondSetOfInstructions;
    TextView resultOfPhoto;
    String resultOfKnnToString;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__take_photo_to_guess_pose);

        initialiseButtons();

        myImageView = (ImageView) findViewById(R.id.myImgView);
        pose1 = (ImageView) findViewById(R.id.pose1);
        pose2 = (ImageView) findViewById(R.id.pose2);

        pose1.setImageResource(R.drawable.guessposepic1);
        pose2.setImageResource(R.drawable.guessposepic2);

        initialInstructions = (TextView) findViewById(R.id.initialInsturctionsTextView);
        initialInstructions.setTextSize(20);
        initialInstructions.setTextColor(Color.parseColor("#000000"));

        secondSetOfInstructions = (TextView) findViewById(R.id.instructions2);
        secondSetOfInstructions.setVisibility(View.INVISIBLE);
        secondSetOfInstructions.setTextSize(20);
        secondSetOfInstructions.setTextColor(Color.parseColor("#000000"));

        resultOfPhoto = (TextView) findViewById(R.id.resultOfPicture);
        resultOfPhoto.setTextSize(20);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
    }


    public void launchCamera(View view) {

        setVisibilityOfElements();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");

            setVisibiltyOnActivityResult();
            myImageView.setImageBitmap(photo);

            //call Knn with photo
            int resultOfKnn = Knn.testModel(photo, Knn.trainingData, Knn.trainingLabels);

            if(resultOfKnn == 1){
                resultOfKnnToString = "reaching for a lemon!";
            }
            else if(resultOfKnn == 2){
                resultOfKnnToString = "crouching to pick up an egg!";
            }

            secondSetOfInstructions.setText("The computer guessed that your pose is " + resultOfKnnToString + " Is this correct?");

        }
    }

    public void correct(View view){

        Knn.numberGuessedCorrectly++;

        resultOfPhoto.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        yesButton.setVisibility(View.INVISIBLE);
        noButton.setVisibility(View.INVISIBLE);
        secondSetOfInstructions.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);

        Utils.setInstructions(resultOfPhoto, "Hooray! The computer guessed correctly. Tap the back button below.");
    }

    public void notCorrect(View view) {

        Knn.numberGuessedIncorrectly++;

        tryAgain.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        resultOfPhoto.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        secondSetOfInstructions.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);
        yesButton.setVisibility(View.INVISIBLE);
        noButton.setVisibility(View.INVISIBLE);
        secondSetOfInstructions.setVisibility(View.INVISIBLE);
        myImageView.setVisibility(View.INVISIBLE);

        Utils.setInstructions(resultOfPhoto,"Oh no! The computer was wrong. Try taking another photo, or tap back below." );

    }

    private void initialiseButtons(){

        next = (Button) findViewById(R.id.nextButton);
        takePhoto = (Button) findViewById(R.id.takePhoto);
        yesButton = (Button) findViewById(R.id.yesButton);
        noButton = (Button) findViewById(R.id.noButton);
        tryAgain = (Button) findViewById(R.id.tryAnotherPhoto);
        back = (Button) findViewById(R.id.goBack);

        next.setVisibility(View.INVISIBLE);
        yesButton.setVisibility(View.INVISIBLE);
        noButton.setVisibility(View.INVISIBLE);
        tryAgain.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
    }

    private void setVisibilityOfElements() {
        resultOfPhoto.setVisibility(View.INVISIBLE);
        tryAgain.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
        pose1.setVisibility(View.INVISIBLE);
        pose2.setVisibility(View.INVISIBLE);
    }

    private void setVisibiltyOnActivityResult() {
        myImageView.setVisibility(View.VISIBLE);
        takePhoto.setVisibility(View.INVISIBLE);
        yesButton.setVisibility(View.VISIBLE);
        noButton.setVisibility(View.VISIBLE);
        secondSetOfInstructions.setVisibility(View.VISIBLE);
        initialInstructions.setVisibility(View.INVISIBLE);
    }

    public void goBack(View view) {
        this.finish();
    }

}
