package com.todo.backend.service;

import com.todo.backend.service.dto.TodoItemCreateDTO;
import com.todo.backend.service.dto.TodoItemDTO;
import com.todo.backend.service.dto.TodoItemUpdateDTO;

import java.util.List;

public interface TodoService {
    List<TodoItemDTO> findAll();

    TodoItemDTO findById(Integer id);

    TodoItemDTO add(TodoItemCreateDTO newItem);

    TodoItemDTO update(TodoItemUpdateDTO updatedItem);

    void delete(Integer id);
}
