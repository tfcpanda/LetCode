logger：日志记录器，用来存放日志对象，定义日志类型和等级

appender:日志输出的目的地，

layout：格式化日志信息的输出







```
//平多仓
if (futureOrderRecord.getDirection().equals(Constant.FSHORT)) {
    double profit = (futureOrderRecord.getPrice() - futureAsset.getFutureOpenAvgPrice()) * futureOrderRecord.getVolume() * FutureLot.getByName(futureOrderRecord.getInstrumentId());
    futureOrder.setFutureProfit(BigDecimal.valueOf(profit));
}
//平空仓
if (futureOrderRecord.getDirection().equals(Constant.FLONG)) {
    double profit = (futureOrderRecord.getPrice() - futureAsset.getFutureOpenAvgPrice()) * -1 * futureOrderRecord.getVolume() * FutureLot.getByName(futureOrderRecord.getInstrumentId());
    futureOrder.setFutureProfit(BigDecimal.valueOf(profit));
}
```

```
        //记录被平完的OrderID
        List<Long> closePositionID = new ArrayList();
        
                    //把被平完的ID记住。
        
                    closePositionID.add(futureOrderList.get(i).getId());
                    
                    
                    
        for (int i = 0; i < closePositionID.size(); i++) {
            for (int j = 0; j < futureOrderList.size(); j++) {
                if (closePositionID.get(i).equals(futureOrderList.get(j).getId())) {
                    futureOrderList.remove(j);
                }
            }
        }


```