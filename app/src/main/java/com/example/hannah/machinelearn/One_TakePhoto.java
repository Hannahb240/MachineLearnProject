package com.example.hannah.machinelearn;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class One_TakePhoto extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Button takePhoto;
    Button retakePhoto;
    Button next;

    ImageView myImageView;
    //int typeOfTree;

    TextView takePhotoInstructions;
    TextView takePhotoInstructions2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_take_photo);

//        Bundle b = getIntent().getExtras();
//        typeOfTree = b.getInt("key");

        takePhotoInstructions = (TextView) findViewById(R.id.photoInstructions);
        takePhotoInstructions.setTextColor(Color.parseColor("#000000"));

        takePhotoInstructions2 = (TextView) findViewById(R.id.photoInstructions2);
        takePhotoInstructions2.setTextColor(Color.parseColor("#000000"));

//        switch(typeOfTree) {
//            case 1:
//                //lemon
//                takePhotoInstructions.setText("Take a photo of your partner pretending to reach up to get the fruit!");
//                break;
//            case 2:
//               //orange
//                takePhotoInstructions.setText("Take a photo of your partner pretending to jump up to reach the fruit!");
//                break;
//            case 3:
//                //apple
//                takePhotoInstructions.setText("Take a photo of your partner pretending to pick the fruit near to the ground");
//            case 4:
//                //pear
//                takePhotoInstructions.setText("Take a photo of your partner getting the fruit from the tree. Be creative with your ideas!");
//                break;
//        }

        //takePhotoInstructions.setText("Take a picture of your partner pretending to collect a lemon from the tree.");

        takePhotoInstructions2.setText("You're going to need to reach up high!");
        takePhotoInstructions2.setTextSize(20);
        takePhoto = (Button) findViewById(R.id.takePhoto);

        next = (Button) findViewById(R.id.nextButton);
        next.setVisibility(View.INVISIBLE);

        retakePhoto = (Button) findViewById(R.id.retakePhoto);
        retakePhoto.setVisibility(View.INVISIBLE);

        myImageView = (ImageView) findViewById(R.id.myImgView);

        //Photo code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());

    }

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            //Get the photo
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            myImageView.setImageBitmap(photo);
            retakePhoto.setVisibility(View.VISIBLE);
            next.setVisibility(View.VISIBLE);
            takePhoto.setVisibility(View.INVISIBLE);
            takePhotoInstructions.setText("If you're happy with your picture, tap next to go to the next page.");
            takePhotoInstructions.setTextSize(20);
            takePhotoInstructions2.setVisibility(View.INVISIBLE);
        }
    }

    public void goToResult(View view) {

        Button buttonPressed = (Button) findViewById(view.getId());
        String buttonText = buttonPressed.getText().toString();
        if(buttonText.equals("Next")) {
            Intent intent = new Intent(getApplicationContext(), One_ExplainTrainingData.class);
//            Bundle b = new Bundle();
//            b.putInt("key",typeOfTree);
//            intent.putExtras(b);
            startActivity(intent);
            this.finish();
        }



    }


}
