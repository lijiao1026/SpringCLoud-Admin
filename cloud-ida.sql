/*
Navicat MySQL Data Transfer

Source Server         : 百度云
Source Server Version : 50722
Source Host           : 180.76.115.105:3306
Source Database       : cloud-ida

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-18 14:25:44
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for ida_permission
-- ----------------------------
DROP TABLE IF EXISTS `ida_permission`;
CREATE TABLE `ida_permission` (
  `permission_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `permission_name` varchar(255) DEFAULT NULL,
  `permission_url` varchar(255) DEFAULT NULL,
  `parent_permission_id` int(11) DEFAULT NULL,
  `permission_lv` int(11) DEFAULT NULL,
  `permission_auth` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`permission_id`),
  UNIQUE KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ida_permission
-- ----------------------------
INSERT INTO `ida_permission` VALUES ('1', '用户管理', null, '0', '1', '');
INSERT INTO `ida_permission` VALUES ('2', '新增修改', '/user-post', '1', '2', 'upost');
INSERT INTO `ida_permission` VALUES ('3', '列表查询', '/user-get', '1', '2', 'uget');
INSERT INTO `ida_permission` VALUES ('4', '删除用户', '/user/{id}-delete', '1', '2', 'udelete');
INSERT INTO `ida_permission` VALUES ('5', '角色管理', null, '0', '1', '');
INSERT INTO `ida_permission` VALUES ('6', '新增修改', '/role-post', '5', '2', 'rpost');
INSERT INTO `ida_permission` VALUES ('7', '列表查询', '/role-get', '5', '2', 'rget');
INSERT INTO `ida_permission` VALUES ('8', '删除角色', '/role/{id}-delete', '5', '2', 'rdelete');
INSERT INTO `ida_permission` VALUES ('9', '角色授权', '/role-authorization-post', '5', '2', 'rauth');
INSERT INTO `ida_permission` VALUES ('10', '权限管理', null, '0', '1', '');
INSERT INTO `ida_permission` VALUES ('11', '新增修改', '/permission-post', '10', '2', 'ppost');
INSERT INTO `ida_permission` VALUES ('12', '列表查询', '/permission-get', '10', '2', 'pget');
INSERT INTO `ida_permission` VALUES ('13', '删除权限', '/permission/{id}-delete', '10', '2', 'pdelete');
INSERT INTO `ida_permission` VALUES ('14', '预览权限', '/permission-view-get', '10', '2', 'pview');
INSERT INTO `ida_permission` VALUES ('15', '菜单', null, '0', '1', '');
INSERT INTO `ida_permission` VALUES ('16', '标签取数', '/tag-index', '20', '2', 'tindex');
INSERT INTO `ida_permission` VALUES ('17', '模板取数', '/tag-fetch-data', '20', '2', 'tftemplet');
INSERT INTO `ida_permission` VALUES ('18', '客户群', '/tag-cluster', '20', '2', 'tcluster');
INSERT INTO `ida_permission` VALUES ('19', '常规标签配置', '/tag-simple', '20', '2', 'tsconfig');
INSERT INTO `ida_permission` VALUES ('20', '标签工厂', '/tag-factory', '20', '2', 'tfconfig');
INSERT INTO `ida_permission` VALUES ('21', 'tag服务权限控制', null, '0', '1', '');
INSERT INTO `ida_permission` VALUES ('22', '通过id获取用户信息', '/api-tag/tag/getUserById', '26', '2', 'tag:get');

-- ----------------------------
-- Table structure for ida_role
-- ----------------------------
DROP TABLE IF EXISTS `ida_role`;
CREATE TABLE `ida_role` (
  `role_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  UNIQUE KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ida_role
-- ----------------------------
INSERT INTO `ida_role` VALUES ('1', '用户管理员');
INSERT INTO `ida_role` VALUES ('2', '角色管理员');
INSERT INTO `ida_role` VALUES ('3', '权限管理员');
INSERT INTO `ida_role` VALUES ('4', '超级管理员');
INSERT INTO `ida_role` VALUES ('5', '测试222233');

-- ----------------------------
-- Table structure for ida_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `ida_role_permission`;
CREATE TABLE `ida_role_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ida_role_permission
-- ----------------------------
INSERT INTO `ida_role_permission` VALUES ('1', '4', '2');
INSERT INTO `ida_role_permission` VALUES ('2', '4', '3');
INSERT INTO `ida_role_permission` VALUES ('3', '4', '4');
INSERT INTO `ida_role_permission` VALUES ('4', '4', '6');
INSERT INTO `ida_role_permission` VALUES ('5', '4', '7');
INSERT INTO `ida_role_permission` VALUES ('6', '4', '8');
INSERT INTO `ida_role_permission` VALUES ('7', '4', '9');
INSERT INTO `ida_role_permission` VALUES ('8', '4', '11');
INSERT INTO `ida_role_permission` VALUES ('9', '4', '12');
INSERT INTO `ida_role_permission` VALUES ('10', '4', '13');
INSERT INTO `ida_role_permission` VALUES ('11', '4', '14');
INSERT INTO `ida_role_permission` VALUES ('12', '1', '1');
INSERT INTO `ida_role_permission` VALUES ('13', '1', '2');
INSERT INTO `ida_role_permission` VALUES ('14', '4', '22');
INSERT INTO `ida_role_permission` VALUES ('15', '4', '16');
INSERT INTO `ida_role_permission` VALUES ('16', '4', '17');
INSERT INTO `ida_role_permission` VALUES ('17', '4', '18');
INSERT INTO `ida_role_permission` VALUES ('18', '4', '19');
INSERT INTO `ida_role_permission` VALUES ('19', '4', '20');
INSERT INTO `ida_role_permission` VALUES ('20', '5', '7');
INSERT INTO `ida_role_permission` VALUES ('21', '5', '8');

-- ----------------------------
-- Table structure for ida_user
-- ----------------------------
DROP TABLE IF EXISTS `ida_user`;
CREATE TABLE `ida_user` (
  `user_id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_name` varchar(255) DEFAULT NULL,
  `user_role_names` varchar(255) DEFAULT NULL,
  `user_account` varchar(255) DEFAULT NULL,
  `user_password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_id` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ida_user
-- ----------------------------
INSERT INTO `ida_user` VALUES ('1', '李骄', '超级管理员', 'admin', '123456');
INSERT INTO `ida_user` VALUES ('2', '用户管理员', '用户管理员', 'user', '123456');

-- ----------------------------
-- Table structure for ida_user_role
-- ----------------------------
DROP TABLE IF EXISTS `ida_user_role`;
CREATE TABLE `ida_user_role` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ida_user_role
-- ----------------------------
INSERT INTO `ida_user_role` VALUES ('2', '2', '1');
INSERT INTO `ida_user_role` VALUES ('4', '12', '2');
INSERT INTO `ida_user_role` VALUES ('5', '11', '2');
INSERT INTO `ida_user_role` VALUES ('6', '1', '4');
