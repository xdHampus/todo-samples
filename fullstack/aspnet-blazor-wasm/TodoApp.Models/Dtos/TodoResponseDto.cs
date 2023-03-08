namespace TodoApp.Models.Dtos;

public record TodoResponseDto(
    System.Guid Id,
    string Title,
    string Description,
    bool Completed,
    System.DateTime PostDateTime,
    System.DateTime LastModifiedDateTime
);