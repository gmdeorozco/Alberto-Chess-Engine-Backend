package com.chess.boardserver.chessLogic;

import com.chess.boardserver.entities.Board;
import com.chess.boardserver.entities.Casilla;

import lombok.Data;

@Data
public class ChessGame {

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

    public ChessGame( int pieceProof, int index, boolean turn ){
        this.whitesTurn=turn;
        this.whiteCanRoque=true;
        this.blackCanRoque=true;
        
        if ( pieceProof == 2 ){
            this.positionWhite = Position.knightProof( index );
            this.positionBlack = Position.knightProof( index + 1 );
        }
        if ( pieceProof == 3 ){
            this.positionWhite = Position.bishopProof( index );
            this.positionBlack = Position.bishopProof( index + 1 );
        } 
    }

    public ChessGame( Board board){

        this.blackCanRoque = board.isBlackCanRoque();
        this.whiteCanRoque = board.isWhiteCanRoque();
        this.whitesTurn = board.isWhitesTurn();

        this.positionWhite = new Position();
        this.positionBlack = new Position();

        board.getCasillas().stream()
            .forEach(casilla -> setPosition(casilla));
    }

    public void setPosition( Casilla casilla ){
        if( casilla.getColor() == "White"){
            switch( casilla.getPieza() ) {
                case PAWN: 
                    this.positionWhite.getPawnSet().set( casilla.getBitsetNumber());
                    
                    break;
                case BISHOP:
                    this.positionWhite.getBishopSet().set( casilla.getBitsetNumber());
                    break;
                case KING:
                    this.positionWhite.getKingSet().set( casilla.getBitsetNumber());
                    break;
                case KNIGTH:
                    this.positionWhite.getKnightSet().set( casilla.getBitsetNumber());
                    break;
                case QUEEN:
                    this.positionWhite.getQueenSet().set( casilla.getBitsetNumber());
                    break;
                case ROOK:
                    this.positionWhite.getRookSet().set( casilla.getBitsetNumber());
                    break;
                default:
                    break;
            }
            this.positionWhite.recalculatePosition();
        } else {
            switch( casilla.getPieza() ) {
                case PAWN: 
                    this.positionBlack.getPawnSet().set( casilla.getBitsetNumber());
                    break;
                case BISHOP:
                    this.positionBlack.getBishopSet().set( casilla.getBitsetNumber());
                    break;
                case KING:
                    this.positionBlack.getKingSet().set( casilla.getBitsetNumber());
                    break;
                case KNIGTH:
                    this.positionBlack.getKnightSet().set( casilla.getBitsetNumber());
                    break;
                case QUEEN:
                    this.positionBlack.getQueenSet().set( casilla.getBitsetNumber());
                    break;
                case ROOK:
                    this.positionBlack.getRookSet().set( casilla.getBitsetNumber());
                    break;
                default:
                    break;
            }
            this.positionBlack.recalculatePosition();
        }
    }




}
