package com.alex.godeye.ui.douban.view;

import com.alex.godeye.models.Douban;

public interface IDoubanView extends IView {
    void updateInTheaters(Douban mDouban);
    void enterDetail(Douban mDouban, int index);
    void onError(String result);
}
