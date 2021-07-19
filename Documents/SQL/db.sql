
1) Select * From user Join project On user.projectId = project.projectId;

2) Select * From users where projectid In (select Distinct(projectid) From projects);
