# Write your MySQL query statement below
select name as results
from (
    select u.name , count(1) as cnt
    from MovieRating r
    left join Users u
    on r.user_id = u.user_id
    group by u.name
    order by cnt desc , u.name asc
    limit 1
) x

union all

select title
from (
    select title , avg(rating) as average
    from MovieRating r
    left join Movies m
    on r.movie_id = m.movie_id
    where r.created_at between '2020-02-01' and '2020-02-29'
    group by m.title
    order by average desc , title asc
    limit 1
) y
