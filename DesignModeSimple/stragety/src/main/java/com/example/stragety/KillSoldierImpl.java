package com.example.stragety;

/**
 * Created by AxeChen on 2017/10/11.
 */

public class KillSoldierImpl implements GetMoneyWay{
    @Override
    public int getMoney(int count) {
        int sum = count * 50;
        // 省略一大堆的逻辑
        return sum;
    }
}
