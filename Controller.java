package com.tictactoe;

public class Controller {
    private boolean keepPlaying;
    private Player player;
    public enum Player {X, O};

    public Controller() {
        keepPlaying = true;
        player = Player.X;
    }

    public void switchPlayer() {
        if (player == Player.X) player = Player.O;
            else player = Player.X;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean getKeepPlaying() {
        return keepPlaying;
    }

}
