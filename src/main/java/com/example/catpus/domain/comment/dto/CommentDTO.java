package com.example.catpus.domain.comment.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class CommentDTO {
    private Long id;
    private String text;
    private LocalDateTime createdDate;
}
