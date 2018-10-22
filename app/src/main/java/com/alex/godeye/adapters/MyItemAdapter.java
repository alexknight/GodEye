package com.alex.godeye.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.alex.godeye.beans.AbstractBean;

import java.util.List;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/22 上午10:45
 */


public abstract class MyItemAdapter<T extends AbstractBean> extends BaseAdapter {

    protected LayoutInflater mInflater;
    protected List<T> list;
    protected Context mContext;

    MyItemAdapter(Context context, List<T> list){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.list = list;
    }

    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
