package com.example.issuetracker.service.mapper;

import com.example.issuetracker.model.Label;
import com.example.issuetracker.model.dto.request.CreateLabelRequest;
import com.example.issuetracker.model.dto.request.UpdateLabelRequest;
import com.example.issuetracker.model.dto.response.LabelResponse;
import com.example.issuetracker.model.dto.response.TaskResponse;

import java.util.Set;

public class LabelMapper {
    public Label mapToEntity(CreateLabelRequest createLabelRequest) {
        Label label = new Label();

        String labelText = createLabelRequest.getLabelText();

        label.setLabelText(labelText);

        return label;
    }

    public Label mapToEntity(UpdateLabelRequest updateLabelRequest, Label label) {
        String labelText = updateLabelRequest.getLabelText();

        label.setLabelText(labelText);

        return label;
    }

    public Label patchToEntity(UpdateLabelRequest updateLabelRequest, Label label) {
        String newLabelText = updateLabelRequest.getLabelText();

        String oldLabelText = label.getLabelText();

        label.setLabelText(newLabelText != null ? newLabelText : oldLabelText);

        return label;
    }

    public LabelResponse mapToResponse(Label label, Set<TaskResponse> tasks) {
        LabelResponse labelResponse = new LabelResponse();

        String labelText = label.getLabelText();

        labelResponse.setId(label.getId());
        labelResponse.setLabelText(labelText);
        labelResponse.setTasks(tasks);

        return labelResponse;
    }
}
