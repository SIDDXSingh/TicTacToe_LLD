package com.example.tictactoe.Strategies;

import com.example.tictactoe.models.*;

import java.util.List;

public class BotEasyMovingStrategy implements BotMoveStrategy {
    @Override
    public Move makeMove(Board board, Players players)
    {
        for(List<Cells>row:board.getBoard())
        {
            for(Cells cell:row)
            {
                if(cell.isEmpty())
                {
                    Move move=new Move();
                    move.setCells(cell);
                    move.setSymbol(players.getSymbol());
                    move.setPlayers(players);
                    return move;
                }
            }
        }
        return null;
    }

}
