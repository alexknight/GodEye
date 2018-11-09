package com.alex.godeye.presenter.douban;

import com.alex.godeye.ui.douban.view.IDoubanView;
import com.alex.godeye.presenter.Presenter;
import com.alex.godeye.models.DataManager;
import com.alex.godeye.models.Douban;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

public class DoubanPresenter implements Presenter {

    private DataManager dataManager;
    private CompositeSubscription mCompositeSubscription;
    private IDoubanView mIDoubanView;
    private int index;
    public Douban mDouban;

    public DoubanPresenter (IDoubanView view){
        this.mIDoubanView = view;
        dataManager = new DataManager();
        mCompositeSubscription = new CompositeSubscription();
    }


    @Override
    public void onStop() {
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }


    public void updateInTheaters(){
        mCompositeSubscription.add(dataManager.getDoubanInfo()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Douban>(){
                    @Override
                    public void onCompleted() {
                        if (mDouban != null){
                            mIDoubanView.updateInTheaters(mDouban);
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
                            mIDoubanView.enterDetail(mDouban, index);
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
