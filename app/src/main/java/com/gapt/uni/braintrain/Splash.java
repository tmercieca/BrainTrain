package com.gapt.uni.braintrain;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;

import gr.net.maroulis.library.EasySplashScreen;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View m = getWindow().getDecorView();
        m.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        EasySplashScreen config = new EasySplashScreen(Splash.this)
                .withFullScreen()
                .withTargetActivity(GameSelectionActivity.class)
                .withSplashTimeOut(400)
                .withBackgroundResource(android.R.color.holo_purple)
                .withHeaderText("")
                .withFooterText("Copyright 2016")
                .withBeforeLogoText("BrainTrain")
                .withLogo(R.drawable.icon)
                .withAfterLogoText("Created by\nThomas Mercieca,\nSamuel Borg\n& Graziella Debono");


        //set your own animations
        myCustomTextViewAnimation(config.getFooterTextView());

        //customize all TextViews
        Typeface burbank = Typeface.createFromAsset(getAssets(), "BurbankBigRegularBold.ttf");
       config.getAfterLogoTextView().setTypeface(null, Typeface.BOLD);

        config.getBeforeLogoTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getFooterTextView().setTextColor(Color.WHITE);
        config.getAfterLogoTextView().setTextColor(Color.WHITE);

        //create the view
        View easySplashScreenView = config.create();

        setContentView(easySplashScreenView);
    }

    private void myCustomTextViewAnimation(TextView tv){
        Animation animation=new TranslateAnimation(0,0,480,0);
        animation.setDuration(200);
        tv.startAnimation(animation);
    }
}
