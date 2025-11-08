# Write your MySQL query statement below
Select p.product_name , sum(o.unit) as unit
from Orders o
Inner Join Products p
On o.product_id = p.product_id
Where o.order_date between '2020-02-01' AND '2020-02-29'
GROUP BY o.product_id
having sum(o.unit) >= 100;

