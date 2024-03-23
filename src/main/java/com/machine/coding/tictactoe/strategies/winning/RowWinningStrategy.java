package com.machine.coding.tictactoe.strategies.winning;

import com.machine.coding.tictactoe.model.Board;
import com.machine.coding.tictactoe.model.Move;
import com.machine.coding.tictactoe.model.Symbols;

import java.util.HashMap;
import java.util.Map;

public class RowWinningStrategy implements GameWinningStrategy {
    private Map<Integer, Map<Symbols, Integer>> colMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int col = move.getCell().getCol();
        Symbols symbol = move.getPlayer().getSymbol();
        return checkWiningStratergy(board, col, symbol, colMaps);
    }

    static boolean checkWiningStratergy(Board board, int col, Symbols symbol, Map<Integer, Map<Symbols, Integer>> rowColDigaonalMap) {
        if (!rowColDigaonalMap.containsKey(col)) {
            rowColDigaonalMap.put(col, new HashMap<>());
        }
        Map<Symbols, Integer> colMap = rowColDigaonalMap.get(col);
        colMap.put(symbol, colMap.getOrDefault(symbol, 0) + 1);

        return colMap.get(symbol) == board.getSize();
    }
}
