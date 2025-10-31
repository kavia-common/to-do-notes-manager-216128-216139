package com.example.todonotesbackend.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.OffsetDateTime;

/**
 * Note entity representing a to-do note with auditing timestamps.
 */
@Entity
@Table(name = "notes")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Column(nullable = false, length = 255)
    private String title;

    @Lob
    @Column
    private String content;

    @Column(nullable = false)
    private boolean completed = false;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private OffsetDateTime createdAt;

    @UpdateTimestamp
    @Column(nullable = false)
    private OffsetDateTime updatedAt;

    public Note() {
    }

    public Note(String title, String content, boolean completed) {
        this.title = title;
        this.content = content;
        this.completed = completed;
    }

    // Getters and setters

    // PUBLIC_INTERFACE
    public Long getId() {
        /** Returns the database identifier of the note. */
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // PUBLIC_INTERFACE
    public String getTitle() {
        /** Returns the title of the note. */
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // PUBLIC_INTERFACE
    public String getContent() {
        /** Returns the content/body of the note. */
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // PUBLIC_INTERFACE
    public boolean isCompleted() {
        /** Returns whether the note is marked as completed. */
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    // PUBLIC_INTERFACE
    public OffsetDateTime getCreatedAt() {
        /** Returns when the note was created. */
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    // PUBLIC_INTERFACE
    public OffsetDateTime getUpdatedAt() {
        /** Returns when the note was last updated. */
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
