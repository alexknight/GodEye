package com.alex.godeye.models;

import android.content.Context;

import com.alex.godeye.network.RetrofitHelper;
import com.alex.godeye.network.RetrofitService;

import rx.Observable;

public class DataManager {
    private RetrofitService mRetrofitService;

    public DataManager(Context context){
        this.mRetrofitService = RetrofitHelper.getInstance()
                .getRetrofit("http://api.douban.com/v2/").getServer();
    }

    public Observable<Douban> getDoubanInfo(){
        return mRetrofitService.getInTheaters();
    }
}
