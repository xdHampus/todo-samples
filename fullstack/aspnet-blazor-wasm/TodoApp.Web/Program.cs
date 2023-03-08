using Microsoft.AspNetCore.Components.Web;
using Microsoft.AspNetCore.Components.WebAssembly.Hosting;
using TodoApp.Web.Services.Contracts;
using TodoApp.Web;
using TodoApp.Web.Services;

var builder = WebAssemblyHostBuilder.CreateDefault(args);
{
    builder.RootComponents.Add<App>("#app");
    builder.RootComponents.Add<HeadOutlet>("head::after");

    builder.Services.AddScoped(sp => new HttpClient { BaseAddress = new Uri( "http://localhost:5158" ) }); //builder.HostEnvironment.BaseAddress
    builder.Services.AddScoped<ITodoService, TodoService>();
}


await builder.Build().RunAsync();
