package com.todo.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

public record TodoItemUpdateDTO(
        Integer id,
        String title,
        String description
) {
    public TodoItemUpdateDTO {
        Objects.requireNonNull(id);
        Objects.requireNonNull(title);
        Objects.requireNonNull(description);
    }

}