package com.example.catpus.domain.ment.entity;

import com.example.catpus.domain.catInfo.entity.CatInfo;
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
public class Ment extends BaseEntity {
    @ManyToOne
    @JoinColumn(name = "cat_info_id")
    private CatInfo catInfo;
    private String catSay; // 고양이 맨트
}
