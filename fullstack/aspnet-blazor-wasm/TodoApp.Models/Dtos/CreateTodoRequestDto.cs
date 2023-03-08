namespace TodoApp.Models.Dtos;

public record CreateTodoRequestDto(
    string Title,
    string Description,
    bool Completed
);