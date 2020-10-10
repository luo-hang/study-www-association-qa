-- ----------------------------
-- Table structure for t_sys_carousel
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_carousel`;
CREATE TABLE `t_sys_carousel` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `title` varchar(500) DEFAULT NULL COMMENT '标题',
  `domain` varchar(255) NOT NULL COMMENT '域名',
  `url` varchar(255) DEFAULT NULL COMMENT '超链接',
  `file_url` varchar(500) DEFAULT NULL COMMENT '文件地址',
  `order` int(11) NOT NULL COMMENT '排序',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  `is_delete` bigint(2) DEFAULT '0' COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `index_1` (`domain`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_carousel
-- ----------------------------
INSERT INTO `t_sys_carousel` VALUES ('1', '  <p>\n				已为<b style=\"color:#FFB800;font-size: 14px;\">5625</b>名学员提供培训服务   \n				   累计观看次数达<b style=\"color:#FFB800;font-size: 14px;\">87090</b>次\n			</p>  ', 'jiaoyu.shanhaiyh.com', '', 'http://shiant-oss-common.oss-cn-shenzhen.aliyuncs.com/portal/carousel/a8937c06-e521-4d15-8e0f-91828fb3e926.jpg', '1', '2020-06-03 16:32:20', '2020-06-22 17:49:01', '管理员', '管理员', '0');
INSERT INTO `t_sys_carousel` VALUES ('2', '       <p>\n				已为<b style=\"color:#FFB800;font-size: 14px;\">3232</b>名学员提供培训服务   \n				   累计观看次数达<b style=\"color:#FFB800;font-size: 14px;\">17090</b>次\n			</p>       ', 'huanjing.shanhaiyh.com', '', 'http://shiant-oss-common.oss-cn-shenzhen.aliyuncs.com/portal/carousel/98dddcd3-ea07-4b7f-a079-55c0f4639d69.jpg', '1', '2020-06-04 15:10:53', '2020-07-17 14:49:48', '管理员', '管理员', '0');
INSERT INTO `t_sys_carousel` VALUES ('3', '<p>\r\n				已为<b style=\"color:#FFB800;font-size: 14px;\">3232</b>名学员提供培训服务   \r\n				   累计观看次数达<b style=\"color:#FFB800;font-size: 14px;\">17090</b>次\r\n			</p>', 'jianzhu.shanhaiyh.com', '', 'http://shiant-oss-common.oss-cn-shenzhen.aliyuncs.com/portal/carousel/5208b708-ab97-41a7-8e00-f771a8edf307.jpg', '1', '2020-06-04 16:28:27', '2020-06-04 16:30:26', '管理员', '管理员', '0');
INSERT INTO `t_sys_carousel` VALUES ('4', ' <p>\n				已为<b style=\"color:#FFB800;font-size: 14px;\">3232</b>名学员提供培训服务   \n				   累计观看次数达<b style=\"color:#FFB800;font-size: 14px;\">17090</b>次\n			</p> ', 'jiaoyu.gynt.shanhaiyh.com', '', 'http://shiant-oss-common.oss-cn-shenzhen.aliyuncs.com/portal/carousel/c629e0fe-ca08-4f05-b762-6731db2d5798.jpg', '1', '2020-06-04 16:44:30', '2020-06-24 14:18:34', '管理员', '管理员', '0');
INSERT INTO `t_sys_carousel` VALUES ('5', '<p>\r\n				已为<b style=\"color:#FFB800;font-size: 14px;\">3232</b>名学员提供培训服务   \r\n				   累计观看次数达<b style=\"color:#FFB800;font-size: 14px;\">17090</b>次\r\n			</p>', 'ghana.shanhaiyh.com', '', 'http://shiant-oss-common.oss-cn-shenzhen.aliyuncs.com/portal/carousel/52d4076e-feeb-4d62-9dc2-c96ad467b8d8.jpg', '1', '2020-06-04 17:12:54', '2020-06-04 17:12:54', '管理员', '管理员', '0');
INSERT INTO `t_sys_carousel` VALUES ('6', '<p>\r\n				已为<b style=\"color:#FFB800;font-size: 14px;\">3232</b>名学员提供培训服务   \r\n				   累计观看次数达<b style=\"color:#FFB800;font-size: 14px;\">17090</b>次\r\n			</p>', 'ydyl.shanhaiyh.com', '', 'http://shiant-oss-common.oss-cn-shenzhen.aliyuncs.com/portal/carousel/cbc71646-a338-452f-8ac0-96e757d72ec8.jpg', '1', '2020-06-04 17:29:04', '2020-06-04 17:29:04', '管理员', '管理员', '0');

-- ----------------------------
-- Table structure for t_sys_univers
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_univers`;
CREATE TABLE `t_sys_univers` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `univers_name` varchar(255) DEFAULT NULL COMMENT '院校名称',
  `univers_name_en` varchar(255) DEFAULT NULL COMMENT '英文名称',
  `addr_country` varchar(255) NOT NULL COMMENT '所在地(国家)',
  `addr_state` varchar(255) NOT NULL COMMENT '所在地(省/州)',
  `addr_city` varchar(255) NOT NULL COMMENT '所在地(市)',
  `address` varchar(255) DEFAULT NULL COMMENT '所在地(详细地址)',
  `Professional_count` int(11) NOT NULL COMMENT '专业数量',
  `logo` varchar(500) DEFAULT NULL COMMENT '院校logo',
  `introduce` varchar(1000) NOT NULL COMMENT '院校简介',
  `nature` varchar(255) NOT NULL COMMENT '院校性质',
  `tuition` bigint(20) NOT NULL COMMENT '留学费用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_univers
-- ----------------------------
INSERT INTO `t_sys_univers` VALUES ('1','加州大学伯克利分校','Berkeley','美国','旧金山','伯克利','市中心','20','','世界大学学术排名第5位','公立','99999');
INSERT INTO `t_sys_univers` VALUES ('2','伦敦大学帝国理工学院','Imperial College','英国','伦敦','南肯辛顿','市中心','20','','直译为伦敦帝国学院','公立','99999');
INSERT INTO `t_sys_univers` VALUES ('3','东京大学','University of Tokyo','日本','东京','大阪','市中心','20','','素质大学','私立','99999');
INSERT INTO `t_sys_univers` VALUES ('4','慕尼黑大学','University of Munich','德国','巴伐利亚','慕尼黑','市中心','20','','世界一流大学','公立','99999');


-- ----------------------------
-- Table structure for t_sys_professional
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_professional`;
CREATE TABLE `t_sys_professional` (
  `pro_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `pro_name` varchar(255) NOT NULL COMMENT '专业名称',
  `pro_college` varchar(255) NOT NULL COMMENT '所属学院',
  `pro_degree` varchar(255) NOT NULL COMMENT '毕业学位',
  `pro_advantage` varchar(20) NOT NULL COMMENT '是否优势专业',
  `pro_semester` int(11) NOT NULL COMMENT '学期(月)',
  `pro_tuition` bigint(20) NOT NULL COMMENT '学费(￥)',
  PRIMARY KEY (`pro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_professional
-- ----------------------------
INSERT INTO `t_sys_professional` VALUES ('1','生物化学与分子生物学','生物科学学院','工程硕士','是','6','99999');
INSERT INTO `t_sys_professional` VALUES ('2','计算机应用','计算机科学与技术学院','工程硕士','是','6','99999');
INSERT INTO `t_sys_professional` VALUES ('3','生物制药','药理学院','工程硕士','是','6','99999');


-- ----------------------------
-- Table structure for t_sys_organization
-- ----------------------------

DROP TABLE IF EXISTS `t_sys_organization`;
CREATE TABLE `t_sys_organization` (
  `or_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '机构编号',
  `or_name` varchar(20) NOT NULL COMMENT '机构名称',
  `or_Creation_date` varchar(20) NOT NULL COMMENT '创建时间',
  `or_intro` varchar(50) DEFAULT NULL COMMENT '机构简介',
  `or_logo` varchar(30) DEFAULT NULL COMMENT '机构logo',
  `or_country` varchar(30) DEFAULT NULL COMMENT '主攻留学国家',
  `or_services` varchar(30) DEFAULT NULL COMMENT '服务领域',
  `or_address` varchar(30) DEFAULT NULL COMMENT '详细地址',
  `or_hotline` bigint(20) DEFAULT NULL COMMENT '咨询电话',
  `or_url` varchar(20) DEFAULT NULL COMMENT '机构网址',
  `or_qq` bigint(20) DEFAULT NULL COMMENT '客服QQ',
  `or_wechat` varchar(20) DEFAULT NULL COMMENT '客服微信',
  `or_wechat_line` varchar(20) DEFAULT NULL COMMENT '微信公众号',
  `or_microblog` varchar(20) DEFAULT NULL COMMENT '官方微博',
  PRIMARY KEY (`or_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_organization
-- ----------------------------
INSERT INTO `t_sys_organization` VALUES ('1','高科','1999年1月1日','这是一个好机构','','美国','留学金融','三桥','138','www.baidu.com','516','l516','高科公众号','高科微博');
INSERT INTO `t_sys_organization` VALUES ('2','中科','1999年1月1日','这是一个好机构','','美国','留学金融','三桥','138','www.baidu.com','516','l516','高科公众号','高科微博');
INSERT INTO `t_sys_organization` VALUES ('3','低科','1999年1月1日','这是一个好机构','','美国','留学金融','三桥','138','www.baidu.com','516','l516','高科公众号','高科微博');


-- ----------------------------
-- Table structure for t_sys_certification
-- ----------------------------

DROP TABLE IF EXISTS `t_sys_certification`;
CREATE TABLE `t_sys_certification` (
  `ce_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '入驻资质编号',
  `ce_license` varchar(40) DEFAULT NULL COMMENT '营业执照',
  `ce_name` varchar(20) NOT NULL COMMENT '机构联系人',
  `ce_id_number` bigint(20) NOT NULL COMMENT '身份证号',
  `ce_contact` bigint(20) NOT NULL COMMENT '联系方式',
  PRIMARY KEY (`ce_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_sys_certification
-- ----------------------------

INSERT INTO `t_sys_certification` VALUES ('1','','马迈','513646','138');
INSERT INTO `t_sys_certification` VALUES ('2','','马迈','513646','138');
INSERT INTO `t_sys_certification` VALUES ('3','','马迈','513646','138');

