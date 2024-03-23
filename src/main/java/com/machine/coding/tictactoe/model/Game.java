package com.machine.coding.tictactoe.model;

import com.machine.coding.tictactoe.exceptions.InvalidBotCountException;
import com.machine.coding.tictactoe.exceptions.InvalidMoveException;
import com.machine.coding.tictactoe.exceptions.InvalidNumberOfPlayersException;
import com.machine.coding.tictactoe.model.enums.CellState;
import com.machine.coding.tictactoe.model.enums.GameState;
import com.machine.coding.tictactoe.model.enums.PlayerType;
import com.machine.coding.tictactoe.strategies.winning.GameWinningStrategy;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private Player winner;
    private int nextPlayerMoveIndex;
    private GameState gameState;
    private List<Move> moves;
    private List<GameWinningStrategy> winningStrategies;

    private Game(int dimension, List<Player> players, List<GameWinningStrategy> winningStrategies) {
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.nextPlayerMoveIndex = 0;
        this.winner = null;
        this.winningStrategies = winningStrategies;
        this.players = players;
        this.board = new Board(dimension);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public int getNextPlayerMoveIndex() {
        return nextPlayerMoveIndex;
    }

    public void setNextPlayerMoveIndex(int nextPlayerMoveIndex) {
        this.nextPlayerMoveIndex = nextPlayerMoveIndex;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public List<GameWinningStrategy> getWinningStrategies() {
        return winningStrategies;
    }

    public void setWinningStrategies(List<GameWinningStrategy> winningStrategies) {
        this.winningStrategies = winningStrategies;
    }

    public static Builder builder() {
        return new Builder();
    }

    public void makeMove() throws InvalidMoveException {
        Player currentPlayer = players.get(nextPlayerMoveIndex);
        System.out.println("It is "+ currentPlayer.getPlayerName()+"'s move");

        Move currentMove  = currentPlayer.executeMove(board);
        int row = currentMove.getCell().getRow();
        int col = currentMove.getCell().getCol();

        System.out.println(currentPlayer.getPlayerName()+" has made a move at row : "+row+" and col : "+col);
        nextPlayerMoveIndex = (nextPlayerMoveIndex+1) % players.size();
        Cell cell = board.getBoard().get(row).get(col);
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(currentPlayer);

        Move finalMove = new Move(cell,currentPlayer);
        moves.add(finalMove);

        if(checkWinner(board,finalMove)){
            gameState = GameState.ENDED;
            winner = currentPlayer;
        } else if (moves.size()==board.getSize()*board.getSize()) {
            gameState=GameState.DRAW;
        }


    }

    private boolean checkWinner(Board board, Move move) {
        for(GameWinningStrategy gameWinningStrategy: winningStrategies){
            if(gameWinningStrategy.checkWinner(board,move)){
                return true;
            }
        }
        return  false;
    }

    public boolean validateMove(Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();

        if (row > 0 && row >= board.getSize() || col < 0 && col >= board.getSize()) {
            return false;
        }
        return CellState.EMPTY.equals(board.getBoard().get(row).get(col).getCellState());
    }

    public static class Builder {
        private List<Player> players;
        private List<GameWinningStrategy> winningStrategies;
        private int dimension;

        private Builder() {
            this.players = new ArrayList<>();
            this.winningStrategies = new ArrayList<>();
            this.dimension = 0;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setWinningStrategies(List<GameWinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        boolean validateBotCount() {
            int count = 0;
            for (Player player : players) {
                if (PlayerType.BOT.equals(player.getPlayerType())) {
                    count++;
                }
            }

            return count <= 1;
        }

        private void validate() throws InvalidBotCountException, InvalidNumberOfPlayersException {
            if (players.size() != dimension - 1) {
                throw new InvalidNumberOfPlayersException("Number of players should be 1 less than the dimension");
            }

            if (!validateBotCount()) {
                throw new InvalidBotCountException("Bot count should be <= 1");
            }
        }

        public Game build() throws InvalidBotCountException, InvalidNumberOfPlayersException {
            validate();

            return new Game(dimension, players, winningStrategies);
        }
    }

}
