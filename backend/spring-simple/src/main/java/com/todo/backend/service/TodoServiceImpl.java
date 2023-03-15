package com.todo.backend.service;

import com.todo.backend.model.TodoItem;
import com.todo.backend.model.repository.TodoRepository;
import com.todo.backend.service.dto.TodoItemCreateDTO;
import com.todo.backend.service.dto.TodoItemDTO;
import com.todo.backend.service.dto.TodoItemUpdateDTO;
import com.todo.backend.util.TodoItemNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoServiceImpl implements TodoService {
    private final TodoRepository todoRepository;
    private final ModelMapper mapper;
    public TodoServiceImpl(TodoRepository todoRepository, ModelMapper mapper) {
        this.todoRepository = todoRepository;
        this.mapper = mapper;
    }

    @Override
    public List<TodoItemDTO> findAll() {
        return todoRepository.findAll()
                .stream()
                .map(x -> mapper.map(x, TodoItemDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public TodoItemDTO findById(Integer id) {
        return mapper.map(
                todoRepository.findById(id)
                        .orElseThrow(() -> new TodoItemNotFoundException(id)),
                TodoItemDTO.class
        );
    }

    @Override
    public TodoItemDTO add(TodoItemCreateDTO newItem) {
        var savedItem = todoRepository.save(mapper.map(newItem, TodoItem.class));
        return mapper.map(savedItem, TodoItemDTO.class);
    }

    @Override
    public TodoItemDTO update(TodoItemUpdateDTO updatedItem) {
        var oldItem = todoRepository.findById(updatedItem.getId())
                .orElseThrow(() -> new TodoItemNotFoundException(updatedItem.getId()));

        var itemToSave = mapper.map(updatedItem, TodoItem.class);
        itemToSave.setCreatedAt(oldItem.getCreatedAt());

        return mapper.map(todoRepository.save(itemToSave), TodoItemDTO.class);
    }

    @Override
    public void delete(Integer id) {
        if(!todoRepository.existsById(id)){
            throw new TodoItemNotFoundException(id);
        }
        todoRepository.deleteById(id);
    }
}
