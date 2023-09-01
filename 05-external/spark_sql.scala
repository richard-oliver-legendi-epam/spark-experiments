CREATE TABLE people (name STRING, age int);

INSERT INTO people VALUES ("Michael", NULL);
 
SHOW TABLES;

SELECT * FROM people WHERE age < 20;

SELECT name FROM people WHERE age IS NULL;
