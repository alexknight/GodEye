package com.alex.godeye.adapters;

import android.content.Context;
import android.net.Uri;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alex.godeye.R;
import com.alex.godeye.entites.News;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

import java.util.List;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/18 上午10:43
 */


public class DoubanItemAdapter extends BaseAdapter {

    private LayoutInflater mInflater;
    private List<News> list;
    private Context mContext;

    public DoubanItemAdapter(Context context, List<News> list){
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.list = list;
    }

    @Override
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
        holder.title.setText(list.get(i).getTitle());
        holder.score.setText(list.get(i).getScore());
        holder.style.setText(list.get(i).getStyle());
        try {
            Glide.with(mContext)
                    .load(list.get(i).getImg()) //加载地址
                    .dontAnimate()
                    .listener(new RequestListener<String, GlideDrawable>() {
                                  @Override
                                  public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                      e.printStackTrace();
                                      return true;
                                  }

                                  @Override
                                  public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                      return false;
                                  }

                              })
                    .placeholder(R.drawable.ic_launcher_foreground)//加载未完成时显示占位图
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.imageView);//显示的位置
        } catch (Exception e){
            e.printStackTrace();
        }

        return view;
    }

    private class ViewHolder{
        ImageView imageView;
        TextView title;
        TextView score;
        TextView style;
    }
}
