/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019-10-08 20:28:48                          */
/*==============================================================*/


DROP TABLE IF EXISTS address_info;

DROP TABLE IF EXISTS commodity_info;

DROP TABLE IF EXISTS commodity_type;

DROP TABLE IF EXISTS order_detail;

DROP TABLE IF EXISTS order_info;

DROP TABLE IF EXISTS user_info;

/*==============================================================*/
/* Table: address_info                                          */
/*==============================================================*/
CREATE TABLE address_info
(
   rev_id               INT NOT NULL AUTO_INCREMENT,
   user_id              INT,
   rev_name             VARCHAR(255) NOT NULL,
   rev_phone            VARCHAR(11) NOT NULL,
   province             VARCHAR(255) NOT NULL,
   city                 VARCHAR(255) NOT NULL,
   street               VARCHAR(255) NOT NULL,
   detail               VARCHAR(255) NOT NULL,
   PRIMARY KEY (rev_id)
);

ALTER TABLE address_info COMMENT '收货地址表';

/*==============================================================*/
/* Table: commodity_info                                        */
/*==============================================================*/
CREATE TABLE commodity_info
(
   commodity_id         INT NOT NULL AUTO_INCREMENT,
   type_id              INT,
   commodity_name       VARCHAR(255) NOT NULL,
   commodity_url        VARCHAR(255) NOT NULL,
   commodity_count      DOUBLE NOT NULL,
   PRIMARY KEY (commodity_id)
);

/*==============================================================*/
/* Table: commodity_type                                        */
/*==============================================================*/
CREATE TABLE commodity_type
(
   type_id              INT NOT NULL AUTO_INCREMENT,
   type_name            VARCHAR(255) NOT NULL,
   PRIMARY KEY (type_id)
);

ALTER TABLE commodity_type COMMENT '商品分类表';

/*==============================================================*/
/* Table: order_detail                                          */
/*==============================================================*/
CREATE TABLE order_detail
(
   detail_id            INT NOT NULL AUTO_INCREMENT,
   order_id             INT,
   commodity_id         INT,
   commodity_num        DOUBLE NOT NULL,
   PRIMARY KEY (detail_id)
);

ALTER TABLE order_detail COMMENT '订单详情表';

/*==============================================================*/
/* Table: order_info                                            */
/*==============================================================*/
CREATE TABLE order_info
(
   order_id             INT NOT NULL AUTO_INCREMENT,
   user_id              INT,
   rev_id               INT,
   order_money          DOUBLE NOT NULL,
   PRIMARY KEY (order_id)
);

ALTER TABLE order_info COMMENT '订单表';

/*==============================================================*/
/* Table: user_info                                             */
/*==============================================================*/
CREATE TABLE user_info
(
   user_id              INT NOT NULL AUTO_INCREMENT,
   user_name            VARCHAR(255) NOT NULL,
   user_pwd             VARCHAR(255) NOT NULL,
   PRIMARY KEY (user_id)
);

ALTER TABLE user_info COMMENT '用户表';

ALTER TABLE address_info ADD CONSTRAINT FK_Reference_2 FOREIGN KEY (user_id)
      REFERENCES user_info (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE commodity_info ADD CONSTRAINT FK_Reference_1 FOREIGN KEY (type_id)
      REFERENCES commodity_type (type_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE order_detail ADD CONSTRAINT FK_Reference_5 FOREIGN KEY (order_id)
      REFERENCES order_info (order_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE order_detail ADD CONSTRAINT FK_Reference_6 FOREIGN KEY (commodity_id)
      REFERENCES commodity_info (commodity_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE order_info ADD CONSTRAINT FK_Reference_3 FOREIGN KEY (user_id)
      REFERENCES user_info (user_id) ON DELETE RESTRICT ON UPDATE RESTRICT;

ALTER TABLE order_info ADD CONSTRAINT FK_Reference_4 FOREIGN KEY (rev_id)
      REFERENCES address_info (rev_id) ON DELETE RESTRICT ON UPDATE RESTRICT;



##子查询作为临时表使用
SELECT type_name,commodity_name,commodity_num,order_money,rev_name,rev_phone,
province,city,street,detail FROM user_info 
LEFT JOIN order_info ON user_info.`user_id`=order_info.`user_id`
LEFT JOIN address_info ON address_info.`rev_id`=order_info.`rev_id`
LEFT JOIN order_detail ON order_detail.`order_id`=order_info.`order_id`
LEFT JOIN commodity_info ON order_detail.`commodity_id`=commodity_info.`commodity_id`
LEFT JOIN commodity_type ON commodity_info.`type_id`=commodity_type.`type_id`;


