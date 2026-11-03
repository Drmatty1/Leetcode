# Write your MySQL query statement below
select * , (
    SELECT CASE
            WHEN x + y > z
             AND y + z > x
             AND x + z > y
            THEN 'Yes'
            ELSE 'No'
        END 
) as triangle
from Triangle