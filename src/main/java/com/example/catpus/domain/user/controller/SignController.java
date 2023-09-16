package com.example.catpus.domain.user.controller;

import com.example.catpus.domain.user.dto.SignRequest;
import com.example.catpus.domain.user.dto.SignResponse;
import com.example.catpus.domain.user.repository.UserRepository;
import com.example.catpus.domain.user.service.SignService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Sign", description = "회원가입 및 로그인")
public class SignController {

    private final UserRepository userRepository;
    private final SignService userService;

    @PostMapping(value = "/login")
    @Operation(summary ="로그인")
    public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    @Operation(summary ="회원가입")
    public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    @Operation(summary ="일반 회원 정보 ('/user/get?username=아이디' 로 조회 가능)")
    public ResponseEntity<SignResponse> getUser(@RequestParam String username) throws Exception {
        return new ResponseEntity<>( userService.getUser(username), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    @Operation(summary ="관리자")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String username) throws Exception {
        return new ResponseEntity<>( userService.getUser(username), HttpStatus.OK);
    }
}
