package com.example.kerry.singleresponsibility;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.jakewharton.disklrucache.DiskLruCache;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Kerry on 2016/5/24.
 */
public class DiskCache implements ImageCache{
    static String cacheDir = "sdcard/cache/";
    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    public void put(String url, Bitmap bmp) {
        DiskLruCache.Editor editor = null;
        if(editor != null) {
            try {
                OutputStream outputStream = editor.newOutputStream(0);
                editor.commit();
                CloseUtils.closeQuietly(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
