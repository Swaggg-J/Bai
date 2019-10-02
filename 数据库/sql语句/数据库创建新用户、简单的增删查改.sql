##创建一个新的数据库
CREATE DATABASE IF NOT EXISTS student DEFAULT CHARSET utf8;
##创建一个新用户并设置密码
CREATE USER 'student'@'%' IDENTIFIED BY 'student';
##将新数据库的权限赋给用户
GRANT ALL PRIVILEGES ON student.* TO 'student';
##刷新权限
FLUSH PRIVILEGES;

##创建一张学生信息表
USE student;
CREATE TABLE stu_info
(
	stu_id INT PRIMARY KEY AUTO_INCREMENT,
	stu_name VARCHAR(255) NOT NULL,
	stu_age INT CHECK(stu_age>0 AND stu_age<150),
	stu_sex CHAR(1) DEFAULT '男',
	create_time DATETIME DEFAULT NOW(),
	update_time TIMESTAMP
);
##增
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('张三',22,'男');
INSERT INTO stu_info (stu_name,stu_age) VALUES ('李四',24);
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('王红',26,'女');

##删
DELETE FROM stu_info WHERE stu_sex = '男';

DELETE FROM stu_info;
##增
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('张三',22,'男');
INSERT INTO stu_info (stu_name,stu_age) VALUES ('李四',24);
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('王红',26,'女');
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('王五',26,'男');
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('赵六',24,'男');
INSERT INTO stu_info (stu_name,stu_age,stu_sex) VALUES ('张青',26,'女');
##查
SELECT stu_name AS 姓名,stu_age AS 年龄,stu_sex AS 性别 FROM stu_info WHERE 
stu_age = 26;
SELECT stu_name AS 姓名,stu_age AS 年龄 FROM stu_info WHERE stu_sex = '男';
SELECT * FROM stu_info;
##改
UPDATE stu_info SET stu_age = 24 WHERE stu_name = '张青';

##条件查询
SELECT COUNT(*) FROM stu_info WHERE stu_age>22;
##增加字段
ALTER TABLE stu_info ADD stu_pwd VARCHAR(255);
##删除字段
ALTER TABLE stu_info DROP stu_pwd;