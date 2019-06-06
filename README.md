# Microservices with Spring Boot (ECMS)

# Available Auth API's

* POST http://localhost:9090/api/v1/users/register  (Authentication not required)

* POST http://localhost:9090/api/v1/token/generate  (Authentication not required)

* GET http://localhost:9090/api/v1/users/2 (Authentication is required)

# Available Student API's

* POST http://localhost:9090/api/student/profile (Authentication is required)

* PUT http://localhost:9090/api/student/profile/{id} (Authentication is required)

* GET http://localhost:9090/api/student/profile/{id} (Authentication is required)

# NOTE:

* http://localhost:9090 is the zuul proxy which routes the microservices.
* http://localhost:9090 here we have centralized JWT Authentication which applies to all the microservices.
* "/api" is the prefix and "/student" denotes the student microservice.
