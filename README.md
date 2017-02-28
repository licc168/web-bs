# web-bs  


**项目架构：**

前后端分离的方式 ，前台采用ag2（详见 web-font 项目）

功能内聚分包（dao、service、cache、util、web）

**功能点：**

restful api风格，整合\[swagger-ui\]\(http:\/\/swagger.io\/swagger-ui\/\)（前后端分离契约 方便接口调试）

权限采用 jwt+ang2（使用路由过滤）

后台验证（aop注解+validate） 进行统一处理

自定义异常+spring统一异常处理

mybatis-generator 插件修改（自定义分页方法 以及参数）

spring国际化TranslatorHelper工具类

整合redis、Protostuff序列化

异步：采用guava线程总线

自定义缓存注解

**包功能介绍：**

app：controller 提供API服务

licc-service：service 业务逻辑层

licc-dao：数据交互层

licc -cache:缓存（redis、guava）

**后续：**

项目整体功能将移植到和朋友共同新建的基于spring boot框架的lccf项目中

https://github.com/rabbitRennt/lccf


