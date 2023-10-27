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

 Date: 27/10/2023 16:19:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product`  (
  `name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品名称',
  `priority` int NULL DEFAULT NULL COMMENT '优先级',
  `category` bigint NULL DEFAULT NULL COMMENT '产品类别',
  `status` tinyint(1) NULL DEFAULT NULL COMMENT '产品状态 (0 = 无效, 1 = 有效)',
  `imgUrl` varchar(256) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '产品图片链接',
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
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '产品ID',
  `notes` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('欧莱雅绒雾唇霜口红', NULL, 3, 1, 'defult.jpg', '纷泽滋润细管唇膏#666炸场红 向红而生限定系列蓝调正红', 199.90, 255, 124, NULL, '2023-10-22 07:46:15', NULL, '2023-10-22 07:46:15', '2023-10-22 07:46:15', '2023-10-22 07:46:15', 1, NULL);
INSERT INTO `product` VALUES ('PRADA 普拉达', NULL, 3, 1, 'defult.jpg', '缨粉淑女女士淡香水 EDT 100ml东方花香调', 79.90, 52, 4, NULL, '2023-10-22 07:47:04', NULL, '2023-10-22 07:47:04', '2023-10-22 07:46:15', '2023-10-22 07:46:15', 2, NULL);
INSERT INTO `product` VALUES ('ESTĒE LAUDER 雅诗兰黛', NULL, 3, 1, 'defult.jpg', ' DW持妆粉底液无泵头款 30毫升 1N1遮瑕控油 油皮亲妈 欧洲', 529.00, 1225, 852, NULL, '2023-10-22 07:47:42', NULL, '2023-10-22 07:47:42', '2023-10-22 07:46:15', '2023-10-22 07:46:15', 3, NULL);
INSERT INTO `product` VALUES ('98年老玉', NULL, 2, 1, 'defult.jpg', '越带越温润，最合适不过', 1999.00, 12, 3, 199.90, '2023-10-22 07:50:53', NULL, '2023-10-22 07:50:53', '2023-10-22 07:50:53', '2023-12-22 07:50:53', 4, NULL);
INSERT INTO `product` VALUES ('钻石戒指', NULL, 2, 1, 'defult.jpg', '一生只给一人', 2399.00, 520, 4, 239.00, '2023-10-22 07:52:15', NULL, '2023-10-22 07:52:15', '2023-10-22 00:00:00', '2023-12-22 00:00:00', 5, NULL);
INSERT INTO `product` VALUES ('单反摄像机', 1, 1, 1, 'https://ts1.cn.mm.bing.net/th/id/R-C.0b8e03f8aa526b9f6345a20557f424e4?rik=rz%2bPHieB4JDTgA&riu=http%3a%2f%2fnews.mydrivers.com%2fImg%2f20100819%2f02400701.jpg&ehk=RMaAVErqVuHc5PhhLSnKIcSIRiJRXXil6keKfdCPCqM%3d&risl=&pid=ImgRaw&r=0', '记录生活，记录你的美', 5142.00, 71, 48, NULL, '2023-10-22 07:52:55', NULL, '2023-10-22 07:52:55', '2023-10-22 07:46:15', '2023-10-22 07:46:15', 6, NULL);
INSERT INTO `product` VALUES ('4090', 1, 1, 1, 'https://pic.clubic.com/v1/images/2042409/raw', '风扇呼呼吹，嘎嘎流畅', 1828.00, 45, 41, NULL, '2023-10-22 07:53:31', NULL, '2023-10-22 07:53:31', '2023-10-22 07:46:15', '2023-10-22 07:46:15', 7, NULL);
INSERT INTO `product` VALUES ('充电宝', 1, 4, 1, 'https://tse3-mm.cn.bing.net/th/id/OIP-C.-GmhKxM0rioSbCWIbDV7AwHaFu?pid=ImgDet&rs=1', '超级大功率，小巧可爱', 88.00, 63, 5, NULL, '2023-10-22 07:54:06', NULL, '2023-10-22 07:54:06', '2023-10-22 07:46:15', '2023-10-22 07:46:15', 8, NULL);
INSERT INTO `product` VALUES ('文具盒', NULL, 7, 1, 'defult.jpg', '给孩子买一个吧', 15.00, 48, 5, NULL, '2023-10-23 03:48:07', NULL, '2023-10-23 03:48:07', '2023-09-21 07:50:53', '2023-09-22 07:50:53', 9, NULL);
INSERT INTO `product` VALUES ('健身跑步机', NULL, 5, 1, 'defult.jpg', '跑出自律', 4185.00, 24, 7, NULL, '2023-10-23 06:35:01', NULL, '2023-10-23 06:35:01', '2023-10-23 06:35:01', '2023-10-23 06:35:01', 10, NULL);
INSERT INTO `product` VALUES ('欧莱雅绒雾唇霜口红', NULL, 3, 1, 'https://img.mall4j.com/2022/11/27f425e78b664c759a41d6d0671951b4.jpg', '纷泽滋润细管唇膏#666炸场红 向红而生限定系列蓝调正红', 199.00, 52, 42, NULL, '2023-10-25 06:42:36', NULL, '2023-10-25 06:42:36', '2023-10-25 06:42:36', '2023-10-25 06:42:36', 11, NULL);
INSERT INTO `product` VALUES ('COSME DECORTE黛珂水乳', NULL, 3, 1, 'https://img.mall4j.com/2022/03/5f6f885983d540bc8da0a9051f20b7e4.jpg', '高机能清痘爽肤水紫苏水150ml+牛油果乳液150ml', 199.00, 52, 74, NULL, '2023-10-25 06:45:36', NULL, '2023-10-25 06:45:36', '2023-10-25 06:45:36', '2023-10-25 06:45:36', 12, NULL);
INSERT INTO `product` VALUES ('GUERLAIN娇兰', NULL, 3, 1, 'https://img.mall4j.com/2022/03/6594615429ee4ee1b811be18e85e898d.jpg', '第三代帝皇蜂姿黄金修护复原蜜精华液50ml+蜜润修护精粹精华水', 299.00, 7528, 851, NULL, '2023-10-25 06:46:21', NULL, '2023-10-25 06:46:21', '2023-10-25 06:46:21', '2023-10-25 06:46:21', 13, NULL);
INSERT INTO `product` VALUES ('【盈润紧致】SHISEIDO', NULL, 3, 1, 'https://img.mall4j.com/2022/03/c4349f95cee7475b9c63ea8114bc04de.jpg', '资生堂 悦薇珀翡紧颜亮肤水乳套装 焕亮抗糖紧致', 299.00, 78, 51, NULL, '2023-10-25 06:47:00', NULL, '2023-10-25 06:47:00', '2023-10-25 06:47:00', '2023-10-25 06:47:00', 14, NULL);
INSERT INTO `product` VALUES ('ESTĒE LAUDER 雅诗兰黛', NULL, 3, 1, 'https://img.mall4j.com/2022/06/dc38d36cc8a14487a50cdb7bf279f12e.jpg', 'DW持妆粉底液无泵头款 30毫升 1N1遮瑕控油 油皮亲妈 欧洲', 299.00, 155, 48, NULL, '2023-10-25 06:47:34', NULL, '2023-10-25 06:47:34', '2023-10-25 06:47:34', '2023-10-25 06:47:34', 15, NULL);

SET FOREIGN_KEY_CHECKS = 1;
