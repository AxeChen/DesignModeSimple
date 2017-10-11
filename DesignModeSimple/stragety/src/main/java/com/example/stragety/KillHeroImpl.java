package com.example.stragety;

/**
 * Created by AxeChen on 2017/10/11.
 */

public class KillHeroImpl implements GetMoneyWay {
    @Override
    public int getMoney(int count) {
        int sum = count * 300;
        // 省略一大堆的逻辑
        return sum;
    }
}
