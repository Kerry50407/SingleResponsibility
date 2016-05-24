package com.example.kerry.singleresponsibility;

import android.graphics.Bitmap;
import android.util.LruCache;

/**
 * Created by Kerry on 2016/5/24.
 */
public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mMemoryCache;
    public MemoryCache() {

    }
    @Override
    public Bitmap get(String url) {
        if(mMemoryCache != null) {
            return mMemoryCache.get(url);
        }
        return null;
    }

    @Override
    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
    }
}
