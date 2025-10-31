package com.example.todonotesbackend.controller;

import com.example.todonotesbackend.dto.NoteDtos;
import com.example.todonotesbackend.model.Note;
import com.example.todonotesbackend.service.NoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for managing to-do notes.
 */
@RestController
@RequestMapping("/api/notes")
@Tag(name = "Notes", description = "CRUD operations for to-do notes")
public class NoteController {

    private final NoteService service;

    public NoteController(NoteService service) {
        this.service = service;
    }

    // PUBLIC_INTERFACE
    @GetMapping
    @Operation(
            summary = "List notes (paginated)",
            description = "Returns a paginated list of notes. Use 'page', 'size', and 'sort' query params.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of notes returned",
                            content = @Content(mediaType = "application/json",
                                    schema = @Schema(implementation = Page.class)))
            }
    )
    public Page<Note> list(
            @ParameterObject Pageable pageable
    ) {
        /** Returns a paginated list of notes. Query params: page, size, sort (e.g., sort=createdAt,desc). */
        return service.list(pageable);
    }

    // PUBLIC_INTERFACE
    @GetMapping("/{id}")
    @Operation(
            summary = "Get a note by ID",
            description = "Returns a single note by its ID.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note found",
                            content = @Content(schema = @Schema(implementation = Note.class))),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    public Note getById(
            @Parameter(description = "Note ID", required = true) @PathVariable Long id
    ) {
        /** Returns a note by ID or 404 if it does not exist. */
        return service.getById(id);
    }

    // PUBLIC_INTERFACE
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Create a new note",
            description = "Creates a new note with the provided data.",
            responses = {
                    @ApiResponse(responseCode = "201", description = "Note created",
                            content = @Content(schema = @Schema(implementation = Note.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error",
                            content = @Content)
            }
    )
    public Note create(
            @Valid @RequestBody NoteDtos.CreateNoteRequest request
    ) {
        /** Creates a new note. Title is required. Returns the created note. */
        return service.create(request);
    }

    // PUBLIC_INTERFACE
    @PutMapping("/{id}")
    @Operation(
            summary = "Update an existing note",
            description = "Updates title/content/completed fields of an existing note.",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Note updated",
                            content = @Content(schema = @Schema(implementation = Note.class))),
                    @ApiResponse(responseCode = "400", description = "Validation error"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    public Note update(
            @Parameter(description = "Note ID", required = true) @PathVariable Long id,
            @Valid @RequestBody NoteDtos.UpdateNoteRequest request
    ) {
        /** Updates a note by ID. Returns the updated note or 404 if not found. */
        return service.update(id, request);
    }

    // PUBLIC_INTERFACE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Delete a note",
            description = "Deletes a note by its ID.",
            responses = {
                    @ApiResponse(responseCode = "204", description = "Note deleted"),
                    @ApiResponse(responseCode = "404", description = "Note not found")
            }
    )
    public void delete(
            @Parameter(description = "Note ID", required = true) @PathVariable Long id
    ) {
        /** Deletes a note by ID. Returns 204 if deleted or 404 if not found. */
        service.delete(id);
    }
}
