package com.example.simpleglide.glide.recycle;

import android.graphics.Bitmap;

/**
 * Created by luoling on 2019/10/10.
 * description:
 */
public interface BitmapPool {


    void put(Bitmap bitmap);

    Bitmap get(int width, int height, Bitmap.Config config);


    void clearMemory();

    void trimMemory(int level);
}
