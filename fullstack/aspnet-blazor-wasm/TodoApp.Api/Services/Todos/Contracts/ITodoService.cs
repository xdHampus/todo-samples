namespace TodoApp.Api.Services.Todos.Contracts;

using System;
using TodoApp.Api.Models;

public interface ITodoService
{
    void CreateTodo(Todo todo);
    void DeleteTodo(Guid id);
    List<Todo> GetAllTodos();
    Todo GetTodo(Guid id);
    void UpdateTodo(Todo todo);
}