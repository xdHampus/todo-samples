package com.todo.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.todo.backend.model.TodoItem;
import com.todo.backend.model.repository.TodoRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition
public class ApplicationConfig {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public OpenAPI baseOpenAPI(){
        return new OpenAPI().info(new Info()
                .title("Todo Docs")
                .version("1.0.0")
                .description("Documentation for the Todo backend."));
    }
    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new TodoItem("Homework", "pom & backend apps")));
            log.info("Preloading " + repository.save(new TodoItem("Shopping", "groceries, cat food")));
        };
    }
}
