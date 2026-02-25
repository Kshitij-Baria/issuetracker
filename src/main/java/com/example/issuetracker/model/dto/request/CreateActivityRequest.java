package com.example.issuetracker.model.dto.request;

import com.example.issuetracker.model.ActivityFieldType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateActivityRequest {
    private Long taskId;
    private Long userId;
    private ActivityFieldType activityFieldType;
    private String oldValue;
    private String newValue;
    private Long targetId;
}
