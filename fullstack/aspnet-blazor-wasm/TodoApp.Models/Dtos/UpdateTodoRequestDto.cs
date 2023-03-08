namespace TodoApp.Models.Dtos;

public record UpdateTodoRequestDto(
    string Title,
    string Description,
    bool Completed,
    System.DateTime PostDateTime
);