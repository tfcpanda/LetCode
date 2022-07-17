**简介：讲解表数据新增的多种例子**

- 普通的插入表数据

```
insert into 表名（字段名） values（字段对应值）;

insert into employee (empno,ename,job,mgr,hiredate,sal,deptnu) values ('1000','小明','经理','10001','2019-03-03','12345.23','10');

insert into 表名 values（所有字段对应值）;
insert into employee  values ('1001','小明','经理','10001','2019-03-03','12345.23','10');    
```

- 蠕虫复制（将一张表的数据复制到另一张表中）

```
insert into 表名1 select * from 表名2;

insert into 表名1（字段名1，字段名2） select 字段名1，字段名2 from 表名2;

insert into emp (empno,ename) select empno,ename from employee;
```

- 建表复制

```
create table 表名1 as select 字段名1，字段名2 from 表名2;

create table emp as select empno ,ename from employee;
```

- 一次性插入多个数据

```
 insert into 表名  (字段名) values (对应值1),(对应值2),(对应值3);   
```

- 创建sql：

```
某个公司的员工表
CREATE TABLE employee(
    empno       INT  PRIMARY KEY comment '雇员编号',
    ename       VARCHAR(20) comment '雇员姓名',
    job         VARCHAR(20) comment '雇员职位',
    mgr         INT comment '雇员上级编号',
    hiredate    DATE comment '雇佣日期',
    sal         DECIMAL(7,2) comment '薪资',
    deptnu      INT comment '部门编号'
    );
```

**简介：讲解如何对表数据进行修改删除以及注意事项**

- 修改（更新）：

  ```
  update 表名 set 字段名1=值1 where 字段名=值;
  update 表名 set 字段名1=值1,字段名2=值2 where 字段名=值;
  ```

  

- 删除：

  ```
  delete from 表名 where 字段名=值;
  truncate table 表名;
  delete from 表名;
  drop table 表名;
  ```

  

- 注意事项：

  ```
  面试时：面试官问在删改数据之前，你会怎么做？
  答案：会对数据进行备份操作，以防万一，可以进行数据回退
  
  面试时：面试官会问，delete与truncate与drop 这三种删除数据的共同点都是删除数据，他们的不同点是什么?
  delele 会把删除的操作记录给记录起来，以便数据回退，不会释放空间，而且不会删除定义。
  truncate不会记录删除操作，会把表占用的空间恢复到最初，不会删除定义
  drop会删除整张表，释放表占用的空间。
  ```

- 删除速度：

  ```
  drop > truncate > delete
  ```

