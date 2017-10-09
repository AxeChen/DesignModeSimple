package com.example.factory.abstractFactory;

import com.example.factory.abstractProduct.Hero;

/**
 * Created by AxeChen on 2017/10/9.
 */

public class ReflectFactory {
    public static <T extends Hero> T createHero(Class<T> clz) {
        Hero hero = null;
        try {
            hero = (Hero) Class.forName(clz.getName()).newInstance();
        } catch (Exception e) {
        }
        return (T) hero;
    }
}
