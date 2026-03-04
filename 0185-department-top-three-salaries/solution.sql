# Write your MySQL query statement below
select Department , Employee , Salary 
From (SELECT d.name as Department ,
        e.name as Employee ,
        e.salary as Salary,
        dense_rank() over(partition by d.name order by e.salary desc) as rnk
FROM Employee e
LEFT JOIN Department d
ON e.departmentId = d.id) x

where x.rnk <= 3 ;
