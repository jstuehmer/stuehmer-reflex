package com.example.stuehmer.stuehmer_reflex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class BuzzerCountsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buzzer_counts);
    }

    public void showTwoPlayer(View view) {
        Intent intent = new Intent(BuzzerCountsActivity.this, PlayerCountsActivity.class);
        startActivity(intent);
    }

    public void showThreePlayer(View view) {
        Intent intent = new Intent(BuzzerCountsActivity.this, PlayerCountsActivity.class);
        intent.putExtra("numOfPlayers", 3);
        startActivity(intent);
    }

    public void showFourPlayer(View view) {
        Intent intent = new Intent(BuzzerCountsActivity.this, PlayerCountsActivity.class);
        intent.putExtra("numOfPlayers", 4);
        startActivity(intent);
    }
}
