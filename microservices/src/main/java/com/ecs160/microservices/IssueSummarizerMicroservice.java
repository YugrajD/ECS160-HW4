package com.ecs160.microservices;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// Spring Boot annotation
@RestController
public class IssueSummarizerMicroservice {
    private OllamaClient ollama = new OllamaClient();

    // For GET requests
    @GetMapping("/summarize_issue")
    public String summarizeIssue(@RequestParam String issueJson) {
        String systemPrompt = "You are a senior software engineer." +
            "Summarize the following GitHub Issue JSON into a single valid JSON object with these exact fields: " +
            "\"bug_type\" (string), \"line\" (integer; default to 0), " +
            "\"description\" (string), \"filename\" (string; default to N/A).";
      
        System.out.println("Issue summarizer summarizing...");
        return ollama.query(systemPrompt, issueJson);
    }
}