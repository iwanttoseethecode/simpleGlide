package com.example.simpleglide.glide.request;

/**
 * Created by luoling on 2019/10/10.
 * description:
 */
public class RequestOptions {


    private int errorId;
    private int placeholderId;
    private int overrideHeight = -1;
    private int overrideWidth = -1;


    public RequestOptions placeholder(int resourceId) {
        this.placeholderId = resourceId;
        return this;
    }

    public RequestOptions error(int resourceId) {
        this.errorId = resourceId;

        return this;
    }

    public RequestOptions override(int width, int height) {
        this.overrideWidth = width;
        this.overrideHeight = height;
        return this;
    }


    public final int getErrorId() {
        return errorId;
    }

    public final int getPlaceholderId() {
        return placeholderId;
    }


    public final int getOverrideWidth() {
        return overrideWidth;
    }

    public final int getOverrideHeight() {
        return overrideHeight;
    }

}

