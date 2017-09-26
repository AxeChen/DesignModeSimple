package com.mg.axe.builder.imageLoaderBuilder;

import android.graphics.Bitmap;

/**
 * Created by Axe on 2017/9/26.
 */

public interface DiskCache {
    public Bitmap getBitmap(String url);
}
