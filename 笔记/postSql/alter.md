# PostgreSQL 修改字段的数据类型

> **提要**：在本教程中，我们将向您展示如何使用PostgreSQL ALTER TABLE语句修改字段的数据类型。

### 语法

```
ALTER TABLE table_name
ALTER COLUMN column_name [SET DATA] TYPE new_data_type;
```

要同时修改多个字段的数据类型：

```
ALTER TABLE table_name
ALTER COLUMN column_name_1 [SET DATA] TYPE new_data_type,
ALTER COLUMN column_name_2 [SET DATA] TYPE new_data_type,
...;
```

PostgreSQL 允许在修改字段数据类型的同时，将字段的值转换为新的数据类型：

```
ALTER TABLE table_name
ALTER COLUMN column_name TYPE new_data_type USING expression;
```

`USING` 用于将旧的值转换为新数据类型的值。

### 示例

创建新表，及插入一些数据作演示：

```
CREATE TABLE assets (
    id serial PRIMARY KEY,
    name TEXT NOT NULL,
    asset_no VARCHAR NOT NULL,
    description TEXT,
    LOCATION TEXT,
    acquired_date DATE NOT NULL
);

INSERT INTO assets (
    name,
    asset_no,
    location,
    acquired_date
)
VALUES
    (
        'Server',
        '10001',
        'Server room',
        '2017-01-01'
    ),
    (
        'UPS',
        '10002',
        'Server room',
        '2018-01-11'
        )
```

将 `name` 字段的数据类型修改为 `VARCHAR`：

```
ALTER TABLE assets ALTER COLUMN name TYPE VARCHAR;
```

同时将 `location` 和 `description` 字段的数据类型修改为 `VARCHAR`：

```
ALTER TABLE assets 
    ALTER COLUMN location TYPE VARCHAR,
    ALTER COLUMN description TYPE VARCHAR;
```

尝试将 `asset_no` 的数据类型修改为 `INT`：

```
ALTER TABLE assets ALTER COLUMN asset_no TYPE INT;
```

PostgreSQL 将会抛出一个错误：

```
ERROR:  column "asset_no" cannot be cast automatically to type integer
HINT:  You might need to specify "USING asset_no::integer".
```

加上 `USING` 试试：

```
ALTER TABLE assets
    ALTER COLUMN asset_no TYPE INT USING asset_no::integer;
```





https://pg.sjk66.com/index.html  postgreSQL 轻松学