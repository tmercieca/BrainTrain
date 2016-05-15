package com.gapt.uni.braintrain;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.gapt.uni.braintrain.libs.SwipeDeck;

import java.util.ArrayList;

public class FactsActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
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
        setContentView(R.layout.swipe_deck);
        cardStack = (SwipeDeck) findViewById(R.id.swipe_deck);

        final ArrayList<String> fact = new ArrayList<>();
        fact.add("0");
        fact.add("1");
        fact.add("2");
        fact.add("3");
        fact.add("4");
        fact.add("5");

        final SwipeDeckAdapter adapter = new SwipeDeckAdapter(fact, this);
        cardStack.setAdapter(adapter);

        cardStack.setEventCallback(new SwipeDeck.SwipeEventCallback() {

            public void cardSwipedLeft(int position) {
                Log.i("MainActivity", "card was swiped left, position in adapter: " + position);
            }

            public void cardSwipedRight(int position) {
                Log.i("MainActivity", "card was swiped right, position in adapter: " + position);
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