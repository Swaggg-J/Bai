##创建新的库
CREATE DATABASE IF NOT EXISTS homework DEFAULT CHARSET utf8;
##创建一个新用户并设置密码
CREATE USER IF NOT EXISTS 'homework'@'%' IDENTIFIED BY 'homework';
##为新用户授予权限
GRANT ALL PRIVILEGES ON homework.* TO 'homework'@'%';
FLUSH PRIVILEGES;
USE homework;
##创建学生表
CREATE TABLE student
(
	stu_id INT PRIMARY KEY NOT NULL,	-- 学生学号，设为主键，不能为空
	stu_name VARCHAR(8) NOT NULL,		-- 学生姓名
	stu_sex CHAR(1) NOT NULL,		-- 学生性别
	stu_birthday DATETIME,			-- 学生生日
	class CHAR(5)				-- 学生所在班级
);
##创建教师表
CREATE TABLE teacher
(
	tea_id INT PRIMARY KEY NOT NULL,	-- 教师工号，设为主键，不能为空
	tea_name VARCHAR(8) NOT NULL,		-- 教师姓名
	tea_sex CHAR(1) NOT NULL,		-- 教师性别
	tea_birthday DATETIME,			-- 教师生日
	tea_rank CHAR(6),			-- 教师职务
	tea_depart VARCHAR(6) NOT NULL 		-- 教师部门
);
##创建课程表
CREATE TABLE course
(
	cou_id INT PRIMARY KEY NOT NULL,	-- 课程编号，主键非空
	cou_name VARCHAR(8),			-- 课程名称
	teaId INT NOT NULL 			-- 教师编号
);
##创建成绩表
CREATE TABLE score
(
	stuId INT NOT NULL,			-- 学生学号
	couId INT NOT NULL,			-- 课程编号
	Degree DECIMAL(4,1),			-- 成绩
	PRIMARY KEY(stuId,couId)		-- 学号和课程号设为联合主键
);
##添加外键
ALTER TABLE course
ADD FOREIGN KEY course_teacher_id(teaId) 
REFERENCES teacher(tea_id);			-- 将教师编号设为外键

ALTER TABLE score
ADD FOREIGN KEY score_student_id(stuId)
REFERENCES student(stu_id);			-- 成绩表中设置学生外键
	
ALTER TABLE score
ADD FOREIGN KEY score_course_id(couId)
REFERENCES course(cou_id);			-- 成绩表中设置课程外键


##向学生表中插入数据
INSERT INTO student VALUES(21,'张三','男','1998-05-02','16');
INSERT INTO student VALUES(22,'曾华','男','1977-09-01','17');
INSERT INTO student VALUES(23,'匡明','男','1975-10-02','16');
INSERT INTO student VALUES(24,'王丽','女','1976-01-23','18');
INSERT INTO student VALUES(25,'李军','男','1976-02-20','16');
INSERT INTO student VALUES(26,'王芳','女','1975-02-10','17');

##向教师表中插入数据
INSERT INTO teacher VALUES(04,'李诚','男','1958-12-02','副教授','计算机系');
INSERT INTO teacher VALUES(56,'张旭','男','1969-03-12','讲师','电子工程系');
INSERT INTO teacher VALUES(25,'王萍','女','1972-05-05','助教','计算机系') ;
INSERT INTO teacher VALUES(31,'刘冰','女','1977-08-14','助教','电子工程系');

##向课程表中插入数据
INSERT INTO course VALUES(105,'计算机导论',25);
INSERT INTO course VALUES(245,'操作系统',04);
INSERT INTO course VALUES(166,'数字电路',56);
INSERT INTO course VALUES(888,'高等数学',31);

##向成绩表中插入数据
INSERT INTO score VALUES(21,245,86);
INSERT INTO score VALUES(22,245,75);
INSERT INTO score VALUES(23,245,68);
INSERT INTO score VALUES(21,105,92);
INSERT INTO score VALUES(22,105,88);
INSERT INTO score VALUES(23,105,76);
INSERT INTO score VALUES(24,105,64);
INSERT INTO score VALUES(25,105,91);
INSERT INTO score VALUES(26,105,78);
INSERT INTO score VALUES(24,166,85);
INSERT INTO score VALUES(25,166,79);
INSERT INTO score VALUES(26,166,81);