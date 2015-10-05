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