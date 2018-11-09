package com.alex.godeye.interfaces;

import android.content.Intent;

public interface Presenter {

    void onCreate();

    void onStart();

    void onStop();

    void pause();

    void attachView(IView iView);

    void attachView(IView iView, int i);

    void attachIncomingIntent(Intent intent);
}
