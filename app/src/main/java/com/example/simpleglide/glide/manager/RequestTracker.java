package com.example.simpleglide.glide.manager;

import com.example.simpleglide.glide.Utils;
import com.example.simpleglide.glide.request.Request;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * Created by luoling on 2019/10/29.
 * description:
 */
public class RequestTracker {

    private final Set<Request> requests =
            Collections.newSetFromMap(new WeakHashMap<Request, Boolean>());
    private final List<Request> pendingRequests = new ArrayList<>();
    private boolean isPaused;

    /**
     * 执行请求
     */
    public void runRequest(Request request) {
        requests.add(request);
        if (!isPaused) {
            request.begin();
        } else {
            pendingRequests.add(request);
        }
    }


    /**
     * 暂停请求
     */
    public void pauseRequests() {
        isPaused = true;
        for (Request request : Utils.getSnapshot(requests)) {
            if (request.isRunning()) {
                request.pause();
                pendingRequests.add(request);
            }
        }
    }


    /**
     * 继续请求
     */
    public void resumeRequests() {
        isPaused = false;
        for (Request request : Utils.getSnapshot(requests)) {
            if (!request.isComplete() && !request.isCancelled() && !request.isRunning()) {
                request.begin();
            }
        }
        pendingRequests.clear();
    }


    /**
     * 清理请求
     */
    public void clearRequests() {
        for (Request request : Utils.getSnapshot(requests)) {
            if (request == null) {
                return;
            }
            requests.remove(request);
            pendingRequests.remove(request);
            request.clear();
            request.recycle();
        }
        pendingRequests.clear();
    }


}