namespace TodoApp.Web.Services.Contracts;

using TodoApp.Models.Dtos;

public interface ITodoService
{
    Task CreateTodo(CreateTodoRequestDto todo);
    Task DeleteTodo(Guid id);
    Task<IEnumerable<TodoResponseDto>> GetAllTodos();
    Task UpdateTodo(Guid id, UpdateTodoRequestDto todo);
}