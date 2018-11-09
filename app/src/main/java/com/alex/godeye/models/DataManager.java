package com.alex.godeye.models;

import com.alex.godeye.network.RetrofitHelper;
import com.alex.godeye.network.RetrofitService;

import rx.Observable;

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(){
        this.mRetrofitService = RetrofitHelper.getInstance()
                .getRetrofit("http://api.douban.com/v2/").getServer();
    }

    public Observable<Douban> getDoubanInfo(){
        return mRetrofitService.getInTheaters();
    }
}
