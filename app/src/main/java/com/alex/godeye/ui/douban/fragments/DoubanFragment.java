package com.alex.godeye.ui.douban.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alex.godeye.R;
import com.alex.godeye.presenter.douban.DoubanPresenter;
import com.alex.godeye.ui.douban.view.DetailView;
import com.alex.godeye.ui.douban.view.HomeView;


/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/17 下午4:04
 */



public class DoubanFragment extends Fragment {

    private ListView listView;

    private DoubanPresenter mDoubanPresenter = new DoubanPresenter(this.getActivity());

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);
        listView = view.findViewById(R.id.card_listview);
        mDoubanPresenter.onCreate();
        mDoubanPresenter.getInTheaters();
        mDoubanPresenter.attachView(new HomeView(getActivity(), listView));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mDoubanPresenter.attachView(new DetailView(getActivity()), i);
                mDoubanPresenter.reachDetail();
            }
        });
        return view;
    }

}