package com.machine.coding.tictactoe.strategies.winning;

import com.machine.coding.tictactoe.model.Board;
import com.machine.coding.tictactoe.model.Move;
import com.machine.coding.tictactoe.model.Symbols;

import java.util.HashMap;
import java.util.Map;

public class ColWinningStrategy implements GameWinningStrategy {

    private Map<Integer, Map<Symbols, Integer>> colMaps = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
       int col =move.getCell().getCol();
       Symbols symbol = move.getPlayer().getSymbol();;
        return RowWinningStrategy.checkWiningStratergy(board, col, symbol, colMaps);
    }
}
