package com.gapt.uni.braintrain;

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
        ImageButton thumbTop1 = (ImageButton) findViewById(R.id.upper_thumbnail_1);
        ImageButton thumbBot1 = (ImageButton) findViewById(R.id.lower_thumbnail_1);
        ImageButton thumbTop2 = (ImageButton) findViewById(R.id.upper_thumbnail_2);
        ImageButton thumbBot2 = (ImageButton) findViewById(R.id.lower_thumbnail_2);
        ImageButton thumbTop3 = (ImageButton) findViewById(R.id.upper_thumbnail_3);
        ImageButton thumbBot3 = (ImageButton) findViewById(R.id.lower_thumbnail_3);
        thumbTop1.setOnTouchListener(this);
        thumbTop2.setOnTouchListener(this);
        thumbTop3.setOnTouchListener(this);
        thumbBot1.setOnTouchListener(this);
        thumbBot2.setOnTouchListener(this);
        thumbBot3.setOnTouchListener(this);

    }



    public boolean onTouch(View v, MotionEvent event) {


        ImageButton thumbTop1 = (ImageButton) findViewById(R.id.upper_thumbnail_1);
        ImageButton thumbBot1 = (ImageButton) findViewById(R.id.lower_thumbnail_1);
        ImageButton thumbTop2 = (ImageButton) findViewById(R.id.upper_thumbnail_2);
        ImageButton thumbBot2 = (ImageButton) findViewById(R.id.lower_thumbnail_2);
        ImageButton thumbTop3 = (ImageButton) findViewById(R.id.upper_thumbnail_3);
        ImageButton thumbBot3 = (ImageButton) findViewById(R.id.lower_thumbnail_3);
            switch(v.getId()){
                case R.id.upper_thumbnail_1:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                    thumbTop1.setPressed(true);
                    thumbBot1.setPressed(true);
                }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        thumbTop1.setPressed(false);
                        thumbBot1.setPressed(false);
                    }
                    break;

                case R.id.lower_thumbnail_1:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        thumbTop1.setPressed(true);
                        thumbBot1.setPressed(true);
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        thumbTop1.setPressed(false);
                        thumbBot1.setPressed(false);
                    }
                    break;


                case R.id.upper_thumbnail_2:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        thumbTop2.setPressed(true);
                        thumbBot2.setPressed(true);
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        thumbTop2.setPressed(false);
                        thumbBot2.setPressed(false);
                    }
                    break;

                case R.id.lower_thumbnail_2:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        thumbTop2.setPressed(true);
                        thumbBot2.setPressed(true);
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        thumbTop2.setPressed(false);
                        thumbBot2.setPressed(false);
                    }
                    break;


                case R.id.upper_thumbnail_3:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        thumbTop3.setPressed(true);
                        thumbBot3.setPressed(true);
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        thumbTop3.setPressed(false);
                        thumbBot3.setPressed(false);
                    }
                    break;

                case R.id.lower_thumbnail_3:
                    if(event.getAction() == MotionEvent.ACTION_DOWN) {
                        thumbTop3.setPressed(true);
                        thumbBot3.setPressed(true);
                    }
                    if (event.getAction() == MotionEvent.ACTION_UP) {
                        thumbTop3.setPressed(false);
                        thumbBot3.setPressed(false);
                    }
                    break;


            }
            return true;
        }



/*
    @Override
    public void onClick(View v) {

        ImageButton ib = (ImageButton) findViewById(R.id.imageButtonTop99);
        ImageButton ib2 = (ImageButton) findViewById(R.id.imageButtonBottom99);

        switch(v.getId()){


            case R.id.imageButtonTop99: ib2.setSelected(false);
                break;
            case R.id.imageButtonBottom99: ib.setSelected(false);

                break;
            //case R.id.cancel_button: //goback
              //  break;
        }
    }
*/
  /*  public boolean onTouch(final View v, MotionEvent event) {

        Bitmap bmp = Bitmap.createBitmap(v.getDrawingCache());
        int color = 0;
        try {
            color = bmp.getPixel((int) event.getX(), (int) event.getY());
        } catch (Exception e) {
            // e.printStackTrace();
        }
        if (color == Color.TRANSPARENT)
            return false;
        else {

            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    //do something here
                    break;
                case MotionEvent.ACTION_OUTSIDE:
                    break;
                case MotionEvent.ACTION_CANCEL:
                    break;
                case MotionEvent.ACTION_MOVE:
                    break;
                case MotionEvent.ACTION_SCROLL:
                    break;
                case MotionEvent.ACTION_UP:
                    //do something here
                    break;
                default:
                    break;
            }
            return true;

        }
    }

*/
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







}
