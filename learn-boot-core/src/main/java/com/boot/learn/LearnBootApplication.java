package com.boot.learn;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.boot.learn","javax.persistence"})
@Configuration
@EntityScan(basePackages = {"com.boot.learn.entity"})
@EnableJpaRepositories(basePackages = {"com.boot.learn.repository"})
public class LearnBootApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LearnBootApplication.class);
    }
}
