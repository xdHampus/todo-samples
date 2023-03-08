using System;
using Microsoft.AspNetCore.Mvc;
using TodoApp.Api.Services.Todos.Contracts;
using TodoApp.Models.Dtos;
using TodoApp.Api.Models;
namespace TodoApp.Api.Controllers;


[ApiController]
[Route("api/[controller]")]
public class TodosController : ControllerBase
{
    private readonly ITodoService _todoService;

    public TodosController(ITodoService todoService)
    {
        _todoService = todoService;
    }

    [HttpPost()]
    public IActionResult CreateTodo(CreateTodoRequestDto request)
    {
        var todo = new Todo(
            Guid.NewGuid(),
            request.Title,
            request.Description,
            request.Completed,
            DateTime.UtcNow,
            DateTime.UtcNow
        );

        _todoService.CreateTodo(todo);

        var response = new TodoResponseDto(
            todo.Id,
            todo.Title,
            todo.Description,
            todo.Completed,
            todo.PostDateTime,
            todo.LastModifiedDateTime
        );
        return CreatedAtAction(
            actionName: nameof(GetTodo),
            routeValues: new { id = todo.Id },
            value: response);
    }
    [HttpGet("{id:guid}")]
    public IActionResult GetTodo(Guid id)
    {
        Todo todo = _todoService.GetTodo(id);

        var response = new TodoResponseDto(
            todo.Id,
            todo.Title,
            todo.Description,
            todo.Completed,
            todo.PostDateTime,
            todo.LastModifiedDateTime
        );
        return Ok(todo);
    }
    [HttpGet("all")]
    public async Task<IEnumerable<TodoResponseDto>> GetAllTodos()
    {
        var todos = _todoService.GetAllTodos();
        var responses = todos.ConvertAll(todo =>
            new TodoResponseDto(
            todo.Id,
            todo.Title,
            todo.Description,
            todo.Completed,
            todo.PostDateTime,
            todo.LastModifiedDateTime
        ));

        return responses;
    }

    [HttpPut("{id:guid}")]
    public IActionResult UpdateTodo(Guid id, UpdateTodoRequestDto request)
    {
        var todo = new Todo(
            id,
            request.Title,
            request.Description,
            request.Completed,
            request.PostDateTime,
            DateTime.UtcNow
        );
        _todoService.UpdateTodo(todo);

        return NoContent();
    }
    [HttpDelete("{id:guid}")]
    public IActionResult DeleteTodo(Guid id)
    {
        _todoService.DeleteTodo(id);
        return NoContent();
    }
}