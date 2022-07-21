package com.example.tictactoe.models;

public class Cells {
    private int row;
    private int col;
    private Symbol symbol;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Symbol getSymbol() {
        return symbol;
    }


    public boolean isEmpty()
    {
        return symbol==null;
    }

    public void clearCell() {
        this.symbol=null;
    }

    public void setSymbol(Symbol symbol) {
        this.symbol = symbol;
    }
}
