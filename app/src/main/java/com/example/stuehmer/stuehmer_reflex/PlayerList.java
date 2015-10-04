package com.example.stuehmer.stuehmer_reflex;

import java.util.ArrayList;
import java.util.Collection;

public class PlayerList {

    protected ArrayList<Player> playerList;

    public PlayerList() {
        this.playerList = new ArrayList<Player>();
    }

    public Collection<Player> getPlayers() {
        return this.playerList;
    }

    public void addPlayer(Player player) {
        this.playerList.add(player);
    }
}
