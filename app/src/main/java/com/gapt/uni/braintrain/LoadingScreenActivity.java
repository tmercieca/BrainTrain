package com.gapt.uni.braintrain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadingScreenActivity extends AppCompatActivity {

    List<String> factList = new ArrayList<>();
    Random r = new Random();
    String type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen_activity);
        factList.add("Your brain is 73% water");
        factList.add("Dehydration will affect your attention \nand memory");
        factList.add("90 minutes of sweating will temporarily shrink \nthe brain as much as growing older by a year");
        factList.add("Information across the brain moves \nfaster than the speed of Formula 1 cars");
        factList.add("Brains are not fully formed until the age of 25");
        factList.add("The brain is the fattiest organ");
        factList.add("Your brain generates less electricity than \nwhat is required to power a light bulb");
        factList.add("Avoid bumping your head");
        factList.add("The hair on your head serves as a \ncushion when you hit your head");
        type = getIntent().getExtras().getString("type");

        int randomIndex = r.nextInt(factList.size());
        TextView factText = (TextView) findViewById(R.id.fact);
        factText.setText(factList.get(randomIndex));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent i = new Intent(LoadingScreenActivity.this, PopupActivity.class);
                i.putExtra("type", type);
                startActivity(i);
            }
        }, 3500);


    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        View m = getWindow().getDecorView();
        if (hasFocus) {
            m.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }

}
