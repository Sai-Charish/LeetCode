# Write your MySQL query statement below
SELECT email as Email
FROM Person p 
GROUP BY p.email
HAVING COUNT(email) > 1;
