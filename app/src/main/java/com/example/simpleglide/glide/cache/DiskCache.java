package com.example.simpleglide.glide.cache;

import com.example.simpleglide.glide.load.key.Key;

import java.io.File;

/**
 * Created by luoling on 2019/10/10.
 * description:
 */
public interface DiskCache {

    interface Writer{
        boolean write(File file);
    }

    File get(Key key);

    void put(Key key,Writer writer);

    void delete(Key key);

    void clear();

}
