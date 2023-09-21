CREATE TABLE member(
member_id serial NOT NULL,
last_name varchar(50) NOT NULL,
first_name varchar(50) NOT NULL,
email_address varchar(50) NULL,
phone_number varchar(50) NULL,
birth_date DATE NOT NULL,
reminder_flag int NULL,
CONSTRAINT PK_member PRIMARY KEY(member_id)
);

CREATE TABLE groups(
group_id serial NOT NULL,
group_name varchar(50) UNIQUE NOT NULL,
member_id int NOT NULL,
CONSTRAINT PK_group Primary KEY(group_id),
CONSTRAINT FK_group_member FOREIGN KEY(member_id) REFERENCES member(member_id)
);

CREATE TABLE event(
event_id serial,
event_name varchar(50) NOT NULL,
description varchar(200) NULL,
start_date_time TIMESTAMP NOT NULL,
duration int NOT NULL,
group_id int NULL,
member_id int NULL,
CONSTRAINT PK_event PRIMARY KEY(event_id),
CONSTRAINT FK_event_groups FOREIGN KEY(group_id) REFERENCES groups(group_id),
CONSTRAINT FK_event_member FOREIGN KEY(member_id) REFERENCES member(member_id)
);

INSERT INTO member VALUES(1, 'Kent', 'Clark', NULL, NULL, '1938-03-04', NULL);
INSERT INTO member VALUES(2, 'Wayne', 'Bruce', NULL, '412-456-7689', '1939-02-01', NULL);
INSERT INTO member VALUES(3, 'Prince', 'Diana', NULL, NULL, '1941-02-20', NULL);
INSERT INTO member VALUES(4, 'Jordan', 'Hal', NULL, NULL, '1953-01-01', NULL);
INSERT INTO member VALUES(5, 'Stone', 'Victor', NULL, NULL, '1987-11-11', NULL);
INSERT INTO member VALUES(6, 'Curry', 'Arthur', NULL, '657-453-4636', '1999-12-25', NULL);
INSERT INTO member VALUES(7, 'Allen', 'Barry', NULL, NULL, '1998-7-16', NULL);
INSERT INTO member VALUES(8, 'Jones', 'John', NULL, NULL, '1956-08-06', NULL);

INSERT INTO groups VALUES(9, 'Justice League', '1');
INSERT INTO groups VALUES(10, 'Best Buds', '3');
INSERT INTO groups VALUES(11, 'Bat Family', '2');

INSERT INTO event VALUES(12, 'Crisis on Earth', NULL,'2023-04-02 14:30:45', 200, '9', NULL );
INSERT INTO event VALUES(13, 'Flashpoint', NULL,'1934-04-02 12:30:45', 950, NULL, '7' );
INSERT INTO event VALUES(14, 'Batman Vs. Superman', NULL,'2019-07-01 07:30:45', 400, '9', '2' );
INSERT INTO event VALUES(15, 'Mars Attacks', NULL, '2000-10-23 18:26:45', 600, '10', NULL );