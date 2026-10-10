# Employee Management System

A RESTful backend application built using **Java, Spring Boot, and MongoDB** to manage employee records through CRUD operations. The application is deployed on Render and uses MongoDB Atlas for cloud database storage.

## 🚀 Live Demo

- **Base URL:** https://employee-management-yyvi.onrender.com
- **Get All Employees:** https://employee-management-yyvi.onrender.com/employees

> Note: The free hosting instance may take some time to respond after a period of inactivity.

## 🛠️ Tech Stack

- **Language:** Java 21
- **Framework:** Spring Boot 4.1.1
- **Database:** MongoDB Atlas
- **Data Access:** Spring Data MongoDB
- **Build Tool:** Maven
- **Validation:** Jakarta Bean Validation
- **Deployment:** Render
- **Version Control:** Git and GitHub

## ✨ Features

- Create new employee records.
- Retrieve all employees.
- Retrieve an employee by ID.
- Update existing employee details.
- Delete employee records.
- Validate incoming request data.
- Handle exceptions with a global exception handler.
- Connect to MongoDB Atlas using an environment variable.

## 📡 API Endpoints

Base URL: `https://employee-management-yyvi.onrender.com`

| Method | Endpoint | Description |
|---|---|---|
| POST | `/employees` | Create an employee |
| GET | `/employees` | Retrieve all employees |
| GET | `/employees/{id}` | Retrieve an employee by ID |
| PUT | `/employees/{id}` | Update an employee |
| DELETE | `/employees/{id}` | Delete an employee |

### Example: Create an Employee

**Request**

`POST /employees`

```json
{
  "name": "Rahul Sharma",
  "email": "rahul@example.com",
  "department": "IT",
  "salary": 50000
}
```

**Expected response:** `201 Created`

The saved employee response includes its generated ID.

### Example: Retrieve All Employees

`GET /employees`

**Expected response:** `200 OK`

```json
[
  {
    "id": "YOUR_EMPLOYEE_ID",
    "name": "Rahul Sharma",
    "email": "rahul@example.com",
    "department": "IT",
    "salary": 50000
  }
]
```

The example above illustrates the response structure; actual records depend on the database contents.

## 🏗️ Project Architecture

The application follows a layered architecture:

```text
Controller
    ↓
Service Interface
    ↓
Service Implementation
    ↓
Repository
    ↓
MongoDB Atlas
```

### Main Components

- **Controller:** Handles HTTP requests and responses.
- **Service:** Defines the employee management operations.
- **Service Implementation:** Contains business logic and entity/DTO mapping.
- **Repository:** Uses Spring Data MongoDB to interact with the database.
- **Entity:** Represents employee data stored in MongoDB.
- **DTOs:** Separate request and response data from the database entity.
- **Exception Handler:** Handles employee-not-found and validation errors.

## ⚙️ Run Locally

### Prerequisites

- Java 21 or compatible JDK
- Git
- MongoDB Atlas account or a suitable MongoDB instance
- IntelliJ IDEA or another Java IDE

### 1. Clone the Repository

```bash
git clone https://github.com/zaid-works/Employee-Management.git
```

### 2. Configure the Database

Set the MongoDB connection string as an environment variable named `MONGODB_URI`.

Your `src/main/resources/application.properties` should contain:

```properties
spring.application.name=Employee-management
spring.mongodb.uri=${MONGODB_URI}
```

Never commit database passwords or connection strings containing credentials to GitHub.

### 3. Run the Application

On Windows PowerShell, set the environment variable in the terminal before starting the application:

```powershell
$env:MONGODB_URI="YOUR_MONGODB_CONNECTION_STRING"
.\mvnw.cmd spring-boot:run
```

Replace the placeholder with your own connection string. Keep it private.

The application runs on port `8080` by default when no external port is configured.

## ☁️ Deployment

The application is deployed on **Render** using Docker, with MongoDB Atlas as the database.

- The Dockerfile builds the Spring Boot application.
- Render provides the deployment environment and port.
- `MONGODB_URI` is configured as an environment variable in Render.
- The application connects to the cloud database without storing credentials in source code.

## 🔐 Validation and Error Handling

The application includes request validation and centralized exception handling.

| Status | Meaning |
|---|---|
| `200 OK` | Request successful |
| `201 Created` | Employee created |
| `204 No Content` | Delete request completed |
| `400 Bad Request` | Invalid request data |
| `404 Not Found` | Employee not found |

## 🧪 Testing

The deployed API was manually tested using Postman for:

- Creating an employee.
- Retrieving all employees.
- Retrieving an employee by ID.
- Updating employee details.
- Deleting an employee.

## 📚 Learning Outcomes

This project provided practical experience with:

- Building REST APIs using Spring Boot.
- Designing layered backend architecture.
- Using Spring Data MongoDB.
- Implementing DTOs and request validation.
- Handling exceptions globally.
- Managing configuration through environment variables.
- Deploying a Java backend with Docker and Render.
- Testing HTTP endpoints using Postman.

## 👨‍💻 Author

**Mohammad Zaid**

GitHub: [@zaid-works](https://github.com/zaid-works)

---

If you find this project useful, feel free to explore the repository and its implementation.
