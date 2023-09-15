package com.example.catpus.domain.article.repository;

import com.example.catpus.domain.article.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findByCatInfo_CatName(String catName);
    List<Article> findByBoard_Id(Long categoryId);
}