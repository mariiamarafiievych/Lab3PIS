INSERT INTO excursions(excursion_name) VALUES ('Los Angeles');
INSERT INTO excursions(excursion_name) VALUES ('New York');
INSERT INTO excursions(excursion_name) VALUES ('San Jose');
INSERT INTO excursions(excursion_name) VALUES ('Vancouver');

INSERT INTO ships(capability, duration, ports, route)
VALUES (150, 1.5, 1000, 'Route1');
INSERT INTO ships(capability, duration, ports, route)
VALUES (200, 2, 1005, 'Route2');
INSERT INTO ships(capability, duration, ports, route)
VALUES (500, 10, 600, 'Route3');
INSERT INTO ships(capability, duration, ports, route)
VALUES (50, 2, 300, 'Route4');


INSERT INTO clients(client_bonus, client_email, client_full_name, client_ticket_class, excursion_id, ship_id)
VALUES ('Bonus1', 'oleg@gmail.com', 'Oleg Oleg','1', 1,1);
INSERT INTO clients(client_bonus, client_email, client_full_name, client_ticket_class, excursion_id, ship_id)
VALUES ('Bonus2', 'bogdan@gmail.com', 'Bogdan Bogdan','1', 2,3);
INSERT INTO clients(client_bonus, client_email, client_full_name, client_ticket_class, excursion_id, ship_id)
VALUES ('Bonus3', 'mariia@gmail.com', 'Maria Maria','VIP', 4,2);
INSERT INTO clients(client_bonus, client_email, client_full_name, client_ticket_class, excursion_id, ship_id)
VALUES ('Bonus4', 'diana@gmail.com', 'Diana Diana','1', 3,3);