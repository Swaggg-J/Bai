ALTER TABLE stu_info ADD address VARCHAR(255) NOT NULL;

##三大范式

##1、字段不可再被拆分
ALTER TABLE stu_info DROP address;
ALTER TABLE stu_info ADD country VARCHAR(255);
ALTER TABLE stu_info ADD province VARCHAR(255);
ALTER TABLE stu_info ADD city VARCHAR(255);
ALTER TABLE stu_info ADD street VARCHAR(255);

##2、表不可在在被拆分
CREATE TABLE sub_info(
	sub_id INT PRIMARY KEY AUTO_INCREMENT,
	sub_name VARCHAR(255)
);

CREATE TABLE sco_info(
	stu_id INT NOT NULL,
	sub_id INT NOT NULL,
	score INT NOT NULL
);

##3、表与表之间用唯一键关联（图形化操作）

##连表查询
SELECT * FROM stu_info,sco_info WHERE stu_info.stu_id = sco_info.stu_id;
SELECT stu_name,sub_name,score FROM stu_info,sub_info,sco_info 
WHERE stu_info.stu_id = sco_info.stu_id AND sub_info.sub_id = sco_info.sub_id;
