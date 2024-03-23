package com.machine.coding.tictactoe.controller;

import com.machine.coding.tictactoe.exceptions.InvalidBotCountException;
import com.machine.coding.tictactoe.exceptions.InvalidMoveException;
import com.machine.coding.tictactoe.exceptions.InvalidNumberOfPlayersException;
import com.machine.coding.tictactoe.model.Game;
import com.machine.coding.tictactoe.model.Player;
import com.machine.coding.tictactoe.model.enums.GameState;
import com.machine.coding.tictactoe.strategies.winning.GameWinningStrategy;

import java.util.List;

public class GameController {
    public Game startGame(int dimension, List<Player> players, List<GameWinningStrategy> winningStrategies) throws InvalidBotCountException, InvalidNumberOfPlayersException {
        return Game.builder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameState getGameState(Game game) {
        return game.getGameState();
    }

    public void undo(Game game) {

    }

    public void displayBoard(Game game) {
        game.getBoard().displayBoard();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }
}
