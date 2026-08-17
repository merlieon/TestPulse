# TestPulse

A REST API for visibility into CI/CD test results.

## The problem

Most development teams run CI/CD pipelines that generate large amounts of
test execution data — but it often disappears into logs nobody reads.
There's rarely an easy way to answer:

- Which tests are flaky (toggling between pass/fail with no code change)?
- Which test suites take the longest to run?
- Is test health trending up or down over time?
- Which modules have the most failures?

TestPulse ingests test results from a CI pipeline, stores the history,
and exposes an API to answer those questions.

## Status

🚧 Work in progress — built as a learning project in Java/Spring Boot.

## Planned functionality

- Ingest test results (test name, status, duration, timestamp, build id)
  via a POST endpoint
- Store history
- Latest run summary
- Flaky-test detection
- Per-module trend over time

## Tech stack

- Java / Spring Boot
- Maven
- JUnit 5 / Mockito