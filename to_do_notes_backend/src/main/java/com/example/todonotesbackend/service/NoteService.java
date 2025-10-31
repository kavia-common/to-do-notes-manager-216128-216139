package com.example.todonotesbackend.service;

import com.example.todonotesbackend.dto.NoteDtos;
import com.example.todonotesbackend.model.Note;
import com.example.todonotesbackend.repository.NoteRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

/**
 * Service layer for Note operations with validation and error handling.
 */
@Service
public class NoteService {

    private final NoteRepository repository;

    public NoteService(NoteRepository repository) {
        this.repository = repository;
    }

    // PUBLIC_INTERFACE
    public Page<Note> list(Pageable pageable) {
        /** Returns a page of notes using the provided pageable for pagination and sorting. */
        return repository.findAll(pageable);
    }

    // PUBLIC_INTERFACE
    public Note getById(Long id) {
        /** Returns a note by id or throws 404 if not found. */
        return repository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Note not found"));
    }

    // PUBLIC_INTERFACE
    public Note create(NoteDtos.CreateNoteRequest req) {
        /** Creates and returns a new note from the provided request payload. */
        Note note = new Note(req.title, req.content, req.completed != null && req.completed);
        return repository.save(note);
    }

    // PUBLIC_INTERFACE
    public Note update(Long id, NoteDtos.UpdateNoteRequest req) {
        /** Updates an existing note or throws 404 if not found. */
        Note existing = getById(id);
        existing.setTitle(req.title);
        existing.setContent(req.content);
        if (req.completed != null) {
            existing.setCompleted(req.completed);
        }
        return repository.save(existing);
    }

    // PUBLIC_INTERFACE
    public void delete(Long id) {
        /** Deletes a note by id or throws 404 if not found. */
        Note existing = getById(id);
        repository.delete(existing);
    }
}
