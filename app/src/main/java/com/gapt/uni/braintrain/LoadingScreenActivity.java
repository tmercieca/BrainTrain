package com.gapt.uni.braintrain;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoadingScreenActivity extends AppCompatActivity {

    List<String> factList = new ArrayList<>();
    Random r = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        factList.add("fact1");
        factList.add("fact2");
        int randomIndex = r.nextInt(factList.size());
        factList.get(randomIndex);

    }

}
