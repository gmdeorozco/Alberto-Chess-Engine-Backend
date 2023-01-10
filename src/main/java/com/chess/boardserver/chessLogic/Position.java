package com.chess.boardserver.chessLogic;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;


public class Position {

    private BitSet pawnSet;
    private BitSet knightSet;
    private BitSet bishopSet;
    private BitSet rookSet;
    private BitSet queenSet;
    private BitSet kingSet;
    private BitSet occupied;
    private BitSet nonOccupied;

    private final BitSet A1 = new BitSet( 64 );
    private final BitSet A2 = new BitSet( 64 );
    private final BitSet A3 = new BitSet( 64 );
    private final BitSet A4 = new BitSet( 64 );
    private final BitSet A5 = new BitSet( 64 );
    private final BitSet A6 = new BitSet( 64 );
    private final BitSet A7 = new BitSet( 64 );
    private final BitSet A8 = new BitSet( 64 );
    private final BitSet B1 = new BitSet( 64 );
    private final BitSet B2 = new BitSet( 64 );
    private final BitSet B3 = new BitSet( 64 );
    private final BitSet B4 = new BitSet( 64 );
    private final BitSet B5 = new BitSet( 64 );
    private final BitSet B6 = new BitSet( 64 );
    private final BitSet B7 = new BitSet( 64 );
    private final BitSet B8 = new BitSet( 64 );
    private final BitSet C1 = new BitSet( 64 );
    private final BitSet C2 = new BitSet( 64 );
    private final BitSet C3 = new BitSet( 64 );
    private final BitSet C4 = new BitSet( 64 );
    private final BitSet C5 = new BitSet( 64 );
    private final BitSet C6 = new BitSet( 64 );
    private final BitSet C7 = new BitSet( 64 );
    private final BitSet C8 = new BitSet( 64 );
    private final BitSet D1 = new BitSet( 64 );
    private final BitSet D2 = new BitSet( 64 );
    private final BitSet D3 = new BitSet( 64 );
    private final BitSet D4 = new BitSet( 64 );
    private final BitSet D5 = new BitSet( 64 );
    private final BitSet D6 = new BitSet( 64 );
    private final BitSet D7 = new BitSet( 64 );
    private final BitSet D8 = new BitSet( 64 );
    private final BitSet E1 = new BitSet( 64 );
    private final BitSet E2 = new BitSet( 64 );
    private final BitSet E3 = new BitSet( 64 );
    private final BitSet E4 = new BitSet( 64 );
    private final BitSet E5 = new BitSet( 64 );
    private final BitSet E6 = new BitSet( 64 );
    private final BitSet E7 = new BitSet( 64 );
    private final BitSet E8 = new BitSet( 64 );
    private final BitSet F1 = new BitSet( 64 );
    private final BitSet F2 = new BitSet( 64 );
    private final BitSet F3 = new BitSet( 64 );
    private final BitSet F4 = new BitSet( 64 );
    private final BitSet F5 = new BitSet( 64 );
    private final BitSet F6 = new BitSet( 64 );
    private final BitSet F7 = new BitSet( 64 );
    private final BitSet F8 = new BitSet( 64 );
    private final BitSet G1 = new BitSet( 64 );
    private final BitSet G2 = new BitSet( 64 );
    private final BitSet G3 = new BitSet( 64 );
    private final BitSet G4 = new BitSet( 64 );
    private final BitSet G5 = new BitSet( 64 );
    private final BitSet G6 = new BitSet( 64 );
    private final BitSet G7 = new BitSet( 64 );
    private final BitSet G8 = new BitSet( 64 );
    private final BitSet H1 = new BitSet( 64 );
    private final BitSet H2 = new BitSet( 64 );
    private final BitSet H3 = new BitSet( 64 );
    private final BitSet H4 = new BitSet( 64 );
    private final BitSet H5 = new BitSet( 64 );
    private final BitSet H6 = new BitSet( 64 );
    private final BitSet H7 = new BitSet( 64 );
    private final BitSet H8 = new BitSet( 64 );

    private final BitSet ROW_1 = new BitSet( 64 );
    private final BitSet ROW_2 = new BitSet( 64 );
    private final BitSet ROW_3 = new BitSet( 64 );
    private final BitSet ROW_4 = new BitSet( 64 );
    private final BitSet ROW_5 = new BitSet( 64 );
    private final BitSet ROW_6 = new BitSet( 64 );
    private final BitSet ROW_7 = new BitSet( 64 );
    private final BitSet ROW_8 = new BitSet( 64 );

    private final BitSet COL_A = new BitSet( 64 );
    private final BitSet COL_B = new BitSet( 64 );
    private final BitSet COL_C = new BitSet( 64 );
    private final BitSet COL_D = new BitSet( 64 );
    private final BitSet COL_E = new BitSet( 64 );
    private final BitSet COL_F = new BitSet( 64 );
    private final BitSet COL_G = new BitSet( 64 );
    private final BitSet COL_H = new BitSet( 64 );

    private final BitSet DIAGUP_A7_B8 = new BitSet( 64 );
    private final BitSet DIAGUP_A6_C8 = new BitSet( 64 );
    private final BitSet DIAGUP_A5_D8 = new BitSet( 64 );
    private final BitSet DIAGUP_A4_E8 = new BitSet( 64 );
    private final BitSet DIAGUP_A3_F8 = new BitSet( 64 );
    private final BitSet DIAGUP_A2_G8 = new BitSet( 64 );
    private final BitSet DIAGUP_A1_H8 = new BitSet( 64 );
    private final BitSet DIAGUP_B1_H7 = new BitSet( 64 );
    private final BitSet DIAGUP_C1_H6 = new BitSet( 64 );
    private final BitSet DIAGUP_D1_H5 = new BitSet( 64 );
    private final BitSet DIAGUP_E1_H4 = new BitSet( 64 );
    private final BitSet DIAGUP_F1_H3 = new BitSet( 64 );
    private final BitSet DIAGUP_G1_H2 = new BitSet( 64 );

    private final BitSet DIAGDOWN_A2_B1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_A3_C1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_A4_D1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_A5_E1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_A6_F1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_A7_G1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_A8_H1 = new BitSet( 64 );
    private final BitSet DIAGDOWN_B8_H2 = new BitSet( 64 );
    private final BitSet DIAGDOWN_C8_H3 = new BitSet( 64 );
    private final BitSet DIAGDOWN_D8_H4 = new BitSet( 64 );
    private final BitSet DIAGDOWN_E8_H5 = new BitSet( 64 );
    private final BitSet DIAGDOWN_F8_H6 = new BitSet( 64 );
    private final BitSet DIAGDOWN_G8_H7 = new BitSet( 64 );

    private List<BitSet> rows = new ArrayList<>();
    private List<BitSet> cols = new ArrayList<>();
    private List<BitSet> diagsUp = new ArrayList<>();
    private List<BitSet> diagsDown = new ArrayList<>();


    public Position(){
        this.pawnSet =  new BitSet(64);
        this.knightSet =  new BitSet(64);
        this.bishopSet =  new BitSet(64);
        this.rookSet =  new BitSet(64);
        this.queenSet =  new BitSet(64);
        this.kingSet =  new BitSet(64);
        this.occupied =  new BitSet(64);
        this.nonOccupied = new BitSet(64);

        A1.set( 0 );
        A2.set( 8 );
        A3.set( 16 );
        A4.set( 24 );
        A5.set( 32 );
        A6.set( 40 );
        A7.set( 48 );
        A8.set( 56 );
        B1.set( 1 );
        B2.set( 9 );
        B3.set( 17 );
        B4.set( 25 );
        B5.set( 33 );
        B6.set( 41 );
        B7.set( 49 );
        B8.set( 57 );
        C1.set( 2 );
        C2.set( 10 );
        C3.set( 18 );
        C4.set( 26 );
        C5.set( 34 );
        C6.set( 42 );
        C7.set( 50 );
        C8.set( 58 );
        D1.set( 3 );
        D2.set( 11 );
        D3.set( 19 );
        D4.set( 27 );
        D5.set( 35 );
        D6.set( 43 );
        D7.set( 51 );
        D8.set( 59 );
        E1.set( 4 );
        E2.set( 12 );
        E3.set( 20 );
        E4.set( 28 );
        E5.set( 36 );
        E6.set( 44 );
        E7.set( 52 );
        E8.set( 60 );
        F1.set( 5 );
        F2.set( 13 );
        F3.set( 21 );
        F4.set( 29 );
        F5.set( 37 );
        F6.set( 45 );
        F7.set( 53 );
        F8.set( 61 );
        G1.set( 6 );
        G2.set( 14 );
        G3.set( 22 );
        G4.set( 30 );
        G5.set( 38 );
        G6.set( 46 );
        G7.set( 54 );
        G8.set( 62 );
        H1.set( 7 );
        H2.set( 15 );
        H3.set( 23 );
        H4.set( 31 );
        H5.set( 39 );
        H6.set( 47 );
        H7.set( 55 );
        H8.set( 63 );

        ROW_1.set(  0 ,  8 );
        ROW_2.set(  8 , 16 );
        ROW_3.set( 16 , 24 );
        ROW_4.set( 24 , 32 );
        ROW_5.set( 32 , 40 );
        ROW_6.set( 40 , 48 );
        ROW_7.set( 48 , 56 );
        ROW_8.set( 56 , 64 );

        setCol(0 , COL_A);
        setCol( 1 , COL_B);
        setCol( 2 , COL_C);
        setCol( 3 , COL_D);
        setCol( 4 , COL_E);
        setCol( 5 , COL_F);
        setCol( 6 , COL_G);
        setCol( 7 , COL_H);

        DIAGUP_A7_B8.set( 48 );
        DIAGUP_A7_B8.set( 57 );

        DIAGUP_A6_C8.set( 40 );
        DIAGUP_A6_C8.set( 49 );
        DIAGUP_A6_C8.set( 58 );

        DIAGUP_A5_D8.set( 32 );
        DIAGUP_A5_D8.set( 41 );
        DIAGUP_A5_D8.set( 50 );
        DIAGUP_A5_D8.set( 59 );

        DIAGUP_A4_E8.set( 24 );
        DIAGUP_A4_E8.set( 33 );
        DIAGUP_A4_E8.set( 42 );
        DIAGUP_A4_E8.set( 51 );
        DIAGUP_A4_E8.set( 60 );

        DIAGUP_A3_F8.set( 16 );
        DIAGUP_A3_F8.set( 25 );
        DIAGUP_A3_F8.set( 34 );
        DIAGUP_A3_F8.set( 43 );
        DIAGUP_A3_F8.set( 52 );
        DIAGUP_A3_F8.set( 61 );

        DIAGUP_A2_G8.set( 8 );
        DIAGUP_A2_G8.set( 17 );
        DIAGUP_A2_G8.set( 26 );
        DIAGUP_A2_G8.set( 35 );
        DIAGUP_A2_G8.set( 44 );
        DIAGUP_A2_G8.set( 53 );
        DIAGUP_A2_G8.set( 62 );

        DIAGUP_A1_H8.set( 0 );
        DIAGUP_A1_H8.set( 9 );
        DIAGUP_A1_H8.set( 18 );
        DIAGUP_A1_H8.set( 27 );
        DIAGUP_A1_H8.set( 36 );
        DIAGUP_A1_H8.set( 45 );
        DIAGUP_A1_H8.set( 54 );
        DIAGUP_A1_H8.set( 63 );

        DIAGUP_B1_H7.set( 1 );
        DIAGUP_B1_H7.set( 10 );
        DIAGUP_B1_H7.set( 19 );
        DIAGUP_B1_H7.set( 28 );
        DIAGUP_B1_H7.set( 37 );
        DIAGUP_B1_H7.set( 46 );
        DIAGUP_B1_H7.set( 55 );

        DIAGUP_C1_H6.set( 2 );
        DIAGUP_C1_H6.set( 11 );
        DIAGUP_C1_H6.set( 20 );
        DIAGUP_C1_H6.set( 29 );
        DIAGUP_C1_H6.set( 38 );
        DIAGUP_C1_H6.set( 47 );

        DIAGUP_D1_H5.set( 3 );
        DIAGUP_D1_H5.set( 12 );
        DIAGUP_D1_H5.set( 21 );
        DIAGUP_D1_H5.set( 30 );
        DIAGUP_D1_H5.set( 39 );
        

        DIAGUP_E1_H4.set( 4 );
        DIAGUP_E1_H4.set( 13 );
        DIAGUP_E1_H4.set( 22 );
        DIAGUP_E1_H4.set( 31 );

        DIAGUP_F1_H3.set( 5 );
        DIAGUP_F1_H3.set( 14 );
        DIAGUP_F1_H3.set( 23 );

        DIAGUP_G1_H2.set( 6 );
        DIAGUP_G1_H2.set( 15 );
        
        DIAGDOWN_A2_B1.set( 8 );
        DIAGDOWN_A2_B1.set( 1 );

        DIAGDOWN_A3_C1.set( 16 );
        DIAGDOWN_A3_C1.set( 9 );
        DIAGDOWN_A3_C1.set( 2 );

        DIAGDOWN_A4_D1.set( 24 );
        DIAGDOWN_A4_D1.set( 17 );
        DIAGDOWN_A4_D1.set( 10 );
        DIAGDOWN_A4_D1.set( 3 );

        DIAGDOWN_A5_E1.set( 4 );
        DIAGDOWN_A5_E1.set( 11 );
        DIAGDOWN_A5_E1.set( 18 );
        DIAGDOWN_A5_E1.set( 25 );
        DIAGDOWN_A5_E1.set( 32 );

        DIAGDOWN_A6_F1.set( 5 );
        DIAGDOWN_A6_F1.set( 12 );
        DIAGDOWN_A6_F1.set( 19 );
        DIAGDOWN_A6_F1.set( 26 );
        DIAGDOWN_A6_F1.set( 33 );
        DIAGDOWN_A6_F1.set( 40 );

        DIAGDOWN_A7_G1.set( 6 );
        DIAGDOWN_A7_G1.set( 13 );
        DIAGDOWN_A7_G1.set( 20 );
        DIAGDOWN_A7_G1.set( 27 );
        DIAGDOWN_A7_G1.set( 34 );
        DIAGDOWN_A7_G1.set( 41 );
        DIAGDOWN_A7_G1.set( 48 );

        DIAGDOWN_A8_H1.set( 7 );
        DIAGDOWN_A8_H1.set( 14 );
        DIAGDOWN_A8_H1.set( 21 );
        DIAGDOWN_A8_H1.set( 28 );
        DIAGDOWN_A8_H1.set( 35 );
        DIAGDOWN_A8_H1.set( 42 );
        DIAGDOWN_A8_H1.set( 49 );
        DIAGDOWN_A8_H1.set( 56 );

        DIAGDOWN_B8_H2.set( 15 );
        DIAGDOWN_B8_H2.set( 22 );
        DIAGDOWN_B8_H2.set( 29 );
        DIAGDOWN_B8_H2.set( 36 );
        DIAGDOWN_B8_H2.set( 43 );
        DIAGDOWN_B8_H2.set( 50 );
        DIAGDOWN_B8_H2.set( 57 );

        DIAGDOWN_C8_H3.set( 23 );
        DIAGDOWN_C8_H3.set( 30 );
        DIAGDOWN_C8_H3.set( 37 );
        DIAGDOWN_C8_H3.set( 44 );
        DIAGDOWN_C8_H3.set( 51 );
        DIAGDOWN_C8_H3.set( 58 );

        DIAGDOWN_D8_H4.set( 31 );
        DIAGDOWN_D8_H4.set( 38 );
        DIAGDOWN_D8_H4.set( 45 );
        DIAGDOWN_D8_H4.set( 52 );
        DIAGDOWN_D8_H4.set( 59 );

        DIAGDOWN_E8_H5.set( 39 );
        DIAGDOWN_E8_H5.set( 46 );
        DIAGDOWN_E8_H5.set( 53 );
        DIAGDOWN_E8_H5.set( 60 );

        DIAGDOWN_F8_H6.set( 47 );
        DIAGDOWN_F8_H6.set( 54 );
        DIAGDOWN_F8_H6.set( 61 );

        DIAGDOWN_G8_H7.set( 55 );
        DIAGDOWN_G8_H7.set( 62 );

        diagsUp.add( DIAGUP_A7_B8);
        diagsUp.add( DIAGUP_A6_C8);
        diagsUp.add( DIAGUP_A5_D8);
        diagsUp.add( DIAGUP_A4_E8);
        diagsUp.add( DIAGUP_A3_F8);
        diagsUp.add( DIAGUP_A2_G8);
        diagsUp.add( DIAGUP_A1_H8);
        diagsUp.add( DIAGUP_B1_H7);
        diagsUp.add( DIAGUP_C1_H6);
        diagsUp.add( DIAGUP_D1_H5);
        diagsUp.add( DIAGUP_E1_H4);
        diagsUp.add( DIAGUP_F1_H3);
        diagsUp.add( DIAGUP_G1_H2);

        diagsDown.add( DIAGDOWN_A2_B1);
        diagsDown.add( DIAGDOWN_A3_C1);
        diagsDown.add( DIAGDOWN_A4_D1);
        diagsDown.add( DIAGDOWN_A5_E1);
        diagsDown.add( DIAGDOWN_A6_F1);
        diagsDown.add( DIAGDOWN_A7_G1);
        diagsDown.add( DIAGDOWN_A8_H1);
        diagsDown.add( DIAGDOWN_B8_H2);
        diagsDown.add( DIAGDOWN_C8_H3);
        diagsDown.add( DIAGDOWN_D8_H4);
        diagsDown.add( DIAGDOWN_E8_H5);
        diagsDown.add( DIAGDOWN_F8_H6);
        diagsDown.add( DIAGDOWN_G8_H7);

        rows.add( ROW_1);
        rows.add( ROW_2);
        rows.add( ROW_3);
        rows.add( ROW_4);
        rows.add( ROW_5);
        rows.add( ROW_6);
        rows.add( ROW_7);
        rows.add( ROW_8);

        cols.add( COL_A);
        cols.add( COL_B);
        cols.add( COL_C);
        cols.add( COL_D);
        cols.add( COL_E);
        cols.add( COL_F);
        cols.add( COL_G);
        cols.add( COL_H);
        
    }

    public void setCol( int firstIndex, BitSet COL )
    {
        for( int i = firstIndex; i <= firstIndex + 8 * 7; i = i + 8 ){
            COL.set(i);
        }
    }


    public BitSet getColumn ( BitSet bitset ){

        return cols.stream()
            .filter( bit -> bit.intersects( bitset ) )
            .toList()
            .get(0);

    }

    public BitSet getRow ( BitSet bitset ){

        return rows.stream()
            .filter( bit -> bit.intersects( bitset ) )
            .toList()
            .get(0);

    }

    public BitSet getDiagUp ( BitSet bitset ){

        return diagsUp.stream()
            .filter( bit -> bit.intersects( bitset ) )
            .toList()
            .get(0);

    }

    public BitSet getDiagDown ( BitSet bitset ){

        return diagsDown.stream()
            .filter( bit -> bit.intersects( bitset ) )
            .toList()
            .get(0);

    }

    public static Position whiteInitialPosition() {
        Position white = new Position();
       
        white.pawnSet.set(8, 16, true);
        System.out.println( "just set wP " + white.pawnSet);

        white.knightSet.set(1,true);
        white.knightSet.set(6,true);

        white.bishopSet.set(2, true);
        white.bishopSet.set(5, true);
        
        white.rookSet.set(0, true);
        white.rookSet.set(7, true);
       
        white.queenSet.set(3, true);
        
        white.kingSet.set(4, true);

        white.occupied.or( white.pawnSet );
        white.occupied.or( white.knightSet );
        white.occupied.or( white.bishopSet );
        white.occupied.or( white.rookSet );
        white.occupied.or( white.queenSet );
        white.occupied.or( white.kingSet );

        white.nonOccupied = ( BitSet ) white.occupied.clone();
        white.nonOccupied.flip( 0, white.nonOccupied.size()-1 );

        return white;
    }


    public static Position blackInitialPosition() {
        Position black = new Position();
        
      
        black.pawnSet.set(48, 56, true);

        black.knightSet.set(57,true);
        black.knightSet.set(62,true);

  
        black.bishopSet.set(58, true);
        black.bishopSet.set(61, true);
  
        black.rookSet.set(56, true);
        black.rookSet.set(63, true);

 
        black.queenSet.set(59, true);
        
   
        black.kingSet.set(60, true);

        black.occupied.or( black.pawnSet );
        black.occupied.or( black.knightSet );
        black.occupied.or( black.bishopSet );
        black.occupied.or( black.rookSet );
        black.occupied.or( black.queenSet );
        black.occupied.or( black.kingSet );

        black.nonOccupied = ( BitSet ) black.occupied.clone();
        black.nonOccupied.flip( 0, black.nonOccupied.size()-1 );

        return black;
    }

    public static Position knightProof( int index) {
        Position position = new Position();
        
        position.knightSet.set( index );

        position.occupied.or( position.pawnSet );
        position.occupied.or( position.knightSet );
        position.occupied.or( position.bishopSet );
        position.occupied.or( position.rookSet );
        position.occupied.or( position.queenSet );
        position.occupied.or( position.kingSet );

        position.nonOccupied = ( BitSet ) position.occupied.clone();
        position.nonOccupied.flip( 0, position.nonOccupied.size()-1 );

        return position;
    }

    public void recalculatePosition() {
        this.occupied.or( this.pawnSet );
        this.occupied.or( this.knightSet );
        this.occupied.or( this.bishopSet );
        this.occupied.or( this.rookSet );
        this.occupied.or( this.queenSet );
        this.occupied.or( this.kingSet );

        this.nonOccupied = ( BitSet ) this.occupied.clone();
        this.nonOccupied.flip( 0, this.nonOccupied.size()-1 );
    }

    public BitSet getPawnSet() {
        return pawnSet;
    }


    public BitSet getKnightSet() {
        return knightSet;
    }


    public BitSet getBishopSet() {
        return bishopSet;
    }


    public BitSet getRookSet() {
        return rookSet;
    }


    public BitSet getQueenSet() {
        return queenSet;
    }


    public BitSet getKingSet() {
        return kingSet;
    }


    public BitSet getOccupied() {
        return occupied;
    }


    public BitSet getNonOccupied() {
        return nonOccupied;
    }

    

}
