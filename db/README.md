# Database for Spring Boot Crud Demo

## Building the Image

```shell
docker image build -t henrygbrown/db-crud-demo:1.0.0 .
```

## Running the container:

```shell
docker container run -d -p 5432:5432 --name db_crud_demo -v ${PWD}/data:/var/lib/postgresql/data henrygbrown/db-crud-demo:1.0.0
```

## Run psql in container

```shell
docker container exec -it db_crud_demo psql -U postgres -d db_crud_demo
```
