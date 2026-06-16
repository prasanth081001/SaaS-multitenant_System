**SaaS Multi-Tenant Project Management System**
----------------------------------------------

Project Overview

The SaaS Multi-Tenant Project Management System is a Spring Boot application that enables multiple organizations (tenants) to manage users, projects, notifications, and audit logs within a single platform.

The application provides secure JWT-based authentication and role-based access management.

---

Features

Tenant Management

- Create Tenant
- View All Tenants
- View Tenant By ID
- Update Tenant
- Activate Tenant

User Management

- Create User
- View All Users
- View User By ID
- Update User
- Delete User

Project Management

- Create Project
- View All Projects
- View Project By ID
- Update Project
- Delete Project
- High Risk Project Detection

Notification Management

- Automatic Notifications for High Risk Projects
- View Notifications
- Mark Notification as Read

Audit Logging

- Project Creation Logs
- Project Update Logs
- Project Deletion Logs

Security

- JWT Authentication
- Spring Security
- Password Encryption using BCrypt
---

Technology Stack

Backend

- Java 22
- Spring Boot 3
- Spring Security
- Spring Data JPA
- JWT Authentication

Database

- MySQL 8

Tools

- IntelliJ IDEA
- MySQL Workbench
- Postman
- Maven

---

Database Tables

1. tenants
2. users
3. projects
4. notifications
5. audit_logs

---

API Endpoints

Authentication

POST /api/auth/register

POST /api/auth/login

Tenant

POST /api/tenants

GET /api/tenants

GET /api/tenants/{id}

PUT /api/tenants/{id}

PATCH /api/tenants/{id}/activate

User

POST /api/users

GET /api/users

GET /api/users/{id}

PUT /api/users/{id}

DELETE /api/users/{id}

Project

POST /api/projects

GET /api/projects

GET /api/projects/{id}

PUT /api/projects/{id}

DELETE /api/projects/{id}

GET /api/projects/high-risk

Notifications

GET /api/notifications

PUT /api/notifications/{id}/read

Audit Logs

GET /api/audit-logs

GET /api/audit-logs/{id}

---

Project Workflow

1. Create Tenant
2. Create User
3. Login using JWT Authentication
4. Create Project
5. Detect High Risk Projects
6. Generate Notifications
7. Generate Audit Logs
8. View Dashboard Reports

---

Future Enhancements

- Email Notifications
- Multi-Role Access Control
- Analytics Dashboard
- Project Performance Prediction
- Microservices Architecture
- Docker Deployment
- CI/CD Integration


"SaaS Multi-Tenant Project Management System with Risk Analysis, Notifications and Audit Logging"
