package com.todo.backend.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.Objects;

public class TodoItemUpdateDTO {
    public TodoItemUpdateDTO() {
    }

    @NotNull
    private Integer id;
    @NotBlank
    private String title;
    @NotNull
    private String description;

    @JsonIgnore
    private final LocalDateTime editedAt = LocalDateTime.now();

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

    public LocalDateTime getEditedAt() {
        return editedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItemUpdateDTO that = (TodoItemUpdateDTO) o;
        return id.equals(that.id) && title.equals(that.title) && description.equals(that.description) && editedAt.equals(that.editedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, editedAt);
    }

    @Override
    public String toString() {
        return "TodoItemUpdateDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", editedAt=" + editedAt +
                '}';
    }
}