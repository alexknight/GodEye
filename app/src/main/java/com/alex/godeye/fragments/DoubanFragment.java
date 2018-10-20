package com.alex.godeye.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.alex.godeye.R;
import com.alex.godeye.adapters.DoubanItemAdapter;
import com.alex.godeye.entites.News;
import com.alex.godeye.pkrss.Article;
import com.alex.godeye.pkrss.PkRSS;

import java.io.UnsupportedEncodingException;
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
    private DoubanItemAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);
        listView = view.findViewById(R.id.card_listview);
        initData();
        return view;
    }


    private void initData() {
        List<Article> articleList = PkRSS.with(getContext()).get("https://rsshub.app/douban/movie/playing");
        for(int i=0;i<articleList.size();i++){
            String title = encode(articleList.get(i).getTitle());
            String desc = encode(articleList.get(i).getDescription());
            String url = articleList.get(i).getSource().toString();

            System.out.println(title);
        }
        mNews = new ArrayList<>();
        News news;
        for(int i=0;i<=5;i++) {
            news = new News("https://img3.doubanio.com/view/photo/s_ratio_poster/public/p2535096871.webp","火影忍者" + i, "7.9"+i , "热血" + i);
            mNews.add(news);
        }
        mAdapter = new DoubanItemAdapter(this.getActivity(), mNews);
        listView.setAdapter(mAdapter);
    }

    private String encode(String content){
        try {
            return new String(content.getBytes("ISO-8859-1"),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return "";
    }

}