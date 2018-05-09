/*
    Database initialization script that runs on every web-application redeployment.
*/
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS shops;
DROP TABLE IF EXISTS plazas;
DROP TABLE IF EXISTS users;

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    email TEXT UNIQUE NOT NULL,
    password TEXT NOT NULL,
	CONSTRAINT email_not_empty CHECK (email <> ''),
	CONSTRAINT password_not_empty CHECK (password <> '')
);

CREATE TABLE plazas (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    CONSTRAINT name_not_empty CHECK (name <> '')
);

CREATE TABLE shops (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    owner_name TEXT NOT NULL,
    plaza_id int NOT NULL,
	CONSTRAINT name_not_empty CHECK (name <> ''),
	CONSTRAINT owner_name_not_empty CHECK (owner_name <> ''),
	CONSTRAINT plaza_id_not_empty CHECK (plaza_id <> null),
	FOREIGN KEY (plaza_id) REFERENCES plazas(id)
);

CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    manufacturer TEXT NOT NULL,
    barcode bigint NOT NULL,
    price FLOAT NOT NULL,
	shop_id int NOT NULL,
    CONSTRAINT barcode_not_empty CHECK (barcode <> null),
    CONSTRAINT price_not_empty CHECK (price <> null),
    CONSTRAINT name_not_empty CHECK (name <> ''),
    CONSTRAINT manufacturer_not_empty CHECK (manufacturer <> ''),
	CONSTRAINT shop_id_not_empty CHECK (shop_id <> null),
	FOREIGN KEY (shop_id) REFERENCES shops(id)
);

INSERT INTO users (email, password) VALUES
	('user1@user1', 'user1'), -- 1
	('user2@user2', 'user2'), -- 2
	('user2@user3', 'user3'); -- 3

INSERT INTO plazas (name) VALUES
	('Westend'),
	('Arena');

INSERT INTO shops (name, owner_name, plaza_id) VALUES
	('SPAR', 'Mr Spar', 1),   -- 1
	('Tesco', 'Mr Tesco', 1),  -- 2
	('Auchan', 'Mr Auchan', 2); -- 3

INSERT INTO products (name, manufacturer, barcode, price, shop_id) VALUES
	('Bread', 'Bakery', 12345, 10, 1),
	('Beer', 'Beer factory', 54321, 20, 2),
	('Ice-cream','Ice-cream factory', 12332, 40, 2),
	('Chocolate', 'Chocolate factory', 55667, 20, 3),
	('Chips', 'Chips factory', 66778, 15, 1);