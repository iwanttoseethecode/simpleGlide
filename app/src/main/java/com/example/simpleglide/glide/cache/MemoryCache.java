package com.example.simpleglide.glide.cache;

import com.example.simpleglide.glide.load.key.Key;
import com.example.simpleglide.glide.recycle.Resource;

/**
 * Created by luoling on 2019/10/10.
 * description:
 */
public interface MemoryCache {

    interface ResourceRemovedListener {
        void onResourceRemoved(Resource resource);
    }


    Resource remove2(Key key);


    Resource put(Key key, Resource resource);


    void setResourceRemovedListener(ResourceRemovedListener listener);

    void clearMemory();

    void trimMemory(int level);
}