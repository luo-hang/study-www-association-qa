/*
Navicat MySQL Data Transfer

Source Server         : 山海阿里
Source Server Version : 50726
Source Host           : rm-wz99z4cs6j3j1p8b7yo.mysql.rds.aliyuncs.com:3306
Source Database       : shiant-study

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-09-27 12:38:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_study_adviser
-- ----------------------------
DROP TABLE IF EXISTS `t_study_adviser`;
CREATE TABLE `t_study_adviser` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(50) DEFAULT NULL COMMENT '顾问姓名',
  `cover_file` varchar(500) DEFAULT NULL COMMENT '封面地址',
  `title` varchar(50) DEFAULT NULL COMMENT '职称',
  `background` varchar(200) DEFAULT NULL COMMENT '教育背景',
  `working_time` varchar(20) DEFAULT NULL COMMENT '从业时间',
  `items` varchar(200) DEFAULT NULL COMMENT '主要项目',
  `city` varchar(200) DEFAULT NULL COMMENT '所在城市',
  `content` text COMMENT '内容',
  `order` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `org_id` bigint(20) DEFAULT NULL COMMENT '组织机构编号',
  `org_name` varchar(255) DEFAULT NULL COMMENT '组织机构名',
  `show_time` bigint(50) DEFAULT '0' COMMENT '展示次数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  `is_public` bigint(2) DEFAULT '1' COMMENT '发布标记',
  `ability_1` varchar(20) DEFAULT NULL COMMENT '能力1',
  `ability_2` varchar(20) DEFAULT NULL COMMENT '能力2',
  `ability_3` varchar(20) DEFAULT NULL COMMENT '能力3',
  `ability_4` varchar(20) DEFAULT NULL COMMENT '能力4',
  `ability_5` varchar(20) DEFAULT NULL COMMENT '能力5',
  `ability_6` varchar(20) DEFAULT NULL COMMENT '能力6',
  `ability_7` varchar(20) DEFAULT NULL COMMENT '能力7',
  `ability_8` varchar(20) DEFAULT NULL COMMENT '能力8',
  `ability_9` varchar(20) DEFAULT NULL COMMENT '能力9',
  `ability_10` varchar(20) DEFAULT NULL COMMENT '能力10',
  `ability_11` varchar(20) DEFAULT NULL COMMENT '能力11',
  `ability_12` varchar(20) DEFAULT NULL COMMENT '能力12',
  `ability_13` varchar(20) DEFAULT NULL COMMENT '能力13',
  `ability_14` varchar(20) DEFAULT NULL COMMENT '能力14',
  `ability_15` varchar(20) DEFAULT NULL COMMENT '能力15',
  `ability_16` varchar(20) DEFAULT NULL COMMENT '能力16',
  `ability_17` varchar(20) DEFAULT NULL COMMENT '能力17',
  `ability_18` varchar(20) DEFAULT NULL COMMENT '能力18',
  `ability_19` varchar(20) DEFAULT NULL COMMENT '能力19',
  `ability_20` varchar(20) DEFAULT NULL COMMENT '能力20',
  PRIMARY KEY (`aid`),
  KEY `index_1` (`org_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_adviser
-- ----------------------------
INSERT INTO `t_study_adviser` VALUES ('8', '1', 'http://res.common.shiant.com/images/study/management/case/cover/68/68bf1cfc6ffb4cb084aa352c9b807412.jpg', '1111', '2', '2', '2', null, '而且去', '1', '1', '山海云汇教育科技公司', '0', '2020-09-20 22:45:40', '2020-09-20 22:45:40', '管理员', '管理员', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_study_adviser` VALUES ('9', '11', 'http://res.common.shiant.com/images/study/management/adviser/cover/75/75d68c92565249da8bf08376ab48e66f.png', '22', '33', '44', '55', '6', '77', '1', '1', '山海云汇教育科技公司', null, '2020-09-23 16:20:57', '2020-09-23 16:48:02', '管理员', '管理员', '1', '留学咨询及办理', '背景提升', null, null, '境外转学', '留学金融', null, '留学安全', '留学保险', null, '学历认证', null, '就业/创业', null, null, null, null, null, null, null);
INSERT INTO `t_study_adviser` VALUES ('10', '1', '', '2', '3', '4', '5', '6', '7', '1', '2', '山海云汇', '0', '2020-09-24 20:18:19', '2020-09-24 20:18:19', '李文彪', '李文彪', '1', '留学咨询及办理', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for t_study_case
-- ----------------------------
DROP TABLE IF EXISTS `t_study_case`;
CREATE TABLE `t_study_case` (
  `cid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `cover_file` varchar(500) DEFAULT NULL COMMENT '封面地址',
  `content` text COMMENT '内容',
  `student_name` varchar(50) DEFAULT NULL COMMENT '同学名称',
  `school` varchar(50) DEFAULT NULL COMMENT '录取学校',
  `major` varchar(20) DEFAULT NULL COMMENT '录取专业',
  `grade` varchar(20) DEFAULT NULL COMMENT '分数成绩',
  `order` int(11) NOT NULL DEFAULT '1' COMMENT '排序',
  `org_id` bigint(20) DEFAULT NULL COMMENT '组织机构编号',
  `org_name` varchar(255) DEFAULT NULL COMMENT '组织机构名',
  `show_time` bigint(50) DEFAULT '0' COMMENT '展示次数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  `is_public` bigint(2) DEFAULT '1' COMMENT '发布标记',
  PRIMARY KEY (`cid`),
  KEY `index_1` (`org_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_case
-- ----------------------------
INSERT INTO `t_study_case` VALUES ('1', '11', 'http://res.common.shiant.com/images/study/management/case/cover/c0/c00cbfb36a194744a202f863140fd0ba.png', '1<b>23<i>46</i></b>', '22', '33', '44', '55', '66', '1', '山海云汇教育科技公司', '77', '2020-09-18 20:12:21', '2020-09-18 20:58:46', '管理员', '管理员', '0');
INSERT INTO `t_study_case` VALUES ('6', '2', '', '3', '5', '3', '45', '5', '1', '1', '山海云汇教育科技公司', '0', '2020-09-18 21:00:35', '2020-09-18 21:00:35', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('7', '22', 'http://res.common.shiant.com/images/study/management/case/cover/3e/3ee88d48bb934587873a855e4397ecbe.png', '呜呜呜呜&nbsp;', '11', '111', '111', '11', '1', '1', '山海云汇教育科技公司', '0', '2020-09-20 21:54:52', '2020-09-20 21:54:52', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('8', '1111', 'http://res.common.shiant.com/images/study/management/case/cover/68/68bf1cfc6ffb4cb084aa352c9b807412.jpg', '而且去', '1', '2', '2', '2', '1', '1', '山海云汇教育科技公司', '0', '2020-09-20 22:45:40', '2020-09-20 22:45:40', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('9', '12', '', '12', '12', '1', '12', '12', '1', '1', '山海云汇教育科技公司', '0', '2020-09-23 18:38:19', '2020-09-23 19:04:37', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('10', '1', 'http://res.common.shiant.com/images/study/management/case/cover/19/199b387e0aea48da8179e1ec2b985137.png', '2', '3', '4', '5', '6', '1', '2', '山海云汇', '0', '2020-09-24 20:18:43', '2020-09-24 20:18:43', '李文彪', '李文彪', '1');

-- ----------------------------
-- Table structure for t_study_case_to_adviser
-- ----------------------------
DROP TABLE IF EXISTS `t_study_case_to_adviser`;
CREATE TABLE `t_study_case_to_adviser` (
  `c2aid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `cid` bigint(20) NOT NULL COMMENT '案例编号',
  `aid` bigint(20) NOT NULL COMMENT '顾问编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`c2aid`),
  UNIQUE KEY `index_1` (`cid`,`aid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_case_to_adviser
-- ----------------------------
INSERT INTO `t_study_case_to_adviser` VALUES ('1', '0', '11', '2020-09-18 20:12:21', '2020-09-18 20:58:46', '管理员', '管理员');
INSERT INTO `t_study_case_to_adviser` VALUES ('6', '0', '2', '2020-09-18 21:00:35', '2020-09-18 21:00:35', '管理员', '管理员');
INSERT INTO `t_study_case_to_adviser` VALUES ('7', '0', '22', '2020-09-20 21:54:52', '2020-09-20 21:54:52', '管理员', '管理员');
INSERT INTO `t_study_case_to_adviser` VALUES ('8', '0', '1111', '2020-09-20 22:45:40', '2020-09-20 22:45:40', '管理员', '管理员');
INSERT INTO `t_study_case_to_adviser` VALUES ('9', '9', '9', null, null, null, null);
INSERT INTO `t_study_case_to_adviser` VALUES ('10', '9', '8', null, null, null, null);
INSERT INTO `t_study_case_to_adviser` VALUES ('11', '10', '10', null, null, null, null);

-- ----------------------------
-- Table structure for t_study_complaint
-- ----------------------------
DROP TABLE IF EXISTS `t_study_complaint`;
CREATE TABLE `t_study_complaint` (
  `cid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `org_name` varchar(255) DEFAULT NULL COMMENT '组织机构名',
  `title` varchar(50) NOT NULL COMMENT '标题',
  `type` varchar(200) DEFAULT NULL COMMENT '类型',
  `need` varchar(200) DEFAULT NULL COMMENT '诉求',
  `content` text COMMENT '内容',
  `image_file_1` varchar(500) DEFAULT NULL COMMENT '图片一',
  `image_file_2` varchar(500) DEFAULT NULL COMMENT '图片二',
  `image_file_3` varchar(500) DEFAULT NULL COMMENT '图片三',
  `image_file_4` varchar(500) DEFAULT NULL COMMENT '图片四',
  `image_file_5` varchar(500) DEFAULT NULL COMMENT '图片五',
  `image_file_6` varchar(500) DEFAULT NULL COMMENT '图片六',
  `image_file_7` varchar(500) DEFAULT NULL COMMENT '图片七',
  `image_file_8` varchar(500) DEFAULT NULL COMMENT '图片八',
  `image_file_9` varchar(500) DEFAULT NULL COMMENT '图片九',
  `image_file_10` varchar(500) DEFAULT NULL COMMENT '图片十',
  `video_file_1` varchar(500) DEFAULT NULL COMMENT '视频一',
  `video_file_2` varchar(500) DEFAULT NULL COMMENT '视频二',
  `video_file_3` varchar(500) DEFAULT NULL COMMENT '视频三',
  `video_file_4` varchar(500) DEFAULT NULL COMMENT '视频四',
  `video_file_5` varchar(500) DEFAULT NULL COMMENT '视频五',
  `status` bigint(2) DEFAULT '0' COMMENT '展示次数',
  `reason` text COMMENT '原因',
  `org_id` bigint(20) DEFAULT NULL COMMENT '组织机构编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater_id` bigint(20) DEFAULT NULL COMMENT '创建人编号',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `creater_type` varchar(10) DEFAULT NULL COMMENT '创建人类型(机构;用户)',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`cid`),
  KEY `index_1` (`org_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_complaint
-- ----------------------------
INSERT INTO `t_study_complaint` VALUES ('11', '111', '2', '高利贷;客服不处理/处理不当;虚假/误导宣传;', '停止骚扰;解释;', '3', 'http://res.common.shiant.com/images/study/management/complaint/68/68fb00ea45d4404dbe89c8ced9759faf.jpg', 'http://res.common.shiant.com/images/study/management/complaint/22/22bd4de34c8a4d138a0822be8555e54b.png', 'http://res.common.shiant.com/images/study/management/complaint/9c/9c332c16eb3d48078d8e2d73080b82a1.png', '', '', '', '', '', '', '', '', '', '', null, null, '1', null, '1', '2020-09-20 13:31:42', '2020-09-20 17:06:58', '1', '管理员', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('12', '333', '3345', '高利贷;客服不处理/处理不当;服务不到位/态度差;', '赔偿;解释;下架产品;', '345465', 'http://res.common.shiant.com/images/study/management/complaint/68/68b3b048aec34de0b41121a241451f78.jpg', 'http://res.common.shiant.com/images/study/management/complaint/0a/0afbc983b9fe414cb509359553ca6f96.png', 'http://res.common.shiant.com/images/study/management/complaint/5e/5e5c004854e34ad8ab26ef447a29fbbe.png', '', '', '', '', '', '', '', 'http://res.common.shiant.com/video/study/management/complaint/09/09c3dbeab56a4a7c85c48a1ac96d3e62.mp4', 'http://res.common.shiant.com/video/study/management/complaint/bb/bbeded05ccf94de799b2121a6faef0cc.mp4', '', null, null, '1', null, '1', '2020-09-20 13:32:41', '2020-09-25 04:15:10', '1', '管理员', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('13', '111', '11', '骚扰;阴阳合同;', '依法追究责任;', '11', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '1', null, '1', '2020-09-20 21:55:51', '2020-09-20 21:56:01', '1', 'system', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('14', '222', '2', '侮辱;收费问题;', '道歉;作出处罚;', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '1', null, '1', '2020-09-20 22:46:23', '2020-09-20 22:46:37', '1', 'system', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('15', '1', '2', '高利贷;客服不处理/处理不当;虚假/误导宣传;', '赔偿;下架产品;', '3', 'http://res.common.shiant.com/images/study/management/complaint/1c/1cc011999b7846b183ebaf4da87c5161.png', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '-1', '', '2', '2020-09-24 20:19:03', '2020-09-25 04:15:43', '732', '13985111937', '机构', '管理员');

-- ----------------------------
-- Table structure for t_study_white_list
-- ----------------------------
DROP TABLE IF EXISTS `t_study_white_list`;
CREATE TABLE `t_study_white_list` (
  `wlid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `wl_no` varchar(50) DEFAULT NULL COMMENT '资质号',
  `valid_date` datetime DEFAULT NULL COMMENT '有效时间',
  `status` bigint(2) DEFAULT '0' COMMENT '认证状态',
  `org_id` bigint(20) NOT NULL COMMENT '组织机构编号',
  `org_name` varchar(255) DEFAULT NULL COMMENT '组织机构名',
  `commitment_file` varchar(500) DEFAULT NULL COMMENT '机构曹勇国家标准承诺书',
  `commitment_status` bigint(2) DEFAULT '0' COMMENT '机构曹勇国家标准承诺书状态',
  `apply_file` varchar(500) DEFAULT NULL COMMENT '留学服务白名单机构申请表',
  `apply_status` bigint(2) DEFAULT '0' COMMENT '留学服务白名单机构申请表状态',
  `information_file` varchar(500) DEFAULT NULL COMMENT '消费投诉调解机构信息表',
  `information_status` bigint(2) DEFAULT '0' COMMENT '消费投诉调解机构信息表状态',
  `copy_file` varchar(500) DEFAULT NULL COMMENT '营业执照(法人登记证书)复印件',
  `copy_status` bigint(2) DEFAULT '0' COMMENT '营业执照(法人登记证书)复印件状态',
  `convention_file` varchar(500) DEFAULT NULL COMMENT '共同构建留学行业诚信和服务质量保障体系诚信自律公约',
  `convention_status` bigint(2) DEFAULT '0' COMMENT '共同构建留学行业诚信和服务质量保障体系诚信自律公约状态',
  `verification_file` varchar(500) DEFAULT NULL COMMENT '自费出国留学中介服务机构资格认定书',
  `verification_status` bigint(2) DEFAULT '0' COMMENT '自费出国留学中介服务机构资格认定书状态',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`wlid`),
  KEY `index_1` (`org_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_white_list
-- ----------------------------
INSERT INTO `t_study_white_list` VALUES ('2', '222222', '2020-09-15 00:00:00', '1', '1', '山海云汇教育科技公司', 'http://res.common.shiant.com/pdf/9e/9ee409c6af87450bb319eb5c3d75736c.pdf', '2', null, '2', 'http://res.common.shiant.com/pdf/e4/e491c3ca74a44ad9b2b4600000c31b55.pdf', '2', 'http://res.common.shiant.com/pdf/95/95ff3155e5c5469fa897ae342e935a1f.pdf', '2', 'http://res.common.shiant.com/pdf/3b/3b148644473c4dcca5035e896ba07cf9.pdf', '2', 'http://res.common.shiant.com/pdf/cd/cd0233ea097840a59b1ad28aa8fcf252.pdf', '2', '2020-09-18 16:27:48', '2020-09-18 16:27:48', '管理员', '管理员');
