# Write your MySQL query statement below
Select Department , Employee , Salary
from (select d.name as Department, e.name as Employee, e.salary as Salary , DENSE_Rank () over(partition by d.id order by e.salary desc) as Salary_rank
from Employee e
left join Department d 
on e.departmentId = d.id) x
where Salary_rank <= 3