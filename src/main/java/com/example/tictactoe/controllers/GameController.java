package com.example.tictactoe.controllers;

import com.example.tictactoe.Strategies.WinningStrategy;
import com.example.tictactoe.models.Game;
import com.example.tictactoe.models.GameStatus;
import com.example.tictactoe.models.Move;
import com.example.tictactoe.models.Players;

import java.util.List;

public class GameController {



    public Game gameCreator(int dimension, List<Players> players, List<WinningStrategy> winningStrategy)
    {
        Game game=null;
        try {
            game=Game.create().setDim(dimension).addPlayers(players).addWinningStrategies(winningStrategy).build();
        }
        catch (Exception exception)
        {
            System.out.println("Something Wrong");
        }
        return game;
    }

    public void makeMove(Game game)
    {
        game.makeMove();
    }
    public boolean undo(Game game)
    {
        return game.undo();
    }
    public Players getWinner(Game game)
    {
        return game.getWinner();
    }
    public GameStatus gameStatus(Game game)
    {
        return game.getGameStatus();
    }

    public void display(Game game) {
        game.getBoard().printBoard();
    }
}
