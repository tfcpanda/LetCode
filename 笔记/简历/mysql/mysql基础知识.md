

**简介：mysql的service服务管理与登录管理**

- ```
  查看mysql服务进程：ps -ef | grep mysql
  ```

- ```
  service服务管理：cp -a mysql.server /etc/rc.d/init.d/mysql
  ```

- ```
  启动命令：service mysql start
  ```

  ```
  关闭命令：service mysql stop
  ```

  ```
  重新启动命令：service mysql restart
  ```

  ```
  查看状态命令：service mysql status
  ```

- ```
  登录管理： ln -s /usr/local/mysql/bin/*  /bin
  ```

  ```
  登录命令：mysql -uroot -p
  ```

- ```
  默认端口号：3306
  ```

  ```
  配置文件：/etc/my.cnf
  ```

**简介：命令行的登录与图形化界面的登录**

- ```
  命令行模式：
  ```

  ```
      登录命令：mysql -u用户 -p密码
  ```

  ```
      退出命令：exit;  quit;
  ```

- ```
  图形化模式：
  ```

  ```
      ip地址或者主机名：120.76.62.13
  ```





1. DDL 数据定义语言 (Data Definition Language) 例如：建库，建表
2. DML 数据操纵语言(Data Manipulation Language) 例如：对表中的数据进行增删改操作
3. DQL 数据查询语言(Data Query Language) 例如：对数据进行查询
4. DCL 数据控制语言(Data Control Language) 例如：对用户的权限进行设置













