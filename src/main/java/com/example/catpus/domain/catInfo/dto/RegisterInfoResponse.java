package com.example.catpus.domain.catInfo.dto;

import com.example.catpus.domain.catInfo.entity.CatInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterInfoResponse {
    private Long id;
    private String photoUrl; // 고양이 사진
    private String catName; // 고양이 이름
    private String gender; // 성별
    private String characteristic; // 특징
    private String personality; // 성격
    private boolean neutering; // 중성화 여부
    private int chur; // 츄르

    public RegisterInfoResponse(CatInfo catInfo) {
        this.id = catInfo.getId();
        this.photoUrl = catInfo.getPhotoUrl();
        this.catName = catInfo.getCatName();
        this.gender = catInfo.getGender();
        this.characteristic = catInfo.getCharacteristic();
        this.personality = catInfo.getPersonality();
        this.neutering = catInfo.isNeutering();
        this.chur = catInfo.getChur();
    }
}
