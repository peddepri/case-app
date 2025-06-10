# Data Collector Application

## Overview
The Data Collector Application is a Spring Boot project designed for data collection and storage. It provides REST APIs for managing data records, integrates with PostgreSQL (or H2), and includes features for metrics collection, logging, and automated testing. The application is containerized using Docker for easy deployment.

## Architecture
The application follows a layered architecture consisting of the following components:
- **Controller Layer**: Handles incoming HTTP requests and maps them to service methods.
- **Service Layer**: Contains business logic and interacts with the repository layer.
- **Repository Layer**: Manages data access and CRUD operations on the data model.
- **Model Layer**: Defines the data structure used within the application.

## Features
- RESTful APIs for data management
- Metrics collection for monitoring application performance
- Structured logging for better traceability
- Automated tests for ensuring code quality
- Docker deployment for easy setup and scalability

## Getting Started

### Prerequisites
- Java 11 or higher
- Maven
- Docker (optional, for containerization)

### Running the Application
1. Clone the repository:
   ```
   git clone <repository-url>
   cd data-collector-app
   ```

2. Build the application:
   ```
   mvn clean install
   ```

3. Run the application:
   ```
   mvn spring-boot:run
   ```

### Docker Setup
To run the application using Docker, follow these steps:

1. Build the Docker image:
   ```
   docker build -t data-collector-app .
   ```

2. Start the application with Docker Compose:
   ```
   docker-compose up
   ```

### Logging
The application uses Logback for logging. The configuration is defined in `src/main/resources/logback-spring.xml`. Logs are structured for better analysis and can be sent to logging services.

### Metrics
Metrics are collected using Micrometer and can be exposed to Prometheus for monitoring. The configuration is handled in `src/main/java/com/example/datacollector/config/MetricsConfig.java`.

### API Usage
The application provides several REST endpoints for managing data records. You can use tools like Postman to interact with the APIs. Refer to the Postman collection provided in the repository for examples.

## Testing
Automated tests are included in the project to ensure the functionality of the application. You can run the tests using:
```
mvn test
```

## Documentation
For detailed API documentation, refer to the Swagger UI (if integrated) or the Postman collection provided in the repository.

## Contributing
Contributions are welcome! Please submit a pull request or open an issue for any enhancements or bug fixes.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.