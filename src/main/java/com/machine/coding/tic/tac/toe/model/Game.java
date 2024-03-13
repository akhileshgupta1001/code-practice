package com.machine.coding.tic.tac.toe.model;

import com.machine.coding.tic.tac.toe.exceptions.InvalidNumberOfPlayersException;
import com.machine.coding.tic.tac.toe.model.enums.GameState;
import com.machine.coding.tic.tac.toe.strategies.winning.GameWinningStrategy;

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

    public static Builder getBuilder(){
        return new Builder();
    }

    public static class Builder{
        private List<Player> players;
        private List<GameWinningStrategy> winningStrategies;
        private int dimension;

        private Builder(){
            this.players = new ArrayList<>();
            this.winningStrategies =new ArrayList<>();
            this.dimension=0;
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

        boolean validateBotCount(){
            return false;
        }

        private void validate(){
          if(players.size() != dimension-1){
              throw new InvalidNumberOfPlayersException("Number of players should be 1 less than the dimension");
          }


        }
    }

}
