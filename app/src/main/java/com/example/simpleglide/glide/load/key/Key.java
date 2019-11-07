package com.example.simpleglide.glide.load.key;

import java.security.MessageDigest;

/**
 * Created by luoling on 2019/11/4.
 * description:
 */
public interface Key {

    void updateDiskCacheKey(MessageDigest messageDigest);

    byte[] getKeyBytes();

}