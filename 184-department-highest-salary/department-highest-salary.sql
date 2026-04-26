# Write your MySQL query statement below
select Department , Employee,  salary as Salary
from (select d.name as Department , e.name as Employee , e.salary, RANK() over(partition by d.name  order by e.salary desc) as salary_rank
from Employee e
left join Department d
on e.departmentId = d.id) x
where salary_rank=1;