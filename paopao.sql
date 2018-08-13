-- noinspection SqlNoDataSourceInspectionForFile
-- noinspection SqlDialectInspectionForFile
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

 Date: 08/11/2018 13:56:25 PM
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
--  Table structure for `mmall_order_item`
-- ----------------------------
DROP TABLE IF EXISTS `mmall_order_item`;
CREATE TABLE `mmall_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单子表id',
  `user_id` int(11) DEFAULT NULL,
  `order_no` bigint(20) DEFAULT NULL,
  `target_id` int(11) DEFAULT NULL COMMENT '目标id，当前只有取包裹一种',
  `target_name` varchar(100) DEFAULT NULL COMMENT '目标名称',
  `current_unit_price` decimal(20,2) DEFAULT NULL COMMENT '生成订单时的此种服务单价，单位是元,保留两位小数',
  `quantity` int(10) DEFAULT NULL COMMENT '目标的数量',
  `total_price` decimal(20,2) DEFAULT NULL COMMENT '商品总价,单位是元,保留两位小数',
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `order_no_index` (`order_no`) USING BTREE,
  KEY `order_no_user_id_index` (`user_id`,`order_no`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_comment`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_comment`;
CREATE TABLE `paopao_comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `content` text NOT NULL COMMENT '评论内容',
  `author_id` int(11) NOT NULL COMMENT '作者id',
  `entity_type` int(11) NOT NULL COMMENT '评论类型, 1=评论 2=反馈',
  `entity_id` int(11) NOT NULL COMMENT '评论实体id',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '评论状态，1=显示，2=删除',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8;

-- ----------------------------
--  Table structure for `paopao_package`
-- ----------------------------
DROP TABLE IF EXISTS `paopao_package`;
CREATE TABLE `paopao_package` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) NOT NULL COMMENT '包裹名称',
  `address` varchar(100) NOT NULL comment '包裹取货地址',
  `detail` text COMMENT '包裹详细叙述',
  `price` decimal(20,2) NOT NULL COMMENT '价格,单位-元保留两位小数',
  `code` varchar(100) NOT NULL COMMENT '提货码',
  `package_type` int(11) NOT NULL COMMENT '包裹类型， 1-小件 2-大件 3-超大件',
  `status` int(6) DEFAULT '1' COMMENT '包裹状态.1-待取 2-取消',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

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
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
