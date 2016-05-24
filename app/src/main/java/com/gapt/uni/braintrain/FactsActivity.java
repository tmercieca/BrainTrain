package com.gapt.uni.braintrain;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.gapt.uni.braintrain.libs.SwipeDeck;

import java.util.ArrayList;

public class FactsActivity extends AppCompatActivity{

    private static final String TAG = "MainActivity";
    private SwipeDeck cardStack;
    private Context context = this;
    int current = 0;

    private SwipeDeckAdapter adapter;
    private ArrayList<String> fact;
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
                    fact.add("This is a test");
                    fact.add("1");
                    fact.add("2");
                    fact.add("3");
                    fact.add("4");
                    fact.add("this text will not appear");
                    break;

                case "temporal":
                    fact.add("This is a test");
                    fact.add("1");
                    fact.add("2");
                    fact.add("3");
                    fact.add("4");
                    fact.add("this text will not appear");
                    break;

                case "stem":
                    fact.add("This is a test");
                    fact.add("2");
                    fact.add("1");
                    fact.add("3");
                    fact.add("4");
                    fact.add("this text will not appear");
                    break;

                case "occipital":
                    fact.add("This is a test");
                    fact.add("1");
                    fact.add("2");
                    fact.add("3");
                    fact.add("4");
                    fact.add("this text will not appear");
                    break;

                case "paretial":
                    fact.add("This is a test");
                    fact.add("1");
                    fact.add("2");
                    fact.add("3");
                    fact.add("4");
                    fact.add("this text will not appear");
                    break;

                case "cerebellum":
                    fact.add("This is a test");
                    fact.add("1");
                    fact.add("2");
                    fact.add("3");
                    fact.add("4");
                    fact.add("this text will not appear");

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