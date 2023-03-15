package com.todo.backend.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.Objects;

@Entity
@Table(name = "todo_item")
public class TodoItem {
    public TodoItem() {
        createdAt = ZonedDateTime.now(Clock.systemUTC());
        editedAt = ZonedDateTime.now(Clock.systemUTC());
    }
    public TodoItem(String title, String description) {
        this();
        this.title = title;
        this.description = description;
    }
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @NotBlank
    @NotNull
    @Column(name = "title")
    private String title;
    @NotNull
    @Column(name = "description")
    private String description;
    @NotNull
    @Column(name = "created_at")
    private ZonedDateTime createdAt;
    @NotNull
    @Column(name = "edited_at")
    private ZonedDateTime editedAt;

    @Column(name = "completed", columnDefinition = "boolean default false")
    @NotNull
    private boolean completed = false;

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

    public void setCreatedAt(ZonedDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public ZonedDateTime getEditedAt() {
        return editedAt;
    }

    public void setEditedAt(ZonedDateTime editedAt) {
        this.editedAt = editedAt;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TodoItem todoItem = (TodoItem) o;
        return id.equals(todoItem.id) && title.equals(todoItem.title) && description.equals(todoItem.description) && createdAt.equals(todoItem.createdAt) && editedAt.equals(todoItem.editedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, createdAt, editedAt);
    }

    @Override
    public String toString() {
        return "TodoItem{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                ", editedAt=" + editedAt +
                '}';
    }
}
