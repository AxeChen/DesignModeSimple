package com.mg.axe.builder.imageLoaderBuilder;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Created by Axe on 2017/9/26.
 */

public class ImageLoader {

    private final String TAG = "ImageLoader";

    private static ImageLoader imageLoader;

    // 单例模式初始化
    private ImageLoader() {
    }

    public static ImageLoader getInstance() {
        if (imageLoader == null) {
            synchronized (ImageLoader.class) {
                if (imageLoader == null) {
                    imageLoader = new ImageLoader();
                }
            }
        }
        return imageLoader;
    }

    private ImageLoaderConfig config;

    public void init(ImageLoaderConfig config) {
        this.config = config;
    }

    public void displayImage(String url, ImageView imageView) {
        Bitmap bitmap = null;
        // 检查内存是否有该图片
        if (config.useMemoryCache) {
            bitmap = config.memoryCache.getBitmap(url);
        }
        if (bitmap == null) {
            // 检查磁盘中是否有该图片
            if (config.useDiskCache) {
                bitmap = config.diskCache.getBitmap(url);
                if (bitmap == null) {
                    bitmap = loadImage(url);
                }
            }
        }
        if (bitmap != null) {
            // 设置图片
            imageView.setImageBitmap(bitmap);
        }
    }

    public Bitmap loadImage(String url) {
        // 网络请求图片代码
        return null;
    }

    @Override
    public String toString() {
        return "磁盘缓存：" + config.diskCache.getClass().getName() + "  内存缓存" + config.memoryCache.getClass().getName();
    }
}
