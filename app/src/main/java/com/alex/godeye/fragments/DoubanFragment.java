package com.alex.godeye.fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.alex.godeye.R;
import com.alex.godeye.activities.WebActivity;
import com.alex.godeye.adapters.DoubanItemAdapter;
import com.alex.godeye.beans.Douban;
import com.alex.godeye.network.HttpUtils;
import com.alex.godeye.network.HttpCallBack;
import com.alibaba.fastjson.JSON;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/17 下午4:04
 */



public class DoubanFragment extends Fragment {

    private static final int UPDATE = 1;
    private ListView listView;
    private WebView webView;
    private DoubanItemAdapter mAdapter;
    private Douban douban;

    @SuppressLint("HandlerLeak")
    Handler mHandler = new Handler(){

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case UPDATE:
                    mAdapter = new DoubanItemAdapter(getContext(), douban.getSubjects());
                    listView.setAdapter(mAdapter);
                    mAdapter.notifyDataSetChanged();
                    break;
                default:
                    break;
            }
        }

    };

    @Nullable
    @Override
    public View onCreateView(@NonNull final LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.card_fragment, container, false);
        listView = view.findViewById(R.id.card_listview);
        initData();
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent mIntent = new Intent(getActivity(), WebActivity.class);
                mIntent.putExtra("url", douban.getSubjects().get(i).getAlt());
                startActivity(mIntent);
            }
        });
        return view;
    }


    private void initData() {
        HttpUtils.getInstance().sendRequestByOkHttp("http://api.douban.com/v2/movie/in_theaters", new HttpCallBack() {
            @Override
            public void onResponse(Object o) {
                douban = JSON.parseObject((String) o, Douban.class);
                Message msg = mHandler.obtainMessage();
                msg.what = UPDATE;
                msg.obj = douban;
                mHandler.sendMessage(msg);
            }
        });
    }

}