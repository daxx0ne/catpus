package com.example.catpus.domain.board.entity;

import com.example.catpus.domain.article.entity.Article;
import com.example.catpus.domain.catInfo.entity.CatInfo;
import com.example.catpus.global.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Board extends BaseEntity {
    private String name; // 게시판 이름

    @OneToOne
    @JoinColumn(name = "cat_info_id")
    private CatInfo catInfo; // 고양이 정보와의 일대일 관계

    @OneToMany(mappedBy = "board")
    private List<Article> articles; // 해당 게시판의 게시글 목록
}
