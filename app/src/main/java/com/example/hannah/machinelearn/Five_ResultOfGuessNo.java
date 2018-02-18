package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Five_ResultOfGuessNo extends AppCompatActivity {

    TextView text;
    Button yes;
    Button no;
    Button back;
    Button moreData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five__result_of_guess_no);

        yes = (Button) findViewById(R.id.yes);
        no = (Button) findViewById(R.id.no);

        moreData = (Button) findViewById(R.id.moreData);
        moreData.setVisibility(View.INVISIBLE);
        back = (Button) findViewById(R.id.back);
        back.setVisibility(View.INVISIBLE);

        text = (TextView) findViewById(R.id.textBox);
    }

    public void onYes(View view){
        back.setVisibility(View.VISIBLE);
        yes.setVisibility(View.INVISIBLE);
        no.setVisibility(View.INVISIBLE);
        text.setText("Congratulations! You've trained the computer to recognise the pose");
    }

    public void onNo(View view){
        moreData.setVisibility(View.VISIBLE);
        yes.setVisibility(View.INVISIBLE);
        no.setVisibility(View.INVISIBLE);
        text.setText("Looks like you need to collect some more training data so the computer can guess your pose!");
    }

    public void onBack(View view){
        this.finish();
    }

    public void moreData(View view){
        Intent intent = new Intent(getApplicationContext(), Five_CollectTrainingData.class);
        startActivity(intent);
        this.finish();
    }
}
