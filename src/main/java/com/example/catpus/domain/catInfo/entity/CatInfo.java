package com.example.catpus.domain.catInfo.entity;

import com.example.catpus.domain.board.entity.Board;
import com.example.catpus.global.baseEntity.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Getter
@NoArgsConstructor
@SuperBuilder
@ToString(callSuper = true)
public class CatInfo extends BaseEntity {
    private String photoUrl; // 고양이 사진
    private String catName; // 고양이 이름
    private String age; // 나이
    private String characteristic; // 특징
    private String personality; // 성격
    private boolean neutering; // 중성화 여부
    private int chur; // 츄르

    @OneToOne(mappedBy = "catInfo")
    private Board board;
}
