namespace TodoApp.Web.Services;

using TodoApp.Models.Dtos;
using System.Net.Http.Json;
using TodoApp.Web.Services.Contracts;
using System;



public class TodoService : ITodoService
{
    private readonly HttpClient httpClient;
    public TodoService(HttpClient httpClient)
    {
        this.httpClient = httpClient;
    }

    public async Task CreateTodo(CreateTodoRequestDto todo)
    {
        try
        {
            await this.httpClient.PostAsJsonAsync<CreateTodoRequestDto>("api/todos", todo);
        }
        catch (System.Exception)
        {
            throw;
        }
    }

    public async Task DeleteTodo(Guid id)
    {
        try
        {
            await this.httpClient.DeleteAsync($"api/todos/{id}");
        }
        catch (System.Exception)
        {
            throw;
        }
    }

    public async Task<IEnumerable<TodoResponseDto>> GetAllTodos()
    {
        try
        {
            var todos = await this.httpClient.GetFromJsonAsync<IEnumerable<TodoResponseDto>>("api/todos/all");
            return todos != null ? todos : Enumerable.Empty<TodoResponseDto>();

        }
        catch (System.Exception)
        {
            throw;
        }
    }

    public async Task UpdateTodo(Guid id, UpdateTodoRequestDto todo)
    {
        try
        {
            await this.httpClient.PutAsJsonAsync<UpdateTodoRequestDto>($"api/todos/{id}", todo);

        }
        catch (System.Exception)
        {
            throw;
        }
    }
}