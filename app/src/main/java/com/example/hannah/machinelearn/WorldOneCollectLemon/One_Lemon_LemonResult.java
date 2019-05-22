package com.example.hannah.machinelearn.WorldOneCollectLemon;

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

import com.example.hannah.machinelearn.CollectTrainingData;
import com.example.hannah.machinelearn.R;
import com.example.hannah.machinelearn.Utils;

public class One_Lemon_LemonResult extends AppCompatActivity implements CollectTrainingData {

    TextView instructions;
    Button doneButtonForAllImagesTaken;

    ImageView pic1;
    ImageView pic2;
    ImageView pic3;
    ImageView pic4;
    ImageView pic5;

    static final int REQUEST_IMAGE_CAPTURE = 1;
    String buttonPressedNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_lemon_lemon_result);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

        instructions = (TextView) findViewById(R.id.text);
        Utils.setInstructions(instructions, "Take 5 more photos of your pose to pretend to collect a lemon from the tree.");

        doneButtonForAllImagesTaken = (Button) findViewById(R.id.done);
        doneButtonForAllImagesTaken.setVisibility(View.INVISIBLE);

        setInitialImageViews();
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

            //Set picture according to variable
            switch(buttonPressedNumber) {
                case "Take            Photo 1":
                    pic1.setImageBitmap(photo);
                    break;
                case "Take            Photo 2":
                    pic2.setImageBitmap(photo);
                    break;
                case "Take            Photo 3":
                    pic3.setImageBitmap(photo);
                    break;
                case "Take            Photo 4":
                    pic4.setImageBitmap(photo);
                    break;
                case "Take            Photo 5":
                    pic5.setImageBitmap(photo);
                    doneButtonForAllImagesTaken.setVisibility(View.VISIBLE);
                    instructions.setText("Great work! Tap done.");
                    break;
             }
           }
        }

    public void changeActivity(View view) {
            Intent intent = new Intent(getApplicationContext(), One_Lemon_GiveLemonToKing.class);
            startActivity(intent);
            this.finish();
    }

    public void setInitialImageViews() {
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
}


