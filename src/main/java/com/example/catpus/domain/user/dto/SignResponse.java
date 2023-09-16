package com.example.catpus.domain.user.dto;

import com.example.catpus.domain.user.auth.Authority;
import com.example.catpus.domain.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {
    private Long id;

    private String username;

    private String name;

    private String univ;

    @Builder.Default
    private List<Authority> roles = new ArrayList<>();

    private String token;

    public SignResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.name = user.getName();
        this.univ = user.getUniv();
        this.roles = user.getRoles();
    }

    public static SignResponse from(User user) {
        return SignResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .name(user.getName())
                .univ(user.getUniv())
                .roles(user.getRoles())
                .build();
    }
}
