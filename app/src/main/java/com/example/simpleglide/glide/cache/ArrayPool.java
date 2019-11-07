package com.example.simpleglide.glide.cache;

/**
 * Created by luoling on 2019/10/10.
 * description:
 */
public interface ArrayPool {

    byte[] get(int len);

    void put(byte[] data);


    void clearMemory();

    void trimMemory(int level);

    int getMaxSize();
}
