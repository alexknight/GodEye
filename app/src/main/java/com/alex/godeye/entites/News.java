package com.alex.godeye.entites;

import android.graphics.Bitmap;

import com.alex.godeye.util.RssUtil;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/18 上午10:09
 */


public class News {

    private String title;
    private String score;
    private String img;
    private String style;

    public News(String title, String score, String style){
        this.title = title;
        this.score = score;
        this.style = style;
    }

    public News(String img, String title, String score, String style){
        this.title = title;
        this.img = img;
        this.score = score;
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public Bitmap getImg() {
        return RssUtil.getHttpBitmap(img);
    }

    public void setImg(String img) {
        this.img = img;
    }
}
