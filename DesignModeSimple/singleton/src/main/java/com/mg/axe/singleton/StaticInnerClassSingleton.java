package com.mg.axe.singleton;

/**
 * Created by Axe on 2017/8/29.
 * <p>
 * 静态内部类单例模式
 */

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {
    }

    public static StaticInnerClassSingleton getInstance() {
        return SingletonHolder.singleton;
    }

    private static class SingletonHolder {
        private static final StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

}
