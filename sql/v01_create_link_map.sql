DROP TABLE IF EXISTS `link_map`;
CREATE TABLE `link_map` (
  `id` bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `short_link_id` bigint unsigned NOT NULL COMMENT '短链id',
  `short_link` varchar(16) NOT NULL COMMENT '短链',
  `long_link` varchar(255) NOT NULL COMMENT '长链',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_short` (`short_link_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4  COMMENT '链接映射表';
