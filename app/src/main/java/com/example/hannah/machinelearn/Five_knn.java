package com.example.hannah.machinelearn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.ml.KNearest;
import org.opencv.ml.Ml;
import org.opencv.utils.Converters;

import java.util.ArrayList;
import java.util.List;


public class Five_knn extends AppCompatActivity {

    TextView resultOfMat;

    //Training data variables
    Bitmap trainingBitmap;
    Mat trainingBitmapToMat;

    //training data matrix and list of corresponding labels
    Mat trainingData;
    List<Integer> trainingLabels;

    Mat testingData;
    List<Integer> testLabels;

    ImageView myImageView;
    ImageView myImageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_knn);

        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels= new ArrayList<Integer>();


        //Standing training data


        //Crouching training data


        //Lying training data




        for(int x = 1; x <= 2; x++){
            //Find the training image id
            int id = getResources().getIdentifier("person" + x,"drawable", getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1,1));

            //Add training label
            if(x <= 1 ){
                trainingLabels.add(1);
            }
            else if(x > 1){
                trainingLabels.add(2);
            }
        }

        KNearest knn = KNearest.create();
        knn.train(trainingData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainingLabels));

        testingData = new Mat();
        testingData.push_back(trainingBitmapToMat.reshape(1,1));

        testLabels= new ArrayList<Integer>();
        testLabels.add(2);

        //Text to display
        resultOfMat = (TextView) findViewById(R.id.mattext);

        Mat one_feature = testingData.row(0);
        int testLabel = testLabels.get(0);

        Mat res = new Mat();
        float p = knn.findNearest(one_feature, 1, res);
        resultOfMat.setText(testLabel + " " + p + " " + res.dump());


//        //TRAINING IMAGE 1
//        //Convert training image 1 from bitmap to mat.
//        trainingBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.person1);
//        trainingBitmapToMat = new Mat();
//        Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
//        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
//
//        trainingData = new Mat();
//        trainingData.push_back(trainingBitmapToMat.reshape(1,1));
//
//        trainingLabels= new ArrayList<Integer>();
//        trainingLabels.add(1);
//
//
//        //TRAINING IMAGE 2
//        trainingBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.person2);
//        Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
//        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
//
//        trainingData.push_back(trainingBitmapToMat.reshape(1,1));
//        trainingLabels.add(2);
//
//        KNearest knn = KNearest.create();
//        knn.train(trainingData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainingLabels));
//
//        testingData = new Mat();
//        testingData.push_back(trainingBitmapToMat.reshape(1,1));

//        testLabels= new ArrayList<Integer>();
//        testLabels.add(2);


//        for (int i=0; i<testingData.rows(); i++)
//        {
//            Mat one_feature = testingData.row(i);
//            int testLabel = testLabels.get(i);
//
//            Mat res = new Mat();
//            float p = knn.findNearest(one_feature, 1, res);
//            resultOfMat.setText(testLabel + " " + p + " " + res.dump());
//        }





    }

    public void clickhere(View view) {
        //resultOfMat.setText(sourceImage.toString());
    }


}

//Set training image code
//myImageView = (ImageView) findViewById(R.id.myImgView);
//        myImageView.setImageBitmap(bitmap);