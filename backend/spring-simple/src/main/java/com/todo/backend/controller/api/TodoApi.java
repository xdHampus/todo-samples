package com.todo.backend.controller.api;

import com.todo.backend.service.dto.TodoItemCreateDTO;
import com.todo.backend.service.dto.TodoItemDTO;
import com.todo.backend.service.dto.TodoItemUpdateDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/todo")
@Tag(name = "Todo", description = "the Todo API")
public interface TodoApi {
    @RequestMapping(value = {"", "/", "/all"}, method = RequestMethod.GET)
    @Operation(summary = "Get all TodoItems", description = "Get all TodoItems")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation")
    })
    List<TodoItemDTO> getAll();

    @GetMapping("/{id}")
    @Operation(summary = "Get specific TodoItem", description = "Get specific TodoItem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "TodoItem not found")
    })
    TodoItemDTO get(@PathVariable Integer id);

    @PostMapping
    @Operation(summary = "Add new TodoItem", description = "Add new TodoItem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "TodoItem not found after adding")
    })
    TodoItemDTO add(@RequestBody TodoItemCreateDTO newItem);

    @PutMapping
    @Operation(summary = "Update TodoItem", description = "Update TodoItem's title and description")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "TodoItem not found")
    })
    TodoItemDTO update(@RequestBody TodoItemUpdateDTO updatedItem);

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete TodoItem", description = "Delete TodoItem")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successful operation"),
            @ApiResponse(responseCode = "404", description = "TodoItem not found")
    })
    void delete(@PathVariable Integer id);
}
