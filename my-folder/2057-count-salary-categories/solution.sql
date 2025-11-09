# Write your MySQL query statement below
select "Low Salary" as category , count(1) as accounts_count
from Accounts
where income < 20000 

union

select "Average Salary" as category , count(1) as accounts_counts
from Accounts
where income >= 20000 and income <=50000

union

select "High Salary" as category , count(1) as accounts_counts
from Accounts
where income > 50000 
