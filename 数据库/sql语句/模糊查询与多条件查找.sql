##模糊查询：% _
SELECT * FROM stu_info WHERE country LIKE ('中国');
##查询以中开头的字段
SELECT * FROM stu_info WHERE country LIKE ('中%');
##查询以中开头的两字字段
SELECT * FROM stu_info WHERE country LIKE ('中_');
##查询以国结尾的字段
SELECT * FROM stu_info WHERE country LIKE ('%国');
##查询以国结尾的两字字段
SELECT * FROM stu_info WHERE country LIKE ('_国');
##查询包含国字的字段
SELECT * FROM stu_info WHERE country LIKE ('%阿%');


##多条件查找
##OR关键字
SELECT stu_id AS 学号,stu_name AS 姓名,stu_age AS 年龄,stu_sex AS 性别 FROM stu_info 
WHERE stu_id = 2 OR stu_id = 5;
##IN关键字
SELECT stu_id AS 学号,stu_name AS 姓名,stu_age AS 年龄,stu_sex AS 性别 FROM stu_info 
WHERE stu_id IN (5,6,1,7,8);
##AND关键字
SELECT stu_id AS 学号,stu_name AS 姓名,stu_age AS 年龄,stu_sex AS 性别 FROM stu_info 
WHERE stu_age = 24 AND stu_sex = '男';