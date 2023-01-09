package com.chess.boardserver.entities;

import java.util.BitSet;

public class Position {

    public BitSet pawnSet;
    public BitSet knightSet;
    public BitSet bishopSet;
    public BitSet rookSet;
    public BitSet queenSet;
    public BitSet kingSet;

    public Position(){
        this.pawnSet =  new BitSet(64);
        this.knightSet =  new BitSet(64);
        this.bishopSet =  new BitSet(64);
        this.rookSet =  new BitSet(64);
        this.queenSet =  new BitSet(64);
        this.kingSet =  new BitSet(64);
    }


    public static Position whiteInitialPosition() {
        Position white = new Position();
       
        white.pawnSet.set(8, 15, true);

        white.knightSet.set(1,true);
        white.knightSet.set(6,true);

        white.bishopSet.set(2, true);
        white.bishopSet.set(5, true);
        
        white.rookSet.set(0, true);
        white.rookSet.set(7, true);
       
        white.queenSet.set(3, true);
        
        white.kingSet.set(4, true);

        return white;
    }

    public static Position blackInitialPosition() {
        Position black = new Position();
        
      
        black.pawnSet.set(48, 55, true);

        black.knightSet.set(57,true);
        black.knightSet.set(62,true);

  
        black.bishopSet.set(58, true);
        black.bishopSet.set(61, true);
  
        black.rookSet.set(56, true);
        black.rookSet.set(63, true);

 
        black.queenSet.set(59, true);
        
   
        black.kingSet.set(60, true);

        return black;
    }

}
