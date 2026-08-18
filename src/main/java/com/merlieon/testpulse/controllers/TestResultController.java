package com.merlieon.testpulse.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.merlieon.testpulse.models.TestResultModel;
import com.merlieon.testpulse.services.TestResultService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/api/tests")
public class TestResultController {
 
    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping("/results")
    public List<TestResultModel> getTestResult() {
        return testResultService.getAllTestResults();
    }
        
}
