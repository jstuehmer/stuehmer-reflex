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

import java.util.ArrayList;
import java.util.Collections;

public class SingleUser extends Player {

    // create an ArrayList of reaction imes
    private ArrayList<Integer> reactionTimes = new ArrayList<>();

    public SingleUser(String playerName) {
        super(playerName);
    }

    // add reaction time to end of list
    public void addTime(int time) {
        this.reactionTimes.add(0, time);
    }

    // clear all the times
    public void clearTime() {
        this.reactionTimes.clear();
    }

    // return the minimum time in the list
    public int minTime() {
        return Collections.min(this.reactionTimes);
    }

    // return the maximum time in the list
    public int maxTime() {
        return Collections.max(this.reactionTimes);
    }

    // return the average time in the list
    public double averageTime() {
        double sum = 0.0;
        for (int i = 0; i < this.reactionTimes.size(); i++) {
            sum += this.reactionTimes.get(i);
        }
        return sum/this.reactionTimes.size();
    }

    // return the median time
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
