package com.todo.backend.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @NoArgsConstructor
public class TodoItemUpdateDTO {
    @Id @GeneratedValue
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    private String description;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();
}