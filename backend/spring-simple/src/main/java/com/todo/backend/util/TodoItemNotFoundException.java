package com.todo.backend.util;

public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(Long id) {
        super("Could not find todo-item " + id);
    }
}
