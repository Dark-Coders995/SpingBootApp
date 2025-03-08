# Training Center Registry - Spring Boot Application

This is a Spring Boot application for managing government-funded training centers. It provides two APIs:
1. **POST `/api/training-centers/add`**: Create and save a new training center.
2. **GET `/api/training-centers`**: Retrieve a list of all training centers.

---

## Table of Contents
1. [Prerequisites](#prerequisites)
2. [Setup Instructions](#setup-instructions)
3. [Running the Application](#running-the-application)
4. [Testing the APIs](#testing-the-apis)
5. [Database Configuration](#database-configuration)
6. [Troubleshooting](#troubleshooting)
7. [Project Structure](#project-structure)
8. [Dependencies](#dependencies)

---

## Prerequisites

Before you begin, ensure you have the following installed:
- **Java Development Kit (JDK)**: Version 8 or higher.
- **IDE**: IntelliJ IDEA.
- **Postman** or **cURL**: For testing the APIs.

---

## Setup Instructions

### 1. Download and Extract the Project
- Download the project ZIP file.
- Extract the ZIP file to a directory of your choice.

### 2. Import the Project into Your IDE
#### **IntelliJ IDEA**
1. Open IntelliJ IDEA.
2. Click on **File > Open**.
3. Navigate to the extracted project folder and select it.
4. IntelliJ IDEA will automatically detect the project as a Maven project and configure it.

---

## Running the Application

### 1. Build the Project
If Maven is not installed, your IDE will use its embedded Maven to build the project. No additional setup is required.

### 2. Run the Application
#### **IntelliJ IDEA**
1. Open the `DemoApplication` class located in `src/main/java/com/example/demo`.
2. Right-click on the class and select **Run 'DemoApplication'**.

---

## Testing the APIs

### 1. Create a Training Center
- **Note** : In Request its **pinCode** not pincode
- **Endpoint**: `POST http://localhost:8080/api/training-centers/add`
- **Request Body**:
  ```json
  {
    "centerName": "Tech Training Institute",
    "centerCode": "TECH12345678",
    "address": {
      "detailedAddress": "123 Tech Street",
      "city": "Bangalore",
      "state": "Karnataka",
      "pinCode": "560001"
    },
    "studentCapacity": 500,
    "coursesOffered": ["Programming", "Data Science"],
    "contactEmail": "contact@techtraining.com",
    "contactPhone": "+919876543210"
  }
  ```
- **Response**:
  ```json
  {
    "id": 1,
    "centerName": "Tech Training Institute",
    "centerCode": "TECH12345678",
    "address": {
      "detailedAddress": "123 Tech Street",
      "city": "Bangalore",
      "state": "Karnataka",
      "pinCode": "560001"
    },
    "studentCapacity": 500,
    "coursesOffered": ["Programming", "Data Science"],
    "createdOn": 1696942800000,
    "contactEmail": "contact@techtraining.com",
    "contactPhone": "+919876543210"
  }
  ```

### 2. Get All Training Centers
- **Endpoint**: `GET http://localhost:8080/api/training-centers`
- **Response**:
  ```json
  [
    {
      "id": 1,
      "centerName": "Tech Training Institute",
      "centerCode": "TECH12345678",
      "address": {
        "detailedAddress": "123 Tech Street",
        "city": "Bangalore",
        "state": "Karnataka",
        "pinCode": "560001"
      },
      "studentCapacity": 500,
      "coursesOffered": ["Programming", "Data Science"],
      "createdOn": 1696942800000,
      "contactEmail": "contact@techtraining.com",
      "contactPhone": "+919876543210"
    }
  ]
  ```

---

## Database Configuration

The application uses an **H2 in-memory database**. You can access the H2 console at:
```
http://localhost:8080/h2-console
```

- **JDBC URL**: `jdbc:h2:mem:trainingdb`
- **Username**: `sa`
- **Password**: (leave blank)

---

## Troubleshooting

### 1. `404 Not Found` Error
- Ensure the URL is correct (e.g., `POST http://localhost:8080/api/training-centers/add`).
- Verify that the controller is correctly annotated with `@RestController` and `@RequestMapping`.

### 2. `Request method 'POST' is not supported`
- Ensure the `@PostMapping` annotation is used in the controller.
- Verify that the request body is correctly formatted as JSON.

### 3. Validation Errors
- Check the request body for missing or invalid fields.
- Ensure the `Content-Type: application/json` header is included in the request.

---

## Project Structure

```
src
└── main
    ├── java
    │   └── com
    │       └── example
    │           └── demo
    │               ├── DemoApplication.java
    │               ├── controller
    │               │   └── TrainingCenterController.java
    │               ├── service
    │               │   └── TrainingCenterService.java
    │               ├── repository
    │               │   └── TrainingCenterRepository.java
    │               ├── model
    │               │   ├── TrainingCenter.java
    │               │   └── Address.java
    │               └── dto
    │                   ├── TrainingCenterRequest.java
    │                   └── AddressRequest.java
    └── resources
        └── application.properties
```

---

## Dependencies

The project uses the following dependencies:
- **Spring Boot Starter Web**: For building RESTful APIs.
- **Spring Data JPA**: For database interactions.
- **H2 Database**: In-memory database for development.
- **Spring Boot Starter Validation**: For request validation.
