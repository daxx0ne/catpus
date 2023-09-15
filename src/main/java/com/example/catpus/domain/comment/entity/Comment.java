package com.example.catpus.domain.comment.entity;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Comment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    private String comment; // 댓글
    private int commentCount; // 댓글 수
    private int like; // 좋아요 수
}
