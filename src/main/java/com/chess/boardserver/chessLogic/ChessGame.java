package com.chess.boardserver.chessLogic;

import lombok.Data;

@Data
public class ChessGame {
    
    Long id;

    private Position positionWhite;
    private Position positionBlack;
    private boolean whitesTurn;
    private boolean whiteCanRoque;
    private boolean blackCanRoque;


    public ChessGame(){
        this.whitesTurn=true;
        this.whiteCanRoque=true;
        this.blackCanRoque=true;
        
        this.positionWhite = Position.whiteInitialPosition();
        this.positionBlack = Position.blackInitialPosition();

    }


}
