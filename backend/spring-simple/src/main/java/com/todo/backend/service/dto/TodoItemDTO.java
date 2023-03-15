package com.todo.backend.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.*;
import java.util.Objects;

public class TodoItemDTO {
    public TodoItemDTO() {
    }
    public TodoItemDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }
    @NotNull
    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private String description;
    private final ZonedDateTime createdAt = ZonedDateTime.now(Clock.systemUTC());
    private final ZonedDateTime editedAt = ZonedDateTime.now(Clock.systemUTC());

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ZonedDateTime getCreatedAt() {
        return createdAt;
    }

    public ZonedDateTime getEditedAt() {
        return editedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemDTO that = (TodoItemDTO) o;
        return id.equals(that.id) && title.equals(that.title) && description.equals(that.description) && createdAt.equals(that.createdAt) && editedAt.equals(that.editedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, createdAt, editedAt);
    }

    @Override
    public String toString() {
        return "TodoItemDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                '}';
    }
}