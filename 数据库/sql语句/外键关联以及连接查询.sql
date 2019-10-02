USE student;
##新建班级学生表
CREATE TABLE IF NOT EXISTS student
(
	stu_id INT PRIMARY KEY AUTO_INCREMENT,
	stu_name VARCHAR(255) NOT NULL,
	classId INT
);
CREATE TABLE IF NOT EXISTS class
(
	class_id INT PRIMARY KEY AUTO_INCREMENT,
	class_name VARCHAR(255),
	stuNum INT
);
##创建外键
ALTER TABLE student
ADD FOREIGN KEY student_class_id(classId)
REFERENCES class(class_id);

##添加数据
INSERT INTO class (class_name) VALUES ('Java_35');
INSERT INTO class (class_name) VALUES ('Java_37');
INSERT INTO class (class_name) VALUES ('Java_40');
INSERT INTO student (stu_name,classId) VALUES ('张三',1);
INSERT INTO student (stu_name,classId) VALUES ('李四',2);

##错误写法
INSERT INTO student (stu_name,classId) VALUES ('王五',3);

##简单连表查询
SELECT * FROM student,class WHERE student.classId = class.class_id;


##连接查询：内连接、左连接、右连接
##内连接
SELECT * FROM student INNER JOIN class ON student.classID = class.class_id;
##右连接
SELECT * FROM student RIGHT JOIN class ON student.classId = class.class_id;
##左连接
SELECT * FROM student LEFT JOIN class ON student.classId = class.class_id;
