package com.alex.godeye.network;

import android.util.Log;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/21 下午10:25
 */


public class HttpUtils {

    private static volatile HttpUtils mHttpUtils;

    private HttpUtils (){
    }

    public static HttpUtils getInstance() {
        if (mHttpUtils == null) {
            synchronized (HttpUtils.class) {
                if (mHttpUtils == null) {
                    mHttpUtils = new HttpUtils();
                }
            }
        }
        return mHttpUtils;
    }


    public void sendRequestByOkHttp(String url, final HttpCallBack callback) {

        OkHttpClient client = new OkHttpClient.Builder().readTimeout(5, TimeUnit.SECONDS).build();
        //创建Request对象，并传入请求地址
        Request request = new Request.Builder().url(url).build();
        //构造Call对象--其实是AsyncCall对象
        Call call = client.newCall(request);
        //调用Call.enqueue方法进行异步请求
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                //网络请求失败
                Log.d("lenve", "onFailure: " + e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                callback.onResponse(response.body().string());
            }
        });
    }

}
