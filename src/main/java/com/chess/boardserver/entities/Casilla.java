package com.chess.boardserver.entities;

import java.util.BitSet;

import com.chess.boardserver.chessLogic.Piece;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
public class Casilla {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    Long id;

    private String name;
    private Piece pieza = Piece.NONE;
    private String color;

    public Casilla( String name ){
        this.name = name;
        
    }

    public static String getStringNameByIndex( int index ){
        switch( index ){

            case 0 : return "a1"; 
            case 1 : return "b1"; 
            case 2 : return "c1"; 
            case 3 : return "d1"; 
            case 4 : return "e1"; 
            case 5 : return "f1"; 
            case 6 : return "g1"; 
            case 7 : return "h1"; 

            case 8 :  return "a2"; 
            case 9 :  return "b2"; 
            case 10 : return "c2"; 
            case 11 : return "d2"; 
            case 12 : return "e2"; 
            case 13 : return "f2"; 
            case 14 : return "g2"; 
            case 15 : return "h2"; 

            case 16 : return "a3"; 
            case 17 : return "b3"; 
            case 18 : return "c3"; 
            case 19 : return "d3"; 
            case 20 : return "e3"; 
            case 21 : return "f3"; 
            case 22 : return "g3"; 
            case 23 : return "h3"; 

            case 24 : return "a4"; 
            case 25 : return "b4"; 
            case 26 : return "c4"; 
            case 27 : return "d4"; 
            case 28 : return "e4"; 
            case 29 : return "f4"; 
            case 30 : return "g4"; 
            case 31 : return "h4"; 

            case 32 : return "a5"; 
            case 33 : return "b5"; 
            case 34 : return "c5"; 
            case 35 : return "d5"; 
            case 36 : return "e5"; 
            case 37 : return "f5"; 
            case 38 : return "g5"; 
            case 39 : return "h5"; 

            case 40 : return "a6"; 
            case 41 : return "b6"; 
            case 42 : return "c6"; 
            case 43 : return "d6"; 
            case 44 : return "e6"; 
            case 45 : return "f6"; 
            case 46 : return "g6"; 
            case 47 : return "h6"; 

            case 48 : return "a7"; 
            case 49 : return "b7"; 
            case 50 : return "c7"; 
            case 51 : return "d7"; 
            case 52 : return "e7"; 
            case 53 : return "f7"; 
            case 54 : return "g7"; 
            case 55 : return "h7"; 

            case 56 : return "a8"; 
            case 57 : return "b8"; 
            case 58 : return "c8"; 
            case 59 : return "d8"; 
            case 60 : return "e8"; 
            case 61 : return "f8"; 
            case 62 : return "g8"; 
            case 63 : return "h8"; 

            
    }

    return null;

}

    



    public int getBitsetNumber(){
        switch ( this.name.charAt(0) ){
            case 'a': return ( (Integer.valueOf( String.valueOf(this.name.charAt(1)) )-1)*8 );
			case 'b': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 1 );
            case 'c': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 2 );
            case 'd': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 3 );
            case 'e': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 4 );
            case 'f': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 5 );
            case 'g': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 6 );
            case 'h': return ( (Integer.valueOf(  String.valueOf(this.name.charAt(1)))-1)*8 + 7 );
        }
        return 0;
    }

    public BitSet getBitSet(){
        BitSet bitSet = new BitSet(64);
        bitSet.set(getBitsetNumber());
        return bitSet;
    }

    

}