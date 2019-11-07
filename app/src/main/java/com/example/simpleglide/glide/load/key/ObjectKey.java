package com.example.simpleglide.glide.load.key;

import android.support.annotation.Nullable;

import java.security.MessageDigest;

/**
 * Created by luoling on 2019/11/4.
 * description:
 */
public class ObjectKey implements Key {


    private final Object object;

    public ObjectKey(Object object) {
        this.object = object;
    }

    @Override
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(object.toString().getBytes());
    }

    @Override
    public byte[] getKeyBytes() {
        return new byte[0];
    }

    @Override
    public boolean equals(Object object1) {
        if (this == object1) {
            return true;
        }
        if (object1 == null || getClass() != object1.getClass()) {
            return false;
        }
        ObjectKey objectKey = (ObjectKey) object1;

        return object != null ? object.equals(objectKey.object) : objectKey.object == null;
    }

    @Override
    public int hashCode() {
        return object != null ? object.hashCode() : 0;
    }
}

