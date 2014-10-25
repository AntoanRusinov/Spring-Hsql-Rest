CREATE TABLE users(
id int not null,
name varchar(20),
typee varchar(20),
continent varchar(20),
country varchar(20),
user_name varchar(20),
PRIMARY KEY(id)
);

CREATE TABLE to_do(
id int not null,
content varchar(200),
last_modified_date DATETIME,
PRIMARY KEY(id)
);
