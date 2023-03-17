package com.todo.backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

public record TodoItemCreateDTO(
        String title,
        String description
) {
    public TodoItemCreateDTO {
        Objects.requireNonNull(title);
        Objects.requireNonNull(description);
    }
}