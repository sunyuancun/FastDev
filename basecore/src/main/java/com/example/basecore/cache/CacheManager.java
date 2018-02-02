package com.example.basecore.cache;

/**
 * Created by Administrator on 2018/2/1.
 */

public class CacheManager {

    private static final CacheManager cacheInstance = new CacheManager();
    SPCache mSPCache;

    public static CacheManager getInstance() {
        return cacheInstance;
    }

    private CacheManager() {
        mSPCache = SPCache.getInstance();
    }


    //SP
    public SPCache getSPCache() {
        return mSPCache;
    }

    //SD

    //DB

}
