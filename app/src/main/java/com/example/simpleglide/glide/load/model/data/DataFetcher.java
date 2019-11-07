package com.example.simpleglide.glide.load.model.data;

/**
 * Created by luoling on 2019/11/4.
 * description:
 */
public interface DataFetcher<T> {


    interface DataFetcherCallback<T> {


        void onFetcherReady(T data);


        void onLoadFailed(Exception e);
    }

    void loadData(DataFetcherCallback<? super T> callback);

    void cancel();

    Class<T> getDataClass();

}
