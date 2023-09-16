package com.example.catpus.domain.comment.service;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.article.repository.ArticleRepository;
import com.example.catpus.domain.comment.dto.CommentDTO;
import com.example.catpus.domain.comment.entity.Comment;
import com.example.catpus.domain.comment.repository.CommentRepository;
import com.example.catpus.global.exception.CommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ArticleRepository articleRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ArticleRepository articleRepository) {
        this.commentRepository = commentRepository;
        this.articleRepository = articleRepository;
    }

    public Comment createComment(Comment comment) {
        Comment createdComment = commentRepository.save(comment);

        // 댓글 생성 후 게시글의 commentCount 업데이트
        Article article = comment.getArticle();
        article.setCommentCount(article.getCommentCount() + 1);
        articleRepository.save(article);

        return createdComment;
    }

    public List<CommentDTO> getCommentsByArticleId(Long articleId) {
        List<Comment> comments = commentRepository.findByArticleId(articleId);
        return comments.stream()
                .map(comment -> CommentDTO.builder()
                        .id(comment.getId())
                        .text(comment.getText())
                        .build())
                .collect(Collectors.toList());
    }

    public Comment updateComment(Long commentId, String newText) {
        Optional<Comment> existingComment = commentRepository.findById(commentId);
        if (existingComment.isPresent()) {
            Comment comment = existingComment.get();
            comment.setText(newText);
            return commentRepository.save(comment);
        } else {
            throw new CommentNotFoundException("Comment with id " + commentId + " not found.");
        }
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}
