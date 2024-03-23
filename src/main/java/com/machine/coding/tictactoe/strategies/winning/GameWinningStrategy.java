package com.machine.coding.tictactoe.strategies.winning;

import com.machine.coding.tictactoe.model.Board;
import com.machine.coding.tictactoe.model.Move;

public interface GameWinningStrategy {
    boolean checkWinner(Board board, Move move);
}
