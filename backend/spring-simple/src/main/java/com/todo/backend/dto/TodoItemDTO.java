package com.todo.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.*;
import java.util.Objects;

public record TodoItemDTO(
        Integer id,
        String title,
        String description,
        ZonedDateTime createdAt,
        ZonedDateTime editedAt
) {
    public TodoItemDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(title);
        Objects.requireNonNull(description);
    }
    public TodoItemDTO(String title, String description) {
        this(0, title, description, ZonedDateTime.now(Clock.systemUTC()),  ZonedDateTime.now(Clock.systemUTC()));
    }
}