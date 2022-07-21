package com.example.tictactoe.Strategies;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Players;

public interface WinningStrategy {
    public boolean checkWin(Board board, Players player);
}
