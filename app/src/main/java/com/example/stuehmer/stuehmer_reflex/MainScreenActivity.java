package com.example.stuehmer.stuehmer_reflex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
    }

    public void startSingleUser(View view) {
        Intent intent = new Intent(MainScreenActivity.this, SingleUserActivity.class);
        startActivity(intent);
    }

    public void startGameshowBuzzer(View view) {
        Intent intent = new Intent(MainScreenActivity.this, PlayersSelectActivity.class);
        startActivity(intent);
    }

    public void startStatistics(View view) {
        Intent intent = new Intent(MainScreenActivity.this, StatisticsActivity.class);
        startActivity(intent);
    }

    public void startBuzzerCounts(View view) {
        Intent intent = new Intent(MainScreenActivity.this, BuzzerCountsActivity.class);
        startActivity(intent);
    }

}

