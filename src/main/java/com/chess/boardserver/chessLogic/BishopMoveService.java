package com.chess.boardserver.chessLogic;

import java.util.BitSet;

import org.springframework.stereotype.Service;

@Service
public class BishopMoveService {
    
    public BitSet getBishopAvailableMovesBitset(ChessGame chessGame, 
        BitSet originalSquareBitset, 
        boolean color ) {

        int orig = originalSquareBitset.nextSetBit(0);
        BitSet availableSquares = new BitSet( 64 );
       
        BitSet upDiags = chessGame.getPositionBlack().getDiagUp(originalSquareBitset);
        BitSet downDiags = chessGame.getPositionBlack().getDiagDown(originalSquareBitset);
        BitSet limitedDiagUp = new BitSet( 64 );
        BitSet limitedDiagDown = new BitSet( 64 );

        if( upDiags != null){
            limitedDiagUp = 
                getLimitedSegment(orig, chessGame, upDiags, color);
        } 
        if( downDiags != null) {
            limitedDiagDown = 
                getLimitedSegment(orig, chessGame, downDiags, color);
        }

        availableSquares.or( limitedDiagUp );
        availableSquares.or( limitedDiagDown );
        availableSquares.set(orig, false);

        return availableSquares;

	}

    private BitSet getLimitedSegment(int originIndex, ChessGame chessGame, 
        BitSet segment, 
        boolean color ){

        BitSet limitedSegment = new BitSet( 64 );
        BitSet enemyPosition = new BitSet( 64 );;

        if( color ){ enemyPosition = chessGame.getPositionBlack().getOccupied();}
        else{ enemyPosition = chessGame.getPositionWhite().getOccupied(); }

           
            int limit1, limit2;
            limitedSegment.or( segment );

            limitedSegment.and( enemyPosition );
            /*limitedSegment.stream()
                .forEach(bit -> System.out.println(bit));*/

                            
            limit1 = limitedSegment.previousSetBit( originIndex - 1 );
            limit2 = limitedSegment.nextSetBit( originIndex + 1 );

            limitedSegment = (BitSet) segment.clone();


            if ( limit1 != -1 ){
                limitedSegment.set( 0, limit1, false );
            }
            
            if ( limit2 != -1 ){
                limitedSegment.set( limit2, 63, false );
            }

            return limitedSegment ;
        
    }

}
