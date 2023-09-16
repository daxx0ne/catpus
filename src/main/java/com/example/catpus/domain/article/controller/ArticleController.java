package com.example.catpus.domain.article.controller;

import com.example.catpus.domain.article.dto.ArticleDto;
import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.article.service.ArticleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user/articles")
@RequiredArgsConstructor
@Tag(name = "Article", description = "게시글 생성, 조회, 수정, 삭제 API")
public class ArticleController {

    private final ArticleService articleService;
    private final ModelMapper modelMapper;

    @GetMapping
    @Operation(summary ="모든 게시글 조회")
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articleService.getAllArticles();
        return articles.stream()
                .map(article -> modelMapper.map(article, ArticleDto.class))
                .collect(Collectors.toList());
    }

    @GetMapping("/board/{boardId}")
    @Operation(summary = "특정 게시판 Id로 게시글 조회")
    public ResponseEntity<List<ArticleDto>> getArticlesByBoardId(@PathVariable Long boardId) {
        List<Article> articles = articleService.getArticlesByBoardId(boardId);
        List<ArticleDto> articleDtos = articles.stream()
                .map(article -> modelMapper.map(article, ArticleDto.class))
                .collect(Collectors.toList());
        return new ResponseEntity<>(articleDtos, HttpStatus.OK);
    }

    @PostMapping
    @Operation(summary ="게시글 생성")
    public ResponseEntity<ArticleDto> createArticle(@Valid @RequestBody ArticleDto articleDto) {
        Article article = modelMapper.map(articleDto, Article.class);
        Article createdArticle = articleService.createArticle(article);
        ArticleDto createdArticleDto = modelMapper.map(createdArticle, ArticleDto.class);
        return new ResponseEntity<>(createdArticleDto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation(summary ="게시글 수정")
    public ResponseEntity<ArticleDto> updateArticle(@PathVariable Long id, @Valid @RequestBody ArticleDto updatedArticleDto) {
        Article updatedArticle = modelMapper.map(updatedArticleDto, Article.class);
        Article article = articleService.updateArticle(id, updatedArticle);
        if (article != null) {
            ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
            return ResponseEntity.ok(articleDto);
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

    @PostMapping("/{id}/like")
    @Operation(summary ="게시글 좋아요 누르기")
    public ResponseEntity<ArticleDto> addLikeToArticle(@PathVariable Long id, @RequestParam Long userId) {
        Article article = articleService.addLike(id, userId);
        if (article != null) {
            ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
            return ResponseEntity.ok(articleDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}/like")
    @Operation(summary ="게시글 좋아요 취소")
    public ResponseEntity<ArticleDto> removeLikeFromArticle(@PathVariable Long id, @RequestParam Long userId) {
        Article article = articleService.removeLike(id, userId);
        if (article != null) {
            ArticleDto articleDto = modelMapper.map(article, ArticleDto.class);
            return ResponseEntity.ok(articleDto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
