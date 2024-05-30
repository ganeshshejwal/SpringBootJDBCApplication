<h1>Project Description:</h1>

The project appears to be a simple CRUD (Create, Read, Update, Delete) application for managing employee data. 
<br>It consists of the following components:

**Controller Layer:**
1. Receives HTTP requests from clients and routes them to appropriate methods.
2. Methods are:
     <br>**PostMapping("/api/employees")** - save(): Creates a new employee record.
     <br>**GetMapping("/api/employees/{id}")** - get(): Retrieves data for a specific employee.
     <br>**GetMapping("/api/employees")** - getAll(): Retrieves data for all employees.
     <br>**PutMapping("/api/employees/{id}")** - update(): Updates data for a specific employee.
     <br>**DeleteMapping("/api/employees/{id}")** - delete(): Deletes data for a specific employee.
4. Implements RESTful endpoints for CRUD operations on employee data.
5. Handles request parameters, request bodies, and path variables.

**Service Layer:**
1. Contains business logic for managing employee data.
2. Methods of serive layer are:
     <br>**saveEmployee(Employee employee)**: Saves a new employee record.
     <br>**getEmployee(UUID id)**: Retrieves data for a specific employee.
     <br>**getAllEmployees()**: Retrieves data for all employees.
     <br>**updateEmployee(UUID id, Employee employee)**: Updates data for a specific employee.
     <br>**deleteEmployee(UUID id)**: Deletes data for a specific employee.
4. Implements interactions between the controller and the DAO layer.
5. Performs business operations.

**DAO Layer:**
1. Interacts with the database to perform CRUD operations on employee entities.
2. Methods of dao layer are:
   <br>**saveEmployee(Employee employee)**:
     Inserts a new employee record into the database using a prepared statement and try-with-resources.
     Manages database connection, prepared statement creation, and exception handling with try-with-resources.
     Ensures proper cleanup of resources with try-with-resources to maintain application integrity.
   <br>**getEmployee(UUID id)**:
     Retrieves data for a specific employee from the database using a prepared statement and try-with-resources.
     Manages database connection, prepared statement creation, result set retrieval, and exception handling with try-with-resources.
     Ensures proper resource management with try-with-resources to avoid resource leaks.
   <br>**getAllEmployees()**:
      Retrieves data for all employees from the database using a prepared statement and try-with-resources.
      Manages database connection, prepared statement creation, result set retrieval, and exception handling with try-with-resources.
      Ensures efficient resource management with try-with-resources to maintain application performance.
   <br>**updateEmployee(UUID id, Employee employee)**:
      Updates data for a specific employee in the database using a prepared statement and try-with-resources.
      Manages database connection, prepared statement creation, and exception handling with try-with-resources.
      Ensures seamless resource management with try-with-resources to prevent database inconsistencies.
   <br>**deleteEmployee(UUID id)**:
      Deletes data for a specific employee from the database using a prepared statement and try-with-resources.
      Manages database connection, prepared statement creation, and exception handling with try-with-resources.
      Ensures reliable resource management with try-with-resources to maintain data integrity.

**Model Layer:**
1. Defines the structure and attributes of an employee entity using Java classes.
2. Utilizes Lombok annotations like @Getter, @Setter, @AllArgsConstructor, and @NoArgsConstructor to automatically generate getter and setter methods, constructors, and other boilerplate code.
3. Employs a UUID field for the employee id, ensuring uniqueness and security in identifying each employee.
4. Represents the data entities that are persisted in the database, such as id, name, salary, and joindate.

**DatabaseConnection Class:**
1. Configures database connectivity for the application.
2. Reads database connection properties such as URL, username, password, and driver class name from the application.properties file.
3. Creates and returns a configured DataSource bean using the Spring @Bean annotation.
4. Enables other components of the application to access the configured data source for database interaction.

Utilizes a logger, such as SLF4J, to record important events, debug information, and errors occurring within the controller.
<br>Integrates Swagger, a powerful tool for documenting and testing RESTful APIs, to generate API documentation and provide an interactive API explorer for developers.


<h1>Build Steps</h1>
1. Make sure you have Java Development Kit (JDK) version 21 installed on your machine.<br>
2. Open the project in your preferred Integrated Development Environment (IDE) or navigate to the project directory using a terminal or command prompt.<br>
3. Ensure that you have the <b>build.gradle</b> file in the project root directory. This file should contain the project configuration and dependencies.<br>
4. Build the project using Gradle by running the following command in the project directory:
   <br>Copy code
   <b>./gradlew build</b>
<br>This command will compile the source code, run unit tests, and package the application into a JAR file.

<h1>Execution Steps</h1>
1. After successfully building the project, navigate to the build/libs directory, where the JAR file is generated.<br>
2. Run the following command to start the Spring Boot application:
   <br>Copy code:
   <b>java -jar employeeProject-0.0.1.jar</b>
3. Alternatively, you can run the application from your IDE by locating the main class <b>(com.webapplication.employeeProject.EmployeeProjectApplication)</b> and running it as a Java application.<br>
4. Once the application is running, you can access the API endpoints using a tool like Postman or cURL. The available endpoints are:
   <br><b>POST /api/employees: Save a new employee</b>
   <br><b>GET /api/employees/{id}: Get an employee by ID</b>
   <br><b>GET /api/employees: Get all employees</b>
   <br><b>PUT /api/employees/{id}: Update an employee by ID</b>
   <br><b>DELETE /api/employees/{id}: Delete an employee by ID</b><br>
5. Make sure to configure the database connection properties in the <b>application.properties</b> file or provide them as environment variables. 
   <br>The required properties are:
   <br><b>spring.datasource.url</b>
   <br><b>spring.datasource.username</b>
   <br><b>spring.datasource.password</b>
   <br><b>spring.datasource.driver-class-name</b>
   <br>The application will automatically create the required database table (employee) if it doesn't exist.
