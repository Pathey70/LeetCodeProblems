# Write your MySQL query statement below
select max(N1.num) as num from (select t.num from MyNumbers t group by t.num having count(*)=1) as N1;