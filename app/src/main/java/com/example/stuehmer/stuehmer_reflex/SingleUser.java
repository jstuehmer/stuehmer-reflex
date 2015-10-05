package com.example.stuehmer.stuehmer_reflex;


import java.util.ArrayList;
import java.util.Collections;

public class SingleUser extends Player {

    private ArrayList<Integer> reactionTimes = new ArrayList<>();

    public SingleUser(String playerName) {
        super(playerName);
    }

    // add reaction time to start of list
    public void addTime(int time) {
        this.reactionTimes.add(0, time);
    }

    public int minTime() {
        return Collections.min(this.reactionTimes);
    }

    public int maxTime() {
        return Collections.max(this.reactionTimes);
    }

    public double averageTime() {
        double sum = 0.0;
        for (int i = 0; i < this.reactionTimes.size(); i++) {
            sum += this.reactionTimes.get(i);
        }
        return sum/this.reactionTimes.size();
    }

    public double medianTime() {
        ArrayList<Integer> sortedTimes = this.reactionTimes;
        Collections.sort(sortedTimes);
        if (sortedTimes.size() % 2 == 1) {
            return sortedTimes.get((sortedTimes.size()+1)/2-1);
        }
        else {
            double lower = sortedTimes.get(sortedTimes.size()/2-1);
            double upper = sortedTimes.get(sortedTimes.size()/2);

            return (lower + upper) / 2.0;
        }
    }
}
