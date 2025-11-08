# Write your MySQL query statement below


Select customer_id
from Customer
Group by customer_id
Having count(Distinct product_key) = (Select Count(1) from Product);
