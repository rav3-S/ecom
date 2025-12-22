# Ecom - E-commerce Backend

A simple e-commerce backend built with Spring Boot, JPA, and H2 in-memory database.

## Features

- Product CRUD operations (Create, Read, Update, Delete)
- Product search by keyword
- RESTful API endpoints
- H2 in-memory database for development
- CORS enabled for frontend integration

## Technologies

- Java 21+
- Spring Boot
- Spring Data JPA
- H2 Database
- Maven

## Getting Started

### Prerequisites

- Java 21 or higher
- Maven

### Running the Application

1. Clone the repository:
    ```bash
   git clone https://github.com/rav3-S/ecom.git cd ecom
   ```
2. Build and run:
    ```bash
    mvn spring-boot:run
    ```
3. Access H2 Console (for development):
    - URL: `http://localhost:8080/h2-console`
    - JDBC URL: `jdbc:h2:mem:ecomdb`

## API Endpoints

| Method | Endpoint                | Description                |
|--------|------------------------|----------------------------|
| GET    | /api/products          | List all products          |
| GET    | /api/products/{id}     | Get product by ID          |
| POST   | /api/product           | Add a new product          |
| PUT    | /api/product/{id}      | Update product by ID       |
| DELETE | /api/product/{id}      | Delete product by ID       |
| GET    | /api/products/search   | Search products by keyword |

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
