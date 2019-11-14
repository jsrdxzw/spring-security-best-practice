# spring-security-practice

the practice for security that develop rest api

## Getting Started

#### IntelliJ setting
- go to 'Preferences' -> 'Plugin', install **Lombok Plugin**
- go to 'Preferences' -> 'Build, Exucuting, Deployment' -> 'Compile' -> 'Annotation Processors', select **Enable annotation processing**

#### Env setting using docker-compose

`docker-compose up`
p.s. `docker-compose up -d` would be executed in background

#### Env setting manually

Install MySQL & Redis, configuration refer to `docker-compose.yml`

## Build & Test

`./gradlew build`

## Run

`./gradlew run`

For more info, see Swagger API: <http://localhost:8080/COS/swagger-ui.html>

## Using Mybatis Generator

`./gradlew gen`

For more info, see <http://www.mybatis.org/generator/>

## DB migration

spring-security-practice use <https://flywaydb.org/> to migrate database.

### Migrations files

File directory:

[migration](base/src/main/resources/db/migration/)

File naming rules:

`V{versionNumber}__{description}_{DDL/DML}.sql`

- DDL is Data Definition Language : used to define data structures.
- DML is Data Manipulation Language : used to manipulate data itself.

For more advanced naming rules, refer to [documentation](https://flywaydb.org/documentation/migrations) .

*Important:* 
We should keep it as a good practice that a commit/pr is either a database update or a code change.
We first commit database, so the tests in the Continuous Delivery pipeline check if new database works correctly with service.
