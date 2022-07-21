package com.example.tictactoe.models;

import java.util.Scanner;

public class HumanPlayer extends Players {
    String email;
    String Name;

    public HumanPlayer(Symbol symbol, String email, String Name) {
        super(symbol, PlayerType.HUMAN);
        this.email=email;
        this.Name=Name;

    }

    @Override
    public Symbol getSymbol() {
        return super.getSymbol();
    }

    public Move makeMove(Board board)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter Row");
        int row=sc.nextInt();
        System.out.println("Enter Row");
        int col=sc.nextInt();
        Move move=new Move();
        move.setSymbol(this.getSymbol());
        move.setPlayers(this);
        move.setCells(board.getCell(row,col));
        return move;
    }


}
