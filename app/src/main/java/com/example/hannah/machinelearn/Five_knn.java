package com.example.hannah.machinelearn;

import android.graphics.Bitmap;
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

    Bitmap bitmap;
    Mat sourceImage;
    TextView resultOfMat;
    ImageView myImageView;
    ImageView myImageView2;
    Mat trainData;
    List<Integer> trainLabels;
    List<Integer> testLabels;


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_knn);

        resultOfMat = (TextView) findViewById(R.id.mattext);

        //Apple
        Bitmap bitmap;
        Drawable apple = getDrawable(R.drawable.person1);

        BitmapDrawable bitmapDrawable = (BitmapDrawable) apple;
        bitmap = bitmapDrawable.getBitmap();

        myImageView = (ImageView) findViewById(R.id.myImgView);
        myImageView.setImageBitmap(bitmap);

        Mat sourceImage = new Mat();
        Utils.bitmapToMat(bitmap, sourceImage);

        sourceImage.convertTo(sourceImage, CvType.CV_32F);
        trainData = new Mat();
        trainData.push_back(sourceImage.reshape(1,1));

        trainLabels= new ArrayList<Integer>();
        trainLabels.add(1);


        //pear
        Bitmap bitmap2;
        Drawable pear = getDrawable(R.drawable.person2);

        BitmapDrawable bitmapDrawable2 = (BitmapDrawable) pear;
        bitmap2 = bitmapDrawable2.getBitmap();

        myImageView2 = (ImageView) findViewById(R.id.myImgView2);
        myImageView2.setImageBitmap(bitmap2);

        Mat sourceImage2 = new Mat();
        Utils.bitmapToMat(bitmap2, sourceImage2);

        sourceImage2.convertTo(sourceImage2, CvType.CV_32F);


        trainData.push_back(sourceImage2.reshape(1,1));
        trainLabels.add(2);

        KNearest knn = KNearest.create();
        knn.train(trainData, Ml.ROW_SAMPLE, Converters.vector_int_to_Mat(trainLabels));


        Mat testData = new Mat();
        testData.push_back(sourceImage2.reshape(1,1));

        testLabels= new ArrayList<Integer>();
        testLabels.add(2);


        for (int i=0; i<testData.rows(); i++)
        {
            Mat one_feature = testData.row(i);
            int testLabel = testLabels.get(i);

            Mat res = new Mat();
            float p = knn.findNearest(one_feature, 1, res);
            resultOfMat.setText(testLabel + " " + p + " " + res.dump());

        }





    }

    public void clickhere(View view) {
        resultOfMat.setText(sourceImage.toString());
    }


}
