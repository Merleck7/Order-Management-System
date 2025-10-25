# 🧾 Order Management System

**Order Management System** is a Spring Boot application designed to manage customer orders efficiently.
It follows a modular architecture, supports multiple environments (**dev**, **test**, **prod**) using **PostgreSQL**, and includes full CRUD operations for Orders.

This version integrates **Swagger/OpenAPI documentation** as part of **Sprint 3**, allowing interactive exploration and testing of the API.

---

## 🧱 Project Structure

```
order-management/
│
├── .gitignore
├── pom.xml
├── README.md
│
├── src/
│ ├── main/
│ │ ├── java/
│ │ │ └── com/meli/ordermanagement/
│ │ │     ├── OrderManagementApplication.java
│ │ │     ├── controller/
│ │ │     │   └── OrderController.java
│ │ │     ├── model/
│ │ │     │   └── Order.java
│ │ │     ├── repository/
│ │ │     │   └── OrderRepository.java
│ │ │     ├── service/
│ │ │     │   └── OrderService.java
│ │ │     └── config/
│ │ │         └── SwaggerConfig.java
│ │ │
│ │ └── resources/
│ │     ├── 01_schema.sql
│ │     ├── data.sql
│ │     ├── application.yml
│ │     ├── application-dev.yml
│ │     ├── application-test.yml
│ │     ├── application-prod.yml
│ │     ├── application-prod.properties
│ │     └── application.properties
│ │
│ └── test/
│     └── java/
│         └── com/meli/ordermanagement/
│             ├── controller/
│             │    └── OrderControllerIntegrationTest.java
│             └── service/
│                  └── OrderServiceTest.java
│
└── target/ # (Generated build output, ignored by Git)
```

---

## ⚙️ Environment Configuration

This project supports three profiles, each with its own database and logging configuration.

| Profile | File                 | Database   | Hibernate DDL | SQL Logs |
| ------- | -------------------- | ---------- | ------------- | -------- |
| dev     | application-dev.yml  | PostgreSQL | create-drop   | Enabled  |
| test    | application-test.yml | PostgreSQL | update        | Partial  |
| prod    | application-prod.yml | PostgreSQL | update        | Disabled |

---

## 🌍 Environment Variables

| Variable    | Description       | Default             |
| ----------- | ----------------- | ------------------- |
| DB_HOST     | Database host     | localhost           |
| DB_PORT     | Database port     | 5432                |
| DB_NAME     | Database name     | order_management_db |
| DB_USER     | Database username | postgres            |
| DB_PASSWORD | Database password | your_password       |

### Example (PowerShell)

```powershell
$env:DB_USER="postgres"
$env:DB_PASSWORD="your_password"
$env:DB_HOST="localhost"
$env:DB_PORT="5432"
$env:DB_NAME="order_management_db"
```

---

## 🧩 Application Profiles

`application.yml` defines global properties and the active profile:

```yaml
spring:
  application:
    name: order-management
  datasource:
    driver-class-name: org.postgresql.Driver
  jpa:
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
  profiles:
    active: dev
server:
  port: 8080
```

Each environment file overrides these base settings.

---

## 📝 API Documentation (Sprint 3)

**Swagger/OpenAPI** is integrated via `SwaggerConfig.java`. It automatically documents all REST controllers and endpoints, including `OrderController`.

* **Swagger UI URL:** `http://localhost:8080/swagger-ui.html`
* **OpenAPI JSON:** `http://localhost:8080/v3/api-docs`

**Features:**

* Interactive exploration of endpoints.
* Example requests/responses visible.
* Supports all CRUD operations for Orders.

### Example Endpoints via Swagger

| Method | Endpoint           | Description                                                                                                           |
| ------ | ------------------ | --------------------------------------------------------------------------------------------------------------------- |
| POST   | `/api/orders`      | Create a new order. Requires `customerName`, `product`, `quantity`, `price`, `status`. `totalAmount` auto-calculated. |
| GET    | `/api/orders`      | List all orders.                                                                                                      |
| GET    | `/api/orders/{id}` | Get an order by ID.                                                                                                   |
| PUT    | `/api/orders/{id}` | Update an order by ID.                                                                                                |
| DELETE | `/api/orders/{id}` | Delete an order by ID.                                                                                                |

**Example JSON for POST /api/orders:**

```json
{
  "customerName": "Juan Perez",
  "product": "Laptop",
  "quantity": 2,
  "price": 15000.50,
  "status": "Pending"
}
```

---

## 🚀 Running the Application

### Option 1 — Using Maven directly

```bash
mvn spring-boot:run "-Dspring-boot.run.arguments=--spring.profiles.active=dev"
```

---

## ✅ Testing (Sprint 3)

The project includes **unit and integration tests** covering main scenarios, edge cases, and failure cases:

* **Unit Tests:** `OrderServiceTest.java`
* **Integration Tests:** `OrderControllerIntegrationTest.java`

Tests validate:

* Creation of orders.
* Calculation of `totalAmount`.
* Retrieval of all orders.
* Retrieval by ID.

Run tests via Maven:

```bash
mvn test
```

---

## 🧠 Authors and Credits

* Developer: Luis Mendoza
* Evaluator: Digital NAO – Challenge 5
* Version: Sprint 3 – October 2025
