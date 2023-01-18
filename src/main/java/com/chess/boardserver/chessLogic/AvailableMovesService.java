package com.chess.boardserver.chessLogic;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chess.boardserver.entities.Casilla;

@Service
public class AvailableMovesService {

    @Autowired
    BishopMoveService bishopMoveService;

	public List<String> getListOfMoves( ChessGame chessGame, String casillaName ) {
        Casilla casilla = new Casilla( casillaName );
        BitSet bitSet = casilla.getBitSet();

        System.out.println("white knight " + chessGame.getPositionWhite().getKnightSet());

        if( bitSet.intersects( chessGame.getPositionWhite().getPawnSet() ) 
            && chessGame.isWhitesTurn() ) {

                BitSet availableSquares 
                    = getWhitePawnAvailableMovesBitset( chessGame, bitSet );
                    System.out.println("avail sq "+ bitSet.toString() );
                return bitSetToListOfSquares( availableSquares );

        } 
        
        
        if( bitSet.intersects( chessGame.getPositionWhite().getKnightSet() ) 
        && chessGame.isWhitesTurn() ) {

            BitSet availableSquares 
                = getKnightAvailableMovesBitset( chessGame, bitSet, true );
        
            return bitSetToListOfSquares( availableSquares );

        }
        
        if( bitSet.intersects( chessGame.getPositionWhite().getBishopSet() ) 
            && chessGame.isWhitesTurn() ) {
                BitSet availableSquares 
                    = bishopMoveService
                        .getBishopAvailableMovesBitset( chessGame, 
                            bitSet, true );
        
            return bitSetToListOfSquares( availableSquares );
        }
		
        return null;
	}

    

	private BitSet getKnightAvailableMovesBitset(ChessGame chessGame, 
        BitSet originalSquareBitset,
        boolean color
        ) {
            
        BitSet availableSquares = new BitSet( 64 );
        int orig = originalSquareBitset.nextSetBit(0);

        List<Integer> indexes = new ArrayList<>();

        BitSet itsColumn = chessGame.getPositionWhite().getColumn(originalSquareBitset);
        BitSet itsRow = chessGame.getPositionWhite().getRow(originalSquareBitset);

            if( orig + 16 <= 63 ) { //Intersection point with row1

                BitSet row1 = new BitSet(64);
                int fila1_intersec = itsColumn.nextSetBit( orig + 16 );

                row1.set ( fila1_intersec );
                
                    if( chessGame.getPositionWhite().getRow( row1 ).get(orig + 16 - 1) ){
                        int row1_index1;
                        row1_index1 = orig + 16 - 1;
                        indexes.add( row1_index1 );
                    }

                if( orig + 16 + 1 <= 63){
                    if( chessGame.getPositionWhite().getRow( row1 ).get(orig + 16 + 1) ){
                        int row1_index2 ;
                        row1_index2 = orig + 16 + 1;
                        indexes.add( row1_index2 );
                    }
                  
                }
                
            }
        
        

        
        if( orig - 16 >= 0 ){ //intersection point for row2
            
            BitSet row2 = new BitSet(64);
            int fila2_intersec = itsColumn.nextSetBit(orig - 16);

                row2.set ( fila2_intersec );

                if( orig - 16 - 1 > -1 ){
                    if( chessGame.getPositionWhite().getRow( row2 ).get(orig - 16 - 1) ){
                        int row2_index1;
                        row2_index1 = orig - 16 - 1;
                        indexes.add( row2_index1 );
                    }
                }
                
                if( chessGame.getPositionWhite().getRow( row2 ).get(orig - 16 + 1) ){
                    int row2_index2;
                    row2_index2 = orig - 16 + 1;
                    indexes.add( row2_index2 );
                }
             
        }

        if( orig + 2 <= 63 ){
            BitSet col1 = new BitSet(64);
            int col1_intersec = itsRow.nextSetBit(orig + 2);

           
                col1.set(col1_intersec);
                if( orig + 2 - 8 > -1 ){
                    if( chessGame.getPositionWhite().getColumn( col1 ).get(orig + 2 - 8) ){
                        int col1_index1;
                        col1_index1 = orig + 2 - 8;
                        indexes.add( col1_index1 );
                    }
                    
                }

                if( orig + 2 + 8 <= 63 ){
                    if( chessGame.getPositionWhite().getColumn( col1 ).get(orig + 2 + 8) ){
                        int col1_index2;
                        col1_index2 = orig + 2 + 8;
                        indexes.add( col1_index2 );
                    }
                   
                }
            
            

            
        }

        if( orig - 2 > -1 ){
            BitSet col2 = new BitSet(64);
            int col2_intersec = itsRow.nextSetBit(orig - 2);

            if( col2_intersec > -1 ){
                col2.set(col2_intersec);

                if( orig - 2 - 8 > -1 ){
                    if( chessGame.getPositionWhite().getColumn( col2 ).get(orig - 2 - 8) ){
                        int col2_index1;
                        col2_index1 = orig - 2 - 8;
                        indexes.add( col2_index1 );
                    }
                   
                }

                if( orig - 2 + 8 <= 63 ){
                    if( chessGame.getPositionWhite().getColumn( col2 ).get(orig - 2 + 8) ){
                        int col2_index2;
                        col2_index2 = orig - 2 + 8;
                        indexes.add( col2_index2 );
                    }
                    
                }
            }
            

        }
        
        indexes.stream()
            .forEach( ind -> availableSquares.set( ind ));

        if( color ){
            availableSquares.and ( chessGame.getPositionWhite().getNonOccupied() );
        }
        else{
            availableSquares.and ( chessGame.getPositionBlack().getNonOccupied() );
        }
        


        return availableSquares;
    }

    public BitSet getWhitePawnAvailableMovesBitset( ChessGame chessGame, 
        BitSet originalSquareBitset ){
        
        BitSet availableSquares = new BitSet( 64 );
        int frontIndexSquare = originalSquareBitset.nextSetBit(0) + 8;
        System.out.println( "front index " + frontIndexSquare);
        
        availableSquares.set( frontIndexSquare );

        availableSquares.and( chessGame.getPositionBlack().getNonOccupied() );
        availableSquares.and( chessGame.getPositionWhite().getNonOccupied() );

        if ( availableSquares.get( frontIndexSquare ) ){
            availableSquares.set( frontIndexSquare + 8 );
            availableSquares.and( chessGame.getPositionBlack().getNonOccupied() );
            availableSquares.and( chessGame.getPositionWhite().getNonOccupied() );
        }

        return availableSquares;
    }

    public List<String> bitSetToListOfSquares( BitSet bitSet){
        List<String> list = new ArrayList<>();
        bitSet.stream()
            .forEach( index -> list.add( Casilla.getStringNameByIndex(index) ) );
        
        return list;
    }
    
}
