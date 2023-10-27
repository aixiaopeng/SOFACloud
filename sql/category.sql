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

 Date: 27/10/2023 16:19:26
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for category
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category`  (
  `category_name` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '分类名称',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted_at` datetime NULL DEFAULT NULL COMMENT '删除时间',
  `updated_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `id` bigint NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('数码周边', '2023-10-22 05:22:22', NULL, '2023-10-22 05:22:22', 1);
INSERT INTO `category` VALUES ('珠宝首饰', '2023-10-22 05:42:42', NULL, '2023-10-22 05:42:42', 2);
INSERT INTO `category` VALUES ('美妆护肤', '2023-10-22 05:48:42', NULL, '2023-10-22 05:48:42', 3);
INSERT INTO `category` VALUES ('移动设备', '2023-10-22 05:48:52', NULL, '2023-10-22 05:48:52', 4);
INSERT INTO `category` VALUES ('运动户外', '2023-10-22 05:49:00', NULL, '2023-10-22 05:49:00', 5);
INSERT INTO `category` VALUES ('居家餐厅', '2023-10-22 05:49:07', NULL, '2023-10-22 05:49:07', 6);
INSERT INTO `category` VALUES ('办公文具', '2023-10-22 05:49:17', NULL, '2023-10-22 05:49:17', 7);
INSERT INTO `category` VALUES ('随便查查', '2023-10-25 06:53:59', NULL, '2023-10-25 06:53:59', 8);

SET FOREIGN_KEY_CHECKS = 1;
