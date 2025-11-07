# Write your MySQL query statement below
select name 
from Employee
where id in
(select managerId
from Employee e
group by managerID
having count(managerId) >=5);
