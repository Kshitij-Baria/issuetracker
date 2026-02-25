package com.example.issuetracker.model.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateLabelRequest {
    private String labelText;
}
