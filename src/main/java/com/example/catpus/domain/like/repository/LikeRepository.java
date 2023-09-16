package com.example.catpus.domain.like.repository;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.like.entity.Like;
import com.example.catpus.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

public interface LikeRepository extends JpaRepository<Like, Long> {

    @Transactional
    void deleteByArticleAndUser(Article article, User user);

    // 게시글별 좋아요 수 조회
    long countByArticle(Article article);
}
