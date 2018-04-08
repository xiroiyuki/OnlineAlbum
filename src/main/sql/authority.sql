/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50719
Source Host           : localhost:3306
Source Database       : album

Target Server Type    : MYSQL
Target Server Version : 50719
File Encoding         : 65001

Date: 2018-04-08 20:48:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for authority
-- ----------------------------
DROP TABLE IF EXISTS `authority`;
CREATE TABLE `authority` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(50) DEFAULT NULL COMMENT '权限元素名称',
  `url` varchar(200) DEFAULT NULL COMMENT '权限对应可访问地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8 COMMENT='权限表 粒度为URL';

-- ----------------------------
-- Records of authority
-- ----------------------------
INSERT INTO `authority` VALUES ('1', '更新用户', '/user/update');
INSERT INTO `authority` VALUES ('2', '列出用户', '/user/list');
INSERT INTO `authority` VALUES ('3', '查看用户详情', '/user/detail');
INSERT INTO `authority` VALUES ('4', '编辑用户', '/user/edit');
INSERT INTO `authority` VALUES ('5', '删除用户', '/user/delete');
INSERT INTO `authority` VALUES ('6', '更新相册', '/album/update');
INSERT INTO `authority` VALUES ('7', '删除相册', '/album/delete');
INSERT INTO `authority` VALUES ('8', '列出相册', '/album/list');
INSERT INTO `authority` VALUES ('9', '相册详情', '/album/detail');
INSERT INTO `authority` VALUES ('10', '相册刷新', '/album/refresh');
INSERT INTO `authority` VALUES ('11', '编辑相册', '/album/edit');
INSERT INTO `authority` VALUES ('12', '添加权限', '/authority/add');
INSERT INTO `authority` VALUES ('13', '更新权限', '/authority/update');
INSERT INTO `authority` VALUES ('14', '删除权限', '/authority/delete');
INSERT INTO `authority` VALUES ('15', '列出权限', '/authority/list');
INSERT INTO `authority` VALUES ('16', '插入权限', '/authority/insert');
INSERT INTO `authority` VALUES ('17', '权限详情', '/authority/detail');
INSERT INTO `authority` VALUES ('18', '编辑权限', '/authority/edit');
INSERT INTO `authority` VALUES ('19', '登录界面', '/login');
INSERT INTO `authority` VALUES ('20', '欢迎界面', '/welcome');
INSERT INTO `authority` VALUES ('21', '工作台', '/workbench');
INSERT INTO `authority` VALUES ('22', '添加消息', '/message/add');
INSERT INTO `authority` VALUES ('23', '更新消息', '/message/update');
INSERT INTO `authority` VALUES ('24', '删除消息', '/message/delete');
INSERT INTO `authority` VALUES ('25', '列出消息', '/message/list');
INSERT INTO `authority` VALUES ('26', '插入消息', '/message/insert');
INSERT INTO `authority` VALUES ('27', '消息详情', '/message/detail');
INSERT INTO `authority` VALUES ('28', '编辑消息', '/message/edit');
INSERT INTO `authority` VALUES ('29', '更新图片', '/photo/update');
INSERT INTO `authority` VALUES ('30', '删除图片', '/photo/delete');
INSERT INTO `authority` VALUES ('31', '图片详情 ', '/photo/detail');
INSERT INTO `authority` VALUES ('32', '编辑图片信息', '/photo/edit');
INSERT INTO `authority` VALUES ('33', '添加角色', '/role/add');
INSERT INTO `authority` VALUES ('34', '更新角色', '/role/update');
INSERT INTO `authority` VALUES ('35', '删除角色', '/role/delete');
INSERT INTO `authority` VALUES ('36', '列出角色', '/role/list');
INSERT INTO `authority` VALUES ('37', '插入角色', '/role/insert');
INSERT INTO `authority` VALUES ('38', '角色详情', '/role/detail');
INSERT INTO `authority` VALUES ('39', '编辑角色', '/role/edit');
INSERT INTO `authority` VALUES ('40', '更新来源', '/source/update');
INSERT INTO `authority` VALUES ('41', '删除来源 ', '/source/delete');
INSERT INTO `authority` VALUES ('42', '列出来源', '/source/list');
INSERT INTO `authority` VALUES ('43', '来源详情', '/source/detail');
INSERT INTO `authority` VALUES ('44', '编辑来源', '/source/edit');
INSERT INTO `authority` VALUES ('50', '登录', '/user/login.do');
