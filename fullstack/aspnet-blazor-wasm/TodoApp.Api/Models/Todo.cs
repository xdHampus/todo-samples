using System;

namespace TodoApp.Api.Models;

public class Todo
{
    public Todo(
        Guid id,
        string title,
        string description,
        bool completed,
        DateTime postDateTime,
        DateTime lastModifiedDateTime)
    {
        Id = id;
        Title = title;
        Description = description;
        Completed = completed;
        PostDateTime = postDateTime;
        LastModifiedDateTime = lastModifiedDateTime;
    }

    public Guid Id { get; }
    public string Title { get; }
    public string Description { get; }
    public bool Completed { get; }
    public DateTime PostDateTime { get; }
    public DateTime LastModifiedDateTime { get; }

    
}



