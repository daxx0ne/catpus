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
@RequestMapping("user/boards")
@Tag(name = "Boards", description = "게시판 관련 API")
public class BoardController {

    private final BoardRepository boardRepository;

    @Autowired
    public BoardController(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @GetMapping("/list")
    @Operation(summary = "게시판 목록 조회")
    public ResponseEntity<List<Board>> getBoardList() {
        List<Board> boards = boardRepository.findAll();
        return new ResponseEntity<>(boards, HttpStatus.OK);
    }
}