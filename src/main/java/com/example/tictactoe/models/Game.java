package com.example.tictactoe.models;

import com.example.tictactoe.Exceptions.MultipleBotException;
import com.example.tictactoe.Strategies.WinningStrategy;

import java.nio.channels.MulticastChannel;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;
    private List<Players>playersList;
    private List<WinningStrategy>winningStrategyList;
    private int LastPlayerMovedIndex;
    private int numberOfFilledCells=0;
    private GameStatus gameStatus;
    private List<Move>moves;
    private Players winner;

    public Board getBoard() {
        return board;
    }
    public int getLastPlayerMovedIndex() {
        return LastPlayerMovedIndex;
    }
    public List<Players> getPlayersList() {
        return playersList;
    }
    public List<WinningStrategy> getWinningStrategyList() {
        return winningStrategyList;
    }

    public Players getWinner() {
        return winner;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public static Builder create()
    {
        return new Builder();
    }

    public boolean undo()
    {
        if(this.moves.size()==0)
        {
            System.out.println("Wrong");
            return false;
        }
        else
        {
            Move lastmove=this.moves.get(this.moves.size()-1);
            Cells relevantCell=lastmove.getCells();
            relevantCell.clearCell();

            this.LastPlayerMovedIndex-=1;
            this.LastPlayerMovedIndex=(this.LastPlayerMovedIndex+this.playersList.size())%playersList.size();
            this.moves.remove(lastmove);
            return true;
        }

    }
    private Game()
    {
        this.playersList=new ArrayList<>();
        this.winningStrategyList=new ArrayList<>();
        this.gameStatus=GameStatus.IN_PROGRESS;
        this.moves=new ArrayList<>();
        this.LastPlayerMovedIndex=-1;
    }

    public void makeMove()
    {

        this.LastPlayerMovedIndex+=1;
        this.LastPlayerMovedIndex%=this.playersList.size();
        Move move=this.playersList.get(LastPlayerMovedIndex).makeMove(this.board);
        move.getCells().setSymbol(move.getSymbol());
        this.moves.add(move);
        for (WinningStrategy winningStrategy:winningStrategyList)
        {
            if (winningStrategy.checkWin(this.board,this.playersList.get(LastPlayerMovedIndex)))
            {
                this.gameStatus=GameStatus.ENDED;
                this.winner=this.playersList.get(LastPlayerMovedIndex);
                break;
            }
        }
        if (moves.size() ==this.board.getDimension()*this.board.getDimension()) {
            this.gameStatus = GameStatus.DRAW;
        }
    }
    public static class Builder
    {
        //private Board board;
        private List<Players>playersList;
        private List<WinningStrategy>winningStrategyList;
        //private int LastPlayerMovedIndex;
        //private GameStatus gameStatus;
        //private Players winner;
        private int dimension;

        Builder()
        {
            this.playersList=new ArrayList<>();
            this.winningStrategyList=new ArrayList<>();
        }



        public Builder addPlayer(Players players)
        {
            this.playersList.add(players);
            return this;
        }
        public Builder addPlayers(List<Players>players)
        {
            this.playersList.addAll(players);
            return this;
        }
        public Builder setDim(int dimension)
        {
            this.dimension=dimension;
            return this;
        }

        public Builder addWinningStrategy(WinningStrategy winningStrategy)
        {
            this.winningStrategyList.add(winningStrategy);
            return this;
        }
        public Builder addWinningStrategies(List<WinningStrategy>winningStrategy)
        {
            this.winningStrategyList.addAll(winningStrategy);
            return this;
        }


        private boolean checkIfSingleBot()
        {
            int count=0;
            for (Players players:playersList)
            {
                if (players.playerType==PlayerType.BOT)
                    count++;
            }
            return count<=1;
        }
        public Game build() throws MultipleBotException
        {
            if(!checkIfSingleBot()) {
                throw new MultipleBotException();
            }



            Game game = new Game();
            game.playersList.addAll(this.playersList);
            game.winningStrategyList.addAll(this.winningStrategyList);
            game.board=new Board(dimension);
            return game;
        }

    }







}
