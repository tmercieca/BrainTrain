//SoundMatchingGameActivity.java
package com.gapt.uni.braintrain;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SoundMatchingGameActivity extends Activity {
    int score = 0;
    Random rand = new Random();
    //MediaPlayer mp2, mMediaPlayer;
    int i, j, index = 0, tGuesses = 2;
    List<Animal> listOfAnimals = new ArrayList<>();
    MediaPlayer mMediaPlayer = new MediaPlayer();
    MediaPlayer mp2 = new MediaPlayer();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("activity", "new");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sound_matching_game);


        View m = getWindow().getDecorView();
        m.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        listOfAnimals.add(new Animal("Bear", R.mipmap.animals_bear, R.raw.bear_growl));//0
        listOfAnimals.add(new Animal("Lion", R.mipmap.animals_lion, R.raw.lion_growling));//1
        listOfAnimals.add(new Animal("Tiger", R.mipmap.animals_tiger, R.raw.tiger_growl));//2
        listOfAnimals.add(new Animal("Dog", R.mipmap.animals_dog, R.raw.dog_bark));//3
        listOfAnimals.add(new Animal("Cat", R.mipmap.animals_cat, R.raw.cat_meow));//4
        listOfAnimals.add(new Animal("Bird", R.mipmap.animals_bird, R.raw.bird_nightingale));//5
        listOfAnimals.add(new Animal("Horse", R.mipmap.animals_horse, R.raw.horse_neighing));//6
        listOfAnimals.add(new Animal("Panther", R.mipmap.animals_panther, R.raw.panther_sound));//7
        listOfAnimals.add(new Animal("Elephant", R.mipmap.animals_elephant, R.raw.elephant_trumpeting));//8
        listOfAnimals.add(new Animal("Eagle", R.mipmap.animals_eagle, R.raw.eagle_cry));//9
        listOfAnimals.add(new Animal("Wolf", R.mipmap.animals_wolf, R.raw.wolf_howl));//10

        int x = rand.nextInt(listOfAnimals.size()); //random number from 0 to 10 inclusive

        final ImageButton replay = (ImageButton) findViewById(R.id.play_button);
        final MediaPlayer mMediaPlayer = MediaPlayer.create(this, listOfAnimals.get(x).getSoundRes());

        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.start();
        replay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!mMediaPlayer.isPlaying()) {
                    mMediaPlayer.start();
                }
            }
        });

        final ImageButton backButton = (ImageButton) findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopPlaying(mp2);
                stopPlaying(mMediaPlayer);
                finish();


                Intent i = new Intent(SoundMatchingGameActivity.this, LoadingScreenActivity.class);
                i.putExtra("type", "game_over sound");
                startActivity(i);
            }
        });


        final TableLayout table = (TableLayout) findViewById(R.id.table_with_choices);
        table.setGravity(Gravity.CENTER);


        List<Integer> uniqueRandomsArrayList = createListUnqRandInclNo(0, 10, 0, 8, x);

        for (i = 0; i < 2; i++) { // 2 rows
            TableRow tr = new TableRow(this);
            tr.setGravity(Gravity.CENTER);
            table.addView(tr);
            for (j = 0; j < 4; j++) {// 4 cols
                final ImageButton ib = new ImageButton(this);
                TableRow.LayoutParams params = new TableRow.LayoutParams();
                params.height = 200;
                params.width = 200;
                String tag = "" + listOfAnimals.get(uniqueRandomsArrayList.get(index)).getSoundRes();
                ib.setImageResource(listOfAnimals.get(uniqueRandomsArrayList.get(index)).getDrawable());
                if (uniqueRandomsArrayList.get(index) == x) {
                    ib.setTag(1 + tag);
                } else {
                    ib.setTag(0 + tag);
                }

                ib.setLayoutParams(params);
                ib.setScaleType(ImageButton.ScaleType.CENTER_CROP);
                ib.setId(Integer.parseInt(Integer.toString(i) + Integer.toString(j)));
                ib.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (((String) ib.getTag()).charAt(0) == '1') {

                            TextView tv = (TextView) findViewById(R.id.score);
                            //Log.i("TAG", "success - match");

                            score++;
                            tv.setText("SCORE: " + score);

                            int soundRes;
                            //Log.i("TAgg", ((String)ib.getTag()).substring(1));
                            soundRes = Integer.parseInt(((String) ib.getTag()).substring(1));
                            ib.setTag("0"); //so as not to be able to click again click again
                            mp2 = MediaPlayer.create(getApplicationContext(), soundRes);
                            mp2.setAudioStreamType(AudioManager.STREAM_MUSIC);


                            mp2.start();
                            replay.setVisibility(View.INVISIBLE);
                            backButton.setVisibility(View.INVISIBLE);
                            table.removeAllViews();
                            stopPlaying(mMediaPlayer);
                            //delay
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {

                                    stopPlaying(mp2);

                                    //new Intent().putExtra()
                                    //intent.putExtra("EXTRA_SESSION_ID", sessionId);
                                    startActivity(new Intent(SoundMatchingGameActivity.this, SoundMatchingGameActivity.class));
                                    //Log.i("msg", "reached new activity");
                                    finish();
                                }
                            }, mp2.getDuration());

                        } else {
                            int soundRes;
                            //Log.i("tag", "fail no match");
                            soundRes = Integer.parseInt(((String) ib.getTag()).substring(1));

                            mp2 = MediaPlayer.create(getApplicationContext(), soundRes);
                            mp2.setAudioStreamType(AudioManager.STREAM_MUSIC);
                            //mMediaPlayer.setLooping(true);
                            mp2.start();
                            table.removeAllViews();
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {


                                    finish();
                                    Intent i = new Intent(SoundMatchingGameActivity.this, LoadingScreenActivity.class);
                                    i.putExtra("type", "game_over sound");
                                    startActivity(i);

//gameover
                                }
                            }, mp2.getDuration());


                        }
                    }


                });

                tr.addView(ib);
                index++;
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
    }


    @Override
    protected void onDestroy() {
        stopPlaying(mp2);
        stopPlaying(mp2);
        stopPlaying(mMediaPlayer);
        stopPlaying(mMediaPlayer);
        super.onDestroy();
    }

    private void stopPlaying(MediaPlayer mp) {
        if (mp != null) {
            mp.release();
//            mp.stop();
            mp = null;
        }
    }

    @Override
    protected void onStart() {

        super.onStart();
    }


    @Override
    protected void onStop() {
        stopPlaying(mp2);
        stopPlaying(mMediaPlayer);

        //save score when activity is finished
        SharedPreferences sharedPref = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt("score", score);
        editor.commit();
        editor.apply();

        super.onStop();
    }

    @Override
    protected void onPause() {

        stopPlaying(mp2);
        stopPlaying(mMediaPlayer);
        super.onPause();

    }

    public List<Integer> createListUnqRandInclNo(int min, int max, int startIndex, int endIndex, int noToIncl) {//start - 0, max - 10, endIndex - 8
        List<Integer> listToShuffle = new ArrayList<>();
        for (int i = min; i <= max; i++) listToShuffle.add(i);
        List<Integer> shuffledList = new ArrayList<>();
        do{
            Collections.shuffle(listToShuffle);
            shuffledList = listToShuffle.subList(startIndex, endIndex);
            } while (!shuffledList.contains(noToIncl));
        return shuffledList;

    }



}
