package com.example.kerry.singleresponsibility;

import java.io.Closeable;
import java.io.IOException;

/**
 * Created by Kerry on 2016/5/27.
 */
public final class CloseUtils {
    private CloseUtils() {}

    public static void closeQuietly(Closeable closeable) {
        if(null != closeable) {
            try {
                closeable.close();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
    }
}
