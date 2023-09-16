package com.example.catpus.domain.catInfo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterInfoRequest {
    private Long id;
    private String photoUrl; // 고양이 사진
    private String catName; // 고양이 이름
    private String gender; // 성별
    private String characteristic; // 특징
    private String personality; // 성격
    private boolean neutering; // 중성화 여부
    private int chur; // 츄르
}
