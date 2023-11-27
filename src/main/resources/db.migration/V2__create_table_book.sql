CREATE TABLE book(
    id SERIAL primary key,
    name varchar(255) not null,
    price decimal(10,2) not null,
    status varchar(255) not null,
    customer_id SERIAL not null,
    FOREIGN KEY (customer_id) REFERENCES customer(id)
);