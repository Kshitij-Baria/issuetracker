package com.example.issuetracker.model.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class LabelResponse {
    private Long id;
    private String labelText;
    private Set<TaskReferenceResponse> tasks;
}
