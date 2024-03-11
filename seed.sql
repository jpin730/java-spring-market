DROP TABLE IF EXISTS purchase_product,
purchase,
customer,
product,
category;
CREATE TABLE category (
    "id" SERIAL NOT NULL,
    "description" VARCHAR(45) NOT NULL,
    "state" BOOLEAN NOT NULL,
    PRIMARY KEY ("id")
);
CREATE TABLE product (
    "id" SERIAL NOT NULL,
    "name" VARCHAR(45) NOT NULL,
    "category_id" INT NOT NULL,
    "price" DECIMAL(16, 2) NOT NULL,
    "stock" INT NOT NULL,
    "state" BOOLEAN NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT "fk_product_category" FOREIGN KEY ("category_id") REFERENCES category ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE customer (
    "id" SERIAL NOT NULL,
    "full_name" VARCHAR(100) NOT NULL,
    "email" VARCHAR(70) NOT NULL,
    PRIMARY KEY ("id")
);
CREATE TABLE purchase (
    "id" SERIAL NOT NULL,
    "customer_id" INT NOT NULL,
    "date" TIMESTAMP NOT NULL,
    "state" CHAR(1) NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT "fk_purchase_customer" FOREIGN KEY ("customer_id") REFERENCES customer ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE purchase_product (
    "purchase_id" INT NOT NULL,
    "product_id" INT NOT NULL,
    "quantity" INT NOT NULL,
    "total" DECIMAL(16, 2) NOT NULL,
    "state" BOOLEAN NOT NULL,
    PRIMARY KEY ("purchase_id", "product_id"),
    CONSTRAINT "fk_purchase_product_product" FOREIGN KEY ("product_id") REFERENCES product ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT "fk_purchase_product_purchase" FOREIGN KEY ("purchase_id") REFERENCES purchase ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
-- CATEGORIES
INSERT INTO category
VALUES (1, 'Fruits and vegetables', true),
    (2, 'Bakery', true),
    (3, 'Meat and fish', true),
    (4, 'Dairy and eggs', true),
    (5, 'Drinks', true),
    (6, 'Liquors', true),
    (7, 'Personal care', true),
    (8, 'Pantry', true);
-- PRODUCTS
INSERT INTO product
VALUES (1, 'Guava', 1, 300, 500, true),
    (2, 'Mango', 1, 2100, 250, true),
    (3, 'Apple', 1, 700, 130, true),
    (4, 'Avocado', 1, 2500, 98, true),
    (5, 'Lettuce', 1, 4000, 86, true),
    (6, 'Tomato', 1, 290, 430, true),
    (7, 'Pear', 1, 750, 210, true),
    (8, 'Celery', 1, 150, 115, true),
    (9, 'Papaya', 1, 4500, 73, true),
    (10, 'Lemon', 1, 350, 425, true),
    (11, 'Brownie', 2, 2500, 80, true),
    (12, 'Sliced bread', 2, 4500, 120, true),
    (13, 'Cake', 2, 10000, 35, true),
    (14, 'Tortilla', 2, 6400, 87, true),
    (15, 'Toasts', 2, 4000, 45, true),
    (16, 'Pan Cake', 2, 2000, 105, true),
    (17, 'Salmon', 3, 28000, 55, true),
    (18, 'Top round', 3, 12000, 32, true),
    (19, 'Post', 3, 7800, 40, true),
    (20, 'Pork rib', 3, 8600, 70, true),
    (21, 'Tilapia', 3, 17000, 60, true),
    (22, 'Hake', 3, 23000, 45, true),
    (23, 'Cow milk', 4, 2500, 500, true),
    (24, 'Cheese', 4, 4000, 300, true),
    (25, 'Happy hen eggs', 4, 400, 1000, true),
    (26, 'Egg white', 4, 3200, 200, true),
    (27, 'Coastal whey', 4, 9000, 110, true),
    (28, 'Water', 5, 2000, 600, true),
    (29, 'Orange juice', 5, 7400, 200, true),
    (30, 'Colombian soda', 5, 3100, 175, true),
    (31, 'Apple juice', 5, 8250, 630, true),
    (32, 'Tea', 5, 1900, 450, true),
    (33, 'Beer', 6, 2100, 800, true),
    (34, 'Tequila', 6, 65000, 764, true),
    (35, 'Rum', 6, 55000, 240, true),
    (36, 'Firewater', 6, 40000, 480, true),
    (37, 'Wine', 6, 82000, 560, true),
    (38, 'Toothpaste', 7, 7500, 200, true),
    (39, 'Hand soap', 7, 4900, 90, true),
    (40, 'Mouthwash', 7, 12000, 105, true),
    (41, 'Shampoo', 7, 9300, 200, true),
    (42, 'Deodorant', 7, 6900, 85, true),
    (43, 'Rice', 8, 3500, 600, true),
    (44, 'Lentils', 8, 3000, 560, true),
    (45, 'Flour', 8, 1800, 300, true),
    (46, 'Salt', 8, 1400, 500, true),
    (47, 'Oil', 8, 6500, 135, true),
    (48, 'Cereal', 8, 7000, 75, true),
    (49, 'Beans', 8, 8200, 270, true),
    (50, 'Coffee', 8, 7200, 400, true);
-- CUSTOMERS
INSERT INTO customer
VALUES (1, 'John Doe', 'john@doe.com'),
    (2, 'Gary Smith', 'gary@smith.com'),
    (3, 'Nick James', 'nick@james.com');
-- SEQUENCES
SELECT SETVAL('public.category_id_seq', 8, true),
    SETVAL('public.product_id_seq', 50, true),
    SETVAL('public.customer_id_seq', 3, true);