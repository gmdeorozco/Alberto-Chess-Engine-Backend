package com.chess.boardserver;

import java.util.BitSet;

public class Position {

    public BitSet pawnSet;
    public BitSet knightSet;
    public BitSet bishopSet;
    public BitSet rookSet;
    public BitSet queenSet;
    public BitSet kingSet;

    public static Position whiteInitialPosition() {
        Position white = new Position();
        
        white.pawnSet = new BitSet(64);
        white.pawnSet.set(8, 15, true);

        white.knightSet = new BitSet(64);
        white.kingSet.set(1,true);
        white.kingSet.set(6,true);

        white.bishopSet = new BitSet(64);
        white.bishopSet.set(2, true);
        white.bishopSet.set(5, true);
        
        white.rookSet = new BitSet(64);
        white.rookSet.set(0, true);
        white.rookSet.set(7, true);

        white.queenSet = new BitSet(64);
        white.queenSet.set(3, true);
        
        white.kingSet = new BitSet(64);
        white.kingSet.set(4, true);

        return white;
    }

    public static Position blackInitialPosition() {
        Position black = new Position();
        
        black.pawnSet = new BitSet(64);
        black.pawnSet.set(48, 55, true);

        black.knightSet = new BitSet(64);
        black.kingSet.set(57,true);
        black.kingSet.set(62,true);

        black.bishopSet = new BitSet(64);
        black.bishopSet.set(58, true);
        black.bishopSet.set(61, true);
        
        black.rookSet = new BitSet(64);
        black.rookSet.set(56, true);
        black.rookSet.set(63, true);

        black.queenSet = new BitSet(64);
        black.queenSet.set(59, true);
        
        black.kingSet = new BitSet(64);
        black.kingSet.set(60, true);

        return black;
    }

}
