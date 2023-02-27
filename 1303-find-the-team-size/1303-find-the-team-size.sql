# Write your MySQL query statement below
select E.employee_id ,count(*) as "team_size" from Employee E, Employee E1 where E.team_id = E1.team_id group by E.employee_id;