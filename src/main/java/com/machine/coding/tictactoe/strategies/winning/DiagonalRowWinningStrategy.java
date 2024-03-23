package com.machine.coding.tictactoe.strategies.winning;

import com.machine.coding.tictactoe.model.Board;
import com.machine.coding.tictactoe.model.Move;
import com.machine.coding.tictactoe.model.Symbols;

import java.util.HashMap;
import java.util.Map;

public class DiagonalRowWinningStrategy implements GameWinningStrategy{
    private Map<Symbols, Integer> leftDiagonal = new HashMap<>();
    private Map<Symbols, Integer> rightDiagonal = new HashMap<>();
    @Override
    public boolean checkWinner(Board board, Move move) {
        Symbols symbol = move.getPlayer().getSymbol();;
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        // left diagonal
        if (row == col) {
            if (!leftDiagonal.containsKey(symbol)) {
                leftDiagonal.put(symbol, 0);
            }
            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);
        }

        if (row + col == board.getSize() - 1) {
            if (!rightDiagonal.containsKey(symbol)) {
                rightDiagonal.put(symbol, 0);
            }
            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);
        }

        if (row == col && leftDiagonal.get(symbol).equals(board.getSize())) {
            return true;
        }

        if (row + col == board.getSize() - 1 && rightDiagonal.get(symbol).equals(board.getSize())) {
            return true;
        }
        return false;
    }
}
