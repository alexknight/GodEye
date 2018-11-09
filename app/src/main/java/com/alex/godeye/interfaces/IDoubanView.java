package com.alex.godeye.interfaces;

import com.alex.godeye.models.Douban;

public interface IDoubanView extends IView {
    void onSuccess(Douban mDouban);
    void onSuccess(Douban mDouban, int index);
    void onError(String result);
}
