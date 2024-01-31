# REST API with CRUD implementation built using Spring/Spring Boot

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
