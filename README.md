# Event Validation & Transformation Pipeline

## 1. Overview

A Java-based event processing pipeline that simulates ingestion of 10,000 events and processes them through multiple stages:

* Validation
* Transformation
* Routing
* Analytics

The project demonstrates backend engineering concepts such as custom exceptions, functional programming, Java Streams, event routing, and collection-based analytics.

---

## 2. Architecture Diagram

```text
                +------------------+
                | Event Generator  |
                +------------------+
                         |
                         v
                +------------------+
                | Event Validator  |
                +------------------+
                         |
                         v
                +------------------+
                | Event Transformer|
                +------------------+
                         |
                         v
                +------------------+
                |  Event Router    |
                +------------------+
                         |
                         v
                +------------------+
                | Event Pipeline   |
                +------------------+
                         |
                         v
                +------------------+
                | Event Analytics  |
                +------------------+
```

---

## 3. Features

* Generate 10,000 simulated events
* Validate incoming events
* Custom exception handling
* Functional transformations using Lambdas
* Topic-based event routing
* Event processing pipeline
* Analytics using Java Streams
* Top active user reporting
* Event aggregation by topic and event type

---

## 4. Project Structure

```text
src/
└── project/
    ├── analytics/
    ├── exception/
    ├── generator/
    ├── model/
    ├── pipeline/
    ├── route/
    ├── transform/
    ├── validate/
    └── Main.java
```

---

## 5. How to Run

### Prerequisites

* Java 17+ (or compatible version)
* Lombok

### VS Code Configuration

`.vscode/settings.json`

```json
{
    "java.project.referencedLibraries": [
        "lib/**/*.jar"
    ]
}
```

### Lombok Setup

Download Lombok and place the jar inside the `lib/` directory:

https://projectlombok.org/download

Example:

```text
project-root/
├── lib/
│   └── lombok.jar
├── src/
└── .vscode/
```

### Run

Execute:

```text
project.Main
```

---

## 6. Sample Output

```text
size: 4

{user-topic=2484,
 analytics-topic=2485,
 behavior-topic=2477,
 purchase-topic=2554}

{PUSH_CLICK=2477,
 PURCHASE=2554,
 USER_LOGIN=2484,
 APP_OPEN=2485}

{U745=21,
 U112=20,
 U391=19,
 U84=19,
 ...}
```

---

## 7. Concepts Practiced

### Core Java

* Interfaces
* Enums
* Collections Framework
* Generics

### Exception Handling

* Custom Exceptions
* Validation Layer Design

### Functional Programming

* Functional Interfaces
* Lambda Expressions
* Method References

### Java Streams

* IntStream
* Stream API
* flatMap
* groupingBy
* counting
* sorted
* limit
* Collectors

### Backend Design

* Pipeline Pattern
* Event Routing
* Data Transformation
* Analytics Aggregation
* Separation of Concerns
* Constructor Dependency Injection

```
```
