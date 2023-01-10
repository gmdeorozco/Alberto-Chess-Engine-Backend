package com.chess.boardserver.controllers;

import java.util.BitSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chess.boardserver.chessLogic.AvailableMovesService;
import com.chess.boardserver.chessLogic.ChessGame;
import com.chess.boardserver.entities.Board;
import com.chess.boardserver.service.BoardService;


@RestController
@RequestMapping("/api/v1")
public class ChessGameController {
    
    @Autowired
    BoardService boardService;

    @Autowired
    AvailableMovesService availableMovesService;

    @GetMapping("/initgame")
    public Board getGameStateById(){
        ChessGame chessGame = new ChessGame();
        return boardService.save( new Board(chessGame) );
    }

    @GetMapping("/proof/{pieceProof}/{index}/{turn}")
    public Board proof( @PathVariable( value = "pieceProof") int pieceProof, 
        @PathVariable( value = "index") int index, 
        @PathVariable( value = "turn") boolean turn ){
        
            ChessGame chessGame = new ChessGame( pieceProof, index, turn );
        return boardService.save( new Board(chessGame) );
    }

    @GetMapping("/getDestinations/{gameId}/{casilla}")
    public List<String> getDestinations(@PathVariable(value = "gameId") Long gameId, 
        @PathVariable(value = "casilla") String casilla
        ){
        Board board = boardService.getById( gameId );
        ChessGame chessGame = new ChessGame(board);

        return availableMovesService.getListOfMoves( chessGame, casilla);
    }

  
}
