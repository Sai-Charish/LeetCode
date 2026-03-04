# Write your MySQL query statement below
Select query_name , round(avg(q.rating/q.position),2) as quality , round(sum(case when rating < 3 then 1 else 0 end) *100/count(q.query_name),2) as poor_query_percentage
from Queries q
group by q.query_name;
