using Microsoft.AspNetCore.Mvc;
namespace TodoApp.Api.Controllers;


public class ErrorsController : ControllerBase
{
    [Route("api/error")]
    public IActionResult Error(){
        return Problem();
    }
}