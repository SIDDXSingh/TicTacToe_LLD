package com.example.tictactoe.Strategies;

import com.example.tictactoe.models.Board;
import com.example.tictactoe.models.Players;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class NormalWinningStrategy implements WinningStrategy{
    private List<HashMap<Character, Integer>> rowCharCounts;
    private List<HashMap<Character, Integer>> colCharCounts;

    private void intitializationCounts(Board board)
    {
        rowCharCounts =new ArrayList<>();
        colCharCounts=new ArrayList<>();
        for (int i=0;i<board.getDimension();i++)
        {
            rowCharCounts.add(new HashMap<>());
            colCharCounts.add(new HashMap<>());
        }
    }

    @Override
    public boolean checkWin(Board board, Players player) {
        return false;
    }
}
