CREATE table Product (
  id SERIAL PRIMARY KEY,
  name varchar(1000) NOT NULL,
  category VARCHAR(50) REFERENCES ProductCategory(id),
  price decimal(10,2) NOT NULL,
  description varchar(5000) NOT NULL
);

CREATE TABLE Customer (
  id SERIAL PRIMARY KEY ,
  firstname VARCHAR(60) NOT NULL ,
  lastname VARCHAR(100) NOT NULL ,
  email VARCHAR(50) NOT NULL UNIQUE ,
  address VARCHAR(100) NOT NULL,
  login VARCHAR(100) NOT NULL UNIQUE ,
  hashPassword VARCHAR(100) NOT NULL

);

CREATE TABLE Basket (
  id INTEGER NOT NULL,
  productId INTEGER REFERENCES Product(id),
  amount INTEGER
);

CREATE TABLE ProductCategory (
  id SERIAL PRIMARY KEY ,
  name VARCHAR(50)
);

CREATE TABLE Order (
  id SERIAL PRIMARY KEY ,
  customerId INTEGER REFERENCES Customer(id) NOT NULL ,
  orderDate DATE NOT NULL,
  customerAddress VARCHAR(100) NOT NULL ,
  orderPrice decimal(10,2) NOT NULL
);