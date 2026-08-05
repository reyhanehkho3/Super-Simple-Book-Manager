# Book Manager

A simple Spring Boot web application for managing a personal book collection. Users can add, view, edit, search, and delete books with a clean, responsive interface.

## Features

- **CRUD Operations** - Create, Read, Update, Delete books
- **Search** - Search books by title or author
- **Date Tracking** - Track publication dates
- **Bootstrap UI** - Professional, responsive design
- **PostgreSQL Support** - Production-ready database option

## Project Structure

```
bookmanager/
├── src/
│   ├── main/
│   │   ├── java/com/example/bookmanager/
│   │   │   ├── BookManagerApplication.java      # Main entry point
│   │   │   ├── model/
│   │   │   │   └── Book.java                    # Book entity
│   │   │   ├── repository/
│   │   │   │   └── BookRepository.java          # Database operations
│   │   │   └── controller/
│   │   │       └── BookController.java          # Web request handlers
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── index.html                   # Main page (list + search)
│   │       │   ├── add-book.html                # Add book form
│   │       │   └── edit-book.html               # Edit book form
│   │       └── application.properties           # Configuration
│   └── test/                                    # Unit tests
├── pom.xml                                      # Maven dependencies
└── README.md                                    # This file
```

## Database Schema

### Book Table
```sql
CREATE TABLE book (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    author VARCHAR(255) NOT NULL,
    published_date DATE
);
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven (or use the included Maven wrapper)
- PostgreSQL 

1. **Create database**

```sql
CREATE DATABASE bookdb;
CREATE USER bookuser WITH PASSWORD 'bookpassword';
GRANT ALL PRIVILEGES ON DATABASE bookdb TO bookuser;
```

2. **Update `application.properties`**

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/bookdb
spring.datasource.username=bookuser
spring.datasource.password=bookpassword
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```

3. **Run the application**

```bash
./mvnw spring-boot:run
```

## Key Features Explained

### Search
- Search by title or author (case-insensitive)
- Real-time filtering
- Clear button to reset search

### CRUD Operations
- **Create**: Add new books with title, author, and publication date
- **Read**: View all books in a clean table format
- **Update**: Edit any book's details
- **Delete**: Remove books with confirmation

### Database Options
- **H2**: In-memory, perfect for development and testing
- **PostgreSQL**: Persistent storage for production use
