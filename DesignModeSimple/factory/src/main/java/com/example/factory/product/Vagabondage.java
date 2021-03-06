package com.example.factory.product;

import android.util.Log;

import com.example.factory.abstractProduct.Hero;

/**
 * Created by AxeChen on 2017/10/9.
 */

public class Vagabondage extends Hero {

    @Override
    public void run() {
        Log.i("Hero", name + "用魔法在跑");
    }

    @Override
    public void upgrade() {
        Log.i("Hero", name + "升级了");
    }

    @Override
    public void combat() {
        Log.i("Hero", name + "用魔法在战斗");
    }

    @Override
    public void death() {
        Log.i("Hero", name + "死亡了");
    }
}
