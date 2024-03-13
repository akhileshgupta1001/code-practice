package com.machine.coding.tic.tac.toe.exceptions;

public class InvalidNumberOfPlayersException extends RuntimeException{

    public InvalidNumberOfPlayersException(String message){
        super(message);
    }

}
