namespace TodoApp.Web.Pages;

using Microsoft.AspNetCore.Components;
using TodoApp.Models.Dtos;
using TodoApp.Web.Services.Contracts;
using static System.Net.WebRequestMethods;

public class TodoBase : ComponentBase {

    [Inject]
    public ITodoService TodoService { get; set; }

    public IEnumerable<TodoResponseDto> Todos { get; set; }
    public async Task GetAllTodos() =>
    Todos = await TodoService.GetAllTodos();
    protected override async Task OnInitializedAsync() => await GetAllTodos();

}