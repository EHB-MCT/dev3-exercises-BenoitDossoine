# FIRST BATCH

What is the product with this number: S24_3856?

``` SQL
SELECT productName FROM products WHERE productCode = "S24_3856"; 
```

**Answer:**
1956 Porsche 356A Coupe

<br/>

What is the average product price?
```SQL
SELECT AVG(buyPrice) FROM products;
```
**Answer:**
54.395182

<br/>

How many products have “Ford” in the name?

```SQL
SELECT COUNT(productName) FROM products WHERE productName LIKE "%Ford%";
```
Answer
15

<br/>
What is the most expensive product?

```SQL
SELECT productName FROM products WHERE buyPrice = (SELECT MAX(buyPrice) FROM products);
```
**Answer:**
1962 LanciaA Delta 16V

<br/>
How many ships are in the products?

```SQL
SELECT COUNT(productLine) FROM products WHERE productLine = "Ships";
```
**Answer:**  9


# SECOND BATCH

How many orders were made by customer with nr 328?
```SQL
SELECT COUNT(orderNumber) FROM orders WHERE customerNumber = 328; 
```
**Answer:** 3

<br/>

How many orders were made by customer Julie Young?
```SQL
SELECT COUNT(orderNumber) 
FROM orders 
LEFT JOIN customers ON orders.customerNumber = customers.customerNumber 
WHERE (contactLastName = "Young" AND contactFirstName="Julie"); 
```
**Answer:**
3

How many customers from the USA have a credit limit of 0?
```SQL
SELECT COUNT(*) 
FROM customers
WHERE creditLimit = 0.00 AND country = "USA";
```
**Answer:**
1

<br/>

Who makes the biggest payment on average?
```SQL
SELECT customers.customerName, AVG(amount) AS average from payments
INNER JOIN customers ON customers.customerNumber = payments.customerNumber
GROUP BY customers.customerNumber
ORDER BY AVG(amount) DESC
LIMIT 1;
```
**Answer:**
Collectable Mini Designs Co.: 80375.240000

# BATCH 3

How much did William Brown pay in 2004?

```SQL
SELECT SUM(amount), payments.paymentDate as paymentDate FROM payments
LEFT JOIN customers ON customers.customerNumber = payments.customerNumber
WHERE (contactLastName = "Brown" AND contactFirstName = "William" AND paymentDate LIKE '2004%');
```

**Answer:** 38281.51

<br/>

Get a list of customer names and the name of their representative. Only include customers with a representative.

```SQL
SELECT customers.customerName as Customer, CONCAT(employees.lastName, " ",employees.firstName) as Representative FROM customers
LEFT JOIN employees ON employees.employeeNumber = customers.salesRepEmployeeNumber
WHERE NOT salesRepEmployeeNumber = 'NULL';
```

<br/>

What office is customer The Sharp Gifts Warehouse tied to?

```SQL
SELECT customers.customerName as Customer,  CONCAT(offices.city, ", ",offices.country) as Office FROM customers
LEFT JOIN employees ON employees.employeeNumber = customers.salesRepEmployeeNumber
LEFT JOIN offices ON offices.officeCode = employees.officeCode
WHERE customers.customerName = "The Sharp Gifts Warehouse";
```

**Answer:** San Francisco, USA