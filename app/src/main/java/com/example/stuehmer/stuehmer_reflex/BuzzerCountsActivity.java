/*
stuehmer-reflex: Reaction timer and gameshow buzzer application

Copyright (C) 2015 Justin Stuehmer stuehmer@ualberta.ca

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/

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

    // start activity for 2 player counts
    public void showTwoPlayer(View view) {
        Intent intent = new Intent(BuzzerCountsActivity.this, PlayerCountsActivity.class);
        startActivity(intent);
    }

    // start activity for 3 player counts
    public void showThreePlayer(View view) {
        Intent intent = new Intent(BuzzerCountsActivity.this, PlayerCountsActivity.class);
        intent.putExtra("numOfPlayers", 3);
        startActivity(intent);
    }

    // start activity for 4 player counts
    public void showFourPlayer(View view) {
        Intent intent = new Intent(BuzzerCountsActivity.this, PlayerCountsActivity.class);
        intent.putExtra("numOfPlayers", 4);
        startActivity(intent);
    }
}
