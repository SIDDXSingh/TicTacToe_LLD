package com.example.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cells>> board;
    private int dimension;


    public Board(int dimension)//Board Constructor for creating for of dimension= dimension
    {
        this.dimension=dimension;
        board=new ArrayList<>();
        for (int i=0; i<dimension;++i)
        {
            board.add(new ArrayList<>());

            for (int j=0; j<dimension;++j)
            {
                board.get(i).add(new Cells());
            }
        }
    }

    public Cells getCell(int i,int j)
    {
        return board.get(i).get(j);
    }
    public int getDimension() {
        return dimension;
    }
    public List<List<Cells>> getBoard() {
        return board;
    }



    public void printBoard() {
        for (List<Cells> row: board)
        {
            for (Cells cells:row)
            {
                if (cells.getSymbol()==null)
                {
                    System.out.print("|  |");
                }
                else {
                    System.out.print("| " + cells.getSymbol().getAchar() + " |");
                }

            }
            System.out.println();
        }
    }
}
