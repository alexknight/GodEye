package com.alex.godeye.ui.douban.view;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.alex.godeye.adapters.douban.DoubanItemAdapter;
import com.alex.godeye.interfaces.IDoubanView;
import com.alex.godeye.models.Douban;

public class HomeView implements IDoubanView{

    private final Context mContext;
    private ListView listView;

    public HomeView(Context context, View view){
        this.mContext= context;
        listView = (ListView) view;
    }

    private DoubanItemAdapter mAdapter;
    @Override
    public void onSuccess(Douban mDouban) {
        mAdapter = new DoubanItemAdapter(mContext, mDouban.getSubjects());
        listView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void onSuccess(Douban mDouban, int index) {

    }

    @Override
    public void onError(String result) {
        Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
    }
}
