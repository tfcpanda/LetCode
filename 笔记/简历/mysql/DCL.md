## 第6章：mysql核心知识之DCL数据控制语言（对用户权限的设置）

**简介：精讲数据控制语言如何限制用户的各种权限**

- 什么是DCL数据控制语言？

  数据控制语言（DCL：Data Control Language）是用来设置或者更改数据库用户或角色权限的语句，这些语句包括GRANT、DENY、REVOKE等语句

### 6.1 mysql限制root用户指定ip登录

**简介：详解如何从安全角度出发限制root用户指定ip登录**

- 查看root用户可以在哪台机器登录

```
select user,host from mysql.user where user='root';
```

- 修改mysql库里边的user表

```
 update mysql.user set host='localhost' where user='root';
```

- 刷新权限

```
flush privileges;
```

### 6.2 mysql必备知识之用户密码

**简介：详解忘记密码以及如何修改用户密码**

- 修改用户密码分三种方法：

1. 第一种：set password for 用户@ip = password('密码');

   ```
     set password for root@localhost = password('root');
   ```

2. 第二种：mysqladmin -u用户 -p旧密码 password 新密码;

   ```
   mysqladmin -urootmysqladmin -uroot -proot password;
   ```

3. 第三种：update mysql.user set authentication_string=password('密码') where user='用户' and host='ip';

   ```
   update mysql.user set authentication_string=password('root') where user='root' and host='localhost';
   ```

- 忘记密码:

1. 第一步：修改配置文件my.cnf (默认在/etc/my.cnf)，在[mysqld]下面加上 skip-grant-tables （跳过权限的意思）
2. 第二步：重启mysql服务
3. 第三步：mysql -uroot -p 无需密码登录进入
4. 第四步：修改密码

### 6.3 mysql实战系列之创建新用户并限制ip网段登录

**简介：讲解如何创建新用户与删除用户并限制ip登录**

- 创建用户的语法：create user 'username'@'host' identified by 'password';

```
username：你将创建的用户名

host：指定该用户在哪个主机上可以登陆，如果是本地用户可用localhost，如果想让该用户可以从任意远程主机    登陆，可以使用通配符%

password：该用户的登陆密码，密码可以为空，如果为空则该用户可以不需要密码登陆服务器
```

- 创建用户语法：

创建一个pig用户，并指定登录密码：123456，可以在任何一台远程主机都可以登录

```
create user 'pig'@'%' identified by '123456';
```

创建一个pig用户，并指定登录密码：为空，指定在120网段的机器登录

```
create user 'pig'@'120.%.%.%' identified by '';
```

- 查看权限：

```
   select * from mysql.user where user='pig'\G
    mysql> show grants for 'pig'@'%';
    +---------------------------------+
    | Grants for pig@%                |
    +---------------------------------+
    | GRANT USAGE ON *.* TO 'pig'@'%' |
    +---------------------------------+
    USAGE：无权限的意思
    mysql> show grants for 'root'@'localhost';
    +---------------------------------------------------------------------+
    | Grants for root@localhost                                           |
    +---------------------------------------------------------------------+
    | GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' WITH GRANT OPTION |
    +---------------------------------------------------------------------+
    WITH GRANT OPTION:表示这个用户拥有grant权限，即可以对其他用户授权
```

- 删除用户语法：drop user 'username'@'host';

```
   drop user 'pig'@'%';
   delete from mysql.user where user='pig';
```

### 6.4 mysql实战系列之库表权限授权与回收

**简介：讲解如何限制用户对库表的增删改查权限**

- 授权语法：grant 权限1,权限2..... on 数据库对象 to '用户'

```
grant 权限1,权限2..... on 数据库对象 to '用户'@'host' identified by 'password';
```

- all privileges:代表所有权限
- *.* :代表所有库所有表

```
对现有用户进行授权：对现有用户pig授予所有库所有表所有权限。
grant all privileges on *.*  to 'pig';
对没有的用户进行授权：创建一个新用户dog授予XD库的所有权限，登录密码123456，任何一台主机登录
grant all privileges on XD.* to 'dog'@'%' identified by '123456';
对没有的用户进行授权：创建一个新用户cat授予XD库的employee表 查与修改权限，登录密码123456，任何一台主机登录
grant select,update on XD.employee to 'cat'@'%' identified by '123456'
对没有的用户进行授权：对用户cat授予XD库的employee表insert 权限，登录密码123456，任何一台主机登录
grant insert on XD.employee to 'cat'@'%' identified by '123456';
```

- 回收语法：revoke 权限1,权限2..... on 数据库对象 from '用户'@'host';

```
回收pig用户的所有权限（注意：并没有回收它的登录权限）
revoke all privileges on *.*  from 'pig' @ '%';
flush privileges;
回收pig用户的所有权限（并回收它的登录权限）
delete from mysql.user where user='pig';
flush privileges;
回收cat用户对XD库的employee的查与修改权限
revoke select,update on XD.employee from 'cat'@'%';
flush privileges;
```