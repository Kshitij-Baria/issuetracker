package com.example.issuetracker.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class CommentResponse {
    private Long id;
    private TaskReferenceResponse task;
    private UserResponse author;
    private String content;
    private Instant createdAt;
    private Instant updatedAt;
}
