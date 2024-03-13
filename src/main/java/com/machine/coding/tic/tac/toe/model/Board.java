package com.machine.coding.tic.tac.toe.model;

import com.machine.coding.tic.tac.toe.model.enums.CellState;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<List<Cell>> board;
    private int size;
    public Board(int size) {
        this.size = size;
        board = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            board.add(new ArrayList<>());
            for (int j = 0; j < size; j++) {
                board.get(i).add(new Cell(i, j));
            }
        }
    }

    public void displayBoar() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board.get(i).get(j).getCellState().equals(CellState.EMPTY)) {
                    System.out.print("|  |");
                } else {
                    System.out.print("|" + board.get(i).get(j).getPlayer().getSymbol().getSymbol() + "|");
                }
            }
            System.out.println();
        }
    }

}
