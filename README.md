# 苍穹外卖
## 项目简介：
IT黑马程序员旗下的企业级实战项目，专为餐饮企业定制，分为管理端（B/S架构）和用户端（微信小程序）。核心功能包括用户点餐、订单处理、商家管理、菜品分类等，注重权限控制与数据安全。采用前后端分离架构，后端使用SpringBoot+MyBatis，前端使用Vue+Uniapp实现微信小程序。支持MySQL数据库存储核心数据，Redis缓存热点信息，Nginx反向代理优化请求负载
## 技术栈

- 后端框架
  - SpringBoot (3.1.2)
  - Mybatis
- 数据库
  - MySql
  - Redis
- 前端框架
  - Vue
  - Uniapp
  - ElementUI
- 前后端通信
  - RESTful API

## Windows 开发环境搭建

1. 安装 Java JDK 17 并配置环境变量
2. 安装 MySQL、Redis 数据库并创建相应数据库
3. 创建 MySQL 数据库与表: 运行sql
4. 安装 Maven 构建工具
5. 下载安装 Nginx 并完成配置
6. 克隆项目到本地 `git clone https://github.com/ArrowSaul/sky-take-out.git `
7. 修改配置文件 [application.yml](./sky-server/src/main/resources/application.yml)

   ```yml
   spring:
     datasource:
       url: jdbc:mysql://url
       username: root
       password: 数据库密码
     data:
       redis:
         password: redis数据库密码
   ```

8. 在 [resources](./sky-server/src/main/resources/) 目录下新建 `application-env.yml` 文件，写入以下配置

   ```yml
   sky:
     wechat:
       appid: 申请微信小程序可获得
       secret: 申请微信小程序可获得
       mchid: 商户号
       mchSerialNo:
       privateKeyFilePath:
       apiV3Key:
       weChatPayCertFilePath:
       notifyUrl:
       refundNotifyUrl:
   ```

9. 运行项目
