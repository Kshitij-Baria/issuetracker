package com.example.issuetracker.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCommentRequest {
    private Long taskId;
    private Long authorId;
    private String content;
}
