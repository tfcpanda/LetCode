### 5.9 mysql查询之项目高级查询实战(一)

**简介：高级查询实战**

- 查出至少有一个员工的部门。显示部门编号、部门名称、部门位置、部门人数。

```
    涉及表： employee dept
    语句：select deptnu,count(*) from employee group by deptnu
    语句：select a.deptnu,a.dname,a.addr, b.zongshu from dept a,(select deptnu,count(*) as zongshu from employee group by deptnu) b where a.deptnu=b.deptnu;
```

- 列出薪金比安琪拉高的所有员工。

```
    涉及表：employee
    语句：select * from  employee where sal > (select sal from employee where ename='安琪拉');
```

- 列出所有员工的姓名及其直接上级的姓名。

```
    涉及表：employee
    语句：select a.ename,ifnull(b.ename,'BOSS') as leader from employee a left join employee b on a.mgr=b.empno;
```

- 列出受雇日期早于直接上级的所有员工的编号、姓名、部门名称。

```
    涉及表：employee dept
    条件：a.hiredate < b.hiredate
    语句：select a.empno,a.ename,c.dname from employee a left join employee b on a.mgr=b.empno left join dept c on a.deptnu=c.deptnu where a.hiredate < b.hiredate;
```

- 列出部门名称和这些部门的员工信息，同时列出那些没有员工的部门。

```
    涉及表：dept employee
    语句：select a.dname,b.* from dept a left join employee b on a.deptnu=b.deptnu;
```

- 列出所有文员的姓名及其部门名称，所在部门的总人数。

```
    涉及表：employee dept
    条件：job='文员'
    语句：select deptnu,count(*) as zongshu from employee group by deptnu;
    语句：select b.ename,a.dname,b.job,c.zongshu from dept a ,employee b ,(select deptnu,count(*) as zongshu from employee group by deptnu) c where a.deptnu=b.deptnu and b.job='文员' and b.deptnu=c.deptnu;
```

### 5.10 mysql查询之项目高级查询实战(二)

**简介：高级查询实战续**

- 列出最低薪金大于15000的各种工作及从事此工作的员工人数。

```
    涉及表：employee
    条件：min(sal) > 15000 
    语句：select job,count(*) from employee group by job having   min(sal) > 15000;
```

- 列出在销售部工作的员工的姓名，假定不知道销售部的部门编号。

```
   涉及表：employee dept
   select  ename  from employee where deptnu=(select deptnu from dept where dname='销售部');
```

- 列出与诸葛亮从事相同工作的所有员工及部门名称。

```
    涉及表：employee dept
    语句：select a.ename,b.dname from employee a,dept b where a.deptnu=b.deptnu and a.job=                (select job from employee where ename='诸葛亮');
    语句：select a.ename,b.dname from employee a left join dept b on a.deptnu=b.deptnu where               a.job=(select job from employee where ename='诸葛亮');
```

- 列出薪金比 在部门30工作的员工的薪金 还高的员工姓名和薪金、部门名称。

```
    涉及表：employee dept
    语句：select a.ename,a.sal,b.dname from employee a ,dept b where a.deptnu=b.deptnu and sal >          (select max(sal) from employee where deptnu=30);
```

- 列出每个部门的员工数量、平均工资。

```
    涉及表：employee
    语句：select deptnu , count(*) ,avg (sal) from employee  group by deptnu;
```

- 列出薪金高于公司平均薪金的所有员工信息，所在部门名称，上级领导，工资等级。

```
    涉及表：employee dept salgrade
    条件：select avg(sal) from employee
    语句：elect a.*,c.dname,b.ename,d.grade from employee a,employee b,dept c ,salgrade d where           a.mgr=b.empno and a.deptnu =c.deptnu and a.sal > (select avg(sal) from employee)  and           a.sal  between d.lowsal and d.higsal;
```