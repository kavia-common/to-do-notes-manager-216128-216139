package com.example.todonotesbackend.repository;

import com.example.todonotesbackend.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Note entity.
 */
@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
}
