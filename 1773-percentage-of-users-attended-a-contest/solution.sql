# Write your MySQL query statement below
select contest_id , ROUND(COUNT(distinct r.user_id)*100 / (Select Count(user_id) from Users),2) as percentage
from Register r
left join Users u
on u.user_id = r.user_id
Group by contest_id 
order by percentage DESC,contest_id;
