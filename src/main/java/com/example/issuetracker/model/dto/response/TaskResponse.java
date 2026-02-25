package com.example.issuetracker.model.dto.response;

import com.example.issuetracker.model.TaskPriority;
import com.example.issuetracker.model.TaskStatus;
import com.example.issuetracker.model.TaskType;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Setter
public class TaskResponse {
    private Long id;
    private TaskType taskType;
    private String taskSummary;
    private String taskDescription;
    private TaskPriority taskPriority;
    private TaskStatus taskStatus;
    private UserResponse createdBy;
    private UserResponse assignedTo;
    private TaskReferenceResponse parentTask;
    private Set<TaskReferenceResponse> subTasks;
    private Set<UserResponse> watchers;
    private Set<LabelResponse> labels;
    private Set<CommentResponse> comments;
    private Set<ActivityResponse> activities;
    private Instant createdAt;
    private Instant updatedAt;
}
