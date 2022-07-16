# 清除缓存文件



```aidl
git rm -r --cached .  
git add .  
git commit -m ".gitignore重写缓存成功"  
git push
```


重新提交后发现.gitignore文件生效了

原理解读
.gitignore文件只会在第一次提交项目的时候写入缓存，也就是说如果你第一次提交项目时候忘记写.gitignore文件，后来再补上是没有用的，.gitignore文件是不生效的。因为在缓存中已经标记该项目不存在ignore文件了（boolean）

所以我们使用git rm -r --cached .去清除所有的缓存。然后再次提交代码就可以了，这样.gitignore文件就会生效了。  
————————————————
版权声明：本文为CSDN博主「大前端工程师」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/chengqige/article/details/123768773