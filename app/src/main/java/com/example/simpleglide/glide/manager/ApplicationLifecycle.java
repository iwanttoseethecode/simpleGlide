package com.example.simpleglide.glide.manager;

/**
 * Created by luoling on 2019/10/29.
 * description:
 */
class ApplicationLifecycle implements Lifecycle {
    @Override
    public void addListener(LifecycleListener listener) {
        listener.onStart();
    }

    @Override
    public void removeListener(LifecycleListener listener) {
    }
}