package com.example.stuehmer.stuehmer_reflex;

public class Player {
    protected String playerName;
    protected int buzzerCount = 0;

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public String getName() {
        return this.playerName;
    }

    public void increaseCount() {
        this.buzzerCount += 1;
    }

    public int getCount() {
        return this.buzzerCount;
    }

}
