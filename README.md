# Spring Boot: Using Spring Data JPA to perform batch inserts

Download the docker image for the database from: https://hub.docker.com/r/henrygbrown/db-crud-demo/tags

# Run the database in a docker container

```shell
docker container run -d -p 5432:5432 --name db_crud_demo -v ${PWD}/data:/var/lib/postgresql/data henrygbrown/db-crud-demo:1.0.0
```

# Build the jar

```shell
./gradlew assemble
```

# Run the jar

```shell
java -jar build/libs/sb-crud-demo-0.0.1-SNAPSHOT.jar
```

# Change Log

## v 1.0.0

- The original code that would not batch due to the following parameter: `spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults=false`

## v 1.0.1

- Implemented fix as described by [Thorben Janssen](https://thorben-janssen.com/membership/forums/topic/help-with-batch-inserts-using-spring-data-jpa/) in [Persistence Hub](https://thorben-janssen.com/membership/) forum.
- Output for `save`: `909292 nanoseconds spent executing 1 JDBC batches;` - per insert
- Output for `saveAll`: `3772999 nanoseconds spent executing 2 JDBC batches;`
- Output for `persistAll`: `2227333 nanoseconds spent executing 2 JDBC batches;`
- Output for `saveAllBooks`: `2194209 nanoseconds spent executing 2 JDBC batches;`
- So calling `save` on each entity does not batch up but all other methods do.
