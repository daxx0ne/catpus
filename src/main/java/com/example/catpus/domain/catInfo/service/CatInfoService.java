package com.example.catpus.domain.catInfo.service;

import com.example.catpus.domain.catInfo.entity.CatInfo;
import com.example.catpus.domain.catInfo.event.CatInfoCreatedEvent;
import com.example.catpus.domain.catInfo.repository.CatInfoRepository;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CatInfoService {
    private final CatInfoRepository catInfoRepository;
    private final ApplicationEventPublisher eventPublisher;

    public CatInfoService(CatInfoRepository catInfoRepository, ApplicationEventPublisher eventPublisher) {
        this.catInfoRepository = catInfoRepository;
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public CatInfo createCatInfo(CatInfo catInfo) {
        // CatInfo를 저장하고
        CatInfo savedCatInfo = catInfoRepository.save(catInfo);

        // 이벤트를 발생시켜서 게시판을 생성
        CatInfoCreatedEvent catInfoCreatedEvent = new CatInfoCreatedEvent(this, savedCatInfo);
        eventPublisher.publishEvent(catInfoCreatedEvent);

        return savedCatInfo;
    }
}
