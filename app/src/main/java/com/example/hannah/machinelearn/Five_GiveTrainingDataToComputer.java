package com.example.hannah.machinelearn;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__give_training_data_to_computer);

        text = (TextView) findViewById(R.id.text);
        text.setText("We'll give the computer your training data.");

        folderPic = (ImageView) findViewById(R.id.folderView);
        folderPic.setImageResource(R.drawable.folder);

        returnToWorldSelection = (Button) findViewById(R.id.returnToWorldOneID);

    }

    public void returnToActivityFive(View view){
        this.finish();
    }
}
