# REST API with CRUD implementation built using Spring/Spring Boot
A REST API for an Employee Directory  

Developed on:
- Java Version: 18.0.2.1
- Spring Boot: 3.2.2
- Package Manager: Maven (https://start.spring.io/)
- Dependencies:
    1. Spring Web: For building web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.
    2. Spring Data JPA: Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.
    3. MySQL Driver: MySQL JDBC driver.
    4. Spring Boot Dev Tools: Provides fast application restarts, LiveReload, and configurations for enhanced development experience.
# How to run -- Installation
- To run this project, you need to have Java installed on your system.
- Spring Boot 3.2.2 requires at least Java 17 or above.

- Once you have installed the right version of Java, you can follow these steps:

1. Clone the repository.
2. Use the SQL script in the repository to set up the employee table in MySQL.
3. In `src/main/resources/application.properties`, connect to your MySQL database by changing these three parameters:
    ```
    spring.datasource.url=jdbc:Insert Link Here
    spring.datasource.username=Insert Username Here
    spring.datasource.password=Insert Password Here
    ```
4. Run `RestcrudApplication.java`.
5. The default port is `8080`.
6. Use a client tool like Postman to make the API calls.
7. Check below for the various API methods.
# NOTE
You can create your own databse table directly on MySQL Workbench(Skip step 2).    
OPTIONAL: Use this in ``application.properties`` to autocreate the table from java code: ``spring.jpa.hibernate.ddl-auto=create``   
**Make sure to change the entity name to your table name, and other subsequent updates(objects and methods related to that entity/class)**
# API Requirements
A REST API for the Employee Directory 

REST clients should be able to:   
- Get a list of employees
- Get a single employee by id
- Add a new employee
- Update an employee
- Delete an employee
  
Main resource / entity: **employees**

**HTTP methods to assign action on resource**  
| HTTP Method | Endpoint | CRUD Action|  
|----------|----------|----------|  
| POST    |/api/employees| Create a new entity    |  
| GET   |/api/employees| Read a list of entities   |  
| GET   |/api/employees/{employeeId}| Read a single entity    |
| PUT    |/api/employees| Update an existing entity    |  
| DELETE    |/api/employees/{employeeId}| Delete an existing entity    |  

For POST and PUT make sure the body sent is in JSON format.
