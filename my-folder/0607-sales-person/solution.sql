SELECT name
FROM SalesPerson 
WHERE name NOT IN (SELECT s.name
FROM Orders o
LEFT JOIN Company c
ON o.com_id = c.com_id
LEFT JOIN SalesPerson s
ON o.sales_id = s.sales_id
WHERE c.name = 'RED');
