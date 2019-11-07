package com.example.simpleglide.glide.manager;

import android.app.Fragment;

import com.example.simpleglide.glide.request.RequestManager;

/**
 * Created by luoling on 2019/10/29.
 * description:
 */
public class RequestManagerFragment extends Fragment {
    private final ActivityFragmentLifecycle lifecycle;

    private RequestManager requestManager;

    public RequestManagerFragment() {
        this.lifecycle = new ActivityFragmentLifecycle();
    }


    public void setRequestManager(RequestManager requestManager) {
        this.requestManager = requestManager;
    }

    ActivityFragmentLifecycle getGlideLifecycle() {
        return lifecycle;
    }

    public RequestManager getRequestManager() {
        return requestManager;
    }


    @Override
    public void onStart() {
        super.onStart();
        lifecycle.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        lifecycle.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        lifecycle.onDestroy();
    }

}
