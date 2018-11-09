package com.alex.godeye.presenter.douban;

import android.content.Context;
import android.content.Intent;

import com.alex.godeye.interfaces.IView;
import com.alex.godeye.models.Douban;
import com.alex.godeye.models.DataManager;
import com.alex.godeye.interfaces.Presenter;
import com.alex.godeye.interfaces.IDoubanView;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class DoubanPresenter implements Presenter {

    private DataManager dataManager;
    private CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private IDoubanView mIDoubanView;
    private int index;
    public Douban mDouban;

    public DoubanPresenter (Context mContext){
        this.mContext = mContext;
    }

    @Override
    public void onCreate() {
        dataManager = new DataManager(mContext);
        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void pause() {

    }

    @Override
    public void attachView(IView iView) {
        mIDoubanView = (IDoubanView) iView;
    }

    @Override
    public void attachView(IView iView, int i) {
        mIDoubanView = (IDoubanView) iView;
        index = i;
    }



    @Override
    public void attachIncomingIntent(Intent intent) {

    }

    public void getInTheaters(){
        mCompositeSubscription.add(dataManager.getDoubanInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Douban>(){
                    @Override
                    public void onCompleted() {
                        if (mDouban != null){
                            mIDoubanView.onSuccess(mDouban);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Douban douban) {
                        mDouban = douban;
                    }
                })
        );
    }

    public void reachDetail(){
        mCompositeSubscription.add(dataManager.getDoubanInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Douban>(){
                    @Override
                    public void onCompleted() {
                        if (mDouban != null){
                            mIDoubanView.onSuccess(mDouban, index);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(Douban douban) {
                        mDouban = douban;
                    }
                })
        );
    }

}
