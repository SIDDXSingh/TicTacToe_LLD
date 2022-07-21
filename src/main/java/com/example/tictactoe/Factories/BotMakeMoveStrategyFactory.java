package com.example.tictactoe.Factories;

import com.example.tictactoe.Strategies.BotEasyMovingStrategy;
import com.example.tictactoe.Strategies.BotMoveStrategy;
import com.example.tictactoe.models.DifficultyLevel;

public class BotMakeMoveStrategyFactory {
    DifficultyLevel difficultyLevel;

    public BotMakeMoveStrategyFactory(DifficultyLevel difficultyLevel)
    {
        this.difficultyLevel=difficultyLevel;
    }
    public BotMoveStrategy createMoveStrategy()
    {
        return new BotEasyMovingStrategy();
    }
}

