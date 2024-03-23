package com.machine.coding.tictactoe.model;

import com.machine.coding.tictactoe.model.enums.PlayerType;

import java.util.Scanner;

public class Player {
    private long id;
    private String playerName;
    private Symbols symbol;
    private PlayerType playerType;

    public Player(String name, Symbols symbol){
        this.playerName = name;
        this.symbol = symbol;
        this.playerType=PlayerType.HUMAN;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Symbols getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbols symbol) {
        this.symbol = symbol;
    }

    public PlayerType getPlayerType() {
        return playerType;
    }

    public void setPlayerType(PlayerType playerType) {
        this.playerType = playerType;
    }
    public Move executeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the row index where you want to make the move: ");
        int row = scanner.nextInt();

        System.out.println("Please enter the col index where you want to make the move: ");
        int col = scanner.nextInt();

        return new Move(new Cell(row, col), this);
    }
}
