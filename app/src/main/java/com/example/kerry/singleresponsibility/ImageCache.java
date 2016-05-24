package com.example.kerry.singleresponsibility;

import android.graphics.Bitmap;

/**
 * Created by Kerry on 2016/5/24.
 */
public interface ImageCache {
    Bitmap get(String url);
    void put(String url, Bitmap bmp);
}
