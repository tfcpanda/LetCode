启动    systemctl start docker

守护进程重启  sudo systemctl daemon-reload

重启docker服务  systemctl restart  docker

重启docker服务  sudo service docker restart

关闭docker service docker stop

关闭docker systemctl stop docker







### 进入docker容器命令

docker exec -it 65368eb0f4a7 /bin/bash  



容器重新命名：docker rename [] []







i : 交互模式

d : 持久化

t ：开个dos框

p：端口号

v：挂载

--name=xxx  命名

镜像：版本号





### 创建mongo容器

```
docker run -itd -p 27013:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456 -v /home/work/data/mongo/mongo13/data:/data/db -v /home/work/data/mongo/mongo13/config:/data/conf -v /home/work/data/mongo/mongo13/log:/data/log --name=mg03 mongo --auth --config /data/conf/mongod.yml

docker run -itd -p 27012:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456 -v /home/work/data/mongo/mongo12/data:/data/db -v /home/work/data/mongo/mongo12/config:/data/conf -v /home/work/data/mongo/mongo12/log:/data/log --name=mg02 mongo:3.6.21 --auth --config /data/conf/mongod.yml

docker run -itd -p 27011:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456 -v /home/work/data/mongo/mongo11/data:/data/db -v /home/work/data/mongo/mongo11/config:/data/conf -v /home/work/data/mongo/mongo11/log:/data/log --name=mg01 mongo --auth --config /data/conf/mongod.yml

docker run -itd -p 27017:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456 -v /home/work/data/mongo/mongo17/data:/data/db -v /home/work/data/mongo/mongo17/config:/data/conf -v /home/work/data/mongo/mongo17/log:/data/log --name=mg00 mongo --auth --config /data/conf/mongod.yml
```



### 创建redis容器

```
docker run -itd --name r0 -p 6379:6379 -v /home/work/data/redis/redis6379:/data redis:6.0.9 --requirepass firstquant@redis
```







### 直接进入mongo

```
docker run -it --rm --network=host mongo:3.6.21 mongo -u mongoadmin -p cckj1239fjb --authenticationDatabase admin --port 27011


docker run -it --rm --network=host mongo:3.6.21 mongo -u mongoadmin -p cckj1239fjb --authenticationDatabase admin --port 27013
```














--name mongo mongo:4.0



docker run -itd -p 27012:27017  -v mongo_configdb:/home/work/data/mongo/mongo12/config  -v mongo_db:/home/work/data/mongo/mongo12/data --name=mg02 mongo

```
$ docker exec -it mongo mg02 admin

docker exec -it mongo mg01 admin

```



docker run -itd -p 27011:27017 -e MONGO_INITDB_ROOT_USERNAME=admin -e MONGO_INITDB_ROOT_PASSWORD=123456  -v /home/work/data/mongo/mongo11:/data/db --name=mg01 mongo --auth 







docker run -itd -p 27017:27017  -v mongo_configdb:/home/work/data/mongo/mongo17/config  -v mongo_db:/home/work/data/mongo/mongo17/data --name=mg00 mongo



```bash
docker run  -d \
  -e MONGO_INITDB_ROOT_USERNAME=admin \
  -e MONGO_INITDB_ROOT_PASSWORD=123456 \
  -v /home/work/data/mongo/mongo11:/data/db \
  -p 27011:27017 \
  --name mg01 \
  --restart always \
  --auth \
  mongo
```

 



https://blog.sunriseydy.top/technology/linux/docker-install-mongodb/#toc-4



https://juejin.cn/post/6959151757955956749

