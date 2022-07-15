流程图

时序图

用例图

状态图



```
    /**
     * @author tfc
     * @description 得到K线数是12，波动率是3的信号
     **/
    @Override
    public Pf107_cs2107 getSignal() {
        //创建业务类对象
        Pf107_cs2107KlineVO pf107_cs2107KlineVO = new Pf107_cs2107KlineVO();
        //创建显示层对象
        KlineVO klineVO = new KlineVO();
        //创建显示层的List
        List<KlineVO> klineVOList = new ArrayList<>();


        Pf107_cs2107 Pf107_cs2107Signal = backTestDao.getSignal();
        List<Signal> signal = Pf107_cs2107Signal.getSignal();

        log.info(signal + "看看信号里面的内容");
        //相邻元素去重
        Signal signal1 = signal.get(0);
        Integer s = signal1.getS();

        //先得到PF107的时间戳顺序
        //jqkline_900中的时间戳的类型是int32，期货对中的时间戳的数据类型是int64
        Long startTimes = 1602465300L;
        Long endTimes = 1626181200L;
        List<Pf107> FuturesTimes = jqklineDao.getFuturesTimes(startTimes, endTimes);
        log.info(FuturesTimes + "里面的结构");

        Integer TheFirstSignal = signal.get(0).getS();

        //1).循环期货PF107的时间戳，如果和期货对的时间戳一致，就操作期货。
        for (int i = 0; i < FuturesTimes.size(); i++) {
            //期货pf107的数据
            Pf107 pf107 = FuturesTimes.get(i);

            //2).循环期货对的时间戳。
            for (int j = 0; j < signal.size(); j++) {
                //创建信号的对象
                Signal signals = signal.get(i);


                //判断第一个信号
//                if (pf107.getTimestamp().longValue() == TheFirstSignal && signal.get(0).getT() == 1) {
//                    //-------------------------------------------------------------------------------------------------
//                    pf107_cs2107KlineVO.OperPf(pf107_cs2107KlineVO,22.11,222.11,signal.get(0).getT().);
//                } else {
//
//                }


                //3).如果信号的时间戳和期货的时间戳一致，则期货进行操作。
                if (signals.getT() == pf107.getTimestamp().longValue()) {


                    //4).如果第一个信号为1(j == 0 AND signals.getT == 1)
                    if (j == 0) {
                        //做多PF107，做空Cs2107
                    }

                    //4).如果第一个信号为-1(j == 0 AND signals.getT == 1)
                    if (j == 0) {
                        //做多Cs2107，做空Pf107
                    }
                }


            }

            //
            // PF_Fund=PF_Margin+(PF_Ask+PF_Bid)/2*PF_Space+ PF_Money


        }

//        //转化成一个信号List同时去重
//        List<Integer> signalList = new ArrayList<>();
//
//        for (int i = 0; i < signal.size(); i++) {
//            if (signal.get(i).getS() == signal.get(i + 1).getS()) {
//
//            }
//        }


        return Pf107_cs2107Signal;
    }
```