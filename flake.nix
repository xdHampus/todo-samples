{
  description =
    "An assortment of example applications using various technologies.";

  outputs = { self }: {

    templates = rec {

      backend-django-simple = {
        path = ./backend/django-simple;
        description = "A standard flake template";
      };
      backend-django-drf-simple = {
        path = ./backend/django-drf-simple;
        description = "A standard flake template";
      };
      backend-spring-simple = {
        path = ./backend/spring-simple;
        description = "A standard flake template";
      };
      fullstack-aspnet-blazor-wasm = {
        path = ./fullstack/aspnet-blazor-wasm;
        description = "A standard flake template";
      };

    };

  };
}

