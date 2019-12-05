package org.team68;

public class Launcher {

    public static void main(String[] args) {
        GrabNewGame grabNewGame = new GrabNewGame();
        try {
            grabNewGame.execute();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
