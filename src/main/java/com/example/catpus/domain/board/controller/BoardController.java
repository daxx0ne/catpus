package com.example.catpus.domain.board.controller;

import com.example.catpus.domain.board.entity.Board;
import com.example.catpus.domain.board.repository.BoardRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boards")
@Tag(name = "Boards", description = "게시판 종류")
public class BoardController {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/all")
    @Operation(summary ="모든 게시판 조회")
    public ResponseEntity<List<Board>> getAllBoards() {
        List<Board> boards = boardRepository.findAll();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }
}