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
