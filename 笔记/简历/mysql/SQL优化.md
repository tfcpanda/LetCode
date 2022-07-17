## 第9章：mysql不得不学的sql语句优化思路

**简介：介绍如何对sql查询语句进行优化**

### 9.1 mysql的慢查询日志开启与问题定位

**简介：介绍如何开启慢查询日志与问题定位**

- 第一步：查看是否已经开启了慢查询日志

```
mysql> show variables like 'slow%';
+---------------------+--------------------------------------+
| Variable_name       | Value                                |
+---------------------+--------------------------------------+
| slow_launch_time    | 2                                    |
| slow_query_log      | OFF                                  |
| slow_query_log_file | /data/mydata/xdclass-public-slow.log |
+---------------------+--------------------------------------+
```

- 第二步：开启慢查询日志

```
set global slow_query_log = on ;

日志路径也可以自定义：

set global slow_query_log_file = '路径';
```

- 第三步：查看慢查询的时间临界值

```
show variables like '%long%';
```

- 第四步：设置慢查询的时间标准

```
set long_query_time=0.4;
```

- 注意：重启mysql服务会让在交互界面设置的慢查询恢复到默认

```
永久生效的设置方法：修改配置文件 vi /etc/my.cnf
[mysqld]
slow_query_log = 1
long_query_time = 0.1
slow_query_log_file =/usr/local/mysql/mysql_slow.log

最后必须重启服务才能生效！
```

 

### 9.2 mysql的sql语句执行过程解析

**简介：介绍如何开启性能详情**

- 第一步：查看性能详情是否开启

```
mysql> show variables like '%profiling%';
+------------------------+-------+
| Variable_name          | Value |
+------------------------+-------+
| have_profiling         | YES   |
| profiling              | OFF   |
| profiling_history_size | 15    |
+------------------------+-------+
```

- 第二步：开启性能记录功能

```
set profiling = on ;
```

- 第三步：查看性能的记录

```
mysql> show profiles;
+----------+------------+---------------------------------------------------+
| Query_ID | Duration   | Query                                             |
+----------+------------+---------------------------------------------------+
|        1 | 0.00177775 | show variables like '%profiling%'                 |
|        2 | 0.00037900 | select * from test where id='087878'              |
|        3 | 0.34618025 | select * from test where servnumber='1367008787'  |
|        4 | 0.31986825 | select * from test where servnumber='13670087879' |
+----------+------------+---------------------------------------------------+
```

- 第四步：查看语句的执行性能详情

```
mysql> show profile for query 4;
+----------------------+----------+
| Status               | Duration |
+----------------------+----------+
| starting             | 0.000100 |
| checking permissions | 0.000010 |
| Opening tables       | 0.000023 |
| init                 | 0.000045 |
| System lock          | 0.000015 |
| optimizing           | 0.000016 |
| statistics           | 0.000028 |
| preparing            | 0.000020 |
| executing            | 0.000006 |
| Sending data         | 0.319489 |
| end                  | 0.000037 |
| query end            | 0.000012 |
| closing tables       | 0.000012 |
| freeing items        | 0.000040 |
| cleaning up          | 0.000017 |
+----------------------+----------+
```

- 性能线程的详细解释官方文档链接：

```
https://dev.mysql.com/doc/refman/5.7/en/general-thread-states.html
```

### 9.3 mysql语句优化的几个小建议

**简介：介绍日常工作应该尽量避免的sql语句**

- 第一个注意点：

```
尽量避免使用select *from ，尽量精确到想要的结果字段
```

- 第二个注意点：

```
尽量避免条件使用or
```

- 第三个注意点：

```
记得加上limit 限制行数，避免数据量过大消耗性能
```

- 第四个注意点：

```
使用模糊查询时，%放在前面是会使索引失效

mysql> explain select * from test where servnumber like '%1367000%'\G
*************************** 1. row ***************************
           id: 1
  select_type: SIMPLE
        table: test
   partitions: NULL
         type: ALL
possible_keys: NULL
          key: NULL
      key_len: NULL
          ref: NULL
         rows: 996303
     filtered: 11.11
        Extra: Using where
```

- 第五个注意点：

```
要小心条件字段类型的转换
```