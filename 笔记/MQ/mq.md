- 什么是MQ消息中间件
  - 全称MessageQueue，主要是用于程序和程序直接通信，异步+解耦



- 使用场景：

  - 核心应用
    - 解耦：订单系统-》物流系统
    - 异步：用户注册-》发送邮件，初始化信息
    - 削峰：秒杀、日志处理
  - 跨平台 、多语言
  - 分布式事务、最终一致性
  - RPC调用上下游对接，数据源变动->通知下属

  ![image-20220618173359163](C:\Users\田付成\AppData\Roaming\Typora\typora-user-images\image-20220618173359163.png)



**讲解什么是AMQP和JMS消息服务**

- 什么是JMS: Java消息服务（Java Message Service),Java平台中关于面向消息中间件的接口
  - JMS是一种与厂商无关的 API，用来访问消息收发系统消息，它类似于JDBC(Java Database Connectivity)。这里，JDBC 是可以用来访问许多不同关系数据库的 API
  - 是由Sun公司早期提出的消息标准，旨在为java应用提供统一的消息操作，包括create、send、receive
  - JMS是针对java的，那微软开发了NMS（.NET消息传递服务）



**简介：介绍什么是AMQP高级消息队列协议和MQTT科普**

- 背景
  - JMS或者NMS都没有标准的底层协议，它们可以在任何底层协议上运行，但是API是与编程语言绑定的，AMQP解决了这个问题，它使用了一套标准的底层协议



- 什么是AMQP
  - AMQP（advanced message queuing protocol）在2003年时被提出，最早用于解决金融领不同平台之间的消息传递交互问题,就是是一种协议，兼容JMS
  - 更准确说的链接协议 binary- wire-level-protocol 直接定义网络交换的数据格式，类似http
  - 具体的产品实现比较多，RabbitMQ就是其中一种





- 科普：大家可能也听过MQTT
  - MQTT: 消息队列遥测传输（Message Queueing Telemetry Transport ）
  - 背景：
    - 我们有面向基于Java的企业应用的JMS和面向所有其他应用需求的AMQP，那这个MQTT是做啥的？
  - 原因
    - 计算性能不高的设备不能适应AMQP上的复杂操作,MQTT它是专门为小设备设计的
    - MQTT主要是是物联网（IOT）中大量的使用
  - 特性
    - 内存占用低，为小型无声设备之间通过低带宽发送短消息而设计
    - 不支持长周期存储和转发，不允许分段消息（很难发送长消息）
    - 支持主题发布-订阅、不支持事务（仅基本确认）
    - 消息实际上是短暂的（短周期）
    - 简单用户名和密码、不支持安全连接、消息不透明











  

















