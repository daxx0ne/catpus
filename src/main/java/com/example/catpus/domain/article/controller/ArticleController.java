package com.example.catpus.domain.article.controller;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.article.repository.ArticleRepository;
import com.example.catpus.domain.article.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
@Tag(name = "Article", description = "게시글 생성, 조회, 수정, 삭제 API")
public class ArticleController {

    private ArticleService articleService;
    private ArticleRepository articleRepository;

    @Autowired
    public ArticleController(ArticleService articleService) {
        this.articleService = articleService;
    }

    @GetMapping
    @Operation(summary ="모든 게시글 조회")
    public List<Article> getAllArticles() {
        return articleService.getAllArticles();
    }

    @GetMapping("/byBoard/{boardId}")
    @Operation(summary = "특정 게시판 Id로 게시글 조회")
    public ResponseEntity<List<Article>> getArticlesByBoardId(@PathVariable Long boardId) {
        List<Article> articles = articleService.getArticlesByBoardId(boardId);
        return new ResponseEntity<>(articles, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary ="게시글 생성")
    public Article createArticle(@Valid @RequestBody Article article) {
        return articleService.createArticle(article);
    }

    @PutMapping("/{id}")
    @Operation(summary ="게시글 수정")
    public ResponseEntity<Article> updateArticle(@PathVariable Long id, @Valid @RequestBody Article updatedArticle) {
        Article article = articleService.updateArticle(id, updatedArticle);
        if (article != null) {
            return ResponseEntity.ok(article);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary ="게시글 삭제")
    public ResponseEntity<Void> deleteArticle(@PathVariable Long id) {
        boolean deleted = articleService.deleteArticle(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
