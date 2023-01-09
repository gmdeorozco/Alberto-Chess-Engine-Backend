package com.chess.boardserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chess.boardserver.entities.Board;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long>{
    
}
