package com.example.hannah.machinelearn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import org.opencv.android.Utils;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.ml.KNearest;
import org.opencv.ml.Ml;
import org.opencv.utils.Converters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hannah on 22/02/2018.
 */

public class knn {

    public static Bitmap retrain1;
    public static Bitmap retrain2;
    public static Bitmap retrain3;
    public static Bitmap retrain4;
    public static Bitmap retrain5;

    //Training data variables
    private static Bitmap trainingBitmap;
    private static Mat trainingBitmapToMat;

    //Training data matrix and list of corresponding labels
    private static Mat trainingData;
    private static List<Integer> trainingLabels;

    //Testing data variables
    private static Bitmap testingBitmap;
    private static Mat testingBitmapToMat;

    //Testing data matrix and list of corresponding labels
    private static Mat testingData;
    private static List<Integer> testLabels;

    private static KNearest knearestneighbor;
    private static Mat knnresult;

    //Labels
    private static final int standingLabel = 1;
    private static final int crouchingLabel = 2;
    private static final int lyingLabel = 3;

    private static String resultOfKnn;


    private static Context myContext;

    public knn (Context context)
    {
        myContext =context;
    }

    public static String doKnn(Bitmap photo){

        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels = new ArrayList<Integer>();
        knearestneighbor = KNearest.create();

        trainModel();
        testModel(photo);

        return resultOfKnn;

    }
    private static int id;
    public static void trainModel(){

        //Standing training data
        for (int x = 1; x <= 36; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("standing" + x, "drawable", myContext.getPackageName());

            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(standingLabel);
        }

        //Crouching training data
        for (int x = 1; x <= 36; x++) {

            //Find the training image id
            id = myContext.getResources().getIdentifier("crouching" + x, "drawable", myContext.getPackageName());
            //Change from drawable to bitmap, to Mat, to float Mat
            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);

            //Add training data
            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));

            //Add label
            trainingLabels.add(crouchingLabel);
        }

        //Lying training data
//        for (int x = 1; x <= 14; x++) {
//
//            //Find the training image id
//            id = myContext.getResources().getIdentifier("lying" + x, "drawable", myContext.getPackageName());
//            //Change from drawable to bitmap, to Mat, to float Mat
//            trainingBitmap = BitmapFactory.decodeResource(myContext.getResources(), id);
//            Utils.bitmapToMat(trainingBitmap, trainingBitmapToMat);
//            trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
//
//            //Add training data
//            trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
//
//            //Add label
//            trainingLabels.add(lyingLabel);
//        }

        knearestneighbor.train(trainingData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainingLabels));
    }

    public static void testModel(Bitmap photo){

        testingData = new Mat();
        testingBitmapToMat = new Mat();
        testLabels = new ArrayList<Integer>();
        knnresult = new Mat();

        //Resize the photo
        Bitmap sizeComparison = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.standing1);
        Bitmap resizedphoto = Bitmap.createScaledBitmap(photo, sizeComparison.getWidth(), sizeComparison.getHeight(), true);

        //Find test image and convert to bitmap float
        Utils.bitmapToMat(resizedphoto, testingBitmapToMat);
        testingBitmapToMat.convertTo(testingBitmapToMat, CvType.CV_32F);

        //Add test data to matrix
        testingData.push_back(testingBitmapToMat.reshape(1, 1));

        //Add label
        testLabels.add(standingLabel);

        //Getting a feature to test
        Mat one_feature = testingData.row(0);
        int testLabel = testLabels.get(0);
        float p = knearestneighbor.findNearest(one_feature, 3, knnresult);
        resultOfKnn = knnresult.dump();

        //resultOfMat.setText("Test label: " + testLabel + " p = " + p + " RESULT: " + knnresult.dump());
    }

    public static String trainAndDoKNNWithExtraData(int label, Bitmap testPhoto, Bitmap one, Bitmap two, Bitmap three, Bitmap four, Bitmap five){

        trainingBitmapToMat = new Mat();
        trainingData = new Mat();
        trainingLabels = new ArrayList<Integer>();
        knearestneighbor = KNearest.create();
        Bitmap resizedPhoto;
        Bitmap sizeComparison = BitmapFactory.decodeResource(myContext.getResources(), R.drawable.standing1);

        trainModel();

        //image one
        resizedPhoto = Bitmap.createScaledBitmap(one, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image two
        resizedPhoto = Bitmap.createScaledBitmap(two, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image three
        resizedPhoto = Bitmap.createScaledBitmap(three, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image four
        resizedPhoto = Bitmap.createScaledBitmap(four, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        //image five
        resizedPhoto = Bitmap.createScaledBitmap(five, sizeComparison.getWidth(), sizeComparison.getHeight(), true);
        Utils.bitmapToMat(resizedPhoto, trainingBitmapToMat);
        trainingBitmapToMat.convertTo(trainingBitmapToMat, CvType.CV_32F);
        trainingData.push_back(trainingBitmapToMat.reshape(1, 1));
        trainingLabels.add(label);

        testModel(testPhoto);

        return resultOfKnn;
    }
}
