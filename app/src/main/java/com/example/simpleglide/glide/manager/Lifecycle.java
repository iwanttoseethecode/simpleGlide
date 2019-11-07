package com.example.simpleglide.glide.manager;

/**
 * Created by luoling on 2019/10/29.
 * description:
 */
public interface Lifecycle {

    void addListener(LifecycleListener listener);

    void removeListener(LifecycleListener listener);
}

