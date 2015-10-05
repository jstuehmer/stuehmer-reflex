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

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import java.util.ArrayList;

public class TwoGameshowBuzzerActivity extends AppCompatActivity {

    static ArrayList<Player> twoPlayer = new ArrayList<Player>();
    static GameshowPlayer p1 = new GameshowPlayer("Player 1");
    static GameshowPlayer p2 = new GameshowPlayer("Player 2");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.two_player_mode);
        twoPlayer.add(p1);
        twoPlayer.add(p2);
    }

    public void increase1of2(View view) {
        p1.increaseBuzzerCount();
        AlertDialog alertDialog = new AlertDialog.Builder(TwoGameshowBuzzerActivity.this).create();
        alertDialog.setTitle(getString(R.string.player_one) + " answered first");
        alertDialog.setMessage(getString(R.string.play_again));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                recreate();
            }
        });
        alertDialog.show();
    }

    public void increase2of2(View view) {
        p2.increaseBuzzerCount();
        AlertDialog alertDialog = new AlertDialog.Builder(TwoGameshowBuzzerActivity.this).create();
        alertDialog.setTitle(getString(R.string.player_two) + " answered first");
        alertDialog.setMessage(getString(R.string.play_again));
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                recreate();
            }
        });
        alertDialog.show();
    }
}
