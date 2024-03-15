DROP TABLE IF EXISTS purchase_item;
DROP TABLE IF EXISTS purchase;
DROP TABLE IF EXISTS customer;
DROP TABLE IF EXISTS product;
DROP TABLE IF EXISTS category;
CREATE TABLE category (
    "id" SERIAL NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    PRIMARY KEY ("id")
);
CREATE TABLE product (
    "id" SERIAL NOT NULL,
    "name" VARCHAR(45) NOT NULL,
    "price" DECIMAL(16, 2) NOT NULL,
    "category_id" INT NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT "fk_product_category" FOREIGN KEY ("category_id") REFERENCES category ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE customer (
    "id" SERIAL NOT NULL,
    "name" VARCHAR(100) NOT NULL,
    PRIMARY KEY ("id")
);
CREATE TABLE purchase (
    "id" SERIAL NOT NULL,
    "total" DECIMAL(16, 2) NOT NULL,
    "paid" BOOLEAN NOT NULL,
    "customer_id" INT NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT "fk_purchase_customer" FOREIGN KEY ("customer_id") REFERENCES customer ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
CREATE TABLE purchase_item (
    "purchase_id" INT NOT NULL,
    "product_id" INT NOT NULL,
    "quantity" INT NOT NULL,
    "total" DECIMAL(16, 2) NOT NULL,
    PRIMARY KEY ("purchase_id", "product_id"),
    CONSTRAINT "fk_purchase_item_product" FOREIGN KEY ("product_id") REFERENCES product ("id") ON DELETE NO ACTION ON UPDATE NO ACTION,
    CONSTRAINT "fk_purchase_item_purchase" FOREIGN KEY ("purchase_id") REFERENCES purchase ("id") ON DELETE NO ACTION ON UPDATE NO ACTION
);
-- CATEGORIES
INSERT INTO category
VALUES (1, 'Fruits and vegetables'),
    (2, 'Bakery'),
    (3, 'Meat and fish'),
    (4, 'Dairy and eggs'),
    (5, 'Drinks'),
    (6, 'Liquors'),
    (7, 'Personal care'),
    (8, 'Pantry');
-- PRODUCTS
INSERT INTO product
VALUES (1, 'Apple', 50.00, 1),
    (2, 'Mango', 25.00, 1),
    (3, 'Cherry', 13.00, 1),
    (4, 'Avocado', 9.00, 1),
    (5, 'Lettuce', 8.00, 1),
    (6, 'Tomato', 43.00, 1),
    (7, 'Pear', 21.00, 1),
    (8, 'Celery', 11.00, 1),
    (9, 'Papaya', 7.00, 1),
    (10, 'Lemon', 42.00, 1),
    (11, 'Brownie', 8.00, 2),
    (12, 'Sliced bread', 12.00, 2),
    (13, 'Cake', 3.00, 2),
    (14, 'Tortilla', 8.00, 2),
    (15, 'Toasts', 4.00, 2),
    (16, 'Pan Cake', 10.00, 2),
    (17, 'Salmon', 5.00, 3),
    (18, 'Top round', 3.00, 3),
    (19, 'Post', 4.00, 3),
    (20, 'Pork rib', 7.00, 3),
    (21, 'Tilapia', 6.00, 3),
    (22, 'Hake', 4.00, 3),
    (23, 'Cow milk', 50.00, 4),
    (24, 'Cheese', 30.00, 4),
    (25, 'Happy hen eggs', 100.00, 4),
    (26, 'Egg white', 20.00, 4),
    (27, 'Coastal whey', 11.00, 4),
    (28, 'Water', 60.00, 5),
    (29, 'Orange juice', 20.00, 5),
    (30, 'Colombian soda', 17.00, 5),
    (31, 'Apple juice', 63.00, 5),
    (32, 'Tea', 45.00, 5),
    (33, 'Beer', 80.00, 6),
    (34, 'Tequila', 76.00, 6),
    (35, 'Rum', 24.00, 6),
    (36, 'Firewater', 48.00, 6),
    (37, 'Wine', 56.00, 6),
    (38, 'Toothpaste', 20.00, 7),
    (39, 'Hand soap', 9.00, 7),
    (40, 'Mouthwash', 10.00, 7),
    (41, 'Shampoo', 20.00, 7),
    (42, 'Deodorant', 8.00, 7),
    (43, 'Rice', 60.00, 8),
    (44, 'Lentils', 56.00, 8),
    (45, 'Flour', 30.00, 8),
    (46, 'Salt', 50.00, 8),
    (47, 'Oil', 13.00, 8),
    (48, 'Cereal', 7.00, 8),
    (49, 'Beans', 27.00, 8),
    (50, 'Coffee', 40.00, 8);
-- CUSTOMERS
INSERT INTO customer
VALUES (1, 'John Doe'),
    (2, 'Gary Smith'),
    (3, 'Nick James');
-- SEQUENCES
SELECT SETVAL('public.category_id_seq', 8, true),
    SETVAL('public.product_id_seq', 50, true),
    SETVAL('public.customer_id_seq', 3, true);