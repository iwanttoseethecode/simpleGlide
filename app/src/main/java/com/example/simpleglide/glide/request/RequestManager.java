package com.example.simpleglide.glide.request;

import android.content.Context;

import com.example.simpleglide.glide.manager.Lifecycle;
import com.example.simpleglide.glide.manager.LifecycleListener;
import com.example.simpleglide.glide.manager.RequestTracker;

import java.io.File;

/**
 * Created by luoling on 2019/10/29.
 * description:
 */
public class RequestManager implements LifecycleListener, ModelTypes<RequestBuilder> {

    protected final Context context;
    final Lifecycle lifecycle;
    private final RequestTracker requestTracker;

    public RequestManager(Lifecycle lifecycle, Context context) {
        this.lifecycle = lifecycle;
        this.requestTracker = new RequestTracker();
        this.context = context;
        lifecycle.addListener(this);
    }


    @Override
    public void onStart() {
        requestTracker.resumeRequests();
    }

    @Override
    public void onStop() {
        requestTracker.pauseRequests();
    }

    @Override
    public void onDestroy() {
        requestTracker.clearRequests();
        lifecycle.removeListener(this);
    }


    public RequestBuilder asBitmap() {
        return new RequestBuilder(this, context);
    }


    void track(Request request) {
        requestTracker.runRequest(request);
    }


    @Override
    public RequestBuilder load(String string) {
        return asBitmap().load(string);
    }

    @Override
    public RequestBuilder load(File file) {
        return asBitmap().load(file);
    }

}