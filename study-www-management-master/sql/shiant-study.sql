/*
Navicat MySQL Data Transfer

Source Server         : 山海数据库
Source Server Version : 50726
Source Host           : rm-wz99z4cs6j3j1p8b7yo.mysql.rds.aliyuncs.com:3306
Source Database       : shiant-study

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-10-09 21:41:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_pms_organization`
-- ----------------------------
DROP TABLE IF EXISTS `t_pms_organization`;
CREATE TABLE `t_pms_organization` (
  `org_id` bigint(10) NOT NULL AUTO_INCREMENT COMMENT '部门编号',
  `o_id` bigint(10) DEFAULT NULL COMMENT '父机构编号',
  `parent_id` bigint(10) DEFAULT NULL COMMENT '父机构编号',
  `org_name` varchar(255) DEFAULT NULL COMMENT '机构名称',
  `org_code` varchar(20) DEFAULT NULL COMMENT '机构代码',
  `org_scale` varchar(20) DEFAULT NULL COMMENT '机构规模',
  `org_logo` varchar(255) DEFAULT NULL COMMENT '机构图标',
  `org_introduction` text COMMENT '机构简介',
  `customer_num` varchar(20) DEFAULT NULL COMMENT '客户数量',
  `industry` varchar(20) DEFAULT NULL COMMENT '所属行业',
  `province` varchar(10) DEFAULT NULL COMMENT '省',
  `city` varchar(10) DEFAULT NULL COMMENT '市',
  `county` varchar(10) DEFAULT NULL COMMENT '县',
  `address` varchar(255) DEFAULT NULL COMMENT '详细地址',
  `consultation_phone` varchar(20) DEFAULT NULL COMMENT '咨询电话',
  `website` varchar(255) DEFAULT NULL COMMENT '机构网址',
  `qq` varchar(20) DEFAULT NULL COMMENT '机构QQ',
  `wechat` varchar(20) DEFAULT NULL COMMENT '机构微信',
  `wechat_qr_code` varchar(255) DEFAULT NULL COMMENT '机构二维码',
  `wechat_mp` varchar(20) DEFAULT NULL COMMENT '机构微信公众号',
  `wechat_mp_qr_code` varchar(255) DEFAULT NULL COMMENT '机构二维码',
  `weibo` varchar(255) DEFAULT NULL COMMENT '微博',
  `legal_person` varchar(20) DEFAULT NULL COMMENT '法人',
  `legal_person_id_card` varchar(20) DEFAULT NULL COMMENT '法人身份证',
  `legal_person_phone` varchar(20) DEFAULT NULL COMMENT '法人电话',
  `business_license` varchar(255) DEFAULT NULL COMMENT '营业执照',
  `found_date` date DEFAULT NULL COMMENT '创立时间',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  `is_delete` bigint(2) DEFAULT '0' COMMENT '删除标记',
  `status` bigint(2) DEFAULT '0' COMMENT '状态 （0:初始化，1:通过，-1:驳回）',
  `reason` text COMMENT '原因',
  `verify_date` datetime DEFAULT NULL COMMENT '审核时间',
  PRIMARY KEY (`org_id`),
  UNIQUE KEY `index_1` (`org_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1001 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pms_organization
-- ----------------------------
INSERT INTO `t_pms_organization` VALUES ('1', '1', '1', '山海云汇教育科技公司', null, null, 'http://res.common.shiant.com/images/center/management/organization/logo/91/91521def7a3143fc98d1c9c293d0e457.png', 'We aim to build the specialized big data service platform for agriculture which integrates various service resources including online training, certification, agricultural technical support, food processing and quality testing. The platform collects the real-time data while servicing the farmers and poor households. Through big data analysis, we provides the customized services to our customers; provide guidance for the government\'s poverty alleviation and provides direction for the development of local industries. ', null, null, null, null, null, '贵州省贵阳市林城西路摩根中心11楼205', '0851-88888881', 'www.shanhaiyh.com', '9999999', '88888888', 'http://res.common.shiant.com/images/center/management/organization/wechat/39/396444a523464e5983e3720f7ed3b8fa.jpg', '山海云汇平台', 'http://res.common.shiant.com/images/center/management/organization/wechat/57/57bb7c80478f45f49cc16f9446962746.png', '88888888', '杨陈', '520103199910101011', '18275008418', 'http://res.common.shiant.com/images/center/management/organization/business license/66/6676b61019a34473af938ec89fad26ea.jpg', '2020-09-09', '2020-07-04 15:31:37', '2020-09-21 11:43:25', '超级管理员', '管理员', '0', '1', '1212', '2020-09-21 11:43:24');
INSERT INTO `t_pms_organization` VALUES ('2', '2', '2', '山海云汇留学咨询服务有限公司', null, null, 'http://res.common.shiant.com/images/center/management/organization/logo/01/01fd874e4a4b4c48a826a2ad674cf582.png', 'We aim to build the specialized big data service platform for agriculture which integrates various service resources including online training, certification, agricultural technical support, food processing and quality testing. The platform collects the real-time data while servicing the farmers and poor households. Through big data analysis, we provides the customized services to our customers; provide guidance for the government\'s poverty alleviation and provides direction for the development of local industries. ', null, null, null, null, null, '1', '18999999999', 'www.shanhaiyh.com', '18999999999', '18999999999', 'http://res.common.shiant.com/images/center/management/organization/wechat/8a/8a907bef3a9a412eaa846feef0269a57.png', '山海云汇平台', 'http://res.common.shiant.com/images/center/management/organization/wechat/c6/c68c4611f46f47ca82764758a810c2e5.png', '18999999999', '杨陈', '520103198107212212', '18999999999', 'http://res.common.shiant.com/images/center/management/organization/business license/32/32cd9093d2c14e3f838a5789a35bca41.jpg', '2020-09-25', '2020-07-04 15:31:37', '2020-09-27 20:20:19', '超级管理员', '李文彪', '0', '1', null, '2020-09-25 19:58:51');
INSERT INTO `t_pms_organization` VALUES ('3', '3', '3', '贵州万峰湖润丰实业发展有限公司', null, null, 'http://res.common.shiant.com/images/center/business/logo/c0/c035b753a94a481586535181df7e4ef2.png', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('4', '4', '4', '贵州罗甸惠禾农旅投资开发有限公司', null, null, 'http://res.common.shiant.com/images/center/business/logo/73/738dbc221add4563b9bd95286c45a61e.png', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('5', '5', '5', '贵州扶贫开发投资有限公司', null, null, 'http://res.common.shiant.com/images/center/business/logo/44/441a1f07d7814eafb762e20623367d27.png', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-07-04 15:31:37', '2020-09-25 17:14:07', '超级管理员', '管理员', '0', '1', null, '2020-09-25 17:14:06');
INSERT INTO `t_pms_organization` VALUES ('9', '9', '6', '2342', '342A', '3423A', 'http://res.common.shiant.com/images/center/management/organization/logo/7d/7dbf6349407848bf9391cab2aaed8473.png', null, '234A', '4234A', '广东省', '深圳市', '南山区', '234A', null, null, null, null, null, null, null, null, '234A', null, '18275008484', null, null, '2020-07-23 16:01:04', '2020-07-23 16:54:59', '管理员', '管理员', '1', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('10', '10', '7', '456', '456', '456', '', null, '456', '456', '贵州省', '贵阳市', '南明区', '456', null, null, null, null, null, null, null, null, '456', null, '18275001444', null, null, '2020-07-23 16:57:01', '2020-07-23 16:57:01', '管理员', '管理员', '1', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('11', '12', '9', '567', '567', '567', '', null, '67', '5675', '贵州省', '贵阳市', '南明区', '567', null, null, null, null, null, null, null, null, '56756', null, '18744444444', null, null, '2020-07-25 14:11:00', '2020-07-25 14:11:00', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('13', '13', null, '24234', '234', '234234', '', null, '24234', '23423', '贵州省', '贵阳市', '南明区', '234234', null, null, null, null, null, null, null, null, '23424', null, '18233333333', null, null, '2020-07-28 11:49:47', '2020-07-28 11:49:47', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('15', null, null, 'hkx', '', '100人', '', null, '200', '种植业', '贵州省', '贵阳市', '南明区', '是当然够仍然 ', null, null, null, null, null, null, null, null, 'hkx', null, '18798625925', null, null, '2020-07-31 21:47:35', '2020-07-31 21:47:35', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('19', null, null, '18275999999', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-08-07 22:22:48', '2020-08-07 22:22:48', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('23', null, null, '18275888888', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '18275888888', null, '18275888888', null, null, '2020-08-07 22:30:32', '2020-08-07 22:31:50', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('25', null, null, '15186901557', '110', '45', '', null, '77777777', '娱乐', '贵州省', '贵阳市', '南明区', '15186901557', null, null, null, null, null, null, null, null, '毛毛', null, '15186901557', null, null, '2020-08-13 17:18:25', '2020-08-13 17:19:14', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('26', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '2020-08-18 15:36:01', '2020-08-18 15:36:01', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('27', null, null, '李文彪团队', '1', '2', '', null, '4', '3', '贵州省', '贵阳市', '南明区', '1', null, null, null, null, null, null, null, null, '5', null, '18275555555', null, null, '2020-08-20 00:12:06', '2020-08-20 00:12:06', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('28', null, null, 'aaaaaa', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '18299999999', null, '18299999999', null, null, '2020-08-20 00:43:24', '2020-08-20 00:43:24', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('29', null, null, '李安定团队', '李安定', '李安定', '', null, '李安定', '李安定', '贵州省', '贵阳市', '南明区', '李安定', null, null, null, null, null, null, null, null, '李安定', null, '17588756458', null, null, '2020-08-20 10:45:45', '2020-08-20 10:45:57', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('30', null, null, '测试有限公司', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0820测试1', null, '17885637172', null, null, '2020-08-20 14:07:06', '2020-08-20 14:07:06', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('32', null, null, '贵州省分析测试院', null, null, 'http://res.common.shiant.com/images/center/management/organization/logo/40/408052fbf40b4aa4a1f393549c1b2345.png', null, null, null, '贵州省', '贵阳市', '南明区', '贵阳市白云区白沙路388号', null, null, null, null, null, null, null, null, '测试院', null, '18084572928', null, null, '2020-08-20 17:32:37', '2020-08-20 17:33:05', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('34', null, null, '贵州湄潭兰馨茶业有限公司', null, null, 'http://res.common.shiant.com/images/center/management/organization/logo/48/489f82cef4b24849880d533e40120fc0.png', null, null, null, '贵州省', '贵阳市', '南明区', '贵州省遵义市湄潭县湄江镇', null, null, null, null, null, null, null, null, '兰馨茶业', null, '17608506257', null, null, '2020-08-20 17:44:09', '2020-08-20 17:46:01', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('35', null, null, '0823测试公司', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '0823测试', null, '15285932363', null, null, '2020-08-23 11:48:29', '2020-08-23 11:48:29', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('36', null, null, '啥啥啥公司', null, null, 'http://res.common.shiant.com/images/center/management/organization/logo/1f/1fef17bad400494b8b590fd2782af2d6.png', null, null, null, '贵州省', '贵阳市', '南明区', '摄氏度我服你', null, null, null, null, null, null, null, null, '0823测试②', null, '18896584755', null, null, '2020-08-23 12:41:00', '2020-09-01 16:54:35', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('37', null, null, '贵州测试有限公司', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, '小明', null, '18224702809', null, null, '2020-08-26 10:00:07', '2020-08-26 10:00:07', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('38', null, null, '移动互联应用技术', null, '1000', null, null, '100', null, '贵州省', '贵阳市', '南明区', '花果园J区5栋3802', null, null, null, null, null, null, null, null, '爪子', null, '13339633732', null, null, '2020-08-26 10:44:19', '2020-08-26 10:51:42', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('39', null, null, '小阿梅互联网时代', '', '', 'http://res.common.shiant.com/images/center/management/organization/logo/32/323dcfef4b004ccb99e6fd198789d160.png', null, '', '', '贵州省', '贵阳市', '南明区', '林城西路', null, null, null, null, null, null, null, null, '小阿梅', null, '15186901467', null, null, '2020-08-26 15:38:05', '2020-08-26 15:38:23', '管理员', '管理员', '0', '0', null, null);
INSERT INTO `t_pms_organization` VALUES ('40', null, null, '贵州南侧有限公司', '', '1000', '', null, '43333', '', '贵州省', '贵阳市', '南明区', '岭城西路', null, null, null, null, null, null, null, null, '吴浅浅', null, '13145201100', null, null, '2020-09-09 14:13:44', '2020-09-23 10:49:24', '管理员', '管理员', '0', '1', null, '2020-09-23 10:49:24');

-- ----------------------------
-- Table structure for `t_pms_power`
-- ----------------------------
DROP TABLE IF EXISTS `t_pms_power`;
CREATE TABLE `t_pms_power` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限表ID(平台页面ID)',
  `POWER_NAME` varchar(255) NOT NULL COMMENT '权限名称 （菜单名称）',
  `POWER_NOTE` varchar(100) DEFAULT NULL,
  `POWER_ORDER` int(11) DEFAULT '0' COMMENT '权限顺序',
  `HIGHER` bigint(20) DEFAULT '0' COMMENT '隶属于（上级菜单ID）',
  `PLATFORM_ID` bigint(20) DEFAULT NULL COMMENT '所属平台ID',
  `LAST_UPDATE_TIME` datetime DEFAULT NULL COMMENT '最后操作时间',
  `USER_ID` bigint(20) DEFAULT NULL COMMENT '最后操作人ID',
  `LAST_UPDATE_USERNAME` varchar(100) DEFAULT NULL COMMENT '最后操作人',
  `POWER_STATUS` char(1) DEFAULT 'Y' COMMENT '权限状态（菜单状态）',
  `URL` varchar(255) DEFAULT NULL COMMENT '菜单链接页面(点击菜单所跳转到的页面）',
  `LEVEL` int(10) DEFAULT NULL COMMENT '菜单层级',
  `RECORD_INSERT_TIME` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `ICON` varchar(400) DEFAULT NULL COMMENT '图标路劲',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of t_pms_power
-- ----------------------------
INSERT INTO `t_pms_power` VALUES ('3', '岗位维护', null, '0', '0', '1', '2018-02-02 10:11:29', '1', '超级管理员', 'Y', '/pms-core/views/posts/posts.html', '2', '2018-02-02 10:11:29', '<i class=\"fa fa-vcard-o\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('4', '组织架构', null, '0', '0', '1', '2017-06-27 06:51:35', '1', '超级管理员', 'Y', '/pms-core/views/org/orgnation.html', '2', '2017-06-27 14:51:35', '<i class=\"fa fa-globe\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('5', '角色维护', null, '0', '0', '1', '2017-06-09 03:42:04', '1', '超级管理员', 'Y', '/pms-core/views/role/role.html', '2', '2017-06-09 11:42:04', '<i class=\"fa fa-registered\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('6', '用户维护', null, '0', '0', '1', '2017-12-20 09:54:00', '248', '张建军1', 'Y', '/pms-core/views/user/user.html', '1', '2017-12-20 09:54:00', '<i class=\"fa fa-user-o\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('7', '个人信息', null, '0', '0', '1', '2017-10-17 02:02:32', '165', '毛多多', 'Y', '/pms-core/views/user/userline.html', '1', '2017-10-17 10:02:32', '<i class=\"fa fa-vcard-o\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('18', '权限维护', null, '0', '0', '1', '2017-06-15 18:08:15', '1', '超级管理员', 'Y', '/pms-core/views/power/power.html', '1', '2017-06-15 18:08:15', '<i class=\"fa fa-dedent\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('23', '机构维护', null, '0', '0', '1', '2017-06-09 05:39:38', '1', '超级管理员', 'Y', '/pms-core/views/team/team.html', '0', '2017-06-09 13:39:38', '<i class=\"fa fa-tty\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('24', '我的培训', null, '0', '45', '1', '2017-07-06 08:58:21', '1', '超级管理员', 'Y', '/pms-core/views/train/train.html', '0', '2017-07-06 16:58:21', '<i class=\"fa fa-newspaper-o\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('25', '能力授权', null, '0', '0', '1', '2018-01-26 10:56:02', '1', '超级管理员', 'Y', '/pms-core/views/ability/ability.html', '0', '2018-01-26 10:56:02', '<i class=\"fa fa-balance-scale\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('26', '添加计划', null, '0', '45', '1', '2017-07-03 06:04:39', '1', '超级管理员', 'Y', '/pms-core/views/train/trainplan.html', '0', '2017-07-03 14:04:39', '<i class=\"fa fa-street-view\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('32', '统计分析', null, '0', '0', '1', '2018-12-11 21:20:12', '1', '超级管理员', 'Y', 'https://www.baidu.com/', '0', '2018-12-11 21:20:12', '');
INSERT INTO `t_pms_power` VALUES ('37', '仪器统计分析', null, '0', '32', '1', '2017-06-22 08:23:08', '1', '超级管理员', 'Y', '/pms-core/views/count/count.html', '0', '2017-06-22 16:23:08', '<i class=\"fa fa-line-chart\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('38', '平行统计分析', null, '0', '32', '1', '2017-06-22 08:23:39', '1', '超级管理员', 'Y', '/pms-core/views/counts/counts.html', '0', '2017-06-22 16:23:39', '<i class=\"fa fa-line-chart\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('45', '培训计划', null, '0', '0', '1', '2018-12-03 09:57:18', '1', '超级管理员', 'N', '/', '0', '2018-12-03 09:57:18', '<i class=\"fa fa-newspaper-o\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('49', 'check in', null, '0', '0', '1', '2017-07-08 08:04:59', '1', '超级管理员', 'Y', 'https://www.baidu.com/', '0', '2017-07-08 16:04:59', '<i class=\"fa fa-frown-o\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('56', '项目追踪', null, '0', '0', '1', '2017-10-25 02:31:23', '1', '超级管理员', 'Y', '', '0', '2017-10-25 10:31:23', '');
INSERT INTO `t_pms_power` VALUES ('108', '首页', null, '0', '0', '2', '2017-11-07 02:23:22', '1', '超级管理员', 'N', '/sample/home.html', '0', '2017-11-07 10:23:22', null);
INSERT INTO `t_pms_power` VALUES ('109', '样品管理', null, '0', '0', '2', '2017-11-02 07:42:14', '1', '超级管理员', 'Y', '#', '0', '2017-11-02 15:42:14', '');
INSERT INTO `t_pms_power` VALUES ('110', '样品信息', null, '0', '109', '2', '2017-11-01 02:12:58', '1', 'system', 'Y', '/sample/views/sample/management.html', '0', '2017-11-01 10:12:56', null);
INSERT INTO `t_pms_power` VALUES ('111', '样品移交', null, '0', '109', '2', '2017-11-01 02:13:30', '1', 'system', 'Y', '/sample/views/sample/sampleTransfer.html', '0', '2017-11-01 10:13:28', null);
INSERT INTO `t_pms_power` VALUES ('112', '样品分样', null, '0', '109', '2', '2017-11-01 02:14:03', '1', 'system', 'Y', '/sample/views/sample/sampleSubSampleinfo.html', '0', '2017-11-01 10:14:01', null);
INSERT INTO `t_pms_power` VALUES ('113', '抽样码打印', null, '0', '109', '2', '2017-11-01 02:14:25', '1', 'system', 'Y', '/sample/views/sample/sample_selectTemplate.html', '0', '2017-11-01 10:14:23', null);
INSERT INTO `t_pms_power` VALUES ('114', '入库(抽样)', null, '0', '109', '2', '2017-11-01 02:14:44', '1', 'system', 'Y', '/sample/views/sample/sampleInStorageSample.html', '0', '2017-11-01 10:14:42', null);
INSERT INTO `t_pms_power` VALUES ('115', '样品原样打印', null, '0', '109', '2', '2017-11-01 02:15:03', '1', 'system', 'Y', '/sample/views/sample/sampleOriginalSampleinfo.html', '0', '2017-11-01 10:15:01', null);
INSERT INTO `t_pms_power` VALUES ('116', '待办样品信息', null, '0', '109', '2', '2017-11-01 02:15:24', '1', 'system', 'Y', '/sample/views/sample/sampleInfoBacklog.html', '0', '2017-11-01 10:15:22', null);
INSERT INTO `t_pms_power` VALUES ('117', '存放位置', null, '0', '109', '2', '2017-11-01 02:15:51', '1', 'system', 'Y', '/', '0', '2017-11-01 10:15:49', null);
INSERT INTO `t_pms_power` VALUES ('118', '检测样', null, '0', '109', '2', '2017-11-01 02:16:16', '1', 'system', 'Y', '/', '0', '2017-11-01 10:16:14', null);
INSERT INTO `t_pms_power` VALUES ('119', '留存样', null, '0', '109', '2', '2017-11-01 02:16:32', '1', 'system', 'Y', '/', '0', '2017-11-01 10:16:30', null);
INSERT INTO `t_pms_power` VALUES ('120', '样品处置记录查询', null, '0', '109', '2', '2017-11-01 02:16:51', '1', 'system', 'Y', '/', '0', '2017-11-01 10:16:48', null);
INSERT INTO `t_pms_power` VALUES ('121', '样品柜管理', null, '0', '117', '2', '2017-11-01 02:17:32', '1', 'system', 'Y', '/sample/views/cabinet/management.html', '0', '2017-11-01 10:17:30', null);
INSERT INTO `t_pms_power` VALUES ('122', '样品格管理', null, '0', '117', '2', '2017-11-01 02:17:55', '1', 'system', 'Y', '/sample/views/grid/management.html', '0', '2017-11-01 10:17:53', null);
INSERT INTO `t_pms_power` VALUES ('123', '入库', null, '0', '118', '2', '2017-11-01 02:18:23', '1', 'system', 'Y', '/sample/views/sample/sampleProcessinfo.html?type=1', '0', '2017-11-01 10:18:21', null);
INSERT INTO `t_pms_power` VALUES ('124', '领用', null, '0', '118', '2', '2017-11-01 02:18:47', '1', 'system', 'Y', '/sample/views/sample/sampleProcessinfo.html?type=2', '0', '2017-11-01 10:18:45', null);
INSERT INTO `t_pms_power` VALUES ('125', '返还', null, '0', '118', '2', '2017-11-01 02:19:18', '1', 'system', 'Y', '/sample/views/sample/sampleProcessinfo.html?type=3', '0', '2017-11-01 10:19:16', null);
INSERT INTO `t_pms_power` VALUES ('126', '销毁', null, '0', '118', '2', '2017-11-01 02:20:37', '1', 'system', 'Y', '/sample/views/sample/sampleDestory.html?type=0', '0', '2017-11-01 10:20:34', null);
INSERT INTO `t_pms_power` VALUES ('127', '销毁(已返还)', null, '0', '118', '2', '2017-11-01 02:21:05', '1', 'system', 'Y', '/sample/views/sample/sampleDestory.html?type=0&statusType=3', '0', '2017-11-01 10:21:03', null);
INSERT INTO `t_pms_power` VALUES ('128', '未归还样品清空', null, '0', '118', '2', '2017-11-01 02:22:45', '1', 'system', 'Y', '/sample/views/sample/sampleDestory.html?type=0&statusType=13', '0', '2017-11-01 10:22:43', null);
INSERT INTO `t_pms_power` VALUES ('129', '物料管理', null, '0', '0', '2', '2017-11-02 07:42:23', '1', '超级管理员', 'Y', '#', '0', '2017-11-02 15:42:23', '');
INSERT INTO `t_pms_power` VALUES ('130', '物料信息', null, '0', '129', '2', '2017-11-01 02:24:55', '1', 'system', 'Y', '/sample/views/material/materialNew.html', '0', '2017-11-01 10:24:53', null);
INSERT INTO `t_pms_power` VALUES ('131', '库存管理', null, '0', '129', '2', '2017-11-01 02:25:23', '1', 'system', 'Y', '/sample/views/material/materialInventory.html', '0', '2017-11-01 10:25:21', null);
INSERT INTO `t_pms_power` VALUES ('132', '入库', null, '0', '119', '2', '2017-11-01 02:28:52', '1', 'system', 'Y', '/sample/views/sample/sampleProcessinfo.html?type=4', '0', '2017-11-01 10:28:50', null);
INSERT INTO `t_pms_power` VALUES ('133', '领用', null, '0', '119', '2', '2017-11-01 02:29:22', '1', 'system', 'Y', '/sample/views/sample/sampleProcessinfo.html?type=5', '0', '2017-11-01 10:29:20', null);
INSERT INTO `t_pms_power` VALUES ('134', '返还', null, '0', '119', '2', '2017-11-01 02:29:44', '1', 'system', 'Y', '/sample/views/sample/sampleProcessinfo.html?type=6', '0', '2017-11-01 10:29:42', null);
INSERT INTO `t_pms_power` VALUES ('135', '销毁', null, '0', '119', '2', '2017-11-01 02:30:09', '1', 'system', 'Y', '/sample/views/sample/sampleDestory.html?type=1', '0', '2017-11-01 10:30:06', null);
INSERT INTO `t_pms_power` VALUES ('136', '销毁(已返还)', null, '0', '119', '2', '2017-11-01 02:36:19', '1', 'system', 'Y', '/sample/views/sample/sampleDestory.html?type=1&statusType=3', '0', '2017-11-01 10:36:17', null);
INSERT INTO `t_pms_power` VALUES ('137', '未归还样品清空', null, '0', '119', '2', '2017-11-01 02:36:45', '1', 'system', 'Y', '/sample/views/sample/sampleDestory.html?type=1&statusType=13', '0', '2017-11-01 10:36:43', null);
INSERT INTO `t_pms_power` VALUES ('138', '检测样', null, '0', '120', '2', '2017-11-01 02:39:19', '1', 'system', 'Y', '/sample/views/sample/sampleCheckManage.html?type=0', '0', '2017-11-01 10:39:17', null);
INSERT INTO `t_pms_power` VALUES ('139', '留存样', null, '0', '120', '2', '2017-11-01 02:39:37', '1', 'system', 'Y', '/sample/views/sample/sampleCheckManage.html?type=1', '0', '2017-11-01 10:39:35', null);
INSERT INTO `t_pms_power` VALUES ('140', '采购申请', null, '0', '129', '2', '2017-11-01 02:40:14', '1', 'system', 'Y', '/sample/views/material/materialApply.html', '0', '2017-11-01 10:40:11', null);
INSERT INTO `t_pms_power` VALUES ('141', '领用申请', null, '0', '129', '2', '2017-11-01 02:40:38', '1', 'system', 'Y', '/sample/views/material/materialApplyOut.html', '0', '2017-11-01 10:40:36', null);
INSERT INTO `t_pms_power` VALUES ('142', '编码维护', null, '0', '129', '2', '2017-11-01 02:41:06', '1', 'system', 'Y', '/sample/views/system/sys_numberRule.html', '0', '2017-11-01 10:41:04', null);
INSERT INTO `t_pms_power` VALUES ('143', '基础维护', null, '0', '129', '2', '2017-11-01 02:41:27', '1', 'system', 'Y', '/sample/views/system/sys_dictionary.html', '0', '2017-11-01 10:41:25', null);
INSERT INTO `t_pms_power` VALUES ('144', '供货商信息', null, '0', '129', '2', '2017-11-01 02:41:54', '1', 'system', 'Y', '/sample/views/material/materialRated.html', '0', '2017-11-01 10:41:52', null);
INSERT INTO `t_pms_power` VALUES ('145', '物料预警设置', null, '0', '129', '2', '2017-11-01 02:42:17', '1', 'system', 'Y', '/sample/views/material/materialNewSetWarning.html', '0', '2017-11-01 10:42:15', null);
INSERT INTO `t_pms_power` VALUES ('146', '标准/基准物质', null, '0', '129', '2', '2017-11-01 02:42:39', '1', 'system', 'Y', '/sample/views/material/materialInventoryStandardBasis.html', '0', '2017-11-01 10:42:36', null);
INSERT INTO `t_pms_power` VALUES ('147', '标准/基准物质领用', null, '0', '129', '2', '2017-11-01 02:42:57', '1', 'system', 'Y', '/sample/views/material/materialStandardBasisReceive.html', '0', '2017-11-01 10:42:55', null);
INSERT INTO `t_pms_power` VALUES ('148', '存放位置', null, '0', '129', '2', '2017-11-01 02:43:27', '1', 'system', 'Y', '/', '0', '2017-11-01 10:43:25', null);
INSERT INTO `t_pms_power` VALUES ('149', '物料柜管理', null, '0', '148', '2', '2017-11-01 02:43:51', '1', 'system', 'Y', '/sample/views/cabinet/managementmaterial.html', '0', '2017-11-01 10:43:48', null);
INSERT INTO `t_pms_power` VALUES ('150', '物料格管理', null, '0', '148', '2', '2017-11-01 02:44:08', '1', 'system', 'Y', '/sample/views/grid/managementmaterial.html', '0', '2017-11-01 10:44:06', null);
INSERT INTO `t_pms_power` VALUES ('151', '统计管理', null, '0', '0', '2', '2017-11-02 07:42:31', '1', '超级管理员', 'Y', '#', '0', '2017-11-02 15:42:31', '');
INSERT INTO `t_pms_power` VALUES ('152', '报表统计', null, '0', '151', '2', '2017-11-01 02:44:47', '1', 'system', 'Y', '/sample/views/report/management_report.html', '0', '2017-11-01 10:44:45', null);
INSERT INTO `t_pms_power` VALUES ('153', '报表配置管理', null, '0', '151', '2', '2017-11-01 02:45:05', '1', 'system', 'Y', '/sample/views/report/report_manager.html', '0', '2017-11-01 10:45:03', null);
INSERT INTO `t_pms_power` VALUES ('154', '权限001', null, '0', '0', '1', '2017-12-11 10:49:11', '282', 'PGG', 'N', '/pms-core/views/posts/posts.html', '0', '2017-12-11 10:49:11', null);
INSERT INTO `t_pms_power` VALUES ('155', '54567', null, '0', '3', '1', '2017-12-21 14:43:55', '282', 'PGG', 'N', '/pms-core/views/user/userline.html', '0', '2017-12-21 14:43:55', '<i class=\"fa fa-window-close\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('156', '表单管理', null, '0', '0', '3', '2018-11-28 12:23:33', '1', '超级管理员', 'Y', '/', '0', '2018-11-28 12:23:33', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('157', '表单模板', null, '0', '156', '3', '2017-12-29 13:18:46', '1', '超级管理员', 'Y', 'views/template/template.html', '0', '2017-12-29 13:18:46', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('158', '表单元素', null, '0', '156', '3', '2018-01-02 09:53:05', '1', '超级管理员', 'Y', 'views/field/field.html', '0', '2018-01-02 09:53:05', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('159', '下拉类型', null, '0', '156', '3', '2018-01-04 10:59:01', '1', '超级管理员', 'Y', 'views/field/fieldDdType.html', '0', '2018-01-04 10:59:01', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('160', '下拉数据', null, '0', '156', '3', '2018-01-04 10:59:17', '1', '超级管理员', 'Y', 'views/field/fieldDdData.html', '0', '2018-01-04 10:59:17', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('161', '测试权限1_', '这是用于测试的菜单', '0', '0', '3', '2019-01-24 13:39:48', '1', '超级管理员', 'Y', '/', '0', '2019-01-24 13:39:51', '<i class=\"fa fa-fw fa-gears\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('162', '测试权限11', null, '0', '161', '3', '2018-09-12 14:12:08', '1', '超级管理员', 'N', 'www.baidu.com', '0', '2018-09-12 14:12:08', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('169', '服务', null, '0', '0', '5', '2018-09-12 15:18:00', '1', '超级管理员', 'N', '/', '0', '2018-09-12 15:18:00', '<i class=\"fa fa-fw fa-list\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('170', '委托单', '键安德委托单页面', '0', '0', '5', '2019-05-09 13:28:44', '1', '超级管理员', 'N', 'views/order/so_management_jad.html', '0', '2019-05-09 13:28:44', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('171', '流程管理', '', '0', '0', '6', '2019-02-16 09:46:01', '1', '超级管理员', 'Y', 'views/flow/flow_management.html', '0', '2019-02-16 09:46:01', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('172', '样品管理', null, '0', '0', '7', '2018-09-12 15:20:15', '1', '超级管理员', 'Y', 'views/sample/sample_management.html', '0', '2018-09-12 15:20:15', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('173', '生物体系管理', null, '0', '0', '8', '2018-09-27 14:04:52', '1', '超级管理员', 'Y', '/lims-web-bms/views/biosystem/biosystem_management.html', '0', '2018-09-27 14:04:52', '');
INSERT INTO `t_pms_power` VALUES ('174', '方法开发记录', '', '0', '0', '9', '2019-03-17 10:30:00', '1', '超级管理员', 'Y', '/lims-web-mds/views/methodDevelopment/management.html', '0', '2019-03-17 10:30:00', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('175', '计划书管理', '', '0', '0', '10', '2019-04-18 16:59:40', '1', '超级管理员', 'Y', '/lims-web-psms/views/prospectus/prospectus_management.html', '0', '2019-04-18 16:59:40', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('176', '标准物质', null, '0', '0', '11', '2018-11-16 11:11:55', '1', '超级管理员', 'Y', 'views/material/material_management.html', '0', '2018-11-16 11:11:55', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('177', '标物库存', null, '0', '0', '11', '2018-11-21 17:34:17', '1', '超级管理员', 'Y', 'views/inventory/inventory_management.html', '0', '2018-11-21 17:34:17', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('178', '标准溶液', null, '0', '0', '11', '2018-12-15 14:09:35', '1', '超级管理员', 'Y', 'views/solution/standardSolution_management.html', '0', '2018-12-15 14:09:35', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('182', '报告模板', null, '0', '183', '3', '2018-11-29 15:53:42', '1', '超级管理员', 'Y', 'views/resource/resource_management.html', '0', '2018-11-29 15:53:42', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('183', '报告管理', null, '0', '0', '3', '2018-11-28 15:16:51', '1', '超级管理员', 'Y', '', '0', '2018-11-28 15:16:51', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('184', '模板关联', null, '0', '183', '3', '2018-11-29 15:52:29', '1', '超级管理员', 'N', 'views/report/report_relation.html', '0', '2018-11-29 15:52:29', '<i class=\"fa fa-cog\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('185', '系统属性', null, '0', '0', '11', '2018-12-04 10:42:10', '1', '超级管理员', 'Y', 'views/system/attribute_management.html', '0', '2018-12-04 10:42:10', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('186', '试验管理', '', '0', '0', '12', '2019-03-18 16:31:05', '1', '超级管理员', 'Y', '/lims-web-ems/views/experiment/experiment_management.html', '0', '2019-03-18 16:31:05', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('187', '试验溶液', null, '0', '0', '11', '2018-12-15 14:10:33', '1', '超级管理员', 'Y', 'views/solution/testSolution_management.html', '0', '2018-12-15 14:10:33', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('188', '系统属性', '', '2', '0', '5', '2019-04-24 15:40:04', '1', '超级管理员', 'Y', 'views/system/attribute_management.html', '0', '2019-04-24 15:40:04', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('189', '委托单', '健安德外部人员使用的委托单页面', '0', '0', '5', '2019-05-09 13:21:21', '1', '超级管理员', 'N', 'views/order/so_management_jadOutsideOrg.html', '0', '2019-05-09 13:21:21', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('190', '委托单', '委托单主页面', '0', '0', '5', '2019-02-21 10:24:41', '1', '超级管理员', 'Y', 'views/order/so_management.html', '0', '2019-02-21 10:24:41', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('191', '存放位置', '', '0', '0', '11', '2019-03-11 09:37:21', '1', '超级管理员', 'Y', 'views/storageLocation/storageLocation_management.html', '0', '2019-03-11 09:37:21', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('192', '系统属性', '', '3', '0', '7', '2019-04-29 08:56:58', '1', '超级管理员', 'Y', 'views/system/attribute_management.html', '0', '2019-04-29 08:56:58', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('193', '报告编制', '', '0', '0', '13', '2019-04-18 14:45:50', '1', '超级管理员', 'Y', 'views/report/reportPreparation_management.html', '0', '2019-04-18 14:45:50', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('194', '系统属性', '', '0', '0', '9', '2019-04-15 13:30:45', '1', '超级管理员', 'Y', 'views/system/attribute_management.html', '0', '2019-04-15 13:30:44', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('195', '系统属性', '', '0', '0', '12', '2019-04-15 15:26:07', '1', '超级管理员', 'Y', 'views/system/attribute_management.html', '0', '2019-04-15 15:26:06', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('196', '系统属性', '', '0', '0', '10', '2019-04-15 15:34:29', '1', '超级管理员', 'Y', 'views/system/attribute_management.html', '0', '2019-04-15 15:34:29', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('197', '最终报告', '', '0', '0', '13', '2019-04-18 14:43:23', '1', '超级管理员', 'Y', 'views/report/finalReport_management.html', '0', '2019-04-18 14:43:23', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('198', '用户操作记录', 'OMS用户操作日志', '1', '0', '5', '2019-04-24 15:39:54', '1', '超级管理员', 'Y', 'views/userLog/user_log.html', '0', '2019-04-24 15:39:54', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('199', '检测费用维护', '', '2', '0', '7', '2019-05-07 14:29:36', '1', '超级管理员', 'Y', 'views/price/testPrice_management.html', '0', '2019-05-07 14:29:36', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('200', '称样管理', '', '1', '0', '7', '2019-04-29 17:42:34', '1', '超级管理员', 'Y', 'views/sampling/sampling_management.html', '0', '2019-04-29 17:42:34', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('201', '检测目的维护', '', '2', '0', '7', '2019-04-30 14:16:50', '1', '超级管理员', 'Y', 'views/testPurpose/testPurpose_management.html', '0', '2019-04-30 14:16:50', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('202', '主计划表', '', '1', '0', '5', '2019-05-09 16:06:10', '1', '超级管理员', 'Y', 'views/plan/plan_management.html', '0', '2019-05-09 16:06:10', '<i class=\"fa fa-fw fa-list-ol\" aria-hidden=\"true\"></i>');
INSERT INTO `t_pms_power` VALUES ('203', '原始记录管理', '', '0', '0', '14', '2019-05-10 14:14:14', '1', '超级管理员', 'Y', 'views/rawRecord/management.html', '0', '2019-05-10 14:14:14', null);

-- ----------------------------
-- Table structure for `t_pms_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_pms_role`;
CREATE TABLE `t_pms_role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `role_name` varchar(50) DEFAULT NULL COMMENT '角色名',
  `org_id` bigint(20) DEFAULT NULL COMMENT '组织机构编号',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pms_role
-- ----------------------------
INSERT INTO `t_pms_role` VALUES ('1', '超级管理员', '1', '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_role` VALUES ('2', '机构管理员', '1', '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_role` VALUES ('3', '老师', '2', '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_role` VALUES ('4', '学员', '2', '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_role` VALUES ('5', '业务员', '2', '2020-07-04 15:31:37', '2020-07-04 15:31:41', '超级管理员', '超级管理员');

-- ----------------------------
-- Table structure for `t_pms_role_to_power`
-- ----------------------------
DROP TABLE IF EXISTS `t_pms_role_to_power`;
CREATE TABLE `t_pms_role_to_power` (
  `p_id` bigint(20) NOT NULL COMMENT '权限编号',
  `r_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`p_id`,`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pms_role_to_power
-- ----------------------------

-- ----------------------------
-- Table structure for `t_pms_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_pms_user`;
CREATE TABLE `t_pms_user` (
  `user_id` bigint(10) NOT NULL COMMENT '用户编号',
  `user_name` varchar(255) NOT NULL COMMENT '账号',
  `org_id` bigint(20) NOT NULL COMMENT '组织机构编号',
  `is_delete` bigint(2) DEFAULT '0' COMMENT '删除标记',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`user_id`),
  UNIQUE KEY `index_1` (`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pms_user
-- ----------------------------
INSERT INTO `t_pms_user` VALUES ('1', 'system', '1', '0', '2020-07-04 15:31:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('732', '13985111937', '2', '0', '2020-07-04 15:31:37', '2020-08-24 14:55:39', '超级管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('787', '13212354706', '1', '0', '2020-08-01 11:23:00', '2020-08-01 11:23:11', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('1022', '18084572928', '32', '0', '2020-08-20 18:19:00', '2020-08-20 19:36:50', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('1179', '18275008418', '1', '0', '2020-07-28 12:01:00', '2020-07-28 12:01:35', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('4199', '15086532411', '3', '0', '2020-07-04 15:31:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4201', '18800105773', '3', '0', '2020-07-04 15:31:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4202', '18083276539', '3', '0', '2020-07-04 15:32:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4212', '15519936902', '3', '0', '2020-07-04 15:33:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4229', '18208676102', '3', '0', '2020-07-04 15:34:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4230', '18285904486', '3', '0', '2020-07-04 15:35:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4236', '13595922516', '3', '0', '2020-07-04 15:36:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4238', '15117309311', '3', '0', '2020-07-04 15:37:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4248', '15808597658', '3', '0', '2020-07-04 15:38:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4846', '13984817616', '3', '0', '2020-07-04 15:39:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4848', '15284609905', '5', '0', '2020-07-04 15:40:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4849', '15008579894', '5', '0', '2020-07-04 15:41:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4850', '18396902878', '5', '0', '2020-07-04 15:42:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4851', '15186066500', '5', '0', '2020-07-04 15:43:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4852', '13721593317', '5', '0', '2020-07-04 15:44:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4853', '18748587833', '5', '0', '2020-07-04 15:45:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4854', '15117672269', '5', '0', '2020-07-04 15:46:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4855', '13638571499', '5', '0', '2020-07-04 15:47:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4856', '13984794513', '5', '0', '2020-07-04 15:48:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4857', '13678545933', '4', '0', '2020-07-04 15:50:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4858', '136785459331', '4', '0', '2020-07-04 15:51:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4859', '15267981565', '4', '0', '2020-07-04 15:52:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4860', '18785467553', '4', '0', '2020-07-04 15:53:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4861', '18385623353', '4', '0', '2020-07-04 15:54:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4862', '15286226641', '4', '0', '2020-07-04 15:55:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('4863', '16685140758', '4', '0', '2020-07-04 15:56:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10099', '15870331680', '2', '0', '2020-08-27 16:06:21', '2020-08-27 16:06:21', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10107', '13985518418', '5', '0', '2020-07-04 15:57:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10108', '18785139777', '5', '0', '2020-07-04 15:58:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10109', '13595103787', '5', '0', '2020-07-04 15:59:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10110', '13511996907', '5', '0', '2020-07-04 16:00:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10111', '13985422725', '5', '0', '2020-07-04 16:01:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10112', '17385816017', '5', '0', '2020-07-04 16:02:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10113', '18984190927', '5', '0', '2020-07-04 16:03:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10114', '13809407008', '5', '0', '2020-07-04 16:04:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10115', '15185043563', '5', '0', '2020-07-04 16:05:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10116', '15180878842', '5', '0', '2020-07-04 16:06:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10117', '17785951150', '5', '0', '2020-07-04 16:07:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10118', '18623106353', '5', '0', '2020-07-04 16:08:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10119', '15761691449', '5', '0', '2020-07-04 16:09:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10120', '18285113590', '5', '0', '2020-07-04 16:10:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10121', '13985510533', '5', '0', '2020-07-04 16:11:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10122', '15086588105', '5', '0', '2020-07-04 16:12:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10123', '18786814998', '5', '0', '2020-07-04 16:13:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10124', '13885396194', '5', '0', '2020-07-04 16:14:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10125', '13885077527', '5', '0', '2020-07-04 16:15:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10126', '13984350240', '5', '0', '2020-07-04 16:16:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10127', '13312224911', '5', '0', '2020-07-04 16:17:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10128', '16608510622', '5', '0', '2020-07-04 16:18:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10129', '15185145950', '5', '0', '2020-07-04 16:19:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10130', '18786784167', '5', '0', '2020-07-04 16:20:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10131', '13984331317', '5', '0', '2020-07-04 16:21:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10132', '13809474380', '5', '0', '2020-07-04 16:22:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10133', '13595010088', '5', '0', '2020-07-04 16:23:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10134', '18286102006', '5', '0', '2020-07-04 16:24:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10135', '18798785503', '5', '0', '2020-07-04 16:25:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10136', '13518543174', '5', '0', '2020-07-04 16:26:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10137', '13885022301', '5', '0', '2020-07-04 16:27:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10138', '15933988765', '5', '0', '2020-07-04 16:28:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10139', '13583982038', '5', '0', '2020-07-04 16:29:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10140', '13985309183', '5', '0', '2020-07-04 16:30:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10141', '15722133437', '5', '0', '2020-07-04 16:31:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10142', '18685151033', '5', '0', '2020-07-04 16:32:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10143', '13985123861', '5', '0', '2020-07-04 16:33:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10144', '15870135225', '5', '0', '2020-07-04 16:34:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10145', '18285096088', '5', '0', '2020-07-04 16:35:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10146', '18934458111', '5', '0', '2020-07-04 16:36:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10147', '13984456117', '5', '0', '2020-07-04 16:37:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10148', '13595006989', '5', '0', '2020-07-04 16:38:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10149', '13985754395', '5', '0', '2020-07-04 16:39:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10150', '18984193981', '5', '0', '2020-07-04 16:40:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10151', '13809474154', '5', '0', '2020-07-04 16:41:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10152', '18585066089', '5', '0', '2020-07-04 16:42:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10153', '15985103048', '5', '0', '2020-07-04 16:43:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10154', '13809483225', '5', '0', '2020-07-04 16:44:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10155', '18984173851', '5', '0', '2020-07-04 16:45:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10156', '13511947756', '5', '0', '2020-07-04 16:46:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10157', '18285076691', '5', '0', '2020-07-04 16:47:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10158', '13608535340', '5', '0', '2020-07-04 16:48:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10159', '17385616136', '5', '0', '2020-07-04 16:49:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10160', '13985192321', '5', '0', '2020-07-04 16:51:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10161', '18984392102', '5', '0', '2020-07-04 16:52:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10162', '18286020616', '5', '0', '2020-07-04 16:53:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10163', '15339513219', '5', '0', '2020-07-04 16:54:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10164', '13809410015', '5', '0', '2020-07-04 16:55:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10165', '18985660739', '5', '0', '2020-07-04 16:56:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10166', '15984099721', '5', '0', '2020-07-04 16:57:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10167', '18385002605', '5', '0', '2020-07-04 16:58:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10168', '18212717584', '5', '0', '2020-07-04 16:59:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10169', '17684070197', '5', '0', '2020-07-04 17:00:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10170', '18286418192', '5', '0', '2020-07-04 17:01:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10171', '15186822562', '5', '0', '2020-07-04 17:02:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10172', '18087718346', '5', '0', '2020-07-04 17:03:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10173', '13964691293', '5', '0', '2020-07-04 17:04:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10174', '15085820014', '5', '0', '2020-07-04 17:05:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10175', '13398540239', '5', '0', '2020-07-04 17:06:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10176', '18786656000', '5', '0', '2020-07-04 17:07:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10177', '13984149909', '5', '0', '2020-07-04 17:08:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10178', '15285998975', '5', '0', '2020-07-04 17:09:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10179', '15685125694', '5', '0', '2020-07-04 17:10:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10180', '15285541409', '5', '0', '2020-07-04 17:11:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10181', '15662569259', '5', '0', '2020-07-04 17:12:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10182', '13953660276', '5', '0', '2020-07-04 17:13:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10183', '18785117707', '5', '0', '2020-07-04 17:14:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10184', '13964772559', '5', '0', '2020-07-04 17:15:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10185', '13924744217', '5', '0', '2020-07-04 17:16:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10190', '18685005206', '5', '0', '2020-07-04 17:17:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10192', '18985563349', '5', '0', '2020-07-04 17:18:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10199', '17784165672', '5', '0', '2020-07-04 17:19:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10202', '13885179324', '5', '0', '2020-07-04 17:20:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10204', '18798105635', '5', '0', '2020-07-04 17:21:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10206', '15186518482', '5', '0', '2020-07-04 17:22:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10207', '18585032353', '5', '0', '2020-07-04 17:23:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10208', '13337840586', '5', '0', '2020-07-04 17:24:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10209', '18285027724', '5', '0', '2020-07-04 17:25:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10217', '15187729617', '5', '0', '2020-07-04 17:26:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10222', '15285178642', '5', '0', '2020-07-04 17:27:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10278', '15885104479', '5', '0', '2020-07-04 17:28:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10279', '18334178977', '5', '0', '2020-07-04 17:29:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10281', '18286966871', '5', '0', '2020-07-04 17:30:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10285', '18286909252', '5', '0', '2020-07-04 17:31:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10286', '18385055992', '5', '0', '2020-07-04 17:32:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10296', '18212000780', '5', '0', '2020-07-04 17:33:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10299', '13985581583', '5', '0', '2020-07-04 17:34:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10303', '15285523341', '5', '0', '2020-07-04 17:35:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10318', '15985147097', '5', '0', '2020-07-04 17:36:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10319', '18286122160', '5', '0', '2020-07-04 17:37:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10321', '17385911337', '5', '0', '2020-07-04 17:38:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10322', '13335213810', '5', '0', '2020-07-04 17:39:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10323', '15069655269', '5', '0', '2020-07-04 17:40:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10324', '13985573356', '5', '0', '2020-07-04 17:41:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10325', '15908004515', '5', '0', '2020-07-04 17:42:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10326', '13518506403', '5', '0', '2020-07-04 17:43:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10327', '15285590715', '5', '0', '2020-07-04 17:44:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10328', '13854465707', '5', '0', '2020-07-04 17:45:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10337', '18286014730', '5', '0', '2020-07-04 17:46:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10360', '13638519851', '5', '0', '2020-07-04 17:47:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10361', '13984127882', '5', '0', '2020-07-04 17:48:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10362', '15885881568', '5', '0', '2020-07-04 17:49:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10363', '15121278223', '5', '0', '2020-07-04 17:50:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10364', '18785358959', '5', '0', '2020-07-04 17:51:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10365', '18334154151', '5', '0', '2020-07-04 17:53:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10366', '15117767110', '5', '0', '2020-07-04 17:54:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10367', '18685352366', '5', '0', '2020-07-04 17:55:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10368', '18224618720', '5', '0', '2020-07-04 17:56:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10369', '13885122744', '5', '0', '2020-07-04 17:57:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10370', '18485786004', '5', '0', '2020-07-04 17:58:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10371', '18786449683', '5', '0', '2020-07-04 17:59:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10372', '13619611736', '5', '0', '2020-07-04 18:00:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10373', '15286342637', '5', '0', '2020-07-04 18:01:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10374', '18253692968', '5', '0', '2020-07-04 18:02:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10375', '18286336376', '5', '0', '2020-07-04 18:03:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10376', '13648530835', '5', '0', '2020-07-04 18:04:00', '2020-07-04 15:31:41', '超级管理员', '超级管理员');
INSERT INTO `t_pms_user` VALUES ('10579', '18275999999', '19', '0', '2020-07-04 18:05:00', '2020-08-07 22:22:48', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10580', '18275888888', '23', '0', '2020-07-04 18:06:00', '2020-08-07 22:30:23', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10581', '4564', '1', '0', '2020-07-04 18:07:00', '2020-08-07 23:12:20', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10679', '17608506257', '34', '0', '2020-07-04 18:08:00', '2020-08-20 18:38:59', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10689', '0823测试', '35', '0', '2020-08-23 11:48:29', '2020-08-23 12:20:45', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10690', '0823测试②', '36', '0', '2020-08-23 12:41:00', '2020-08-26 10:15:09', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10705', '18224702809', '37', '0', '2020-08-26 10:00:07', '2020-08-26 10:02:17', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10712', '13339633732', '38', '0', '2020-08-26 10:44:19', '2020-08-26 14:37:31', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10718', '13017489117', '39', '0', '2020-08-26 15:43:43', '2020-08-27 14:33:50', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10719', '19974602272', '39', '0', '2020-08-26 16:20:08', '2020-08-26 16:20:08', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10724', '13145201200', '39', '0', '2020-08-27 15:24:58', '2020-08-27 15:24:58', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10754', '13145201101', '39', '0', '2020-09-01 15:43:31', '2020-09-01 15:56:26', '管理员', '管理员');
INSERT INTO `t_pms_user` VALUES ('10981', 'test.com_1', '11', '0', '2020-09-29 17:38:01', '2020-09-29 17:38:01', '一带一路管理员', '一带一路管理员');
INSERT INTO `t_pms_user` VALUES ('10982', 'gas.shanhaiyh.com_2', '11', '0', '2020-09-29 17:46:42', '2020-09-29 17:46:42', '一带一路管理员', '一带一路管理员');
INSERT INTO `t_pms_user` VALUES ('10983', 'gas.shanhaiyh.com_25', '11', '0', '2020-09-30 10:02:13', '2020-09-30 10:02:13', '一带一路管理员', '一带一路管理员');
INSERT INTO `t_pms_user` VALUES ('10986', 'gas.shanhaiyh.com_31', '11', '0', '2020-10-05 11:48:12', '2020-10-05 11:48:12', '一带一路管理员', '一带一路管理员');
INSERT INTO `t_pms_user` VALUES ('10987', 'gas.shanhaiyh.com_33', '11', '0', '2020-10-09 10:13:27', '2020-10-09 10:13:27', '一带一路管理员', '一带一路管理员');

-- ----------------------------
-- Table structure for `t_pms_user_to_role`
-- ----------------------------
DROP TABLE IF EXISTS `t_pms_user_to_role`;
CREATE TABLE `t_pms_user_to_role` (
  `u_id` bigint(20) NOT NULL COMMENT '用户编号',
  `r_id` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`u_id`,`r_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_pms_user_to_role
-- ----------------------------
INSERT INTO `t_pms_user_to_role` VALUES ('1', '1');
INSERT INTO `t_pms_user_to_role` VALUES ('1022', '3');
INSERT INTO `t_pms_user_to_role` VALUES ('1022', '5');
INSERT INTO `t_pms_user_to_role` VALUES ('4199', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4200', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4201', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4202', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4212', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4229', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4230', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4236', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4238', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4248', '6');
INSERT INTO `t_pms_user_to_role` VALUES ('4848', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4849', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4850', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4851', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4852', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4853', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4854', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4855', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4856', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('4857', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('4858', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('4859', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('4860', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('4861', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('4862', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('4863', '8');
INSERT INTO `t_pms_user_to_role` VALUES ('10099', '5');
INSERT INTO `t_pms_user_to_role` VALUES ('10107', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10108', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10109', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10110', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10111', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10112', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10113', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10114', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10115', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10116', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10117', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10118', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10119', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10120', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10121', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10122', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10123', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10124', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10125', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10126', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10127', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10128', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10129', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10130', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10131', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10132', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10133', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10134', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10135', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10136', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10137', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10138', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10139', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10140', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10141', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10142', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10143', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10144', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10145', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10146', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10147', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10148', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10149', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10150', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10151', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10152', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10153', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10154', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10155', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10156', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10157', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10158', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10159', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10160', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10161', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10162', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10163', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10164', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10165', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10166', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10167', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10168', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10169', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10170', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10171', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10172', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10173', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10174', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10175', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10176', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10177', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10178', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10179', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10180', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10181', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10182', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10183', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10184', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10185', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10204', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10206', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10207', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10208', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10278', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10279', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10281', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10285', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10286', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10296', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10299', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10303', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10318', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10319', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10321', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10322', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10323', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10324', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10325', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10326', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10327', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10337', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10360', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10360', '10');
INSERT INTO `t_pms_user_to_role` VALUES ('10361', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10362', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10363', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10364', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10365', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10366', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10367', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10368', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10369', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10370', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10371', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10372', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10373', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10374', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10375', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10376', '0');
INSERT INTO `t_pms_user_to_role` VALUES ('10679', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10689', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10689', '3');
INSERT INTO `t_pms_user_to_role` VALUES ('10689', '4');
INSERT INTO `t_pms_user_to_role` VALUES ('10689', '5');
INSERT INTO `t_pms_user_to_role` VALUES ('10690', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10690', '3');
INSERT INTO `t_pms_user_to_role` VALUES ('10690', '4');
INSERT INTO `t_pms_user_to_role` VALUES ('10690', '5');
INSERT INTO `t_pms_user_to_role` VALUES ('10705', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10705', '3');
INSERT INTO `t_pms_user_to_role` VALUES ('10705', '4');
INSERT INTO `t_pms_user_to_role` VALUES ('10705', '5');
INSERT INTO `t_pms_user_to_role` VALUES ('10712', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10712', '3');
INSERT INTO `t_pms_user_to_role` VALUES ('10712', '4');
INSERT INTO `t_pms_user_to_role` VALUES ('10712', '5');
INSERT INTO `t_pms_user_to_role` VALUES ('10718', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10718', '3');
INSERT INTO `t_pms_user_to_role` VALUES ('10719', '4');
INSERT INTO `t_pms_user_to_role` VALUES ('10724', '4');
INSERT INTO `t_pms_user_to_role` VALUES ('10754', '2');
INSERT INTO `t_pms_user_to_role` VALUES ('10754', '3');

-- ----------------------------
-- Table structure for `t_study_adviser`
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
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_adviser
-- ----------------------------
INSERT INTO `t_study_adviser` VALUES ('8', '1', 'http://res.common.shiant.com/images/study/management/case/cover/68/68bf1cfc6ffb4cb084aa352c9b807412.jpg', '1111', '2', '2', '2', null, '而且去', '1', '1', '山海云汇教育科技公司', '0', '2020-09-20 22:45:40', '2020-09-20 22:45:40', '管理员', '管理员', '1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `t_study_adviser` VALUES ('9', '11', 'http://res.common.shiant.com/images/study/management/adviser/cover/75/75d68c92565249da8bf08376ab48e66f.png', '22', '33', '44', '55', '6', '77', '1', '1', '山海云汇教育科技公司', null, '2020-09-23 16:20:57', '2020-09-23 16:48:02', '管理员', '管理员', '1', '留学咨询及办理', '背景提升', null, null, '境外转学', '留学金融', null, '留学安全', '留学保险', null, '学历认证', null, '就业/创业', null, null, null, null, null, null, null);
INSERT INTO `t_study_adviser` VALUES ('11', '杨陈', 'http://res.common.shiant.com/images/study/management/adviser/cover/d8/d8c8940414ab4eccb2c1d138b5796e8b.jpg', '高级留学咨询顾问', '教育背景介绍', '2011年至今', '主要项目介绍', '贵阳', '顾问简介', '1', '2', '山海云汇', '0', '2020-09-27 07:22:09', '2020-09-27 07:22:09', '李文彪', '李文彪', '1', '留学咨询及办理', '背景提升', '艺术留学', '航空服务', '境外转学', '留学金融', '升学指导', '留学安全', '留学保险', '海外租房', '学历认证', '积分落户', '就业/创业', null, null, null, null, null, null, null);
INSERT INTO `t_study_adviser` VALUES ('12', '赵其祥', 'http://res.common.shiant.com/images/study/management/adviser/cover/da/da0eb591b4174df8ace146be9e73b59b.jpg', '高级留学咨询顾问', '教育背景介绍', '2010年至今', '主要项目介绍', '北京', '顾问简介', '1', '2', '山海云汇', '0', '2020-09-27 07:24:05', '2020-09-27 07:24:05', '李文彪', '李文彪', '1', '留学咨询及办理', '背景提升', '艺术留学', '航空服务', '境外转学', '留学金融', '升学指导', '留学安全', '留学保险', '海外租房', '学历认证', '积分落户', '就业/创业', null, null, null, null, null, null, null);
INSERT INTO `t_study_adviser` VALUES ('13', '谢荣深', 'http://res.common.shiant.com/images/study/management/adviser/cover/25/25781cb1b7094f58b3aa484534987247.jpg', '高级留学咨询顾问', '教育背景介绍', '2011年至今', '主要项目介绍', '上海', '顾问简介', '1', '2', '山海云汇', '0', '2020-09-27 07:25:32', '2020-09-27 07:25:32', '李文彪', '李文彪', '1', '留学咨询及办理', '背景提升', '艺术留学', '航空服务', null, '留学金融', null, null, null, null, '学历认证', '积分落户', '就业/创业', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `t_study_article`
-- ----------------------------
DROP TABLE IF EXISTS `t_study_article`;
CREATE TABLE `t_study_article` (
  `aid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `type` varchar(50) DEFAULT NULL COMMENT '文章类型',
  `cover_file` varchar(500) DEFAULT NULL COMMENT '封面地址',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '内容',
  `order` int(11) DEFAULT '1' COMMENT '排序',
  `show_time` bigint(50) DEFAULT '0' COMMENT '展示次数',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_article
-- ----------------------------
INSERT INTO `t_study_article` VALUES ('8', '最新动态', 'http://res.common.shiant.com/images/study/management/case/cover/68/68bf1cfc6ffb4cb084aa352c9b807412.jpg', '1111', '而且去', '1', '0', '2020-09-20 22:45:40', '2020-09-20 22:45:40', '管理员', '管理员');
INSERT INTO `t_study_article` VALUES ('9', '政策法规', 'http://res.common.shiant.com/images/study/management/adviser/cover/75/75d68c92565249da8bf08376ab48e66f.png', '22', '77', '1', null, '2020-09-23 16:20:57', '2020-09-23 16:48:02', '管理员', '管理员');
INSERT INTO `t_study_article` VALUES ('11', '行业报告', 'http://res.common.shiant.com/images/study/management/adviser/cover/d8/d8c8940414ab4eccb2c1d138b5796e8b.jpg', '高级留学咨询顾问', '顾问简介', '1', '0', '2020-09-27 07:22:09', '2020-09-27 07:22:09', '李文彪', '李文彪');
INSERT INTO `t_study_article` VALUES ('12', '留学预警', 'http://res.common.shiant.com/images/study/management/adviser/cover/da/da0eb591b4174df8ace146be9e73b59b.jpg', '高级留学咨询顾问', '顾问简介', '1', '0', '2020-09-27 07:24:05', '2020-09-27 07:24:05', '李文彪', '李文彪');
INSERT INTO `t_study_article` VALUES ('13', '热门新闻', 'http://res.common.shiant.com/images/study/management/adviser/cover/25/25781cb1b7094f58b3aa484534987247.jpg', '高级留学咨询顾问', '顾问简介', '1', '0', '2020-09-27 07:25:32', '2020-09-27 07:25:32', '李文彪', '李文彪');
INSERT INTO `t_study_article` VALUES ('14', '头条新闻', 'http://res.common.shiant.com/images/study/management/adviser/cover/da/da0eb591b4174df8ace146be9e73b59b.jpg', '234234', '234234', '1', '0', '2020-09-27 07:25:32', '2020-09-27 07:25:32', '李文彪', '李文彪');

-- ----------------------------
-- Table structure for `t_study_case`
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
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_case
-- ----------------------------
INSERT INTO `t_study_case` VALUES ('1', '11', 'http://res.common.shiant.com/images/study/management/case/cover/c0/c00cbfb36a194744a202f863140fd0ba.png', '1<b>23<i>46</i></b>', '22', '33', '44', '55', '66', '1', '山海云汇教育科技公司', '77', '2020-09-18 20:12:21', '2020-09-18 20:58:46', '管理员', '管理员', '0');
INSERT INTO `t_study_case` VALUES ('6', '2', '', '3', '5', '3', '45', '5', '1', '1', '山海云汇教育科技公司', '0', '2020-09-18 21:00:35', '2020-09-18 21:00:35', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('7', '22', 'http://res.common.shiant.com/images/study/management/case/cover/3e/3ee88d48bb934587873a855e4397ecbe.png', '呜呜呜呜&nbsp;', '11', '111', '111', '11', '1', '1', '山海云汇教育科技公司', '0', '2020-09-20 21:54:52', '2020-09-20 21:54:52', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('8', '1111', 'http://res.common.shiant.com/images/study/management/case/cover/68/68bf1cfc6ffb4cb084aa352c9b807412.jpg', '而且去', '1', '2', '2', '2', '1', '1', '山海云汇教育科技公司', '0', '2020-09-20 22:45:40', '2020-09-20 22:45:40', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('9', '12', '', '12', '12', '1', '12', '12', '1', '1', '山海云汇教育科技公司', '0', '2020-09-23 18:38:19', '2020-09-23 19:04:37', '管理员', '管理员', '1');
INSERT INTO `t_study_case` VALUES ('11', '案例1', 'http://res.common.shiant.com/images/study/management/case/cover/3f/3fc3035efd894999a5edafaaf7fade0c.jpg', '案例正文', 'A同学', 'A学校', 'A专业', '500', '1', '2', '山海云汇', '226', '2020-09-27 07:43:35', '2020-09-27 07:43:35', '李文彪', '李文彪', '1');
INSERT INTO `t_study_case` VALUES ('12', '案例2', 'http://res.common.shiant.com/images/study/management/case/cover/76/76fc43617a134dada7002401e5893f09.jpg', '案例正文', 'B同学', 'B学校', 'B专业', '490', '1', '2', '山海云汇', '490', '2020-09-27 07:44:27', '2020-09-27 07:44:27', '李文彪', '李文彪', '1');

-- ----------------------------
-- Table structure for `t_study_case_to_adviser`
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
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

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
INSERT INTO `t_study_case_to_adviser` VALUES ('12', '11', '11', null, null, null, null);
INSERT INTO `t_study_case_to_adviser` VALUES ('13', '11', '12', null, null, null, null);
INSERT INTO `t_study_case_to_adviser` VALUES ('14', '12', '13', null, null, null, null);

-- ----------------------------
-- Table structure for `t_study_complaint`
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
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_complaint
-- ----------------------------
INSERT INTO `t_study_complaint` VALUES ('11', '111', '2', '高利贷;客服不处理/处理不当;虚假/误导宣传;', '停止骚扰;解释;', '3', 'http://res.common.shiant.com/images/study/management/complaint/68/68fb00ea45d4404dbe89c8ced9759faf.jpg', 'http://res.common.shiant.com/images/study/management/complaint/22/22bd4de34c8a4d138a0822be8555e54b.png', 'http://res.common.shiant.com/images/study/management/complaint/9c/9c332c16eb3d48078d8e2d73080b82a1.png', '', '', '', '', '', '', '', '', '', '', null, null, '1', null, '1', '2020-09-20 13:31:42', '2020-09-20 17:06:58', '1', '管理员', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('12', '333', '3345', '高利贷;客服不处理/处理不当;服务不到位/态度差;', '赔偿;解释;下架产品;', '345465', 'http://res.common.shiant.com/images/study/management/complaint/68/68b3b048aec34de0b41121a241451f78.jpg', 'http://res.common.shiant.com/images/study/management/complaint/0a/0afbc983b9fe414cb509359553ca6f96.png', 'http://res.common.shiant.com/images/study/management/complaint/5e/5e5c004854e34ad8ab26ef447a29fbbe.png', '', '', '', '', '', '', '', 'http://res.common.shiant.com/video/study/management/complaint/09/09c3dbeab56a4a7c85c48a1ac96d3e62.mp4', 'http://res.common.shiant.com/video/study/management/complaint/bb/bbeded05ccf94de799b2121a6faef0cc.mp4', '', null, null, '1', null, '1', '2020-09-20 13:32:41', '2020-09-25 04:15:10', '1', '管理员', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('13', '111', '11', '骚扰;阴阳合同;', '依法追究责任;', '11', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '1', null, '1', '2020-09-20 21:55:51', '2020-09-20 21:56:01', '1', 'system', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('14', '222', '2', '侮辱;收费问题;', '道歉;作出处罚;', '2', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '1', null, '1', '2020-09-20 22:46:23', '2020-09-20 22:46:37', '1', 'system', '机构', '管理员');
INSERT INTO `t_study_complaint` VALUES ('16', 'A机构', '不合理竞争', '态度恶劣;威胁恐吓;', '道歉;作出处罚;赔偿;', '投诉细节', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '0', null, '2', '2020-09-27 07:45:36', '2020-09-27 07:45:36', '732', '13985111937', '机构', '李文彪');
INSERT INTO `t_study_complaint` VALUES ('17', 'B机构', '底价竞争', '收费问题;', '道歉;', '投诉明细', '', '', '', '', '', '', '', '', '', '', '', '', '', null, null, '0', null, '2', '2020-09-27 07:46:20', '2020-09-27 07:46:20', '732', '13985111937', '机构', '李文彪');

-- ----------------------------
-- Table structure for `t_study_profession`
-- ----------------------------
DROP TABLE IF EXISTS `t_study_profession`;
CREATE TABLE `t_study_profession` (
  `pid` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `sid` bigint(20) NOT NULL COMMENT '学院编号',
  `name` varchar(50) NOT NULL COMMENT '专业名称',
  `college` varchar(20) DEFAULT NULL COMMENT '所属学院',
  `degree` varchar(20) DEFAULT NULL COMMENT '毕业学位',
  `semester` bigint(10) DEFAULT NULL COMMENT '学期',
  `fee` bigint(10) DEFAULT NULL COMMENT '学费',
  `advantage` bigint(1) DEFAULT NULL COMMENT '是否是优势专业',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '更新时间',
  `creater` varchar(20) DEFAULT NULL COMMENT '创建人',
  `updater` varchar(20) DEFAULT NULL COMMENT '更新人',
  PRIMARY KEY (`pid`),
  KEY `index_1` (`sid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_profession
-- ----------------------------
INSERT INTO `t_study_profession` VALUES ('11', '80', '2', '高利贷;客服不处理/处理不当;虚假/误导', '停止骚扰;解释;', '3', '0', '0', '2020-09-20 13:31:42', '2020-09-20 17:06:58', '管理员', '管理员');
INSERT INTO `t_study_profession` VALUES ('12', '80', '3345', '高利贷;客服不处理/处理不当;服务不到位', '赔偿;解释;下架产品;', '345465', '0', '0', '2020-09-20 13:32:41', '2020-09-25 04:15:10', '管理员', '管理员');
INSERT INTO `t_study_profession` VALUES ('13', '81', '11', '骚扰;阴阳合同;', '依法追究责任;', '11', '0', '0', '2020-09-20 21:55:51', '2020-09-20 21:56:01', 'system', '管理员');
INSERT INTO `t_study_profession` VALUES ('14', '81', '2', '侮辱;收费问题;', '道歉;作出处罚;', '2', '0', '0', '2020-09-20 22:46:23', '2020-09-20 22:46:37', 'system', '管理员');
INSERT INTO `t_study_profession` VALUES ('16', '82', '不合理竞争', '态度恶劣;威胁恐吓;', '道歉;作出处罚;赔偿;', '0', '0', '0', '2020-09-27 07:45:36', '2020-09-27 07:45:36', '13985111937', '李文彪');
INSERT INTO `t_study_profession` VALUES ('17', '82', '底价竞争', '收费问题;', '道歉;', '0', '0', '0', '2020-09-27 07:46:20', '2020-09-27 07:46:20', '13985111937', '李文彪');

-- ----------------------------
-- Table structure for `t_study_school`
-- ----------------------------
DROP TABLE IF EXISTS `t_study_school`;
CREATE TABLE `t_study_school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `school_name_c` varchar(120) DEFAULT NULL COMMENT '院校名称（中文）',
  `school_name_e` varchar(255) DEFAULT NULL COMMENT '院校名称（英文）',
  `school_img` varchar(255) DEFAULT NULL COMMENT '学校图片',
  `school_logo` varchar(255) DEFAULT NULL COMMENT '学校logo',
  `schooling` varchar(100) DEFAULT NULL COMMENT '学费',
  `school_property` varchar(100) DEFAULT NULL COMMENT '院校性质',
  `new_students_enrollment` varchar(100) DEFAULT NULL COMMENT '招生人数',
  `school_country` varchar(30) DEFAULT NULL COMMENT '院校所属国',
  `province` varchar(20) DEFAULT NULL COMMENT '省',
  `city` varchar(20) DEFAULT NULL COMMENT '市',
  `area` varchar(20) DEFAULT NULL COMMENT '区',
  `school_address` varchar(255) DEFAULT NULL COMMENT '院校地址',
  `school_about` varchar(255) DEFAULT NULL COMMENT '院校简介',
  `create_date` date DEFAULT NULL COMMENT '创建日期',
  `update_date` date DEFAULT NULL COMMENT '更新日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=98 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_school
-- ----------------------------
INSERT INTO `t_study_school` VALUES ('80', '国外大学XXXX', '发给', 'http://47.112.113.89:18080/study-www-management/portal/img/yale_uni.png', 'http://47.112.113.89:18080/study-www-management/portal/img/harvard_badge.png', '10000', '公立大学', '100', '美国', null, null, null, null, '麻省理工学院（Massachusetts Institute of Technology），简称“麻省理工”（MIT），位于美国马萨诸塞州波士顿都市区剑桥市，主校区依查尔斯河而建，是世界著名私立研究型大学。 [1-3] 麻省理工学院创立于1861年，早期侧重应用科学及工程学，在第二次世界大战后，麻省理工学院倚靠美国国防科技的研发需要而迅速崛起。 [4-5] 在二战和冷战期间，麻省理工学院的研究人员对计算机、雷达以及惯性导航系统等科技发展作出了重要贡献二战和冷战期间，麻省理工学院的研究人员对计算机、雷达以及', '2020-09-22', '2020-09-22');
INSERT INTO `t_study_school` VALUES ('81', '国外大学XXXX1', 'fudan', 'http://47.112.113.89:18080/study-www-management/portal/img/yale_uni.png', 'http://47.112.113.89:18080/study-www-management/portal/img/harvard_badge.png', '20000', '公立大学', '200', '美国', null, null, null, '中华人民共和国', null, '2020-10-23', null);
INSERT INTO `t_study_school` VALUES ('94', '国外大学XXXX2', 'oyo', 'http://47.112.113.89:18080/study-www-management/portal/img/yale_uni.png', 'http://47.112.113.89:18080/study-www-management/portal/img/harvard_badge.png', '30000', '公立大学', '300', '德国', null, null, null, null, 'fsdfsdf', '2020-09-24', '2020-09-24');
INSERT INTO `t_study_school` VALUES ('95', '国外大学XXXX3', null, 'http://47.112.113.89:18080/study-www-management/portal/img/yale_uni.png', 'http://47.112.113.89:18080/study-www-management/portal/img/harvard_badge.png', '40000', '公立大学', '400', '德国', null, null, null, null, null, '2020-10-14', null);
INSERT INTO `t_study_school` VALUES ('96', '剑桥', 'jianqiao', '第三方', null, '发给', 'sad', '但是', '美国', null, null, null, '水电费', '是', '2019-09-09', '2020-09-10');
INSERT INTO `t_study_school` VALUES ('97', '哈', 'fudan', '不知道是不是官方', null, '哈哈哈', null, null, '法国', null, null, null, '中华民族', null, '2020-10-23', null);

-- ----------------------------
-- Table structure for `t_study_text`
-- ----------------------------
DROP TABLE IF EXISTS `t_study_text`;
CREATE TABLE `t_study_text` (
  `aid` int(11) NOT NULL AUTO_INCREMENT,
  `type` varchar(100) DEFAULT NULL COMMENT '文章类型',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` text COMMENT '正文内容',
  `create_date` datetime DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_text
-- ----------------------------
INSERT INTO `t_study_text` VALUES ('3', '最新动态', '房价', '哈哈哈啊哈', '2020-09-23 00:00:00', '2019-09-09 00:00:00');
INSERT INTO `t_study_text` VALUES ('4', '行业报告', '房产', '很多货', '2020-09-20 00:00:00', '2020-09-22 00:00:00');
INSERT INTO `t_study_text` VALUES ('5', '留学预警', '美国疫情', '很多', '2020-09-21 00:00:00', '2020-09-22 00:00:00');

-- ----------------------------
-- Table structure for `t_study_white_list`
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_study_white_list
-- ----------------------------
INSERT INTO `t_study_white_list` VALUES ('2', '12', '2020-08-31 11:00:00', '-1', '1', '山海云汇教育科技公司', 'http://res.common.shiant.com/pdf/4b/4b8f1d94d4204919a77f2498feb35322.pdf', '2', 'http://res.common.shiant.com/pdf/ec/eca9fa59d1c14e0495248c89848c2962.pdf', '2', 'http://res.common.shiant.com/pdf/fa/fad7fc24114b43fab58bc67bb7a7ce7d.pdf', '2', 'http://res.common.shiant.com/pdf/ce/ce4b6344690e43b59aaa2bdcecd791e8.pdf', '2', 'http://res.common.shiant.com/pdf/b7/b78ecf9b6be247eea80b201c9c2bd2aa.pdf', '2', 'http://res.common.shiant.com/pdf/52/520d01521b2341a89fcd72002d0f544c.pdf', '2', '2020-09-18 16:27:48', '2020-09-18 16:27:48', '管理员', '管理员');
INSERT INTO `t_study_white_list` VALUES ('3', null, null, '0', '2', '山海云汇', 'http://res.common.shiant.com/pdf/4b/4b8f1d94d4204919a77f2498feb35322.pdf', '1', 'http://res.common.shiant.com/pdf/ec/eca9fa59d1c14e0495248c89848c2962.pdf', '1', 'http://res.common.shiant.com/pdf/fa/fad7fc24114b43fab58bc67bb7a7ce7d.pdf', '1', 'http://res.common.shiant.com/pdf/ce/ce4b6344690e43b59aaa2bdcecd791e8.pdf', '1', 'http://res.common.shiant.com/pdf/b7/b78ecf9b6be247eea80b201c9c2bd2aa.pdf', '1', 'http://res.common.shiant.com/pdf/52/520d01521b2341a89fcd72002d0f544c.pdf', '1', '2020-09-27 07:46:53', '2020-09-27 07:46:53', '李文彪', '李文彪');
