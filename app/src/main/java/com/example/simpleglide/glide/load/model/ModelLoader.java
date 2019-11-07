package com.example.simpleglide.glide.load.model;

import com.example.simpleglide.glide.load.key.Key;
import com.example.simpleglide.glide.load.model.data.DataFetcher;

/**
 * Created by luoling on 2019/11/4.
 * description:
 */
public interface ModelLoader<Model, Data> {

    interface ModelLoaderFactory<Model, Data> {
        ModelLoader<Model, Data> build(ModelLoaderRegistry modelLoaderRegistry);
    }

    class LoadData<Data> {
        public final Key sourceKey;
        public final DataFetcher<Data> fetcher;

        public LoadData(Key sourceKey, DataFetcher<Data> fetcher) {
            this.sourceKey = sourceKey;
            this.fetcher = fetcher;
        }

    }

    LoadData<Data> buildLoadData(Model model);

    boolean handles(Model model);
}
