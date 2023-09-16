package com.example.catpus.domain.like.entity;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.user.entity.User;
import com.example.catpus.global.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Like extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "article_id", nullable = false)
    private Article article; // 해당 좋아요가 속한 게시글

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user; // 좋아요를 누른 사용자
}