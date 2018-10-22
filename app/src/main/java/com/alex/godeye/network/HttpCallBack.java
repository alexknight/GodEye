package com.alex.godeye.network;

import java.util.List;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/21 下午10:45
 */


public interface HttpCallBack<T> {
    public void onResponse(T t);
}
