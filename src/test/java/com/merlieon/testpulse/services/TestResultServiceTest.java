package com.merlieon.testpulse.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.time.Duration;
import java.time.Instant;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.merlieon.testpulse.models.Status;
import com.merlieon.testpulse.models.TestResultModel;

public class TestResultServiceTest {
    
    TestResultService testResultService = new TestResultService();
    TestResultModel testResultModel;

    @BeforeEach
    void beforeTest() {
        testResultModel = new TestResultModel(null, "test", "Test executed successfully. All assertions passed.", null, Status.PASS, Duration.ofMinutes(1), Instant.now(), "run-1042");
    }

    @Test
    void addTestResultTest() {
        TestResultModel testResultModelObject = testResultService.addTestResult(testResultModel);

        assertEquals(testResultModel.testName(), testResultModelObject.testName());
        assertEquals(testResultModel.buildId(), testResultModelObject.buildId());
        assertEquals(testResultModel.testLogData(), testResultModelObject.testLogData());
        assertEquals(testResultModel.status(), testResultModelObject.status());
        assertNotEquals(testResultModel.id(), testResultModelObject.id());
    }

    @Test
    void getTestResultsById() {

        TestResultModel addTestResult = testResultService.addTestResult(testResultModel);
        TestResultModel getTestResult = testResultService.getTestResultsById(addTestResult.id());

        assertEquals(addTestResult, getTestResult);
    }

    @Test
    void getTestResultsByIdEqualsNull() {
        TestResultModel getTestResult = testResultService.getTestResultsById(-1L);
        assertNull(getTestResult);
    }

    @Test
    void getAllTestResults() {
        int getAllTestResultsPreAdd = testResultService.getAllTestResults().size();
        testResultService.addTestResult(testResultModel);
        int getAllTestResultsPostAdd = testResultService.getAllTestResults().size();

        assertEquals(getAllTestResultsPreAdd + 1, getAllTestResultsPostAdd);

    }
}
