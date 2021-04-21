insert INTO clients (id_client, first_name, last_name, middle_name, inn) VALUES(1L, 'Ivan' ,'Ivanoff', 'Ivanoff', '1234567890');
insert INTO clients (id_client, first_name, last_name, middle_name, inn) VALUES(2L, 'Ivan' ,'Petroff', 'Petroff', '1234567890');
insert INTO clients (id_client, first_name, last_name, middle_name, inn) VALUES(3L, 'Ivan' ,'Sidoroff', 'Sidoroff', '1234567890');
insert INTO transactions (id, amount, card, currency, place, id_client) VALUES(1L, '10.01', '123456****1234', 'UAH', 'A PLACE 1', 1L);
insert INTO transactions (id, amount, card, currency, place, id_client) VALUES(2L, '9876.01', '123456****1234', 'UAH', 'A PLACE 2', 2L);
insert INTO transactions (id, amount, card, currency, place, id_client) VALUES(3L, '12.01', '123456****1234', 'USD', 'A PLACE 3', 3L);