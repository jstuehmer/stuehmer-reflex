package com.example.stuehmer.stuehmer_reflex;

public class GameshowPlayer extends Player {

    private int buzzerCount = 0;

    public GameshowPlayer(String playerName) {
        super(playerName);
    }

    public int getBuzzerCount() {
        return this.buzzerCount;
    }

    public void increaseBuzzerCount() {
        this.buzzerCount += 1;
    }
}
