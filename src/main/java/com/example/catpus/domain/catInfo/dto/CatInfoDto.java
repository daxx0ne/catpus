package com.example.catpus.domain.catInfo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CatInfoDto {
    private Long id;
    private String photoUrl;
    private String catName;
    private String gender;
    private String characteristic;
    private String personality;
    private boolean neutering;
    private int chur;
}
