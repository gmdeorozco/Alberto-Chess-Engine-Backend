package com.chess.boardserver.entities;

import java.util.ArrayList;
import java.util.List;

import com.chess.boardserver.chessLogic.ChessGame;
import com.chess.boardserver.chessLogic.Piece;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;

    @OneToMany(cascade = CascadeType.ALL)
    List<Casilla> casillas = new ArrayList<>();


    public Board( ChessGame chessGame){

       
        casillas.add(new Casilla("a1"));
        casillas.add(new Casilla("a2"));
        casillas.add(new Casilla("a3"));
        casillas.add(new Casilla("a4"));
        casillas.add(new Casilla("a5"));
        casillas.add(new Casilla("a6"));
        casillas.add(new Casilla("a7"));
        casillas.add(new Casilla("a8"));

        casillas.add(new Casilla("b1"));
        casillas.add(new Casilla("b2"));
        casillas.add(new Casilla("b3"));
        casillas.add(new Casilla("b4"));
        casillas.add(new Casilla("b5"));
        casillas.add(new Casilla("b6"));
        casillas.add(new Casilla("b7"));
        casillas.add(new Casilla("b8"));
        
        casillas.add(new Casilla("c1"));
        casillas.add(new Casilla("c2"));
        casillas.add(new Casilla("c3"));
        casillas.add(new Casilla("c4"));
        casillas.add(new Casilla("c5"));
        casillas.add(new Casilla("c6"));
        casillas.add(new Casilla("c7"));
        casillas.add(new Casilla("c8"));

        casillas.add(new Casilla("d1"));
        casillas.add(new Casilla("d2"));
        casillas.add(new Casilla("d3"));
        casillas.add(new Casilla("d4"));
        casillas.add(new Casilla("d5"));
        casillas.add(new Casilla("d6"));
        casillas.add(new Casilla("d7"));
        casillas.add(new Casilla("d8"));

        casillas.add(new Casilla("e1"));
        casillas.add(new Casilla("e2"));
        casillas.add(new Casilla("e3"));
        casillas.add(new Casilla("e4"));
        casillas.add(new Casilla("e5"));
        casillas.add(new Casilla("e6"));
        casillas.add(new Casilla("e7"));
        casillas.add(new Casilla("e8"));

        casillas.add(new Casilla("f1"));
        casillas.add(new Casilla("f2"));
        casillas.add(new Casilla("f3"));
        casillas.add(new Casilla("f4"));
        casillas.add(new Casilla("f5"));
        casillas.add(new Casilla("f6"));
        casillas.add(new Casilla("f7"));
        casillas.add(new Casilla("f8"));

        casillas.add(new Casilla("g1"));
        casillas.add(new Casilla("g2"));
        casillas.add(new Casilla("g3"));
        casillas.add(new Casilla("g4"));
        casillas.add(new Casilla("g5"));
        casillas.add(new Casilla("g6"));
        casillas.add(new Casilla("g7"));
        casillas.add(new Casilla("g8"));

        casillas.add(new Casilla("h1"));
        casillas.add(new Casilla("h2"));
        casillas.add(new Casilla("h3"));
        casillas.add(new Casilla("h4"));
        casillas.add(new Casilla("h5"));
        casillas.add(new Casilla("h6"));
        casillas.add(new Casilla("h7"));
        casillas.add(new Casilla("h8"));

        casillas.stream()
            .forEach(casilla -> configureCasilla(casilla, chessGame));


    }

    public void configureCasilla( Casilla casilla, ChessGame chessGame){
   

        int ind = casilla.getBitsetNumber();

        if( chessGame.getPositionWhite().pawnSet.get(ind)) { casilla.setColor("White"); casilla.setPieza(Piece.PAWN); }
        else if( chessGame.getPositionWhite().knightSet.get(ind)) { casilla.setColor("White"); casilla.setPieza(Piece.KNIGTH); }
        else if( chessGame.getPositionWhite().bishopSet.get(ind)) { casilla.setColor("White"); casilla.setPieza(Piece.BISHOP); }
        else if( chessGame.getPositionWhite().rookSet.get(ind)) { casilla.setColor("White"); casilla.setPieza(Piece.ROOK); }
        else if( chessGame.getPositionWhite().queenSet.get(ind)) { casilla.setColor("White"); casilla.setPieza(Piece.QUEEN); }
        else if( chessGame.getPositionWhite().kingSet.get(ind)) { casilla.setColor("White"); casilla.setPieza(Piece.KING); }

        else if( chessGame.getPositionBlack().pawnSet.get(ind)) { casilla.setColor("Black"); casilla.setPieza(Piece.PAWN); }
        else if( chessGame.getPositionBlack().knightSet.get(ind)) { casilla.setColor("Black"); casilla.setPieza(Piece.KNIGTH); }
        else if( chessGame.getPositionBlack().bishopSet.get(ind)) { casilla.setColor("Black"); casilla.setPieza(Piece.BISHOP); }
        else if( chessGame.getPositionBlack().rookSet.get(ind)) { casilla.setColor("Black"); casilla.setPieza(Piece.ROOK); }
        else if( chessGame.getPositionBlack().queenSet.get(ind)) { casilla.setColor("Black"); casilla.setPieza(Piece.QUEEN); }
        else if( chessGame.getPositionBlack().kingSet.get(ind)) { casilla.setColor("Black"); casilla.setPieza(Piece.KING); }
        
    }

}


