package com.todo.backend.service;

import com.todo.backend.dto.TodoItemCreateDTO;
import com.todo.backend.dto.TodoItemDTO;
import com.todo.backend.dto.TodoItemUpdateDTO;

import java.util.List;

public interface TodoService {
    List<TodoItemDTO> findAll();

    TodoItemDTO findById(Integer id);

    TodoItemDTO add(TodoItemCreateDTO newItem);

    TodoItemDTO update(TodoItemUpdateDTO updatedItem);

    void delete(Integer id);
}
