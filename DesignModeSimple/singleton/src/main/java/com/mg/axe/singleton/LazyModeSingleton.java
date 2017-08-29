package com.mg.axe.singleton;

/**
 * Created by Axe on 2017/8/29.
 * 单例模式 - 懒汉模式
 * 相对于懒汉模式{@link HungryModeSingleton}：
 * 1、懒汉模式只有调用的时候才初始化，节省了开支。
 * 2、懒汉模式保证了线程安全
 * 缺点：
 * 每次初始化会进行同步，会消耗不必要的资源
 */

public class LazyModeSingleton {

    private static LazyModeSingleton singleton;

    private LazyModeSingleton() {
    }

    public static synchronized LazyModeSingleton getInstance() {
        if (singleton == null) {
            singleton = new LazyModeSingleton();
        }
        return singleton;
    }

}
