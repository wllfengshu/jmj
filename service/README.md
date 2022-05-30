## JmJ(Java MaJiang,Java麻将)

> 参考：https://github.com/jmj/jmj-master

### 项目介绍
```
功能点：
    麻将（包含：项目的运维，有各项的监控指标和运维指标）
技术点：
       核心技术为springcloud+vue两个全家桶实现，采取了取自开源用于开源的目标，所以能用开源绝不用收费框架，整体技术栈只有
    阿里云短信服务是收费的，都是目前java前瞻性的框架，可以为中小企业解决微服务架构难题，可以帮助企业快速建站。由于服务
    器成本较高，尽量降低开发成本的原则，本项目由10个后端项目和3个前端项目共同组成。真正实现了基于RBAC、jwt和oauth2的
    无状态统一权限认证的解决方案，实现了异常和日志的统一管理，实现了MQ落地保证100%到达的解决方案。
	
	核心框架：springcloud Edgware全家桶
	安全框架：Spring Security Spring Cloud Oauth2
	分布式任务调度：elastic-job
	持久层框架：MyBatis、通用Mapper4、Mybatis_PageHelper
	数据库连接池：Alibaba Druid
	日志管理：Logback	前端框架：Vue全家桶以及相关组件
	三方服务： 邮件服务、阿里云短信服务、七牛云文件服务、钉钉机器人服务、高德地图API
```
### 平台目录结构说明


```
├─jmj-master----------------------------父项目，公共依赖
│  │
│  ├─jmj-eureka--------------------------微服务注册中心
│  │
│  ├─jmj-config-----------------------微服务配置中心
│  │
│  ├─jmj-monitor-------------------------微服务监控中心
│  │
│  ├─jmj-zipkin--------------------------微服务日志采集中心
│  │
│  ├─jmj-gateway--------------------------微服务网关中心
│  │
│  ├─jmj-provider
│  │  │
│  │  ├─jmj-provider-mdc------------------数据服务中心
│  │  │
│  │  ├─jmj-provider-omc------------------订单服务中心
│  │  │
│  │  ├─jmj-provider-opc------------------对接服务中心
│  │  │
│  │  ├─jmj-provider-tpc------------------任务服务中心
│  │  │
│  │  └─jmj-provider-uac------------------用户服务中心
│  │
│  ├─jmj-provider-api
│  │  │
│  │  ├─jmj-provider-mdc-api------------------数据服务中心API
│  │  │
│  │  ├─jmj-provider-omc-api------------------订单服务中心API
│  │  │
│  │  ├─jmj-provider-opc-api------------------对接服务中心API
│  │  │
│  │  ├─jmj-provider-tpc-api------------------任务服务中心API
│  │  │
│  │  ├─jmj-provider-sdk-api------------------可靠消息服务API
│  │  │
│  │  └─jmj-provider-uac-api------------------用户服务中心API
│  │
│  ├─jmj-common
│  │  │
│  │  ├─jmj-common-base------------------公共POJO基础包
│  │  │
│  │  ├─jmj-common-config------------------公共配置包
│  │  │
│  │  ├─jmj-common-core------------------微服务核心依赖包
│  │  │
│  │  ├─jmj-common-util------------------公共工具包
│  │  │
│  │  ├─jmj-common-zk------------------zookeeper配置
│  │  │
│  │  ├─jmj-security-app------------------公共无状态安全认证
│  │  │
│  │  ├─jmj-security-core------------------安全服务核心包
│  │  │
│  │  └─jmj-security-feign------------------基于auth2的feign配置
│  │
│  ├─jmj-generator
│  │  │
│  │  ├─jmj-generator-mdc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─jmj-generator-omc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─jmj-generator-opc------------------数据服务中心Mybatis Generator
│  │  │
│  │  ├─jmj-generator-tpc------------------数据服务中心Mybatis Generator
│  │  │
│  │  └─jmj-generator-uac------------------数据服务中心Mybatis Generator


```

### 作者介绍

### QQ群交流

### FAQ

### 传送门

学习视频：https://www.bilibili.com/video/BV1Et411c7JD?p=59&spm_id_from=pageDriver
学习项目：https://github.com/paascloud/paascloud-master

### 架构图


