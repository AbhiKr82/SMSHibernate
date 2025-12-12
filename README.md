# Student Management System with Hibernate

A Java-based Student Management System built with Hibernate ORM and MySQL database. This project demonstrates JPA/Hibernate relationships including OneToOne and ManyToMany mappings for managing students, laptops, and courses.


## ✨ Features

- **Student Management**: Create, Read, Update, and Delete student records
- **Laptop Assignment**: OneToOne relationship between Student and Laptop
- **Course Enrollment**: ManyToMany relationship between Student and Course
- **CRUD Operations**: Full CRUD functionality for all entities
- **Query Support**: Custom HQL queries for data retrieval
- **Transaction Management**: Proper transaction handling with rollback support

## 🛠 Technologies Used

- **Java** (JDK 8 or higher)
- **Hibernate ORM** 7.1.11.Final
- **MySQL** 8.4.0
- **Maven** - Dependency Management
- **Jakarta Persistence API** (JPA)

## 🗃 Database Schema

The project uses three main entities:

### Student

- `id` (Primary Key) - Student ID
- `name` - Student name
- `gender` - Gender
- `branch` - Department/Branch
- `cgpa` - Cumulative GPA
- `email` - Email address
- `phone` - Phone number
- `laptop_id` (Foreign Key) - OneToOne with Laptop
- Relationship with Course via `student_course` join table

### Laptop

- `id` (Primary Key) - Laptop ID
- `brand` - Brand name (Dell, HP, Apple, etc.)
- `model` - Model name
- `ram` - RAM in GB

### Course

- `id` (Primary Key) - Course code (e.g., CS101)
- `title` - Course title
- `duration` - Course duration in months
- `instructor` - Instructor name

##  Project Structure

```
Hibernateproject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── org/
│   │   │       └── example/
│   │   │           ├── App.java                    # Main application entry point
│   │   │           ├── entities/
│   │   │           │   ├── Student.java            # Student entity
│   │   │           │   ├── Laptop.java             # Laptop entity
│   │   │           │   └── Course.java             # Course entity
│   │   │           └── util/
│   │   │               ├── HibernateUtil.java      # SessionFactory configuration
│   │   │               └── StudentService.java     # Service layer with CRUD operations
│   │   └── resources/
│   │       └── hibernate.cfg.xml                   # Hibernate configuration file
│   └── test/
│       └── java/
│           └── org/
│               └── example/
│                   └── AppTest.java                # Unit tests
├── pom.xml                                          # Maven dependencies
└── README.md                                        # Project documentation
```


### 2. Create MySQL Database

```sql
CREATE DATABASE Hibernate;
```

### 3. Configure Database Connection

Edit `src/main/resources/hibernate.cfg.xml` and update the database credentials:

```xml
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/Hibernate</property>
<property name="hibernate.connection.username">your_username</property>
<property name="hibernate.connection.password">your_password</property>
```

## ⚙ Configuration

### Hibernate Configuration (`hibernate.cfg.xml`)

Key properties:

```xml
<property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
<property name="hibernate.show_sql">true</property>
<property name="hibernate.format_sql">true</property>
<property name="hibernate.hbm2ddl.auto">update</property>
```

### Maven Dependencies (`pom.xml`)

```xml
<dependencies>
    <!-- Hibernate Core -->
    <dependency>
        <groupId>org.hibernate.orm</groupId>
        <artifactId>hibernate-core</artifactId>
        <version>7.1.11.Final</version>
    </dependency>

    <!-- MySQL Connector -->
    <dependency>
        <groupId>com.mysql</groupId>
        <artifactId>mysql-connector-j</artifactId>
        <version>8.4.0</version>
    </dependency>
</dependencies>
```

## 💻 Usage

### Example: Adding Students with Laptops and Courses

```java
// Create Service
StudentService service = new StudentService();

// Create Courses
Course c1 = new Course("CS101", "DSA", 6, "S.V Ready");
service.saveCourse(c1);

// Create Laptop
Laptop l1 = new Laptop(101, "HP", "Pavilion", 32);
service.saveLaptop(l1);

// Create Student
Student s1 = new Student("122CS0049", "Abhimanyu Kumar", "Male", "CSE", 7.10,
                         "122CS0049@gmail.com", "6734125890");
s1.setLaptop(l1);
s1.setCourseList(Arrays.asList(c1, c2, c3));
service.saveStudent(s1);
```

## 🔗 Entity Relationships

### OneToOne: Student ↔ Laptop

```java
@OneToOne
private Laptop laptop;
```

Each student can have one laptop.

### ManyToMany: Student ↔ Course

```java
@ManyToMany
private List<Course> courseList;
```

Multiple students can enroll in multiple courses.

## 📚 API Methods

### StudentService Methods

#### Create

- `saveStudent(Student student)` - Save a new student
- `saveLaptop(Laptop laptop)` - Save a new laptop
- `saveCourse(Course course)` - Save a new course

#### Read

- `getAllStudent()` - Get all students
- `getStudentByID(String id)` - Get student by ID
- `getByQuery(String query)` - Execute custom HQL query

#### Update

- `UpdateStudent(String id, Student newStudent)` - Update existing student

#### Delete

- `delete(String id)` - Delete student by ID

### Example Queries

```java
// Get all students
List<Student> students = service.getAllStudent();

// Get student by ID
Student student = service.getStudentByID("122CS0049");

// Custom query - Get students by branch
String query = "FROM Student WHERE branch = 'CSE'";
List<Student> cseStudents = service.getByQuery(query);

// Update student
Student updatedStudent = new Student("122CS0049", "New Name", "Male", "ECE", 8.5,
                                     "newemail@gmail.com", "1234567890");
service.UpdateStudent("122CS0049", updatedStudent);

// Delete student
service.delete("122CS0049");
```

