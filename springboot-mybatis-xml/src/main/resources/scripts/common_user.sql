/* ---------------------------------------------------- */
/*  Generated by Enterprise Architect Version 15.0 		*/
/*  Created On : 13-3月-2020 0:08:39 				*/
/*  DBMS       : MySql 						*/
/* ---------------------------------------------------- */

SET FOREIGN_KEY_CHECKS=0
; 
/* Drop Tables */

DROP TABLE IF EXISTS `common_user` CASCADE
;

/* Create Tables */

CREATE TABLE `common_user`
(
	`user_id` INT UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '主键',
	`user_name` VARCHAR(50) NULL COMMENT '用户名',
	`age` INT NULL COMMENT '年龄',
	`email` VARCHAR(50) NULL COMMENT '邮箱',
	`phone` VARCHAR(50) NULL COMMENT '电话',
	`money` DOUBLE(10,2) NULL COMMENT '账户余额，用于演示事务才添加至此',
	`create_time` TIMESTAMP NULL COMMENT '创建时间',
	`last_update_time` TIMESTAMP NULL COMMENT '最后更新时间',
	`created_by` INT NULL,
	`last_updated_by` INT NULL,
	CONSTRAINT `PK_Table1` PRIMARY KEY (`user_id` ASC)
)

;

SET FOREIGN_KEY_CHECKS=1
; 
