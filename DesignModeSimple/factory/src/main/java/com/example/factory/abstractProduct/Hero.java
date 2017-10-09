package com.example.factory.abstractProduct;

/**
 * Created by AxeChen on 2017/10/9.
 */

public abstract class Hero {

    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 跑
     */
    public abstract void run();

    /**
     * 升级
     */
    public abstract void upgrade();

    /**
     * 死亡
     */
    public abstract void death();

    /**
     * 使用魔法攻击
     */
    public abstract void combat();
}
