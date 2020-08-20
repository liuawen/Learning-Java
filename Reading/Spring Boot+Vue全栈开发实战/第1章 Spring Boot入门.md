# 第1章 Spring Boot入门

本章概要• Spring Boot简介• 开发第一个Spring Boot程序• Spring Boot的简便创建方式

1.1 Spring Boot简介

Spring作为一个轻量级的容器，在Java EE开发中得到了广泛的应用，但是Spring的配置烦琐臃肿，在和各种第三方框架进行整合时代码量都非常大，并且整合的代码大多是重复的，为了使开发者能够快速上手Spring，利用Spring框架快速搭建Java EE项目，Spring Boot应运而生。

Spring Boot带来了全新的自动化配置解决方案，使用Spring Boot可以快速创建基于Spring生产级的独立应用程序。Spring Boot中对一些常用的第三方库提供了默认的自动化配置方案，使得开发者只需要很少的Spring配置就能运行一个完整的Java EE应用。Spring Boot项目可以采用传统的方案打成war包，然后部署到Tomcat中运行。也可以直接打成可执行jar包，这样通过java -jar命令就可以启动一个Spring Boot项目。总体来说，Spring Boot主要有如下优势：

• 提供一个快速的Spring项目搭建渠道。• 开箱即用，很少的Spring配置就能运行一个Java EE项目。• 提供了生产级的服务监控方案。• 内嵌服务器，可以快速部署。• 提供了一系列非功能性的通用配置。• 纯Java配置，没有代码生成，也不需要XML配置。

Spring Boot是一个“年轻”的项目，发展非常迅速，特别是在Spring Boot 2.0之后，许多API都有较大的变化，本书的写作基于目前最新的稳定版2.0.4（本书写作时的最新版），因此需要Java 8或9以及Spring Framework 5.0.8.RELEASE或更高版本，同时，构建工具的版本要求为Maven 3.2+或Gradle 4。

1.2 开发第一个Spring Boot程序

Spring Boot工程可以通过很多方式来创建，最通用的方式莫过于使用Maven了，因为大多数的IDE都支持Maven。

1.2.1 创建Maven工程这里不过多说明，Maven的介绍和安装只介绍三种创建Maven工程的方式。