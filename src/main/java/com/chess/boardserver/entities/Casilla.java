package com.chess.boardserver.entities;

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
    private Piece pieza;
    private String color;

    public Casilla( String name ){
        this.name = name;
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
}

