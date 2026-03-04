# Write your MySQL query statement below
select visited_on , 
    (
        select sum(amount)
        from customer
        where visited_on between Date_sub(c.visited_on , Interval 6 day) and c.visited_on
    ) as amount,

    round((
        select sum(amount)/7
        from customer
        where visited_on between Date_sub(c.visited_on , Interval 6 day) and c.visited_on
    ),2) as average_amount

from Customer c
where DATE_SUB(visited_on,INTERVAL 6 DAY) in (select visited_on from Customer)
group by visited_on
order by visited_on
