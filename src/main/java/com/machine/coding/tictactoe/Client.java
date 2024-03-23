package com.machine.coding.tictactoe;

import com.machine.coding.tictactoe.controller.GameController;
import com.machine.coding.tictactoe.exceptions.InvalidBotCountException;
import com.machine.coding.tictactoe.exceptions.InvalidMoveException;
import com.machine.coding.tictactoe.exceptions.InvalidNumberOfPlayersException;
import com.machine.coding.tictactoe.model.Game;
import com.machine.coding.tictactoe.model.Player;
import com.machine.coding.tictactoe.model.Symbols;
import com.machine.coding.tictactoe.model.enums.GameState;
import com.machine.coding.tictactoe.strategies.winning.ColWinningStrategy;
import com.machine.coding.tictactoe.strategies.winning.DiagonalRowWinningStrategy;
import com.machine.coding.tictactoe.strategies.winning.GameWinningStrategy;
import com.machine.coding.tictactoe.strategies.winning.RowWinningStrategy;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws InvalidBotCountException, InvalidNumberOfPlayersException, InvalidMoveException {
        GameController gameController = new GameController();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the game dimension");

        int dimension = scanner.nextInt();

        List<Player> players = Arrays.asList(new Player("Akhilesh", new Symbols('X')), new Player("AKUL", new Symbols('O')));

        List<GameWinningStrategy> winningStrategies = Arrays.asList(new RowWinningStrategy(), new ColWinningStrategy(), new DiagonalRowWinningStrategy());

        Game game = gameController.startGame(dimension, players, winningStrategies);
        while (GameState.IN_PROGRESS.equals(gameController.getGameState(game))) {
            gameController.displayBoard(game);
            // Undo functionality
            gameController.makeMove(game);
        }
        //While loop will be over if the game has ENDED or game has DRAWN.
        System.out.println("Game finished");
        gameController.displayBoard(game);
        if (gameController.getGameState(game).equals(GameState.ENDED)) {
            System.out.println("Winner is " + gameController.getWinner(game).getPlayerName());
        } else {
            System.out.println("Game DRAWN");
        }
    }
}
