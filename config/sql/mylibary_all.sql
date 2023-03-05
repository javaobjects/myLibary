/*
 Navicat Premium Data Transfer

 Source Server         : 本地localhost
 Source Server Type    : MySQL
 Source Server Version : 50527
 Source Host           : localhost:3306
 Source Schema         : mylibary

 Target Server Type    : MySQL
 Target Server Version : 50527
 File Encoding         : 65001

 Date: 05/03/2023 22:06:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for mylibary_book
-- ----------------------------
DROP TABLE IF EXISTS `mylibary_book`;
CREATE TABLE `mylibary_book`  (
  `BOOK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `BOOK_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `LEND_COUNT` int(3) NOT NULL,
  `STATUS` int(1) NOT NULL,
  PRIMARY KEY (`BOOK_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of mylibary_book
-- ----------------------------
BEGIN;
INSERT INTO `mylibary_book` VALUES (1, 'Java基础', 4, 1), (2, 'JS高级', 2, 1), (3, 'PHP入门', 6, 1), (4, 'Oracle基础', 1, 1), (5, 'vue入门', 4, 1), (6, '计算机基础', 5, 1), (7, '网络基础', 6, 1), (8, 'xshell', 4, 0), (9, 'git入门', 6, 1), (10, 'webpack配置', 9, 1), (11, 'CSS探密', 7, 1), (12, 'HTML5入门', 5, 1), (13, 'react入门', 5, 1), (14, 'Angular入门', 5, 1), (15, 'nodeJs入门', 6, 1), (16, 'mySql精讲', 10, 1), (17, 'Mongodb精讲', 10, 1), (18, 'ES6精讲', 14, 1), (19, 'spring入门', 23, 1), (20, 'mybaits入门', 15, 1);
COMMIT;

-- ----------------------------
-- Table structure for mylibary_record
-- ----------------------------
DROP TABLE IF EXISTS `mylibary_record`;
CREATE TABLE `mylibary_record`  (
  `RECORD_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_ID` int(6) NOT NULL,
  `BOOK_ID` int(6) NOT NULL,
  `LEND_TIME` datetime NULL,
  `RETURN_TIME` datetime NULL DEFAULT NULL,
  PRIMARY KEY (`RECORD_ID`) USING BTREE,
  INDEX `FK_MYLIBARY_BOOK_ID`(`BOOK_ID`) USING BTREE,
  INDEX `FK_MYLIBARY_USER_ID`(`USER_ID`) USING BTREE,
  CONSTRAINT `FK_MYLIBARY_BOOK_ID` FOREIGN KEY (`BOOK_ID`) REFERENCES `mylibary_book` (`BOOK_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `FK_MYLIBARY_USER_ID` FOREIGN KEY (`USER_ID`) REFERENCES `mylibary_user` (`USER_ID`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 37 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of mylibary_record
-- ----------------------------
BEGIN;
INSERT INTO `mylibary_record` VALUES (1, 1, 1, '2019-04-02 00:00:00', '2019-05-01 00:00:00'), (2, 1, 2, '2019-04-02 00:00:00', '2023-02-12 14:14:25'), (3, 1, 3, '2019-04-02 00:00:00', '2019-05-01 00:00:00'), (4, 1, 4, '2019-04-02 00:00:00', '2023-02-12 14:14:29'), (5, 1, 5, '2019-04-02 00:00:00', '2019-05-01 00:00:00'), (6, 1, 6, '2019-04-02 00:00:00', '2019-05-01 00:00:00'), (7, 1, 7, '2019-04-02 00:00:00', '2019-05-01 00:00:00'), (8, 1, 8, '2019-04-02 00:00:00', '2019-05-01 00:00:00'), (9, 2, 9, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (10, 2, 10, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (11, 2, 11, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (12, 2, 12, '2019-01-01 00:00:00', '2023-02-12 19:56:13'), (13, 2, 13, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (14, 2, 14, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (15, 2, 15, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (16, 2, 16, '2019-01-01 00:00:00', '2019-01-05 00:00:00'), (17, 3, 17, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (18, 3, 18, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (19, 3, 19, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (20, 3, 20, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (21, 3, 1, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (22, 3, 2, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (23, 3, 3, '2019-03-03 00:00:00', '2019-03-05 00:00:00'), (24, 4, 7, '2019-07-07 00:00:00', '2019-07-24 00:00:00'), (25, 5, 10, '2019-07-07 00:00:00', '2019-07-24 00:00:00'), (26, 6, 12, '2019-07-07 00:00:00', '2019-07-24 00:00:00'), (28, 2, 1, '2023-02-12 15:16:23', '2023-02-12 17:09:22'), (29, 2, 3, '2023-02-12 18:56:11', '2023-02-12 20:37:28'), (30, 2, 12, '2023-02-12 18:56:14', '2023-02-12 20:38:02'), (31, 2, 17, '2023-02-12 18:56:17', '2023-02-12 20:16:22'), (32, 2, 5, '2023-02-12 20:38:20', '2023-02-14 15:05:56'), (33, 2, 8, '2023-02-12 20:38:23', '2023-02-12 20:58:21'), (34, 2, 14, '2023-02-12 20:38:26', '2023-02-14 15:11:51'), (35, 2, 19, '2023-02-14 15:11:38', '2023-02-14 15:12:02'), (36, 1, 8, '2023-02-14 16:25:08', NULL);
COMMIT;

-- ----------------------------
-- Table structure for mylibary_user
-- ----------------------------
DROP TABLE IF EXISTS `mylibary_user`;
CREATE TABLE `mylibary_user`  (
  `USER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `USER_NAME` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_PASSWORD` varchar(40) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `USER_TYPE` int(1) NOT NULL,
  PRIMARY KEY (`USER_ID`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8 COLLATE = utf8_general_ci;

-- ----------------------------
-- Records of mylibary_user
-- ----------------------------
BEGIN;
INSERT INTO `mylibary_user` VALUES (1, 'aaa', '123456', 1), (2, 'bbb', '123456', 2), (3, 'ccc', '123456', 1), (4, 'ddd', '123456', 2), (5, 'eee', '123456', 1), (6, 'fff', '123456', 2), (7, 'xx1', '123456', 1), (8, 'xx2', '123456', 2), (9, 'aa', '123456', 2), (10, 'aaa1', '123456', 2), (11, 'aq', '123456', 2), (12, 'xxw', '123456', 2), (13, 'qwe', '123456', 2), (14, 'qas', '123456', 2), (15, 'xxtr', '123456', 2);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
