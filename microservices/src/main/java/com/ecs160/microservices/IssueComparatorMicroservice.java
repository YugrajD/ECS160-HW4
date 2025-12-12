package com.ecs160.microservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring Boot annotation
@RestController
public class IssueComparatorMicroservice {
    private OllamaClient ollama = new OllamaClient();

    // For GET requests
    @GetMapping("/check_equivalence")
    public String checkEquivalence(@RequestParam String issueJsonArray) 
    {
        String systemPrompt = "You are a senior software engineer. " +
                "I will provide a JSON array containing two lists of bugs: [List A, List B]. " +
                "Your task is to identify overlapping bugs that are present in BOTH lists. " +
                "Return a single valid JSON array containing only the matching bugs. " +
                "If no overlapping bugs are found, return an empty JSON array: []. " +
                "If one list is empty (no bugs), you should default return an empty JSON array [].";

        System.out.println("Issue Comparator comparing...");
        return ollama.query(systemPrompt, issueJsonArray);
    }
}