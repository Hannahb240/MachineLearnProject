package com.example.hannah.machinelearn;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.opencv.*;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.ml.KNearest;
import org.opencv.ml.Ml;

import java.io.IOException;
import java.io.InputStream;


public class Five_knn extends AppCompatActivity {

    Bitmap bitmap;
    Mat sourceImage;
    TextView resultOfMat;
    ImageView myImageView;


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_knn);
        resultOfMat = (TextView) findViewById(R.id.mattext);
        KNearest knn = KNearest.create();

        Bitmap bitmap = null;

        Drawable apple = getDrawable(R.drawable.apple);


        if (apple instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) apple;
            if (bitmapDrawable.getBitmap() != null) {
                bitmap = bitmapDrawable.getBitmap();
            }
        }

        if (apple.getIntrinsicWidth() <= 0 || apple.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888); // Single color bitmap will be created of 1x1 pixel
        } else {
            bitmap = Bitmap.createBitmap(apple.getIntrinsicWidth(), apple.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap);
        apple.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        apple.draw(canvas);

        myImageView = (ImageView) findViewById(R.id.myImgView);
        myImageView.setImageBitmap(bitmap);

        Mat sourceImage = new Mat();
        Utils.bitmapToMat(bitmap, sourceImage);

        resultOfMat.setText(sourceImage.dump());




        // knn.train(samples, Ml.ROW_SAMPLE, labels);


        //Obtain training image 3 - standing
//    AAsset *trainThree = AAssetManager_open(mgr, "stand3.JPG", AASSET_MODE_UNKNOWN);
//    long sizeOfTrainThree = AAsset_getLength(trainThree);
//    char *bufferTrainThree = (char *) AAsset_getBuffer(trainThree);
//    std::vector<char> trainThreeData(bufferTrainThree, bufferTrainThree + sizeOfTrainThree);
//    cv::Mat trainThreeMat = cv::imdecode(trainThreeData, IMREAD_UNCHANGED);
//    AAsset_close (trainThree);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    public void clickhere(View view) {
        resultOfMat.setText(sourceImage.toString());
    }


    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Five_knn Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
