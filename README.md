## goTrain-schedule-ms
This API is used to get go train schedule details.

# Getting Started
I have developed this API to run locally, so I have a default application.yaml file
and we don't need to configure the profile.

1. I am using h2 database and loading data to it while at application startup.
2. To check the data please refer below datasource details application.yaml for console
      path : http://localhost:8080/h2.console
  datasource:
   driverClassName: org.h2.Driver
   url: jdbc:h2:mem:testdb
   username: test
   password: password
3. I have added postman collection inside docs' folder.

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.12-SNAPSHOT/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.12-SNAPSHOT/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.12-SNAPSHOT/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.12-SNAPSHOT/reference/htmlsingle/#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

