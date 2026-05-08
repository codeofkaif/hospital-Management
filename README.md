# Hospital Management API

A backend application built using Spring Boot, Spring Data JPA, Hibernate, and PostgreSQL to understand real-world enterprise backend architecture, database management, ORM concepts, and API development.

This project focuses on learning how modern backend systems interact with relational databases using JPA and Hibernate instead of writing large amounts of raw SQL manually.

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

---

# 1. Spring Boot Layered Architecture

Learned how enterprise-level backend applications are divided into multiple layers to maintain clean architecture, scalability, and separation of concerns.

## Architecture Flow

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

## Layers Explanation

| Layer | Responsibility |
|---|---|
| Controller Layer | Handles HTTP requests and API endpoints |
| Service Layer | Contains business logic and validations |
| Repository Layer | Communicates with database using JPA |
| Entity Layer | Maps Java classes to database tables |

---

## Request Flow Understanding

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

# 2. JPA & Hibernate Concepts

Learned Object Relational Mapping (ORM) and how Hibernate converts Java objects into SQL queries automatically.

Understood how JPA acts as a specification while Hibernate works as its implementation.

---

## Entity Mapping Example

```java
@Entity
@Table(name = "patient")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;
}
```

---

## Concepts Learned

- ORM (Object Relational Mapping)
- Entity Mapping
- Primary Keys
- Auto Increment IDs
- Persistence Context
- Entity Lifecycle
- Hibernate SQL Generation
- EntityManager Basics

---

# 3. CRUD Operations

Implemented complete CRUD operations:

- Create
- Read
- Update
- Delete

---

## Example

```java
patientRepository.save(patient);
```

---

## CRUD Understanding

| Operation | Purpose |
|---|---|
| Create | Insert new data |
| Read | Fetch data |
| Update | Modify existing data |
| Delete | Remove data |

---

# 4. Repository Pattern & JPA Repositories

Learned how Spring Data JPA automatically generates implementations for repository interfaces.

---

## Example

```java
public interface PatientRepository
        extends JpaRepository<Patient, Long> {
}
```

---

## Learned Features

- `save()`
- `findById()`
- `findAll()`
- `deleteById()`
- `existsById()`
- `count()`

---

# 5. Custom JPA Queries

Learned how to create custom JPQL queries using `@Query`.

---

## Example

```java
@Query("SELECT p FROM Patient p WHERE p.bloodGroup = :bloodGroup")
List<Patient> findByBloodGroup(BloodGroupType bloodGroup);
```

---

## Topics Learned

- JPQL (Java Persistence Query Language)
- Named Parameters
- Query Filtering
- Dynamic Query Handling
- Query Annotation

---

# 6. Update & Delete Queries

Learned transaction management and modifying queries.

---

## Annotations Learned

- `@Transactional`
- `@Modifying`

---

## Example

```java
@Transactional
@Modifying
@Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
void updatePatientName(Long id, String name);
```

---

## Important Understanding

Understood why update/delete operations require transactions internally.

Learned about:

- Transaction lifecycle
- Commit & rollback
- Persistence synchronization
- Database consistency

---

# 7. Database Constraints & Validation

Learned how relational databases maintain data integrity using constraints.

---

## Unique Constraint Example

```java
@Column(unique = true)
private String email;
```

---

## Real Database Error Handled

```text
ERROR: duplicate key value violates unique constraint
```

---

## Concepts Learned

- Unique Constraints
- Primary Key Constraints
- Data Integrity
- Duplicate Data Prevention
- Validation Logic

---

# 8. Hibernate SQL Generation

Observed how Hibernate internally converts Java code into SQL queries.

---

## Example Generated SQL

```sql
update patient set name=? where id=?
```

---

## Learned Internals

- SQL generation process
- Prepared statements
- Query optimization basics
- JDBC interaction flow

---

# 9. Understanding ddl-auto

Learned how Hibernate manages database schema creation and updates.

---

## Properties Learned

```properties
spring.jpa.hibernate.ddl-auto=create
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.hibernate.ddl-auto=validate
```

---

## Understanding

| Value | Meaning |
|---|---|
| create | Drops old tables and creates new tables |
| update | Updates schema without deleting data |
| create-drop | Creates tables and drops them on shutdown |
| validate | Validates schema without modifying it |

---

# 10. Pagination & Sorting

Learned how to fetch large datasets efficiently using pagination.

---

## Example

```java
Page<Patient> findAll(Pageable pageable);
```

---

## Concepts Learned

- Pageable Interface
- Page Request
- Sorting Data
- Performance Optimization
- Large Dataset Handling

---

# 🏥 Real World Problem Solved

This project simulates a Hospital Management System backend where:

- Patient records are stored securely
- Duplicate patient emails are prevented
- Patient information can be updated dynamically
- Database queries can filter records efficiently
- Transactions ensure data consistency
- APIs communicate with the database cleanly

---

# 📌 Real World Use Cases

- Find patients by blood group
- Update patient details
- Prevent duplicate patient registration
- Manage patient records securely
- Paginate large patient datasets
- Filter and search records dynamically

---

# 🔥 Key Learnings

- Spring Boot backend architecture
- Layered architecture design
- JPA Repository pattern
- Hibernate ORM internals
- Transaction management
- SQL generation using Hibernate
- Database persistence
- Entity-to-table mapping
- Custom JPQL queries
- Constraint handling
- Pagination & sorting
- Repository abstraction

---

# 🎯 Future Learning Goals

- DTO Mapping
- Entity Relationships
    - OneToMany
    - ManyToOne
    - ManyToMany
- Advanced JPQL
- Native SQL Queries
- Spring Security
- JWT Authentication
- Exception Handling
- Validation API
- Caching
- Docker Integration
- Microservices Architecture
- API Documentation using Swagger

---

# 💡 Project Goal

The main goal of this project is to deeply understand how enterprise-level backend applications work internally using Spring Boot, JPA, Hibernate, and PostgreSQL.

This project is focused not only on building APIs but also on understanding the internal architecture, ORM behavior, database transactions, query execution flow, and real-world backend development practices.
