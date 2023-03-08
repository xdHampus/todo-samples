package com.todo.backend;

import com.todo.backend.model.TodoItem;
import com.todo.backend.model.repository.TodoRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    private static final Logger log = LoggerFactory.getLogger(ApplicationConfig.class);

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    CommandLineRunner initDatabase(TodoRepository repository) {

        return args -> {
            log.info("Preloading " + repository.save(new TodoItem("Homework", "pom & backend apps")));
            log.info("Preloading " + repository.save(new TodoItem("Shopping", "groceries, cat food")));
        };
    }
}
