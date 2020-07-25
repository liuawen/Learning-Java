/*
 Navicat Premium Data Transfer

 Source Server         : dalaoyang-dev
 Source Server Type    : MySQL
 Source Server Version : 50720
 Source Host           : localhost:3306
 Source Schema         : dalaoyang

 Target Server Type    : MySQL
 Target Server Version : 50720
 File Encoding         : 65001

 Date: 03/04/2019 10:03:09
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for ARTICLE_INFO
-- ----------------------------
DROP TABLE IF EXISTS `ARTICLE_INFO`;
CREATE TABLE `ARTICLE_INFO` (
  `ARTICLE_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `ARTICLE_NAME` varchar(1000) DEFAULT NULL COMMENT '文章名称',
  `ARTICLE_CONTENT` text COMMENT '文章内容',
  `ARTICLE_AUTHORS` varchar(1000) DEFAULT NULL COMMENT '文章作者',
  `ARTICLE_INPUT_DATE` date DEFAULT NULL COMMENT '文章录入日期',
  `ARTICLE_READING_TIME` int(11) DEFAULT NULL COMMENT '文章阅读次数',
  `ARTICLE_IS_TOP` varchar(1) DEFAULT NULL COMMENT '是否置顶',
  `ARTICLE_TAG` varchar(100) DEFAULT NULL COMMENT '文章标签',
  `ARTICLE_IS_RELEASE` varchar(1) DEFAULT NULL COMMENT '文章是否发布',
  PRIMARY KEY (`ARTICLE_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ARTICLE_INFO
-- ----------------------------
BEGIN;
INSERT INTO `ARTICLE_INFO` VALUES (1, '使用IntelliJ Idea新建SpringBoot项目', '简单给大家介绍一下我来创建SpringBoot项目使用的工具，本人使用IntelliJ Idea来创建项目，利用其中的Spring Initializr工具来快速创建项目。\n\n步骤如下：\n\n菜单栏中选择File--New--Project，出现如下图所示，然后选择Spring Initializr。\n\n其中SDK可以根据自己需求选择合适的jdk版本，本人项目均使用的Jdk1.8\n\nService Url 是Spring官方提供的Spring Initializr工具地址。\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/11/16214b82d3c9983d?w=1752&h=1414&f=jpeg&s=153372)\n\n然后点击Next，进入下面页面，其中以下各项内容与创建maven项目填写相同。\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/11/16214b885a312afa?w=1744&h=1414&f=jpeg&s=140889)\n\n点击Next，如下图所示，可以配置SpringBoot项目或SpringCloud项目各种依赖，需要注意的是，SpringBoot旁边的2.0.0是自己需要使用的SpringBoot版本，根据自己的需求选择。\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/11/16214b8cb27b7af1?w=1748&h=1416&f=jpeg&s=166239)\n\n\n选择依赖和版本后，点击Next进入下图所示。设置项目名称，以及项目存储位置。\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/11/16214b94e23c0fc6?w=1744&h=1418&f=jpeg&s=104642)\n\n以上都设置完成后，点击Finish。\n\n进入项目后，启动项目就可以看到SpringBoot项目启动后的标志Banner，第一个SpringBoot项目就这样搭建完成了。\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/11/16214b9ae25ddf6c?w=2416&h=506&f=jpeg&s=239423)\n\n\n个人网站：[http://dalaoyang.cn]()', 'dalaoyang', '2018-04-02', 1, 'Y', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (2, 'SpringBoot的第一个web项目', '这一节主要是讲springboot搭建简单的web项目。\n\n首先pom文件新增spring-boot-starter-web依赖，pom文件如下所示\n\n\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springboot_web</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springboot_web</name>\n	<description>springboot_web</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.10.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-web</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-devtools</artifactId>\n			<scope>runtime</scope>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n	</dependencies>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n```\n\n\n然后在项目内新建IndexController，代码如下\n\n```\npackage com.dalaoyang.controller;\n\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RestController;\n\n/**\n * @author dalaoyang\n * @Description\n * @project springboot_learn\n * @package com.dalaoyang.controller\n * @email 397600342@qq.com\n * @date 2018/3/13\n */\n@RestController\npublic class IndexController {\n\n    @RequestMapping(\"/\")\n    public String index(){\n        return \"hi dalaoyang\";\n    }\n}\n```\n\n启动类SpringbootWebApplication代码如下\n\n```\npackage com.dalaoyang;\n\nimport org.springframework.boot.SpringApplication;\nimport org.springframework.boot.autoconfigure.SpringBootApplication;\n\n@SpringBootApplication\npublic class SpringbootWebApplication {\n\n	public static void main(String[] args) {\n		SpringApplication.run(SpringbootWebApplication.class, args);\n	}\n}\n```\n\n配置文件如下\n\n```\n##设置端口号\nserver.port=8888\n\n##springboot项目默认访问是/ 默认不配置下面属性的话 可以直接通过http://ip:port/可以访问index\n##如果在配置文件中增加如下配置 则访问时需要访问http://ip:port/dalaoyang\nserver.context-path=/dalaoyang\n```\n\n就这样一个简单的springboot web项目搭建完成。\n\n然后启动项目 访问http://localhost:8888/dalaoyang/如下图所示\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/13/1621e7e8022216de?w=1328&h=558&f=jpeg&s=67690)\n\n源码下载 ：[大老杨码云](https://gitee.com/dalaoyang/springboot_learn)', 'dalaoyang', '2018-03-02', 1, 'Y', '2', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (3, 'SpringBoot集成FreeMarker', '给大家简单介绍一下springboot 集成FreeMarker\n过程很简单，5分钟即可。\n\n首先在项目中增添依赖spring-boot-starter-freemarker\npom文件代码如下：\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springboot_freemarker</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springboot_freemarker</name>\n	<description>springboot_freemarker</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.10.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-freemarker</artifactId>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-web</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-devtools</artifactId>\n			<scope>runtime</scope>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n	</dependencies>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n```\n\n然后创建controller，代码如下：\n```\npackage com.dalaoyang.controller;\n\nimport org.springframework.stereotype.Controller;\nimport org.springframework.ui.ModelMap;\nimport org.springframework.web.bind.annotation.RequestMapping;\n\n/**\n * @author dalaoyang\n * @Description\n * @project springboot_learn\n * @package com.dalaoyang.controller\n * @email 397600342@qq.com\n * @date 2018/3/14\n */\n@Controller\npublic class TestController {\n\n    @RequestMapping(\"/test\")\n    public String testFreemarker(ModelMap modelMap){\n        modelMap.addAttribute(\"msg\", \"Hello dalaoyang , this is freemarker\");\n        return \"freemarker\";\n    }\n}\n```\n\napplication.properties如下\n```\n##端口号\nserver.port=8888\n\n#设定ftl文件路径\nspring.freemarker.template-loader-path=classpath:/templates\n#设定静态文件路径，js,css等\nspring.mvc.static-path-pattern=/static/**\n```\n\n然后简单给大家介绍一下，目录结构\n\n![](https://user-gold-cdn.xitu.io/2018/3/14/1622331c856e7728?w=1152&h=500&f=jpeg&s=99294)\n\n然后贴上ftl文件的代码，一定注意，是ftl！！！！！\n写html文件是无法找到页面的。\n\n```\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"utf-8\"/>\n    <title>FreeMarker</title>\n</head>\n<body>\n<h1>${msg}</h1>\n</body>\n</html>\n```\n\n然后启动项目，访问http://localhost:8888/ 即可看到以下页面，\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/14/1622334600e4619a?w=1412&h=660&f=jpeg&s=102396)\n\n源码下载 ：[大老杨码云](https://gitee.com/dalaoyang/springboot_learn)', 'dalaoyang', '2018-02-02', 1, 'Y', '3', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (4, 'SpringBoot集成Thymeleaf', '上一篇给大家介绍了springboot整合freemarker，这一片来继续为大家介绍一种模板thymeleaf。\n\n首先在项目中增添thymeleaf依赖spring-boot-starter-thymeleaf\n同时为了解决html严格校验报错的问题，增添依赖nekohtml\npom文件代码如下：\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springboot_thymeleaf</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springboot_thymeleaf</name>\n	<description>springboot_thymeleaf</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.10.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-thymeleaf</artifactId>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-web</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-devtools</artifactId>\n			<scope>runtime</scope>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n\n		<dependency>\n			<groupId>net.sourceforge.nekohtml</groupId>\n			<artifactId>nekohtml</artifactId>\n			<version>1.9.15</version>\n		</dependency>\n	</dependencies>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n\n```\ncontroller代码大致与freemarker相同，代码如下：\n```\npackage com.dalaoyang.controller;\n\nimport org.springframework.stereotype.Controller;\nimport org.springframework.ui.ModelMap;\nimport org.springframework.web.bind.annotation.RequestMapping;\n\n/**\n * @author dalaoyang\n * @Description\n * @project springboot_learn\n * @package com.dalaoyang.controller\n * @email 397600342@qq.com\n * @date 2018/3/14\n */\n@Controller\npublic class TestController {\n\n    @RequestMapping(\"/\")\n    public String testThymeleaf(ModelMap modelMap){\n        modelMap.addAttribute(\"msg\", \"Hello dalaoyang , this is thymeleaf\");\n        return \"thymeleaf\";\n    }\n}\n```\napplication.properties如下：\n```\n##端口号\nserver.port=8888\n\n\n##去除thymeleaf的html严格校验\nspring.thymeleaf.mode=LEGACYHTML5\n\n#设定thymeleaf文件路径 默认为src/main/resources/templates\nspring.freemarker.template-loader-path=classpath:/templates\n#设定静态文件路径，js,css等\nspring.mvc.static-path-pattern=/static/**\n# 是否开启模板缓存，默认true\n# 建议在开发时关闭缓存,不然没法看到实时页面\nspring.thymeleaf.cache=false\n# 模板编码\nspring.freemarker.charset=UTF-8\n```\n\nhtml代码如下\n\n```\n<!DOCTYPE html>\n<!--解决th报错 -->\n<html lang=\"en\" xmlns:th=\"http://www.w3.org/1999/xhtml\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>thymeleaf</title>\n</head>\n<body>\n<h1 th:text=\"${msg}\"></h1>\n</body>\n</html>\n```\n\n启动项目，访问http://localhost:8888/ 即可看到以下页面，\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/14/1622371ebf9261de?w=1214&h=596&f=jpeg&s=93994)\n\n源码下载 ：[大老杨码云](https://gitee.com/dalaoyang/springboot_learn)', 'dalaoyang', '2018-04-02', 1, 'Y', '4', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (5, 'maven仓库设置', '\nMaven 中央仓库地址：  \n\n1、http://www.sonatype.org/nexus/  私服nexus工具使用  \n2、http://mvnrepository.com/   \n3、http://repo1.maven.org/maven2  \n4、http://maven.aliyun.com/nexus/content/repositories/central/  阿里云 \n5、http://repo2.maven.org/maven2/ 私服nexus工具使用  \n6、http://uk.maven.org/maven2/  \n7、http://repository.jboss.org/nexus/content/groups/public  \n8、http://maven.oschina.net/content/groups/public/oschina  \n9、http://mirrors.ibiblio.org/maven2/  \n10、http://maven.antelink.com/content/repositories/central/  \n11、http://nexus.openkoala.org/nexus/content/groups/Koala-release/   \n12、http://maven.tmatesoft.com/content/groups/public/\n\n\nmaven库配置\n```\n<mirror>\n<id>oschina-repo</id>\n<name>开源中国镜像</name>\n<mirrorOf>central</mirrorOf>\n<url>可以根据自己的网络情况选填上面的url</url>\n</mirror>\n```', 'dalaoyang', '2018-04-02', 1, 'Y', '5', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (6, 'SpringBoot使用WebJars', '本人主要做的是java，但是从第一份工作开始，就一直在做一个写前端又写后端的程序员，相信很多朋友和我一样，不仅要会后台代码，还要懂得很多的前端代码，例如javascipt和css样式。\n\n本文就为大家简单介绍一下SpringBoot如何结合前端代码。\n\nSpringBoot结合前端有很多种方法，比如在static里面直接加入css或js，又或者引入webjars，以jar包的形式加入项目，本文就是简单介绍一下这种方式。\n\n\n话不多说，直接引入代码，还是新建一个SpringBoot Web项目。然后在pom文件引入webjars的jar，pom文件代码如下：\n\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springboot_webjars</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springboot_webjars</name>\n	<description>springboot_webjars</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.9.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-web</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-devtools</artifactId>\n			<scope>runtime</scope>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n\n       <!-- 引用bootstrap -->\n		<dependency>\n			<groupId>org.webjars</groupId>\n			<artifactId>bootstrap</artifactId>\n			<version>3.3.7-1</version>\n		</dependency>\n\n		<!-- 引用jquery -->\n		<dependency>\n			<groupId>org.webjars</groupId>\n			<artifactId>jquery</artifactId>\n			<version>3.1.1</version>\n		</dependency>\n	</dependencies>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n```\n\n\n然后我们观察一下项目的依赖jar包，依赖中就有了bootstrap.jar和jquery.jar\n\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/22/1624e2faf3afa456)\n\n\n然后在src/main/resources/static文件下新建index.html，代码如下：\n```\n<!DOCTYPE html>\n<html lang=\"en\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>Dalaoyang</title>\n    <link rel=\"stylesheet\" href=\"/webjars/bootstrap/3.3.7-1/css/bootstrap.min.css\" />\n    <script src=\"/webjars/jquery/3.1.1/jquery.min.js\"></script>\n    <script src=\"/webjars/bootstrap/3.3.7-1/js/bootstrap.min.js\"></script>\n</head>\n<body>\n<div class=\"container\"><br/>\n    <div class=\"alert alert-success\">\n        <a href=\"#\" class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">×</a>\n        Hello, <strong>Dalaoyang!</strong>\n    </div>\n</div>\n</body>\n</html>\n```\n\n至此配置已经结束，启动项目，访问http://localhost:8888/\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/22/1624e32a59169e22)\n\n\n至此SpringBoot结合WebJars成功就完成。\n\n\n源码下载 ：[大老杨码云](https://gitee.com/dalaoyang/springboot_learn)\n\n\n<p>给大家简单介绍一下springboot 集成FreeMarker\n过程很简单，5分钟即可。</p>\n\n<p>首先在项目中增添依赖spring-boot-starter-freemarker\npom文件代码如下：\n<code></code>`\n&lt;?xml version=&quot;1.0&quot; encoding=&quot;UTF-8&quot;?&gt;\n&lt;project xmlns=&quot;http://maven.apache.org/POM/4.0.0&quot; xmlns:xsi=&quot;http://www.w3.org/2001/XMLSchema-instance&quot;\n	xsi:schemaLocation=&quot;http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd&quot;&gt;\n	&lt;modelVersion&gt;4.0.0&lt;/modelVersion&gt;</p>\n\n<pre><code>&lt;groupId&gt;com.dalaoyang&lt;/groupId&gt;\n&lt;artifactId&gt;springboot_freemarker&lt;/artifactId&gt;\n&lt;version&gt;0.0.1-SNAPSHOT&lt;/version&gt;\n&lt;packaging&gt;jar&lt;/packaging&gt;\n\n&lt;name&gt;springboot_freemarker&lt;/name&gt;\n&lt;description&gt;springboot_freemarker&lt;/description&gt;\n\n&lt;parent&gt;\n	&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n	&lt;artifactId&gt;spring-boot-starter-parent&lt;/artifactId&gt;\n	&lt;version&gt;1.5.10.RELEASE&lt;/version&gt;\n	&lt;relativePath/&gt; &lt;!-- lookup parent from repository --&gt;\n&lt;/parent&gt;\n\n&lt;properties&gt;\n	&lt;project.build.sourceEncoding&gt;UTF-8&lt;/project.build.sourceEncoding&gt;\n	&lt;project.reporting.outputEncoding&gt;UTF-8&lt;/project.reporting.outputEncoding&gt;\n	&lt;java.version&gt;1.8&lt;/java.version&gt;\n&lt;/properties&gt;\n\n&lt;dependencies&gt;\n	&lt;dependency&gt;\n		&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n		&lt;artifactId&gt;spring-boot-starter-freemarker&lt;/artifactId&gt;\n	&lt;/dependency&gt;\n	&lt;dependency&gt;\n		&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n		&lt;artifactId&gt;spring-boot-starter-web&lt;/artifactId&gt;\n	&lt;/dependency&gt;\n\n	&lt;dependency&gt;\n		&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n		&lt;artifactId&gt;spring-boot-devtools&lt;/artifactId&gt;\n		&lt;scope&gt;runtime&lt;/scope&gt;\n	&lt;/dependency&gt;\n	&lt;dependency&gt;\n		&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n		&lt;artifactId&gt;spring-boot-starter-test&lt;/artifactId&gt;\n		&lt;scope&gt;test&lt;/scope&gt;\n	&lt;/dependency&gt;\n&lt;/dependencies&gt;\n\n&lt;build&gt;\n	&lt;plugins&gt;\n		&lt;plugin&gt;\n			&lt;groupId&gt;org.springframework.boot&lt;/groupId&gt;\n			&lt;artifactId&gt;spring-boot-maven-plugin&lt;/artifactId&gt;\n		&lt;/plugin&gt;\n	&lt;/plugins&gt;\n&lt;/build&gt;</code></pre>\n\n<p>&lt;/project&gt;\n<code></code>`</p>\n\n<p>然后创建controller，代码如下：\n<code></code>`\npackage com.dalaoyang.controller;</p>\n\n<p>import org.springframework.stereotype.Controller;\nimport org.springframework.ui.ModelMap;\nimport org.springframework.web.bind.annotation.RequestMapping;</p>\n\n<p>/**\n <em> @author dalaoyang\n </em> @Description\n <em> @project springboot_learn\n </em> @package com.dalaoyang.controller\n <em> @email 397600342@qq.com\n </em> @date 2018/3/14\n */\n@Controller\npublic class TestController {</p>\n\n<pre><code>@RequestMapping(&quot;/test&quot;)\npublic String testFreemarker(ModelMap modelMap){\n    modelMap.addAttribute(&quot;msg&quot;, &quot;Hello dalaoyang , this is freemarker&quot;);\n    return &quot;freemarker&quot;;\n}</code></pre>\n\n<p>}\n<code></code>`</p>\n\n<p>application.properties如下\n<code></code>`</p>\n\n<h2>端口号</h2>\n\n<p>server.port=8888</p>\n\n<h1>设定ftl文件路径</h1>\n\n<p>spring.freemarker.template-loader-path=classpath:/templates</p>\n\n<h1>设定静态文件路径，js,css等</h1>\n\n<p>spring.mvc.static-path-pattern=/static/**\n<code></code>`</p>\n\n<p>然后简单给大家介绍一下，目录结构</p>\n\n<p><img alt=\"\" src=\"https://user-gold-cdn.xitu.io/2018/3/14/1622331c856e7728?w=1152&amp;h=500&amp;f=jpeg&amp;s=99294\"/></p>\n\n<p>然后贴上ftl文件的代码，一定注意，是ftl！！！！！\n写html文件是无法找到页面的。</p>\n\n<p><code>\n&lt;!DOCTYPE html&gt;\n&lt;html lang=&quot;en&quot;&gt;\n&lt;head&gt;\n    &lt;meta charset=&quot;utf-8&quot;/&gt;\n    &lt;title&gt;FreeMarker&lt;/title&gt;\n&lt;/head&gt;\n&lt;body&gt;\n&lt;h1&gt;${msg}&lt;/h1&gt;\n&lt;/body&gt;\n&lt;/html&gt;\n</code></p>\n\n<p>然后启动项目，访问http://localhost:8888/ 即可看到以下页面，</p>\n\n<p><img alt=\"\" src=\"https://user-gold-cdn.xitu.io/2018/3/14/1622334600e4619a?w=1412&amp;h=660&amp;f=jpeg&amp;s=102396\"/></p>\n\n<p>源码下载 ：<a href=\"https://gitee.com/dalaoyang/springboot_learn\">大老杨码云</a></p>', 'dalaoyang', '2018-04-02', 1, 'Y', '4', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (7, '服务注册与发现---eureka', 'eureka简介：云端服务发现，一个基于 REST 的服务，用于定位服务，以实现云端中间层服务发现和故障转移。\n\n\n话不多说直接上代码\n\n首先新建一个springcloud eurekaserver项目。\npom文件如下：\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springcloud_eureka_server</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springcloud_eureka_server</name>\n	<description>springcloud_eureka_server</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.9.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.cloud</groupId>\n			<artifactId>spring-cloud-starter-eureka-server</artifactId>\n		</dependency>\n	</dependencies>\n\n\n	<dependencyManagement>\n		<dependencies>\n			<dependency>\n				<groupId>org.springframework.cloud</groupId>\n				<artifactId>spring-cloud-dependencies</artifactId>\n				<version>Edgware.SR1</version>\n				<type>pom</type>\n				<scope>import</scope>\n			</dependency>\n		</dependencies>\n	</dependencyManagement>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n\n```\n\n\n然后在application.properties加入如下配置:\n```\nserver.port=8761\n\neureka.instance.hostname=localhost\neureka.client.service-url.defaultZone=http://${eureka.instance.hostname}:${server.port}/eureka/\n\n##禁止自己向自己注册\neureka.client.register-with-eureka=false\neureka.client.fetch-registry=false\n```\n\n最后只需在启动类application上加入注解@EnableEurekaServer \n开启服务注册中心，然后启动项目，访问[http://localhost:8761/](http://localhost:8761/)可以看到如下页面。\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/23/16250f06f527d858?w=2402&h=1452&f=jpeg&s=346171)\n\n下图可见当前并没有实例\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/23/16250f2c6c84b6a5?w=2380&h=1368&f=jpeg&s=276774)\n\n然后新建一个eureka-client项目，pom文件如下\n\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springcloud_eureka_client</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springcloud_eureka_client</name>\n	<description>springcloud_eureka_client</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.9.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n		<spring-cloud.version>Edgware.SR1</spring-cloud.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.cloud</groupId>\n			<artifactId>spring-cloud-starter-eureka</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n	</dependencies>\n\n	<dependencyManagement>\n		<dependencies>\n			<dependency>\n				<groupId>org.springframework.cloud</groupId>\n				<artifactId>spring-cloud-dependencies</artifactId>\n				<version>${spring-cloud.version}</version>\n				<type>pom</type>\n				<scope>import</scope>\n			</dependency>\n		</dependencies>\n	</dependencyManagement>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n```\n\napplication.properties如下所示：\n```\n##端口号\nserver.port=8762\n\nspring.application.name=eureka_client\n\neureka.client.service-url.defaultZone=http://localhost:8761/eureka/\n```\n\n启动类appliction加入@EnableEurekaClient注解，application代码如下\n```\npackage com.dalaoyang;\n\nimport org.springframework.boot.SpringApplication;\nimport org.springframework.boot.autoconfigure.SpringBootApplication;\nimport org.springframework.cloud.netflix.eureka.EnableEurekaClient;\n\n@SpringBootApplication\n@EnableEurekaClient\npublic class SpringcloudEurekaClientApplication {\n\n	public static void main(String[] args) {\n		SpringApplication.run(SpringcloudEurekaClientApplication.class, args);\n	}\n}\n```\n\n启动eureka-client，在观察eurekaserver管理页面\n\n![](https://user-gold-cdn.xitu.io/2018/3/23/16250f643b7bd3d1?w=2378&h=1360&f=jpeg&s=288805)\n\n这时就可以看到一个实例已经注册成功了，服务名为EUREKA_CLIENT ,端口为8762\n\n\n源码下载 ：[大老杨码云](https://gitee.com/dalaoyang/springboot_learn)\n', 'dalaoyang', '2018-04-02', 1, 'Y', '3', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (8, '简单实现自定义注解', '在Java中创建自定义注解\n\n创建自定义注解与编写接口很相似，除了它的接口关键字前有个@符号。\n注意以下几点：\n\n·注解方法不能有参数。  \n·注解方法的返回类型局限于原始类型，字符串，枚举，注解，或以上类型构成的数组。  \n·注解方法可以包含默认值。  \n·注解可以包含与其绑定的元注解，元注解为注解提供信息，有四种元注解类型：  \n\n1. @Documented – 表示使用该注解的元素应被javadoc或类似工具文档化，它应用于类型声明，类型声明的注解会影响客户端对注解元素的使用。如果一个类型声明添加了Documented注解，那么它的注解会成为被注解元素的公共API的一部分。\n\n2. @Target – 表示支持注解的程序元素的种类，一些可能的值有TYPE, METHOD, CONSTRUCTOR, FIELD等等。如果Target元注解不存在，那么该注解就可以使用在任何程序元素之上。\n\n3. @Inherited – 表示一个注解类型会被自动继承，如果用户在类声明的时候查询注解类型，同时类声明中也没有这个类型的注解，那么注解类型会自动查询该类的父类，这个过程将会不停地重复，直到该类型的注解被找到为止，或是到达类结构的顶层（Object）。\n\n4. @Retention – 表示注解类型保留时间的长短，它接收RetentionPolicy参数，可能的值有SOURCE, CLASS, 以及RUNTIME。\n\n以下是一个简单自定义注解的实现过程：\n\n首先创建自定义注解类Annotations，代码如下:\n```\npackage com.dalaoyang.test;\n\nimport java.lang.annotation.Documented;\nimport java.lang.annotation.ElementType;\nimport java.lang.annotation.Retention;\nimport java.lang.annotation.RetentionPolicy;\nimport java.lang.annotation.Target;\n\n@Documented\n@Retention(RetentionPolicy.RUNTIME)\n@Target({ElementType.METHOD})\npublic @interface Annotations {\n    long time() default -1;\n}\n```\n\n写一个简单的实现类:\n```\npackage com.dalaoyang.test;\n\n\nimport java.util.Date;\n\n/**\n * @author dalaoyang\n * @Description\n * @project java_custon_annotations\n * @package com.dalaoyang.test\n * @email 397600342@qq.com\n * @date 2018/3/27\n */\npublic class DoSomeThing {\n    public void test() {\n        System.out.println(\"执行自定义注解\");\n        System.out.println(\"执行自定义注解结束时间：\"+new Date());\n\n    }\n}\n```\n\n然后写一个使用注解的类：\n```\npackage com.dalaoyang.test;\n\n\npublic class Test {\n\n    private DoSomeThing doSomeThing= new DoSomeThing();\n\n\n    @Annotations\n    public void test(){\n        doSomeThing.test();\n    }\n\n}\n```\n\n最后利用反射，使注解可以使用：\n```\npackage com.dalaoyang.test;\n\n\nimport java.lang.reflect.Method;\nimport java.util.Date;\n\n\n// 反射注解\npublic class AnnotationsRunner {\n    public static void main(String[] args) throws Exception {\n        System.out.println(\"执行自定义注解开始时间：\"+new Date());\n        Class clazz = Test.class;\n        Method[] ms = clazz.getMethods();\n        for (Method method : ms) {\n            boolean flag = method.isAnnotationPresent(Annotations.class);\n            if (flag) {\n                method.invoke(clazz.newInstance(), null);\n            }\n        }\n    }\n}\n```\n\n执行AnnotationsRunner类中得main函数，可以看到控制台如下所示：\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16265f8c056893de?w=1294&h=396&f=jpeg&s=64851)', 'dalaoyang', '2018-04-03', 17, 'Y', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (9, '解决Intellij IDEA部署JavaWeb项目 404问题', '今天朋友问了我一个问题，他的公司项目用idea启动tomcat是成功的，\n但是访问页面是404。一般来说，这个问题普遍都是打war包的时候配置有一定的问题导致的。\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266b3a7c84207f?w=809&h=290&f=png&s=11168)\n\n检查一下Project Structure的配置，首先是project：\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266b8901420145?w=2460&h=1462&f=jpeg&s=308071)\n\nModules-Sources如下图：\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266bb1999f5803?w=2474&h=1462&f=jpeg&s=284204)\n\nModules-Paths中没什么需要特别修改的地方。\nModules-Dependencis如下图：\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266bddd19bdf9f?w=2474&h=1456&f=jpeg&s=246862)\n\n\nLiraires如下图所示：\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266bf30862000e?w=2472&h=1460&f=jpeg&s=250834)\n\nFacets如下，路径一定不要配错，不如一定404，如下图：\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c1fe15e4692?w=2468&h=1470&f=jpeg&s=319874)\n\n最后就是Artifacts:\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c3440d1229f?w=2462&h=1442&f=jpeg&s=299761)\n\n项目到这就配置完了，有些路径一定要结合自己的项目来配置。\n\n接下来配置tomcat：\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c67fd91a224?w=2192&h=1466&f=jpeg&s=370521)\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c975ddcbca6?w=2190&h=1462&f=jpeg&s=253399)\n\n\n到此，启动项目即可。', 'dalaoyang', '2018-04-03', 2, 'Y', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (10, 'SpringBoot的国际化使用', '在项目中，很多时候需要国际化的支持，这篇文章要介绍一下springboot项目中国际化的使用。\n\n   \n在这个项目中前端页面使用的thymeleaf，另外加入了nekohtml去掉html严格校验，如果不了解springboot和thymeleaf的使用，可以去看我的上一篇文章[《SpringBoot集成Thymeleaf》](https://juejin.im/post/5aa8ce8ff265da23a404836f)。\n\n新建一个springboot项目，pom文件代码如下：\n```\n<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\n	xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\n	<modelVersion>4.0.0</modelVersion>\n\n	<groupId>com.dalaoyang</groupId>\n	<artifactId>springboot_internationalization</artifactId>\n	<version>0.0.1-SNAPSHOT</version>\n	<packaging>jar</packaging>\n\n	<name>springboot_internationalization</name>\n	<description>springboot_internationalization</description>\n\n	<parent>\n		<groupId>org.springframework.boot</groupId>\n		<artifactId>spring-boot-starter-parent</artifactId>\n		<version>1.5.10.RELEASE</version>\n		<relativePath/> <!-- lookup parent from repository -->\n	</parent>\n\n	<properties>\n		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\n		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>\n		<java.version>1.8</java.version>\n	</properties>\n\n	<dependencies>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-web</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-devtools</artifactId>\n			<scope>runtime</scope>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-test</artifactId>\n			<scope>test</scope>\n		</dependency>\n		<dependency>\n			<groupId>org.springframework.boot</groupId>\n			<artifactId>spring-boot-starter-thymeleaf</artifactId>\n		</dependency>\n\n		<dependency>\n			<groupId>net.sourceforge.nekohtml</groupId>\n			<artifactId>nekohtml</artifactId>\n			<version>1.9.15</version>\n		</dependency>\n	</dependencies>\n\n	<build>\n		<plugins>\n			<plugin>\n				<groupId>org.springframework.boot</groupId>\n				<artifactId>spring-boot-maven-plugin</artifactId>\n			</plugin>\n		</plugins>\n	</build>\n\n\n</project>\n```\n\n从上面可以看出，其实和之前结合thymeleaf的时候一样。接下来给大家看一下application.propertie配置：\n```\n##端口号\nserver.port=8888\n\n\n##去除thymeleaf的html严格校验\nspring.thymeleaf.mode=LEGACYHTML5\n\n#设定thymeleaf文件路径 默认为src/main/resources/templates\nspring.freemarker.template-loader-path=classpath:/templates\n```\n\n新建IndexController\n```\n@Controller\npublic class IndexController {\n\n    @RequestMapping(\"/\")\n    public String hello(Model model){\n        return \"index\";\n    }\n}\n```\n\n到这里可以看出来，其实和整合thymeleaf一样。\n\n接下来我们要加入国际化的关键，在resources里面新建messages.properties（默认配置），messages_en_US.properties（英文），messages_zh_CN.properties（中文）\n\n其中messages.properties里面加入：\n```\nmessage = 欢迎使用国际化（默认）\n```\n\nmessages_en_US.properties里面加入：\n```\nmessage = Welcome to internationalization (English)\n```\n\nmessages_zh_CN.properties里面加入\n```\nmessage = \\u6b22\\u8fce\\u4f7f\\u7528\\u56fd\\u9645\\u5316\\uff08\\u4e2d\\u6587\\uff09\n```\n\n\n然后在templates下新建index.html，代码如下：\n```\n<!DOCTYPE html>\n<html lang=\"en\" xmlns:th=\"http://www.w3.org/1999/xhtml\">\n<head>\n    <meta charset=\"UTF-8\">\n    <title>Title</title>\n</head>\n<body>\n\n<a href=\"/?lang=en_US\">English(US)</a>\n<a href=\"/?lang=zh_CN\">简体中文</a></br>\n<p><label th:text=\"#{message}\"></label></p>\n\n\n</body>\n</html>\n```\n\n创建国际化配置文件，I18Config 代码如下:\n```\npackage com.dalaoyang.config;\n\nimport java.util.Locale;\n\nimport org.springframework.boot.autoconfigure.EnableAutoConfiguration;\nimport org.springframework.context.annotation.Bean;\nimport org.springframework.context.annotation.ComponentScan;\nimport org.springframework.context.annotation.Configuration;\nimport org.springframework.web.servlet.LocaleResolver;\nimport org.springframework.web.servlet.config.annotation.InterceptorRegistry;\nimport org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;\nimport org.springframework.web.servlet.i18n.LocaleChangeInterceptor;\nimport org.springframework.web.servlet.i18n.SessionLocaleResolver;\n\n@Configuration\n@EnableAutoConfiguration\n@ComponentScan\n/**\n * @author dalaoyang\n * @Description\n * @project springboot_learn\n * @package com.dalaoyang.config\n * @email 397600342@qq.com\n * @date 2018/3/28\n */\npublic class I18Config extends WebMvcConfigurerAdapter{\n    @Bean\n    public LocaleResolver localeResolver() {\n        SessionLocaleResolver slr = new SessionLocaleResolver();\n        // 默认语言\n        slr.setDefaultLocale(Locale.US);\n        return slr;\n    }\n\n    @Bean\n    public LocaleChangeInterceptor localeChangeInterceptor() {\n        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();\n        // 参数名\n        lci.setParamName(\"lang\");\n        return lci;\n    }\n\n    @Override\n    public void addInterceptors(InterceptorRegistry registry) {\n        registry.addInterceptor(localeChangeInterceptor());\n    }\n}\n```\n\n最后修改IndexController，修改成如下：\n```\npackage com.dalaoyang.controller;\n\nimport org.springframework.stereotype.Controller;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport java.util.Locale;\n\nimport org.springframework.beans.factory.annotation.Autowired;\nimport org.springframework.context.MessageSource;\nimport org.springframework.context.i18n.LocaleContextHolder;\nimport org.springframework.ui.Model;\n/**\n * @author dalaoyang\n * @Description\n * @project springboot_learn\n * @package com.dalaoyang.controller\n * @email 397600342@qq.com\n * @date 2018/3/28\n */\n@Controller\npublic class IndexController {\n\n    @Autowired\n    private MessageSource messageSource;\n\n    @RequestMapping(\"/\")\n    public String hello(Model model){\n        Locale locale = LocaleContextHolder.getLocale();\n        model.addAttribute(\"message\", messageSource.getMessage(\"message\", null, locale));\n        return \"index\";\n    }\n}\n```\n\n现在启动项目，访问http://localhost:8888/\n\n然后点击中文或者English就可以自由切换语言了。', 'dalaoyang', '2018-04-03', 3, 'Y', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (11, 'SpringBoot使用数据库', '这一篇简单介绍一下SpringBoot配置数据库的配置（依赖和application.properties）,以下全是以本地数据库为例子，具体用户名密码地址都根据实际去修改。\n\nMysql数据库：\n\npom文件：\n```\n<dependency>\n	<groupId>mysql</groupId>\n	<artifactId>mysql-connector-java</artifactId>\n	<scope>runtime</scope>\n</dependency>\n```\n\napplication.properties:\n```\n##数据库地址\nspring.datasource.url=jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false\n##数据库用户名\nspring.datasource.username=root\n##数据库密码\nspring.datasource.password=root\n##数据库驱动\nspring.datasource.driver-class-name=com.mysql.jdbc.Driver\n```\n\nSql Server数据库：\n\npom文件：\n```\n<dependency>\n    <groupId>com.microsoft.sqlserver</groupId>\n    <artifactId>mssql-jdbc</artifactId>\n    <scope>runtime</scope>\n</dependency>\n```\n\napplication.properties:\n```\n##数据库地址\nspring.datasource.url=jdbc:sqlserver://192.168.16.218:1433;databaseName=dev_btrpawn\n##数据库用户名\nspring.datasource.username=sa\n##数据库密码\nspring.datasource.password=p@ssw0rd\n##数据库驱动\nspring.datasource.driver-class-name=com.microsoft.sqlserver.jdbc.SQLServerDriver\n```\n\noracle数据库：\n\n没有找到仓库中oracle得jar 需要自己下载然后加入\n\napplication.properties:\n```\nspring.datasource.driver-class-name=oracle.jdbc.driver.OracleDriver\nspring.datasource.url=jdbc:oracle:thin:@localhost:1521:orcl\nspring.datasource.username=dalaoyang\nspring.datasource.password=dalaoyang123\n```\n\nmongodb数据库：\n\npom文件：\n```\n<dependencies>\n	<dependency> \n	    <groupId>org.springframework.boot</groupId>\n	    <artifactId>spring-boot-starter-data-mongodb</artifactId>\n	</dependency> \n</dependencies>\n```\n\napplication.properties:\n```\nspring.data.mongodb.uri=mongodb://localhost:27017/test\n```\n\nh2数据库：\n\npom文件：\n```\n<dependency>\n    <groupId>com.h2database</groupId>\n    <artifactId>h2</artifactId>\n    <scope>runtime</scope>\n</dependency>\n```\n\napplication.properties:\n```\nspring.datasource.url=jdbc:h2:file:D:/roncoo_h2/roncoo_spring_boot;AUTO_SERVER=TRUE;DBCLOSE_ON_EXIT=FALSE\nspring.datasource.username=sa\nspring.datasource.password=\n```\n', 'dalaoyang', '2018-04-03', 1, 'Y', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (12, 'linux下安装mysql', ' 这是自己踩过的坑，记录一下，翻了一天博客，csdn等等，最后在网上看到了一个十分简单的安装过程。\n\n安装\n```\n# yum -y install http://dev.mysql.com/get/mysql-community-release-el6-5.noarch.rpm\n# yum info mysql-community-server\n# yum -y install mysql-community-server\n# vi /etc/my.cnf\n    character-set-server=utf8\n# /etc/init.d/mysqld restart\n# mysqld --version\n    mysqld  Ver 5.6.23 for Linux on x86_64 (MySQL Community Server (GPL))\n```\n    \n设置\n\n```\n# mysql_secure_installation  \n    Enter current password for root (enter for none):　←　回车  \n  \n    Set root password? [Y/n]　←　回车  \n    New password:　←　123456  \n    Re-enter new password:　←　123456  \n  \n    Remove anonymous users? [Y/n]　←　回车(删除匿名用户)  \n  \n    Disallow root login remotely? [Y/n]　←　回车(禁止远程root登录)  \n  \n    Remove test database and access to it? [Y/n]　←　回车(删除test库)  \n  \n    Reload privilege tables now? [Y/n]　←　回车  \n  \n    Thanks for using MySQL!  \n# mysql -u root -p  \n    Enter password:123456  \n  \n    mysql> create database mydb;  \n    mysql> grant all privileges on mydb.* to testuser@localhost identified by \'123456\';  \n    mysql> select user, host from mysql.user;  \n    mysql> quit  \n```\n    \n    \n装到这之后，本地使用没问题了，但是远程连接却不好用，提示Host is not allowed to connect to this MySQL server。然后在一片文章里找到解决办法，记录一下。\n\n\n先说说这个错误，其实就是我们的MySQL不允许远程登录，所以远程登录失败了，解决方法如下：\n\n1、在装有MySQL的机器上登录MySQL mysql -u root -p密码  \n2、执行use mysql;  \n3、执行update user set host = \'%\' where user = \'root\';这一句执行完可能会报错，不用管它。  \n4、执行FLUSH PRIVILEGES;  \n\n经过上面4步，就可以解决这个问题了。 \n注: 第四步是刷新MySQL的权限相关表，一定不要忘了，我第一次的时候没有执行第四步，结果一直不成功，最后才找到这个原因。', 'dalaoyang', '2018-04-03', 1, 'Y', '4', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (13, 'SpringBoot学习历程', '经过公司新同事介绍，听说了SpringBoot框架，并且亲身感受过这个框架的优势，经过一段时间的学习和使用，故此写博客记录自己学习SpringBoot的全部历程。\n\n· 入门\n\n[使用IntelliJ Idea新建SpringBoot项目](https://juejin.im/post/5aa50c226fb9a028cb2d41bf)\n\n· Web学习\n\n  [SpringBoot的第一个web项目](https://juejin.im/post/5aa78857f265da237b21c21b)\n\n  [SpringBoot集成FreeMarker](https://juejin.im/post/5aa8c0416fb9a028c6756818)\n\n  [SpringBoot集成Thymeleaf](https://juejin.im/post/5aa8ce8ff265da23a404836f)\n\n  [SpringBoot使用WebJars](https://juejin.im/post/5ab3bfbf5188255565346cf5)\n\n  [SpringBoot的国际化使用](https://juejin.im/post/5abb053a5188255caf06406f)\n\n  SpringBoot文件上传下载\n\n  SpringBoot邮件发送\n\n· 数据库学习\n\n[SpringBoot使用数据库](https://juejin.im/post/5abb3c3551882555666fbdbc)\n\nSpringBoot+Jpa+MySql学习\n\nSpringBoot+Mybatis+MySql学习\n\nSpringBoot多数据源\n\nSpringBoot使用Swagger2实现Restful API\n\nSpringBoot集成阿里巴巴Druid监控\n\n· 日志学习\n\n使用Log4j日志处理\n\n· 监控学习\n\n使用Actuator监控\n\n使用Admin监控\n\n· 安全学习\n\n使用shiro安全管理\n\n使用SpringSecurity\n\n未完待续，文章内容会不断更新......\n\n个人网站：[http://dalaoyang.cn]()', 'dalaoyang', '2018-01-03', 30, 'Y', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (14, 'SpringCloud学习目录', 'Spring Cloud直接建立在Spring Boot的企业Java创新方法上，它通过实现经过验证的模式来简化分布式、微服务风格的体系结构，从而为您的微服务带来弹性、可靠性和协调。\n\n以上来自spring官网中文翻译。\n\n中文文档：[https://springcloud.cc/](https://springcloud.cc/)\n\n官方文档：[http://projects.spring.io/spring-cloud/#quick-start](http://projects.spring.io/spring-cloud/#quick-start)\n   \n   \n\n最近总结了一下本人SpringCloud的学习历程，由于文章都是近期才开始写，文章内所有项目都是以jdk1.8+springboot1.5.9+springcloudEdgware.SR1来构建的，ide使用的是IntelliJ Idea。\n\n本人创建了一个公益eureka地址：[eureka.dalaoyang.cn](http://eureka.dalaoyang.cn)\n\n\n下面是我学习SpringCloud的历程目录。\n  \n基础篇：\n\n服务注册与发现---eureka  \n负载均衡---ribbon  \n声明式调用---Feign  \n熔断器---Hystrix  \n路由网关---zuul  \n分布式配置   \n消息总线   \n服务链路追踪---Sleuth  \nSpringBoot Admin监控\n\n安全篇：\n\nSpringCloud Oauth2认证\nSpringBoot Security\n\n\n未完待续，文章目录和内容在整理中，后续会不断更新......\n\n\n个人网站：[http://dalaoyang.cn](https://link.jianshu.com/?t=http%3A%2F%2Fdalaoyang.cn%2F)\n\n\n\n', 'dalaoyang', '2018-02-01', 2, 'Y', '2', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (15, '利用nginx，腾讯云免费证书制作https', '之前一直在研究，https怎么弄。最近看到了腾讯云提供的免费得ssl证书，寻思把网站弄成https。\n\n首先先去腾讯云购买一个免费得证书。\n\n![](https://user-gold-cdn.xitu.io/2018/3/28/1626b8726a104761?w=1088&h=900&f=jpeg&s=110641)\n\n点击后填写内容，\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/28/1626b8794cdef1fb?w=1940&h=1154&f=jpeg&s=286098)\n\n然后下载证书\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/28/1626b87cac6d75e0?w=1814&h=168&f=jpeg&s=35668)\n\n解压证书就可以看到，提供四种方式来修改https，我们需要用到的是\nNginx包里面的东西。\n\n![](https://user-gold-cdn.xitu.io/2018/3/28/1626b882d5153c6b?w=1608&h=996&f=jpeg&s=187111)\n\n\n证书到这里就搞完了。\n\n然后说一下项目配置，本人网站项目是用springboot做的，端口号8888。\n\n然后服务器安装nginx，具体安装细节就不细说了，不懂的就百度一下吧，特别简单。需要说的就是nginx.conf配置：\n\n```\n    ##这里是将http默认的80端口重定向到https\n    server {\n        listen       80;\n        server_name  www.dalaoyang.cn;\n        rewrite ^ https://$http_host$request_uri? permanent; \n    }\n	\n	##这里是将默认请求https的443端口拦截\n	##并请求转发到http://127.0.0.1:8888/\n    server {\n        listen 443;\n        server_name www.dalaoyang.cn;\n        ssl on;     \n         ssl_certificate 1_dalaoyang.cn_bundle.crt;\n        ssl_certificate_key 2_dalaoyang.cn.key;\n        ssl_session_timeout 5m;\n        location / {\n            proxy_set_header X-Real-IP $remote_addr;\n            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;\n            proxy_set_header Host $http_host;\n            proxy_set_header X-NginX-Proxy true;\n               #你的项目端口号\n            proxy_pass http://127.0.0.1:8888/;\n            proxy_redirect off;\n        }\n    }\n```\n\n然后在网站上输入www.dalaoyang.cn就可以看到如下图\n\n\n![](https://user-gold-cdn.xitu.io/2018/3/28/1626b8e692e78f5f?w=862&h=340&f=jpeg&s=59956)\n\n', 'dalaoyang', '2018-04-03', 2, 'Y', '3', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (16, '', '今天朋友问了我一个问题，他的公司项目用idea启动tomcat是成功的，\r\n但是访问页面是404。一般来说，这个问题普遍都是打war包的时候配置有一定的问题导致的。\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266b3a7c84207f?w=809&h=290&f=png&s=11168)\r\n\r\n检查一下Project Structure的配置，首先是project：\r\n\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266b8901420145?w=2460&h=1462&f=jpeg&s=308071)\r\n\r\nModules-Sources如下图：\r\n\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266bb1999f5803?w=2474&h=1462&f=jpeg&s=284204)\r\n\r\nModules-Paths中没什么需要特别修改的地方。\r\nModules-Dependencis如下图：\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266bddd19bdf9f?w=2474&h=1456&f=jpeg&s=246862)\r\n\r\n\r\nLiraires如下图所示：\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266bf30862000e?w=2472&h=1460&f=jpeg&s=250834)\r\n\r\nFacets如下，路径一定不要配错，不如一定404，如下图：\r\n\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c1fe15e4692?w=2468&h=1470&f=jpeg&s=319874)\r\n\r\n最后就是Artifacts:\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c3440d1229f?w=2462&h=1442&f=jpeg&s=299761)\r\n\r\n项目到这就配置完了，有些路径一定要结合自己的项目来配置。\r\n\r\n接下来配置tomcat：\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c67fd91a224?w=2192&h=1466&f=jpeg&s=370521)\r\n\r\n\r\n![](https://user-gold-cdn.xitu.io/2018/3/27/16266c975ddcbca6?w=2190&h=1462&f=jpeg&s=253399)\r\n\r\n\r\n到此，启动项目即可。', '', '2018-04-26', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (17, 'asd', 'asdasd', 'asdad', '2018-04-26', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (18, 'asd', 'asdasd', 'asdad', '2018-04-26', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (19, 'asd', 'asdasd', 'asdad', '2018-04-26', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (20, 'asdad', 'asdsad', 'asdas', '2018-04-26', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (21, 'asdad', 'asdasd', 'asdasd', '2018-04-26', 1, 'N', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (22, 'test', 'asd', 'asd', '2018-04-28', 1, 'N', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (23, 'asd', 'asd', 'asd', '2018-04-28', 3, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (24, 'a\'s\'d', 'asda', 'asdad', '2018-04-28', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (25, '13', 'sad', '123', '2018-04-28', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (26, 'testaaa', 'sad', 'aaa', '2018-04-28', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (31, 'asdasd', 'asdasd', 'dalaoyang', '2018-05-22', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (32, '测试文章', 'aaa', 'dalaoyang', '2018-05-22', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (33, '111', '111', '111', '2018-05-22', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (34, '222', '222', '222', '2018-05-22', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (35, '111', '111', '111', '2018-05-22', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (36, '奥术大师', 'asd', 'adas', '2018-05-22', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (38, 'zzz1', 'asd1231232222', 'dalaoyang1', '2018-11-09', 1, 'N', '1', 'Y');
INSERT INTO `ARTICLE_INFO` VALUES (39, '222', '222', '222', '2018-11-16', 1, 'Y', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (40, '333', '777', '444', '2018-11-16', 1, 'N', '1', 'N');
INSERT INTO `ARTICLE_INFO` VALUES (41, '555', '555', '555', '2018-11-16', 1, 'Y', '1', 'N');
COMMIT;

-- ----------------------------
-- Table structure for LINK_INFO
-- ----------------------------
DROP TABLE IF EXISTS `LINK_INFO`;
CREATE TABLE `LINK_INFO` (
  `LINK_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LINK_NAME` varchar(100) DEFAULT NULL COMMENT '链接名称',
  `LINK_URL` varchar(500) DEFAULT NULL COMMENT '链接地址',
  `REMARK` text COMMENT '备注',
  PRIMARY KEY (`LINK_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of LINK_INFO
-- ----------------------------
BEGIN;
INSERT INTO `LINK_INFO` VALUES (1, 'Spring Cloud中国社区111', 'http://www.springcloud.cn/222', '333');
INSERT INTO `LINK_INFO` VALUES (3, 'Spring For All社区', 'http://www.spring4all.com/', NULL);
INSERT INTO `LINK_INFO` VALUES (4, '许进沉思录', 'http://xujin.org/', NULL);
INSERT INTO `LINK_INFO` VALUES (5, '13blog', 'http://13blog.site/', NULL);
INSERT INTO `LINK_INFO` VALUES (6, '测试连接1', 'http://localhost:9000/editLink1', '备注1');
INSERT INTO `LINK_INFO` VALUES (8, '4', '4', '4');
INSERT INTO `LINK_INFO` VALUES (9, '2', '2', '2');
INSERT INTO `LINK_INFO` VALUES (10, '3', '3', '3');
INSERT INTO `LINK_INFO` VALUES (11, '5', '5', '5');
INSERT INTO `LINK_INFO` VALUES (13, '555', '555', '555');
COMMIT;

-- ----------------------------
-- Table structure for TAG_INFO
-- ----------------------------
DROP TABLE IF EXISTS `TAG_INFO`;
CREATE TABLE `TAG_INFO` (
  `TAG_ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签主键id',
  `TAG_NAME` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`TAG_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of TAG_INFO
-- ----------------------------
BEGIN;
INSERT INTO `TAG_INFO` VALUES (2, 'SPRINGCLOUD');
INSERT INTO `TAG_INFO` VALUES (3, 'NGINX');
INSERT INTO `TAG_INFO` VALUES (4, 'LINUX');
INSERT INTO `TAG_INFO` VALUES (5, 'JAVA');
INSERT INTO `TAG_INFO` VALUES (6, 'JPA');
INSERT INTO `TAG_INFO` VALUES (9, 'DALAOYANG1');
INSERT INTO `TAG_INFO` VALUES (10, 'DALAOYANG2');
INSERT INTO `TAG_INFO` VALUES (11, 'DALAOYANG3');
INSERT INTO `TAG_INFO` VALUES (12, 'AAA');
INSERT INTO `TAG_INFO` VALUES (13, '111');
INSERT INTO `TAG_INFO` VALUES (16, 'AAAASSS');
INSERT INTO `TAG_INFO` VALUES (17, 'ASDA');
INSERT INTO `TAG_INFO` VALUES (18, 'ZZZ');
INSERT INTO `TAG_INFO` VALUES (19, '123');
INSERT INTO `TAG_INFO` VALUES (20, '12312313');
INSERT INTO `TAG_INFO` VALUES (21, '333');
INSERT INTO `TAG_INFO` VALUES (22, '444');
INSERT INTO `TAG_INFO` VALUES (23, '555');
INSERT INTO `TAG_INFO` VALUES (24, '222');
INSERT INTO `TAG_INFO` VALUES (25, '22222');
INSERT INTO `TAG_INFO` VALUES (26, '2222');
INSERT INTO `TAG_INFO` VALUES (28, '5555');
COMMIT;

-- ----------------------------
-- Table structure for WEBSITE_SYSTEM_INFO
-- ----------------------------
DROP TABLE IF EXISTS `WEBSITE_SYSTEM_INFO`;
CREATE TABLE `WEBSITE_SYSTEM_INFO` (
  `ID` int(11) NOT NULL,
  `TOTAL_WEBSITE_VISITS` int(11) DEFAULT NULL,
  `TODAY_WEBSITE_VISITS` int(11) DEFAULT NULL,
  `MONTH_WEBSITE_VISITS` int(11) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of WEBSITE_SYSTEM_INFO
-- ----------------------------
BEGIN;
INSERT INTO `WEBSITE_SYSTEM_INFO` VALUES (1, 1608, 66, 1591);
COMMIT;

-- ----------------------------
-- Table structure for WEBSITE_SYSTEM_PROPERTY
-- ----------------------------
DROP TABLE IF EXISTS `WEBSITE_SYSTEM_PROPERTY`;
CREATE TABLE `WEBSITE_SYSTEM_PROPERTY` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `WEBSITE_URL` varchar(1000) DEFAULT NULL COMMENT '网站地址',
  `WEBSITE_NAME` varchar(1000) DEFAULT NULL COMMENT '网站名称',
  `DOMAIN_NAME` varchar(1000) DEFAULT NULL COMMENT '网站域名',
  `BEIAN_NUMBER` varchar(1000) DEFAULT NULL COMMENT '网站备案号',
  `WECHAT_NAME` varchar(1000) DEFAULT NULL COMMENT 'wechat图片地址',
  `WEIBO_URL` varchar(1000) DEFAULT NULL COMMENT '微博地址',
  `GITEE_URL` varchar(1000) DEFAULT NULL COMMENT '码云地址',
  `EMAIL_URL` varchar(1000) DEFAULT NULL COMMENT '个人邮箱地址',
  `CSDE_URL` varchar(1000) DEFAULT NULL COMMENT 'csdn地址',
  `BLOG_URL` varchar(1000) DEFAULT NULL COMMENT '其他博客地址，例如博客园等',
  `JIANSHU_URL` varchar(1000) DEFAULT NULL COMMENT '简书地址',
  `GONGZHONGHAO_NAME` varchar(1000) DEFAULT NULL COMMENT '个人公众号',
  `GONGZHONGHAO_TURENAME` varchar(1000) DEFAULT NULL COMMENT '公众号名称',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of WEBSITE_SYSTEM_PROPERTY
-- ----------------------------
BEGIN;
INSERT INTO `WEBSITE_SYSTEM_PROPERTY` VALUES (1, 'https://www.dalaoyang.cn25', 'Dalaoyang125', 'Dalaoyang.cn125', '辽ICP备17014944号-22225', 'dalaoyang.jpeg25', 'https://weibo.com/2886438580/profile?topnav=1&wvr=625', 'https://gitee.com/dalaoyang25', 'yangyang@dalaoyang.cn25', '5https://blog.csdn.net/qq_3325752725', 'http://www.cnblogs.com/dalaoyang/25', 'https://www.jianshu.com/u/128b6effde5325', 'dalaoyang_gongzhonghao.jpg25', 'dalaoyang25');
COMMIT;

-- ----------------------------
-- Table structure for article_tag
-- ----------------------------
DROP TABLE IF EXISTS `article_tag`;
CREATE TABLE `article_tag` (
  `ARTICLE_ID` int(11) NOT NULL COMMENT '文章id',
  `TAG_ID` int(11) NOT NULL COMMENT '标签id',
  PRIMARY KEY (`ARTICLE_ID`,`TAG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article_tag
-- ----------------------------
BEGIN;
INSERT INTO `article_tag` VALUES (22, 2);
INSERT INTO `article_tag` VALUES (22, 3);
INSERT INTO `article_tag` VALUES (22, 4);
INSERT INTO `article_tag` VALUES (26, 2);
INSERT INTO `article_tag` VALUES (31, 10);
INSERT INTO `article_tag` VALUES (31, 11);
INSERT INTO `article_tag` VALUES (31, 16);
INSERT INTO `article_tag` VALUES (32, 10);
INSERT INTO `article_tag` VALUES (32, 11);
INSERT INTO `article_tag` VALUES (32, 12);
INSERT INTO `article_tag` VALUES (33, 13);
INSERT INTO `article_tag` VALUES (34, 24);
INSERT INTO `article_tag` VALUES (35, 13);
INSERT INTO `article_tag` VALUES (38, 17);
INSERT INTO `article_tag` VALUES (38, 18);
INSERT INTO `article_tag` VALUES (38, 20);
INSERT INTO `article_tag` VALUES (39, 24);
INSERT INTO `article_tag` VALUES (39, 25);
INSERT INTO `article_tag` VALUES (39, 26);
INSERT INTO `article_tag` VALUES (40, 23);
INSERT INTO `article_tag` VALUES (41, 23);
INSERT INTO `article_tag` VALUES (41, 28);
COMMIT;

-- ----------------------------
-- Table structure for sys_user
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `ID` int(50) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `USERNAME` varchar(100) DEFAULT NULL COMMENT '用户名',
  `PASSWORD` varchar(100) DEFAULT NULL COMMENT '密码',
  `TRUENAME` varchar(100) DEFAULT NULL COMMENT '真实姓名',
  `EMAIL` varchar(100) DEFAULT NULL COMMENT '邮箱',
  `PHONE` varchar(11) DEFAULT NULL COMMENT '手机号',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
BEGIN;
INSERT INTO `sys_user` VALUES (1, 'admin', 'zzz111', 'admin', 'admin@dalaoyang.cn', '18888888888');
INSERT INTO `sys_user` VALUES (2, 'dalaoyang', 'dalaoyang', 'dalaoyang', 'yangyang@dalaoyang.cn', '18640027340');
COMMIT;

-- ----------------------------
-- Table structure for website_access_info
-- ----------------------------
DROP TABLE IF EXISTS `website_access_info`;
CREATE TABLE `website_access_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `ACCESS_DATE` date DEFAULT NULL COMMENT '访问日期',
  `ACCESS_COUNT` int(11) DEFAULT NULL COMMENT '访问数量',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of website_access_info
-- ----------------------------
BEGIN;
INSERT INTO `website_access_info` VALUES (1, '2018-12-15', 1517);
INSERT INTO `website_access_info` VALUES (2, '2018-12-15', 1517);
INSERT INTO `website_access_info` VALUES (3, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (4, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (5, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (6, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (7, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (8, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (9, '2018-12-15', 1524);
INSERT INTO `website_access_info` VALUES (10, '2018-12-15', 1530);
INSERT INTO `website_access_info` VALUES (11, '2018-12-15', 1530);
INSERT INTO `website_access_info` VALUES (12, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (13, '2018-12-15', 1);
INSERT INTO `website_access_info` VALUES (14, '2018-12-15', 1);
INSERT INTO `website_access_info` VALUES (15, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (16, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (17, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (18, '2018-12-15', 6);
INSERT INTO `website_access_info` VALUES (19, '2018-12-15', 4);
INSERT INTO `website_access_info` VALUES (20, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (21, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (22, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (23, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (24, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (25, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (26, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (27, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (28, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (29, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (30, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (31, '2018-12-15', 0);
INSERT INTO `website_access_info` VALUES (32, '2018-12-17', 100);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
