/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50615
Source Host           : localhost:3306
Source Database       : moments

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2019-03-13 16:03:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_album
-- ----------------------------
DROP TABLE IF EXISTS `t_album`;
CREATE TABLE `t_album` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ALBUM_NAME` varchar(255) DEFAULT NULL,
  `ALBUM_COVER` varchar(255) DEFAULT NULL,
  `ALBUM_USERID` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_album
-- ----------------------------

-- ----------------------------
-- Table structure for t_circle
-- ----------------------------
DROP TABLE IF EXISTS `t_circle`;
CREATE TABLE `t_circle` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `CIRCLE_NAME` varchar(255) DEFAULT NULL,
  `CIRCLE_USERID` varchar(255) DEFAULT NULL,
  `CIRCLE_USERNAME` varchar(255) DEFAULT NULL,
  `CIRCLE_DESCRIPTION` varchar(255) DEFAULT NULL,
  `CIRCLE_PHOTO` varchar(255) DEFAULT NULL,
  `CIRCLE_STATE` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_circle
-- ----------------------------

-- ----------------------------
-- Table structure for t_comments
-- ----------------------------
DROP TABLE IF EXISTS `t_comments`;
CREATE TABLE `t_comments` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `COMMENT_USERID` varchar(255) DEFAULT NULL,
  `COMMENT_USERNAME` varchar(255) DEFAULT NULL,
  `COMMENT_BODY` varchar(255) DEFAULT NULL,
  `COMMENT_ANNID` varchar(255) DEFAULT NULL,
  `COMMENT_TARGETID` varchar(255) DEFAULT NULL,
  `COMMENT_TARGETNAME` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_comments
-- ----------------------------
INSERT INTO `t_comments` VALUES ('1', '3', '管理员', '《终于明白》、《花与剑》、《答应不爱你》、《生生世世爱》等等，这几个歌最好听了', '2', null, null, '2019-03-13 14:39:43.371');
INSERT INTO `t_comments` VALUES ('2', '2', '***', '楼上戏精', '2', null, null, '2019-03-13 14:40:43.672');

-- ----------------------------
-- Table structure for t_message
-- ----------------------------
DROP TABLE IF EXISTS `t_message`;
CREATE TABLE `t_message` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `FROMID` varchar(255) DEFAULT NULL,
  `FROMNAME` varchar(255) DEFAULT NULL,
  `TARGETID` varchar(255) DEFAULT NULL,
  `TARGETNAME` varchar(255) DEFAULT NULL,
  `MSGBODY` varchar(255) DEFAULT NULL,
  `MSGTYPE` varchar(255) DEFAULT NULL,
  `MSGEXTRAS` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  `RESULT` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_message
-- ----------------------------

-- ----------------------------
-- Table structure for t_notice
-- ----------------------------
DROP TABLE IF EXISTS `t_notice`;
CREATE TABLE `t_notice` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `NOTICE_TITLE` varchar(255) DEFAULT NULL,
  `NOTICE_USERID` varchar(255) DEFAULT NULL,
  `NOTICE_USERNAME` varchar(255) DEFAULT NULL,
  `NOTICE_TYPE` varchar(255) DEFAULT NULL,
  `NOTICE_FILEID` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  `NOTICE_BODY` text,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_notice
-- ----------------------------
INSERT INTO `t_notice` VALUES ('1', '系统新鲜出炉欢迎大家访问啊', '3', '管理员', null, null, '2019-03-13 14:41:04.674', '系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊！\n       系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊系统新鲜出炉欢迎大家访问啊！');

-- ----------------------------
-- Table structure for t_relation
-- ----------------------------
DROP TABLE IF EXISTS `t_relation`;
CREATE TABLE `t_relation` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `KID` int(10) DEFAULT NULL,
  `VID` int(10) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  `CREATETIME` datetime DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_relation
-- ----------------------------

-- ----------------------------
-- Table structure for t_topic
-- ----------------------------
DROP TABLE IF EXISTS `t_topic`;
CREATE TABLE `t_topic` (
  `TID` int(10) NOT NULL AUTO_INCREMENT,
  `TITLE` varchar(255) DEFAULT NULL,
  `ATTACHMENT` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  `USERID` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `CIRCLEID` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `IS_RECOM` varchar(255) DEFAULT NULL,
  `COM_TOTAL` varchar(255) DEFAULT NULL,
  `VIEW_TOTAL` varchar(255) DEFAULT NULL,
  `CONTENT` text,
  PRIMARY KEY (`TID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_topic
-- ----------------------------
INSERT INTO `t_topic` VALUES ('1', '说的是', null, '2019-03-13 14:27:05.452', '2', '***', '0', '2', null, '0', '2', '<p>王子超是沙雕</p>');
INSERT INTO `t_topic` VALUES ('2', '《仙剑奇侠传》：细数仙剑系列中那些好听到哭的歌，你都听过吗？', null, '2019-03-13 14:30:05.028', '1', '旧执如初', '0', '1', null, '2', '4', '<p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">大家好，我是小编闲聊一二三，请眼熟我！<span class=\"bjh-br\"></span></span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">今天呢，我要聊的话题，是《仙剑奇侠传一》与《仙剑奇侠传三》中的歌，别问我为什么没有二，不是一二三吗，我现在不水了。</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1045763641,1789189171&amp;fm=173&amp;app=25&amp;f=JPEG?w=590&amp;h=444&amp;s=6F520DC78023AEFC5881E4A803004011\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《仙剑奇侠传》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\"><span class=\"bjh-br\"></span></span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">众所皆知，一部好的仙侠（武侠）电视剧，如果想让观众能够感同身受，不仅仅要考验演员的演技，还要看适逢其境的背景音乐。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">比如打斗的场面，就要配上《男儿当自强》热血类型的歌，生离死别的场面，就要配上《梁祝》凄婉类型的歌，杀机重重的场面，就要配上《十面埋伏》急促的乐曲，伸手挽留爱人的场景，就要配上《当》……当、当我没说吧。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">总而言之，一个好的背景音乐，不仅是主角装逼时的神器，还能充分调动观众的情绪，使他们恍如身临其境，扣动心弦，从而达到让他们追剧的效果。</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"normal\" width=\"352px\" data-loadfunc=\"0\" src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=3551153189,4255907374&amp;fm=173&amp;app=25&amp;f=JPEG?w=352&amp;h=220&amp;s=1F406387C812B4D6D67DD48D0300B081\" data-loaded=\"0\" style=\"display: block; margin: 0px auto;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《仙剑奇侠传三》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">好了，说完前面铺垫的话，终于该到正主了。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">仙剑一与仙剑三的剧情，那是没得说，一个字——好看。而两部仙剑的歌曲，时隔多年，依旧百听不厌。所以，我就挑出八首自己认为好听的，排名纯属娱乐，别当真，当真了也没用。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">一、《杀破狼》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">其实，将《杀破狼》排到《偏爱》前面，我个人还是很纠结的，毕竟两者不分伯仲，但最后还是决定将《杀破狼》排在第一位。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">原因嘛，无他，就是相对《杀破狼》而言，仙剑其他歌的格局有点小。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">无论是《偏爱》、《此生不换》、《忘记时间》，还有《生生世世爱》，它们讲的都是徐长卿与紫萱、景天与雪见、飞蓬与夕瑶中某一对的爱情故事，而《杀破狼》，与其说它讲的是逍遥与灵儿、逍遥与月如、晋元与彩衣、唐钰小宝与阿奴、莫一兮与圣姑等人的爱情故事，我更愿意称它是对整部仙剑剧情的诠释。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">这首歌，贯穿了整部《仙剑奇侠传》的剧情，从仙灵岛的“桃花瓣在凋零”，暗示逍遥（胡歌饰）与灵儿（刘亦菲饰）的结局，到最后的“孤独等待黎明”，逍遥一人夜里舞剑的情景，揭示最后只有他一个人等待黎明的到来。</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=183394675,4061058552&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=360&amp;s=BE84D904323B0E379803F8850300B089\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《杀破狼》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\"><span class=\"bjh-br\"></span></span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">二、《偏爱》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">《偏爱》，个人感觉就不用多说了，一看歌名就知道为什么它会这么经典了，表白时的神曲啊！（虽然最后我失败了，暗中抹眼泪）</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">还是要说一下，这首歌的主旨是围绕徐长卿（霍建华饰）与紫萱（刘诗诗饰）三生三世的恋情来展开，重点突出紫萱的用心情深，对爱情的忠贞不二，还有两人冲破世俗枷锁、穿越时空的爱恋。应该是仙剑系列中播放量最多的一首歌。</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2536074132,2559918294&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=360&amp;s=5A39E34A4152827318747219030010D4\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《偏爱》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\"><span class=\"bjh-br\"></span></span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">三、《一直很安静》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">初听这首歌，觉得挺寻常的，也看不出歌词有什么深意，那时我的眼里只有逍遥与灵儿，没想过林月如（安以轩饰）。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">多年后，当我读懂林月如的苦涩，读懂她很不甘心却又不忍心拆散两人的心痛时，开始心疼她，也渐渐喜欢这首歌了。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">有一种想念，叫求不得放不下。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">有一种深爱，叫一直很安静</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"normal\" width=\"500px\" data-loadfunc=\"0\" src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=4078711456,753563003&amp;fm=173&amp;app=25&amp;f=JPEG?w=500&amp;h=381&amp;s=C840D518524E45E9045944D9030070B2\" data-loaded=\"0\" style=\"display: block; margin: 0px auto;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《一直很安静》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">四、《忘记时间》<span class=\"bjh-br\"></span></span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">《忘记时间》这首歌，有人说是讲徐长卿与紫萱的故事，有人说是讲夕瑶等待飞蓬归来的故事，或许，两者都是吧。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">我把它排在《此生不换》前面，原因嘛，很简单，两首歌都差不多，但这首歌是胡歌唱的，加分！！！</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=416854194,3586550347&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=400&amp;s=4747FD005F739BD642D0C88D0300F0C2\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《忘记时间》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">五、《此生不换》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">我当初记住这首歌，不只是因为它好听，而是在《仙剑奇侠传三》的结局，徐长卿与紫萱一起“喝下”忘情水，一笑“泯”情缘后，大雪纷飞，满头白发的紫萱站在南疆的雪地上，而蜀山上，徐长卿雪中舞剑。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">那一幕，配上这首《此生不换》，简直戳中泪点！</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=418568209,147521938&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=338&amp;s=1EA5F1045E20721740BF54880300C09B\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《此生不换》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">六、《逍遥叹》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">歌名中的逍遥，我一直认为是指李逍遥。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">第一次出现这首歌的时候，是逍遥为灵儿精心准备她记忆里“漫天的红色蒲公英”。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">歌词偏古风，听起来也是极好的，而且也是胡歌亲自演唱。</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"normal\" width=\"400px\" data-loadfunc=\"0\" src=\"https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=1047353831,3239432172&amp;fm=173&amp;app=25&amp;f=JPEG?w=400&amp;h=300&amp;s=25E4FA04B4678B4D2CFB448F0300F09A\" data-loaded=\"0\" style=\"display: block; margin: 0px auto;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《逍遥叹》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">七、《六月的雨》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">这首歌让我第一时间想到的是，六月，那年毕业的雨季。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">不过呢，这歌其实就是为逍遥与灵儿而写，在灵儿失踪后，逍遥与月如终于找到她，逍遥看见昏迷的灵儿时，非常应景的插曲。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">嗯，老胡唱的。</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"normal\" width=\"500px\" data-loadfunc=\"0\" src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2192445891,3304375889&amp;fm=173&amp;app=25&amp;f=JPEG?w=500&amp;h=300&amp;s=B2A3F148D61225DC4079201A030080D0\" data-loaded=\"0\" style=\"display: block; margin: 0px auto;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《六月的雨》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">八、《光棍》</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">之所以把这首《光棍》排进来，而不是《终于明白》、《答应不爱你》等等几首，是因为我觉得这首歌，与仙剑三的景天形象太贴切了。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">从一开始的没心没肝，只为自己而活，到后来，发现自己喜欢雪见时的难以相信。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">这首歌将景天的心情变化，演绎得淋漓尽致！更何况这首歌，还是景天的饰演者胡歌唱的，简直不能再完美了。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">总觉得一个人逍遥快活的时候，唱这首《光棍》很带劲！</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss0.baidu.com/6ONWsjip0QIZ8tyhnq/it/u=2553504522,357880216&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=360&amp;s=5E3516C65A032E5D6603C4AD0300F01B\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">《光棍》</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">虽然，仙剑里还有不少歌曲不输于榜上的八首，比如《终于明白》、《花与剑》、《答应不爱你》、《生生世世爱》等等，毕竟仙剑一与仙剑三没有哪首歌不好听，但这只是我个人娱乐的排名榜，每个人心里的都不一样，这种事情没必要强求。</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">至于为什么是前八，而不是前十，我只能说，我高兴！反正现在都没推荐没人看了，我也很绝望啊！！！</span></p><div class=\"img-container\" style=\"margin-top: 30px; font-family: arial; font-size: 12px;\"><img class=\"large\" data-loadfunc=\"0\" src=\"https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1182301882,3744378787&amp;fm=173&amp;app=25&amp;f=JPEG?w=640&amp;h=360&amp;s=5388BE458911ECDC1EBFC87003006059\" data-loaded=\"0\" style=\"width: 537px; display: block;\"><span class=\"bjh-image-caption\" style=\"font-size: 13px; color: rgb(153, 153, 153); display: block; margin-top: 11px; text-align: center;\">仙剑</span></div><p style=\"margin-top: 26px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">（文章原创）</span></p><p style=\"margin-top: 22px; margin-bottom: 0px; padding: 0px; font-size: 16px; line-height: 24px; color: rgb(51, 51, 51); text-align: justify; font-family: arial;\"><span class=\"bjh-p\">（部分图片来自网络，如侵联删）</span></p>');

-- ----------------------------
-- Table structure for t_uploadfile
-- ----------------------------
DROP TABLE IF EXISTS `t_uploadfile`;
CREATE TABLE `t_uploadfile` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `ORIGINALNAME` varchar(255) DEFAULT NULL,
  `PATHNAME` varchar(255) DEFAULT NULL,
  `OWNERID` varchar(255) DEFAULT NULL,
  `OWNERTYPE` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  `DESCRIPTION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_uploadfile
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `USERID` int(10) NOT NULL AUTO_INCREMENT,
  `PASSWORD` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `EMAIL` varchar(255) DEFAULT NULL,
  `PHOTO` varchar(255) DEFAULT NULL,
  `SIGNATURE` varchar(255) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `CREATETIME` varchar(255) DEFAULT NULL,
  `USERROLES` varchar(255) DEFAULT NULL,
  `BIRTHDAY` varchar(255) DEFAULT NULL,
  `GENDER` varchar(255) DEFAULT NULL,
  `ADDRESS` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`USERID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', '123456', '旧执如初', '403466144@qq.com', '/upload/20190313142304755570385.jpg', '我的个性没有签名', '1', '2019-03-13 14:22:15.075', 'user', '1995-03-14 00:00:00', '男', '河南郑州');
INSERT INTO `t_user` VALUES ('2', '123456', '***', '123456@139.com', '/upload/20190313142302116996587.jpg', '-', '1', '2019-03-13 14:22:23.398', 'user', '2019-03-13 00:00:00', '男', '-');
INSERT INTO `t_user` VALUES ('3', '123456', '管理员', 'admin@qq.com', '/upload/20190313142304755570385.jpg', '我的个性没有签名', '1', '2019-03-13 14:22:15.075', 'admin', '1995-03-14 00:00:00', '男', '河南郑州');
