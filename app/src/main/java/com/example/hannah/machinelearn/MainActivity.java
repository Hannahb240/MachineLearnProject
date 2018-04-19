 package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.OpenCVLoader;
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

     TextView texxt;
     TextView texxt2;
     Button worldOneButton;
     Button worldTwoButton;
     //Button worldThreeButton;
     //Button classificationQuiz;
     Button guessThePose;


     Button changenum;
     boolean hiddenButtonPressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        worldOneButton = (Button) findViewById(R.id.goToWorld1);
        worldTwoButton = (Button) findViewById(R.id.goToWorld2);
        //worldThreeButton = (Button) findViewById(R.id.goToWorld3);
        //classificationQuiz = (Button) findViewById(R.id.classificationQuiz);
        guessThePose = (Button) findViewById(R.id.guessThePose);

        hiddenButtonPressed = false;

        knn knearest = new knn(this.getApplicationContext());
        //call knn with photo
        knearest.trainModel();
        Mat trainData = knearest.getTrainingData();
        List<Integer> trainLabels = knearest.getTrainingLabels();


        knn.trainingData = trainData;
        knn.trainingLabels = trainLabels;

        int id = this.getApplicationContext().getResources().getIdentifier("small", "drawable", this.getApplicationContext().getPackageName());
        Bitmap picture = BitmapFactory.decodeResource(this.getApplicationContext().getResources(), id);

        Log.d("picturew", Integer.toString(picture.getWidth()));
        Log.d("pictureh", Integer.toString(picture.getHeight()));

        Mat changedPic = new Mat();
        Utils.bitmapToMat(picture, changedPic);
        Log.d("changedr", Integer.toString( changedPic.rows()));
        Log.d("changedc", Integer.toString( changedPic.cols()));
        Log.d("changedp", changedPic.dump());

        changedPic.convertTo(changedPic, CvType.CV_32F);
        Mat bigMat = new Mat();
        bigMat.push_back(changedPic.reshape(1, 1));

        Log.d("bigmatcol", Integer.toString(bigMat.cols()));
        Log.d("bigmatrow", Integer.toString(bigMat.rows()));
        Log.d("bigmatpic", bigMat.dump());


        texxt = (TextView) findViewById(R.id.testingText);
        texxt2 = (TextView) findViewById(R.id.testingText2);

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
         else if(buttonText.equals("Classification quiz")) {
             Intent intent = new Intent(getApplicationContext(), Four_ClassificationQuizOne.class);
             startActivity(intent);
         }
         else if(buttonText.equals("Guess the pose")){
             Intent intent = new Intent(getApplicationContext(), Five_GuessThePose.class);
             startActivity(intent);
         }
     }

     public void tvActivity(View view) {

         if(!hiddenButtonPressed){
             hiddenButtonPressed = true;
         }
         else if(hiddenButtonPressed){
             Intent intent = new Intent(getApplicationContext(), Desktop_simulation.class);
             startActivity(intent);
         }

     }

     public void updateNumber(View view){

         int testerr = knn.trainingData.rows();
         texxt.setText(Integer.toString(testerr));

         float result = knn.testAccuracyOfModel(knn.trainingData, knn.trainingLabels);
         texxt2.setText(Float.toString(result));
     }

}
