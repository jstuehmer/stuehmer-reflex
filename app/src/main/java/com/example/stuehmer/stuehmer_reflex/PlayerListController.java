package com.example.stuehmer.stuehmer_reflex;


import java.util.Collection;

public class PlayerListController {

    private static PlayerList playerList = null;

    static public PlayerList getPlayerList() {
        if (playerList == null) {
            playerList = new PlayerList();
        }
        return playerList;
    }

    public Collection getPlayer() throws EmptyPlayerListException{
        return getPlayerList().getPlayers();
    }

}
