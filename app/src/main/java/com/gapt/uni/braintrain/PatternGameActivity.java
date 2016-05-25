//PatternGameActivity.java

package com.gapt.uni.braintrain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatternGameActivity extends Activity {

    int score = 0;
    int guessed = 0;
    int rowNo= 0;
    int colNo= 0;
    int toGuessNo = 0;//might need change
    int level  = 0;//first

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_game);
        Bundle bundle = getIntent().getExtras();

        rowNo = bundle.getInt("row");
        colNo = bundle.getInt("col");
        toGuessNo = bundle.getInt("guesses");
        level =bundle.getInt("level");
        generateTable(rowNo, colNo, toGuessNo);
        score = bundle.getInt("score");
    }

    public void removeTable (View table) {
        ((ViewGroup) table.getParent()).removeView(table);
    }

    public void generateTable(int row, int col, final int totalToGuess){
        //int rows, cols = 0; // to create
        TableLayout tableToFill = (TableLayout)findViewById(R.id.tableOfButtons);

        tableToFill.setGravity(Gravity.CENTER);
            for (int r  = 0; r < row; r++) {
                TableRow tr = new TableRow(this);
                tr.setGravity(Gravity.CENTER);
                tableToFill.addView(tr);
                for (int c = 0; c < col; c++) {
                    final ImageButton ib = new ImageButton(this);

                    //TableRow.LayoutParams params = new TableRow.LayoutParams();
                    ib.setEnabled(false);
                    ib.setImageDrawable(getResources().getDrawable(R.drawable.pattern_block));
                    ib.setBackgroundResource(0);
                    ib.setId(Integer.parseInt(Integer.toString(r) + Integer.toString(c)));
                    ib.setTag("0");

                    ib.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (ib.getTag().equals("1")) {

                                TextView tv = (TextView) findViewById(R.id.score);
                                Log.i("TAG", "success");
                                ib.setTag("0"); //so as not to be able to click again
                                tv.setText("SCORE: " + score);
                                guessed++;
                               ib.getDrawable().setColorFilter(new LightingColorFilter(Color.GREEN, 1));
                                if (guessed == totalToGuess) {
                                    level++; //next level
                                    if (level < 13) {
                                        finish();
                                        Intent i = new Intent(PatternGameActivity.this, LoadingScreenActivity.class);
                                        if (level == 3 || level == 9) {
                                            rowNo++;
                                        } else if (level == 2 || level == 4 || level == 6) {
                                            colNo++;
                                        } else if (level == 5 || level == 7 || level == 8 || level == 10 || level == 11 || level == 12) {
                                            toGuessNo++;
                                        } else {
                                            finish();
//change to game over
                                            //  startActivity(new Intent(PatternGameActivity.this, GameSelectionActivity.class));
//                                            startActivity(new Intent(PatternGameActivity.this, GameSelectionActivity.class));

                                            // startActivity(new Intent(PatternGameActivity.this, LoadingScreenActivity.class));

                                            i.putExtra("type", "game_over pattern");
                                            //startActivity(i);//duplicate?

                                        }
                                        //game over level>10
                                        score += (level * level) + 1;
                                        i.putExtra("score", score);
                                        i.putExtra("row", rowNo);
                                        i.putExtra("col", colNo);
                                        i.putExtra("guesses", toGuessNo);
                                        i.putExtra("level", level);
                                        Log.i("score", "" + score);
                                        Log.i("row", "" + rowNo);
                                        Log.i("col", "" + colNo);
                                        Log.i("guesses", "" + toGuessNo);
                                        Log.i("level", "" + level);
                                        startActivity(i);
                                    } else {
                                        Intent i = new Intent(PatternGameActivity.this, LoadingScreenActivity.class);
                                        i.putExtra("type", "game_over pattern");
                                        startActivity(i);
                                        finish();

                                    }
                                }
                            } else {
                                //error event
                                Intent i = new Intent(PatternGameActivity.this, LoadingScreenActivity.class);
                                i.putExtra("type", "game_over pattern");
                                startActivity(i);
                                finish();//close this activity

                                Log.i("TAG", "fail");
                            }
                        }
                    });
                    tr.addView(ib);
                }
            }
            Random r = new Random();

        int count = 0;//number of buttons we want user to guess
            String x, y;
            List<String> XYcoords = new ArrayList<>();
            do{
                Log.i("row, col", ""+row+col);
                x = Integer.toString(r.nextInt(row));
                y = Integer.toString(r.nextInt(col));

                if (XYcoords.contains(x+y)) {
                    continue; //value is duplicate. generate another
                }
                else {
                    XYcoords.add(x+y);
                }
                ImageButton temp = (ImageButton)findViewById(Integer.parseInt(x+y));
                temp.setTag("1");
                count++;
            } while(count<totalToGuess);

        for (String coords : XYcoords){
            final ImageButton ib = (ImageButton)findViewById(Integer.parseInt(coords));
            final ColorFilter originalColour = ib.getColorFilter();
            ib.getDrawable().setColorFilter(new LightingColorFilter(Color.CYAN, 1));
            //ib.setColorFilter(new LightingColorFilter(Color.CYAN, 1));

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   ib.getDrawable().setColorFilter(originalColour);
                   // ib.setColorFilter(originalColour);
                    for (int r2  = 0; r2 < rowNo; r2++) {
                        for (int c = 0; c < colNo; c++) {
                            ImageButton ib = (ImageButton)findViewById(Integer.parseInt(""+r2+c));
                            ib.setEnabled(true);
                            //ib.setId(Integer.parseInt(Integer.toString(r) + Integer.toString(c)));
                        }
                    }
                }
            }, 2000);

        }

    }

    protected void onStop(){
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("score", score);
        editor.commit();
        editor.apply();
        super.onStop();
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