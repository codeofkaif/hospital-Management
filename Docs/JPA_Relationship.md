# JPA Entity Relationships

Entity relationships are one of the most important concepts in Spring Data JPA and Hibernate. In real-world backend applications, data is connected across multiple tables, and relationships help represent these connections using Java objects.

This documentation explains how entity relationships work internally in JPA and Hibernate along with real-world examples, database mapping, annotations, and important concepts.

---

# 📚 Relationship Types Covered

- OneToMany
- ManyToOne
- ManyToMany

---

# 🏥 Real World Understanding

| Real World Example | Relationship |
|---|---|
| One Hospital → Many Patients | OneToMany |
| Many Patients → One Hospital | ManyToOne |
| Many Students ↔ Many Courses | ManyToMany |

---

# 1. OneToMany Relationship

A OneToMany relationship means:

> One entity can contain multiple records of another entity.

---

# 🏥 Real World Example

```text
One Hospital → Many Patients
One Department → Many Doctors
One Teacher → Many Students
```

---

# 📂 Database Understanding

## Hospital Table

| id | name |
|---|---|
| 1 | City Hospital |

---

## Patient Table

| id | name | hospital_id |
|---|---|---|
| 1 | Kaif | 1 |
| 2 | Ali | 1 |

Here:

```text
One Hospital → Multiple Patients
```

---

# 🔥 JPA Mapping Example

## Parent Entity

```java
@Entity
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hospital")
    private List<Patient> patients;
}
```

---

## Child Entity

```java
@Entity
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private Hospital hospital;
}
```

---

# 📌 Important Concepts Learned

| Annotation | Purpose |
|---|---|
| `@OneToMany` | One parent contains many child records |
| `mappedBy` | Defines owner side |
| `@JoinColumn` | Foreign key mapping |
| `List<>` | Collection handling |

---

# ⚙️ Internal Database Flow

```text
Hospital Object
      ↓
Hibernate ORM
      ↓
Foreign Key Creation
      ↓
hospital_id inside patient table
```

---

# 2. ManyToOne Relationship

ManyToOne is the reverse side of OneToMany.

It means:

> Many entities belong to one parent entity.

---

# 🏥 Real World Example

```text
Many Employees → One Company
Many Patients → One Hospital
Many Orders → One Customer
```

---

# 🔥 Example

```java
@ManyToOne
@JoinColumn(name = "hospital_id")
private Hospital hospital;
```

---

# 📌 Concepts Learned

- Foreign Keys
- Parent-Child Relationship
- Bidirectional Mapping
- Object Navigation

---

# 🔗 Understanding Foreign Key

```text
patient table
```

contains:

```text
hospital_id
```

which references:

```text
hospital.id
```

This creates relational database connectivity.

---

# 3. ManyToMany Relationship

ManyToMany means:

> Multiple records from one table can connect with multiple records from another table.

---

# 🏫 Real World Example

```text
Many Students ↔ Many Courses
Many Users ↔ Many Roles
Many Doctors ↔ Many Patients
```

---

# 📂 Database Understanding

A third table (junction table) is created automatically.

---

# Example Tables

## Student Table

| id | name |
|---|---|
| 1 | Kaif |

---

## Course Table

| id | course |
|---|---|
| 1 | Java |

---

## Junction Table

| student_id | course_id |
|---|---|
| 1 | 1 |

---

# 🔥 JPA Mapping Example

## Student Entity

```java
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(
        name = "student_course",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "course_id")
    )
    private List<Course> courses;
}
```

---

## Course Entity

```java
@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    @ManyToMany(mappedBy = "courses")
    private List<Student> students;
}
```

---

# 📌 Concepts Learned

| Concept | Explanation |
|---|---|
| Junction Table | Extra table connecting both entities |
| `@JoinTable` | Defines mapping table |
| `joinColumns` | Current entity foreign key |
| `inverseJoinColumns` | Other entity foreign key |
| Bidirectional Mapping | Both entities know each other |

---

# 🔥 Cascade Types

Cascade allows operations on parent entities to affect child entities automatically.

---

# Common Cascade Types

| Cascade Type | Meaning |
|---|---|
| ALL | Applies all operations |
| PERSIST | Saves child automatically |
| REMOVE | Deletes child automatically |
| MERGE | Updates child automatically |

---

# Example

```java
@OneToMany(cascade = CascadeType.ALL)
private List<Patient> patients;
```

---

# ⚡ Fetch Types

Fetch type defines when related data should load.

---

# Types

| Fetch Type | Meaning |
|---|---|
| EAGER | Loads immediately |
| LAZY | Loads only when needed |

---

# Example

```java
@OneToMany(fetch = FetchType.LAZY)
private List<Patient> patients;
```

---

# ⚙️ LAZY vs EAGER Understanding

## EAGER

```text
Hospital loaded
      ↓
Patients automatically loaded
```

---

## LAZY

```text
Hospital loaded
      ↓
Patients loaded only when accessed
```

---

# 🔄 Bidirectional vs Unidirectional Mapping

---

# Unidirectional

Only one entity knows the relationship.

```text
Patient → Hospital
```

---

# Bidirectional

Both entities know the relationship.

```text
Hospital ↔ Patient
```

---

# 🏢 Enterprise-Level Importance

Entity relationships are used everywhere in backend systems:

- E-commerce applications
- Hospital systems
- Banking systems
- Social media platforms
- ERP software
- CRM systems
- Learning management systems

---

# 🧩 Problems Solved Using Relationships

- Connecting multiple tables
- Maintaining relational data
- Reducing redundant data
- Improving database normalization
- Efficient querying using joins

---

# ⚠️ Common Issues Learned

- Infinite recursion in JSON response
- LazyInitializationException
- N+1 Query Problem
- Cascade deletion issues
- Circular dependency problems

---

# 📌 Important Annotations Learned

| Annotation | Purpose |
|---|---|
| `@OneToMany` | One parent → many children |
| `@ManyToOne` | Many children → one parent |
| `@ManyToMany` | Many ↔ many relationship |
| `@JoinColumn` | Foreign key column |
| `@JoinTable` | Junction table mapping |
| `mappedBy` | Defines non-owning side |
| `cascade` | Child operation management |
| `fetch` | Data loading strategy |

---

# 🔥 Key Learnings

- Entity relationship mapping
- Foreign key management
- Database normalization concepts
- Parent-child entity handling
- Bidirectional relationships
- Cascade operations
- Lazy & eager fetching
- Junction table handling
- ORM relationship management

---

# 🎯 Future Advanced Topics

- OneToOne Relationship
- Entity Graphs
- DTO Projections
- Advanced Fetch Joins
- Query Optimization
- Hibernate Caching
- Performance Tuning
- Transaction Optimization
- Advanced JPQL with Relationships

---

# 💡 Final Understanding

Entity relationships are the foundation of real-world backend applications because relational databases are built around connected data.

Spring Data JPA and Hibernate simplify these complex database relationships by allowing developers to connect Java objects directly using annotations instead of manually writing complex SQL joins and relationship handling logic.