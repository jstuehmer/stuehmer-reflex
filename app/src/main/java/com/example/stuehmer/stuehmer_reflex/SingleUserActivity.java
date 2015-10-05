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
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class SingleUserActivity extends AppCompatActivity {

    private Random rand = new Random();
    static SingleUser singleUser = new SingleUser("Single User");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);
    }

    protected void onStart() {
        super.onStart();

        // Thanks to Pentium10 for the idea/implementation for this
        // http://http://stackoverflow.com/questions/2614719/how-do-i-get-the-sharedpreferences-from-a-preferenceactivity-in-android
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.previously_started), false);

        if (!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.previously_started), Boolean.TRUE);
            edit.commit();

            AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            alertDialog.setTitle(getString(R.string.reaction_timer));
            alertDialog.setMessage(getString(R.string.description));
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
            alertDialog.show();
        }
    }

    public void startTimer(View view) {
        final int randomTime = rand.nextInt(1991) + 10;
        final long startTime  = System.currentTimeMillis();
        final Button buzzer = (Button) findViewById(R.id.buzzer);
        buzzer.setText("");

        new Handler().postDelayed(new Runnable() {
            public void run() {
                buzzer.setText(getText(R.string.click));
            }
        }, randomTime);

        buzzer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final long endTime = System.currentTimeMillis();
                int waitTime = (int) (endTime - startTime);
                int reactionTime = waitTime - randomTime;

                if (waitTime <= randomTime) {
                    AlertDialog alertDialog = new AlertDialog.Builder(SingleUserActivity.this).create();
                    alertDialog.setTitle(getString(R.string.too_soon));
                    alertDialog.setMessage(getString(R.string.wait_message));
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            recreate();
                        }
                    });
                    alertDialog.show();
                }
                else {
                    singleUser.addTime(reactionTime);
                    AlertDialog alertDialog = new AlertDialog.Builder(SingleUserActivity.this).create();
                    alertDialog.setTitle(Integer.toString(reactionTime) + " ms");
                    alertDialog.setMessage(getString(R.string.play_again));
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            recreate();
                        }
                    });
                    alertDialog.show();
                }
            }
        });

    }
}
