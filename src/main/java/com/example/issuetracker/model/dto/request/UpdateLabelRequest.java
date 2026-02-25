package com.example.issuetracker.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateLabelRequest {
    private Long id;
    private String labelText;
}
