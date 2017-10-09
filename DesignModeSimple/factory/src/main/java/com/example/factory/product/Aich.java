package com.example.factory.product;

import android.util.Log;

import com.example.factory.abstractProduct.Hero;

/**
 * Created by AxeChen on 2017/10/9.
 */

public class Aich extends Hero {

    @Override
    public void run() {
        Log.i("Hero", name + "边跑边射击");
    }

    @Override
    public void upgrade() {
        Log.i("Hero", name + "升到12级了");
    }

    @Override
    public void combat() {
        Log.i("Hero", name + "和盖伦在战斗");
    }

    @Override
    public void death() {
        Log.i("Hero", name + "死亡了");
    }
}
