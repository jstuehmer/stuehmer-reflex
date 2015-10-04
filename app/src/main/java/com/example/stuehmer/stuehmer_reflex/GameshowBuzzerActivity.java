package com.example.stuehmer.stuehmer_reflex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class GameshowBuzzerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent rIntent = getIntent();
        int numOfPlayers = rIntent.getIntExtra("numOfPlayers", 0);

        if (numOfPlayers == 2) {
            setContentView(R.layout.two_player_mode);
        }
        if (numOfPlayers == 3) {
            setContentView(R.layout.three_player_mode);
        }
        if (numOfPlayers == 4) {
            setContentView(R.layout.four_player_mode);
        }
    }
}
