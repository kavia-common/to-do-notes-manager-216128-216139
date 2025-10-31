package com.example.todonotesbackend.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

/**
 * DTO classes for Note create/update operations.
 */
public class NoteDtos {

    @Schema(name = "CreateNoteRequest", description = "Payload to create a new note")
    public static class CreateNoteRequest {
        @NotBlank
        @Schema(description = "Title of the note", example = "Buy groceries", requiredMode = Schema.RequiredMode.REQUIRED)
        public String title;

        @Schema(description = "Optional content of the note", example = "Milk, Eggs, Bread")
        public String content;

        @Schema(description = "Whether the note is completed", defaultValue = "false", example = "false")
        public Boolean completed = false;
    }

    @Schema(name = "UpdateNoteRequest", description = "Payload to update an existing note")
    public static class UpdateNoteRequest {
        @NotBlank
        @Schema(description = "Title of the note", example = "Buy groceries (updated)", requiredMode = Schema.RequiredMode.REQUIRED)
        public String title;

        @Schema(description = "Optional content of the note", example = "Milk, Eggs, Bread, Butter")
        public String content;

        @Schema(description = "Whether the note is completed", defaultValue = "false", example = "true")
        public Boolean completed;
    }
}
