package com.javarush.task.task37.task3708.retrievers;

import com.javarush.task.task37.task3708.cache.LRUCache;
import com.javarush.task.task37.task3708.storage.Storage;

/**
 * Created by Miha on 16.05.2017.
 */
public class CachingProxyRetriever implements Retriever{

    private Storage storage;
    private LRUCache cache;
    private OriginalRetriever retriever;

    public CachingProxyRetriever(Storage storage) {
        this.storage = storage;
        this.retriever = new OriginalRetriever(storage);
        cache = new LRUCache<>(16);
    }

    @Override
    public Object retrieve(long id) {

        Object object = cache.find(id);

        if (object == null) {
            object = retriever.retrieve(id);
            cache.set(id, object);
        }

        return object;
    }
}
