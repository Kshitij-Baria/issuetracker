package com.example.issuetracker.model.dto.response;

import com.example.issuetracker.model.ActivityFieldType;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class ActivityResponse {
    private Long id;
    private TaskReferenceResponse task;
    private UserResponse user;
    private ActivityFieldType activityFieldType;
    private String oldValue;
    private String newValue;
    private Long targetId;
    private Instant createdAt;
}
