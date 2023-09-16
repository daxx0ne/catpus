package com.example.catpus.domain.article.dto;

import com.example.catpus.domain.catInfo.entity.CatInfo;
import com.example.catpus.domain.user.entity.User;
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

    private String photoUrl;
    private CatInfo catInfo;
    private User author;
    private int likeCount;
    private int commentCount;
}
