package com.alex.godeye.ui.douban.view;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.alex.godeye.interfaces.IDoubanView;
import com.alex.godeye.models.Douban;
import com.alex.godeye.ui.WebActivity;

public class DetailView implements IDoubanView{

    private final Context mContext;

    public DetailView(Context context){
        this.mContext= context;
    }

    @Override
    public void onSuccess(Douban mDouban) {

    }

    @Override
    public void onSuccess(Douban mDouban, int index) {
        Intent mIntent = new Intent(mContext, WebActivity.class);
        mIntent.putExtra("url", mDouban.getSubjects().get(index).getAlt());
        mContext.startActivity(mIntent);
    }

    @Override
    public void onError(String result) {
        Toast.makeText(mContext, result, Toast.LENGTH_SHORT).show();
    }
}
