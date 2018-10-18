package com.alex.godeye.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alex.godeye.R;
import com.alex.godeye.adapters.TitleListViewAdapter;
import com.alex.godeye.entites.News;

import java.util.ArrayList;
import java.util.List;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/17 下午4:04
 */



public class DoubanFragment extends Fragment {

    private ListView listView;
    private List<News> mNews;
    private TitleListViewAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);
        listView = view.findViewById(R.id.card_listview);
        initData();
        return view;
    }


    private void initData() {
        mNews = new ArrayList<>();

        News news;
        for(int i=0;i<=100;i++) {
            news = new News("https://img1.doubanio.com/view/photo/s_ratio_poster/public/p2533904688.jpg","火影忍者" + i, "7.9"+i , "热血" + i);
            mNews.add(news);
        }
        mAdapter = new TitleListViewAdapter(this.getActivity(), mNews);
        listView.setAdapter(mAdapter);
    }

}