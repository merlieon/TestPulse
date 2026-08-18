package com.merlieon.testpulse.models;

import java.time.Duration;
import java.time.Instant;

public record TestResultModel(String testName, String testLogData, String errorMessage, Status status, Duration duration, Instant timestamp, String buildId) {

}

