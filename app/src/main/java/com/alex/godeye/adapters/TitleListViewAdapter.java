package com.alex.godeye.adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.godeye.R;
import com.alex.godeye.entites.News;

import java.util.List;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/18 上午10:43
 */


public class TitleListViewAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<News> list;

    public TitleListViewAdapter(Context context, List<News> list){
        mInflater = LayoutInflater.from(context);
        this.list = list;
    }

    public TitleListViewAdapter(LayoutInflater inflater, List<News> list){
        mInflater = inflater;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
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
        ViewHolder holder = null;
        if (view == null){
            view = mInflater.inflate(R.layout.display_douban_item, viewGroup, false);
            holder = new ViewHolder();
            holder.imageView = view.findViewById(R.id.imageView);
            holder.title = view.findViewById(R.id.titleTv);
            holder.score = view.findViewById(R.id.scoreTv);
            holder.style = view.findViewById(R.id.styleTv);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        News news = list.get(i);
        holder.imageView.setImageBitmap(news.getImg());
        holder.title.setText(news.getTitle());
        holder.score.setText(news.getScore());
        holder.style.setText(news.getStyle());
        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView score;
        TextView style;
    }
}
