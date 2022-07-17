## 第5章：mysql核心知识之DQL数据查询语言与项目高级查询实战

**简介：细讲对数据表中的数据进行各种查询，以及项目实战查询**

```
/*创建部门表*/
CREATE TABLE dept(
    deptnu      INT  PRIMARY KEY comment '部门编号',
    dname       VARCHAR(50) comment '部门名称',
    addr        VARCHAR(50) comment '部门地址'
);

某个公司的员工表
CREATE TABLE employee(
    empno       INT  PRIMARY KEY comment '雇员编号',
    ename       VARCHAR(50) comment '雇员姓名',
    job         VARCHAR(50) comment '雇员职位',
    mgr         INT comment '雇员上级编号',
    hiredate    DATE comment '雇佣日期',
    sal         DECIMAL(7,2) comment '薪资',
    deptnu      INT comment '部门编号'
)ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*创建工资等级表*/
CREATE TABLE salgrade(
    grade       INT  PRIMARY KEY comment '等级',
    lowsal      INT comment '最低薪资',
    higsal      INT comment '最高薪资'
);

/*插入dept表数据*/
INSERT INTO dept VALUES (10, '研发部', '北京');
INSERT INTO dept VALUES (20, '工程部', '上海');
INSERT INTO dept VALUES (30, '销售部', '广州');
INSERT INTO dept VALUES (40, '财务部', '深圳');

/*插入emp表数据*/
INSERT INTO employee VALUES (1009, '唐僧', '董事长', NULL, '2010-11-17', 50000,  10);
INSERT INTO employee VALUES (1004, '猪八戒', '经理', 1009, '2001-04-02', 29750, 20);
INSERT INTO employee VALUES (1006, '猴子', '经理', 1009, '2011-05-01', 28500, 30);
INSERT INTO employee VALUES (1007, '张飞', '经理', 1009, '2011-09-01', 24500,10);
INSERT INTO employee VALUES (1008, '诸葛亮', '分析师', 1004, '2017-04-19', 30000, 20);
INSERT INTO employee VALUES (1013, '林俊杰', '分析师', 1004, '2011-12-03', 30000, 20);
INSERT INTO employee VALUES (1002, '牛魔王', '销售员', 1006, '2018-02-20', 16000, 30);
INSERT INTO employee VALUES (1003, '程咬金', '销售员', 1006, '2017-02-22', 12500, 30);
INSERT INTO employee VALUES (1005, '后裔', '销售员', 1006, '2011-09-28', 12500, 30);
INSERT INTO employee VALUES (1010, '韩信', '销售员', 1006, '2018-09-08', 15000,30);
INSERT INTO employee VALUES (1012, '安琪拉', '文员', 1006, '2011-12-03', 9500,  30);
INSERT INTO employee VALUES (1014, '甄姬', '文员', 1007, '2019-01-23', 7500, 10);
INSERT INTO employee VALUES (1011, '妲己', '文员', 1008, '2018-05-23', 11000, 20);
INSERT INTO employee VALUES (1001, '小乔', '文员', 1013, '2018-12-17', 8000, 20);

/*插入salgrade表数据*/
INSERT INTO salgrade VALUES (1, 7000, 12000);
INSERT INTO salgrade VALUES (2, 12010, 14000);
INSERT INTO salgrade VALUES (3, 14010, 20000);
INSERT INTO salgrade VALUES (4, 20010, 30000);
INSERT INTO salgrade VALUES (5, 30010, 99990);
```

### 5.1 mysql查询子句之一where条件查询

**简介：详解where条件下的各种查询**

- 简单查询

  ```
  select * from employee;
  ```

  ```
  select empno,ename,job as ename_job from employee;
  ```

- 精确条件查询

  ```
  select * from employee where ename='后裔';
  ```

  ```
  select * from employee where sal != 50000;
  ```

  ```
  select * from employee where sal <> 50000;
  ```

  ```
  select * from employee where sal > 10000;
  ```

- 模糊条件查询

  ```
  show variables like '%aracter%'; 
  ```

  ```
  select * from employee  where ename like '林%';
  ```

- 范围查询

  ```
  select * from employee where sal between 10000 and 30000;
  ```

  ```
  select * from employee where hiredate between '2011-01-01' and '2017-12-1';
  ```

- 离散查询

  ```
  select * from employee where ename in ('猴子','林俊杰','小红','小胡');  
  ```

- 清除重复值

  ```
  select distinct(job) from employee;
  ```

- 统计查询（聚合函数）:

  ```
         count(code)或者count(*)
  ```

  ```
          select count(*) from employee;
  ```

  ```
          select count(ename) from employee;
  ```

  ```
          
  ```

  ```
         sum()  计算总和 
  ```

  ```
          select sum(sal) from employee;
  ```

  ```
          
  ```

  ```
         max()    计算最大值
  ```

  ```
          select * from employee where sal= (select  max(sal) from employee);
  ```

  ```
          
  ```

  ```
         avg()   计算平均值
  ```

  ```
          select avg(sal) from employee;
  ```

  ```
          
  ```

  ```
         min()   计算最低值
  ```

  ```
          select * from employee where sal= (select  min(sal) from employee);
  ```

  ```
          
  ```

  ```
         concat函数： 起到连接作用
  ```

  ```
          select concat(ename,' 是 ',job) as aaaa from employee;
  ```

### 5.2 mysql查询子句之二group by分组查询（分组）

**简介：详解group by的用法以及应用场景**

- 作用：把行 按 字段 分组
- 语法：group by 列1，列2....列N
- 适用场合：常用于统计场合，一般和聚合函数连用

```
eg:
     select deptnu,count(*) from employee group by deptnu;
     select deptnu,job,count(*) from employee group by deptnu,job;
     select job,count(*) from employee group by job;
```

### 5.3 mysql查询子句之三having条件查询（筛选）

**简介：详解having的用法以及应用场景**

- 作用：对查询的结果进行筛选操作
- 语法：having 条件 或者 having 聚合函数 条件
- 适用场合：一般跟在group by之后

```
eg:
    select job,count(*) from employee group by job having job ='文员';
    select  deptnu,job,count(*) from employee group by deptnu,job having count(*)>=2;
    select  deptnu,job,count(*) as 总数 from employee group by deptnu,job having 总数>=2;
```

### 5.4 mysql查询子句之四order by排序查询（排序）

**简介：详解order by的用法以及应用场景**

- 作用：对查询的结果进行排序操作
- 语法：order by 字段1,字段2 .....
- 适用场合：一般用在查询结果的排序

```
eg:
     select * from employee order by sal;
     select * from employee order by hiredate;
     select  deptnu,job,count(*) as 总数 from employee group by deptnu,job having 总数>=2 order by deptnu desc;
     select  deptnu,job,count(*) as 总数 from employee group by deptnu,job having 总数>=2 order by deptnu asc;
     select  deptnu,job,count(*) as 总数 from employee group by deptnu,job having 总数>=2 order by deptnu;

     顺序：where ---- group by ----- having ------ order by 

```

### 5.5 mysql查询子句之五limit限制查询（限制）

**简介：详解limit的用法以及应用场景**

- 作用：对查询结果起到限制条数的作用
- 语法：limit n，m n:代表起始条数值，不写默认为0；m代表：取出的条数
- 适用场合：数据量过多时，可以起到限制作用

```
eg:
    select * from XD.employee limit 4,5;
```

### 5.6 mysql查询之exists型子查询

**简介：详解exists的用法**

- exists型子查询后面是一个受限的select查询语句
- exists子查询，如果exists后的内层查询能查出数据，则返回 TRUE 表示存在；为空则返回 FLASE则不存在。

```
分为俩种：exists跟 not exists

select 1 from employee where 1=1;
select * from 表名 a where exists (select 1 from 表名2 where 条件);

eg:查询出公司有员工的部门的详细信息
select * from dept a where exists (select 1 from employee b where a.deptnu=b.deptnu);
select * from dept a where not exists (select 1 from employee b where a.deptnu=b.deptnu);
```

### 5.7 mysql查询之左连接查询与右连接查询

**简介：详解左右连接的用法以及应用场景**

- 左连接称之为左外连接 右连接称之为右外连接 这俩个连接都是属于外连接
- 左连接关键字：left join 表名 on 条件 / left outer 表名 join on 条件 右连接关键字：right join 表名 on 条件/ right outer 表名 join on 条件
- 左连接说明： left join 是left outer join的简写，左(外)连接，左表(a_table)的记录将会全部表示出来， 而右表(b_table)只会显示符合搜索条件的记录。右表记录不足的地方均为NULL。
- 右连接说明：right join是right outer join的简写，与左(外)连接相反，右(外)连接，左表(a_table)只会显示符合搜索条件的记录，而右表(b_table)的记录将会全部表示出来。左表记录不足的地方均为NULL。

```
eg:列出部门名称和这些部门的员工信息，同时列出那些没有的员工的部门
        dept，employee
        select a.dname,b.* from dept a  left join employee b on a.deptnu=b.deptnu;
        select b.dname,a.* from employee a  right join  dept b on b.deptnu=a.deptnu;

```

### 5.8 mysql查询之内连接查询与联合查询

**简介：详解内连接与联合查询的用法以及应用场景**

- 内连接：获取两个表中字段匹配关系的记录
- 主要语法：INNER JOIN 表名 ON 条件;

```
eg:想查出员工张飞的所在部门的地址
    select a.addr  from dept a inner join employee b on a.deptnu=b.deptnu and b.ename='张飞';
    select a.addr from dept a,employee b where a.deptnu=b.deptnu and b.ename='张飞';

```

- 联合查询：就是把多个查询语句的查询结果结合在一起

主要语法1：... UNION ... （去除重复） 主要语法2：... UNION ALL ...（不去重复）

- union查询的注意事项：

  ```
  (1)两个select语句的查询结果的“字段数”必须一致；
  ```

  ```
  (2)通常，也应该让两个查询语句的字段类型具有一致性；
  ```

  ```
  (3)也可以联合更多的查询结果；
  ```

  ```
  (4)用到order by排序时，需要加上limit（加上最大条数就行），需要对子句用括号括起来
  ```

  

  ```
  eg:对销售员的工资从低到高排序，而文员的工资从高到低排序
  ```

  ```
      (select * from employee a where a.job = '销售员'  order by a.sal limit 999999 ) union  (select * from employee b where b.job = '文员' order by b.sal desc limit 999999);
  ```