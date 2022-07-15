# 前言：

记录一下在使用Spring Boot 时，由于对框架不熟悉，在项目启动的过程中遇到的问题

# 问题描述：

**问题一**：dao层注入问题



```bash
Field xxMapper in xx.service.impl.xxServiceImpl required a bean of type 'xx.mapper.xxMapper
```

以前是通过xml文件配置的，但spring boot不用配置xml文件。
 解决方法：
 1：可以在每个dao加上@Mapper或者@Repository注解
 2：统一在启动类配置@MapperScan



```java
@SpringBootApplication
@MapperScan("com.example.demo.base.mapper")
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

**问题二**：配置好之后，启动项目又出现数据源配置问题



```bash
Failed to configure a DataSource: ‘url’ attribute is not specified and no embedded datasource could be configured
```

项目中加了Mybatis依赖jar包，SpringBoot数据源自动配置需要我们配置主类中加入@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})自动注入



```java
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@MapperScan("com.example.demo.base.mapper")
@ComponentScan(basePackages = {"com.example.demo"})
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
```

接下来又报错。。。



```bash
Property 'sqlSessionFactory' or 'sqlSessionTemplate' are required
```

原因是mybatis-spring-1.3.2中取消了自动注入SqlSessionFactory 和 SqlSessionTemplate，也就是mybatis依赖版本的问题。

**方案一：**
 mybatis版本太高（1.3.2），于是降级到1.1.1解决问题。
 （换这个太麻烦，没有实践，但听说还是有用。。）

**方案二：**
 创建一个Dao的基类CommonDao，让这个基类继承SqlSessionDaoSupport，并通过set方法注入SqlSessionFactory属性即可：



```java
public class CommonDao extends SqlSessionDaoSupport {
    @Resource
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
        super.setSqlSessionFactory(sqlSessionFactory);
    }
}
```

然后让Dao实现类再继承这个CommonDao基类即可。（但我dao用的是接口，不适用）

**方案三：**
 后面将(exclude={DataSourceAutoConfiguration.class})去掉，将application.properties中配置放到新建的application.yml中

application.yml



```yaml
spring:
  datasource:
    url: jdbc:mysql://127.0.0.1:3306/demo_db?serverTimezone=GMT%2B8
    username: root
    password: root
    driver-class-name: com.mysql.jdbc.Driver
```

项目启动成功

**方案四：**
 上面说SqlSessionFactory 和 SqlSessionTemplate没有自动注入，那我们可以自己手动注入



```java
@Value("${mybatis-plus.mapper-locations}")
    private String mapperLocations;
    //配置FactoryBean
    @Bean(name = "sqlSessionFactoryBean")
    public SqlSessionFactoryBean sqlSessionFactoryBean() {
        SqlSessionFactoryBean sqlSessionFactoryBean = null;
        try {
            // 加载JNDI配置
            Context context = new InitialContext();
            // 实例SessionFactory
            sqlSessionFactoryBean = new SqlSessionFactoryBean();
            // 配置数据源
            sqlSessionFactoryBean.setDataSource(dataSource());
            // 加载MyBatis配置文件
            PathMatchingResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
            // 能加载多个，所以可以配置通配符(如：classpath*:mapper/**/*.xml)
            sqlSessionFactoryBean.setMapperLocations(resourcePatternResolver.getResources(mapperLocations));
        } catch (Exception e) {
            System.out.println("创建SqlSession连接工厂错误：{}");
        }
        return sqlSessionFactoryBean;
    }
    @Bean
    public SqlSessionTemplate sqlSessionTemplate() throws Exception {
        SqlSessionTemplate sqlSessionTemplate=new SqlSessionTemplate(sqlSessionFactoryBean().getObject(),ExecutorType.BATCH);
        return sqlSessionTemplate;
    }
```

)





