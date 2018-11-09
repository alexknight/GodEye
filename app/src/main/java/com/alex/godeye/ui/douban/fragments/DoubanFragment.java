package com.alex.godeye.ui.douban.fragments;

import android.content.Intent;
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
import com.alex.godeye.adapters.douban.DoubanItemAdapter;
import com.alex.godeye.ui.douban.view.IDoubanView;
import com.alex.godeye.models.Douban;
import com.alex.godeye.presenter.douban.DoubanPresenter;
import com.alex.godeye.ui.WebActivity;


/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/17 下午4:04
 */



public class DoubanFragment extends Fragment implements IDoubanView {

    private ListView listView;

    private DoubanItemAdapter mAdapter;

    private DoubanPresenter mDoubanPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);
        listView = view.findViewById(R.id.card_listview);
        mDoubanPresenter = new DoubanPresenter(this);
        mDoubanPresenter.updateInTheaters();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mDoubanPresenter.reachDetail();
            }
        });
        return view;
    }


    @Override
    public void updateInTheaters(Douban mDouban) {
        mAdapter = new DoubanItemAdapter(getActivity(), mDouban.getSubjects());
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void enterDetail(Douban mDouban, int index) {
        Intent mIntent = new Intent(getActivity(), WebActivity.class);
        mIntent.putExtra("url", mDouban.getSubjects().get(index).getAlt());
        startActivity(mIntent);
    }

    @Override
    public void onError(String result) {

    }
}