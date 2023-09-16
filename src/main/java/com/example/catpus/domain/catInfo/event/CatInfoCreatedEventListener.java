package com.example.catpus.domain.catInfo.event;

import com.example.catpus.domain.board.service.BoardService;
import com.example.catpus.domain.catInfo.entity.CatInfo;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CatInfoCreatedEventListener {
    private final BoardService boardService;

    public CatInfoCreatedEventListener(BoardService boardService) {
        this.boardService = boardService;
    }

    @EventListener
    public void handleCatInfoCreatedEvent(CatInfoCreatedEvent event) {
        CatInfo catInfo = event.getCatInfo();

        // CatInfo를 기반으로 게시판 생성
        boardService.createBoardFromCatInfo(catInfo);
    }
}
