package com.gapt.uni.braintrain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.gapt.uni.braintrain.libs.SwipeDeck;

import java.util.ArrayList;

public class FactsActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    int current = 0;
    private SwipeDeck cardStack;
    private Context context = this;
    private SwipeDeckAdapter adapter;
    private ArrayList<String> fact;

//    public void setLeftImage(int imageResource) {
//        leftImageResource = imageResource;
//    }
//
//    public void setRightImage(int imageResource) {
//        rightImageResource = imageResource;
//    }

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
        setContentView(R.layout.activity_facts);
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);

        final ArrayList<String> fact = new ArrayList<>();
        TextView label = (TextView)findViewById(R.id.smallText);
        ImageButton back = (ImageButton)findViewById(R.id.back_button);
        String labelstring = "";

        Bundle extras = getIntent().getExtras();
        String lobe = extras.getString("index");
            switch (lobe)
            {
                case "frontal":
                    //frontal
                    labelstring = "Frontal lobe";
                    fact.add("Frontal Lobe \nThis part of your brain is responsible for...");
                    fact.add("Movement at will");
                    fact.add("Expressing yourself");
                    fact.add("Social Interactions");
                    fact.add("Emotions");
                    fact.add("Motivation");
                    fact.add("Short Term Memory");
                    fact.add("Improve this part of the brain by playing memory games.");
                    fact.add("");

                    break;

                case "temporal":
                    fact.add("Temporal Lobe \nThis part of your brain is responsible for...");
                    fact.add("Hearing");
                    fact.add("Smelling");
                    fact.add("Sense of music");
                    fact.add("Long Term Memory");
                    fact.add("Protect this part of your brain by engaging in activities which use your senses.");
                    fact.add("");
                    break;

                case "stem":
                    fact.add("Brain Stem \n This part of your brain is responsible for...");
                    fact.add("Motor skills such as...");
                    fact.add("Chewing swalling, balance, speaking, breat...");
                    fact.add("Swallowing");
                    fact.add("Balance");
                    fact.add("Breathing");
                    fact.add("Speaking");
                    fact.add("Protect this part of the brain by engaging in motor skills activities.");
                    fact.add("");

                    break;

                case "occipital":
                    fact.add("Occipital Lobe \nThis part of your brain is responsible for...");
                    fact.add("Visual perception");
                    fact.add("In other words, understanding what you see");
                    fact.add("");

                    break;

                case "paretial":
                    fact.add("Paretial Lobe \nThis part of your brain is responsible for...");
                    fact.add("Telling between hot and cold");
                    fact.add("Reading");
                    fact.add("Calculations");
                    fact.add("Awareness");
                    fact.add("Relationships");
                    fact.add("Improve this part of the brain by reading and doing math.");
                    fact.add("");

                    break;

                case "cerebellum":
                    fact.add("Cerebellum \n This part of your brain is responsible for...");
                    fact.add("Coordinating actions");
                    fact.add("Balance");
                    fact.add("Protect this part of the brain by performing meditation... ");
                    fact.add("... and by being mindful of your actions.");
                    fact.add("");

                    break;
            }

        Button btn2 = (Button) findViewById(R.id.right);
        assert btn2 != null;
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardStack.swipeTopCardRight(current);
            }
        });

        ImageButton bk = (ImageButton) findViewById(R.id.back_button);
        assert bk != null;
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        final SwipeDeckAdapter adapter = new SwipeDeckAdapter(fact, this);
        cardStack.setAdapter(adapter);

        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {

            public void cardSwipedLeft(int position) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + position);
                current = position;
            }

            public void cardSwipedRight(int position) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + position);
                current = position;
            }

            @Override
            public void cardsDepleted() {
                Log.i("MainActivity", "no more cards");
            }

            public void cardActionDown() {
                Log.i(TAG, "cardActionDown");
            }

            public void cardActionUp() {
                Log.i(TAG, "cardActionUp");
            }

        });
    }

}