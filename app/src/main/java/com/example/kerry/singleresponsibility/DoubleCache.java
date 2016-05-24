package com.example.kerry.singleresponsibility;

import android.graphics.Bitmap;

/**
 * Created by Kerry on 2016/5/24.
 */
public class DoubleCache implements ImageCache{
    ImageCache mMemoryCache = new MemoryCache();
    ImageCache mDiskCache = new DiskCache();

    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if(bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
        mDiskCache.put(url, bmp);
    }
}
