# 🏥 Hospital Management API

A backend application built using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL to understand real-world enterprise backend architecture, database management, ORM concepts, and REST API development.

This project focuses on learning how modern backend systems interact with relational databases using JPA and Hibernate instead of writing large amounts of raw SQL manually.

The goal of this project is not only to build APIs but also to deeply understand how enterprise backend applications work internally.

---

# 🚀 Technologies Used

| Technology | Purpose |
|---|---|
| Java | Core backend programming language |
| Spring Boot | Backend application framework |
| Spring Data JPA | Database abstraction layer |
| Hibernate ORM | JPA implementation for ORM |
| PostgreSQL | Relational database |
| Maven | Dependency and build management |

---

# 📚 Concepts & Topics Learned

- Spring Boot Layered Architecture
- REST API Development
- JPA & Hibernate
- CRUD Operations
- Repository Pattern
- Custom JPQL Queries
- Transactions
- Pagination & Sorting
- Database Constraints
- Hibernate SQL Generation
- Entity Relationships
  - OneToMany
  - ManyToOne
  - ManyToMany

---

# 🏗️ Architecture Flow

```text
Client
   ↓
Controller Layer
   ↓
Service Layer
   ↓
Repository Layer
   ↓
Hibernate / JPA
   ↓
PostgreSQL Database
```

---

# 📖 Request Processing Flow

```text
Client Request
      ↓
Controller receives request
      ↓
Service processes business logic
      ↓
Repository interacts with database
      ↓
Hibernate generates SQL
      ↓
PostgreSQL executes query
      ↓
Response returned to client
```

---

# 🔥 Features Implemented

- Patient Management APIs
- CRUD Operations
- Custom Query Handling
- Transaction Management
- Pagination Support
- Sorting Support
- Entity Relationship Mapping
- Unique Constraint Handling
- Dynamic Database Operations

---

# 🏥 Real World Problem Solved

This project simulates a Hospital Management System backend where:

- Patient records are stored securely
- Duplicate patient emails are prevented
- Patient information can be updated dynamically
- Database queries can filter records efficiently
- Large datasets can be paginated efficiently
- Transactions ensure database consistency
- Entity relationships maintain relational data properly

---

# 📌 Real World Use Cases

- Find patients by blood group
- Update patient details
- Prevent duplicate patient registration
- Manage patient records securely
- Paginate large patient datasets
- Filter and search records dynamically

---

# 📂 Project Structure

```text
hospital-management/
│
├── docs/
│   ├── JPA_RELATIONSHIPS.md
│   ├── JPA_QUERIES.md
│   ├── PAGINATION_AND_SORTING.md
│   ├── TRANSACTIONS.md
│   └── HIBERNATE.md
│
├── src/
├── pom.xml
└── README.md
```

---

# 📚 Documentation

Detailed technical documentation and learning notes are available inside the `docs/` folder.

| File | Description |
|---|---|
| JPA_RELATIONSHIPS.md | Entity relationship mapping and database relationships |
| JPA_QUERIES.md | Custom JPQL queries and query handling |
| PAGINATION_AND_SORTING.md | Pagination and sorting implementation |
| TRANSACTIONS.md | Transaction management and consistency |
| HIBERNATE.md | Hibernate internals and ORM behavior |

---

# ⚙️ Setup & Run

## Clone Repository

```bash
git clone https://github.com/codeofkaif/hospital-Management.git
```

---

## Navigate to Project

```bash
cd hospital-Management
```

---

## Run Application

```bash
./mvnw spring-boot:run
```

---

# 🔥 Example JPA Query

```java
@Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
List<Patient> findByBloodGroup(
        @Param("bloodGroup") BloodGroupType bloodGroup);
```

---

# 🔥 Example Relationship Mapping

```java
@OneToMany(mappedBy = "hospital")
private List<Patient> patients;
```

---

# 🎯 Future Learning Goals

- DTO Mapping
- Advanced JPQL
- Native SQL Queries
- Spring Security
- JWT Authentication
- Exception Handling
- Validation API
- Caching
- Docker Integration
- Swagger Documentation
- Microservices Architecture
- Performance Optimization

---

# 💡 Key Learnings

- Enterprise backend architecture
- ORM concepts using Hibernate
- Repository abstraction
- Database transaction management
- SQL generation using Hibernate
- Entity relationship mapping
- Constraint handling
- Pagination & sorting
- Layered backend design
- Query execution flow
- Relational database handling

---

# 🚧 Project Status

Currently under active development and continuous learning.

New backend concepts and enterprise-level features will continue to be added as learning progresses.

---

# 💡 Project Goal

The main goal of this project is to deeply understand how enterprise-level backend applications work internally using Spring Boot, JPA, Hibernate, and PostgreSQL.

This project is focused not only on building APIs but also on understanding:

- ORM internals
- Database interaction flow
- Entity relationships
- Transactions
- Query execution
- Scalable backend architecture
- Real-world backend development practices