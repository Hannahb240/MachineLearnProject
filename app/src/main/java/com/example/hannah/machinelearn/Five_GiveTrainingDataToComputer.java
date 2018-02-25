package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Five_GiveTrainingDataToComputer extends AppCompatActivity {

    TextView text;
    ImageView folderPic;
    Button returnToWorldSelection;

    int typeOfPose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__give_training_data_to_computer);

        Bundle b = getIntent().getExtras();
        typeOfPose = b.getInt("key");

        text = (TextView) findViewById(R.id.text);
        text.setText("We'll give the computer your training data. And your pose is : " + typeOfPose);

        folderPic = (ImageView) findViewById(R.id.folderView);
        folderPic.setImageResource(R.drawable.folder);

        //returnToWorldSelection = (Button) findViewById(R.id.returnToWorldOneID);

    }

    public void tryAgain(View view){

        //Open a new intent for taking photo
        Bundle b = new Bundle();
        //In take photo to guess pose class, check if rig = 1. If it is, it must guess the right pose on second try.
        b.putInt("rig", 1);
        //Make sure to pass through the key from whichever button the user pressed a few classes ago.
        b.putInt("key", typeOfPose);

        Intent intent = new Intent(getApplicationContext(), Five_TakePhotoToGuessPose.class);
        intent.putExtras(b);

        this.finish();
    }
}
