package com.mg.axe.builder.imageLoaderBuilder;

/**
 * Created by Axe on 2017/9/26.
 */

public class ImageLoaderConfig {

    public boolean useMemoryCache = false;

    public boolean useDiskCache = false;

    public MemoryCache memoryCache;

    public DiskCache diskCache;

    public static class Builder {

        private MemoryCache memoryCache;

        private DiskCache diskCache;

        public Builder memoryCache(MemoryCache memoryCache) {
            this.memoryCache = memoryCache;
            return this;
        }

        public Builder discCache(DiskCache diskCache) {
            this.diskCache = diskCache;
            return this;
        }

        private void applyConfig(ImageLoaderConfig config) {
            if (memoryCache != null) {
                config.memoryCache = this.memoryCache;
                config.useMemoryCache = true;
            }
            if (diskCache != null) {
                config.diskCache = this.diskCache;
                config.useDiskCache = true;
            }
        }

        public ImageLoaderConfig create() {
            ImageLoaderConfig config = new ImageLoaderConfig();
            applyConfig(config);
            return config;
        }

    }
}
