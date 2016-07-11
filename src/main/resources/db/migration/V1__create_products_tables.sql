-- CREATE TABLE users (
--   id VARCHAR(255) PRIMARY KEY,
--   name VARCHAR(255) NOT NULL,
--   email VARCHAR(255) NOT NULL,
--   role VARCHAR(255),
--   password varchar(255)
-- );
--
-- insert into users (id, name, email, role, password) values ("002", "admin", "admin@example.com", "BACKGROUND_JOB", "$2a$04$DbgJbGA4dkQSzAvXvJcGBOv5kHuMBzrWfne3x3Cx4JQv4IJcxtBIW");


CREATE TABLE PRODUCTS(
  product_id VARCHAR(255) PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  description VARCHAR(255),
  price FLOAT(2),
  rating FLOAT
);

-- INSERT INTO PRODUCTS (product_id, name, description, price, rating) VALUES ("1", "apple", "red apple", 1.1, 5);
-- INSERT INTO PRODUCTS (product_id, name, description, price, rating) VALUES ("2", "grape", "purple", 2.5, 5);