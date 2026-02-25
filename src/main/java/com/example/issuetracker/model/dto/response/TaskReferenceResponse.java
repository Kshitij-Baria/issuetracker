package com.example.issuetracker.model.dto.response;

import com.example.issuetracker.model.TaskPriority;
import com.example.issuetracker.model.TaskStatus;
import com.example.issuetracker.model.TaskType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TaskReferenceResponse {
    private Long id;
    private TaskType taskType;
    private String taskSummary;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
}
