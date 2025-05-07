# ChatTogether - Backend

This is the backend service for **ChatTogether**, a real-time chat application built using Spring Boot. It provides RESTful APIs for authentication, user management, and messaging, along with WebSocket support for live chat.

## Features

- User Signup & Login
- JWT-based Authentication
- WebSocket for Real-Time Messaging
- MongoDB for storing chat messages
- PostgreSQL for storing user data
- Consistent API responses with metadata (status, code, etc.)

## Tech Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Data JPA (PostgreSQL)
- Spring Data MongoDB
- Spring WebSocket
- Lombok
- Gradle

## Database

- **PostgreSQL**: For storing user details
- **MongoDB**: For storing chat messages

## Dependencies

All dependencies are managed via `build.gradle`, including:

- `spring-boot-starter-web`
- `spring-boot-starter-data-jpa`
- `spring-boot-starter-data-mongodb`
- `spring-boot-starter-websocket`
- `spring-boot-starter-validation`
- `lombok`

## Running Locally

1. **Clone the repository**
   ```bash
   git clone https://github.com/your-username/chat-together-backend.git
   cd chat-together-backend
2. **Set up your PostgreSQL and MongoDB**

  Make sure PostgreSQL and MongoDB are running locally.
  Create a database for the project (e.g., chatdb for Postgres).

3. **Configure application.properties**
  # PostgreSQL
  spring.datasource.url=jdbc:postgresql://localhost:5432/chatdb
  spring.datasource.username=your_username
  spring.datasource.password=your_password

# MongoDB
spring.data.mongodb.uri=mongodb://localhost:27017/chatdb

4. **Run the application**
  ./gradlew bootRun

5. Access API
  Base URL: http://localhost:8080/api
