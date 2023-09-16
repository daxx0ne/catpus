package com.example.catpus.domain.comment.entity;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.global.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Comment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "article_id")
    private Article article;
    private String text; // 댓글

    public void setText(String text) {
        this.text = text;
    }
}
