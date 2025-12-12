package com.ecs160.microservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring Boot annotation
@RestController
public class BugFinderMicroservice 
{
    private OllamaClient ollama = new OllamaClient();

    // For GET requests
    @GetMapping("/find_bugs")
    public String findBugs(@RequestParam String code) 
    {
        String systemPrompt = "You are a senior software engineer." +
                "Analyze the following C++ code for bugs. " +
                "Return the result as a valid JSON LIST of objects in the format: \"bug_type\", \"line\", \"description\", \"filename\". " +
                "If there are no bugs, return an empty list.";

        System.out.println("Bug Finder locating bugs...");
        return ollama.query(systemPrompt, code);
    }
}