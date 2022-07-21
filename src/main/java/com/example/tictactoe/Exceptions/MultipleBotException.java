package com.example.tictactoe.Exceptions;

public class MultipleBotException extends Exception {
    public MultipleBotException()
    {
        super("Cannot Have more than 1 bot");
    }

}
