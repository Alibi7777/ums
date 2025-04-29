
#  University Management System

University Management System — a Spring Boot project for managing students, courses, and enrollments.
It implements basic CRUD operations, authentication with JWT, and role-based access control (ADMIN, TEACHER, STUDENT).


##  How to Run the Project

1. Install PostgreSQL and create a database named `ums`.
2. Make sure your `application.properties` is configured correctly:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/ums
   spring.datasource.username=postgres
   spring.datasource.password=1234
   ```
3. Make sure you have **Maven** and **Java 21** installed.
4. Run the project using your IDE

---

##  Project Structure Overview

```
com.ums.University_Management_System
│
├── config/          # Spring Security configuration
├── controller/      # REST Controllers (Students, Courses, Auth, Enrollment)
├── dto/             # Data Transfer Objects
├── entity/          # JPA Entities (Student, Course, User, Enrollment)
├── exception/       # Custom exceptions
├── factory/         # Factories to create entities from DTOs
├── mapper/          # DTO <-> Entity Mappers
├── repository/      # JPA Repositories
├── security/        # JWT Authentication and Security configuration
├── service/         # Business logic for Students, Courses, Users
└── strategy/        # Sorting strategies for courses
```

---

## 📋 Example API Endpoints

## Method | Endpoint | Description | Roles

POST | /auth/register | Register a new user | Public

POST | /auth/login | Login and get JWT token | Public

POST | /students | Create a new student | ADMIN only

GET | /students/{id} | Get student details by ID | ADMIN, STUDENT, TEACHER

DELETE | /students/{id} | Delete a student | ADMIN only

GET | /courses | List all courses | ADMIN, STUDENT, TEACHER

POST | /courses | Create a new course | ADMIN only

PUT | /courses/{id} | Update course information | ADMIN only

DELETE | /courses/{id} | Delete a course | ADMIN only

POST | /enrollments | Enroll a student in a course | ADMIN, TEACHER

---

## Technologies Used

- Java 21
- Spring Boot 3.4.5
- Spring Security (JWT Authentication)
- Spring Data JPA
- Hibernate
- PostgreSQL
- Flyway (Database Migrations)
- Lombok
- Maven

---

---

##  Contact Information

- Email: **alibiospan604@gmail.com**
- GitHub: https://github.com/Alibi7777/

