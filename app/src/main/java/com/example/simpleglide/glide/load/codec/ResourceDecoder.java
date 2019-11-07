package com.example.simpleglide.glide.load.codec;

import android.graphics.Bitmap;

import java.io.IOException;

/**
 * Created by luoling on 2019/11/4.
 * description:
 */
public interface ResourceDecoder<T> {
    boolean handles(T source) throws IOException;
    Bitmap decode(T source,int width,int height) throws IOException;
}
