# blog

**简介：** 基于Spring Boot开发的小型个人博客+后台管理

**技术组合：**

* 后端：Spring Boot + Mybatis + thymeleaf模板
* 数据库：MySQL+Redis
* 前端UI：Semantic UI框架

**工具与环境：**

* IDEA
* Maven3
* JDK8


# 如何运行

1. 克隆本项目到本地

2. 根据sql文件夹下的blog.sql文件生成数据库
3. 修改application.yml配置(Mysql配置以及Redis配置,在此强烈推荐[一个开源免费的Redis客户端](https://github.com/cinience/RedisStudio))
4. 运行项目

博客首页路径：http://localhost:8080/

博客后台管理：http://localhost:8080/admin  账号：admin 密码：admin

Druid数据监控：http://localhost:8080/druid/ 账号：admin 密码：admin

