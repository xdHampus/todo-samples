package com.todo.backend.service;

import com.todo.backend.service.map.TodoItemMapper;
import com.todo.backend.model.repository.TodoRepository;
import com.todo.backend.dto.TodoItemCreateDTO;
import com.todo.backend.dto.TodoItemDTO;
import com.todo.backend.dto.TodoItemUpdateDTO;
import com.todo.backend.util.TodoItemNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final TodoItemMapper mapper;
    public TodoServiceImpl(TodoRepository todoRepository, TodoItemMapper mapper) {
        this.todoRepository = todoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<TodoItemDTO> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(mapper::mapDto)
                .collect(Collectors.toList());
    }

    @Override
    public TodoItemDTO findById(Integer id) {
        return mapper.mapDto(
                todoRepository.findById(id)
                        .orElseThrow(() -> new TodoItemNotFoundException(id))
        );
    }

    @Override
    public TodoItemDTO add(TodoItemCreateDTO newItem) {
        var itemToSave = todoRepository.save(mapper.map(newItem));
        return mapper.mapDto(itemToSave);
    }

    @Override
    public TodoItemDTO update(TodoItemUpdateDTO updatedItem) {
        var itemToSave = mapper.map(updatedItem);
        return mapper.mapDto(todoRepository.save(itemToSave));
    }

    @Override
    public void delete(Integer id) {
        if(!todoRepository.existsById(id)){
            throw new TodoItemNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }
}
