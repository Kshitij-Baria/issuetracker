package com.example.issuetracker.service.mapper;

import com.example.issuetracker.model.*;
import com.example.issuetracker.model.dto.request.CreateTaskRequest;
import com.example.issuetracker.model.dto.request.UpdateTaskRequest;
import com.example.issuetracker.model.dto.response.*;

import org.springframework.stereotype.Component;
import java.time.Instant;
import java.util.Set;

@Component
public class TaskMapper {
    public Task mapToEntity(CreateTaskRequest createTaskRequest, User createdBy, User assignedTo, Task parentTask, Set<Task> subTasks, Set<User> watchers, Set<Label> labels) {
        Task task = new Task();

        TaskType taskType = createTaskRequest.getTaskType();
        String taskSummary = createTaskRequest.getTaskSummary();
        String taskDescription = createTaskRequest.getTaskDescription();
        TaskPriority taskPriority = createTaskRequest.getTaskPriority();
        TaskStatus taskStatus = createTaskRequest.getTaskStatus();

        task.setTaskType(taskType);
        task.setTaskSummary(taskSummary);
        task.setTaskDescription(taskDescription);
        task.setTaskPriority(taskPriority);
        task.setTaskStatus(taskStatus);
        task.setCreatedBy(createdBy);
        task.setAssignedTo(assignedTo);
        task.setParentTask(parentTask);
        task.setSubTasks(subTasks);
        task.setWatchers(watchers);
        task.setLabels(labels);

        return task;
    }

    public Task mapToEntity(UpdateTaskRequest updateTaskRequest, Task task, User assignedTo, Task parentTask, Set<Task> subTasks, Set<User> watchers, Set<Label> labels) {
        TaskType taskType = updateTaskRequest.getTaskType();
        String taskSummary = updateTaskRequest.getTaskSummary();
        String taskDescription = updateTaskRequest.getTaskDescription();
        TaskPriority taskPriority = updateTaskRequest.getTaskPriority();
        TaskStatus taskStatus = updateTaskRequest.getTaskStatus();

        task.setTaskType(taskType);
        task.setTaskSummary(taskSummary);
        task.setTaskDescription(taskDescription);
        task.setTaskPriority(taskPriority);
        task.setTaskStatus(taskStatus);
        task.setAssignedTo(assignedTo);
        task.setParentTask(parentTask);
        task.setSubTasks(subTasks);
        task.setWatchers(watchers);
        task.setLabels(labels);

        return task;
    }

    public Task patchToEntity(UpdateTaskRequest updateTaskRequest, Task task, User newAssignedTo, Task newParentTask, Set<Task> newSubTasks, Set<User> newWatchers, Set<Label> newLabels) {
        TaskType newTaskType = updateTaskRequest.getTaskType();
        String newTaskSummary = updateTaskRequest.getTaskSummary();
        String newTaskDescription = updateTaskRequest.getTaskDescription();
        TaskPriority newTaskPriority = updateTaskRequest.getTaskPriority();
        TaskStatus newTaskStatus = updateTaskRequest.getTaskStatus();

        TaskType oldTaskType = task.getTaskType();
        String oldTaskSummary = task.getTaskSummary();
        String oldTaskDescription = task.getTaskDescription();
        TaskPriority oldTaskPriority = task.getTaskPriority();
        TaskStatus oldTaskStatus = task.getTaskStatus();
        User oldAssignedTo = task.getAssignedTo();
        Task oldParentTask = task.getParentTask();
        Set<Task> oldSubTasks = task.getSubTasks();
        Set<User> oldWatchers = task.getWatchers();
        Set<Label> oldLabels = task.getLabels();

        task.setTaskType(newTaskType != null ? newTaskType : oldTaskType);
        task.setTaskSummary(newTaskSummary != null ? newTaskSummary : oldTaskSummary);
        task.setTaskDescription(newTaskDescription != null ? newTaskDescription : oldTaskDescription);
        task.setTaskPriority(newTaskPriority != null ? newTaskPriority : oldTaskPriority);
        task.setTaskStatus(newTaskStatus != null ? newTaskStatus : oldTaskStatus);
        task.setAssignedTo(newAssignedTo != null ? newAssignedTo : oldAssignedTo);
        task.setParentTask(newParentTask != null ? newParentTask : oldParentTask);
        task.setSubTasks(newSubTasks != null ? newSubTasks : oldSubTasks);
        task.setWatchers(newWatchers != null ? newWatchers : oldWatchers);
        task.setLabels(newLabels != null ? newLabels : oldLabels);

        return task;
    }

    public TaskResponse mapToResponse(Task task, UserResponse createdBy, UserResponse assignedTo, TaskResponse parentTask, Set<TaskResponse> subTasks, Set<UserResponse> watchers, Set<LabelResponse> labels, Set<CommentResponse> comments, Set<ActivityResponse> activities) {
        TaskResponse taskResponse = new TaskResponse();

        Long id = task.getId();
        TaskType taskType = task.getTaskType();
        String taskSummary = task.getTaskSummary();
        String taskDescription = task.getTaskDescription();
        TaskPriority taskPriority = task.getTaskPriority();
        TaskStatus taskStatus = task.getTaskStatus();
        Instant createdAt = task.getCreatedAt();
        Instant updatedAt = task.getUpdatedAt();

        taskResponse.setId(id);
        taskResponse.setTaskType(taskType);
        taskResponse.setTaskSummary(taskSummary);
        taskResponse.setTaskDescription(taskDescription);
        taskResponse.setTaskPriority(taskPriority);
        taskResponse.setTaskStatus(taskStatus);
        taskResponse.setCreatedBy(createdBy);
        taskResponse.setAssignedTo(assignedTo);
        taskResponse.setParentTask(parentTask);
        taskResponse.setSubTasks(subTasks);
        taskResponse.setWatchers(watchers);
        taskResponse.setLabels(labels);
        taskResponse.setComments(comments);
        taskResponse.setActivities(activities);
        taskResponse.setCreatedAt(createdAt);
        taskResponse.setUpdatedAt(updatedAt);

        return taskResponse;
    }
}
