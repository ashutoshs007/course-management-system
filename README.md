# 📚 Course Management System - Spring Boot Backend

A RESTful backend API for managing courses, enrollments, and course materials.  
Built using **Spring Boot, Spring Data JPA, and MySQL**, this system allows instructors to create courses and upload materials, while students can enroll and access course content.

---

# 🚀 Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA (Hibernate)**
- **MySQL**
- **Maven**
- **Lombok**
- **Swagger OpenAPI (API Documentation)**
- **REST APIs**

---

# 📂 Project Architecture

The project follows a **layered architecture** used in production Spring Boot applications.

controller
│
├── AuthController
├── CourseController
├── EnrollmentController
└── MaterialController

service
│
├── UserService
├── CourseService
├── EnrollmentService
└── CourseMaterialService

service.impl
│
├── UserServiceImpl
├── CourseServiceImpl
├── EnrollmentServiceImpl
└── CourseMaterialServiceImpl

repository
│
├── UserRepository
├── CourseRepository
├── EnrollmentRepository
└── CourseMaterialRepository

entity
│
├── User
├── Course
├── Enrollment
├── CourseMaterial
├── Role
└── EnrollmentStatus

dto
│
├── user
├── course
├── enrollment
└── material

config
│
└── OpenApiConfig

exception
│
└── GlobalExceptionHandler



---

# ✨ Features

## 👤 Authentication

- Register user
- Login user

Supports two roles:

- **INSTRUCTOR**
- **STUDENT**

---

## 📖 Course Management

Instructors can:

- Create a course
- View courses
- View course details
- Delete courses

API Endpoints

POST /api/courses/{instructorId}
GET /api/courses
GET /api/courses/{id}
DELETE /api/courses/{id}


---

## 🎓 Enrollment System

Students can enroll in courses.

API Endpoints

POST /api/enrollments
GET /api/enrollments/student/{studentId}
GET /api/enrollments/course/{courseId}


---

## 📂 Course Materials

Instructors can upload course learning materials.

Supported example: **PDF files**

API Endpoints

POST /api/materials/upload
GET /api/materials/course/{courseId}


---

# 🗄️ Database Design

Main Entities:

| Entity | Description |
|------|-------------|
| User | Stores instructor and student information |
| Course | Course created by instructor |
| Enrollment | Student enrollment in courses |
| CourseMaterial | Course learning resources |

Relationships:

- One **Instructor → Many Courses**
- One **Student → Many Enrollments**
- One **Course → Many Materials**

---

# 📊 API Documentation (Swagger)

Swagger UI automatically documents all APIs.

Open in browser:
http://localhost:8080/swagger-ui.html


You can test all APIs directly from Swagger.

---

# ⚙️ Setup & Run Locally

## 1️⃣ Clone Repository

git clone https://github.com/ashutoshs007/course-management-system.git


---

## 2️⃣ Navigate to Project
cd course-management-system

---

## 3️⃣ Configure Database

Update `application.properties`
spring.datasource.url=jdbc:mysql://localhost:3306/cms_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect


---

## 4️⃣ Run Application

Using Maven:
mvn spring-boot:run

Or run the main class:
CourseManagementSystemApplication.java


---

# 🌐 Server

Default Spring Boot server:
http://localhost:8080


---

# 🧪 Testing APIs

Use:

- Swagger UI
- Postman
- Curl

Example request:

Register user



---

# 📌 Future Improvements

Possible extensions:

- JWT Authentication
- Role based authorization (Spring Security)
- Video course materials
- Pagination and filtering
- Course reviews and ratings
- Frontend integration (React / Angular)

---

# 👨‍💻 Author

**Ashutosh**

GitHub:  
https://github.com/ashutoshs007

---

# ⭐ If you like this project

Give it a ⭐ on GitHub!
