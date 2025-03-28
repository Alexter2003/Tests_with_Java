package org.example.player;

public class Player {
    private Dice dice;
    private int minNumerToWin;

    public Player(Dice dice, int minNumerToWin) {
        this.dice = dice;
        this.minNumerToWin = minNumerToWin;
    }

    public boolean play(){
        int diceNumber = dice.roll();
        return diceNumber >= minNumerToWin;
    }
}
