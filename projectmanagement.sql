/*
 Navicat Premium Data Transfer

 Source Server         : localhost
 Source Server Type    : MySQL
 Source Server Version : 50737
 Source Host           : localhost:3306
 Source Schema         : projectmanagement

 Target Server Type    : MySQL
 Target Server Version : 50737
 File Encoding         : 65001

 Date: 18/10/2022 09:58:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for project
-- ----------------------------
DROP TABLE IF EXISTS `project`;
CREATE TABLE `project`  (
  `project_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `project_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `industry` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL COMMENT '0:未完结，2：已完结，3：表示项目搁置或者取消',
  `proprietor` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `main_manager` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `fen_manager` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `agent` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `bidding` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `significance` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '以星级来判定，最高5星，最低1星：从5555-1111',
  PRIMARY KEY (`project_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project
-- ----------------------------
INSERT INTO `project` VALUES ('pr1663499543239', '测试（中文名）项目', '2022-09-18 19:12:23', 'stringasdasdasd', '党政军', 2, 'string', 'string', 'string', 'string', '是', '4');
INSERT INTO `project` VALUES ('pr1663725573622', '测试', '2022-09-21 09:59:34', '首先是char/varchar/text之间的区别：\n断。\nvarchar适合长度不固定的字符串存储,不会处理尾部空格,而且实际存储占用的空间会加1或2(因为要记录长度 1个字节 =8位 11111111=128+64+32+16+8+4+2+1=255 所以不超过255得就只用1个字节', '其他', 0, 'asdas', 'asda', '12312', 'asdasa', NULL, '3');
INSERT INTO `project` VALUES ('pr1663742692241', 'test', '2022-09-21 14:44:52', '测试项目', '党政军', 0, '无', '无', '无', '无', NULL, '3');
INSERT INTO `project` VALUES ('pr1663749961019', 'tyesta', '2022-09-21 16:46:01', '无', '党政军', 2, '无', '无', '无', '无', '否', '4');
INSERT INTO `project` VALUES ('pr1663820290714', '测试（普通成员为此项目的项目经理1）', '2022-09-22 12:18:11', '测试项目', '党政军', 0, NULL, NULL, NULL, NULL, NULL, '5');
INSERT INTO `project` VALUES ('pr1664177976753', '新增测试5星项目', '2022-09-26 15:39:37', '无', '党政军', 0, '无', '无', '无', '无', NULL, '5');
INSERT INTO `project` VALUES ('pr1664178026839', '测试修改为4星项目', '2022-09-26 15:40:27', '无', '党政军', 0, '无', '无', '无', '无', NULL, '4');
INSERT INTO `project` VALUES ('pr1664178387862', '新增三星项目', '2022-09-26 15:46:28', '无', '党政军', 0, '无', '无', '无', '无', NULL, '3');

-- ----------------------------
-- Table structure for project_member
-- ----------------------------
DROP TABLE IF EXISTS `project_member`;
CREATE TABLE `project_member`  (
  `role` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `project_member_id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`project_member_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 35 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of project_member
-- ----------------------------
INSERT INTO `project_member` VALUES ('项目经理', 'pr1663820290714', 'user1663668156969', 10);
INSERT INTO `project_member` VALUES ('客户经理', 'pr1663820290714', 'user1663823733052', 11);
INSERT INTO `project_member` VALUES ('客户经理', 'pr1663499543239', 'user1663668156969', 22);
INSERT INTO `project_member` VALUES ('项目经理', 'pr1663725573622', 'user1663823733052', 26);
INSERT INTO `project_member` VALUES ('项目经理', 'pr1663499543239', 'user1663662434083', 28);
INSERT INTO `project_member` VALUES ('解决方案经理', 'pr1663499543239', 'user1663823733052', 30);
INSERT INTO `project_member` VALUES ('客户经理', 'pr1663499543239', 'user1664175094919', 32);
INSERT INTO `project_member` VALUES ('解决方案经理', 'pr1663820290714', 'user1664175094919', 33);
INSERT INTO `project_member` VALUES ('客户经理', 'pr1663820290714', 'user1663662434083', 34);

-- ----------------------------
-- Table structure for summarize
-- ----------------------------
DROP TABLE IF EXISTS `summarize`;
CREATE TABLE `summarize`  (
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `project_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of summarize
-- ----------------------------
INSERT INTO `summarize` VALUES ('123', 'string', '2022-09-21 10:50:29', 'pr1663499543239', 1);
INSERT INTO `summarize` VALUES ('阶段2', '修改问题', '2022-09-21 10:54:43', 'pr1663499543239', 2);
INSERT INTO `summarize` VALUES ('阶段2', '修改问题', '2022-09-21 10:55:46', 'pr1663499543239', 3);
INSERT INTO `summarize` VALUES ('阶段3', '啊实打实', '2022-09-21 11:02:47', 'pr1663499543239', 4);
INSERT INTO `summarize` VALUES ('阶段4', '项目完成', '2022-09-21 11:06:51', 'pr1663499543239', 5);
INSERT INTO `summarize` VALUES ('测试', ';hajsdj阿斯达卡兰达睡了多久啊迫使打死都jams破大家【的卡片司机大炮的就卡死破电脑i是的阿三大苏打实打实的在川藏线川藏线川藏线', '2022-09-21 11:38:37', 'pr1663499543239', 6);
INSERT INTO `summarize` VALUES ('项目初始化', '项目二开始', '2022-09-21 14:42:01', 'pr1663725573622', 7);
INSERT INTO `summarize` VALUES ('阶段1', '测试项目初始化', '2022-09-22 13:07:39', 'pr1663820290714', 8);
INSERT INTO `summarize` VALUES ('阶段5', '新日期测试', '2022-09-22 13:30:54', 'pr1663499543239', 9);

-- ----------------------------
-- Table structure for task
-- ----------------------------
DROP TABLE IF EXISTS `task`;
CREATE TABLE `task`  (
  `task_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `task_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_bin NULL DEFAULT NULL,
  `details` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `create_person` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `create_time` datetime(0) NULL DEFAULT NULL,
  `over_time` datetime(0) NULL DEFAULT NULL COMMENT '任务最终完成时间',
  `deadline` datetime(0) NULL DEFAULT NULL,
  `state` int(11) NULL DEFAULT NULL COMMENT '0：未完结，1：已完结',
  `project_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `istask` int(11) NULL DEFAULT NULL COMMENT '1:是，0：否',
  `solve_details` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '任务最综执行情况',
  PRIMARY KEY (`task_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task
-- ----------------------------
INSERT INTO `task` VALUES ('ta1664181671599', 'taskId为0的任务', '反向xx问题，', 'admin2', '2022-09-26 16:41:12', NULL, '2022-09-26 08:41:08', 0, 'pr1663820290714', 0, NULL);
INSERT INTO `task` VALUES ('ta1664243523052', '手机端测试', '手机端测试审核通过的情况', 'ertyweratWE', '2022-09-27 09:52:03', '2022-09-27 09:53:06', '2022-09-27 01:52:01', 1, 'pr1663820290714', 1, '第二次提交');
INSERT INTO `task` VALUES ('ta1664246710233', '测试', '测试bug', 'ertyweratWE', '2022-09-27 10:45:10', '2022-09-27 11:07:55', '2022-09-27 02:45:06', 1, 'pr1663820290714', 1, '再次提交');
INSERT INTO `task` VALUES ('ta1664248153713', '普通成员创建任务', '普通成员创建任务', '测试人员普通', '2022-09-27 11:09:14', '2022-09-27 11:10:19', '2022-09-27 03:09:11', 1, 'pr1663820290714', 1, '再次处理');
INSERT INTO `task` VALUES ('ta1664259640633', '添加反馈', '手机第一次反馈测试', 'ertyweratWE', '2022-09-27 14:20:41', NULL, NULL, 0, 'pr1663820290714', 0, NULL);
INSERT INTO `task` VALUES ('ta1664345223431', '测试超时', '测试超时', '测试人员普通', '2022-09-28 14:07:03', '2022-09-28 14:08:25', '2022-09-28 18:00:00', 1, 'pr1663820290714', 1, '提交');
INSERT INTO `task` VALUES ('ta1664358362262', '手机时间选择器测试', '手机时间选择器测试', 'ertyweratWE', '2022-09-28 17:46:02', NULL, '2022-09-28 19:00:00', 0, 'pr1663820290714', 1, NULL);
INSERT INTO `task` VALUES ('ta1664358423839', '超时任务测试', '超时任务测试', 'ertyweratWE', '2022-09-28 17:47:04', NULL, '2022-09-28 17:45:00', 0, 'pr1663820290714', 1, NULL);
INSERT INTO `task` VALUES ('ta1664440406884', '新家token后第一次测试', '新家token后第一次测试', '测试人员普通', '2022-09-29 16:33:27', '2022-09-29 16:36:48', '2022-09-29 18:00:00', 1, 'pr1663820290714', 1, '第二次提交');
INSERT INTO `task` VALUES ('ta1664441068963', '新增测试任务', '新增测试任务,验证任务紧急程度取不同颜色背景', '测试人员普通', '2022-09-29 16:44:29', NULL, '2022-09-29 18:00:00', 0, 'pr1663820290714', 1, NULL);
INSERT INTO `task` VALUES ('ta1664504590948', '添加任务，发送短信测试', '添加任务，发送短信测试', 'ertyweratWE', '2022-09-30 10:23:11', NULL, '2022-12-01 09:00:00', 0, 'pr1663820290714', 1, NULL);
INSERT INTO `task` VALUES ('ta1664507633340', '新增任务4，发布短信', '新增任务4，发布短信', '测试人员普通', '2022-09-30 11:13:53', NULL, '2022-09-30 12:00:00', 0, 'pr1663820290714', 1, NULL);
INSERT INTO `task` VALUES ('ta1665306717574', '测试任务', '测试任务', 'admin2', '2022-10-09 17:11:58', NULL, '2022-10-09 17:11:00', 0, 'pr1663820290714', 1, NULL);
INSERT INTO `task` VALUES ('ta1665306765415', 'ceshi', 'ceshi', 'ertyweratWE', '2022-10-09 17:12:45', '2022-10-09 18:01:05', '2022-10-09 17:00:00', 1, 'pr1663820290714', 1, 'asda');
INSERT INTO `task` VALUES ('ta1665307413362', 'ceshi2', 'ceshi2', 'ertyweratWE', '2022-10-09 17:23:33', '2022-10-09 17:24:04', '2022-10-09 18:00:00', 1, 'pr1663820290714', 1, '测阿斯顿');
INSERT INTO `task` VALUES ('ta1666000217121', '测试删除任务', '测试删除任务', 'admin2', '2022-10-17 17:50:17', NULL, '2022-10-20 00:00:00', 0, 'pr1663499543239', 1, NULL);

-- ----------------------------
-- Table structure for task_record
-- ----------------------------
DROP TABLE IF EXISTS `task_record`;
CREATE TABLE `task_record`  (
  `record_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `hand_person_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '处理人ID',
  `state` int(11) NULL DEFAULT NULL COMMENT '0:待处理，1：待审核，2：已完结,3退回',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `over_time` datetime(0) NULL DEFAULT NULL,
  `solve_details` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `check_details` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `task_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `check_person_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL COMMENT '审核人ID',
  PRIMARY KEY (`record_id`) USING BTREE,
  INDEX `任务ID`(`task_id`) USING BTREE,
  CONSTRAINT `任务ID` FOREIGN KEY (`task_id`) REFERENCES `task` (`task_id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of task_record
-- ----------------------------
INSERT INTO `task_record` VALUES ('tare1664243523088', 'user1663823733052', 3, '2022-09-27 09:52:03', '2022-09-27 09:52:48', '第一次提交', '第一次退回', 'ta1664243523052', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664243568013', 'user1663823733052', 2, '2022-09-27 09:52:48', '2022-09-27 09:53:06', '第二次提交', '同意', 'ta1664243523052', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664246710269', 'user1663823733052', 3, '2022-09-27 10:45:10', '2022-09-27 11:07:32', '提交测试', '退回测试', 'ta1664246710233', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664248052465', 'user1663823733052', 2, '2022-09-27 11:07:32', '2022-09-27 11:07:55', '再次提交', '通过测试', 'ta1664246710233', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664248153729', 'user1663668156969', 3, '2022-09-27 11:09:14', '2022-09-27 11:09:42', '提交测试', '退回测试', 'ta1664248153713', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1664248182177', 'user1663668156969', 2, '2022-09-27 11:09:42', '2022-09-27 11:10:19', '再次处理', '通过测试', 'ta1664248153713', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1664345223457', 'user1663668156969', 2, '2022-09-28 14:07:03', '2022-09-28 14:08:25', '提交', '', 'ta1664345223431', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1664358362293', 'user1663823733052', 0, '2022-09-28 17:46:02', NULL, NULL, NULL, 'ta1664358362262', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664358423870', 'user1663823733052', 0, '2022-09-28 17:47:04', NULL, NULL, NULL, 'ta1664358423839', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664440406929', 'user1663668156969', 3, '2022-09-29 16:33:27', '2022-09-29 16:35:48', '加token后第一次提交测试', '新家token后第一次退回测试', 'ta1664440406884', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1664440547669', 'user1663668156969', 2, '2022-09-29 16:35:48', '2022-09-29 16:36:48', '第二次提交', '新加token后第一次 通过测试', 'ta1664440406884', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1664441069003', 'user1663668156969', 1, '2022-09-29 16:44:29', '2022-09-29 16:45:59', '提交回归至审核处', NULL, 'ta1664441068963', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1664504590993', 'user1663823733052', 0, '2022-09-30 10:23:11', NULL, NULL, NULL, 'ta1664504590948', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1664507633384', 'user1663668156969', 0, '2022-09-30 11:13:53', NULL, NULL, NULL, 'ta1664507633340', 'user1663823733052');
INSERT INTO `task_record` VALUES ('tare1665306717608', 'user1663668156969', 0, '2022-10-09 17:11:58', NULL, NULL, NULL, 'ta1665306717574', 'user1663662434083');
INSERT INTO `task_record` VALUES ('tare1665306765446', 'user1663662434083', 3, '2022-10-09 17:12:45', '2022-10-09 17:23:59', '测试', 'huitu', 'ta1665306765415', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1665307413383', 'user1663662434083', 2, '2022-10-09 17:23:33', '2022-10-09 17:24:04', '测阿斯顿', 'asd ', 'ta1665307413362', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1665307439087', 'user1663662434083', 2, '2022-10-09 17:23:59', '2022-10-09 18:01:05', 'asda', '', 'ta1665306765415', 'user1663668156969');
INSERT INTO `task_record` VALUES ('tare1666000217211', 'user1663668156969', 0, '2022-10-17 17:50:17', NULL, NULL, NULL, 'ta1666000217121', 'user1663662434083');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NOT NULL,
  `user_name` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `phone_number` varchar(40) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `post` varchar(32) CHARACTER SET utf8 COLLATE utf8_unicode_ci NULL DEFAULT NULL,
  `status` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_vietnamese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('user1663662386920', 'admin', '17723451265', 'admin', 0);
INSERT INTO `user` VALUES ('user1663662434083', 'admin2', '15223592416', 'manager', 0);
INSERT INTO `user` VALUES ('user1663668156969', 'ertyweratWE', '15235465456', 'common', 0);
INSERT INTO `user` VALUES ('user1663823733052', '测试人员普通', '19923218989', 'common', 0);
INSERT INTO `user` VALUES ('user1664175094919', '测试人员普通2', '15365456587', 'common', 0);

SET FOREIGN_KEY_CHECKS = 1;
