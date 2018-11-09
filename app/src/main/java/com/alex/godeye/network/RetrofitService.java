package com.alex.godeye.network;

import com.alex.godeye.models.Douban;

import retrofit2.http.GET;
import rx.Observable;

public interface RetrofitService {
    @GET("movie/in_theaters")
    Observable<Douban> getInTheaters();
}