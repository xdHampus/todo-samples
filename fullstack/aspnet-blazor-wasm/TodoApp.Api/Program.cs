using Microsoft.AspNetCore.Builder;
using Microsoft.Extensions.DependencyInjection;
using TodoApp.Api.Services.Todos.Contracts;
using TodoApp.Api.Services.Todos;

var builder = WebApplication.CreateBuilder(args);
{
    
    builder.Services.AddCors(options =>
    {
        options.AddPolicy("AllowAny",
                          builder =>
                          {
                              builder.AllowAnyOrigin().AllowAnyMethod().AllowAnyHeader();
                          });
    });

    builder.Services.AddControllers();
    builder.Services.AddScoped<ITodoService, TodoService>();
}

var app = builder.Build();
{
    app.UseExceptionHandler("/error");
    //app.UseHttpsRedirection();
    app.UseCors("AllowAny");
    app.MapControllers();
    app.Run();
}
