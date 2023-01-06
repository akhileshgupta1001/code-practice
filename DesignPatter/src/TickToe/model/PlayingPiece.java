package model;

public class PlayingPiece {
    private GameSymbol gameSymbol;
    PlayingPiece(GameSymbol gameSymbol){
        this.gameSymbol=gameSymbol;
    }

    public GameSymbol getGameSymbol() {
        return gameSymbol;
    }

    public void setGameSymbol(GameSymbol gameSymbol) {
        this.gameSymbol = gameSymbol;
    }
}
