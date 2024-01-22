CREATE TABLE IF NOT EXISTS users
(
    user_id  SERIAL PRIMARY KEY,
    name     VARCHAR(255)        NOT NULL,
    username VARCHAR(50) UNIQUE  NOT NULL,
    email    VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255)        NOT NULL
);

CREATE TABLE IF NOT EXISTS category
(
    category_id   SERIAL PRIMARY KEY,
    category_name VARCHAR(50) UNIQUE NOT NULL,
    description   VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS product
(
    product_id   SERIAL PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    create_date  DATE,
    category_id  INT,
    brand_id     INT,
    FOREIGN KEY (category_id) REFERENCES category (category_id),
    FOREIGN KEY (brand_id) REFERENCES brand (brand_id)
);

CREATE TABLE IF NOT EXISTS brand
(
    brand_id    SERIAL PRIMARY KEY,
    brand_name  VARCHAR(255) UNIQUE NOT NULL,
    website     VARCHAR(255)        NOT NULL,
    description VARCHAR(255)        NOT NULL
);

CREATE TABLE IF NOT EXISTS shareholder_brand
(
    shareholder_id INT,
    brand_id       INT,
    FOREIGN KEY (shareholder_id) REFERENCES shareholder (shareholder_id),
    FOREIGN KEY (brand_id) REFERENCES brand (brand_id)
);

CREATE TABLE IF NOT EXISTS shareholder
(
    shareholder_id   SERIAL PRIMARY KEY,
    shareholder_name VARCHAR(255) NOT NULL,
    phone_number     VARCHAR(15) UNIQUE,
    national_code    VARCHAR(10) UNIQUE
);
