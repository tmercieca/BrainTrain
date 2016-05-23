//GameSelectionActivity.java
package com.gapt.uni.braintrain;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class GameSelectionActivity extends AppCompatActivity implements View.OnTouchListener {
int score = 0;//load from DB
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_selection); //change for testing
        View m = getWindow().getDecorView();
        m.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
         final String PREFS_NAME = "MyPrefsFile";

        SharedPreferences settings = getApplicationContext().getSharedPreferences(PREFS_NAME, 0);

        int score = settings.getInt("score", 0); //set score to 0 if score not found



        //ImageButton thumbTop1 = (ImageButton) findViewById(R.id.upper_thumbnail_1);
        //ImageButton thumbBot1 = (ImageButton) findViewById(R.id.lower_thumbnail_1);
        //ImageButton thumbTop2 = (ImageButton) findViewById(R.id.upper_thumbnail_2);
        //ImageButton thumbBot2 = (ImageButton) findViewById(R.id.lower_thumbnail_2);
        //ImageButton thumbTop3 = (ImageButton) findViewById(R.id.upper_thumbnail_3);
        //ImageButton thumbBot3 = (ImageButton) findViewById(R.id.lower_thumbnail_3);
        //thumbTop1.setOnTouchListener(this);
        //thumbTop2.setOnTouchListener(this);
        //thumbTop3.setOnTouchListener(this);
       // thumbBot1.setOnTouchListener(this);
        //thumbBot2.setOnTouchListener(this);
        //thumbBot3.setOnTouchListener(this);

        Button b = (Button) findViewById(R.id.brain_map_button);
        b.setOnTouchListener(this);
        ImageButton  sgm = (ImageButton) findViewById(R.id.sound_game_mapping);
        ImageButton  mgm = (ImageButton) findViewById(R.id.memory_game_mapping);

        sgm.setOnTouchListener(this);
        mgm.setOnTouchListener(this);


        //ImageView trainBody = (ImageView) findViewById(R.id.train_body);
        //Drawable d = getResources().getDrawable(R.drawable.train4);//this.getApplicationContext().getResources().getDrawable(R.drawable.train4);


        //trainBody.setBackground(null);//required

        //d.setColorFilter(Color.parseColor("#FF1233"), PorterDuff.Mode.MULTIPLY);
        //Log.i("overlayed!", "");;
        //trainBody.setImageDrawable(d);

        //trainBody.setVisibility(View.VISIBLE);

        //Drawable d =getDrawable(R.id.train_body);
        //Drawable d = ContextCompat.getDrawable(getApplicationContext(), R.id.train_body);


        //Drawable d = getResources().getDrawable()(R.id.train_body);//.id.train_body;// R.id.train_body;//.setColorFilter(0x99FF66, PorterDuff.Mode.MULTIPLY);
        //d.setColorFilter(0x99FF66, PorterDuff.Mode.MULTIPLY);
        //trainBody.setBackground(getResources().getDrawable(R.drawable.train4));

        //getResources().getDrawable(R.drawable.train4));//.train_body));


        //sgm.setVisibility(View.VISIBLE);
        //mgm.setVisibility(View.VISIBLE);


    }



    public boolean onTouch(View v, MotionEvent event) {

       // ImageButton thumbTop1 = (ImageButton) findViewById(R.id.upper_thumbnail_1);

        //ImageButton thumbTop2 = (ImageButton) findViewById(R.id.upper_thumbnail_2);
        //ImageButton thumbBot2 = (ImageButton) findViewById(R.id.lower_thumbnail_2);
        //ImageButton thumbTop3 = (ImageButton) findViewById(R.id.upper_thumbnail_3);
        //ImageButton thumbBot3 = (ImageButton) findViewById(R.id.lower_thumbnail_3);
            switch(v.getId()){
                case R.id.sound_game_mapping:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        //    thumbTop1.setPressed(true);
                        //thumbBot1.setPressed(true);

                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        Intent i = new Intent(GameSelectionActivity.this, PatternGameActivity.class);
                        i.putExtra("row", 1);
                        i.putExtra("col", 2);
                        i.putExtra("guesses", 1);
                        i.putExtra("level", 1);
                        i.putExtra("score", score);

                        startActivity(i);
                    }
                    break;
                case R.id.memory_game_mapping:

                    if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    }

                    if (event.getAction() == MotionEvent.ACTION_UP) {

                        Intent i = new Intent(GameSelectionActivity.this, SoundMatchingGameActivity.class);
                        i.putExtra("score", score);

                        startActivity(i);

                        Log.i("Action down","ad");
                    }
                    break;
                case R.id.brain_map_button:
                    if (event.getAction() == MotionEvent.ACTION_DOWN){

                    }


                    if (event.getAction() == MotionEvent.ACTION_UP){
                        Intent i = new Intent (GameSelectionActivity.this, BrainMapActivity.class);
                        startActivity(i);
                    }


            }
            return true;
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
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    } //CHECK FLAGS



/*
    // This snippet hides the system bars.
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    // This snippet shows the system bars. It does this by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }



    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        if (hasFocus) {
            decorView.setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                            | View.SYSTEM_UI_FLAG_FULLSCREEN
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);}
    }

    */

    public int getHotspotColor (int hotspotId, int x, int y) {
        ImageView img = (ImageView) findViewById (hotspotId);
        img.setDrawingCacheEnabled(true);
        Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);
        return hotspots.getPixel(x, y);
    }

    public boolean closeMatch (int color1, int color2, int tolerance) {
        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) > tolerance )
            return false;
        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) > tolerance )
            return false;
        if ((int) Math.abs (Color.blue (color1) - Color.blue(color2)) > tolerance )
            return false;
        return true;
    } // end match











}
