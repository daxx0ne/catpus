package com.example.catpus.domain.catInfo.entity;

import com.example.catpus.global.baseEntity.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import javax.persistence.Entity;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CatInfo extends BaseEntity {
    private String photoUrl; // 고양이 사진

    private String catName; // 고양이 이름
    private String gender; // 성별
    private String characteristic; // 특징
    private String personality; // 성격
    private boolean neutering; // 중성화 여부
    private int chur; // 츄르
}
