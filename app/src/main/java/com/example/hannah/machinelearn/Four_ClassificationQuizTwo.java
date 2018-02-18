package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Four_ClassificationQuizTwo extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four__classification_quiz_two);
    }

    public void nextQuestion(View view){
        Intent intent = new Intent(getApplicationContext(), Four_ClassificationQuizThree.class);
        startActivity(intent);
        this.finish();
    }
}
