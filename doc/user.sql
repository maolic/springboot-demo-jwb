# Host: localhost  (Version 5.7.28)
# Date: 2021-10-17 13:41:34

#
# Structure for table "user"
#

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL DEFAULT '',
  `password` varchar(255) NOT NULL DEFAULT '',
  `status` int(11) DEFAULT '1',
  `remark` varchar(255) DEFAULT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

#
# Data for table "user"
#

INSERT INTO `user` VALUES (1,'admin','admin',1,NULL,'2021-10-17 13:41:07','2021-10-17 13:41:07');

# 对用户表添加用户名唯一键，防止重复用户名冲突
ALTER TABLE `user` ADD UNIQUE (`username`);
