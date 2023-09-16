package com.example.catpus.domain.article.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ArticleDto {
    private Long id;

    @NotNull(message = "Board ID cannot be null")
    private Long boardId;

    @NotBlank(message = "Title is required")
    private String title;

    @NotBlank(message = "Content is required")
    private String content;

    // 다른 필드 및 getter/setter 메서드 추가
}
