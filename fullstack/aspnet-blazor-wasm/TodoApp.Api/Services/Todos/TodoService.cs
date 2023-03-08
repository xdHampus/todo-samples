namespace TodoApp.Api.Services.Todos;

using System;
using System.Collections.Generic;
using TodoApp.Api.Services.Todos.Contracts;
using TodoApp.Api.Models;
public class TodoService : ITodoService
{
    private static readonly Dictionary<Guid, Todo> _todos = new();
    public void CreateTodo(Todo todo){
        _todos.Add(todo.Id, todo);
    }

    public void DeleteTodo(Guid id)
    {
        _todos.Remove(id);
    }

    public List<Todo> GetAllTodos()
    {
        return _todos.Values.ToList();
    }

    public Todo GetTodo(Guid id){
        return _todos[id];
    }

    public void UpdateTodo(Todo todo)
    {
        _todos[todo.Id] = todo;
    }
}