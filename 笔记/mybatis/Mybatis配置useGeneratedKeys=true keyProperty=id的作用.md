### Mybatis配置useGeneratedKeys="true" keyProperty="id"的作用

有时候在开发中需要向表中插入自增ID，这个时候领域模型如果想要获取该ID的值，就需要在相应的mapper文件中添加useGeneratedKeys="true" keyProperty="id"。



# MyBatis如何获取插入记录的自增长字段值:

第一步：

  在Mybatis Mapper文件中添加属性“useGeneratedKeys”和“keyProperty”，其中keyProperty是Java对象的属性名！

```
<insert id="insert" parameterType="Spares" 
        useGeneratedKeys="true" keyProperty="id">
        insert into spares(spares_id,spares_name,
            spares_type_id,spares_spec)
        values(#{id},#{name},#{typeId},#{spec})
    </insert>
```

第二步：

Mybatis执行完插入语句后，自动将自增长值赋值给对象Spares的属性id。因此，可通过Spares对应的getter方法获取！

```
/**
     * 新增备件
     * @author hellostory
     * @param spares
     * @return
     */
    @RequestMapping(value = "/insert")
    @ResponseBody
    public JsonResponse insert(Spares spares) {
        int count = sparesService.insert(spares);      //count>0 表示成功
        System.out.println( "刚刚插入记录的主键自增长值为：" + spares.getId());
```

 **如果没有useGeneratedKeys="true"和keyProperty="id",下面 insert 之后的 user.getId() 是无法获取 id 值的public void insert(User user) {   int count = userMapper.insert(user);   System.out.println("共插入" + count + "条记录！" + "\n刚刚插入记录的主键自增长值为：" + user.getId()); }**