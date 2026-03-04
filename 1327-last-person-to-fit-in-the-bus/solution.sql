# Write your MySQL query statement below
SELECT person_name
FROM   (SELECT person_name ,sum(weight) over(order by turn) as Total_weight
        FROM Queue 
        ORDER BY turn desc) x
WHERE Total_weight <=1000
limit 1;



