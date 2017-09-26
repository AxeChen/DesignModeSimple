package com.mg.axe.builder;

import android.media.ImageReader;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mg.axe.builder.carBuilder.Car;
import com.mg.axe.builder.carBuilder.CarBuilder;
import com.mg.axe.builder.carBuilder.CarDirector;
import com.mg.axe.builder.imageLoaderBuilder.ImageLoader;
import com.mg.axe.builder.imageLoaderBuilder.ImageLoaderConfig;
import com.mg.axe.builder.imageLoaderBuilder.MyDisCache;
import com.mg.axe.builder.imageLoaderBuilder.MyMemoryCache;

/**
 * Created by Axe on 2017/9/26.
 */

public class MyBuilder extends AppCompatActivity {

    private static String TAG = "MyBuilder";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // 最简单的构造
        CarBuilder carBuilder = new CarBuilder();
        CarDirector director = new CarDirector(carBuilder);
        Car car = director.creatCar();
        Log.i(TAG, "车的牌子：" + car.getMake() + "车的类型：" + car.getType() + "车的座位：" + car.getSeat());

        // 仿照Imageloader构造者模式
        ImageLoaderConfig config = new ImageLoaderConfig.Builder()
                // 设置磁盘图片缓存
                .discCache(new MyDisCache())
                // 设置内存图片缓存
                .memoryCache(new MyMemoryCache())
                .create();
        ImageLoader imageLoader = ImageLoader.getInstance();
        imageLoader.init(config);
        Log.i(TAG, imageLoader.toString());

    }
}
