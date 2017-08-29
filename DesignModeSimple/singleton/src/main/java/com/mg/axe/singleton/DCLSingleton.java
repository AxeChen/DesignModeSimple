package com.mg.axe.singleton;

/**
 * Created by Axe on 2017/8/29.
 * <p>
 * Double Check Lock (双层检查同步模式)
 */

public class DCLSingleton {
    private static DCLSingleton singleton = null;

    private DCLSingleton() {
    }

    public static DCLSingleton getInstance() {
        if (singleton == null) {
            synchronized (DCLSingleton.class) {
                if (singleton == null) {
                    singleton = new DCLSingleton();
                }
            }
        }
        return singleton;
    }
}
