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
import android.widget.TextView;

public class Five_CollectTrainingData extends AppCompatActivity {

    TextView text;
    Button done;

    int typeOfPose;

    ImageView pic1;
    ImageView pic2;
    ImageView pic3;
    ImageView pic4;
    ImageView pic5;

    Bitmap trainingImage1;
    Bitmap trainingImage2;
    Bitmap trainingImage3;
    Bitmap trainingImage4;
    Bitmap trainingImage5;

    Button takepic1;
    Button takepic2;
    Button takepic3;
    Button takepic4;
    Button takepic5;

    String resultOfKnn;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String buttonPressedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__collect_training_data);

        Bundle b = getIntent().getExtras();
        typeOfPose = b.getInt("key");

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        text = (TextView) findViewById(R.id.text);
        text.setText("Take 5 pictures of you or your partner acting out the pose to give the computer some more training data, so it learns how to classify the pose.");

        done = (Button) findViewById(R.id.done);
        done.setVisibility(View.INVISIBLE);

        takepic1 = (Button) findViewById(R.id.TakePhoto);
        takepic2 = (Button) findViewById(R.id.TakePhoto2);
        takepic3 = (Button) findViewById(R.id.TakePhoto3);
        takepic4 = (Button) findViewById(R.id.TakePhoto4);
        takepic5 = (Button) findViewById(R.id.TakePhoto5);

        pic1 = (ImageView) findViewById(R.id.pic1);
        pic1.setImageResource(R.drawable.photofillin);
        pic2 = (ImageView) findViewById(R.id.pic2);
        pic2.setImageResource(R.drawable.photofillin);
        pic3 = (ImageView) findViewById(R.id.pic3);
        pic3.setImageResource(R.drawable.photofillin);
        pic4 = (ImageView) findViewById(R.id.pic4);
        pic4.setImageResource(R.drawable.photofillin);
        pic5 = (ImageView) findViewById(R.id.pic5);
        pic5.setImageResource(R.drawable.photofillin);

    }

    public void takePhotograph(View view) {

        //Get text of button pressed
        Button buttonPressed = (Button) findViewById(view.getId());
        buttonPressedNumber = buttonPressed.getText().toString();

        //Take the photo
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");

            //case statement for whatever the variable is set to
            switch(buttonPressedNumber) {
                case "Take      Photo 1":
                    pic1.setImageBitmap(photo);
                    trainingImage1 = photo;
                    break;
                case "Take      Photo 2":
                    pic2.setImageBitmap(photo);
                    trainingImage2 = photo;
                    break;
                case "Take      Photo 3":
                    pic3.setImageBitmap(photo);
                    trainingImage3 = photo;
                    break;
                case "Take      Photo 4":
                    pic4.setImageBitmap(photo);
                    trainingImage4 = photo;
                    break;
                case "Take      Photo 5":
                    pic5.setImageBitmap(photo);
                    trainingImage5 = photo;
                    done.setVisibility(View.VISIBLE);
                    text.setVisibility(View.INVISIBLE);
                    break;
            }
        }
        else if(requestCode == 2) {

            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");

            //send to knn to test
            resultOfKnn = knn.trainAndDoKNNWithExtraData(1, photo, trainingImage1, trainingImage2, trainingImage3, trainingImage4, trainingImage5);
            text.setVisibility(View.VISIBLE);
            text.setText(resultOfKnn);

        }

    }

    public void changeActivity(View view) {
        Intent intent = new Intent(getApplicationContext(), Five_GiveTrainingDataToComputer.class);
        Bundle b = new Bundle();
        b.putInt("key", typeOfPose);
        intent.putExtras(b);
        startActivity(intent);
        this.finish();
    }

    public void changeActivityRetrain(View view) {

        //set everything here to be invisible.
        pic1.setVisibility(View.INVISIBLE);
        pic2.setVisibility(View.INVISIBLE);
        pic3.setVisibility(View.INVISIBLE);
        pic4.setVisibility(View.INVISIBLE);
        pic5.setVisibility(View.INVISIBLE);

        takepic1.setVisibility(View.INVISIBLE);
        takepic2.setVisibility(View.INVISIBLE);
        takepic3.setVisibility(View.INVISIBLE);
        takepic4.setVisibility(View.INVISIBLE);
        takepic5.setVisibility(View.INVISIBLE);

        done.setVisibility(View.INVISIBLE);
        text.setVisibility(View.INVISIBLE);

        //do knn stuff. Call a method.
        changeActivityRetrain();



    }

    private void changeActivityRetrain(){

        pic1.setVisibility(View.VISIBLE);

        //test it out! - button
        //take a new picture of the pose youre trying to guess
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 2);



    }

}
