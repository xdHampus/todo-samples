package com.todo.backend.controller;

import com.todo.backend.service.TodoService;
import com.todo.backend.service.dto.TodoItemDTO;
import com.todo.backend.service.dto.TodoItemUpdateDTO;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @RequestMapping(value={"", "/", "/all"})
    List<TodoItemDTO> getAll(){
        return todoService.findAll();
    }
    @GetMapping("/{id}")
    TodoItemDTO get(@PathVariable Integer id){
        return todoService.findById(id);
    }
    @PostMapping
    TodoItemDTO add(@RequestBody TodoItemDTO newItem){
        return todoService.add(newItem);
    }
    @PutMapping
    TodoItemDTO update(@RequestBody TodoItemUpdateDTO updatedItem){
        return todoService.update(updatedItem);
    }
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id){
        todoService.delete(id);
    }

}


