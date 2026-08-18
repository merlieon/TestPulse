package com.merlieon.testpulse.services;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.merlieon.testpulse.models.Status;
import com.merlieon.testpulse.models.TestResultModel;

@Service
public class TestResultService {

    private final List<TestResultModel> testResults = new ArrayList<>();

    public TestResultService() {
        createInitData();
    }


    public void createInitData(){
        TestResultModel testResultModel = new TestResultModel("test", "Test executed successfully. All assertions passed.", null, Status.PASS, Duration.ofMinutes(1), Instant.now(), "run-1042");
        TestResultModel testResultModel1 = new TestResultModel("test1", "Running test... assertion failed at line 42. See error message for details.", "error message", Status.FAIL, Duration.ofMinutes(1), Instant.now(), "run-1043");
        TestResultModel testResultModel2 = new TestResultModel("test2", "Running test... assertion failed at line 42. See error message for details.", "error message", Status.FAIL, Duration.ofMinutes(1), Instant.now(), "run-1044");
        TestResultModel testResultModel3 = new TestResultModel("test3", "Running test... assertion failed at line 42. See error message for details.", "error message", Status.FAIL, Duration.ofMinutes(1), Instant.now(), "run-1045");

        addTestResult(testResultModel);
        addTestResult(testResultModel1);
        addTestResult(testResultModel2);
        addTestResult(testResultModel3);
        
    }

    public TestResultModel addTestResult(TestResultModel testResultModel) {
        testResults.add(testResultModel);
        return testResultModel;
    }

    public List<TestResultModel> getAllTestResults() {
        return testResults;
    }

}
