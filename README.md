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
