package com.example.catpus.domain.article.service;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.article.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<Article> getAllArticles() {
        return articleRepository.findAll();
    }

    // 특정 게시판 아이디로 글을 조회하는 메서드
    public List<Article> getArticlesByBoardId(Long boardId) {
        return articleRepository.findByBoard_Id(boardId);
    }

    public Article createArticle(Article article) {
        return articleRepository.save(article);
    }

    public Article updateArticle(Long id, Article updatedArticle) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            Article article = optionalArticle.get();
            article.setTitle(updatedArticle.getTitle());
            article.setContent(updatedArticle.getContent());

            return articleRepository.save(article);
        }
        return null;
    }

    public boolean deleteArticle(Long id) {
        Optional<Article> optionalArticle = articleRepository.findById(id);
        if (optionalArticle.isPresent()) {
            articleRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
