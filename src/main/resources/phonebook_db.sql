USE phonebook_db;

CREATE TABLE customers (
                           id int NOT NULL AUTO_INCREMENT,
                           name varchar(15),
                           phone varchar(100),
                           PRIMARY KEY (id)
) ;

INSERT INTO phonebook_db.customers (name,  phone)
VALUES
    ('Alex', '+79601232233'),
    ('Billy', '+79213215566 | +79213215567 | +79213215568'),
    ('Jack', '+555'),
    ('Nophone', null);


