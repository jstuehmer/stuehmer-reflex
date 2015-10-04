package com.example.stuehmer.stuehmer_reflex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class PlayersSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players_select);
    }

    public void startTwoPlayer(View view) {
        Intent intent = new Intent(PlayersSelectActivity.this, GameshowBuzzerActivity.class);
        intent.putExtra("numOfPlayers", 2);
        startActivity(intent);
    }

    public void startThreePlayer(View view) {
        Intent intent = new Intent(PlayersSelectActivity.this, GameshowBuzzerActivity.class);
        intent.putExtra("numOfPlayers", 3);
        startActivity(intent);
    }

    public void startFourPlayer(View view) {
        Intent intent = new Intent(PlayersSelectActivity.this, GameshowBuzzerActivity.class);
        intent.putExtra("numOfPlayers", 4);
        startActivity(intent);
    }
}
