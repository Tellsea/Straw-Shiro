/*
 Navicat Premium Data Transfer

 Source Server         : 127.0.0.1
 Source Server Type    : MySQL
 Source Server Version : 50713
 Source Host           : 127.0.0.1:3306
 Source Schema         : straw_shiro

 Target Server Type    : MySQL
 Target Server Version : 50713
 File Encoding         : 65001

 Date: 04/04/2021 17:01:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for login_log
-- ----------------------------
DROP TABLE IF EXISTS `login_log`;
CREATE TABLE `login_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `device` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '登录设备',
  `code` int(11) NULL DEFAULT NULL COMMENT '状态码',
  `message` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '消息',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 102 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of login_log
-- ----------------------------
INSERT INTO `login_log` VALUES (4, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-04 16:13:30', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (23, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-10 12:43:52', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (24, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-10 12:43:52', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (25, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:54:47', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (26, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:55:12', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (27, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 19:59:36', 'Chrome -- Windows 10', 200, '用户不存在');
INSERT INTO `login_log` VALUES (28, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 20:03:50', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (29, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 20:04:30', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (30, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 21:59:32', 'Chrome -- Windows 10', 500, '用户不存在');
INSERT INTO `login_log` VALUES (31, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:01:03', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (32, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:01:13', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (33, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:07:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (34, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-08-11 22:10:16', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (35, 1, '192.168.1.105', '0|0|0|内网IP|内网IP', '2019-08-11 22:23:49', 'Chrome -- Windows 10Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (36, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:52:21', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (37, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:54:29', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (38, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 13:56:46', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (39, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:03:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (40, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:04:17', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (41, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:06:14', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (42, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:07:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (43, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:09:27', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (44, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:09:36', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (45, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:52:16', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (46, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-04 14:52:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (47, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 09:15:00', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (48, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 10:15:50', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (49, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 11:41:18', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (50, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 11:46:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (51, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 14:57:38', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (52, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:20:53', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (53, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:24:36', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (54, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:28:56', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (55, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:32:25', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (56, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:34:15', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (57, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:42:22', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (58, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:43:47', 'Chrome -- Windows 10', 500, '验证码错误');
INSERT INTO `login_log` VALUES (59, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:46:35', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (60, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:46:55', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (61, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-05 15:50:51', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (62, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:41:23', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (63, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:43:21', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (64, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:48:21', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (65, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:50:57', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (66, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 11:59:09', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (67, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:01:05', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (68, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:04:37', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (69, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 12:07:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (70, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-06 22:16:33', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (71, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-07 12:14:49', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (72, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-09 15:02:57', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (73, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-09 15:05:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (74, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 15:38:54', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (75, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:04:35', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (76, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:05:29', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (77, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:21:48', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (78, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:23:53', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (79, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:39:37', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (80, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:41:06', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (81, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-11 16:50:26', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (82, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-17 21:25:07', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (83, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-20 20:52:51', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (84, 1, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-09-23 09:35:50', 'Chrome -- Windows 10', 200, 'OK');
INSERT INTO `login_log` VALUES (95, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2019-12-24 23:01:35', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (96, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-01-01 11:14:01', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (97, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-01-01 11:38:12', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (98, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-01-01 13:25:47', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (99, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-02-26 12:04:44', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (100, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-02-28 15:36:55', 'Chrome -- Windows 10', 200, '登录成功');
INSERT INTO `login_log` VALUES (101, NULL, '127.0.0.1', '0|0|0|内网IP|内网IP', '2020-04-18 14:11:47', 'Chrome -- Windows 10', 200, '登录成功');

-- ----------------------------
-- Table structure for map_role_resource
-- ----------------------------
DROP TABLE IF EXISTS `map_role_resource`;
CREATE TABLE `map_role_resource`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  `resource_id` int(11) NOT NULL COMMENT '菜单/按钮ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 262 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色资源关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_role_resource
-- ----------------------------
INSERT INTO `map_role_resource` VALUES (164, 7, 1);
INSERT INTO `map_role_resource` VALUES (165, 7, 3);
INSERT INTO `map_role_resource` VALUES (166, 7, 4);
INSERT INTO `map_role_resource` VALUES (167, 7, 10);
INSERT INTO `map_role_resource` VALUES (168, 7, 5);
INSERT INTO `map_role_resource` VALUES (169, 7, 17);
INSERT INTO `map_role_resource` VALUES (170, 7, 6);
INSERT INTO `map_role_resource` VALUES (171, 7, 20);
INSERT INTO `map_role_resource` VALUES (217, 3, 1);
INSERT INTO `map_role_resource` VALUES (218, 3, 3);
INSERT INTO `map_role_resource` VALUES (219, 3, 7);
INSERT INTO `map_role_resource` VALUES (220, 3, 22);
INSERT INTO `map_role_resource` VALUES (221, 3, 23);
INSERT INTO `map_role_resource` VALUES (222, 3, 24);
INSERT INTO `map_role_resource` VALUES (223, 3, 25);
INSERT INTO `map_role_resource` VALUES (224, 3, 26);
INSERT INTO `map_role_resource` VALUES (225, 1, 1);
INSERT INTO `map_role_resource` VALUES (226, 1, 2);
INSERT INTO `map_role_resource` VALUES (227, 1, 3);
INSERT INTO `map_role_resource` VALUES (228, 1, 4);
INSERT INTO `map_role_resource` VALUES (229, 1, 8);
INSERT INTO `map_role_resource` VALUES (230, 1, 9);
INSERT INTO `map_role_resource` VALUES (231, 1, 10);
INSERT INTO `map_role_resource` VALUES (232, 1, 11);
INSERT INTO `map_role_resource` VALUES (233, 1, 12);
INSERT INTO `map_role_resource` VALUES (234, 1, 13);
INSERT INTO `map_role_resource` VALUES (235, 1, 27);
INSERT INTO `map_role_resource` VALUES (236, 1, 28);
INSERT INTO `map_role_resource` VALUES (237, 1, 5);
INSERT INTO `map_role_resource` VALUES (238, 1, 14);
INSERT INTO `map_role_resource` VALUES (239, 1, 15);
INSERT INTO `map_role_resource` VALUES (240, 1, 16);
INSERT INTO `map_role_resource` VALUES (241, 1, 17);
INSERT INTO `map_role_resource` VALUES (242, 1, 6);
INSERT INTO `map_role_resource` VALUES (243, 1, 18);
INSERT INTO `map_role_resource` VALUES (244, 1, 19);
INSERT INTO `map_role_resource` VALUES (245, 1, 20);
INSERT INTO `map_role_resource` VALUES (246, 1, 21);
INSERT INTO `map_role_resource` VALUES (247, 1, 7);
INSERT INTO `map_role_resource` VALUES (248, 1, 22);
INSERT INTO `map_role_resource` VALUES (249, 1, 23);
INSERT INTO `map_role_resource` VALUES (250, 1, 24);
INSERT INTO `map_role_resource` VALUES (251, 1, 25);
INSERT INTO `map_role_resource` VALUES (252, 1, 26);
INSERT INTO `map_role_resource` VALUES (253, 2, 1);
INSERT INTO `map_role_resource` VALUES (254, 2, 3);
INSERT INTO `map_role_resource` VALUES (255, 2, 4);
INSERT INTO `map_role_resource` VALUES (256, 2, 8);
INSERT INTO `map_role_resource` VALUES (257, 2, 9);
INSERT INTO `map_role_resource` VALUES (258, 2, 10);
INSERT INTO `map_role_resource` VALUES (259, 2, 12);
INSERT INTO `map_role_resource` VALUES (260, 2, 13);
INSERT INTO `map_role_resource` VALUES (261, 2, 28);

-- ----------------------------
-- Table structure for map_user_role
-- ----------------------------
DROP TABLE IF EXISTS `map_user_role`;
CREATE TABLE `map_user_role`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `user_id` int(11) NOT NULL COMMENT '用户ID',
  `role_id` int(11) NOT NULL COMMENT '角色ID',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户角色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of map_user_role
-- ----------------------------
INSERT INTO `map_user_role` VALUES (10, 1, 1);
INSERT INTO `map_user_role` VALUES (11, 2, 2);
INSERT INTO `map_user_role` VALUES (12, 4, 7);
INSERT INTO `map_user_role` VALUES (15, 3, 3);

-- ----------------------------
-- Table structure for resource_info
-- ----------------------------
DROP TABLE IF EXISTS `resource_info`;
CREATE TABLE `resource_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '资源编号',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '资源名称',
  `pid` int(11) NULL DEFAULT 0 COMMENT '父级ID',
  `url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'URL',
  `perms` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL COMMENT '权限标识',
  `type` int(11) NOT NULL DEFAULT 0 COMMENT '0 未使用 1 菜单 2 按钮 3 链接',
  `icon` varchar(30) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '菜单图标',
  `sort` int(11) NULL DEFAULT 0 COMMENT '排序',
  `is_visible` tinyint(1) NULL DEFAULT 0 COMMENT '是否可见 1-是 2-否',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1-正常 2-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 29 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource_info
-- ----------------------------
INSERT INTO `resource_info` VALUES (1, '权限管理系统', 0, '/home', NULL, 1, '', 0, 1, 1, '2021-04-02 09:07:45', 1);
INSERT INTO `resource_info` VALUES (2, '首页', 1, '/home', NULL, 1, 'fa-home', 0, 1, 1, '2021-04-02 09:07:45', 1);
INSERT INTO `resource_info` VALUES (3, '系统管理', 1, '', NULL, 1, 'fa-gears', 0, 1, 1, '2021-04-04 11:00:45', 1);
INSERT INTO `resource_info` VALUES (4, '用户管理', 3, '/system/userInfo/init', 'system:userInfo:view', 1, 'fa-group', 0, 1, 1, '2021-04-04 14:10:29', 1);
INSERT INTO `resource_info` VALUES (5, '角色管理', 3, '/system/roleInfo/init', 'system:roleInfo:view', 1, 'fa-check', 0, 1, 1, '2021-04-04 14:10:36', 1);
INSERT INTO `resource_info` VALUES (6, '菜单管理', 3, '/system/resourceInfo/init', 'system:resourceInfo:view', 1, 'fa-reorder', 0, 1, 1, '2021-04-04 14:10:43', 1);
INSERT INTO `resource_info` VALUES (7, '日志管理(未写)', 3, '/system/logInfo/init', 'system:logInfo:view', 1, 'fa-calendar', 0, 1, 1, '2021-04-04 16:00:30', 1);
INSERT INTO `resource_info` VALUES (8, '新增用户', 4, NULL, 'system:userInfo:save', 2, '', 0, 1, 1, '2021-04-04 13:33:30', 1);
INSERT INTO `resource_info` VALUES (9, '更新用户', 4, NULL, 'system:userInfo:update', 2, '', 0, 1, 1, '2021-04-02 09:14:53', 1);
INSERT INTO `resource_info` VALUES (10, '查询用户', 4, NULL, 'system:userInfo:list', 2, '', 0, 1, 1, '2021-04-02 09:14:56', 1);
INSERT INTO `resource_info` VALUES (11, '删除用户', 4, NULL, 'system:userInfo:delete', 2, '', 0, 1, 1, '2021-04-02 09:14:57', 1);
INSERT INTO `resource_info` VALUES (12, '导入用户', 4, NULL, 'system:userInfo:import', 2, NULL, 0, 1, 1, '2021-04-02 09:14:59', 1);
INSERT INTO `resource_info` VALUES (13, '导出用户', 4, NULL, 'system:userInfo:export', 2, NULL, 0, 1, 1, '2021-04-02 09:15:01', 1);
INSERT INTO `resource_info` VALUES (14, '新增角色', 5, NULL, 'system:roleInfo:save', 2, '', 0, 1, 1, '2021-04-04 13:33:36', 1);
INSERT INTO `resource_info` VALUES (15, '更新角色', 5, NULL, 'system:roleInfo:update', 2, '', 0, 1, 1, '2021-04-02 09:15:07', 1);
INSERT INTO `resource_info` VALUES (16, '查询角色', 5, NULL, 'system:roleInfo:list', 2, '', 0, 1, 1, '2021-04-02 09:15:09', 1);
INSERT INTO `resource_info` VALUES (17, '删除角色', 5, NULL, 'system:roleInfo:delete', 2, '', 0, 1, 1, '2021-04-02 09:15:11', 1);
INSERT INTO `resource_info` VALUES (18, '新增菜单', 6, NULL, 'system:resourceInfo:save', 2, '', 0, 1, 1, '2021-04-04 15:45:52', 1);
INSERT INTO `resource_info` VALUES (19, '更新菜单', 6, NULL, 'system:resourceInfo:update', 2, '', 0, 1, 1, '2021-04-02 09:15:14', 1);
INSERT INTO `resource_info` VALUES (20, '查询菜单', 6, NULL, 'system:resourceInfo:list', 2, '', 0, 1, 1, '2021-04-02 09:15:17', 1);
INSERT INTO `resource_info` VALUES (21, '删除菜单', 6, NULL, 'system:resourceInfo:delete', 2, '', 0, 1, 1, '2021-04-02 09:15:19', 1);
INSERT INTO `resource_info` VALUES (22, '查询日志', 7, NULL, 'system:logInfo:list', 2, '', 0, 1, 1, '2021-04-02 09:21:23', 1);
INSERT INTO `resource_info` VALUES (23, '删除日志', 7, NULL, 'system:logInfo:delete', 2, '', 0, 1, 1, '2021-04-02 09:26:08', 1);
INSERT INTO `resource_info` VALUES (24, '开发工具', 1, '', 'dev:tool:view', 1, 'fa-anchor', 0, 1, 1, '2021-04-04 11:24:04', 1);
INSERT INTO `resource_info` VALUES (25, 'Druid监控', 24, '/druid', 'dev:tool:druid', 1, 'fa-building-o', 0, 1, 1, '2021-04-03 21:29:00', 1);
INSERT INTO `resource_info` VALUES (26, 'Swagger文档', 24, '/doc.html', 'dev:tool:swagger', 1, 'fa-sitemap', 0, 1, 1, '2021-04-03 21:30:58', 1);
INSERT INTO `resource_info` VALUES (27, '重置密码', 4, '', 'system:userInfo:resetPwd', 2, 'fa-refresh', 0, 1, 1, '2021-04-03 23:09:57', 1);
INSERT INTO `resource_info` VALUES (28, '用户详情', 4, '', 'system:userInfo:detail', 2, 'fa-align-left', 0, 1, 1, '2021-04-04 15:46:38', 1);

-- ----------------------------
-- Table structure for role_info
-- ----------------------------
DROP TABLE IF EXISTS `role_info`;
CREATE TABLE `role_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '角色ID',
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '角色名称',
  `role` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '角色',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1-正常 2-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '角色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of role_info
-- ----------------------------
INSERT INTO `role_info` VALUES (1, '超级管理员', 'admin', '拥有所有权限', 1, '2021-04-04 15:42:02', 1);
INSERT INTO `role_info` VALUES (2, '系统管理员', 'system', '只有系统管理，并且不能删除与重置密码', 1, '2021-04-04 15:42:40', 1);
INSERT INTO `role_info` VALUES (3, '系统监控员', 'monitor', '日志管理、Druid监控、Swagger文档', 1, '2021-04-04 15:42:56', 1);
INSERT INTO `role_info` VALUES (4, 'test', 'test', 'test', 0, '2021-04-04 15:40:45', 2);
INSERT INTO `role_info` VALUES (5, 'test', 'test', 'test', 0, '2021-04-04 15:40:51', 2);
INSERT INTO `role_info` VALUES (7, '游客', 'visitor', '访客，只能查看，不能新增、编辑、删除', 1, '2021-04-04 15:41:46', 1);
INSERT INTO `role_info` VALUES (8, 'test啊', 'admin', '超级管理员，系统最高级权限', 1, '2021-04-01 17:48:34', 2);

-- ----------------------------
-- Table structure for system_log
-- ----------------------------
DROP TABLE IF EXISTS `system_log`;
CREATE TABLE `system_log`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `user_id` int(11) NULL DEFAULT 0 COMMENT '操作用户id',
  `operation` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作描述',
  `time` int(11) NULL DEFAULT 0 COMMENT '耗时(毫秒)',
  `method` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作方法',
  `params` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作参数',
  `ip` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT 'IP地址',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '操作时间',
  `location` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '操作地点',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '系统日志表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_log
-- ----------------------------
INSERT INTO `system_log` VALUES (1, 1, '新增用户', 3, 'saveUserInfo', 'UserInfo[\"userName\": \"tellsea\",\"password\":\"123456\"]', '127.0.0.1', '2019-12-21 22:25:57', '操作地点');

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info`  (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '用户名',
  `nick_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '账户，登录名，不可更改',
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '密码',
  `salt` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '盐值',
  `avatar` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '头像',
  `phone` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '手机',
  `sex` int(1) NULL DEFAULT 0 COMMENT '性别 1男 2女',
  `description` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '描述',
  `last_login_time` datetime(0) NULL DEFAULT NULL COMMENT '最后登录时间',
  `login_times` int(11) NULL DEFAULT 0 COMMENT '登录次数',
  `create_user` int(11) NULL DEFAULT 0 COMMENT '创建人',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `status` tinyint(1) NULL DEFAULT 0 COMMENT '状态 1-正常 2-删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_info
-- ----------------------------
INSERT INTO `user_info` VALUES (1, 'admin', '汤海鸿', 'e6e3a3f9c3ac0c31c53d07720e69d692', 'VKqvum8YW0xNaTDFbrcijhTG6wUP5xAZ', 'https://ss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=2562372298,495845374&fm=26&gp=0.jpg', '18386474459', 1, 'I am Iron Man', '2019-12-20 10:15:58', 12, 1, '2021-04-04 15:50:40', 1);
INSERT INTO `user_info` VALUES (2, 'tellsea', '小海绵', '44eb196feb810ee770047cc34da66133', 'V1D9h266hLYqYfF5DnZCjlJKyG3Gx36c', 'https://ss1.bdstatic.com/70cFvXSh_Q1YnxGkpoWK1HF6hhy/it/u=3041599764,2432042915&fm=26&gp=0.jpg', '15836541252', 1, '我不想打字', NULL, 0, 1, '2021-04-03 21:56:16', 1);
INSERT INTO `user_info` VALUES (3, 'monitor', '监控员', '221605ef8256bb0cfbbfa5fb7688eaf1', '2HI9EdHJjSYsfyqSdbWlXZRxJNXvFnrE', 'https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=584948523,1006436504&fm=26&gp=0.jpg', '15356521441', 2, '中二病晚期', NULL, 0, 1, '2021-04-04 15:50:12', 1);
INSERT INTO `user_info` VALUES (4, 'test', '测试', 'ca77996da6aa4879c139c42adae1e324', 'RwS5Y8B7jV8DJxomL8sC2EWXlcpkEywn', NULL, '18386465555', 1, '简介', NULL, 0, 1, '2021-04-03 23:00:11', 1);

SET FOREIGN_KEY_CHECKS = 1;
