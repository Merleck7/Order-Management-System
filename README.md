# 🛒 Order Management System – Challenge 5 (Sprint 1)

This project was developed using **Spring Boot 3.0** and **Java 17** as part of **Challenge 5** for the Digital NAO program.  
The goal is to implement a basic **Order Management System** for an online store, connected to a database and properly documented.

---

## 🚀 Technologies Used
- Java 17  
- Spring Boot 3.0  
- Spring Data JPA  
- H2 Database (development environment)  
- PostgreSQL (production environment)  
- Maven  
- Postman (for API testing)

---

## ⚙️ Project Structure
```
order-management/
│
├─ src/main/java/com/meli/ordermanagement/
│ ├─ OrderManagementApplication.java
│ ├─ entity/Order.java
│ ├─ repository/OrderRepository.java
│ ├─ service/OrderService.java
│ └─ controller/OrderController.java
│
├─ src/main/resources/
│ ├─ application.properties
│ └─ application-prod.properties
│
├─ scripts/
│ └─ start.sh
│
├─ README.md
└─ pom.xml
```
---

## 💾 Database Configuration (H2)

File: `src/main/resources/application.properties`

```properties
spring.datasource.url=jdbc:h2:mem:ordersdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.hibernate.ddl-auto=update
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
You can access the console at:
👉 http://localhost:8080/h2-console
```
________________________________________

## 🧩 API Endpoints
| Method     | Endpoint       | Description              |
| ---------- | -------------- | ------------------------ |
| **POST**   | `/orders`      | Create a new order       |
| **GET**    | `/orders`      | Retrieve all orders      |
| **GET**    | `/orders/{id}` | Retrieve an order by ID  |
| **PUT**    | `/orders/{id}` | Update an existing order |
| **DELETE** | `/orders/{id}` | Delete an order by ID    |
________________________________________
## 📦 Example Request (POST /orders)
```json
{
  "customerName": "Luis Mendoza",
  "product": "Gaming Laptop",
  "quantity": 1,
  "price": 2500.00
}
```
## ✅ Expected Response
```json
{
  "id": 1,
  "customerName": "Luis Mendoza",
  "product": "Gaming Laptop",
  "quantity": 1,
  "price": 2500.0,
  "createdAt": "2025-10-16T15:00:00"
}
```
________________________________________
## ▶️ Running the Application
```bash
Option 1 — Using Maven
mvn spring-boot:run
Option 2 — Using the Startup Script
For Linux/macOS:
./scripts/start.sh
For Windows:
scripts\start.bat
```
________________________________________
## 🧪 Testing with Postman
•	Import the file orders_postman_collection.json into Postman.
•	Make sure the application is running at http://localhost:8080.
•	Test all CRUD operations.
________________________________________
## 🌍 Switching to Production Profile
When deploying in production, use PostgreSQL instead of H2.
Make sure to configure your PostgreSQL credentials in application-prod.properties (see below) and run with:
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=prod
```
________________________________________
## 🧠 Authors and Credits
Developer: Luis Mendoza
Evaluator: Digital NAO – Challenge 5
Version: Sprint 1 – October 2025
