# Write your MySQL query statement below
UPDATE Salary
SET sex = (CASE WHEN sex = 'm' THEN 'f' else 'm' END);
