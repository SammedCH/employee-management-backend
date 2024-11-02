
---

### **Backend (`employee-management-backend`)**

```markdown
# Employee Management - Backend

This is the backend of the Employee Management system, built with Java Spring Boot. It provides a REST API for CRUD operations on employee records, with a relational database to store employee data.

## Project Structure

- **Controller**: API endpoints for employee operations.
- **Service**: Business logic for employee management.
- **Repository**: JPA repositories for interacting with the database.
- **Model**: Employee and related entities.

## Features

- **Employee CRUD Operations**: Create, read, update, delete (soft delete by inactivation).
- **Active Employee Filtering**: Fetch only active employees.
- **Data Validation**: Ensures required fields and input constraints.
- **Database Constraints**: Uses multiple tables and relationships for structured data storage.

## Prerequisites

- Java 17 or higher
- Maven
- MySQL or other RDBMS

## Database Setup

- Create a new database in your RDBMS (e.g., MySQL).
- Update application.properties with your database details
   spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
   spring.datasource.username=yourUsername
   spring.datasource.password=yourPassword
   spring.jpa.hibernate.ddl-auto=update

 ##   API Endpoints
  The API will run on http://localhost:8080.
    - GET /api/employees - List all employees.
    - GET /api/employees/active - List only active employees.
    - POST /api/employees - Create a new employee.
    - PUT /api/employees/{id} - Update employee details.
    - PUT /api/employees/{id}/inactivate - Set employee's active status to inactive.

## Database Design
- Employee Table: Stores basic employee details with a foreign key relationship to EducationDetails.
- EducationDetails Table: Stores educational background for employees.
- Constraints: Primary keys, foreign keys, and unique constraints applied as needed.

## employee-management-frontend
For employee-management-frontend - https://github.com/SammedCH/employee-management-frontend

## Installation

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/employee-management-backend.git
   cd employee-management-backend
