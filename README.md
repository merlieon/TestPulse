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

## How to run

**Prerequisites:** a JDK compatible with Spring Boot 4.1.0 (Java 17–26; this
project targets Java 25). No separate Maven install is needed — the project
ships with the Maven Wrapper.

From the project root:

```bash
# macOS/Linux
./mvnw spring-boot:run

# Windows (PowerShell)
.\mvnw.cmd spring-boot:run
```

The application starts on `http://localhost:8080`. Try it with:

```
GET http://localhost:8080/api/tests/results
```

Stop the app with `Ctrl+C` in the terminal it's running in.

### Building a jar

```bash
./mvnw clean package
java -jar target/testpulse-0.0.1-SNAPSHOT.jar
```

## API

Base path: `/api/tests`

| Method | Path | Description |
|---|---|---|
| GET | `/results` | List all stored test results |
| GET | `/results/{id}` | Get a single test result by id (404 if not found) |
| POST | `/results` | Ingest a new test result. Returns 201 Created with a `Location` header pointing to the new resource |

### Test result fields

`testName`, `status` (`PASS`/`FAIL`), `duration`, `timestamp`, `buildId`,
`testLogData`, `errorMessage`. The `id` is always generated server-side —
any `id` sent by the client is ignored.

## Implemented

- REST endpoints for creating, listing, and fetching test results
- In-memory storage with auto-generated ids
- Dependency injection between controller and service layers
- Structured logging (SLF4J) on write operations

## Planned functionality

- Persistent storage (database, replacing the in-memory store)
- Latest run summary
- Flaky-test detection
- Per-module trend over time
- Automated tests (JUnit 5 / Mockito)

## Tech stack

- Java / Spring Boot
- Maven
- JUnit 5 / Mockito (planned)
