package com.example.catpus.domain.catMent.controller;

import com.example.catpus.domain.catMent.repository.MentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user/ment")
@Tag(name = "Ment", description = "고양이 멘트")
public class MentController {
    private final MentRepository mentRepository;

    @Autowired
    public MentController(MentRepository mentRepository) {
        this.mentRepository = mentRepository;
    }

    @GetMapping("/random")
    @Operation(summary ="랜덤으로 고양이 멘트 하나만 조회")
    public ResponseEntity<String> getRandomCatMent() {
        try {
            // 랜덤한 고양이 맨트 조회
            String randomCatMent = mentRepository.findRandomMent();

            if (randomCatMent != null) {
                return new ResponseEntity<>(randomCatMent, HttpStatus.OK);
            } else {
                return new ResponseEntity<>("No cat ment found", HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>("Failed to fetch cat ment", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
