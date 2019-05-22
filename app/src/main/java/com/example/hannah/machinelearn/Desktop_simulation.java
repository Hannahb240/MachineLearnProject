package com.example.hannah.machinelearn;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.*;

import java.util.ArrayList;

public class Desktop_simulation extends AppCompatActivity {

    ImageButton trainingPic1;
    ImageButton trainingPic1Below;

    ImageButton trainingPic2;
    ImageButton trainingPic2Below;

    ImageButton trainingPic3;
    ImageButton trainingPic3Below;

    ImageButton trainingPic4;
    ImageButton trainingPic4Below;

    ImageButton trainingPic6;
    ImageButton trainingPic6Below;

    ImageButton trainingPic7;
    ImageButton trainingPic7Below;

    ImageButton trainingPic8;
    ImageButton trainingPic8Below;

    ImageButton trainingPic9;
    ImageButton trainingPic9Below;

    ImageButton trainingPic11;
    ImageButton trainingPic11Below;

    ImageButton trainingPic12;
    ImageButton trainingPic12Below;

    ImageButton trainingPic13;
    ImageButton trainingPic13Below;

    ImageButton trainingPic14;
    ImageButton trainingPic14Below;

    ImageButton trainingPic17;
    ImageButton trainingPic17Below;

    ImageButton trainingPic18;
    ImageButton trainingPic18Below;

    ImageButton trainingPic19;
    ImageButton trainingPic19Below;

    ImageButton trainingPic20;
    ImageButton trainingPic20Below;

    Map<String, Boolean> trainingPicClicked;

    ImageView myImageView;

    ArrayList<ImageButton> trainingPicButtons;
    ArrayList<ImageButton> trainingPicBelowButtons;

    int imageCount;

    TextView crouchLabel;
    TextView standingLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_simulation);

        myImageView = (ImageView) findViewById(R.id.myImgView);

        crouchLabel = (TextView) findViewById(R.id.crouchLabel);
        standingLabel = (TextView) findViewById(R.id.standingLabel);

        crouchLabel.setText("Reaching up");
        standingLabel.setText("Crouching");

        imageCount = 0;

        trainingPicButtons = new ArrayList();
        trainingPicBelowButtons = new ArrayList();

        trainingPicClicked = new HashMap<>();

        setTrainingPics();
        setInitialInvisibility();
        initialiseBooleans();
        setOnClickListeners();
}


    public void resetTrainingImages(View view) {

        for(ImageButton trainingPic : trainingPicButtons)
        {
            trainingPic.setVisibility(View.VISIBLE);
        }

        for(ImageButton trainingPic : trainingPicBelowButtons)
        {
            trainingPic.setVisibility(View.INVISIBLE);
        }

    }

    public void setInitialInvisibility() {

        for(ImageButton trainingPic : trainingPicBelowButtons)
        {
            trainingPic.setVisibility(View.INVISIBLE);
        }
    }

    public void addNewTestingImage(View view) {
        switch (imageCount) {
            case 0:
                myImageView.setImageResource(R.drawable.changetogrid1);
                break;
            case 1:
                myImageView.setImageResource(R.drawable.changetogrid2);
                break;
            case 2:
                myImageView.setImageResource(R.drawable.changetogrid3);
                break;
            case 3:
                myImageView.setImageResource(R.drawable.changetogrid4);
                break;
        }
        imageCount++;
    }

    public void changeToGrid(View view) {
        switch (imageCount) {
            case 1:
                myImageView.setImageResource(R.drawable.changetogrid1grid);
                break;
            case 2:
                myImageView.setImageResource(R.drawable.changetogrid2grid);
                break;
            case 3:
                myImageView.setImageResource(R.drawable.changetogrid3grid);
                break;
            case 4:
                myImageView.setImageResource(R.drawable.changetogrid4grid);
                break;
        }
    }


    private void initialiseBooleans() {

        for (int i = 1; i <= 20; i++) {
            trainingPicClicked.put("trainingPic" + i + "Clicked", false);
        }
    }

    private ImageButton initialiseTrainingPicture(ImageButton trainingPic, int indexOfPicture) {

        int trainingPictureResId = getTrainingPictureResID(indexOfPicture);
        trainingPic = (ImageButton) findViewById(trainingPictureResId);
        return trainingPic;
    }

    private ImageButton initialiseTrainingPictureBelow(ImageButton trainingPicBelow, int indexOfPicture) {

        int trainingPictureBelowResId = getTrainingPictureBelowResID(indexOfPicture);
        trainingPicBelow = (ImageButton) findViewById(trainingPictureBelowResId);
        return trainingPicBelow;
    }

      private int getTrainingPictureResID(int indexOfPicture) {
          return  getResources().getIdentifier("trainingpic"
                  + indexOfPicture, "id", getPackageName());

      }

      private int getTrainingPictureBelowResID(int indexOfPicture) {
          return getResources().getIdentifier("trainingpic"
                + indexOfPicture + "below", "id", getPackageName());

      }

    private int getGridPictureID(int indexOfGrid) {

        if(indexOfGrid == 17){
            indexOfGrid = 5;
        }
        else if(indexOfGrid == 18){
            indexOfGrid = 6;
        }
        else if(indexOfGrid == 19){
            indexOfGrid = 7;
        }
        else if(indexOfGrid == 20){
            indexOfGrid = 8;
        }
        return getResources().getIdentifier("grid"+indexOfGrid, "drawable", getPackageName());
    }


    class OnClickListenerId {

        int trainingPictureId;
        int gridPictureId;
        String trianingPictureClickedText;

        public OnClickListenerId(int index) {

            trainingPictureId = getTrainingPictureResID(index);
            gridPictureId = getGridPictureID(index);
            trianingPictureClickedText = "trainingPic" + index + "Clicked";
        }

        public int getTrainingPictureId() {
            return trainingPictureId;
        }

        public String getTrainingPictureClickedText() {
            return trianingPictureClickedText;
        }

        public int getGridPictureId() {
            return gridPictureId;
        }
    }


    private void buttonClicked(int trainingPictureId, int gridPictureId, String trainingPictureClickedText, ImageButton trainingPicture, ImageButton trainingPictureBelow) {
            // on first click, change to new image.
            if (!(trainingPicClicked.get(trainingPictureClickedText))) {
                findViewById(trainingPictureId).setBackgroundResource(gridPictureId);
                trainingPicClicked.put(trainingPictureClickedText, true);
            }

            //move on second click
            else if (trainingPicClicked.get(trainingPictureClickedText)) {
                trainingPicture.setVisibility(View.INVISIBLE);
                trainingPictureBelow.setVisibility(View.VISIBLE);
            }
    }

    class ButtonClick implements View.OnClickListener {

        int trainingPictureId;
        int gridPictureId;
        String trainingPictureClickedText;
        ImageButton trainingPicture;
        ImageButton trainingPictureBelow;


        public ButtonClick(int trainingPictureId, int gridPictureId, String trainingPictureClickedText, ImageButton trainingPicture, ImageButton trainingPictureBelow) {
            this.trainingPictureId = trainingPictureId;
            this.gridPictureId = gridPictureId;
            this.trainingPicture = trainingPicture;
            this.trainingPictureBelow = trainingPictureBelow;
            this.trainingPictureClickedText = trainingPictureClickedText;
        }

        @Override
        public void onClick(View v) {
            buttonClicked(trainingPictureId, gridPictureId, trainingPictureClickedText, trainingPicture, trainingPictureBelow);
        }
    }

     class TrainingPictureBelowListener implements View.OnClickListener {

        ImageButton trainingPicture;
        ImageButton trainingPictureBelow;

        public TrainingPictureBelowListener(ImageButton trainingPicture, ImageButton trainingPictureBelow){
            this.trainingPicture = trainingPicture;
            this.trainingPictureBelow = trainingPictureBelow;
        }

        @Override
        public void onClick(View v) {
            trainingPictureBelowClicked(trainingPicture, trainingPictureBelow);
        }

    }

    private void trainingPictureBelowClicked(ImageButton trainingPicture, ImageButton trainingPictureBelow) {
        trainingPicture.setVisibility(View.VISIBLE);
        trainingPictureBelow.setVisibility(View.INVISIBLE);
    }

    private void setOnClickListeners() {

        OnClickListenerId listenerIds1 = new OnClickListenerId(1);
        trainingPic1.setOnClickListener(new ButtonClick(listenerIds1.getTrainingPictureId(),
                listenerIds1.getGridPictureId(), listenerIds1.getTrainingPictureClickedText(), trainingPic1, trainingPic1Below));

        trainingPic1Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic1, trainingPic1Below));

        OnClickListenerId listenerIds2 = new OnClickListenerId(2);
        trainingPic2.setOnClickListener(new ButtonClick(listenerIds2.getTrainingPictureId(),
                listenerIds2.getGridPictureId(), listenerIds2.getTrainingPictureClickedText(), trainingPic2, trainingPic2Below));

        trainingPic2Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic2, trainingPic2Below));

        OnClickListenerId listenerIds3 = new OnClickListenerId(3);
        trainingPic3.setOnClickListener(new ButtonClick(listenerIds3.getTrainingPictureId(),
                listenerIds3.getGridPictureId(), listenerIds3.getTrainingPictureClickedText(), trainingPic3, trainingPic3Below));

        trainingPic3Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic3, trainingPic3Below));

        OnClickListenerId listenerIds4 = new OnClickListenerId(4);
        trainingPic4.setOnClickListener(new ButtonClick(listenerIds4.getTrainingPictureId(),
                listenerIds4.getGridPictureId(), listenerIds4.getTrainingPictureClickedText(), trainingPic4, trainingPic4Below));

        trainingPic4Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic4, trainingPic4Below));

        OnClickListenerId listenerIds6 = new OnClickListenerId(6);
        trainingPic6.setOnClickListener(new ButtonClick(listenerIds6.getTrainingPictureId(),
                listenerIds6.getGridPictureId(), listenerIds6.getTrainingPictureClickedText(), trainingPic6, trainingPic6Below));

        trainingPic6Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic6, trainingPic6Below));

        OnClickListenerId listenerIds7 = new OnClickListenerId(7);
        trainingPic7.setOnClickListener(new ButtonClick(listenerIds7.getTrainingPictureId(),
                listenerIds7.getGridPictureId(), listenerIds7.getTrainingPictureClickedText(), trainingPic7, trainingPic7Below));

        trainingPic7Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic7, trainingPic7Below));

        OnClickListenerId listenerIds8 = new OnClickListenerId(8);
        trainingPic8.setOnClickListener(new ButtonClick(listenerIds8.getTrainingPictureId(),
                listenerIds8.getGridPictureId(), listenerIds8.getTrainingPictureClickedText(), trainingPic8, trainingPic8Below));

        trainingPic8Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic8, trainingPic8Below));

        OnClickListenerId listenerIds9 = new OnClickListenerId(9);
        trainingPic9.setOnClickListener(new ButtonClick(listenerIds9.getTrainingPictureId(),
                listenerIds9.getGridPictureId(), listenerIds9.getTrainingPictureClickedText(), trainingPic9, trainingPic9Below));

        trainingPic9Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic9, trainingPic9Below));

        OnClickListenerId listenerIds11 = new OnClickListenerId(11);
        trainingPic11.setOnClickListener(new ButtonClick(listenerIds11.getTrainingPictureId(),
                listenerIds11.getGridPictureId(), listenerIds11.getTrainingPictureClickedText(), trainingPic11, trainingPic11Below));

        trainingPic11Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic11, trainingPic11Below));

        OnClickListenerId listenerIds12 = new OnClickListenerId(12);
        trainingPic12.setOnClickListener(new ButtonClick(listenerIds12.getTrainingPictureId(),
                listenerIds12.getGridPictureId(), listenerIds12.getTrainingPictureClickedText(), trainingPic12, trainingPic12Below));

        trainingPic12Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic12, trainingPic12Below));

        OnClickListenerId listenerIds13 = new OnClickListenerId(13);
        trainingPic13.setOnClickListener(new ButtonClick(listenerIds13.getTrainingPictureId(),
                listenerIds13.getGridPictureId(), listenerIds13.getTrainingPictureClickedText(), trainingPic13, trainingPic13Below));

        trainingPic13Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic13, trainingPic13Below));

        OnClickListenerId listenerIds14 = new OnClickListenerId(14);
        trainingPic14.setOnClickListener(new ButtonClick(listenerIds14.getTrainingPictureId(),
                listenerIds14.getGridPictureId(), listenerIds14.getTrainingPictureClickedText(), trainingPic14, trainingPic14Below));

        trainingPic14Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic14, trainingPic14Below));

        OnClickListenerId listenerIds17 = new OnClickListenerId(17);
        trainingPic17.setOnClickListener(new ButtonClick(listenerIds17.getTrainingPictureId(),
                listenerIds17.getGridPictureId(), listenerIds17.getTrainingPictureClickedText(), trainingPic17, trainingPic17Below));

        trainingPic17Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic17, trainingPic17Below));

        OnClickListenerId listenerIds18 = new OnClickListenerId(18);
        trainingPic18.setOnClickListener(new ButtonClick(listenerIds18.getTrainingPictureId(),
                listenerIds18.getGridPictureId(), listenerIds18.getTrainingPictureClickedText(), trainingPic18, trainingPic18Below));

        trainingPic18Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic18, trainingPic18Below));

        OnClickListenerId listenerIds19 = new OnClickListenerId(19);
        trainingPic19.setOnClickListener(new ButtonClick(listenerIds19.getTrainingPictureId(),
                listenerIds19.getGridPictureId(), listenerIds19.getTrainingPictureClickedText(), trainingPic19, trainingPic19Below));

        trainingPic19Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic19, trainingPic19Below));

        OnClickListenerId listenerIds20 = new OnClickListenerId(20);
        trainingPic20.setOnClickListener(new ButtonClick(listenerIds20.getTrainingPictureId(),
                listenerIds20.getGridPictureId(), listenerIds20.getTrainingPictureClickedText(), trainingPic20, trainingPic20Below));

        trainingPic20Below.setOnClickListener(new TrainingPictureBelowListener(trainingPic20, trainingPic20Below));

    }

    private void setTrainingPics() {

        trainingPic1 = initialiseTrainingPicture(trainingPic1, 1);
        trainingPic1Below = initialiseTrainingPictureBelow(trainingPic1Below, 1);
        trainingPicButtons.add(trainingPic1);
        trainingPicBelowButtons.add(trainingPic1Below);

        trainingPic2 = initialiseTrainingPicture(trainingPic2, 2);
        trainingPic2Below = initialiseTrainingPictureBelow(trainingPic2Below, 2);
        trainingPicButtons.add(trainingPic2);
        trainingPicBelowButtons.add(trainingPic2Below);

        trainingPic3 = initialiseTrainingPicture(trainingPic3, 3);
        trainingPic3Below = initialiseTrainingPictureBelow(trainingPic3Below, 3);
        trainingPicButtons.add(trainingPic3);
        trainingPicBelowButtons.add(trainingPic3Below);

        trainingPic4 = initialiseTrainingPicture(trainingPic4, 4);
        trainingPic4Below = initialiseTrainingPictureBelow(trainingPic4Below, 4);
        trainingPicButtons.add(trainingPic4);
        trainingPicBelowButtons.add(trainingPic4Below);

        trainingPic6 = initialiseTrainingPicture(trainingPic6, 6);
        trainingPic6Below = initialiseTrainingPictureBelow(trainingPic6Below, 6);
        trainingPicButtons.add(trainingPic6);
        trainingPicBelowButtons.add(trainingPic6Below);

        trainingPic7 = initialiseTrainingPicture(trainingPic7, 7);
        trainingPic7Below = initialiseTrainingPictureBelow(trainingPic7Below, 7);
        trainingPicButtons.add(trainingPic7);
        trainingPicBelowButtons.add(trainingPic7Below);

        trainingPic8 = initialiseTrainingPicture(trainingPic8, 8);
        trainingPic8Below = initialiseTrainingPictureBelow(trainingPic8Below, 8);
        trainingPicButtons.add(trainingPic8);
        trainingPicBelowButtons.add(trainingPic8Below);

        trainingPic9 = initialiseTrainingPicture(trainingPic9, 9);
        trainingPic9Below = initialiseTrainingPictureBelow(trainingPic9Below, 9);
        trainingPicButtons.add(trainingPic9);
        trainingPicBelowButtons.add(trainingPic9Below);

        trainingPic11 = initialiseTrainingPicture(trainingPic11, 11);
        trainingPic11Below = initialiseTrainingPictureBelow(trainingPic11Below, 11);
        trainingPicButtons.add(trainingPic11);
        trainingPicBelowButtons.add(trainingPic11Below);

        trainingPic12 = initialiseTrainingPicture(trainingPic12, 12);
        trainingPic12Below = initialiseTrainingPictureBelow(trainingPic12Below, 12);
        trainingPicButtons.add(trainingPic12);
        trainingPicBelowButtons.add(trainingPic12Below);

        trainingPic13 = initialiseTrainingPicture(trainingPic13, 13);
        trainingPic13Below = initialiseTrainingPictureBelow(trainingPic13Below, 13);
        trainingPicButtons.add(trainingPic13);
        trainingPicBelowButtons.add(trainingPic13Below);

        trainingPic14 = initialiseTrainingPicture(trainingPic14, 14);
        trainingPic14Below = initialiseTrainingPictureBelow(trainingPic14Below, 14);
        trainingPicButtons.add(trainingPic14);
        trainingPicBelowButtons.add(trainingPic14Below);

        trainingPic17 = initialiseTrainingPicture(trainingPic17, 17);
        trainingPic17Below = initialiseTrainingPictureBelow(trainingPic17Below, 17);
        trainingPicButtons.add(trainingPic17);
        trainingPicBelowButtons.add(trainingPic17Below);

        trainingPic18 = initialiseTrainingPicture(trainingPic18, 18);
        trainingPic18Below = initialiseTrainingPictureBelow(trainingPic18Below, 18);
        trainingPicButtons.add(trainingPic18);
        trainingPicBelowButtons.add(trainingPic18Below);

        trainingPic19 = initialiseTrainingPicture(trainingPic19, 19);
        trainingPic19Below = initialiseTrainingPictureBelow(trainingPic19Below, 19);
        trainingPicButtons.add(trainingPic19);
        trainingPicBelowButtons.add(trainingPic19Below);

        trainingPic20 = initialiseTrainingPicture(trainingPic20, 20);
        trainingPic20Below = initialiseTrainingPictureBelow(trainingPic20Below, 20);
        trainingPicButtons.add(trainingPic20);
        trainingPicBelowButtons.add(trainingPic20Below);
    }


}