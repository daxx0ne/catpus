package com.example.catpus.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignRequest {
    private Long id;

    private String username;

    private String password;

    private String name;

    private String univ;
}
