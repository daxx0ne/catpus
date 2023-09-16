package com.example.catpus.domain.catInfo.service;

import com.example.catpus.domain.catInfo.entity.CatInfo;
import com.example.catpus.domain.catInfo.event.CatInfoCreatedEvent;
import com.example.catpus.domain.catInfo.repository.CatInfoRepository;
import com.example.catpus.global.exception.CatInfoNotFoundException;
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
    public CatInfo registerCatInfo(CatInfo catInfo) {

        // CatInfo를 저장하고
        CatInfo savedCatInfo = catInfoRepository.save(catInfo);

        // 이벤트를 발생시켜서 게시판을 생성
        CatInfoCreatedEvent catInfoCreatedEvent = new CatInfoCreatedEvent(this, savedCatInfo);
        eventPublisher.publishEvent(catInfoCreatedEvent);

        return savedCatInfo;
    }

    @Transactional
    public CatInfo getCatInfo(Long catInfoId) {
        return catInfoRepository.findById(catInfoId).orElse(null);
    }

    @Transactional
    public CatInfo increaseChur(Long catInfoId) {
        // 고양이 정보를 데이터베이스에서 가져옴
        CatInfo catInfo = catInfoRepository.findById(catInfoId)
                .orElseThrow(() -> new CatInfoNotFoundException("CatInfo with id " + catInfoId + " not found."));

        // 츄르 값을 증가
        catInfo.setChur(catInfo.getChur() + 1);

        // 업데이트된 정보를 저장하고 반환
        return catInfoRepository.save(catInfo);
    }
}
