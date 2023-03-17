package com.todo.backend.controller;

import com.todo.backend.dto.ErrorDTO;
import com.todo.backend.util.TodoItemNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class TodoAdvice {
    @ResponseBody
    @ExceptionHandler(TodoItemNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    ErrorDTO todoItemNotFoundHandler(TodoItemNotFoundException ex) {
        return new ErrorDTO(ex.getMessage());
    }
}
