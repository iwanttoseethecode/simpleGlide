package com.example.simpleglide.glide;

import com.example.simpleglide.glide.load.LoadPath;
import com.example.simpleglide.glide.load.codec.ResourceDecoder;
import com.example.simpleglide.glide.load.codec.ResourceDecoderRegistry;
import com.example.simpleglide.glide.load.key.Key;
import com.example.simpleglide.glide.load.model.ModelLoader;
import com.example.simpleglide.glide.load.model.ModelLoaderRegistry;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by luoling on 2019/10/10.
 * description:
 */
public class Registry {

    private final ModelLoaderRegistry modelLoaderRegistry = new ModelLoaderRegistry();
    private final ResourceDecoderRegistry resourceDecoderRegistry = new ResourceDecoderRegistry();


    /**
     * 添加模型加载器
     *
     * @param source  输入类型
     * @param data    输出类型
     * @param factory 加载器工程
     * @param <Model> 输入类型
     * @param <Data>  输出类型
     */
    public <Model, Data> Registry add(Class<Model> source, Class<Data> data, ModelLoader
            .ModelLoaderFactory<Model, Data> factory) {
        modelLoaderRegistry.add(source, data, factory);
        return this;
    }

    /**
     * 获得对应model类型的所有modelloader
     *
     * @param model
     * @param <Model>
     * @return
     */
    public <Model> List<ModelLoader<Model, ?>> getModelLoaders(Model model) {
        Class<Model> modelClass = (Class<Model>) model.getClass();
        List<ModelLoader<Model, ?>> modelLoaders = modelLoaderRegistry.getModelLoaders
                (modelClass);
        return modelLoaders;
    }

    public List<ModelLoader.LoadData<?>> getLoadDatas(Object model) {
        List<ModelLoader.LoadData<?>> loadData = new ArrayList<>();
        List<ModelLoader<Object, ?>> modelLoaders = getModelLoaders(model);
        for (ModelLoader<Object, ?> modelLoader : modelLoaders) {
            //获得LoadData
            ModelLoader.LoadData<?> current =
                    modelLoader.buildLoadData(model);
            if (current != null) {
                loadData.add(current);
            }
        }
        return loadData;
    }


    public List<Key> getKeys(Object model) {
        List<Key> keys = new ArrayList<>();
        List<ModelLoader.LoadData<?>> loadDatas = getLoadDatas(model);
        for (ModelLoader.LoadData<?> loadData : loadDatas) {
            keys.add(loadData.sourceKey);
        }
        return keys;
    }


    public <T> void register(Class<T> dataClass, ResourceDecoder<T> decoder) {
        resourceDecoderRegistry.add(dataClass, decoder);
    }

    public boolean hasLoadPath(Class<?> dataClass) {
        return getLoadPath(dataClass) != null;
    }

    public <Data> LoadPath<Data> getLoadPath(Class<Data> dataClass) {
        List<ResourceDecoder<Data>> decoders = resourceDecoderRegistry.getDecoders(dataClass);
        return new LoadPath<>(dataClass, decoders);
    }
}
