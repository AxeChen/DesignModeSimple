package com.example.stragety;

/**
 * Created by AxeChen on 2017/10/11.
 * 模拟英雄联盟的获取金币的几种方式
 */

public class GetMoney {

    /**
     * 一个小兵50个金币
     * @param count
     * @return
     */
    public int killSoldier(int count) {
        int sum = count * 50;
        // 省略一大堆的逻辑
        return sum;
    }
    /**
     * 一个英雄300个金币
     * @param count
     * @return
     */
    public int killHero(int count) {
        int sum = count * 300;
        // 省略一大堆的逻辑
        return sum;
    }

    /**
     * 一个野怪100块
     * @param count
     * @return
     */
    public int killMonster(int count) {
        int sum = count * 100;
        // 省略一大堆的逻辑
        return sum;
    }

}
