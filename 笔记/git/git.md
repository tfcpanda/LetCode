**git branch -d {branchName}**



 **git flow开发流程简化一下**

 git reflog  查询git操作日志



**查看日志信息**

**git log --online**

![image-20210831113557030](C:\Users\田付成\AppData\Roaming\Typora\typora-user-images\image-20210831113557030.png)











```
git checkout -b 分支名 origin/分支名
拉去远程分支到本地。

git checkout -b dev-real origin/dev-real

git checkout -b dev origin/dev

git checkout -b dev_simulation_new origin/dev_simulation


rebase
```



```
添加多远程仓库， 注意origin名字不能一样
git remote add origin http://8.136.118.150:3000/TFC/CTP.git


http://52.131.32.21:3000/tamp/tamp-service.git
```

git remote add origin http://52.131.32.21:3000/tamp/tamp-service.git







# 回退本地代码

````
git本地操作有时会有误删误改并提交的时候，此时可以通过回滚获得之前的特定版本

1. 查看log

输入  git log  查看commit记录

[xxxxxxx]$ git log
 结果大致如下（根据实际的commit操作不同，显示结果也会有所不同）

commit 7d72d974a9ed718dc1f50194879d4409a9f5db4b (origin/qxw)
Merge: 99f3694 789a222
Author: taochengye <13601408243@163.com>
Date:   Wed Dec 5 15:16:24 2018 +0800
2. 找到需要回滚的commit

根据时间和用户确认需要回滚到的commitId，  输入git reset --hard {commitId}，将本地文件回滚

git reset --hard 7d72d974a9ed718dc1f50194879d4409a9f5db4b
如果需要同时回滚远程

简单总结一下，其实就是--soft 、--mixed以及--hard是三个恢复等级。使用--soft就仅仅将头指针恢复，已经add的缓存以及工作空间的所有东西都不变。如果使用--mixed，就将头恢复掉，已经add的缓存也会丢失掉，工作空间的代码什么的是不变的。如果使用--hard，那么一切就全都恢复了，头变，aad的缓存消失，代码什么的也恢复到以前状态。


[xxxxxxx]$ git push -f
````





4d02fa6b82272b36c68b9d67c2f4b9052c4c478d



03a87845b888886a9b20f50eabc58782f0281f822
