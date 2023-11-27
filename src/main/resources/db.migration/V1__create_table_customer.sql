CREATE TABLE customer(
    id SERIAL primary key,
    name varchar(255) not null,
    email varchar(255) not null unique
);