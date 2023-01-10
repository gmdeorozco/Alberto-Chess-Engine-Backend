package com.chess.boardserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chess.boardserver.entities.Board;
import com.chess.boardserver.repository.BoardRepository;

@Service
public class BoardService {
    @Autowired
    BoardRepository boardRepository;

    public Board save(Board board) {
        return boardRepository.save(board);
    }

    public Board getById(Long gameId) {
        return boardRepository.getReferenceById(gameId);
    }


}
