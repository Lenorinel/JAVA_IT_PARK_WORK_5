CREATE table Good (
  id SERIAL PRIMARY KEY,
  type varchar(100) NOT NULL,
  name varchar(500) NOT NULL,
  composition VARCHAR(1000) NOT NULL ,
  description varchar(5000) NOT NULL,
  price decimal(10,2) NOT NULL
);

CREATE TABLE Customer (
  id SERIAL PRIMARY KEY ,
  login VARCHAR(100) NOT NULL UNIQUE ,
  hash_Password VARCHAR(100) NOT NULL,
  first_name VARCHAR(60) NOT NULL ,
  secon_dname VARCHAR(100) NOT NULL ,
  email VARCHAR(50) NOT NULL UNIQUE ,
  birth_date DATE NOT NULL ,
  address VARCHAR(100) NOT NULL,
  phone_number VARCHAR(20)

);

CREATE TABLE Basket (
  id INTEGER NOT NULL,
  productId INTEGER REFERENCES Good(id)
);


CREATE TABLE customerOrder (
  id SERIAL PRIMARY KEY ,
  customerId INTEGER REFERENCES Customer(id) NOT NULL ,
  orderDate DATE NOT NULL,
  productId INTEGER REFERENCES Good(id),
  productName VARCHAR(100),
  orderPrice decimal(10,2) NOT NULL
);