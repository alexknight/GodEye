package com.alex.godeye.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alex.godeye.R;
import com.alex.godeye.beans.Douban;
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


public class DoubanItemAdapter extends MyItemAdapter {


    public DoubanItemAdapter(Context context, List<Douban.SubjectsBean> list){
        super(context, list);
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
        Douban.SubjectsBean dsb = ((Douban.SubjectsBean) this.list.get(i));
        holder.title.setText(String.format("电影：%s", ((Douban.SubjectsBean) this.list.get(i)).getTitle()));
        holder.score.setText(String.format("评分：%s", String.valueOf(dsb.getRating().getAverage())));
        holder.style.setText(String.format("类型：%s", dsb.getGenres().toString().substring(1, dsb.getGenres().toString().length()-1)));
        try {
            Glide.with(mContext)
                    .load(dsb.getImages().getSmall()) //加载地址
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
                    .placeholder(R.drawable.layout_divider_vertical)//加载未完成时显示占位图
                    .diskCacheStrategy(DiskCacheStrategy.NONE)
                    .into(holder.imageView);
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
