# 创建用户的命令

```
db.createUser(
  {
    user: "fsd_ex",
    pwd: "123456",
    roles: [ { role: "readWrite", db: "exchange_setting" }  ]
  }
)


 db.createUser({user:'admin1',pwd:'123456',roles:[{ role:'userAdminAnyDatabase', db:'admin'}]});

 db.createUser({ user:'admin',pwd:'123456',roles:[ { role:'root', db: 'admin'}]});

 docker exec -it 699d54c0f1ed  admin

 
db.createUser({ user:'firstQuant',pwd:'123456',roles:[ { role:'userAdminAnyDatabase', db: 'admin'},"readWriteAnyDatabase"]});

 db.createUser({ user:'admin',pwd:'123456',roles:[ { role:'userAdminAnyDatabase', db: 'admin'},"readWriteAnyDatabase"]});


db.auth('admin', '123456')


docker exec -it mongo mongo mg0


 db.createUser({ user:'admin',pwd:'123456',roles:[ { role:'userAdminAnyDatabase', db: 'admin'}]});
Successfully added user: {
    "user" : "admin",
    "roles" : [
        {
            "role" : "userAdminAnyDatabase",
            "db" : "admin"
        }
    ]
}

作者：南瓜慢说
链接：https://juejin.cn/post/6844904003860430855
来源：稀土掘金
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
```

![](C:\Users\田付成\AppData\Roaming\Typora\typora-user-images\image-20211228150317438.png)

 db.createUser({ user:'admin',pwd:'123456',roles:[ { role:'root', db: 'admin'}]});









```
db.createUser(
  {
    user: "fsd_jq",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "jqkline_60"}
        ]
  }
)
```





```
db.createUser(
  {
    user: "fsd_si",
    pwd: "123456",
    roles: [
             { role: "readWrite", db: "simnow"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "fsd_sm",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "smticks"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "fsd_ba",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "fsd_test",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest"}
        ]
  }
)
```





```
db.createUser(
  {
    user: "fsd_jq900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "jqkline_900"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "fsd_ba900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_900"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "twoDBtry",
    pwd: "123456",
    roles: [ { role: "read", db: "backtest_setting" },
             { role: "readWrite", db: "smticks" } ]
  }
)


db.createUser(
  {
    user: "fsd_baSet900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_setting"}
        ]
  }
)
```





```
db.createUser(
  {
    user: "fsd_baSet900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_setting"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "loger",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "history"}
        ]
  }
)
```





# 删除用户的命令

```
 db.dropUser('tfc')
```

# 21012数据库用户创建

```
db.createUser(
  {
    user: "backTest300",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_300"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "backTest900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_900"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "backTestSetting",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_setting"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "exChangeSetting",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "exchange_setting"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "Jqkline60",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "jqkline_60"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "Jqkline300",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "jqkline_300"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "Jqkline900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "jqkline_900"}
        ]
  }
)
```

```
db.createUser(
  {
    user: "backTest60",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_60"}
        ]
  }
)
```



```
db.createUser(
  {
    user: "jqtick2109",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "jqtick_2109"}
        ]
  }
)
```































```
db.createUser(
  {
    user: "fsd_baSet900",
    pwd: "123456",
    roles: [ 
             { role: "readWrite", db: "backtest_setting"}
        ]
  }
)
```











```
package com.firstquant.futuresstrategydata.service.impl;

import com.firstquant.futuresstrategydata.commonutils.date.DateUtils;
import com.firstquant.futuresstrategydata.dao.BackTestDao;
import com.firstquant.futuresstrategydata.model.dto.backtest.Pf107_cs2107DTO;
import com.firstquant.futuresstrategydata.model.po.backtest.Pf107_cs2107;
import com.firstquant.futuresstrategydata.model.vo.backtest.Pf107_cs2107LongVO;
import com.firstquant.futuresstrategydata.model.vo.backtest.Pf107_cs2107VO;
import com.firstquant.futuresstrategydata.service.BackTestService;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: tfc
 * @Date: 2021/9/1
 * @Description:
 */


@Slf4j
@Service
public class BackTestServieImpl implements BackTestService {

    @Autowired
    private BackTestDao backTestDao;


    @Override
    public List<Pf107_cs2107DTO> getFromDate() {

        List<Pf107_cs2107VO> FromDate = backTestDao.getFromDate();
        DateUtils dateUtils = new DateUtils();
        List<Pf107_cs2107DTO> DtoList = new ArrayList<>();

        for (int i = 0; i < FromDate.size(); i++) {
            Pf107_cs2107DTO DtoObject = new Pf107_cs2107DTO();

            Pf107_cs2107VO pf107_cs2107VO = FromDate.get(i);

            //得到vo层里面的id值
            DtoObject.set_id(pf107_cs2107VO.get_id());

            //将开始时间转化成日期
            String StartDate = "";
            Long starttimes = pf107_cs2107VO.getStarttimes();
            StartDate = dateUtils.timeStamp2Date(starttimes, null);
            DtoObject.setStarttimes(StartDate);
            //将结束时间转化成日期
            String endDate = "";
            Long endtimes = pf107_cs2107VO.getEndtimes();
            endDate = dateUtils.timeStamp2Date(endtimes, null);
            DtoObject.setEndtimes(endDate);
            DtoList.add(i, DtoObject);
        }
        return DtoList;
    }

    @Override
    public List<String> getDeDuplicationFormatDate() {
        List<Long> DeDuplicationFormatDateList = backTestDao.getDeDuplicationFormatDate();

        DateUtils dateUtils = new DateUtils();
        List<String> DtoList = new ArrayList<>();

        for (int i = 0; i < DeDuplicationFormatDateList.size(); i++) {
            Long aLong = DeDuplicationFormatDateList.get(i);
            //将开始时间转化成日期
            String StartDate = "";
            StartDate = dateUtils.timeStamp2Date(aLong, null);
            DtoList.add(StartDate);
        }
        return DtoList;

    }
}

```



# mongodb慢查询治理



## 常用方法

1 查看是否开启慢查询

db.getProfilingStatus()

2 开启慢查询 

 db.setProfilingLevel(1,100);     

3 查看慢查询 

db.system.profile.find();



返回最近的 10条数据

```
db.system.profile.find().limit(1).sort( { ts : -1 } ).pretty()
```





db.CY2107.find({},{askps:1,bidps:1}).explain()

db.cs2107.find({"timestamp":1618924500})



```
package com.firstquant.dao;

import com.firstquant.futuresstrategydata.model.po.backtestpo.BackTestTemp;
import com.mongodb.*;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Author: tfc
 * @Date: 2021/9/27
 * @Description:
 */

@Slf4j
@ComponentScan(basePackages = "com.firstquant")
@SpringBootTest(classes = BackTestDaoTest.class)
public class CycleTest {

    @Autowired
    @Qualifier("tampMongo")
    private MongoTemplate tampMongo;


    @Test
    public void test() {
//        MongoClient client = new MongoClient("47.92.168.77",27011);
//        MongoDatabase database = client.getDatabase("admin");
//        MongoIterable<String> list = database.listCollectionNames();
//        for (String name:list){
//            System.out.println(name + "集合名称");
//        }


        //有密码的连接

        ServerAddress serverAddress = new ServerAddress("47.92.168.77", 27012);
        ArrayList<ServerAddress> addrs = new ArrayList<ServerAddress>();
        addrs.add(serverAddress);

        MongoCredential credential = MongoCredential.createScramSha1Credential("backTest900", "backtest_900", "123456".toCharArray());
        ArrayList<MongoCredential> credentials1 = new ArrayList<MongoCredential>();
        credentials1.add(credential);

        //连接认证获取MOngoDB连接
        MongoClient mongoClient = new MongoClient(addrs, credentials1);


        //连接到数据库test
        MongoDatabase mongoDatabase = mongoClient.getDatabase("users");
        System.out.println("成功连接到数据库");
        System.out.println("数据库：" + mongoDatabase.getName());


    }


}

```

