package com.gapt.uni.braintrain;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * Created by Thomas on 02/05/16.
 */
public class PatternGameActivity extends Activity {

    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern_game);

        generateTable(3,3,3); //rows, cols, number of boxes which are to be guessed, can increase number of tries
        //load screen
        //next level
    }

    public void generateTable(int tRows, int tCols, int tGuesses){
        int i, j = 0;
        TableLayout table = (TableLayout)findViewById(R.id.tableOfButtons);
        table.setGravity(Gravity.CENTER);
        for (i = 0; i < tRows; i++) {
            TableRow tr = new TableRow(this);
            tr.setGravity(Gravity.CENTER);
            table.addView(tr);
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
                        if (ib.getTag().equals("1"))
                        {

                            TextView tv = (TextView) findViewById(R.id.score);
                            Log.i("TAG", "success");
                            ib.setTag("0"); //so as not to be able to click again click again
                            score++;
                            tv.setText("SCORE: " +score);
                        }
                        else{
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


