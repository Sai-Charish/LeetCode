# Write your MySQL query statement below
select * , count(id) as num
from (select requester_id as id 
    from RequestAccepted
    union all
    select accepter_id 
    from RequestAccepted ) x
group by id
order by num desc
limit 1

