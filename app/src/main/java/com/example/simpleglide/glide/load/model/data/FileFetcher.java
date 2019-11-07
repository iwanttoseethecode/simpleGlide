package com.example.simpleglide.glide.load.model.data;

import android.content.ContentResolver;
import android.net.Uri;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by luoling on 2019/11/4.
 * description:
 */
public class FileFetcher implements DataFetcher<InputStream> {

    private final ContentResolver contentResolver;
    private final Uri uri;

    public FileFetcher(Uri uri, ContentResolver contentResolver) {
        this.contentResolver = contentResolver;
        this.uri = uri;
    }


    @Override
    public void loadData(DataFetcherCallback<? super InputStream> callback) {
        InputStream inputStream = null;
        try {
            inputStream = contentResolver.openInputStream(uri);
            callback.onFetcherReady(inputStream);
        } catch (FileNotFoundException e) {
            callback.onLoadFailed(e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void cancel() {

    }

    @Override
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }
}
