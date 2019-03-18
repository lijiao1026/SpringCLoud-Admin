# SpringCloud全家桶实践
本项目是基于SpringBoot2.0版本，由于网上大多是1.5.9版本的SpringBoot项目，所以踩坑较多。项目包含了SpringCloud的主要技术，后续还将引入其他技术，例如消息总线，自动化配置刷新，缓存数据库，服务鉴权等。本项目中业务比较简单，主要是包含了SpringCloud各个技术的简单使用和配置，作为一个抛砖引玉和小demo项目。
# 所用技术
* 服务注册中心:Spring Cloud Eureka
* 配置中心:Spring Cloud Config
* 数据库连接:Mybatis
* 网关中心:Spring Cloud Zuul
* 链路追踪：Spring Cloud ZipKin
* 服务监控：Spring Boot Admin2.0
* 日志收集：ELK
* 熔断机制和监控：Spring Cloud Hystrix Dashboard+turbine</br>
后续功能：在网关服务Zuul项目中增加Outh2鉴权，加入Spring Cloud Bus实现自动化配置更新，SpringCloudStream数据流操作，SpringCloudTask定时任务。。
# 项目各模块介绍
* eureka-Server:服务注册中心
* eureka-client：后端业务服务，操作数据库
* eureka-client-admin-web：系统管理前台页面
* springcloud-config：分布式配置中心
* springcloud-zipkin: 链路追踪服务
* springcloud-zuul: 网关服务中心（目前只是转发，内容较少）
* springcloud-hystrix-dashboard： 熔断监控中心
* springboot-admin： 服务监控中心
# 运行系统
* 先需要修改本地hosts文件（文件地址为C:\Windows\System32\drivers\etc\hosts），增加映射eurekaServer，eureka-client-admin-web，cloud-zuul，springboot-admin，springcloud-config，springcloud-hystrix-dashboard，springcloud-zipkin，eureka-client-admin-service，dbmysql全部指向本机127.0.0.1。（pom.xml文件中引入了spotify插件用于docker镜像文件上传，如果你需要使用docker的话请配置地址，否则的话注释即可。）
* 修改项目中的logback.xml的ELK配置地址，如果没有ELK的也可删除logback.xml文件，当然不删除也不会启动报错
* 修改eureka-server和springboot-admin的邮箱地址，这里是发送服务掉线的邮箱告警
* mysql创建数据库cloud-ida并运行sql文件
* 运行项目，顺序为：eureka-Server->springcloud-config->eureka-client->eureka-client-admin-web->springcloud-zuul->springcloud-zipkin->springcloud-hystrix-dashboard-springboot-admin
# 系统使用
1. 访问localhost:9010/index可以看到后台登录页面，账号/密码：admin/123456
2. 访问localhost:8761可以看到注册中心的监测页面
3. 访问localhost:9411可以看到zipkin的监控页面
4. 访问localhost:8788可以看到springbootadmin的登录页面，登陆后可以看到各个服务的运行状态
5. 访问localhost:8999/hystrix可以看到熔断监控页面，输入http://eureka-client-admin-web:9010/actuator/hystrix.stream 下面左边输入200，下面右边输入testapp
# 系统截图
