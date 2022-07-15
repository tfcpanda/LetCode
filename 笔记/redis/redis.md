![image-20211027103129734](C:\Users\田付成\AppData\Roaming\Typora\typora-user-images\image-20211027103129734.png)

### docker 进入redis

```
docker exec -it dsdfsdfsdf redis-cli
```



### 持久化

```
docker exec -it d625e0f2a58f redis-cli

info

auth 123456

config set stop-writes-on-bgsave-error no
```



```
根据前缀删除redis里面的数据
Set<String> keys = stringRedisTemplate.keys("futureData" + "*");
stringRedisTemplate.delete(keys);
log.info("清空redis");
```



