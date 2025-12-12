package com.ecs160;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Spring Boot annotation
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Starting Spring Boot...");
        SpringApplication.run(App.class, args);
    }
}