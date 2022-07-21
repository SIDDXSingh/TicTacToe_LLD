package com.example.tictactoe.Strategies;
import com.example.tictactoe.models.*;

public interface BotMoveStrategy {
    Move makeMove(Board board,Players players);
}
