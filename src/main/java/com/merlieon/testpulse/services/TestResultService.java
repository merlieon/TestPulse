package com.merlieon.testpulse.services;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.merlieon.testpulse.models.Status;
import com.merlieon.testpulse.models.TestResultModel;

@Service
public class TestResultService {

    private final Map<Long, TestResultModel> testResults = new HashMap<>();
    private long nextId = 1;

    public TestResultService() {
        createInitData();
    }

    private long generateNextId() {
        return nextId++;
    }

    public void createInitData(){
        TestResultModel testResultModel = new TestResultModel(null, "test", "Test executed successfully. All assertions passed.", null, Status.PASS, Duration.ofMinutes(1), Instant.now(), "run-1042");
        TestResultModel testResultModel1 = new TestResultModel(null, "test1", "Running test... assertion failed at line 42. See error message for details.", "error message", Status.FAIL, Duration.ofMinutes(1), Instant.now(), "run-1043");
        TestResultModel testResultModel2 = new TestResultModel(null, "test2", "Running test... assertion failed at line 42. See error message for details.", "error message", Status.FAIL, Duration.ofMinutes(1), Instant.now(), "run-1044");
        TestResultModel testResultModel3 = new TestResultModel(null, "test3", "Running test... assertion failed at line 42. See error message for details.", "error message", Status.FAIL, Duration.ofMinutes(1), Instant.now(), "run-1045");

        addTestResult(testResultModel);
        addTestResult(testResultModel1);
        addTestResult(testResultModel2);
        addTestResult(testResultModel3);

    }

    public TestResultModel addTestResult(TestResultModel testResultModel) {
        Long id = generateNextId();
        TestResultModel newTestResult = new TestResultModel(id, testResultModel.testName(), testResultModel.testLogData(), testResultModel.errorMessage(), testResultModel.status(), testResultModel.duration(), testResultModel.timestamp(), testResultModel.buildId());
        testResults.put(id, newTestResult);
        return newTestResult;
    }

    public TestResultModel getTestResultsById(Long id) {
        return testResults.get(id);
    }

    public Map<Long, TestResultModel> getAllTestResults() {
        return testResults;
    }

}
