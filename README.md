spring-profiles-example
===

**All GSW Java solution using Spring Boot.**

### Install the Application:
Clone this repository:
```sh
git clone git@github.com:gsw-team/spring-profiles-example.git
```

Run the application:
```sh
mvn spring-boot:run
```

*When not specifying spring profile, the system use* **local** *profile by default.*

Change spring profile:
```sh
mvn spring-boot:run -Dspring.profiles.active=dev
```

### Generate the Package:

Generate package:
```sh
mvn package -Dspring.profiles.active=prod
```

*Available package in folder /target*
