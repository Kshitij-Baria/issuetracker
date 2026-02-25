package com.example.issuetracker.service.mapper;

import com.example.issuetracker.model.Comment;
import com.example.issuetracker.model.Task;
import com.example.issuetracker.model.User;
import com.example.issuetracker.model.dto.request.CreateCommentRequest;
import com.example.issuetracker.model.dto.request.UpdateCommentRequest;
import com.example.issuetracker.model.dto.response.CommentResponse;
import com.example.issuetracker.model.dto.response.TaskResponse;
import com.example.issuetracker.model.dto.response.UserResponse;

import java.time.Instant;

public class CommentMapper {
    public Comment mapToEntity(CreateCommentRequest createCommentRequest, Task task, User author) {
        Comment comment = new Comment();

        String content = createCommentRequest.getContent();

        comment.setTask(task);
        comment.setAuthor(author);
        comment.setContent(content);

        return comment;
    }

    public Comment mapToEntity(UpdateCommentRequest updateCommentRequest, Comment comment) {
        String content = updateCommentRequest.getContent();

        comment.setContent(content);

        return comment;
    }

    public Comment patchToEntity(UpdateCommentRequest updateCommentRequest, Comment comment) {
        String newContent = updateCommentRequest.getContent();

        String oldContent = comment.getContent();

        comment.setContent(newContent != null ? newContent : oldContent);

        return comment;
    }

    public CommentResponse mapToResponse(Comment comment, TaskResponse taskResponse, UserResponse userResponse) {
        CommentResponse commentResponse = new CommentResponse();

        Long id = comment.getId();
        String content = comment.getContent();
        Instant createdAt = comment.getCreatedAt();
        Instant updatedAt = comment.getUpdatedAt();

        commentResponse.setId(id);
        commentResponse.setTask(taskResponse);
        commentResponse.setAuthor(userResponse);
        commentResponse.setContent(content);
        commentResponse.setCreatedAt(createdAt);
        commentResponse.setUpdatedAt(updatedAt);

        return commentResponse;
    }
}
