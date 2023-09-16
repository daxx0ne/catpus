package com.example.catpus.domain.board.service;

import com.example.catpus.domain.board.entity.Board;
import com.example.catpus.domain.board.repository.BoardRepository;
import com.example.catpus.domain.catInfo.entity.CatInfo;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Transactional
    public Board createBoardFromCatInfo(CatInfo catInfo) {
        // 게시판을 생성하고 설정
        Board board = new Board();
        board.setCatInfo(catInfo);
        board.setName(catInfo.getCatName() + " 게시판");

        // 저장
        return boardRepository.save(board);
    }
}
