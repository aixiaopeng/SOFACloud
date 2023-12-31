/*
 Navicat Premium Data Transfer

 Source Server         : 本机
 Source Server Type    : MySQL
 Source Server Version : 80032
 Source Host           : localhost:3306
 Source Schema         : PRD

 Target Server Type    : MySQL
 Target Server Version : 80032
 File Encoding         : 65001

 Date: 27/10/2023 16:20:05
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `password` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `addr` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地址',
  `phone` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话号码',
  `role` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '状态 (0 - 禁用, 1 - 启用)',
  `created_at` datetime NULL DEFAULT NULL COMMENT '创建时间',
  `deleted_at` datetime NULL DEFAULT NULL COMMENT '删除时间',
  `updated_at` datetime NULL DEFAULT NULL COMMENT '更新时间',
  `name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `is_deleted` tinyint(1) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'manager', '$2a$10$pnvBV0YrMY8vUxTp/6X1euT0WRS5a30o80ofe0x8fRQ1X1X6QNrh6', '开福区长沙大学', '156666666666', 'manager', NULL, '2023-10-22 07:47:04', NULL, '2023-10-22 07:47:04', '店员小二', NULL);
INSERT INTO `users` VALUES (2, 'supervisor', '$2a$10$pnvBV0YrMY8vUxTp/6X1euT0WRS5a30o80ofe0x8fRQ1X1X6QNrh6', '中国上海奉贤区', '00000000000', 'supervisor', NULL, '2023-10-22 07:47:04', NULL, '2023-10-22 07:47:04', '超级管理员', NULL);
INSERT INTO `users` VALUES (3, 'public', '$2a$10$pnvBV0YrMY8vUxTp/6X1euT0WRS5a30o80ofe0x8fRQ1X1X6QNrh6', '中国北京朝阳区', '11111111111', 'public', NULL, NULL, NULL, NULL, '普通用户', NULL);

SET FOREIGN_KEY_CHECKS = 1;
