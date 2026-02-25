package com.example.issuetracker.model.dto.request;

import com.example.issuetracker.model.TaskPriority;
import com.example.issuetracker.model.TaskStatus;
import com.example.issuetracker.model.TaskType;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CreateTaskRequest {
    private TaskType taskType;
    private String taskSummary;
    private String taskDescription;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private Long createdBy;
    private Long assignedTo;
    private Long parentTask;
    private Set<Long> subTasks;
    private Set<Long> watchers;
    private Set<Long> labels;
}
