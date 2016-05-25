//PopupActivity.java
package com.gapt.uni.braintrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class PopupActivity extends Activity implements View.OnClickListener {
    String type;
    int score;
    Button b1;
    Button b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        View m = getWindow().getDecorView();
        m.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_popout);
        type = getIntent().getExtras().getString("type"); //sound, pattern
        score = getIntent().getExtras().getInt("score");
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.8), (int) (height * 0.8));
        TextView tv = (TextView) findViewById(R.id.textviewInPopup);
        b1 = (Button) findViewById(R.id.imageButtonLeft);
        b2 = (Button) findViewById(R.id.imageButtonRight);
        //RelativeLayout.LayoutParams rp = (RelativeLayout.LayoutParams) b1.getLayoutParams();//ou RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);

        //rp.topMargin = b1.getHeight()/2;
        //b1.setLayoutParams(rp);
        //b2.setLayoutParams(rp);//b1 and b2 can use the same parameters

        //rp.bottomMargin("");

//        ViewGroup.MarginLayoutParams params = (ViewGroup.MarginLayoutParams) b1.getLayoutParams();
        //params.width = 200; params.leftMargin = 100; params.topMargin = 200;
//params.bottomMargin = -126/2;
        //      b1.setLayoutParams(params);
        //   b2.setLayoutParams(params);
        Log.i("height", "" + b1.getHeight());
        //b1.setTop(-b1.getHeight()/2);
        //b2.setTop(-b2.getHeight()/2);
        // b1.setBottom((126 / 2));
        //b2.setBottom((126 / 2));
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        ImageView bg_img = (ImageView) findViewById(R.id.background_img);
        if (type.equals("sound_matching")) {
            bg_img.setBackground(null);
            bg_img.setImageResource(R.drawable.how_to_sound_matching);
            tv.setText("\n\nTo play do this xyyyy.");
        } else if (type.equals("pattern_matching")) {
            bg_img.setBackground(null);
            bg_img.setImageResource(R.drawable.how_to_pattern_matching);
            tv.setText("\n\nTo play do this xx.");
        } else if (type.equals("game_over pattern") || type.equals("game_over sound")) {
            bg_img.setImageResource(R.drawable.gameover);
            b1.setText("Game \nSelection");
            b2.setText("Play Again");
            tv.setText("\n\nYour brain power went up by x!\n You are now much better at spatial recognition!\nYour score is now y.");
        }
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        if (type.equals("sound_matching") || type.equals("game_over sound")) {
            i = new Intent(PopupActivity.this, SoundMatchingGameActivity.class);
        } else if (type.equals("pattern_matching") || type.equals("game_over pattern")) {
            i = new Intent(PopupActivity.this, PatternGameActivity.class);
        }

        switch (v.getId()) {
            case R.id.imageButtonLeft:
                if (((Button) v).getText().equals("Game \nSelection")) {
                    i.putExtra("action", "game_selection");
                    finish();
                } else if (((Button) v).getText().equals("Cancel")) {
                    i.putExtra("action", "cancel");
                    finish();
                    //startActivity(i);
                }
                break;
            case R.id.imageButtonRight:
                if (((Button) v).getText().equals("Play Again") || ((Button) v).getText().equals("Play")) {
                    finish();
                    if (type.equals("pattern_matching") || type.equals("game_over pattern")) {
                        i.putExtra("row", 1);
                        i.putExtra("col", 2);
                        i.putExtra("guesses", 1);
                        i.putExtra("level", 1);
                    }
                    i.putExtra("score", score);
                    startActivity(i);
                    finish();
                    break;
                }
        }
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
        Log.i("height here", "" + b1.getHeight());
        //b1.setBottom(-b1.getHeight()/2);
    }

}