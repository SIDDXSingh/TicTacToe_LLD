package com.example.tictactoe.models;

public class Move {
    private Players players;
    private Cells cells;
    private Symbol symbol;

    public Symbol getSymbol() {
        return symbol;
    }

    public Cells getCells() {
        return cells;
    }

    public Players getPlayers() {
        return players;
    }

    public void setCells(Cells cells) {
        this.cells = cells;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }

    public void setPlayers(Players players) {
        this.players = players;
    }
}
