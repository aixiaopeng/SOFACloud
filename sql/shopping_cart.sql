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

 Date: 27/10/2023 16:19:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart`  (
  `user_id` bigint NULL DEFAULT NULL COMMENT '用户 ID，与用户表相关联',
  `product_id` bigint NULL DEFAULT NULL COMMENT '产品 ID，与产品表相关联',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted_at` datetime NULL DEFAULT NULL COMMENT '删除时间',
  `updated_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `num` int NULL DEFAULT NULL COMMENT '商品数量',
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1717448492128768003 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------
INSERT INTO `shopping_cart` VALUES (1, 7, '2023-10-24 10:39:36', NULL, '2023-10-24 10:39:36', 6, 1);
INSERT INTO `shopping_cart` VALUES (2, 4, '2023-10-25 11:15:58', NULL, '2023-10-25 11:15:58', 4, 2);
INSERT INTO `shopping_cart` VALUES (1, 4, '2023-10-26 05:33:37', NULL, '2023-10-26 05:33:37', 16, 3);
INSERT INTO `shopping_cart` VALUES (1, 11, '2023-10-26 06:58:59', NULL, '2023-10-26 06:58:59', 1, 4);
INSERT INTO `shopping_cart` VALUES (3, 15, '2023-10-26 07:00:00', NULL, '2023-10-26 07:00:00', 2, 5);
INSERT INTO `shopping_cart` VALUES (3, 4, '2023-10-26 07:02:41', NULL, '2023-10-26 07:02:41', 16, 1717436570394189825);
INSERT INTO `shopping_cart` VALUES (3, 5, '2023-10-26 07:50:03', NULL, '2023-10-26 07:50:03', 32, 1717448492128768002);

SET FOREIGN_KEY_CHECKS = 1;
