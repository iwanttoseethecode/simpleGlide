package com.example.simpleglide.glide.request;

import java.io.File;

/**
 * Created by luoling on 2019/10/30.
 * description:
 */
public interface ModelTypes<T> {

    T load(String string);

    T load(File file);

}
