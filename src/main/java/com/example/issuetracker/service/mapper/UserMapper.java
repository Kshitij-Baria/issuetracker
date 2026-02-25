package com.example.issuetracker.service.mapper;

import com.example.issuetracker.model.User;
import com.example.issuetracker.model.dto.request.CreateUserRequest;
import com.example.issuetracker.model.dto.request.UpdateUserRequest;
import com.example.issuetracker.model.dto.response.UserResponse;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class UserMapper {
    public User mapToEntity(CreateUserRequest createUserRequest) {
        User user = new User();

        String username = createUserRequest.getUsername();
        String email = createUserRequest.getEmail();

        user.setUsername(username);
        user.setEmail(email);

        return user;
    }

    public User mapToEntity(UpdateUserRequest updateUserRequest, User user) {
        String username = updateUserRequest.getUsername();
        String email = updateUserRequest.getEmail();
        Boolean isActive = updateUserRequest.getIsActive();

        user.setUsername(username);
        user.setEmail(email);
        user.setActive(isActive);

        return user;
    }

    public User patchToEntity(UpdateUserRequest updateUserRequest, User user) {
        String newUsername = updateUserRequest.getUsername();
        String newEmail = updateUserRequest.getEmail();
        Boolean newActiveFlag = updateUserRequest.getIsActive();

        String oldUsername = user.getUsername();
        String oldEmail = user.getEmail();
        boolean oldActiveFlag = user.isActive();

        user.setUsername(newUsername != null ? newUsername : oldUsername);
        user.setEmail(newEmail != null ? newEmail : oldEmail);
        user.setActive(newActiveFlag != null ? newActiveFlag : oldActiveFlag);

        return user;
    }

    public UserResponse mapToResponse(User user) {
        UserResponse userResponse = new UserResponse();

        Long id = user.getId();
        String username = user.getUsername();
        String email = user.getEmail();
        boolean isActive = user.isActive();
        Instant createdAt = user.getCreatedAt();
        Instant deletedAt = user.getDeletedAt();

        userResponse.setUserId(id);
        userResponse.setUsername(username);
        userResponse.setEmail(email);
        userResponse.setActive(isActive);
        userResponse.setCreatedAt(createdAt);
        userResponse.setDeletedAt(deletedAt);

        return userResponse;
    }
}
