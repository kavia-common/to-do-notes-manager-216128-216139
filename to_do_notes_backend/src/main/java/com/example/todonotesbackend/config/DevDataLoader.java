package com.example.todonotesbackend.config;

import com.example.todonotesbackend.model.Note;
import com.example.todonotesbackend.repository.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * Seeds sample data for local development profile.
 */
@Configuration
@Profile({"dev", "local"})
public class DevDataLoader {

    // PUBLIC_INTERFACE
    @Bean
    public CommandLineRunner seedNotes(NoteRepository repository) {
        /** Seeds example notes on startup for dev/local profiles. */
        return args -> {
            if (repository.count() == 0) {
                repository.save(new Note("Buy groceries", "Milk, Eggs, Bread", false));
                repository.save(new Note("Read book", "Finish chapter 4", true));
                repository.save(new Note("Workout", "30 minutes cardio", false));
            }
        };
    }
}
