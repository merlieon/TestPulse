package com.merlieon.testpulse.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.merlieon.testpulse.models.TestResultModel;
import com.merlieon.testpulse.services.TestResultService;

import java.net.URI;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/tests")
public class TestResultController {
 
    private final TestResultService testResultService;

    public TestResultController(TestResultService testResultService) {
        this.testResultService = testResultService;
    }

    @GetMapping("/results")
    public Map<Long, TestResultModel> getTestResult() {
        return testResultService.getAllTestResults();
    }
       
    @GetMapping("/results/{id}")
    public ResponseEntity<TestResultModel> getTestResultsById(@PathVariable Long id) {
        TestResultModel testResultModel = testResultService.getTestResultsById(id);
        if (testResultModel == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(testResultModel);
    }
    
    @PostMapping("/results")
    public ResponseEntity<TestResultModel> postTestResult(@RequestBody TestResultModel testResultModel) {
        TestResultModel add = testResultService.addTestResult(testResultModel);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
        .path("/{id}")
        .buildAndExpand(add.id())
        .toUri();
        return ResponseEntity.created(location).body(add);
    }
    

}
