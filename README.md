# Ecom - E-commerce Backend

A simple e-commerce backend built with Spring Boot, JPA, PosrgreSQL and Spring Security

## Features

- Product CRUD operations (Create, Read, Update, Delete)
- Product search by keyword
- RESTful API endpoints
- JWT-based authentication for protected endpoints
- Public access to product listing, product details, and search
- PostgreSQL database for persistence
- CORS enabled for frontend integration

## Technologies

- Java 21+
- Spring Boot
- Spring Data JPA
- PostgreSQL
- Maven

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven
- PostgreSQL

### Running the Application

1. Clone the repository:
    ```bash
    git clone https://github.com/rav3-S/ecom.git
    cd ecom
    ```
2. Configure your PostgreSQL database in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5432/ecomdb
    spring.datasource.username=your_db_username
    spring.datasource.password=your_db_password
    spring.jpa.hibernate.ddl-auto=update
    spring.jpa.show-sql=true
    spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
    ```
3. Build and run:
    ```bash
    mvn spring-boot:run
    ```

## API Endpoints

| Method | Endpoint                | Description                | Auth Required |
|--------|------------------------|----------------------------|--------------|
| GET    | /api/products          | List all products          | No           |
| GET    | /api/products/{id}     | Get product by ID          | No           |
| GET    | /api/products/search   | Search products by keyword | No           |
| POST   | /api/product           | Add a new product          | Yes          |
| PUT    | /api/product/{id}      | Update product by ID       | Yes          |
| DELETE | /api/product/{id}      | Delete product by ID       | Yes          |
| POST   | /register              | Register a new user        | No           |
| POST   | /login                 | Login and get JWT token    | No           |

> **Note:** Only GET endpoints for products are public. All other endpoints require authentication via JWT.

## Example Product JSON

```json
{
  "name": "Galaxy S25",
  "price": 60000.00,
  "description": "A high-end phone built with AI features.",
  "category": "Mobile",
  "brand": "Samsung",
  "stockQuantity": 20,
  "releaseDate": "2024-02-14T18:30:00.000Z",
  "available": true
}
```

## Authentication

- Register via `/register`
- Login via `/login` to receive a JWT token
- For protected endpoints, include the token in the `Authorization` header:
    ```
    Authorization: Bearer <your_jwt_token>
    ```
