package com.example.aiproject;

public class Step {
    public boolean played;
    public String player;

    public Step() {
        played = false;
        player = "";
    }

    public Step(boolean played, String player) {
        this.played = played;
        this.player = player;
    }
}
