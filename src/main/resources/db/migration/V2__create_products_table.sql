CREATE TABLE PRODUCTS (
  product_id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  price FLOAT NOT NULL,
  rating FLOAT
);


insert into PRODUCTS (product_id, name, description, price, rating) values ("1", "apple", "red apple", 1.1, 5);