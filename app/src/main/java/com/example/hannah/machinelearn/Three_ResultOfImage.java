package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Three_ResultOfImage extends AppCompatActivity {


    Button nextButton;
    int flagForNextSelected;
    TextView resultOfPhoto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three__result_of_image);
        flagForNextSelected = 0;

        ImageView img= (ImageView) findViewById(R.id.turnipPic);
        resultOfPhoto = (TextView) findViewById(R.id.resultText);

        nextButton = (Button) findViewById(R.id.nextButton);

        resultOfPhoto.setText("Hooray you picked a turnip!");

    }

    public void selectNext(View view) {

            if(flagForNextSelected==0) {
                resultOfPhoto.setText("Teach the computer how you collected this!");
                flagForNextSelected +=1;
            }
            else{
                Intent intent = new Intent(getApplicationContext(), Three_CollectTrainingData.class);
                startActivity(intent);
                this.finish();
            }
    }
}
