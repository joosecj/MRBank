INSERT INTO tb_client (name, email, cpf, birth_date, phone) values ('Antonio', 'antonio@gmail.com', '32489004568', TIMESTAMP WITHOUT TIME ZONE '1990-03-17', 31969277138);
INSERT INTO tb_client (name, email, cpf, birth_date, phone) values ('Marcos', 'tt@gmail.com', '62489004568', TIMESTAMP WITHOUT TIME ZONE '1990-03-17', 41969277138);
INSERT INTO tb_client (name, email, cpf, birth_date, phone) values ('Dos Santos', 'aaa@gmail.com', '54489004568', TIMESTAMP WITHOUT TIME ZONE '1990-03-17', 22969277138);


INSERT INTO tb_account (agency, number_cc, balance, clients_id) values ('0001', '25689', '100.0', '1');
INSERT INTO tb_account (agency, number_cc, balance, clients_id) values ('0001', '25787', '400.0', '1');
INSERT INTO tb_account (agency, number_cc, balance, clients_id) values ('0001', '25755', '400.0', '2');
INSERT INTO tb_account (agency, number_cc, balance, clients_id) values ('0001', '25423', '1000.0', '3');

INSERT INTO tb_movement (date, value_movement, description, movement_type, account_id) values ( TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', '100.0', 'deposito', 'REVENUE', '1');
INSERT INTO tb_movement (date, value_movement, description, movement_type, account_id) values ( TIMESTAMP WITH TIME ZONE '2022-07-25T13:00:00Z', '150.0', 'deposito', 'REVENUE', '1');

