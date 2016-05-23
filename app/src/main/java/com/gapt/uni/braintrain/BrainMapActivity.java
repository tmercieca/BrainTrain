package com.gapt.uni.braintrain;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class BrainMapActivity extends Activity {
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
        setContentView(R.layout.activity_brain_map);
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int) (width * 0.85), (int) (height * 0.85));
        ImageView iv = (ImageView) findViewById(R.id.brain_with_pointer);
        iv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent ev) {
                final int action = ev.getAction();
                final int evX = (int) ev.getX();
                final int evY = (int) ev.getY();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        break;
                    case MotionEvent.ACTION_UP:
                        ImageView img = (ImageView) findViewById(R.id.brain_with_pointer);
                        img.setDrawingCacheEnabled(true);
                        Bitmap imgbmp = Bitmap.createBitmap(img.getDrawingCache());
                        img.setDrawingCacheEnabled(false);
                        int pxl = imgbmp.getPixel(evX, evY);
                        int redComponent = Color.red(pxl);
                        int greenComponent = Color.green(pxl);
                        int blueComponent = Color.blue(pxl);
                        Log.i("pressed colors - R G B:", "" + redComponent + " " + greenComponent + "  " + blueComponent);

                        int colourAtPt = Color.rgb(redComponent, greenComponent, blueComponent);
                        //Intent i = new Intent(BrainMapActivity.this, CardFactsss.class);

                        //green is having some trouble distinguishing between pointer and brain part but should not pose a problem
                        if (isCloseColour(colourAtPt, Color.rgb(54, 126, 27), 31) || (isCloseColour(colourAtPt, Color.rgb(85, 155, 15), 25))) {//trouble detecting this green with low tolerance
//                            i.putExtra("index", 0); //frontal
  //                          startActivity(i);
                            //finish(); //close this activity
                            //testing purposes!
                            if (isCloseColour(colourAtPt, Color.rgb(54, 126, 27), 31)) {
                                Log.i("frontal lobe", "green POINTER");
                            }
                            if (isCloseColour(colourAtPt, Color.rgb(85, 155, 15), 25)) {
                                Log.i("brain", "green");
                            }
                        } else if (isCloseColour(colourAtPt, Color.rgb(221, 188, 78), 25) || isCloseColour(colourAtPt, Color.rgb(218, 126, 35), 25)) {
//                            i.putExtra("index", 1); //temporal
  //                          startActivity(i);
                            //finish(); //close this activity
                            if (isCloseColour(colourAtPt, Color.rgb(218, 126, 35), 25)) {
                                Log.i("temporal lobe", "orange POINTER");
                            }
                            if (isCloseColour(colourAtPt, Color.rgb(221, 188, 78), 25)) {
                                Log.i("brain", "yellow");
                            }
                        } else if (isCloseColour(colourAtPt, Color.rgb(109, 157, 204), 25) || isCloseColour(colourAtPt, Color.rgb(99, 39, 191), 25)) {
                           // i.putExtra("index", 2); //stem
                            //startActivity(i);
                            //finish(); //close this activity
                            if (isCloseColour(colourAtPt, Color.rgb(99, 39, 191), 25)) {
                                Log.i("lobe", "purple POINTER");
                            }
                            if (isCloseColour(colourAtPt, Color.rgb(109, 157, 204), 25)) {
                                Log.i("brain", "brain stem");
                            }
                        } else if (isCloseColour(colourAtPt, Color.rgb(191, 221, 242), 25) || isCloseColour(colourAtPt, Color.rgb(39, 125, 206), 25)) {
                            //  i.putExtra("index", 3); //occipital
                           // startActivity(i);
                            //finish(); //close this activity
                            if (isCloseColour(colourAtPt, Color.rgb(39, 125, 206), 25)) {
                                Log.i("lobe", "BLUE POINTER");
                            }
                            if (isCloseColour(colourAtPt, Color.rgb(191, 221, 242), 25)) {
                                Log.i("brain", "light blue");
                            }
                        } else if (isCloseColour(colourAtPt, Color.rgb(219, 46, 71), 20) || isCloseColour(colourAtPt, Color.rgb(188, 41, 76), 25)) { //low tolerance for reds - to distinguish between colours better
                            //i.putExtra("index", 4); //paretial
                            //startActivity(i);
                            //finish(); //close this activity
                            if (isCloseColour(colourAtPt, Color.rgb(219, 46, 71), 20)) {
                                Log.i("partial lobe", "red1 POINTER");
                            }
                            if (isCloseColour(colourAtPt, Color.rgb(188, 41, 76), 25)) {
                                Log.i("brain", "red BRAIN");
                            }
                        } else if (isCloseColour(colourAtPt, Color.rgb(213, 44, 35), 25) || isCloseColour(colourAtPt, Color.rgb(215, 110, 108), 25)) {
                            //i.putExtra("index", 5); //cerebellum
                            //startActivity(i); // opens next activity
                            //finish(); //close this activity
                            if (isCloseColour(colourAtPt, Color.rgb(213, 44, 35), 25)) {
                                Log.i("lobe", "red2 POINTER");
                            }
                            if (isCloseColour(colourAtPt, Color.rgb(215, 110, 108), 25)) {
                                Log.i("brain", "pink cerebellum");
                            }
                        }
                        break;
                }
                return true;
            }
        });
    }





    public boolean isCloseColour (int color1, int color2, int tolerance) {
        Log.i("method is called", "");
        if ((int) Math.abs (Color.red (color1) - Color.red (color2)) >= tolerance ) {
            return false;
        }
        if ((int) Math.abs (Color.green (color1) - Color.green (color2)) >= tolerance ) {
            return false;
        }
        if ((int) Math.abs (Color.blue (color1) - Color.blue (color2)) >= tolerance ) {
            return false;
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
                            | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
        }
    }



}
