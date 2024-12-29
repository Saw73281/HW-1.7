SELECT c.NAME, COUNT(p.ID) AS PROJECT_COUNT
FROM client c
JOIN project p ON c.ID = p.CLIENT_ID
GROUP BY c.NAME
HAVING COUNT(p.ID) = (SELECT MAX(COUNTED)
                      FROM (SELECT COUNT(ID) AS COUNTED
                            FROM project
                            GROUP BY CLIENT_ID));
