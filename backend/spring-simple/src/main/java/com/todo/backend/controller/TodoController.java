package com.todo.backend.controller;

import com.todo.backend.controller.api.TodoApi;
import com.todo.backend.service.TodoService;
import com.todo.backend.dto.TodoItemCreateDTO;
import com.todo.backend.dto.TodoItemDTO;
import com.todo.backend.dto.TodoItemUpdateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController implements TodoApi {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @Override
    public List<TodoItemDTO> getAll(){
        return todoService.findAll();
    }
    @Override
    public TodoItemDTO get(@PathVariable Integer id){
        return todoService.findById(id);
    }
    @Override
    public TodoItemDTO add(@RequestBody TodoItemCreateDTO newItem){
        return todoService.add(newItem);
    }
    @Override
    public TodoItemDTO update(@RequestBody TodoItemUpdateDTO updatedItem){
        return todoService.update(updatedItem);
    }
    @Override
    public void delete(@PathVariable Integer id){
        todoService.delete(id);
    }

}


