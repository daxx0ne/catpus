package com.example.catpus.domain.article.entity;

import com.example.catpus.domain.articleCategory.entity.Category;
import com.example.catpus.domain.catInfo.entity.CatInfo;
import com.example.catpus.domain.comment.entity.Comment;
import com.example.catpus.domain.user.domain.User;
import com.example.catpus.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class Article extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "Category_id", nullable = false)
    private Category category;

    private String title; // 제목
    private String content; // 내용

    @OneToMany(mappedBy = "article")
    private List<Comment> comments;

    @CreatedDate
    private LocalDateTime createDate; // 작성날짜

    private String photoUrl; // 사진

    @ManyToOne // 고양이 정보 연결
    @JoinColumn(name = "cat_info_id", nullable = false)
    private CatInfo catInfo; // 고양이 정보

    @ManyToOne // 작성자 정보 연결
    @JoinColumn(name = "user_id", nullable = false)
    private User author; // 작성자
}
