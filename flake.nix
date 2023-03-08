{
  description =
    "An assortment of example applications using various technologies.";

  outputs = { self }: {

    templates = rec {

      backend-django-simple = {
        path = ./backend/django-simple;
        description = "Example Todo app backend in Django";
      };
      backend-django-drf-simple = {
        path = ./backend/django-drf-simple;
        description = "Example Todo app backend in Django using Django Rest Framework";
      };
      backend-spring-simple = {
        path = ./backend/spring-simple;
        description = "Example Todo app backend in Spring";
      };
      fullstack-aspnet-blazor-wasm = {
        path = ./fullstack/aspnet-blazor-wasm;
        description = "Example fullstack Todo app using ASP.NET and Blazor";
      };

    };

  };
}

