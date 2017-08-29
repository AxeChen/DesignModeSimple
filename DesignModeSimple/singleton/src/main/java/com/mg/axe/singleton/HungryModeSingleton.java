package com.mg.axe.singleton;

/**
 * Created by Axe on 2017/8/29.
 * <p>
 * 单例模式 - 饿汉模式
 *  最简单的单例模式，具有单利模式的所有特征
 *  缺点：
 *  1、当类加载时就会初始化成员变量，可能会浪费资源。
 *  2、在多线程情况下，不安全，无法保证对象唯一。
 */

public class HungryModeSingleton {

    private static final HungryModeSingleton singleton = new HungryModeSingleton();

    private HungryModeSingleton() {
    }

    public static HungryModeSingleton getInstance() {
        return singleton;
    }
}


