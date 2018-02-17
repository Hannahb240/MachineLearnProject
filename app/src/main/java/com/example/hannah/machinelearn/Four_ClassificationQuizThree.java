package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Four_ClassificationQuizThree extends AppCompatActivity {

    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button nextButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four__classification_quiz_three);

        ImageView questionImg= (ImageView) findViewById(R.id.quizImage);
        questionImg.setImageResource(R.drawable.lemon);

        ImageView answer1 = (ImageView) findViewById(R.id.answer1);
        answer1.setImageResource(R.drawable.lemon);

        ImageView answer2 = (ImageView) findViewById(R.id.answer2);
        answer2.setImageResource(R.drawable.lemon);

        ImageView answer3 = (ImageView) findViewById(R.id.answer3);
        answer3.setImageResource(R.drawable.lemon);

        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        nextButton = (Button)findViewById(R.id.next);
    }

    public void nextQuestion(View view){
        Intent intent = new Intent(getApplicationContext(), Four_ClassificationQuizFour.class);
        startActivity(intent);
        this.finish();
    }
}
