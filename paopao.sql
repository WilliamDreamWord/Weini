/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50719
 Source Host           : localhost
 Source Database       : paopao

 Target Server Type    : MySQL
 Target Server Version : 50719
 File Encoding         : utf-8

 Date: 09/06/2018 21:57:00 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `paopao_candidate`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_candidate`;
CREATE TABLE `paopao_candidate` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(10) NOT NULL COMMENT '个人姓名',
  `gender` int(10) NOT NULL COMMENT '性别',
  `qq` varchar(20) NOT NULL COMMENT 'qq',
  `phone` varchar(20) NOT NULL COMMENT '手机号码',
  `address` varchar(50) NOT NULL COMMENT '寝室地址',
  `comment` text COMMENT '候选人个人介绍',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_feedback`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_feedback`;
CREATE TABLE `paopao_feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` text NOT NULL COMMENT '反馈内容',
  `author_id` int(11) NOT NULL COMMENT '作者id',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '该反馈状态，1=显示，2=删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=121 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_order`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_order`;
CREATE TABLE `paopao_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `shipping_id` int(11) DEFAULT NULL COMMENT '收货地址',
  `payment` decimal(20,2) DEFAULT NULL COMMENT '实际付款金额,单位是元,保留两位小数',
  `payment_type` int(4) DEFAULT NULL COMMENT '支付类型,1-线下支付, 2-线上支付',
  `status` int(10) DEFAULT NULL COMMENT '订单状态:0-已取消，10-已下单，20-已接单，30-已签收',
  `get_time` datetime DEFAULT NULL COMMENT '接单时间',
  `end_time` datetime DEFAULT NULL COMMENT '签收时间',
  `close_time` datetime DEFAULT NULL COMMENT '交易关闭时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间, 下单时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_no_index` (`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=126 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_order_item`;
CREATE TABLE `paopao_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `package_id` int(11) DEFAULT NULL COMMENT '包裹id',
  `package_name` varchar(100) DEFAULT NULL COMMENT '包裹名称',
  `price` decimal(20,2) DEFAULT NULL COMMENT '订单总价,单位是元,保留两位小数',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`,`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=143 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_order_returns_apply`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_order_returns_apply`;
CREATE TABLE `paopao_order_returns_apply` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `type` int(4) NOT NULL COMMENT '申请类型：0-取消包裹订单',
  `order_status` int(10) NOT NULL COMMENT '订单状态:0-已取消，10-已下单，20-已接单，30-已签收',
  `why` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '退换货原因',
  `audit_status` int(10) NOT NULL DEFAULT '0' COMMENT '审核状态 -1 拒绝 0 未审核 1审核通过',
  `audit_time` datetime DEFAULT NULL COMMENT '审核时间',
  `audit_why` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核原因',
  `comment` text COLLATE utf8mb4_unicode_ci COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `paopao_order_shipping`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_order_shipping`;
CREATE TABLE `paopao_order_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_no` bigint(20) DEFAULT NULL COMMENT '订单号',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货姓名',
  `receiver_mobile` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '收货移动电话',
  `receiver_large_area` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '大区域，现在是西南大学',
  `receiver_medium_area` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '中区域，现在有北区，南区',
  `receiver_small_area` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '小片区，比如橘园八舍，桃园一舍',
  `receiver_door` varchar(20) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '门牌号',
  `shipping_status` int(11) DEFAULT '1' COMMENT '收货地址状态，1 默认 2 非默认',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=115 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
--  Table structure for `paopao_package`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_package`;
CREATE TABLE `paopao_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `name` varchar(100) NOT NULL COMMENT '包裹名称',
  `address` varchar(100) NOT NULL COMMENT '包裹取货地址',
  `detail` text COMMENT '包裹详细叙述',
  `price` decimal(20,2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `code` varchar(100) NOT NULL COMMENT '提货码',
  `package_type` int(11) NOT NULL COMMENT '包裹类型， 1-小件 2-大件 3-超大件',
  `status` int(6) DEFAULT '1' COMMENT '包裹状态.1-待取 2-取消',
  `except_time` varchar(100) DEFAULT NULL COMMENT '用户期望的收货时间',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_shipping`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_shipping`;
CREATE TABLE `paopao_shipping` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `receiver_name` varchar(20) DEFAULT NULL COMMENT '收货姓名',
  `receiver_mobile` varchar(20) DEFAULT NULL COMMENT '收货移动电话',
  `receiver_large_area` varchar(20) DEFAULT NULL COMMENT '大区域，现在是西南大学',
  `receiver_medium_area` varchar(20) DEFAULT NULL COMMENT '中区域，现在有北区，南区',
  `receiver_small_area` varchar(20) DEFAULT NULL COMMENT '小片区，比如橘园八舍，桃园一舍',
  `receiver_door` varchar(20) DEFAULT NULL COMMENT '门牌号',
  `status` int(11) DEFAULT '1' COMMENT '收货地址状态，1 默认 2 非默认',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_user`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_user`;
CREATE TABLE `paopao_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(50) NOT NULL COMMENT '用户密码，MD5加密',
  `email` varchar(50) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `question` varchar(100) DEFAULT NULL COMMENT '找回密码问题',
  `answer` varchar(100) DEFAULT NULL COMMENT '找回密码答案',
  `role` int(4) NOT NULL COMMENT '角色0-root用户,1-普通用户, 2-管理员',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name_unique` (`username`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_wechat_user`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_wechat_user`;
CREATE TABLE `paopao_wechat_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `open_id` varchar(255) NOT NULL,
  `union_id` varchar(255) DEFAULT NULL,
  `nickname` varchar(50) DEFAULT NULL COMMENT '昵称',
  `gender` varchar(50) DEFAULT NULL COMMENT '性别',
  `phone` varchar(20) DEFAULT NULL COMMENT '电话号码',
  `score` bigint(10) DEFAULT '0' COMMENT '积分',
  `identity` int(4) NOT NULL COMMENT '身份,1-普通用户, 2-vip用户',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '最后一次更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `open_id_unique` (`open_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
