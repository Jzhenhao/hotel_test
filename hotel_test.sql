/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50717
Source Host           : 127.0.0.1:3306
Source Database       : hotel_test

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-12-13 01:30:16
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for booking
-- ----------------------------
DROP TABLE IF EXISTS `booking`;
CREATE TABLE `booking` (
  `bookingID` int(11) NOT NULL AUTO_INCREMENT,
  `roomID` int(11) DEFAULT NULL,
  `userID` int(11) DEFAULT NULL,
  `commentState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookingID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of booking
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `commentID` int(100) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `userID` int(100) DEFAULT NULL,
  `bookingID` int(100) DEFAULT NULL,
  `commentDate` date DEFAULT NULL,
  PRIMARY KEY (`commentID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------

-- ----------------------------
-- Table structure for nearby
-- ----------------------------
DROP TABLE IF EXISTS `nearby`;
CREATE TABLE `nearby` (
  `nearbyID` int(11) NOT NULL AUTO_INCREMENT,
  `nearbyName` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`nearbyID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of nearby
-- ----------------------------
INSERT INTO `nearby` VALUES ('1', '越秀公园', '北京路', 'http://www.yuexiupark-gz.com/');
INSERT INTO `nearby` VALUES ('2', '白云山', '白云路', 'http://www.baiyunshan.com.cn/');

-- ----------------------------
-- Table structure for room
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `roomID` int(11) NOT NULL AUTO_INCREMENT,
  `roomName` varchar(255) DEFAULT NULL,
  `roomType` varchar(255) DEFAULT NULL,
  `roomPrice` int(10) DEFAULT NULL,
  `roomDate` date DEFAULT NULL,
  `roomState` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`roomID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '401', '单人房', '150', '2018-12-21', '未预订');
INSERT INTO `room` VALUES ('2', '402', '双人房', '200', '2018-12-21', '未预订');
INSERT INTO `room` VALUES ('3', '403', '总统套房', '250', '2018-12-21', '未预订');
INSERT INTO `room` VALUES ('4', '401', '单人房', '150', '2018-12-08', '未预订');
INSERT INTO `room` VALUES ('5', '402', '双人房', '200', '2018-12-10', '未预订');
INSERT INTO `room` VALUES ('6', '403', '总统套房', '250', '2018-12-10', '未预订');
INSERT INTO `room` VALUES ('7', '501', '单人房', '150', '2018-12-10', '未预订');
INSERT INTO `room` VALUES ('8', '502', '单人房', '150', '2018-12-07', '未预订');
INSERT INTO `room` VALUES ('9', '503', '单人房', '150', '2018-12-07', '未预订');
INSERT INTO `room` VALUES ('10', '601', '双人房', '200', '2018-12-07', '未预订');
INSERT INTO `room` VALUES ('11', '602', '双人房', '200', '2018-12-07', '未预订');
INSERT INTO `room` VALUES ('12', '603', '双人房', '200', '2018-12-07', '未预订');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `userID` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(255) DEFAULT NULL,
  `userPassword` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', '123', '123');
INSERT INTO `users` VALUES ('2', '222', '222');
