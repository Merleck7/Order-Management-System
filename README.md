# 🧾 Order Management System

**Order Management System** is a Spring Boot application designed to manage customer orders and users efficiently.
It follows a modular architecture and supports multiple environments — **development**, **testing**, and **production** — using **PostgreSQL** as the primary database.
The system includes full CRUD operations for Orders and basic CRUD operations for Users.

---

## 🧱 Project Structure

```
order-management/
│
├── .gitignore
├── pom.xml
├── README.md
││
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
│ │ │     └── service/
│ │ │         └── OrderService.java
│ │ │
│ │ └── resources/
│ │     ├── 01_schema.sql
│ │     ├── 02_data.sql
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
│             └── OrderManagementApplicationTests.java
│
└── target/ # (Generated build output, ignored by Git)
```

---

## ⚙️ Environment Configuration

This project supports **three environment profiles**, each with its own database and logging configuration.

| Profile | File                 | Database   | Hibernate DDL | SQL Logs |
| ------- | -------------------- | ---------- | ------------- | -------- |
| dev     | application-dev.yml  | PostgreSQL | create-drop   | Enabled  |
| test    | application-test.yml | PostgreSQL | update        | Partial  |
| prod    | application-prod.yml | PostgreSQL | update        | Disabled |

---

## 🌍 Environment Variables

These variables must be set before running the application:

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

Each environment file (`application-dev.yml`, `application-test.yml`, `application-prod.yml`) overrides these base settings.

---

## 🚀 API Endpoints (Sprint 2)

### Orders

| Method | Endpoint       | Description                                                                                                                       |
| ------ | -------------- | --------------------------------------------------------------------------------------------------------------------------------- |
| POST   | `/orders`      | Create a new order. Requires `customerName`, `product`, `quantity`, `price`, `status`. `totalAmount` is automatically calculated. |
| GET    | `/orders`      | List all orders.                                                                                                                  |
| GET    | `/orders/{id}` | Get an order by its ID.                                                                                                           |
| DELETE | `/orders/{id}` | Delete an order by its ID.                                                                                                        |

**Example JSON for POST /orders:**

```json
{
  "customerName": "Juan Perez",
  "product": "Laptop",
  "quantity": 2,
  "price": 15000.50,
  "status": "Pending"
}
```

### Users

| Method | Endpoint      | Description                                      |
| ------ | ------------- | ------------------------------------------------ |
| POST   | `/users`      | Create a new user. Requires `username`, `email`. |
| GET    | `/users`      | List all users.                                  |
| GET    | `/users/{id}` | Get a user by ID.                                |
| DELETE | `/users/{id}` | Delete a user by ID.                             |

**Example JSON for POST /users:**

```json
{
  "username": "luis.mendoza",
  "email": "mendozarl@outlook.es"
}
```

**Example DELETE request:**

```http
DELETE /users/1
DELETE /orders/5
```

---

## 🚀 Running the Application

### Option 1 — Using Maven directly

```bash
mvn spring-boot:run "-Dspring-boot.run.arguments=--spring.profiles.active=dev"
```

Available profiles:

* dev
* test
* prod

### Option 2 — Using startup scripts

You can run the predefined `.bat` scripts inside the `scripts/` folder:

#### 🧠 Development

```bash
scripts\start-dev.bat
```

#### 🧪 Testing

```bash
scripts\start-test.bat
```

#### 🚀 Production

```bash
scripts\start-prod.bat
```

Each script automatically activates its respective Spring profile.

---

## 🧠 Authors and Credits

* Developer: Luis Mendoza
* Evaluator: Digital NAO – Challenge 5
* Version: Sprint 2 – October 2025

