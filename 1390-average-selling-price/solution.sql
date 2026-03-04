# Write your MySQL query statement below
Select p.product_id , IFNULL(ROUND(SUM(p.price * u.units)/SUM(u.units),2),0) as average_price
From Prices p
left Join UnitsSold u
On p.product_id = u.product_id
AND p.start_date <=  u.purchase_date
AND p.end_date >= u.purchase_date
Group BY p.product_id;
