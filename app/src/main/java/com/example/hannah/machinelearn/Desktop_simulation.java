package com.example.hannah.machinelearn;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

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

    ImageButton trainingPic5;
    ImageButton trainingPic5Below;

    ImageButton trainingPic6;
    ImageButton trainingPic6Below;

    ImageButton trainingPic7;
    ImageButton trainingPic7Below;

    ImageButton trainingPic8;
    ImageButton trainingPic8Below;

    ImageButton trainingPic9;
    ImageButton trainingPic9Below;

    ImageButton trainingPic10;
    ImageButton trainingPic10Below;

    ImageButton trainingPic11;
    ImageButton trainingPic11Below;

    ImageButton trainingPic12;
    ImageButton trainingPic12Below;

    ImageButton trainingPic13;
    ImageButton trainingPic13Below;

    ImageButton trainingPic14;
    ImageButton trainingPic14Below;

    ImageButton trainingPic15;
    ImageButton trainingPic15Below;

    ImageButton trainingPic16;
    ImageButton trainingPic16Below;

    ImageButton trainingPic17;
    ImageButton trainingPic17Below;

    ImageButton trainingPic18;
    ImageButton trainingPic18Below;

    ImageButton trainingPic19;
    ImageButton trainingPic19Below;

    ImageButton trainingPic20;
    ImageButton trainingPic20Below;

    ImageView myImageView;
    ArrayList<ImageButton> trainingPicButtons;
    ArrayList<ImageButton> trainingPicBelowButtons;
    int imageCount;


    boolean trainingPic1Clicked = false;
    boolean trainingPic2Clicked = false;
    boolean trainingPic3Clicked = false;
    boolean trainingPic4Clicked = false;
    boolean trainingPic5Clicked = false;
    boolean trainingPic6Clicked = false;
    boolean trainingPic7Clicked = false;
    boolean trainingPic8Clicked = false;
    boolean trainingPic9Clicked = false;
    boolean trainingPic10Clicked = false;
    boolean trainingPic11Clicked = false;
    boolean trainingPic12Clicked = false;
    boolean trainingPic13Clicked = false;
    boolean trainingPic14Clicked = false;
    boolean trainingPic15Clicked = false;
    boolean trainingPic16Clicked = false;
    boolean trainingPic17Clicked = false;
    boolean trainingPic18Clicked = false;
    boolean trainingPic19Clicked = false;
    boolean trainingPic20Clicked = false;

    TextView crouchLabel;
    TextView standingLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desktop_simulation);

        myImageView = (ImageView) findViewById(R.id.myImgView);
        myImageView.setImageResource(R.drawable.egg);

        crouchLabel = (TextView) findViewById(R.id.crouchLabel);
        standingLabel = (TextView) findViewById(R.id.standingLabel);

        crouchLabel.setText("Crouching");
        standingLabel.setText("Standing");

        imageCount = 0;

        trainingPicButtons = new ArrayList<ImageButton>();
        trainingPicBelowButtons = new ArrayList<ImageButton>();

        trainingPic1Below = (ImageButton) findViewById(R.id.trainingpic1below);
        trainingPic1Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic1);
        trainingPicBelowButtons.add(trainingPic1Below);


        trainingPic2Below = (ImageButton) findViewById(R.id.trainingpic2below);
        trainingPic2Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic2);
        trainingPicBelowButtons.add(trainingPic2Below);

        trainingPic3Below = (ImageButton) findViewById(R.id.trainingpic3below);
        trainingPic3Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic3);
        trainingPicBelowButtons.add(trainingPic3Below);

        trainingPic4Below = (ImageButton) findViewById(R.id.trainingpic4below);
        trainingPic4Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic4);
        trainingPicBelowButtons.add(trainingPic4Below);

        trainingPic5Below = (ImageButton) findViewById(R.id.trainingpic5below);
        trainingPic5Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic5);
        trainingPicBelowButtons.add(trainingPic5Below);

        trainingPic6Below = (ImageButton) findViewById(R.id.trainingpic6below);
        trainingPic6Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic6);
        trainingPicBelowButtons.add(trainingPic6Below);

        trainingPic7Below = (ImageButton) findViewById(R.id.trainingpic7below);
        trainingPic7Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic7);
        trainingPicBelowButtons.add(trainingPic7Below);

        trainingPic8Below = (ImageButton) findViewById(R.id.trainingpic8below);
        trainingPic8Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic8);
        trainingPicBelowButtons.add(trainingPic8Below);

        trainingPic9Below = (ImageButton) findViewById(R.id.trainingpic9below);
        trainingPic9Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic9);
        trainingPicBelowButtons.add(trainingPic9Below);

        trainingPic10Below = (ImageButton) findViewById(R.id.trainingpic10below);
        trainingPic10Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic10);
        trainingPicBelowButtons.add(trainingPic10Below);

        trainingPic11Below = (ImageButton) findViewById(R.id.trainingpic11below);
        trainingPic11Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic11);
        trainingPicBelowButtons.add(trainingPic11Below);

        trainingPic12Below = (ImageButton) findViewById(R.id.trainingpic12below);
        trainingPic12Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic12);
        trainingPicBelowButtons.add(trainingPic12Below);

        trainingPic13Below = (ImageButton) findViewById(R.id.trainingpic13below);
        trainingPic13Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic13);
        trainingPicBelowButtons.add(trainingPic13Below);

        trainingPic14Below = (ImageButton) findViewById(R.id.trainingpic14below);
        trainingPic14Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic14);
        trainingPicBelowButtons.add(trainingPic14Below);

        trainingPic15Below = (ImageButton) findViewById(R.id.trainingpic15below);
        trainingPic15Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic15);
        trainingPicBelowButtons.add(trainingPic15Below);

        trainingPic16Below = (ImageButton) findViewById(R.id.trainingpic16below);
        trainingPic16Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic16);
        trainingPicBelowButtons.add(trainingPic16Below);

        trainingPic17Below = (ImageButton) findViewById(R.id.trainingpic17below);
        trainingPic17Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic17);
        trainingPicBelowButtons.add(trainingPic17Below);

        trainingPic18Below = (ImageButton) findViewById(R.id.trainingpic18below);
        trainingPic18Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic18);
        trainingPicBelowButtons.add(trainingPic18Below);

        trainingPic19Below = (ImageButton) findViewById(R.id.trainingpic19below);
        trainingPic19Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic19);
        trainingPicBelowButtons.add(trainingPic19Below);

        trainingPic20Below = (ImageButton) findViewById(R.id.trainingpic20below);
        trainingPic20Below.setVisibility(View.INVISIBLE);
        trainingPicButtons.add(trainingPic20);
        trainingPicBelowButtons.add(trainingPic20Below);


        //TRAINING PIC 1 ////////////////////////////////////////////////////////////////////////
        trainingPic1 = (ImageButton) findViewById(R.id.trainingpic1);
        trainingPic1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic1Clicked) {
                    findViewById(R.id.trainingpic1).setBackgroundResource(R.drawable.peartree);
                    trainingPic1Clicked = true;
                }

                //move on second click
                else if(trainingPic1Clicked){
                    trainingPic1.setVisibility(View.INVISIBLE);
                    trainingPic1Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic1Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic1.setVisibility(View.VISIBLE);
                trainingPic1Below.setVisibility(View.INVISIBLE);
            }
        });


        //TRAINING PIC 2 ////////////////////////////////////////////////////////////////////////
        trainingPic2 = (ImageButton) findViewById(R.id.trainingpic2);
        trainingPic2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic2Clicked) {
                    findViewById(R.id.trainingpic2).setBackgroundResource(R.drawable.peartree);
                    trainingPic2Clicked = true;
                }

                //move on second click
                else if(trainingPic2Clicked){
                    trainingPic2.setVisibility(View.INVISIBLE);
                    trainingPic2Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic2Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic2.setVisibility(View.VISIBLE);
                trainingPic2Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 3 ////////////////////////////////////////////////////////////////////////
        trainingPic3 = (ImageButton) findViewById(R.id.trainingpic3);
        trainingPic3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic3Clicked) {
                    findViewById(R.id.trainingpic3).setBackgroundResource(R.drawable.peartree);
                    trainingPic3Clicked = true;
                }

                //move on second click
                else if(trainingPic3Clicked){
                    trainingPic3.setVisibility(View.INVISIBLE);
                    trainingPic3Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic3Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic3.setVisibility(View.VISIBLE);
                trainingPic3Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 4 ////////////////////////////////////////////////////////////////////////
        trainingPic4 = (ImageButton) findViewById(R.id.trainingpic4);
        trainingPic4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic4Clicked) {
                    findViewById(R.id.trainingpic4).setBackgroundResource(R.drawable.peartree);
                    trainingPic4Clicked = true;
                }

                //move on second click
                else if(trainingPic4Clicked){
                    trainingPic4.setVisibility(View.INVISIBLE);
                    trainingPic4Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic4Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic4.setVisibility(View.VISIBLE);
                trainingPic4Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 5 ////////////////////////////////////////////////////////////////////////
        trainingPic5 = (ImageButton) findViewById(R.id.trainingpic5);
        trainingPic5.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic5Clicked) {
                    findViewById(R.id.trainingpic5).setBackgroundResource(R.drawable.peartree);
                    trainingPic5Clicked = true;
                }

                //move on second click
                else if(trainingPic5Clicked){
                    trainingPic5.setVisibility(View.INVISIBLE);
                    trainingPic5Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic5Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic5.setVisibility(View.VISIBLE);
                trainingPic5Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 6 ////////////////////////////////////////////////////////////////////////
        trainingPic6 = (ImageButton) findViewById(R.id.trainingpic6);
        trainingPic6.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic6Clicked) {
                    findViewById(R.id.trainingpic6).setBackgroundResource(R.drawable.peartree);
                    trainingPic6Clicked = true;
                }

                //move on second click
                else if(trainingPic6Clicked){
                    trainingPic6.setVisibility(View.INVISIBLE);
                    trainingPic6Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic6Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic6.setVisibility(View.VISIBLE);
                trainingPic6Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 7 ////////////////////////////////////////////////////////////////////////
        trainingPic7 = (ImageButton) findViewById(R.id.trainingpic7);
        trainingPic7.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic7Clicked) {
                    findViewById(R.id.trainingpic7).setBackgroundResource(R.drawable.peartree);
                    trainingPic7Clicked = true;
                }

                //move on second click
                else if(trainingPic7Clicked){
                    trainingPic7.setVisibility(View.INVISIBLE);
                    trainingPic7Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic7Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic7.setVisibility(View.VISIBLE);
                trainingPic7Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 8////////////////////////////////////////////////////////////////////////
        trainingPic8 = (ImageButton) findViewById(R.id.trainingpic8);
        trainingPic8.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic8Clicked) {
                    findViewById(R.id.trainingpic8).setBackgroundResource(R.drawable.peartree);
                    trainingPic8Clicked = true;
                }

                //move on second click
                else if(trainingPic8Clicked){
                    trainingPic8.setVisibility(View.INVISIBLE);
                    trainingPic8Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic8Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic8.setVisibility(View.VISIBLE);
                trainingPic8Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 9////////////////////////////////////////////////////////////////////////
        trainingPic9 = (ImageButton) findViewById(R.id.trainingpic9);
        trainingPic9.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic9Clicked) {
                    findViewById(R.id.trainingpic9).setBackgroundResource(R.drawable.peartree);
                    trainingPic9Clicked = true;
                }

                //move on second click
                else if(trainingPic9Clicked){
                    trainingPic9.setVisibility(View.INVISIBLE);
                    trainingPic9Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic9Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic9.setVisibility(View.VISIBLE);
                trainingPic9Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 10////////////////////////////////////////////////////////////////////////
        trainingPic10 = (ImageButton) findViewById(R.id.trainingpic10);
        trainingPic10.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic10Clicked) {
                    findViewById(R.id.trainingpic10).setBackgroundResource(R.drawable.peartree);
                    trainingPic10Clicked = true;
                }

                //move on second click
                else if(trainingPic10Clicked){
                    trainingPic10.setVisibility(View.INVISIBLE);
                    trainingPic10Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic10Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic10.setVisibility(View.VISIBLE);
                trainingPic10Below.setVisibility(View.INVISIBLE);
            }
        });


        //TRAINING PIC 11////////////////////////////////////////////////////////////////////////
        trainingPic11 = (ImageButton) findViewById(R.id.trainingpic11);
        trainingPic11.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic11Clicked) {
                    findViewById(R.id.trainingpic11).setBackgroundResource(R.drawable.peartree);
                    trainingPic11Clicked = true;
                }

                //move on second click
                else if(trainingPic11Clicked){
                    trainingPic11.setVisibility(View.INVISIBLE);
                    trainingPic11Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic11Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic11.setVisibility(View.VISIBLE);
                trainingPic11Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 12////////////////////////////////////////////////////////////////////////
        trainingPic12 = (ImageButton) findViewById(R.id.trainingpic12);
        trainingPic12.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic12Clicked) {
                    findViewById(R.id.trainingpic12).setBackgroundResource(R.drawable.peartree);
                    trainingPic12Clicked = true;
                }

                //move on second click
                else if(trainingPic12Clicked){
                    trainingPic12.setVisibility(View.INVISIBLE);
                    trainingPic12Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic12Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic12.setVisibility(View.VISIBLE);
                trainingPic12Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 13////////////////////////////////////////////////////////////////////////
        trainingPic13 = (ImageButton) findViewById(R.id.trainingpic13);
        trainingPic13.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic13Clicked) {
                    findViewById(R.id.trainingpic13).setBackgroundResource(R.drawable.peartree);
                    trainingPic13Clicked = true;
                }

                //move on second click
                else if(trainingPic13Clicked){
                    trainingPic13.setVisibility(View.INVISIBLE);
                    trainingPic13Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic13Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic13.setVisibility(View.VISIBLE);
                trainingPic13Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 14////////////////////////////////////////////////////////////////////////
        trainingPic14 = (ImageButton) findViewById(R.id.trainingpic14);
        trainingPic14.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic14Clicked) {
                    findViewById(R.id.trainingpic14).setBackgroundResource(R.drawable.peartree);
                    trainingPic14Clicked = true;
                }

                //move on second click
                else if(trainingPic14Clicked){
                    trainingPic14.setVisibility(View.INVISIBLE);
                    trainingPic14Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic14Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic14.setVisibility(View.VISIBLE);
                trainingPic14Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 15////////////////////////////////////////////////////////////////////////
        trainingPic15 = (ImageButton) findViewById(R.id.trainingpic15);
        trainingPic15.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic15Clicked) {
                    findViewById(R.id.trainingpic15).setBackgroundResource(R.drawable.peartree);
                    trainingPic15Clicked = true;
                }

                //move on second click
                else if(trainingPic15Clicked){
                    trainingPic15.setVisibility(View.INVISIBLE);
                    trainingPic15Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic15Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic15.setVisibility(View.VISIBLE);
                trainingPic15Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 16////////////////////////////////////////////////////////////////////////
        trainingPic16 = (ImageButton) findViewById(R.id.trainingpic16);
        trainingPic16.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic16Clicked) {
                    findViewById(R.id.trainingpic16).setBackgroundResource(R.drawable.peartree);
                    trainingPic16Clicked = true;
                }

                //move on second click
                else if(trainingPic16Clicked){
                    trainingPic16.setVisibility(View.INVISIBLE);
                    trainingPic16Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic16Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic16.setVisibility(View.VISIBLE);
                trainingPic16Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 17////////////////////////////////////////////////////////////////////////
        trainingPic17 = (ImageButton) findViewById(R.id.trainingpic17);
        trainingPic17.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic17Clicked) {
                    findViewById(R.id.trainingpic17).setBackgroundResource(R.drawable.peartree);
                    trainingPic17Clicked = true;
                }

                //move on second click
                else if(trainingPic17Clicked){
                    trainingPic17.setVisibility(View.INVISIBLE);
                    trainingPic17Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic17Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic17.setVisibility(View.VISIBLE);
                trainingPic17Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 18////////////////////////////////////////////////////////////////////////
        trainingPic18 = (ImageButton) findViewById(R.id.trainingpic18);
        trainingPic18.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic18Clicked) {
                    findViewById(R.id.trainingpic18).setBackgroundResource(R.drawable.peartree);
                    trainingPic18Clicked = true;
                }

                //move on second click
                else if(trainingPic18Clicked){
                    trainingPic18.setVisibility(View.INVISIBLE);
                    trainingPic18Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic18Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic18.setVisibility(View.VISIBLE);
                trainingPic18Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 19////////////////////////////////////////////////////////////////////////
        trainingPic19 = (ImageButton) findViewById(R.id.trainingpic19);
        trainingPic19.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic19Clicked) {
                    findViewById(R.id.trainingpic19).setBackgroundResource(R.drawable.peartree);
                    trainingPic19Clicked = true;
                }

                //move on second click
                else if(trainingPic19Clicked){
                    trainingPic19.setVisibility(View.INVISIBLE);
                    trainingPic19Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic19Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic19.setVisibility(View.VISIBLE);
                trainingPic19Below.setVisibility(View.INVISIBLE);
            }
        });

        //TRAINING PIC 20////////////////////////////////////////////////////////////////////////
        trainingPic20 = (ImageButton) findViewById(R.id.trainingpic20);
        trainingPic20.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                //on first click, change to new image.
                if(!trainingPic20Clicked) {
                    findViewById(R.id.trainingpic20).setBackgroundResource(R.drawable.peartree);
                    trainingPic20Clicked = true;
                }

                //move on second click
                else if(trainingPic20Clicked){
                    trainingPic20.setVisibility(View.INVISIBLE);
                    trainingPic20Below.setVisibility(View.VISIBLE);
                }

            }
        });
        trainingPic20Below.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                trainingPic20.setVisibility(View.VISIBLE);
                trainingPic20Below.setVisibility(View.INVISIBLE);
            }
        });
    }


    public void resetTrainingImages(View view){
        trainingPic1.setVisibility(View.VISIBLE);
        trainingPic2.setVisibility(View.VISIBLE);
        trainingPic3.setVisibility(View.VISIBLE);
        trainingPic4.setVisibility(View.VISIBLE);
        trainingPic5.setVisibility(View.VISIBLE);
        trainingPic6.setVisibility(View.VISIBLE);
        trainingPic7.setVisibility(View.VISIBLE);
        trainingPic8.setVisibility(View.VISIBLE);
        trainingPic9.setVisibility(View.VISIBLE);
        trainingPic10.setVisibility(View.VISIBLE);

        trainingPic11.setVisibility(View.VISIBLE);
        trainingPic12.setVisibility(View.VISIBLE);
        trainingPic13.setVisibility(View.VISIBLE);
        trainingPic14.setVisibility(View.VISIBLE);
        trainingPic15.setVisibility(View.VISIBLE);
        trainingPic16.setVisibility(View.VISIBLE);
        trainingPic17.setVisibility(View.VISIBLE);
        trainingPic18.setVisibility(View.VISIBLE);
        trainingPic19.setVisibility(View.VISIBLE);
        trainingPic20.setVisibility(View.VISIBLE);

        trainingPic1Below.setVisibility(View.INVISIBLE);
        trainingPic2Below.setVisibility(View.INVISIBLE);
        trainingPic3Below.setVisibility(View.INVISIBLE);
        trainingPic4Below.setVisibility(View.INVISIBLE);
        trainingPic5Below.setVisibility(View.INVISIBLE);
        trainingPic6Below.setVisibility(View.INVISIBLE);
        trainingPic7Below.setVisibility(View.INVISIBLE);
        trainingPic8Below.setVisibility(View.INVISIBLE);
        trainingPic9Below.setVisibility(View.INVISIBLE);
        trainingPic10Below.setVisibility(View.INVISIBLE);

        trainingPic11Below.setVisibility(View.INVISIBLE);
        trainingPic12Below.setVisibility(View.INVISIBLE);
        trainingPic13Below.setVisibility(View.INVISIBLE);
        trainingPic14Below.setVisibility(View.INVISIBLE);
        trainingPic15Below.setVisibility(View.INVISIBLE);
        trainingPic16Below.setVisibility(View.INVISIBLE);
        trainingPic17Below.setVisibility(View.INVISIBLE);
        trainingPic18Below.setVisibility(View.INVISIBLE);
        trainingPic19Below.setVisibility(View.INVISIBLE);
        trainingPic20Below.setVisibility(View.INVISIBLE);
    }

    public void addNewTestingImage(View view){
        switch(imageCount) {
            case 0:
                myImageView.setImageResource(R.drawable.lemon);
                break;
            case 1:
                myImageView.setImageResource(R.drawable.orange);
                break;
            case 2:
                myImageView.setImageResource(R.drawable.apple);
                break;
            case 3:
                myImageView.setImageResource(R.drawable.pear);
                break;
            case 4:
                myImageView.setImageResource(R.drawable.egg);
                break;
        }
        imageCount++;
    }
}