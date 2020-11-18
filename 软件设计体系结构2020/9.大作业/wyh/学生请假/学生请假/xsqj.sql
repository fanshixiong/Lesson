# MySQL-Front 8.0  (Build 1.0)

/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE */;
/*!40101 SET SQL_MODE='STRICT_TRANS_TABLES,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES */;
/*!40103 SET SQL_NOTES='ON' */;


# Host: 127.0.0.1    Database: xsqj
# ------------------------------------------------------
# Server version 5.0.15-nt

#CREATE DATABASE `xsqj` /*!40100 DEFAULT CHARACTER SET utf8 */;
#USE `xsqj`;

#
# Table structure for table admin
#

CREATE TABLE `admin` (
  `id` int(11) default NULL,
  `userName` varchar(150) default NULL,
  `userPw` varchar(150) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `admin` VALUES (1,'admin','123');

#
# Table structure for table kao
#

CREATE TABLE `kao` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `ke` varchar(255) default NULL,
  `adate` varchar(255) default NULL,
  `banji` varchar(255) default NULL,
  `qin` varchar(255) default NULL,
  `sid` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `kao` VALUES (1,'王禹涵','高等数学','2019-10-28 11:50:59','191703','否','1');
INSERT INTO `kao` VALUES (2,'钱荣涛','c++','2019-10-28 11:50:59','191703','是','2');
INSERT INTO `kao` VALUES (3,'付志达','C语言','2019-10-28 11:50:59','191703','是','1');
INSERT INTO `kao` VALUES (4,'林张学长','java','2019-10-28 11:50:59','191703','否','1');

#
# Table structure for table ke
#

CREATE TABLE `ke` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `shi` varchar(255) default NULL,
  `jiao` varchar(255) default NULL,
  `info` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `ke` VALUES (1,'高等数学','斋藤飞鸟','j2-201','高等数学');
INSERT INTO `ke` VALUES (2,'c++','王老师','j3-202','大学英语');

#
# Table structure for table qing
#

CREATE TABLE `qing` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `ke` varchar(255) default NULL,
  `adate` varchar(255) default NULL,
  `info` varchar(255) default NULL,
  `state` varchar(255) default NULL,
  `sid` varchar(255) default NULL,
  `banji` varchar(255) default NULL,
  `fujian` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `qing` VALUES (4,'林张学长','java','2019-11-4 15:50:42','约会','同意','1','191703','/upload/19170319.docx');
INSERT INTO `qing` VALUES (3,'付志达','C语言','2019-11-4 15:50:42','看病','不同意','2','191703','/upload/111.docx');

#
# Table structure for table stu
#

CREATE TABLE `stu` (
  `id` int(11) NOT NULL auto_increment,
  `hao` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `pwd` varchar(255) default NULL,
  `sex` varchar(255) default NULL,
  `age` varchar(255) default NULL,
  `banji` varchar(255) default NULL,
  `rdate` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `stu` VALUES (1,'19170301','王禹涵','123','男','16','191703','2019-10-27 23:17:24');
INSERT INTO `stu` VALUES (2,'19170324','钱荣涛','123','女','22','191703','2019-10-27 23:17:24');
INSERT INTO `stu` VALUES (3,'111','付志达','123','不明','20','191703','2019-10-27 23:17:24');
INSERT INTO `stu` VALUES (4,'19170319','林张学长','123','男','22','191703','2019-10-27 23:17:24');

#
# Table structure for table tea
#

CREATE TABLE `tea` (
  `id` int(11) NOT NULL auto_increment,
  `hao` varchar(765) default NULL,
  `name` varchar(765) default NULL,
  `pwd` varchar(255) default NULL,
  `sex` varchar(765) default NULL,
  `age` varchar(765) default NULL,
  `banji` varchar(765) default NULL,
  `rdate` varchar(765) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
INSERT INTO `tea` VALUES (1,'666','王老师','123','女','22','191703,112,113','2019-10-27 23:29:28');
INSERT INTO `tea` VALUES (2,'999','斋藤飞鸟','123','女','18','191703,112,113','2019-10-27 23:29:28');

/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
