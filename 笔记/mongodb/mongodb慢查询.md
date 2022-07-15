```
{
        "op" : "getmore",
        "ns" : "jqkline_60.CF2107",
        "command" : {
                "getMore" : NumberLong("49498597839233"),
                "collection" : "CF2107",
                "$db" : "jqkline_60",
                "lsid" : {
                        "id" : UUID("1b1eb5b7-cd46-4b4b-8277-8f715765ef7b")
                }
        },
        "originatingCommand" : {
                "find" : "CF2107",
                "filter" : {
                        "timestamp" : {
                        		//条件
                                "$gte" : NumberLong(1594737300),
                                "$lte" : NumberLong(1626243240)
                        }
                },
                "projection" : {
                		//返回数据
                        "askps" : 1,
                        "bidps" : 1,
                        "timestamp" : 1
                },
                "$db" : "jqkline_60",
                "lsid" : {
                        "id" : UUID("1b1eb5b7-cd46-4b4b-8277-8f715765ef7b")
                }
        },
        "cursorid" : NumberLong("49498597839233"),
        //该项表明为了找出最终结果MongoDB搜索了多少个key
        "keysExamined" : 83939,
        //该项表明为了找出最终结果MongoDB搜索了多少个文档
        "docsExamined" : 83939,
        //游标耗尽
        "cursorExhausted" : true,
        //为了让别的操作完成而屈服的次数，一般发生在需要访问的数据尚未被完全读取到内存中，MongoDB会优先完成在内存中的操作
        "numYield" : 655,
        "locks" : {
                "Global" : {
                        "acquireCount" : {
                                "r" : NumberLong(1312)
                        }
                },
                "Database" : {
                        "acquireCount" : {
                                "r" : NumberLong(656)
                        }
                },
                "Collection" : {
                        "acquireCount" : {
                                "r" : NumberLong(656)
                        }
                }
        },
        //返回数据量字节
        "nreturned" : 83939,
        //返回字节量
        "responseLength" : 15265877,
        "protocol" : "op_msg",
        //消耗时间
        "millis" : 168,
        //索引查询
        "planSummary" : "IXSCAN { timestamp: 1 }",
        "execStats" : {
                "stage" : "PROJECTION",
                //返回数据
                "nReturned" : 84040,
                "executionTimeMillisEstimate" : 160,
                "works" : 84041,
                "advanced" : 84040,
                "needTime" : 0,
                "needYield" : 0,
                "saveState" : 656,
                "restoreState" : 656,
                "isEOF" : 1,
                "invalidates" : 0,
                "transformBy" : {
                        "askps" : 1,
                        "bidps" : 1,
                        "timestamp" : 1
                },
                "inputStage" : {
                        "stage" : "FETCH",
                        "nReturned" : 84040,
                        "executionTimeMillisEstimate" : 120,
                        "works" : 84041,
                        "advanced" : 84040,
                        "needTime" : 0,
                        "needYield" : 0,
                        "saveState" : 656,
                        "restoreState" : 656,
                        "isEOF" : 1,
                        "invalidates" : 0,
                        "docsExamined" : 84040,
                        "alreadyHasObj" : 0,
                        "inputStage" : {
                                "stage" : "IXSCAN",
                                "nReturned" : 84040,
                                "executionTimeMillisEstimate" : 30,
                                "works" : 84041,
                                "advanced" : 84040,
                                "needTime" : 0,
                                "needYield" : 0,
                                "saveState" : 656,
                                "restoreState" : 656,
                                "isEOF" : 1,
                                "invalidates" : 0,
                                "keyPattern" : {
                                        "timestamp" : 1
                                },
                                "indexName" : "timestamp_1",
                                "isMultiKey" : false,
                                "multiKeyPaths" : {
                                        "timestamp" : [ ]
                                },
                                "isUnique" : false,
                                "isSparse" : false,
                                "isPartial" : false,
                                "indexVersion" : 2,
                                "direction" : "forward",
                                "indexBounds" : {
                                        "timestamp" : [
                                                "[1594737300, 1626243240]"
                                        ]
                                },
                                "keysExamined" : 84040,
                                "seeks" : 1,
                                "dupsTested" : 0,
                                "dupsDropped" : 0,
                                "seenInvalidated" : 0
                        }
                }
        },
        "ts" : ISODate("2021-09-28T15:48:48.194Z"),
        "client" : "123.152.195.72",
        "allUsers" : [
                {
                        "user" : "Jqkline60",
                        "db" : "jqkline_60"
                }
        ],
        "user" : "Jqkline60@jqkline_60"
}
```

