package com.example.tictactoe.models;

abstract public class Players {
    String Name;
    Symbol symbol;
    PlayerType playerType;
    Players(Symbol symbol, PlayerType playerType)
    {
        this.symbol=symbol;
        this.playerType=playerType;

    }


    public PlayerType getPlayerType() {
        return playerType;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public String getName() {
        return Name;
    }

    public abstract Move makeMove(Board board);

}
