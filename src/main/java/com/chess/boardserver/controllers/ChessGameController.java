package com.chess.boardserver.controllers;

import java.util.BitSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chess.boardserver.entities.Board;
import com.chess.boardserver.entities.ChessGame;
import com.chess.boardserver.service.BoardService;


@RestController
@RequestMapping("/api/v1")
public class ChessGameController {
    
    @Autowired
    BoardService boardService;

    @GetMapping("/initgame")
    public Board getGameStateById(){
        ChessGame chessGame = new ChessGame();
        return boardService.save( new Board(chessGame) );
    }

}
