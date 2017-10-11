package com.example.stragety;

/**
 * Created by AxeChen on 2017/10/11.
 */

public class KillMonsterImpl implements GetMoneyWay {
    @Override
    public int getMoney(int count) {
        int sum = count * 100;
        // 省略一大堆的逻辑
        return sum;
    }
}
