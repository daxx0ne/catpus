package com.example.catpus.domain.articleCategory.entity;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Category extends BaseEntity {
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Article> articles;
}
