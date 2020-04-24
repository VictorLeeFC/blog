# blog

**简介：** 基于Spring Boot开发的小型个人博客
* 1.前台门户：博客文章展示，音乐播放，关于作者。
* 2.后台管理：博客文章、标签、类型的发布、修改、删除。
* 3.Druid数据监控：资源访问流量监控。

**技术组合：**
* 后端：Spring Boot + Mybatis + thymeleaf;
* 数据库：MySQL+Redis;
* 前端UI：Semantic UI + APlayer音乐控件;

**工具与环境：**
* IDEA2018
* Maven3
* JDK8

# 如何运行

1. 克隆本项目到本地

2. 根据sql文件夹下的blog.sql文件生成数据库

3. 修改application.yml配置中Mysql以及Redis等适合你主机的配置

4. 播放音乐需要在yml中指定你存放音乐的磁盘目录,win和linux都支持config类中已做适配。

**如使用nginx代理外部静态媒体资源需要这样配置：**
    
    location /admin/media/music/ {
            #你存放的完整路径目录
            alias /home/media/music/;
    }
    location /admin/media/image/ {
            alias /home/media/image128x128/;
    }


5. Linux系统指定外部配置文件后台启动示例：
   nohup java -jar blog.jar --Dspring.config.location=application-pro.yml --server.port=8081 &

# 博客操作相关

博客首页路径：http://localhost:8080/

博客后台管理：http://localhost:8080/admin  账号：admin 密码：admin 

Druid数据监控：http://localhost:8080/druid/ 账号：admin 密码：admin

最后：在你真正部署上线时请在MD5Utils生成你自己的密码覆盖默认密码。
