/*
Navicat MySQL Data Transfer

Source Server         : dbx
Source Server Version : 50612
Source Host           : localhost:3306
Source Database       : cbdparkingmsdb

Target Server Type    : MYSQL
Target Server Version : 50612
File Encoding         : 65001

Date: 2016-03-18 16:18:42
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cbdparking
-- ----------------------------
DROP TABLE IF EXISTS `cbdparking`;
CREATE TABLE `cbdparking` (
  `cbd_id` int(11) NOT NULL AUTO_INCREMENT,
  `cbd_location` varchar(255) DEFAULT NULL,
  `cbd_no` varchar(20) DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cbd_id`),
  UNIQUE KEY `cbd_no` (`cbd_no`),
  KEY `company_id` (`company_id`),
  CONSTRAINT `cbdparking_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cbdparking
-- ----------------------------
INSERT INTO `cbdparking` VALUES ('1', '春熙路', 'YS76', '1');
INSERT INTO `cbdparking` VALUES ('2', '春熙路', 'YS77', '1');
INSERT INTO `cbdparking` VALUES ('3', '春熙路', 'YS99', '1');
INSERT INTO `cbdparking` VALUES ('4', '盐市口', 'YK01', '2');
INSERT INTO `cbdparking` VALUES ('5', '盐市口', 'YK03', '2');
INSERT INTO `cbdparking` VALUES ('6', '春熙路', 'YD03', '1');
INSERT INTO `cbdparking` VALUES ('7', '春熙路', 'YS71', '1');
INSERT INTO `cbdparking` VALUES ('8', '春熙路', 'YS72', '1');
INSERT INTO `cbdparking` VALUES ('9', '春熙路', 'YS73', '1');
INSERT INTO `cbdparking` VALUES ('10', '春熙路', 'YS74', '1');
INSERT INTO `cbdparking` VALUES ('11', '春熙路', 'YS79', '1');
INSERT INTO `cbdparking` VALUES ('12', '盐市口', 'YK10', '2');
INSERT INTO `cbdparking` VALUES ('13', '盐市口', 'YK02', '2');
INSERT INTO `cbdparking` VALUES ('14', '盐市口', 'YK05', '2');
INSERT INTO `cbdparking` VALUES ('15', '盐市口', 'YK07', '2');
INSERT INTO `cbdparking` VALUES ('16', '天府二街', 'GX12', '3');
INSERT INTO `cbdparking` VALUES ('17', '天府二街', 'GX13', '3');
INSERT INTO `cbdparking` VALUES ('18', '天府二街', 'GX14', '3');
INSERT INTO `cbdparking` VALUES ('19', '天府二街', 'GX15', '3');
INSERT INTO `cbdparking` VALUES ('20', '天府二街', 'GX16', '3');
INSERT INTO `cbdparking` VALUES ('21', '天府二街', 'GX17', '3');
INSERT INTO `cbdparking` VALUES ('22', '天府二街', 'GX18', '3');
INSERT INTO `cbdparking` VALUES ('23', '天府二街', 'GX19', '3');
INSERT INTO `cbdparking` VALUES ('24', '天府二街', 'GX11', '3');
INSERT INTO `cbdparking` VALUES ('25', '天府五街', 'TR01', '4');
INSERT INTO `cbdparking` VALUES ('26', '天府五街', 'TR02', '4');
INSERT INTO `cbdparking` VALUES ('27', '天府五街', 'TR03', '4');
INSERT INTO `cbdparking` VALUES ('28', '天府五街', 'TR04', '4');
INSERT INTO `cbdparking` VALUES ('29', '天府五街', 'TR05', '4');
INSERT INTO `cbdparking` VALUES ('30', '天府五街', 'TR06', '4');
INSERT INTO `cbdparking` VALUES ('31', '天府五街', 'TR07', '4');
INSERT INTO `cbdparking` VALUES ('32', '天府五街', 'TR08', '4');
INSERT INTO `cbdparking` VALUES ('33', '天府五街', 'TR09', '4');
INSERT INTO `cbdparking` VALUES ('34', '天府五街', 'TR10', '4');
INSERT INTO `cbdparking` VALUES ('35', '天府五街', 'TR11', '4');
INSERT INTO `cbdparking` VALUES ('36', '天府大道三段', 'JR88', '5');
INSERT INTO `cbdparking` VALUES ('37', '天府大道三段', 'JR89', '5');
INSERT INTO `cbdparking` VALUES ('38', '天府大道三段', 'JR90', '5');
INSERT INTO `cbdparking` VALUES ('39', '天府大道三段', 'JR81', '5');
INSERT INTO `cbdparking` VALUES ('40', '天府大道三段', 'JR82', '5');
INSERT INTO `cbdparking` VALUES ('41', '天府大道三段', 'JR83', '5');
INSERT INTO `cbdparking` VALUES ('42', '天府大道三段', 'JR84', '5');
INSERT INTO `cbdparking` VALUES ('43', '天府大道三段', 'JR85', '5');
INSERT INTO `cbdparking` VALUES ('44', '天府大道三段', 'JR86', '5');
INSERT INTO `cbdparking` VALUES ('45', '天府大道三段', 'JR87', '5');
INSERT INTO `cbdparking` VALUES ('46', '天府大道三段', 'JR92', '5');
INSERT INTO `cbdparking` VALUES ('47', '天府大道三段', 'JR91', '5');
INSERT INTO `cbdparking` VALUES ('48', '天府大道三段', 'JR93', '5');
INSERT INTO `cbdparking` VALUES ('49', '孵化园', 'FH21', '6');
INSERT INTO `cbdparking` VALUES ('50', '孵化园', 'FH22', '6');
INSERT INTO `cbdparking` VALUES ('51', '孵化园', 'FH23', '6');
INSERT INTO `cbdparking` VALUES ('52', '孵化园', 'FH24', '6');
INSERT INTO `cbdparking` VALUES ('53', '孵化园', 'FH25', '6');
INSERT INTO `cbdparking` VALUES ('54', '孵化园', 'FH26', '6');
INSERT INTO `cbdparking` VALUES ('55', '孵化园', 'FH27', '6');
INSERT INTO `cbdparking` VALUES ('56', '孵化园', 'FH28', '6');
INSERT INTO `cbdparking` VALUES ('57', '九眼桥', 'JY01', '7');
INSERT INTO `cbdparking` VALUES ('58', '九眼桥', 'JY02', '7');

-- ----------------------------
-- Table structure for company
-- ----------------------------
DROP TABLE IF EXISTS `company`;
CREATE TABLE `company` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(50) DEFAULT NULL,
  `company_address` varchar(50) DEFAULT NULL,
  `company_responsible` varchar(20) DEFAULT NULL,
  `company_phone` varchar(12) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`company_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of company
-- ----------------------------
INSERT INTO `company` VALUES ('1', '企业用户1', '银石广场写字楼', '企业负责人1', '86543211', '2');
INSERT INTO `company` VALUES ('2', '企业用户2', '盐市口CBD', '企业负责人2', '87876621', '6');
INSERT INTO `company` VALUES ('3', '企业用户3', '高新产业孵化园', '企业负责人3', '89228181', '12');
INSERT INTO `company` VALUES ('4', '企业用户4', '天府软件园', '企业负责人4', '83119898', '15');
INSERT INTO `company` VALUES ('5', '企业用户5', '金融中心办公楼', '企业负责人5', '87654321', '20');
INSERT INTO `company` VALUES ('6', '企业用户6', '高新产业孵化园二期', '企业负责人6', '83217654', '21');
INSERT INTO `company` VALUES ('7', '企业用户7', '天紫界写字楼', '企业负责人7', '87876666', '22');

-- ----------------------------
-- Table structure for complain
-- ----------------------------
DROP TABLE IF EXISTS `complain`;
CREATE TABLE `complain` (
  `complain_id` int(11) NOT NULL AUTO_INCREMENT,
  `complain_time` datetime DEFAULT NULL,
  `complain` text,
  `complain_type` int(11) DEFAULT '0',
  `complain_from` int(11) DEFAULT NULL,
  `complain_to` int(11) DEFAULT NULL,
  `parkingMsg_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`complain_id`),
  KEY `complain_ibfk_1` (`parkingMsg_id`),
  KEY `complain_from` (`complain_from`),
  KEY `complain_to` (`complain_to`),
  CONSTRAINT `complain_ibfk_1` FOREIGN KEY (`parkingMsg_id`) REFERENCES `parkingmessage` (`parkingMsg_id`) ON DELETE CASCADE,
  CONSTRAINT `complain_ibfk_2` FOREIGN KEY (`complain_from`) REFERENCES `personal` (`personal_id`),
  CONSTRAINT `complain_ibfk_3` FOREIGN KEY (`complain_to`) REFERENCES `personal` (`personal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of complain
-- ----------------------------
INSERT INTO `complain` VALUES ('1', '2016-03-19 15:46:23', '我啊啊啊啊啊', '0', '4', '2', '2');
INSERT INTO `complain` VALUES ('2', '2016-03-19 11:47:40', '我去', '0', '4', '1', '3');
INSERT INTO `complain` VALUES ('3', '2016-03-16 15:48:44', '不行不行', '0', '4', '1', '7');
INSERT INTO `complain` VALUES ('4', '2016-03-23 15:48:56', '太差太差', '0', '4', '1', '8');
INSERT INTO `complain` VALUES ('5', '2016-03-25 15:49:47', '太挤了', '0', '4', '1', '4');
INSERT INTO `complain` VALUES ('6', '2016-03-30 15:50:54', '太猥琐了', '0', '4', '1', '5');
INSERT INTO `complain` VALUES ('7', '2016-03-07 15:50:58', '太贵了', '0', '4', '1', '6');
INSERT INTO `complain` VALUES ('8', '2016-03-24 15:51:16', '拖时间', '0', '2', '4', '2');
INSERT INTO `complain` VALUES ('9', '2016-03-24 15:51:52', '太鸡贼', '0', '1', '4', '3');
INSERT INTO `complain` VALUES ('10', '2016-03-26 15:52:53', '人不行', '0', '1', '4', '4');
INSERT INTO `complain` VALUES ('11', '2016-03-29 15:52:56', '还是他', '0', '1', '4', '5');
INSERT INTO `complain` VALUES ('12', '2016-03-11 15:53:00', '走走走', '0', '1', '4', '6');
INSERT INTO `complain` VALUES ('13', '2016-03-27 15:53:03', '再也不租给你了', '0', '1', '4', '7');

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `contract_id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_no` varchar(25) NOT NULL,
  `contract_picture` varchar(50) DEFAULT NULL,
  `contract_type` int(11) DEFAULT NULL,
  `contract_direction` int(11) DEFAULT NULL,
  `contract_start` datetime DEFAULT NULL,
  `contract_end` datetime DEFAULT NULL,
  `company_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`contract_id`),
  UNIQUE KEY `contract_no` (`contract_no`),
  KEY `c_id` (`company_id`),
  CONSTRAINT `contract_ibfk_1` FOREIGN KEY (`company_id`) REFERENCES `company` (`company_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract
-- ----------------------------
INSERT INTO `contract` VALUES ('1', 'ZL20160318001', '/img/1.jpg', '0', '0', '2016-03-18 11:46:03', '2016-06-18 11:46:07', '1');
INSERT INTO `contract` VALUES ('2', 'CZ20160318002', '/img/2.jpg', '0', '1', '2016-03-18 11:49:36', '2016-06-18 11:49:38', '1');
INSERT INTO `contract` VALUES ('3', 'ZL20160318003', '/img/3.jpg', '0', '0', '2016-03-18 13:14:33', '2016-06-18 13:14:36', '2');
INSERT INTO `contract` VALUES ('4', 'CZ20160318004', '/img/4.jpg', '0', '1', '2016-03-18 13:15:27', '2016-06-18 13:15:32', '2');
INSERT INTO `contract` VALUES ('5', 'CZ20151001001', '/img/5.jpg', '1', '1', '2015-10-01 13:26:09', '2016-01-01 13:26:20', '3');
INSERT INTO `contract` VALUES ('6', 'ZL20150901001', '/img/5.jpg', '1', '0', '2015-09-01 13:31:34', '2016-01-01 13:32:04', '1');
INSERT INTO `contract` VALUES ('7', 'ZL20150901002', '/img.5.jpg', '1', '0', '2015-09-01 13:32:36', '2016-01-01 13:32:43', '2');

-- ----------------------------
-- Table structure for contract_cbdparking
-- ----------------------------
DROP TABLE IF EXISTS `contract_cbdparking`;
CREATE TABLE `contract_cbdparking` (
  `cc_id` int(11) NOT NULL AUTO_INCREMENT,
  `contract_id` int(11) DEFAULT NULL,
  `cbd_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`cc_id`),
  KEY `contract_id` (`contract_id`),
  KEY `cbd_id` (`cbd_id`),
  CONSTRAINT `contract_cbdparking_ibfk_1` FOREIGN KEY (`contract_id`) REFERENCES `contract` (`contract_id`),
  CONSTRAINT `contract_cbdparking_ibfk_2` FOREIGN KEY (`cbd_id`) REFERENCES `cbdparking` (`cbd_id`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of contract_cbdparking
-- ----------------------------
INSERT INTO `contract_cbdparking` VALUES ('1', '1', '1');
INSERT INTO `contract_cbdparking` VALUES ('2', '1', '2');
INSERT INTO `contract_cbdparking` VALUES ('3', '1', '3');
INSERT INTO `contract_cbdparking` VALUES ('4', '2', '4');
INSERT INTO `contract_cbdparking` VALUES ('5', '2', '5');
INSERT INTO `contract_cbdparking` VALUES ('6', '2', '12');
INSERT INTO `contract_cbdparking` VALUES ('7', '2', '13');
INSERT INTO `contract_cbdparking` VALUES ('8', '2', '14');
INSERT INTO `contract_cbdparking` VALUES ('9', '2', '15');
INSERT INTO `contract_cbdparking` VALUES ('10', '2', '16');
INSERT INTO `contract_cbdparking` VALUES ('11', '2', '17');
INSERT INTO `contract_cbdparking` VALUES ('12', '3', '4');
INSERT INTO `contract_cbdparking` VALUES ('13', '3', '5');
INSERT INTO `contract_cbdparking` VALUES ('14', '3', '12');
INSERT INTO `contract_cbdparking` VALUES ('15', '3', '13');
INSERT INTO `contract_cbdparking` VALUES ('16', '3', '14');
INSERT INTO `contract_cbdparking` VALUES ('17', '3', '15');
INSERT INTO `contract_cbdparking` VALUES ('18', '4', '1');
INSERT INTO `contract_cbdparking` VALUES ('19', '4', '2');
INSERT INTO `contract_cbdparking` VALUES ('20', '4', '3');
INSERT INTO `contract_cbdparking` VALUES ('21', '4', '6');
INSERT INTO `contract_cbdparking` VALUES ('22', '4', '7');
INSERT INTO `contract_cbdparking` VALUES ('23', '4', '8');
INSERT INTO `contract_cbdparking` VALUES ('24', '4', '9');
INSERT INTO `contract_cbdparking` VALUES ('25', '5', '1');
INSERT INTO `contract_cbdparking` VALUES ('26', '5', '2');
INSERT INTO `contract_cbdparking` VALUES ('27', '5', '3');
INSERT INTO `contract_cbdparking` VALUES ('28', '5', '4');
INSERT INTO `contract_cbdparking` VALUES ('29', '5', '5');
INSERT INTO `contract_cbdparking` VALUES ('30', '5', '6');
INSERT INTO `contract_cbdparking` VALUES ('31', '6', '1');
INSERT INTO `contract_cbdparking` VALUES ('32', '6', '2');
INSERT INTO `contract_cbdparking` VALUES ('33', '6', '3');
INSERT INTO `contract_cbdparking` VALUES ('34', '6', '6');
INSERT INTO `contract_cbdparking` VALUES ('35', '6', '7');
INSERT INTO `contract_cbdparking` VALUES ('36', '6', '8');
INSERT INTO `contract_cbdparking` VALUES ('37', '6', '9');
INSERT INTO `contract_cbdparking` VALUES ('38', '6', '10');
INSERT INTO `contract_cbdparking` VALUES ('41', '6', '11');
INSERT INTO `contract_cbdparking` VALUES ('43', '7', '4');
INSERT INTO `contract_cbdparking` VALUES ('44', '7', '5');
INSERT INTO `contract_cbdparking` VALUES ('45', '7', '12');
INSERT INTO `contract_cbdparking` VALUES ('46', '7', '13');
INSERT INTO `contract_cbdparking` VALUES ('47', '7', '14');
INSERT INTO `contract_cbdparking` VALUES ('48', '7', '15');

-- ----------------------------
-- Table structure for manager
-- ----------------------------
DROP TABLE IF EXISTS `manager`;
CREATE TABLE `manager` (
  `manager_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_name` varchar(20) DEFAULT NULL,
  `manager_phone` varchar(12) DEFAULT NULL,
  `manager_no` int(11) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`manager_id`),
  UNIQUE KEY `manager_no` (`manager_no`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `manager_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager
-- ----------------------------
INSERT INTO `manager` VALUES ('1', '超管1', '13877772222', '10000011', '1');
INSERT INTO `manager` VALUES ('2', '操作员1', '13338888222', '10000022', '4');
INSERT INTO `manager` VALUES ('3', '超管2', '18822221111', '10000013', '5');
INSERT INTO `manager` VALUES ('4', '操作员2', '18612341234', '10000023', '8');
INSERT INTO `manager` VALUES ('5', '超管3', '18677772222', '10000024', '9');
INSERT INTO `manager` VALUES ('6', '操作员3', '13322221111', '10000025', '11');
INSERT INTO `manager` VALUES ('7', '超管4', '18682222222', '10000014', '13');
INSERT INTO `manager` VALUES ('8', '操作员4', '18782828171', '10000026', '16');
INSERT INTO `manager` VALUES ('9', '操作员5', '18171888171', '10000027', '17');
INSERT INTO `manager` VALUES ('10', '操作员6', '18887272652', '10000028', '18');
INSERT INTO `manager` VALUES ('11', '操作员7', '18928268271', '10000029', '19');

-- ----------------------------
-- Table structure for manager_power
-- ----------------------------
DROP TABLE IF EXISTS `manager_power`;
CREATE TABLE `manager_power` (
  `mp_id` int(11) NOT NULL AUTO_INCREMENT,
  `manager_id` int(11) DEFAULT NULL,
  `power_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`mp_id`),
  KEY `manager_id` (`manager_id`),
  KEY `power_id` (`power_id`),
  CONSTRAINT `manager_power_ibfk_1` FOREIGN KEY (`manager_id`) REFERENCES `manager` (`manager_id`),
  CONSTRAINT `manager_power_ibfk_2` FOREIGN KEY (`power_id`) REFERENCES `power` (`power_id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of manager_power
-- ----------------------------
INSERT INTO `manager_power` VALUES ('1', '1', '1');
INSERT INTO `manager_power` VALUES ('2', '1', '2');
INSERT INTO `manager_power` VALUES ('3', '1', '3');
INSERT INTO `manager_power` VALUES ('4', '2', '1');
INSERT INTO `manager_power` VALUES ('5', '3', '1');
INSERT INTO `manager_power` VALUES ('6', '3', '2');
INSERT INTO `manager_power` VALUES ('7', '3', '3');
INSERT INTO `manager_power` VALUES ('8', '4', '2');
INSERT INTO `manager_power` VALUES ('9', '4', '3');
INSERT INTO `manager_power` VALUES ('10', '5', '1');
INSERT INTO `manager_power` VALUES ('11', '5', '2');
INSERT INTO `manager_power` VALUES ('12', '5', '3');
INSERT INTO `manager_power` VALUES ('13', '6', '1');
INSERT INTO `manager_power` VALUES ('14', '6', '3');
INSERT INTO `manager_power` VALUES ('15', '7', '1');
INSERT INTO `manager_power` VALUES ('16', '7', '2');
INSERT INTO `manager_power` VALUES ('17', '7', '3');
INSERT INTO `manager_power` VALUES ('18', '8', '2');
INSERT INTO `manager_power` VALUES ('19', '9', '3');
INSERT INTO `manager_power` VALUES ('22', '10', '2');
INSERT INTO `manager_power` VALUES ('23', '10', '3');
INSERT INTO `manager_power` VALUES ('24', '11', '1');
INSERT INTO `manager_power` VALUES ('25', '11', '3');

-- ----------------------------
-- Table structure for parkingmessage
-- ----------------------------
DROP TABLE IF EXISTS `parkingmessage`;
CREATE TABLE `parkingmessage` (
  `parkingMsg_id` int(11) NOT NULL AUTO_INCREMENT,
  `parkingMsg_start` datetime DEFAULT NULL,
  `parkingMsg_end` datetime DEFAULT NULL,
  `price` decimal(10,2) DEFAULT NULL,
  `parking_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`parkingMsg_id`),
  KEY `parking_id` (`parking_id`),
  CONSTRAINT `parkingmessage_ibfk_1` FOREIGN KEY (`parking_id`) REFERENCES `parkings` (`parking_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkingmessage
-- ----------------------------
INSERT INTO `parkingmessage` VALUES ('1', '2016-03-18 09:39:22', '2016-03-18 21:39:30', '40.00', '1');
INSERT INTO `parkingmessage` VALUES ('2', '2016-03-18 16:40:11', '2016-03-18 22:40:18', '30.00', '3');
INSERT INTO `parkingmessage` VALUES ('3', '2016-03-18 11:40:30', '2016-03-18 14:40:36', '15.00', '5');
INSERT INTO `parkingmessage` VALUES ('4', '2016-03-18 07:40:51', '2016-03-18 22:40:59', '60.00', '6');
INSERT INTO `parkingmessage` VALUES ('5', '2016-03-18 03:41:25', '2016-03-18 23:41:34', '100.00', '7');
INSERT INTO `parkingmessage` VALUES ('6', '2016-03-18 02:41:54', '2016-03-18 17:42:05', '60.00', '8');
INSERT INTO `parkingmessage` VALUES ('7', '2016-02-01 13:42:44', '2016-02-02 13:42:50', '100.00', '1');
INSERT INTO `parkingmessage` VALUES ('8', '2016-03-18 07:43:02', '2016-03-18 12:43:10', '40.00', '6');

-- ----------------------------
-- Table structure for parkings
-- ----------------------------
DROP TABLE IF EXISTS `parkings`;
CREATE TABLE `parkings` (
  `parking_id` int(11) NOT NULL AUTO_INCREMENT,
  `property_no` varchar(50) NOT NULL,
  `parking_picture` varchar(255) DEFAULT NULL,
  `parking_address` varchar(50) DEFAULT NULL,
  `parking_no` varchar(20) DEFAULT NULL,
  `parking_type` int(11) DEFAULT '0',
  `personal_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`parking_id`),
  UNIQUE KEY `property_no` (`property_no`),
  KEY `personal_id` (`personal_id`),
  CONSTRAINT `parkings_ibfk_1` FOREIGN KEY (`personal_id`) REFERENCES `personal` (`personal_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkings
-- ----------------------------
INSERT INTO `parkings` VALUES ('1', 'GT19892828', '/img/1.jpg', '肖家河130号', 'E77', '1', '1');
INSERT INTO `parkings` VALUES ('2', 'GT92882187', '/img/2.jpg', '外双楠55号', 'B21', '0', '1');
INSERT INTO `parkings` VALUES ('3', 'GT77281871', '/img/3.jpg', '城西优品道', 'C221', '1', '2');
INSERT INTO `parkings` VALUES ('4', 'GT87821111', '/img/4.jpg', '北城天街99号', 'E21', '0', '3');
INSERT INTO `parkings` VALUES ('5', 'GT81922129', '/img/5.jpg', '桃溪路22号', 'A331', '1', '1');
INSERT INTO `parkings` VALUES ('6', 'GT82271219', '/img/6.jpg', '太升南路31号', 'E882', '1', '1');
INSERT INTO `parkings` VALUES ('7', 'GT28199912', '/img/7.jpg', '春熙路南口22号', 'W21', '1', '1');
INSERT INTO `parkings` VALUES ('8', 'GT28199917', '/img/7.jpg', '新会展中心', 'A776', '1', '1');

-- ----------------------------
-- Table structure for personal
-- ----------------------------
DROP TABLE IF EXISTS `personal`;
CREATE TABLE `personal` (
  `personal_id` int(11) NOT NULL AUTO_INCREMENT,
  `personal_name` varchar(20) DEFAULT NULL,
  `personal_realName` varchar(50) NOT NULL,
  `personal_phone` varchar(12) DEFAULT NULL,
  `personal_idCard` varchar(20) NOT NULL,
  `personal_address` varchar(100) DEFAULT NULL,
  `personal_job` varchar(50) DEFAULT NULL,
  `tenant_reputation` double DEFAULT '1',
  `renter_reputation` double DEFAULT '1',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`personal_id`),
  UNIQUE KEY `personal_idCard` (`personal_idCard`),
  UNIQUE KEY `personal_phone` (`personal_phone`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `personal_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of personal
-- ----------------------------
INSERT INTO `personal` VALUES ('1', '个人用户1', '张三', '13388883333', '510101196602081131', '成都XXXX街', '工人', '0', '0', '3');
INSERT INTO `personal` VALUES ('2', '个人用户2', '张四', '13388884444', '510103198702019987', '成都XX区XX楼', '教师', '0', '0', '7');
INSERT INTO `personal` VALUES ('3', '个人用户3', '张五', '13387875555', '515000198709092212', '成都XX小区XX号', '学生', '0', '0', '10');
INSERT INTO `personal` VALUES ('4', '个人用户4', '张六', '18633336666', '513001198301019899', '成都武侯祠大街', '自由职业', '0', '0', '14');
INSERT INTO `personal` VALUES ('5', '个人用户5', '张二', '18922222222', '620102198602172417', '成都市成华区', '白领', '0', '0', '23');
INSERT INTO `personal` VALUES ('6', '个人用户6', '张一', '13622221111', '513001198602010026', '成都市武侯区', '教师', '0', '0', '24');
INSERT INTO `personal` VALUES ('7', '个人用户7', '张七', '18199992211', '510101196602010022', '成都市青羊区', '退休', '0', '0', '25');
INSERT INTO `personal` VALUES ('8', '个人用户8', '张八', '18688882222', '510101198703121122', '成都市武侯区', '工人', '0', '0', '26');
INSERT INTO `personal` VALUES ('9', '个人用户9', '张九', '18611112222', '510101197705062211', '成都市青羊区', '私营', '0', '0', '27');
INSERT INTO `personal` VALUES ('10', '个人用户10', '张十', '18677772222', '510101199902021121', '成都市青羊区', '务农', '0', '0', '28');
INSERT INTO `personal` VALUES ('11', '个人用户11', '张十一', '18633331111', '510101198707170022', '成都市青羊区', '私营', '0', '0', '29');

-- ----------------------------
-- Table structure for power
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `power_id` int(11) NOT NULL AUTO_INCREMENT,
  `power_name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`power_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '个人管理');
INSERT INTO `power` VALUES ('2', '企业管理');
INSERT INTO `power` VALUES ('3', '合约管理');

-- ----------------------------
-- Table structure for rentlogs
-- ----------------------------
DROP TABLE IF EXISTS `rentlogs`;
CREATE TABLE `rentlogs` (
  `rentLog_id` int(11) NOT NULL AUTO_INCREMENT,
  `personal_id` int(11) DEFAULT NULL,
  `tenant_msg` text,
  `rentLog_type` int(11) DEFAULT '0',
  `parkingMsg_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`rentLog_id`),
  KEY `personal_id` (`personal_id`),
  KEY `parkingMsg_id` (`parkingMsg_id`),
  CONSTRAINT `rentlogs_ibfk_1` FOREIGN KEY (`personal_id`) REFERENCES `personal` (`personal_id`),
  CONSTRAINT `rentlogs_ibfk_2` FOREIGN KEY (`parkingMsg_id`) REFERENCES `parkingmessage` (`parkingMsg_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of rentlogs
-- ----------------------------
INSERT INTO `rentlogs` VALUES ('1', '4', 'wowowo', '0', '1');
INSERT INTO `rentlogs` VALUES ('2', '5', 'wodewode', '0', '1');
INSERT INTO `rentlogs` VALUES ('3', '6', 'woyao', '0', '1');
INSERT INTO `rentlogs` VALUES ('4', '7', 'geiwoba', '0', '1');
INSERT INTO `rentlogs` VALUES ('5', '8', '我要我要', '0', '1');
INSERT INTO `rentlogs` VALUES ('6', '9', '我给多点呗', '0', '1');
INSERT INTO `rentlogs` VALUES ('7', '11', '我就停一会儿', '0', '1');
INSERT INTO `rentlogs` VALUES ('8', '7', '我我我', '0', '2');
INSERT INTO `rentlogs` VALUES ('9', '6', '给我呗', '0', '2');
INSERT INTO `rentlogs` VALUES ('10', '4', 'hehe', '1', '2');
INSERT INTO `rentlogs` VALUES ('11', '11', 'asd', '0', '3');
INSERT INTO `rentlogs` VALUES ('12', '5', 'saaa', '0', '3');
INSERT INTO `rentlogs` VALUES ('13', '6', 'asd', '0', '3');
INSERT INTO `rentlogs` VALUES ('14', '7', '1111', '0', '3');
INSERT INTO `rentlogs` VALUES ('15', '8', '123', '0', '3');
INSERT INTO `rentlogs` VALUES ('16', '9', 'hheeee', '0', '3');
INSERT INTO `rentlogs` VALUES ('17', '4', 'gei', '1', '3');
INSERT INTO `rentlogs` VALUES ('18', '10', 'enenen', '0', '3');
INSERT INTO `rentlogs` VALUES ('19', '4', 'wode', '1', '7');
INSERT INTO `rentlogs` VALUES ('20', '5', 'wo', '0', '7');
INSERT INTO `rentlogs` VALUES ('21', '7', 'eee', '0', '8');
INSERT INTO `rentlogs` VALUES ('23', '9', 'aaa', '0', '8');
INSERT INTO `rentlogs` VALUES ('24', '4', 'aaaaa', '1', '8');
INSERT INTO `rentlogs` VALUES ('25', '5', 'aaaaa', '0', '4');
INSERT INTO `rentlogs` VALUES ('26', '4', '2223we', '1', '4');
INSERT INTO `rentlogs` VALUES ('27', '4', 'wode', '1', '5');
INSERT INTO `rentlogs` VALUES ('28', '4', 'geiwo', '1', '6');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) NOT NULL,
  `user_password` varchar(25) NOT NULL,
  `user_type` int(11) NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin111', '123123', '0');
INSERT INTO `users` VALUES ('2', 'company111', '123123', '1');
INSERT INTO `users` VALUES ('3', 'personal111', '123123', '2');
INSERT INTO `users` VALUES ('4', 'manager111', '123123', '3');
INSERT INTO `users` VALUES ('5', 'admin222', '123123', '0');
INSERT INTO `users` VALUES ('6', 'company222', '123123', '1');
INSERT INTO `users` VALUES ('7', 'personal222', '123123', '2');
INSERT INTO `users` VALUES ('8', 'manager222', '123123', '3');
INSERT INTO `users` VALUES ('9', 'admin333', '123123', '0');
INSERT INTO `users` VALUES ('10', 'personal333', '123123', '2');
INSERT INTO `users` VALUES ('11', 'manager333', '123123', '3');
INSERT INTO `users` VALUES ('12', 'company333', '123123', '1');
INSERT INTO `users` VALUES ('13', 'admin444', '123123', '0');
INSERT INTO `users` VALUES ('14', 'personal444', '123123', '2');
INSERT INTO `users` VALUES ('15', 'company444', '123123', '1');
INSERT INTO `users` VALUES ('16', 'manager444', '123123', '3');
INSERT INTO `users` VALUES ('17', 'manager555', '123123', '3');
INSERT INTO `users` VALUES ('18', 'manager666', '123123', '3');
INSERT INTO `users` VALUES ('19', 'manager777', '123123', '3');
INSERT INTO `users` VALUES ('20', 'company555', '123123', '1');
INSERT INTO `users` VALUES ('21', 'company666', '123123', '1');
INSERT INTO `users` VALUES ('22', 'company777', '123123', '1');
INSERT INTO `users` VALUES ('23', 'personal555', '123123', '2');
INSERT INTO `users` VALUES ('24', 'personal666', '123123', '2');
INSERT INTO `users` VALUES ('25', 'personal777', '123123', '2');
INSERT INTO `users` VALUES ('26', 'personal888', '123123', '2');
INSERT INTO `users` VALUES ('27', 'personal999', '123123', '2');
INSERT INTO `users` VALUES ('28', 'personal000', '123123', '2');
INSERT INTO `users` VALUES ('29', 'personalaaa', '123123', '2');
