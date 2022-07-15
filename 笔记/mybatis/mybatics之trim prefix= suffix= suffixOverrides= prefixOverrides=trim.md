```
<trim prefix="" suffix="" suffixOverrides="" prefixOverrides=""></trim>
```

prefix:在trim标签内sql语句加上前缀。

suffix:在trim标签内sql语句加上后缀。

suffixOverrides:指定去除多余的后缀内容，如：suffixOverrides=","，去除trim标签内sql语句多余的后缀","。

prefixOverrides:指定去除多余的前缀内容

2.下面是一个往购物车表中插入数据的mybatis语句

```
<insert id="insert" parameterType="com.tortuousroad.groupon.cart.entity.Cart">
        insert into cart
        <trim prefix="(" suffix=")" suffixOverrides=",">
            <if test="id != null">
                id,
            </if>
            <if test="userId != null">
                user_id,
            </if>
            <if test="dealId != null">
                deal_id,
            </if>
            <if test="dealSkuId != null">
                deal_sku_id,
            </if>
            <if test="count != null">
                count,
            </if>
            <if test="createTime != null">
                create_time,
            </if>
            <if test="updateTime != null">
                update_time,
            </if>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
            <if test="id != null">
                #{id,jdbcType=BIGINT},
            </if>
            <if test="userId != null">
                #{userId,jdbcType=BIGINT},
            </if>
            <if test="dealId != null">
                #{dealId,jdbcType=BIGINT},
            </if>
            <if test="dealSkuId != null">
                #{dealSkuId,jdbcType=BIGINT},
            </if>
            <if test="count != null">
                #{count,jdbcType=INTEGER},
            </if>
            <if test="createTime != null">
                #{createTime,jdbcType=TIMESTAMP},
            </if>
            <if test="updateTime != null">
                #{updateTime,jdbcType=TIMESTAMP},
            </if>
        </trim>
    </insert>
```

假设没有指定

```
suffixOverrides=","
```

执行的sql语句也许是这样的：insert into cart (id,user_id,deal_id,) values(1,2,1,);显然是错误的指定之后语句就会变成insert into cart (id,user_id,deal_id) values(1,2,1);这样就将“，”去掉了。

前缀也是一个道理这里就不说了。


