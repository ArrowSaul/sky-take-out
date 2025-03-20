## sky-take-out
项目简介：
IT黑马程序员旗下的企业级实战项目，专为餐饮企业定制，分为管理端（B/S架构）和用户端（微信小程序）。核心功能包括用户点餐、订单处理、商家管理、菜品分类等，注重权限控制与数据安全。
基于Spring Boot 3.1.2开发的外卖订购系统，采用前后端分离架构，后端使用SpringBoot+MyBatis，前端使用Vue+Uniapp实现微信小程序。支持MySQL数据库存储核心数据，Redis缓存热点信息，Nginx反向代理优化请求负载
用户层：微信小程序（用户端）+ ElementUI（管理端）
网关层：Nginx负载均衡与静态资源部署
应用层：SpringBoot、Spring Task定时任务、JWT令牌鉴权、阿里云OSS存储
数据层：MySQL、Redis、MyBatis+PageHelper分页 特色功能：
集成Swagger（Knife4j优化版）实现API文档管理
使用WebSocket实现实时通信，支持订单状态推送
支持Excel数据导出与POI报表生成
