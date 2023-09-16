package com.example.catpus.domain.catMent.repository;

import com.example.catpus.domain.catMent.entity.Ment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MentRepository extends JpaRepository<Ment, Long> {
    // 랜덤한 고양이 맨트 조회 메소드
    @Query(nativeQuery = true, value = "SELECT cat_say FROM Ment ORDER BY RAND() LIMIT 1")
    String findRandomMent();
}
