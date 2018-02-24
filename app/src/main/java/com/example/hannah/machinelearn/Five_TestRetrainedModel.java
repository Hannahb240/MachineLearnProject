package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Five_TestRetrainedModel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__test_retrained_model);

        //Image view
        ImageView pic1 = (ImageView) findViewById(R.id.pic1);
        pic1.setImageBitmap(knn.retrain1);

        //Set image view to be one of the pics collected on prev page


    }
}
