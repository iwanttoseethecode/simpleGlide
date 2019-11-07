package com.example.simpleglide.glide.load.generator;

import com.example.simpleglide.glide.load.key.Key;

/**
 * Created by luoling on 2019/11/5.
 * description:
 */
public interface DataGenerator {
    interface DataGeneratorCallback {

        enum DataSource {
            REMOTE,
            CACHE
        }

        void onDataReady(Key sourceKey, Object data, DataSource dataSource);

        void onDataFetcherFailed(Key sourceKey, Exception e);
    }

    boolean startNext();

    void cancel();
}