CREATE TABLE site_user (
  id SERIAL PRIMARY KEY ,
  first_name VARCHAR(20),
  second_name VARCHAR(20),
  date_birth DATE,
  phone_number INTEGER
);

CREATE TABLE article (
  id SERIAL PRIMARY KEY ,
  name VARCHAR(40),
  discription VARCHAR(100),
  price NUMERIC,
  value INTEGER
);

CREATE TABLE user_order (
  id SERIAL PRIMARY KEY ,
  order_article VARCHAR(40),
  customer VARCHAR(20),
  order_price NUMERIC,
  order_date DATE
);