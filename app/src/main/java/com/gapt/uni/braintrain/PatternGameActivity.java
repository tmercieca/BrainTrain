package com.gapt.uni.braintrain;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
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
import java.util.Timer;
import java.util.TimerTask;

public class PatternGameActivity extends Activity {

    int score = 0;
    //int fails = 0;
    int guessed = 0;
    int a= 0;
    int b= 0;
    int c = 0;//might need change
    int level  = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_game);
        Bundle bundle = getIntent().getExtras();

        a = bundle.getInt("row");
        b = bundle.getInt("col");
        c = bundle.getInt("guesses");
        level =bundle.getInt("level");

        generateTable(a, b, c);

        score = bundle.getInt("score");


        /*
        do {
            removeTable(findViewById(R.id.tableOfButtons));
            generateTable(a, b ,c);
            //win/lose conditoins
            //reset vals
            level = level++;
            if ((level % 3)== 0){
                a++;
            }
            else if ((level%3) == 1){
                b++;
            }
            else if ((level%3) == 2){
                c++;
            }
        }while ();
        */
        }

          //      generateTable(a, b, c); //rows, cols, number of boxes which are to be guessed, can increase number of tries

    public void removeTable (View table) {
        ((ViewGroup) table.getParent()).removeView(table);
    }

    public void generateTable(int tRows, int tCols, final int tGuesses){
        int i, j = 0;


        TableLayout tableToFill = (TableLayout)findViewById(R.id.tableOfButtons);

        tableToFill.setGravity(Gravity.CENTER);

            for (i = 0; i < tRows; i++) {
                TableRow tr = new TableRow(this);
                tr.setGravity(Gravity.CENTER);
                tableToFill.addView(tr);
                for (j = 0; j < tCols; j++) {
                    final ImageButton ib = new ImageButton(this);
                    TableRow.LayoutParams params = new TableRow.LayoutParams();

                    //check this line below - deprecated past 21. we are on 19
                    ib.setImageDrawable(getResources().getDrawable(R.drawable.pattern_block));
                    ib.setId(Integer.parseInt(Integer.toString(i) + Integer.toString(j)));
                    ib.setTag("0"); //imp otherwise is set null and crashes program
                    ib.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (ib.getTag().equals("1")) {

                                TextView tv = (TextView) findViewById(R.id.score);
                                Log.i("TAG", "success");
                                ib.setTag("0"); //so as not to be able to click again click again
                                score++;
                                tv.setText("SCORE: " + score);
                                guessed++;
                                if (guessed == tGuesses) {
                                    if (level != 10) {
                                        finish();
                                        Intent i = new Intent(PatternGameActivity.this, PatternGameActivity.class);
                                        i.putExtra("score", score+1);
                                        i.putExtra("row", a+2);
                                        i.putExtra("col", b++);
                                        i.putExtra("guesses", c++); //tGuesses
                                        i.putExtra("level", level++);
                                        startActivity(i);
                                    } else {
                                        //finish();
                                    }
                                }
                            } else {
                                //error event
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
                x = Integer.toString(r.nextInt(i));
                y = Integer.toString(r.nextInt(j));

                if (XYcoords.contains(x+y)) {
                    continue; //value is duplicate. generate another
                }
                else {
                    XYcoords.add(x+y);
                }
                ImageButton temp = (ImageButton)findViewById(Integer.parseInt(x+y));
                temp.setTag("1");
                count++;
            } while(count<tGuesses);
    }
}