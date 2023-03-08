package com.todo.backend.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data @NoArgsConstructor @EqualsAndHashCode
public class TodoItem {
    @Id @GeneratedValue
    private Long id;
    @NotBlank
    private String title;
    @NotNull
    private String description;
    @NotNull
    private LocalDateTime createdAt;
    @NotNull
    private LocalDateTime editedAt;
    public TodoItem(String title, String description) {
        this.title = title;
        this.description = description;
        createdAt = LocalDateTime.now();
        editedAt = LocalDateTime.now();
    }
}
