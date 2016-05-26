//GameSelectionActivity.java
package com.gapt.uni.braintrain;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;

public class GameSelectionActivity extends AppCompatActivity implements View.OnTouchListener {
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

        ImageButton b = (ImageButton) findViewById(R.id.brain_map_button);
        b.setOnTouchListener(this);
        ImageButton  sgm = (ImageButton) findViewById(R.id.sound_game_mapping);
        ImageButton  mgm = (ImageButton) findViewById(R.id.memory_game_mapping);
        sgm.setOnTouchListener(this);
        mgm.setOnTouchListener(this);
        //d.setColorFilter(0x99FF66, PorterDuff.Mode.MULTIPLY);
    }

    public boolean onTouch(View v, MotionEvent event) {
            switch(v.getId()){
                case R.id.sound_game_mapping:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        //press down effect
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        //  Intent i = new Intent(GameSelectionActivity.this, sound.class);
                        Intent i = new Intent(GameSelectionActivity.this, PopupActivity.class);
                        i.putExtra("type", "sound_matching");
                        startActivity(i);
                    }
                    break;
                case R.id.memory_game_mapping:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        //press down effect
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        Intent i = new Intent(GameSelectionActivity.this, PopupActivity.class);
                        i.putExtra("type", "pattern_matching");
                        startActivity(i);
                    }
                    break;
                case R.id.brain_map_button:
                    if (event.getAction() == MotionEvent.ACTION_DOWN){
                        //press down effect
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
    }
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
}
