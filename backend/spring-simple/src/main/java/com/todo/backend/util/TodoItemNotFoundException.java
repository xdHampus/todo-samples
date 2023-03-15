package com.todo.backend.util;

public class TodoItemNotFoundException extends RuntimeException {
    public TodoItemNotFoundException(Integer id) {
        super("Could not find todo-item " + id);
    }
}
