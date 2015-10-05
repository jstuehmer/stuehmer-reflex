package com.example.stuehmer.stuehmer_reflex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class StatisticsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("Minimum time = " + String.valueOf(SingleUserActivity.singleUser.minTime()) + "\n" +
            "Maximum time = " + String.valueOf(SingleUserActivity.singleUser.maxTime()) + "\n" +
            "Average time = " + String.valueOf(SingleUserActivity.singleUser.averageTime()) + "\n" +
            "Median time = " + String.valueOf(SingleUserActivity.singleUser.medianTime()));
    }



}
