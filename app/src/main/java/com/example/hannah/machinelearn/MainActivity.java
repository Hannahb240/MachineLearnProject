 package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hannah.machinelearn.GuessThePose.Five_GuessThePose;
import com.example.hannah.machinelearn.WorldOneCollectLemon.One_WorldOne;
import com.example.hannah.machinelearn.WorldTwoCollectEgg.Two_WorldTwo;
import com.example.hannah.machinelearn.WorldThreeCollectTurnip.Three_WorldThree;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;

import java.util.List;

 public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
        System.loadLibrary("opencv_java3");
    }

     Button worldOneButton;
     Button worldTwoButton;
     //Button worldThreeButton;
     Button guessThePose;
     Button hiddenButton;

     boolean hiddenButtonPressed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        worldOneButton = (Button) findViewById(R.id.goToWorld1);
        worldTwoButton = (Button) findViewById(R.id.goToWorld2);
        //worldThreeButton = (Button) findViewById(R.id.goToWorld3);
        guessThePose = (Button) findViewById(R.id.guessThePose);
        hiddenButton = (Button) findViewById(R.id.desktop);

//        hiddenButton.setVisibility(View.INVISIBLE);
        hiddenButtonPressed = false;

        trainModelTest();

    }

     public void trainModelTest() {

         Knn knearest = new Knn(this.getApplicationContext());

//         call Knn with photo
         knearest.initialiseModel();
         Mat trainData = knearest.getTrainingData();
         List<Integer> trainLabels = knearest.getTrainingLabels();

         Knn.trainingData = trainData;
         Knn.trainingLabels = trainLabels;

         int id = this.getApplicationContext().getResources().getIdentifier("small", "drawable", this.getApplicationContext().getPackageName());
         Bitmap picture = BitmapFactory.decodeResource(this.getApplicationContext().getResources(), id);

         Mat changedPic = new Mat();
         Utils.bitmapToMat(picture, changedPic);

         changedPic.convertTo(changedPic, CvType.CV_32F);
         Mat bigMat = new Mat();
         bigMat.push_back(changedPic.reshape(1, 1));

     }

     public void changeToWorld(View view) {

         Button buttonPressed = (Button) findViewById(view.getId());
         String buttonText = buttonPressed.getText().toString();
         if(buttonText.equals("Lemon world")) {
             Intent intent = new Intent(getApplicationContext(), One_WorldOne.class);
             startActivity(intent);
         }
         else if(buttonText.equals("Egg world")) {
             Intent intent = new Intent(getApplicationContext(), Two_WorldTwo.class);
             startActivity(intent);
         }
         else if(buttonText.equals("World three")) {
             Intent intent = new Intent(getApplicationContext(), Three_WorldThree.class);
             startActivity(intent);
         }
         else if(buttonText.equals("Guess the pose")){
             Intent intent = new Intent(getApplicationContext(), Five_GuessThePose.class);
             startActivity(intent);
         }
     }

     public void tvActivity(View view) {

         if (!hiddenButtonPressed) {
             hiddenButtonPressed = true;
         } else if (hiddenButtonPressed) {
             Intent intent = new Intent(getApplicationContext(), Desktop_simulation.class);
             startActivity(intent);
         }
     }

}
