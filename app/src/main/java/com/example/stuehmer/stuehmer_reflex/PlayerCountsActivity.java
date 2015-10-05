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

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class PlayerCountsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_counts);
        TextView textView = (TextView) findViewById(R.id.statsView);
        textView.setText(TwoGameshowBuzzerActivity.p1.getName() + " - " +
                        String.valueOf(TwoGameshowBuzzerActivity.p1.getBuzzerCount()) + "\n" +
                        TwoGameshowBuzzerActivity.p2.getName() + " - " +
                        String.valueOf(TwoGameshowBuzzerActivity.p2.getBuzzerCount()));
    }

}