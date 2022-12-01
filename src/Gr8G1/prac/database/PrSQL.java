package Gr8G1.prac.database;

public class PrSQL {
  /*
   * # SQL(Structured Query Language)
   *
   * 설치(Mac)
   *  - Mysql Github: https://gist.github.com/nrollr/3f57fc15ded7dddddcc4e82fe137b58e
   *
   */

  /*
CREATE DATABASE testDB;
DROP DATABASE testDB

CREATE TABLE Customers;
CREATE TABLE Persons(
  PersonID int,
  LastName varchar(255),
  FirstName varchar(255),
  Address varchar(255),
  City varchar(255)
);

DROP TABLE Persons;
TRUNCATE TABLE Persons;

ALTER TABLE Persons ADD Birthday DATE;
ALTER TABLE Persons DROP COLUMN Birthday;

INSERT INTO Customers(CustomerName, Address, City, PostalCode, Country) VALUES('Hekkan Burger', 'Gateveien 15', 'Sandnes', '4306', 'Norway');

SELECT * FROM Customers WHERE PostalCode IS NULL;
SELECT * FROM Customers WHERE PostalCode IS NOT NULL;

SELECT * FROM Customers WHERE City LIKE 'a%';
SELECT * FROM Customers WHERE City LIKE '_a%';
SELECT * FROM Customers WHERE City LIKE 'a%b';
SELECT * FROM Customers WHERE City LIKE '[abc]%';
SELECT * FROM Customers WHERE City LIKE '[a-f]%';
SELECT * FROM Customers WHERE City LIKE '[!abc]%';

// [abc]%: a|b|c OR 조건으로 포함
// [!abc]%: a|b|c 아닌 OR 조건으로 포함
// [a-z]%: a~z 까지 OR 조건으로 포함
// _-% : 와일드카드 이후 2번째 시작 단어(-) 포함
// -% : 시작 단어(-) 포함
// %- : 종료 단어(-) 포함
// %-%: 사이 단어(-) 포함
// -%-: 시작, 종료 단어(-) 포함

SELECT * FROM Customers WHERE Country IN('Norway', 'France');
SELECT * FROM Customers WHERE Country NOT IN('Norway', 'France');

SELECT * FROM Products WHERE Price BETWEEN 10 AND 20;
SELECT * FROM Products WHERE Price NOT BETWEEN 10 AND 20;

SELECT CustomerName, Address, PostalCode AS Pno FROM Customers;

SELECT * FROM Customers AS Consumers;

SELECT * FROM Orders INNER JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
SELECT * FROM Orders LEFT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;
SELECT * FROM Orders RIGHT JOIN Customers ON Orders.CustomerID = Customers.CustomerID;

SELECT COUNT(CustomerID), Country FROM Customers GROUP BY Country;
SELECT COUNT (CustomerID), Country FROM Customers GROUP BY Country ORDER BY COUNT(CustomerID) DESC;

UPDATE Customers SET City = 'Oslo';
UPDATE Customers SET City = 'Oslo' WHERE Country = 'Norway';
UPDATE Customers SET City = 'Oslo', Country = 'Norway' WHERE CustomerID = 32;

DELETE FROM Customers WHERE Country = 'Norway';
DELETE FROM Customers;

SELECT MIN(Price) FROM Products;
SELECT MAX(Price) FROM Products;
SELECT COUNT(*) FROM Products WHERE Price = 18;
SELECT AVG(Price) FROM Products;
SELECT SUM(Price) FROM Products;




   */
}
