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

 Date: 27/10/2023 16:19:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for query_history
-- ----------------------------
DROP TABLE IF EXISTS `query_history`;
CREATE TABLE `query_history`  (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '购物车记录的唯一标识',
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户 ID，与用户表相关联',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品 ID，与产品表相关联',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted_at` datetime NULL DEFAULT NULL COMMENT '删除时间',
  `updated_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `id1` bigint NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of query_history
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
