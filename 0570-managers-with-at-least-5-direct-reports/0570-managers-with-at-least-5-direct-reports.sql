# Write your MySQL query statement below
select name
from Employee e1
where e1.id in 
        (select managerId 
        from Employee e2
        group by managerId
        having count(*)>=5
        )