package com.example.tictactoe.models;

import com.example.tictactoe.Factories.BotMakeMoveStrategyFactory;
import com.example.tictactoe.Strategies.BotMoveStrategy;

public class BotPlayer extends Players{
    private DifficultyLevel difficultyLevel;
    private BotMoveStrategy botMoveStrategy;

    public BotPlayer(DifficultyLevel difficultyLevel, Symbol symbol)
    {
        super(symbol, PlayerType.BOT);
        this.difficultyLevel=difficultyLevel;
        this.botMoveStrategy= new BotMakeMoveStrategyFactory(this.difficultyLevel).createMoveStrategy();

    }

    @Override
    public Move makeMove(Board board) {
        return this.botMoveStrategy.makeMove(board,this);
    }
}
