/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : onlineshop

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 12/11/2019 11:39:33
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for t_admin
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin`  (
  `aid` int(10) NOT NULL AUTO_INCREMENT,
  `aname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `apassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`aid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_admin
-- ----------------------------
INSERT INTO `t_admin` VALUES (2, '易艳钟', '123456700');

-- ----------------------------
-- Table structure for t_catalog
-- ----------------------------
DROP TABLE IF EXISTS `t_catalog`;
CREATE TABLE `t_catalog`  (
  `cid` int(10) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`cid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_catalog
-- ----------------------------
INSERT INTO `t_catalog` VALUES (1, '小米');
INSERT INTO `t_catalog` VALUES (2, '华为');
INSERT INTO `t_catalog` VALUES (3, 'vivo');
INSERT INTO `t_catalog` VALUES (4, 'OPPO');

-- ----------------------------
-- Table structure for t_item
-- ----------------------------
DROP TABLE IF EXISTS `t_item`;
CREATE TABLE `t_item`  (
  `itemId` int(10) NOT NULL AUTO_INCREMENT,
  `itemName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `cid` int(10) NULL DEFAULT NULL,
  `itemProductor` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `itemPhoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `itemIntro` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `priceVip` float(10, 2) NULL DEFAULT NULL,
  `priceNormal` float(10, 2) NULL DEFAULT NULL,
  `itemNum` int(10) NULL DEFAULT NULL,
  `itemTolNum` int(10) NULL DEFAULT NULL,
  `itemState` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`itemId`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_item
-- ----------------------------
INSERT INTO `t_item` VALUES (1, '小米8青春版', 1, '小米1', 'liebiao_xiaomi6.jpg', '青春版全面屏智能拍照手机学生机', 2222.00, 2999.00, 1995, 1, '0');
INSERT INTO `t_item` VALUES (2, '小米8', 1, '小米', 'liebiao_xiaomi6.jpg', '年度旗舰全面屏骁龙845智能拍照游戏手机', 2299.00, 2499.00, 1998, 1, '0');
INSERT INTO `t_item` VALUES (3, '小米 MIX3', 1, '小米', 'liebiao_xiaomi6.jpg', '8周年全面屏双卡青春全网通', 899.00, 1099.00, 1995, 1, '0');
INSERT INTO `t_item` VALUES (4, '小米 Max3', 1, '小米', 'liebiao_xiaomi6.jpg', '全面屏大屏大电量游戏手机智能拍照', 1699.00, 1899.00, 1999, 1, '0');
INSERT INTO `t_item` VALUES (5, '华为 Mate20', 2, '华为', 'liebiao_xiaomi6.jpg', '全面屏珍珠屏超大广角徕卡三镜', 4099.00, 4499.00, 3000, 1, '0');
INSERT INTO `t_item` VALUES (6, '华为 P20Pro', 2, '华为', 'liebiao_xiaomi6.jpg', '全面屏刘海屏徕卡三摄旗舰', 4988.00, 5288.00, 2999, 1, '0');
INSERT INTO `t_item` VALUES (7, '华为 nova3', 2, '华为', 'liebiao_xiaomi6.jpg', '全面屏高清官方正品', 2599.00, 2799.00, 3000, 1, '0');
INSERT INTO `t_item` VALUES (8, '华为 mate10Pro', 2, '华为', 'liebiao_xiaomi6.jpg', '全面屏后置徕卡双镜头旗舰', 3599.00, 3799.00, 3000, 1, '0');
INSERT INTO `t_item` VALUES (9, 'vivo NEX', 3, 'vivo', 'liebiao_xiaomi6.jpg', '全面屏升降摄像头6G大运存全网通', 3499.00, 3699.00, 2500, 1, '0');
INSERT INTO `t_item` VALUES (10, 'vivo X23', 3, 'vivo', 'liebiao_xiaomi6.jpg', '水滴全面屏拍照超大广角智能4G限量版', 2999.00, 3199.00, 2500, 1, '0');
INSERT INTO `t_item` VALUES (11, 'vivo Z3', 3, 'vivo', 'liebiao_xiaomi6.jpg', '水滴全面屏高通骁龙710AIE处理器全网通', 1999.00, 2199.00, 2499, 1, '0');
INSERT INTO `t_item` VALUES (12, 'vivo Y85', 3, 'vivo', 'liebiao_xiaomi6.jpg', '全面屏双摄4G全网通版', 1299.00, 1599.00, 2500, 1, '0');
INSERT INTO `t_item` VALUES (13, 'OPPO Find X', 4, 'OPPO', 'liebiao_xiaomi6.jpg', '超级闪充版全网通OPPOfindx拍照手机', 5099.00, 5499.00, 3000, 1, '0');
INSERT INTO `t_item` VALUES (14, 'OPPO R17 Pro', 4, 'OPPO', 'liebiao_xiaomi6.jpg', '全面屏新年版拍照手机屏幕指纹解锁', 4599.00, 4999.00, 3000, 1, '0');
INSERT INTO `t_item` VALUES (15, 'OPPO R17', 4, 'OPPO', 'liebiao_xiaomi6.jpg', '水滴屏全面屏拍照手机AI智能屏幕指纹美颜', 2999.00, 3199.00, 2999, 1, '0');

-- ----------------------------
-- Table structure for t_order
-- ----------------------------
DROP TABLE IF EXISTS `t_order`;
CREATE TABLE `t_order`  (
  `oid` int(10) NOT NULL AUTO_INCREMENT,
  `uid` int(10) NULL DEFAULT NULL,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `utel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iid` int(10) NULL DEFAULT NULL,
  `iname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `iprice` float(10, 2) NULL DEFAULT NULL,
  `inumber` int(10) NULL DEFAULT NULL,
  `isum` float(10, 2) NULL DEFAULT NULL,
  `iphoto` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oshopDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oisSend` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `osendDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oisReceive` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `oreceiveDate` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`oid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_order
-- ----------------------------
INSERT INTO `t_order` VALUES (3, 0, 'aa', '13388882222', '湖北省襄阳市', 15, 'OPPO R17', 3199.00, 1, 3199.00, NULL, '2019-3-2 15:05:23', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (4, 0, 'aa', '13388882222', '湖北省襄阳市', 1, '小米8青春版', 2999.00, 2, 5998.00, 'liebiao_xiaomi6.jpg', '2019-3-2 15:05:23', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (5, 0, 'aa', '13388882222', '湖北省襄阳市', 2, '小米8', 2499.00, 1, 2499.00, 'liebiao_hongmin4_dd.jpg', '2019-3-2 15:07:33', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (6, 0, 'aa', '13344441111', '湖北省襄阳市隆中', 6, '华为 P20Pro', 5288.00, 1, 5288.00, NULL, '2019-3-2 15:41:46', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (7, 0, 'aa', '13344441111', '湖北省襄阳市隆中', 11, 'vivo Z3', 2199.00, 1, 2199.00, NULL, '2019-3-2 15:41:46', '0', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (8, 0, 'aa', '13388881111', '湖北省襄阳市', 1, '小米8青春版', 2999.00, 2, 5998.00, 'liebiao_hongmin4_dd.jpg', '2019-3-2 16:45:59', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (9, 0, 'aa', '13388881111', '湖北省襄阳市', 3, '小米 MIX3', 1099.00, 5, 5495.00, 'liebiao_xiaomi6.jpg', '2019-3-2 16:45:59', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (10, 0, 'aa', '13388881111', '湖北省襄阳市', 1, '小米8青春版', 2999.00, 1, 2999.00, 'liebiao_xiaomi6.jpg', '2019-11-12 11:22:47', '1', NULL, '1', NULL);
INSERT INTO `t_order` VALUES (11, 0, 'aa', '13388881111', '湖北省襄阳市', 2, '小米8', 2499.00, 1, 2499.00, 'liebiao_xiaomi6.jpg', '2019-11-12 11:22:47', '1', NULL, '1', NULL);

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user`  (
  `uid` int(10) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `utureName` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `upassword` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `uidentity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uemail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uaddress` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uquestion` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uanswer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uzipCode` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `utel` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uvip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `uregTime` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`uid`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES (1, 'aa', '易艳钟', '12345678', '421022199808083022', '1533715166@qq.com', '湖北省襄阳市', NULL, NULL, NULL, '13388881111', '0', NULL);
INSERT INTO `t_user` VALUES (3, 'cc', '杨萧', '12345678', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

SET FOREIGN_KEY_CHECKS = 1;
