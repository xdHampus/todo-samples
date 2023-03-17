package com.todo.backend.service.map;

import com.todo.backend.dto.TodoItemCreateDTO;
import com.todo.backend.dto.TodoItemDTO;
import com.todo.backend.dto.TodoItemUpdateDTO;
import com.todo.backend.model.TodoItem;
import com.todo.backend.model.repository.TodoRepository;
import com.todo.backend.util.TodoItemNotFoundException;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Clock;
import java.time.ZonedDateTime;

@Mapper(componentModel = "spring")
public abstract class TodoItemMapper {
    @Autowired
    private TodoRepository repository;

    public abstract TodoItemDTO mapDto(TodoItem todoItem);
    public abstract TodoItem map(TodoItemDTO todoItem);
    public abstract TodoItemCreateDTO mapCreateDto(TodoItem todoItem);
    @Mapping(target="id", constant="0")
    public abstract TodoItem map(TodoItemCreateDTO todoItem);
    public abstract TodoItemUpdateDTO mapUpdateDto(TodoItem todoItem);
    @Mapping(target = "createdAt", source = "id", qualifiedByName = "createdAtById")
    public abstract TodoItem map(TodoItemUpdateDTO todoItem);

    @Named("createdAtById")
    protected ZonedDateTime createdAtById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new TodoItemNotFoundException(id))
                .getCreatedAt();
    }
}
