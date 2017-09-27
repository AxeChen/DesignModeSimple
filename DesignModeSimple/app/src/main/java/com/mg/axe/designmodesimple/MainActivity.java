package com.mg.axe.designmodesimple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.mg.axe.builder.MyBuilder;
import com.mg.axe.builder.carBuilder.Car;
import com.mg.axe.builder.carBuilder.CarBuilder;
import com.mg.axe.builder.carBuilder.CarDirector;
import com.mg.axe.builder.imageLoaderBuilder.ImageLoader;
import com.mg.axe.builder.imageLoaderBuilder.ImageLoaderConfig;
import com.mg.axe.builder.imageLoaderBuilder.MyDisCache;
import com.mg.axe.builder.imageLoaderBuilder.MyMemoryCache;
import com.mg.axe.prototype.ArticleBean;
import com.mg.axe.singleton.DCLSingleton;
import com.mg.axe.singleton.EnumSingleton;
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
}
