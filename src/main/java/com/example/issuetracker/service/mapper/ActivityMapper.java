package com.example.issuetracker.service.mapper;

import com.example.issuetracker.model.Activity;
import com.example.issuetracker.model.ActivityFieldType;
import com.example.issuetracker.model.Task;
import com.example.issuetracker.model.User;
import com.example.issuetracker.model.dto.request.CreateActivityRequest;
import com.example.issuetracker.model.dto.response.ActivityResponse;
import com.example.issuetracker.model.dto.response.TaskResponse;
import com.example.issuetracker.model.dto.response.UserResponse;

public class ActivityMapper {
    public Activity mapToEntity(CreateActivityRequest createActivityRequest, Task task, User user) {
        Activity activity = new Activity();

        ActivityFieldType activityFieldType = createActivityRequest.getActivityFieldType();
        String oldValue = createActivityRequest.getOldValue();
        String newValue = createActivityRequest.getNewValue();
        Long targetId = createActivityRequest.getTargetId();

        activity.setTask(task);
        activity.setUser(user);
        activity.setActivityFieldType(activityFieldType);
        activity.setOldValue(oldValue);
        activity.setNewValue(newValue);
        activity.setTargetId(targetId);

        return activity;
    }

    public ActivityResponse mapToResponse(Activity activity, TaskResponse taskResponse, UserResponse userResponse) {
        ActivityResponse activityResponse = new ActivityResponse();

        Long id = activity.getId();
        ActivityFieldType activityFieldType = activity.getActivityFieldType();
        String oldValue = activity.getOldValue();
        String newValue = activity.getNewValue();
        Long targetId = activity.getTargetId();

        activityResponse.setId(id);
        activityResponse.setTask(taskResponse);
        activityResponse.setUser(userResponse);
        activityResponse.setActivityFieldType(activityFieldType);
        activityResponse.setOldValue(oldValue);
        activityResponse.setNewValue(newValue);
        activityResponse.setTargetId(targetId);

        return activityResponse;
    }
}
