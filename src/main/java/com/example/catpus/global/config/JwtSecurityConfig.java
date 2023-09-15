package com.example.catpus.global.config;

import com.example.catpus.global.common.jwt.JwtAuthorizationFilter;
import com.example.catpus.global.common.jwt.exception.JwtExceptionFilter;
import com.example.catpus.global.common.jwt.util.JwtTokenProvider;
import com.example.catpus.global.common.redis.forbidden.ForbiddenTokenService;
import com.example.catpus.global.common.redis.refresh.RefreshTokenService;
import com.example.catpus.global.common.security.UserDetailServiceImpl;
import com.example.catpus.global.cookie.CookieUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class JwtSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    private final UserDetailServiceImpl userDetailServiceImpl;
    private final RefreshTokenService refreshTokenService;
    private final ForbiddenTokenService forbiddenTokenService;

    private final JwtTokenProvider jwtTokenProvider;
    private final CookieUtil cookieUtil;

    @Override
    public void configure(HttpSecurity http) throws Exception {
        JwtAuthorizationFilter jwtAuthorizationFilter
                = new JwtAuthorizationFilter(userDetailServiceImpl, refreshTokenService, forbiddenTokenService, jwtTokenProvider, cookieUtil);
        JwtExceptionFilter jwtExceptionFilter = new JwtExceptionFilter();

        // TODO: test
        http.addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class);
        http.addFilterBefore(jwtExceptionFilter, JwtAuthorizationFilter.class);
    }
}