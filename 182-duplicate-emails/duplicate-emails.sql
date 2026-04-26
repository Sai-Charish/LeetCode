# Write your MySQL query statement below
Select email as Email
from Person
group by email
Having count(email) > 1;