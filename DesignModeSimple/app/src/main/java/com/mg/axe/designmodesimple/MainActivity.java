package com.mg.axe.designmodesimple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.factory.abstractFactory.ReflectFactory;
import com.example.factory.abstractProduct.Hero;
import com.example.factory.factory.AichFactory;
import com.example.factory.factory.GalenFactory;
import com.example.factory.factory.VagabondageFactory;
import com.example.factory.product.Aich;
import com.example.factory.product.Galen;
import com.example.factory.product.Vagabondage;
import com.example.stragety.GetMoney;
import com.example.stragety.GetMoneyCalculater;
import com.example.stragety.KillHeroImpl;
import com.example.stragety.KillMonsterImpl;
import com.example.stragety.KillSoldierImpl;
import com.mg.axe.builder.carBuilder.Car;
import com.mg.axe.builder.carBuilder.CarBuilder;
import com.mg.axe.builder.carBuilder.CarDirector;
import com.mg.axe.builder.imageLoaderBuilder.ImageLoader;
import com.mg.axe.builder.imageLoaderBuilder.ImageLoaderConfig;
import com.mg.axe.builder.imageLoaderBuilder.MyDisCache;
import com.mg.axe.builder.imageLoaderBuilder.MyMemoryCache;
import com.mg.axe.prototype.ArticleBean;
import com.mg.axe.singleton.DCLSingleton;
import com.mg.axe.singleton.HungryModeSingleton;
import com.mg.axe.singleton.LazyModeSingleton;
import com.mg.axe.singleton.StaticInnerClassSingleton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**-------单例模式-------**/
        singleton();

        /**-------构造者模式-------**/
        builder();

        /**-------原型模式-------**/
        prototype();

        /**-------工厂模式-------**/
        factory();

        /**-------策略模式-------**/
        //模拟英雄联盟获取金币的方式。1、杀死10个小兵 2、杀死5个野怪 3、杀死3个英雄
        // 没有使用策略模式
        int sum = 0;
        GetMoney getMoney = new GetMoney();
        sum = getMoney.killSoldier(10) + getMoney.killMonster(5) + getMoney.killHero(3);
        Log.i("Stragety", sum + "");

        // 使用策略模式后
        sum = 0;
        GetMoneyCalculater calculater = new GetMoneyCalculater();
        calculater.setGetMoneyWay(new KillSoldierImpl());
        sum += calculater.calculaterMoney(10);
        calculater.setGetMoneyWay(new KillMonsterImpl());
        sum += calculater.calculaterMoney(5);
        calculater.setGetMoneyWay(new KillHeroImpl());
        sum += calculater.calculaterMoney(3);
        Log.i("Stragety", sum + "");
    }

    private void singleton() {
        // 饿汉模式（不推荐）
        HungryModeSingleton.getInstance();
        // 懒汉模式（不推荐）
        LazyModeSingleton.getInstance();
        // 双重检查模式 （推荐）\
        DCLSingleton.getInstance();
        // 静态内部类模式 （推荐）
        StaticInnerClassSingleton.getInstance();
        // 枚举模式 （很少见，一般不用）
    }

    private void builder() {
        // 最简单的构造
        CarBuilder carBuilder = new CarBuilder();
        CarDirector director = new CarDirector(carBuilder);
        Car car = director.creatCar();
        Log.i("builder", "车的牌子：" + car.getMake() + "车的类型：" + car.getType() + "车的座位：" + car.getSeat());

        // 仿照Imageloader构造者模式
        ImageLoaderConfig config = new ImageLoaderConfig.Builder()
                // 设置磁盘图片缓存
                .discCache(new MyDisCache())
                // 设置内存图片缓存
                .memoryCache(new MyMemoryCache())
                .create();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        Log.i("builder", imageLoader.toString());
    }

    private void prototype() {
        // 初始化原先的代码
        ArticleBean articleBean = new ArticleBean();
        ArrayList<String> images = new ArrayList<>();
        images.add("one");
        images.add("two");
        images.add("three");
        articleBean.setImages(images);
        articleBean.setText("这是原来的内容");
        articleBean.setTitle("这是原来的标题");
        Log.i("prototype", "-----------------1、没有克隆前的原始对象------------");
        Log.i("prototype", "原始对象" + articleBean.toString());

        // 克隆新的代码
        ArticleBean cloneArthurBean = articleBean.clone();
        Log.i("prototype", "-----------------2、克隆后原始对象和克隆对象（未修改）做对比------------");
        Log.i("prototype", "原始对象(克隆后)" + articleBean.toString());
        Log.i("prototype", "克隆对象(克隆后未修改)" + cloneArthurBean.toString());

        cloneArthurBean.setText("这是修改后的内容");
        cloneArthurBean.setTitle("这是修改后的标题");
        ArrayList<String> imgs = new ArrayList<>();
        imgs.add("苍井空.jpg");
        imgs.add("泷泽萝拉.jpg");
        imgs.add("小泽玛利亚.jpg");
        cloneArthurBean.setImages(imgs);

        Log.i("prototype", "-----------------2、克隆后原始对象和克隆对象（已经修改）做对比------------");
        Log.i("prototype", "原始对象(克隆后)" + articleBean.toString());
        Log.i("prototype", "克隆对象(克隆后并修改)" + cloneArthurBean.toString());
    }

    private void factory() {
        AichFactory aichFactory = new AichFactory();
        Hero aich = aichFactory.createHero();
        aich.setName("艾希");
        aich.run();
        aich.combat();
        aich.upgrade();
        aich.death();

        GalenFactory galenFactory = new GalenFactory();
        Hero galen = galenFactory.createHero();
        galen.setName("盖伦");
        galen.run();
        galen.combat();
        galen.upgrade();
        galen.death();

        VagabondageFactory vagabondageFactory = new VagabondageFactory();
        Hero vagabondage = vagabondageFactory.createHero();
        vagabondage.setName("盖伦");
        vagabondage.run();
        vagabondage.combat();
        vagabondage.upgrade();
        vagabondage.death();

        // 使用反射的工场
        Hero galen1 = ReflectFactory.createHero(Galen.class);
        Hero aich1 = ReflectFactory.createHero(Aich.class);
        Hero vagabondage1 = ReflectFactory.createHero(Vagabondage.class);
    }
}
