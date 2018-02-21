package com.example.hannah.machinelearn;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

    //Training data matrix and list of corresponding labels
    Mat trainingData;
    List<Integer> trainingLabels;

    //Testing data variables
    Bitmap testingBitmap;
    Mat testingBitmapToMat;

    //Testing data matrix and list of corresponding labels
    Mat testingData;
    List<Integer> testLabels;

    //Labels
    private static final int standingLabel = 1;
    private static final int crouchingLabel = 2;
    private static final int lyingLabel = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_knn);

        //Display result
        resultOfMat = (TextView) findViewById(R.id.mattext);

        //TRAINING ////////////////////////////////////////////////////////////////////////////////////////////////

        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels = new ArrayList<Integer>();

        //Standing training data
        for (int x = 0; x <= 2; x++) {

            //Find the training image id
            int id = getResources().getIdentifier("standing" + x, "drawable", getPackageName());
            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(standingLabel);
        }

        //Crouching training data
        for (int x = 0; x <= 1; x++) {

            //Find the training image id
            int id = getResources().getIdentifier("crouching" + x, "drawable", getPackageName());
            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(crouchingLabel);
        }

        //Lying training data
        for (int x = 0; x <= 1; x++) {

            //Find the training image id
            int id = getResources().getIdentifier("lying" + x, "drawable", getPackageName());
            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(lyingLabel);
        }

        KNearest knn = KNearest.create();
        knn.train(trainingData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainingLabels));

        //TESTING ////////////////////////////////////////////////////////////////////////////////////////////////

        testingData = new Mat();
        testingBitmapToMat = new Mat();
        testLabels = new ArrayList<Integer>();
        Mat result = new Mat();


        //Find test image and convert to bitmap float
        testingBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.standtest1);
        Utils.bitmapToMat(testingBitmap, testingBitmapToMat);
        testingBitmapToMat.convertTo(testingBitmapToMat, CvType.CV_32F);

        //Add test data to matrix
        testingData.push_back(testingBitmapToMat.reshape(1, 1));

        //Add label
        testLabels.add(standingLabel);

        //Getting a feature to test
        Mat one_feature = testingData.row(0);
        int testLabel = testLabels.get(0);

        //Testing
        float p = knn.findNearest(one_feature, 3, result);
        resultOfMat.setText("Test label: " + testLabel + " p = " + p + " RESULT: " + result.dump());
    }
}