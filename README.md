# Todo List Application with REST API

A simple Todo List application with a RESTful API built using Spring Boot and EclipseLink JPA.

## Features

- Create, read, update, and delete todo items
- Mark todos as completed
- Filter todos by completion status
- Search todos by title

## Technologies Used

- Java 17
- Spring Boot 3.4.4
- Spring Data JPA with EclipseLink
- PostgreSQL Database
- Docker Compose for development environment
- JUnit 5 for testing

## API Endpoints

### Get all todos
```
GET /api/todos
```
Optional query parameters:
- `completed` (boolean): Filter by completion status
- `title` (string): Search by title

### Get a specific todo
```
GET /api/todos/{id}
```

### Create a new todo
```
POST /api/todos
```
Request body:
```json
{
  "title": "Task title",
  "description": "Task description"
}
```

### Update a todo
```
PUT /api/todos/{id}
```
Request body:
```json
{
  "title": "Updated title",
  "description": "Updated description",
  "completed": true
}
```

### Delete a todo
```
DELETE /api/todos/{id}
```

## Running the Application

### Prerequisites
- Java 17 or higher
- Docker and Docker Compose

### Steps

1. Clone the repository
2. Start the PostgreSQL database using Docker Compose:
   ```
   docker-compose up -d
   ```
3. Run the Spring Boot application:
   ```
   ./gradlew bootRun
   ```
4. The API will be available at `http://localhost:8080/api/todos`

## Testing

Run the tests using:
```
./gradlew test
```

## Database Configuration

The application is configured to use PostgreSQL. The database configuration can be found in `application.properties`.