package com.example.catpus.global.common.jwt.entity;

import com.example.catpus.domain.user.domain.RoleType;
import com.example.catpus.domain.user.domain.User;
import lombok.Builder;

@Builder
public record JwtUserInfo(
        Long id,
        RoleType role
) {
    public static JwtUserInfo of(Long id, RoleType role) {
        return new JwtUserInfo(id, role);
    }

    public static JwtUserInfo from(User user) {
        return new JwtUserInfo(user.getId(), user.getRole());
    }

    @Override public String toString() {
        return String.format("JwtUserInfo(id=%d, githubId=%d, role=%s)", id, role);
    }
}