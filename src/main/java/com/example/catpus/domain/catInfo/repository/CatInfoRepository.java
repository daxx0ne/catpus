package com.example.catpus.domain.catInfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.catpus.domain.catInfo.entity.CatInfo;

@Repository
public interface CatInfoRepository extends JpaRepository<CatInfo, Long> {
}
