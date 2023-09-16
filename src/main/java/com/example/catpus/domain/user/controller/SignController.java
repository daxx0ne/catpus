package com.example.catpus.domain.user.controller;

import com.example.catpus.domain.user.dto.SignRequest;
import com.example.catpus.domain.user.dto.SignResponse;
import com.example.catpus.domain.user.repository.UserRepository;
import com.example.catpus.domain.user.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final UserRepository userRepository;
    private final SignService userService;

    @PostMapping(value = "/login")
    public ResponseEntity<SignResponse> signin(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.register(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<SignResponse> getUser(@RequestParam String username) throws Exception {
        return new ResponseEntity<>( userService.getUser(username), HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestParam String username) throws Exception {
        return new ResponseEntity<>( userService.getUser(username), HttpStatus.OK);
    }
}
