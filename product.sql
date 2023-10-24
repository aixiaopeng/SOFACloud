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

 Date: 24/10/2023 15:47:34
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `id` bigint NOT NULL COMMENT '产品ID',
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称',
  `priority` int NULL DEFAULT NULL COMMENT '优先级',
  `category` bigint NULL DEFAULT NULL COMMENT '产品类别',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '产品状态 (0 = 无效, 1 = 有效)',
  `imgUrl` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品图片链接',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '产品描述',
  `price` decimal(16, 2) NULL DEFAULT NULL COMMENT '产品价格',
  `num` int NULL DEFAULT NULL COMMENT '产品数量',
  `sold` int NULL DEFAULT NULL COMMENT '已售数量',
  `discount_price` decimal(16, 2) NULL DEFAULT NULL COMMENT '折扣后\r\n',
  `created_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `deleted_at` datetime NULL DEFAULT NULL COMMENT '删除时间',
  `updated_at` datetime NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `discount_begin` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  `discount_end` datetime NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES (1715997983137398786, '欧莱雅绒雾唇霜口红', NULL, 1715968401084522498, NULL, 'defult.jpg', '纷泽滋润细管唇膏#666炸场红 向红而生限定系列蓝调正红', 199.90, 255, 124, NULL, '2023-10-22 07:46:15', NULL, '2023-10-22 07:46:15', '2023-10-22 07:46:15', '2023-10-22 07:46:15');
INSERT INTO `product` VALUES (1715998190239547394, 'PRADA 普拉达', NULL, 1715968401084522498, NULL, 'defult.jpg', '缨粉淑女女士淡香水 EDT 100ml东方花香调', 79.90, 52, 4, NULL, '2023-10-22 07:47:04', NULL, '2023-10-22 07:47:04', '2023-10-22 07:46:15', '2023-10-22 07:46:15');
INSERT INTO `product` VALUES (1715998345936306177, 'ESTĒE LAUDER 雅诗兰黛', NULL, 1715968401084522498, NULL, 'defult.jpg', ' DW持妆粉底液无泵头款 30毫升 1N1遮瑕控油 油皮亲妈 欧洲', 529.00, 1225, 852, NULL, '2023-10-22 07:47:42', NULL, '2023-10-22 07:47:42', '2023-10-22 07:46:15', '2023-10-22 07:46:15');
INSERT INTO `product` VALUES (1715999147853676546, '98年老玉', NULL, 1715966890162003969, NULL, 'defult.jpg', '越带越温润，最合适不过', 1999.00, 12, 3, 199.90, '2023-10-22 07:50:53', NULL, '2023-10-22 07:50:53', '2023-10-22 07:50:53', '2023-12-22 07:50:53');
INSERT INTO `product` VALUES (1715999494370295810, '钻石戒指', NULL, 1715966890162003969, NULL, 'defult.jpg', '一生只给一人', 2399.00, 520, 4, 239.00, '2023-10-22 07:52:15', NULL, '2023-10-22 07:52:15', '2023-10-22 00:00:00', '2023-12-22 00:00:00');
INSERT INTO `product` VALUES (1715999660502482945, '单反摄像机', 1, 1715961774218457090, NULL, 'defult.jpg', '记录生活，记录你的美', 5142.00, 71, 48, NULL, '2023-10-22 07:52:55', NULL, '2023-10-22 07:52:55', '2023-10-22 07:46:15', '2023-10-22 07:46:15');
INSERT INTO `product` VALUES (1715999809916174338, '4090', 1, 1715961774218457090, NULL, 'defult.jpg', '风扇呼呼吹，嘎嘎流畅', 1828.00, 45, 41, NULL, '2023-10-22 07:53:31', NULL, '2023-10-22 07:53:31', '2023-10-22 07:46:15', '2023-10-22 07:46:15');
INSERT INTO `product` VALUES (1715999959220813825, '充电宝', NULL, 1715968440850718721, NULL, 'defult.jpg', '超级大功率，小巧可爱', 88.00, 63, 5, NULL, '2023-10-22 07:54:06', NULL, '2023-10-22 07:54:06', '2023-10-22 07:46:15', '2023-10-22 07:46:15');
INSERT INTO `product` VALUES (1716300443034923009, '文具盒', NULL, 1715968548061323265, NULL, 'defult.jpg', '给孩子买一个吧', 15.00, 48, 5, NULL, '2023-10-23 03:48:07', NULL, '2023-10-23 03:48:07', '2023-09-21 07:50:53', '2023-09-22 07:50:53');
INSERT INTO `product` VALUES (1716342444207964162, '健身跑步机', NULL, 1715968477211140097, NULL, 'defult.jpg', '跑出自律', 4185.00, 24, 7, NULL, '2023-10-23 06:35:01', NULL, '2023-10-23 06:35:01', '2023-10-23 06:35:01', '2023-10-23 06:35:01');

SET FOREIGN_KEY_CHECKS = 1;
