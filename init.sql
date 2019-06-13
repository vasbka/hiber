DROP TABLE IF EXISTS enrollee;

CREATE TABLE enrollee(
    id SERIAL PRIMARY KEY,
    firstName VARCHAR(30),
    lastName VARCHAR(30),
    email VARCHAR(30),
    login VARCHAR(30),
    password VARCHAR(30)
);

CREATE TABLE subject(
    id SERIAL PRIMARY KEY,
    name VARCHAR(30),
    subjectType VARCHAR(30)
);

CREATE TABLE point(
    enorlleeId INTEGER references enrollee(id),
    subjectId INTEGER references subject(id),
    point FLOAT
);
