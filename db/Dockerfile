FROM postgres:10.16-alpine

LABEL author="Henry Brown"

ENV POSTGRES_USERNAME postgres
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB db_crud_demo

COPY dbscripts/ docker-entrypoint-initdb.d/
