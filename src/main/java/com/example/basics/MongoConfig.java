package com.example.basics;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = FilmRepository.class)
@Configuration
public class MongoConfig {
    @Bean
    CommandLineRunner commandLineRunner(FilmRepository filmRepository){
        return strings -> {
//            filmRepository.save(new Film("1","first", "author1", "desc", "horror", "url"));
//            filmRepository.save(new Film("2","second", "author2", "desc", "horror", "url"));
        };
    }
}
