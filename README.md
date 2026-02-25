Git Commit Method
How to Push Code to GitHub from Eclipse | Git First-Time Setup & Push Explained | code logic - Tamil
https://youtu.be/dWWjRwDkiYY?si=Cd7AdHDAs0Q1aGy4

spring-boot-starter-data-jpa
spring-boot-starter-web
spring-boot-starter-security
spring-boot-devtools
H2 Database
JWT 12.5


<!-- H2 Database -->
spring.datasource.url=jdbc:h2:mem:testdb
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

	<!-- JWT API -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-api</artifactId>
        <version>0.12.5</version>
    </dependency>

    <!-- JWT Implementation -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-impl</artifactId>
        <version>0.12.5</version>
        <scope>runtime</scope>
    </dependency>

    <!-- JSON Serializer -->
    <dependency>
        <groupId>io.jsonwebtoken</groupId>
        <artifactId>jjwt-jackson</artifactId>
        <version>0.12.5</version>
        <scope>runtime</scope>
    </dependency>
