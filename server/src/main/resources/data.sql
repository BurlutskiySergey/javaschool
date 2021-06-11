DROP TABLE IF EXISTS cards;
DROP TABLE IF EXISTS accounts;
DROP TABLE IF EXISTS clients;

CREATE TABLE clients (
    id INT AUTO_INCREMENT PRIMARY KEY,
    client_num INT UNIQUE NOT NULL,
    first_name VARCHAR(50) NOT NULL,
    middle_name VARCHAR(50),
    last_name VARCHAR(50) NOT NULL,
    age INT
);

CREATE TABLE accounts (
    id INT AUTO_INCREMENT PRIMARY KEY,
    account_num VARCHAR(20) UNIQUE NOT NULL,
    currency VARCHAR(3) NOT NULL,
    balance int DEFAULT 0,
    client_id INT NOT NULL,
    FOREIGN KEY (client_id) REFERENCES clients(id)
);

CREATE TABLE cards (
    id INT AUTO_INCREMENT PRIMARY KEY,
    card_num VARCHAR(16) UNIQUE NOT NULL,
    pin VARCHAR(4) NOT NULL,
    expired_date DATE NOT NULL,
    account_id INT NOT NULL,
    FOREIGN KEY (account_id) REFERENCES accounts(id)
);

INSERT INTO clients (client_num, first_name, middle_name, last_name, age) VALUES
    (1, 'Иван', 'Иванович', 'Иванов', 20),
    (2, 'Петр', 'Петрович', 'Петров', 65),
    (3, 'Сидор', 'Сидорович', 'Сидоров', 37)
;

INSERT INTO accounts (account_num, currency, balance, client_id) VALUES
    ('40817810055760515501', 'RUR', 10000, SELECT id FROM clients WHERE client_num = 1),
    ('40817810055760515502', 'RUR', 20000, SELECT id FROM clients WHERE client_num = 2),
    ('40817810055760515503', 'USD', 500, SELECT id FROM clients WHERE client_num = 2),
    ('40817810055760515504', 'RUR', 300000, SELECT id FROM clients WHERE client_num = 3),
    ('40817810055760515505', 'USD', 10000, SELECT id FROM clients WHERE client_num = 3),
    ('40817810055760515506', 'EUR', 10000, SELECT id FROM clients WHERE client_num = 3)
;

INSERT INTO cards (card_num, pin, expired_date, account_id) VALUES
    ('4276050037129901', '1111', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515501'),
    ('4276050037129902', '2222', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515502'),
    ('4276050037129903', '3333', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515503'),
    ('4276050037129904', '4444', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515504'),
    ('4276050037129905', '5555', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515505'),
    ('4276050037129906', '6666', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515505'),
    ('4276050037129907', '7777', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515506'),
    ('4276050037129908', '8888', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515506'),
    ('4276050037129909', '9999', '20221011', SELECT id FROM accounts WHERE account_num = '40817810055760515506')
;

