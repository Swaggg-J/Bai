##查询练习
SELECT * FROM student;
SELECT * FROM teacher;
SELECT * FROM course;
SELECT * FROM score;

##第一题：查询Student表中的所有记录的Sname、Ssex和Class列。
SELECT stu_name AS 姓名,stu_sex AS 性别,class AS 班级 FROM student;

##第二题：查询教师所有的单位即不重复的Depart列
SELECT DISTINCT tea_depart FROM teacher;

##第三题：查询Student表的所有记录。
SELECT * FROM student;

##第四题：查询Score表中成绩在60到80之间的所有记录
SELECT * FROM score WHERE degree>60 AND degree<80;
SELECT * FROM score WHERE degree BETWEEN 60 AND 80;

##第五题：查询Score表中成绩为85，86或88的记录。
SELECT * FROM score WHERE degree IN (85,86,88);

##第六题：查询Student表中“95031”班或性别为“女”的同学记录。
SELECT * FROM student WHERE stu_sex = '女' AND class = 16;

##第七题：以Class降序查询Student表的所有记录。
SELECT * FROM student ORDER BY class DESC;

##第八题：以Cno升序、Degree降序查询Score表的所有记录。
SELECT * FROM score ORDER BY couId ASC,Degree DESC;

##第九题：查询“16”班的学生人数。
SELECT COUNT(class) FROM student WHERE class = 16;

##第十题：查询Score表中除了每门课程最高分的学生学号和课程号。（子查询或者排序）
SELECT stuId,couId FROM score WHERE Degree NOT IN (SELECT MAX(Degree) FROM score GROUP BY couId);

##第十一题：查询每门课的平均成绩。
SELECT couId,AVG(Degree) FROM score GROUP BY(couId);

##第十二题：查询Score表中至少有5名学生选修的并以10开头的课程的平均分数。
SELECT couId,AVG(degree) FROM score WHERE couId IN
(SELECT couId FROM score GROUP BY couId HAVING COUNT(couId)>4) AND couId LIKE '10_';

##第十三题：查询分数大于70，小于90的Sno列。
SELECT stuId FROM score WHERE degree BETWEEN 70 AND 90; 

##第十四题：查询所有学生的Sname、Cno和Degree列。
SELECT stu_name,cou_id,degree FROM student,course,score 
WHERE student.stu_id = score.stuId AND course.cou_id = score.couId;

##第十五题：查询所有学生的Sno、Cname和Degree列。
SELECT stu_id,cou_name,degree FROM student,course,score 
WHERE student.stu_id = score.stuId AND course.cou_id = score.couId;

##第十六题：查询所有学生的Sname、Cname和Degree列。
SELECT stu_name,cou_name,degree FROM student,course,score 
WHERE student.stu_id = score.stuId AND course.cou_id = score.couId;

##第十七题：查询“16”班学生的平均分。
SELECT AVG(degree) FROM score WHERE stuId IN
(SELECT stu_id FROM student WHERE class = 16);

##第十八题：查询所有同学的Sno、Cno和rank列。

##第十九题：查询选修“105”课程的,并且成绩高于“24”号同学成绩的所有同学的记录。
SELECT * FROM score WHERE couId = 105 AND degree > (SELECT degree FROM score WHERE stuId = 24 AND couId = 105);

##第二十一题：查询成绩高于学号为“109”、课程号为“3-105”的成绩的所有记录。
SELECT * FROM score WHERE degree > (SELECT degree FROM score WHERE stuId = 24 AND couId = 105);

##第二十二题：查询和学号为22的同学同年出生的所有学生的Sno、Sname和Sbirthday列。
SELECT stu_id,stu_name,stu_birthday FROM student WHERE YEAR(stu_birthday) = 
(SELECT stu_birthday FROM student WHERE stu_id = 22);

##第二十三题：查询“张旭“教师任课的学生成绩。
SELECT degree FROM score WHERE couId = 
(SELECT cou_id FROM course WHERE teaId = 
(SELECT tea_id FROM teacher WHERE tea_name = '张旭' ));

##第二十四题：查询选修某课程的同学人数多于5人的教师姓名。
SELECT tea_name FROM teacher WHERE tea_id = 
(SELECT teaId FROM course WHERE cou_id = 
(SELECT couId FROM score GROUP BY couId HAVING COUNT(couId) > 5));

##第二十五题：查询16班和18班全体学生的记录。
SELECT * FROM student WHERE class IN (16,18);

##第二十六题：查询存在有85分以上成绩的课程Cno.
SELECT DISTINCT couId FROM score WHERE degree > 85;

##第二十七题：查询出“计算机系“教师所教课程的成绩表。
SELECT * FROM score WHERE couId IN
(SELECT cou_id FROM course WHERE teaId IN
(SELECT tea_id FROM teacher WHERE tea_depart = '计算机系'));

##第二十八题：

##第二十九题：查询选修编号为“105“课程且成绩至少高于一个选修编号为“245”的同学的Cno、Sno和Degree,并按Degree从高到低次序排序。
SELECT * FROM score WHERE couId = 105 AND
degree > ANY(SELECT degree FROM score WHERE couId = 245) ORDER BY degree DESC;

##第三十题：查询选修编号为“105”且成绩高于选修编号为“245”课程的同学的Cno、Sno和Degree.
SELECT * FROM score WHERE couId = 105 AND
degree > ALL(SELECT degree FROM score WHERE couId = 245);

##第三十一题：查询所有教师和同学的name、sex和birthday.
SELECT stu_name,stu_sex,stu_birthday FROM student
UNION ALL
SELECT tea_name,tea_sex,tea_birthday FROM teacher;

##第三十二题：查询所有“女”教师和“女”同学的name、sex和birthday.
SELECT stu_name,stu_sex,stu_birthday FROM student WHERE stu_sex = '女'
UNION ALL
SELECT tea_name,tea_sex,tea_birthday FROM teacher WHERE tea_sex = '女';

##第三十三题：查询成绩比该课程平均成绩低的同学的成绩表。
SELECT * FROM score GROUP BY couId WHERE Degree < 
(SELECT AVG(degree) FROM score GROUP BY couId);

##第三十四题：查询所有任课教师的Tname和Depart
SELECT tea_name,tea_depart FROM teacher WHERE tea_id IN
(SELECT teaId FROM course WHERE cou_id IN 
(SELECT couId FROM score));

##第三十二题：

##第三十六题：查询至少有2名男生的班号。
SELECT DISTINCT class FROM student WHERE stu_sex = '男' AND class IN 
(SELECT class FROM student WHERE class HAVING COUNT(1) > 2);
SELECT class FROM student WHERE stu_sex = '男' GROUP BY class HAVING COUNT(class) > 2;

##第三十七题：查询Student表中不姓“王”的同学记录。
SELECT * FROM student WHERE stu_name NOT LIKE '王%';

##第三十八题：查询Student表中每个学生的姓名和年龄。
SELECT stu_name,YEAR(NOW()) - YEAR(stu_birthday) FROM student;

##第三十九题：查询Student表中最大和最小的Sbirthday日期值。
SELECT MAX(stu_birthday),MIN(stu_birthday) FROM student;

##第四十题：以班号和年龄从大到小的顺序查询Student表中的全部记录。
SELECT * FROM student ORDER BY class,YEAR(NOW()) - YEAR(stu_birthday);

##第四十一题：查询“男”教师及其所上的课程。
SELECT tea_name,cou_name FROM teacher,course WHERE teacher.tea_id = course.teaId;

##第四十二题：查询最高分同学的Sno、Cno和Degree列。
SELECT * FROM score WHERE degree IN (SELECT MAX(degree) FROM score);

##第四十三题：查询和“李军”同性别的所有同学的Sname
SELECT stu_name FROM student WHERE stu_sex = 
(SELECT stu_sex FROM student WHERE stu_name = '李军');

##第四十四题：查询和“李军”同性别并同班的同学Sname.
SELECT stu_name FROM student WHERE stu_sex = 
(SELECT stu_sex FROM student WHERE stu_name = '李军')
AND class = 
(SELECT class FROM student WHERE stu_name = '李军');

##第四十五题：查询所有选修“计算机导论”课程的“男”同学的成绩表.
SELECT * FROM score WHERE stuId IN 
(SELECT stu_id FROM student WHERE stu_sex = '男') AND 
couId IN (SELECT cou_id FROM course WHERE cou_name = '计算机导论');