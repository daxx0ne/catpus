package com.example.catpus.domain.article.service;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.article.repository.ArticleRepository;
import com.example.catpus.domain.comment.repository.CommentRepository;
import com.example.catpus.domain.like.entity.Like;
import com.example.catpus.domain.like.repository.LikeRepository;
import com.example.catpus.domain.user.entity.User;
import com.example.catpus.domain.user.repository.UserRepository;
import com.example.catpus.global.exception.ArticleNotFoundException;
import com.example.catpus.global.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;

    public ArticleService(ArticleRepository articleRepository, CommentRepository commentRepository, UserRepository userRepository, LikeRepository likeRepository) {
        this.articleRepository = articleRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.likeRepository = likeRepository;
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

    @Transactional
    public Article addLike(Long articleId, Long userId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("Article with id " + articleId + " not found."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found."));

        Like like = new Like();
        like.setArticle(article);
        like.setUser(user);
        likeRepository.save(like);

        // 게시글의 좋아요 수 1 증가
        article.setLikeCount(article.getLikeCount() + 1);
        articleRepository.save(article);

        return article;
    }

    @Transactional
    public Article removeLike(Long articleId, Long userId) {
        Article article = articleRepository.findById(articleId)
                .orElseThrow(() -> new ArticleNotFoundException("Article with id " + articleId + " not found."));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User with id " + userId + " not found."));

        likeRepository.deleteByArticleAndUser(article, user);

        article.setLikeCount(article.getLikeCount() - 1);
        return articleRepository.save(article);
    }

}
