package com.alex.godeye.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/16 上午11:18
 */


public class RssUtil {

    private final String url;

    public RssUtil(String url){
        this.url = url;
    }

    public static Bitmap getHttpBitmap(final String url){

        URL httpUrl = null;
        Bitmap bitmap = null;
        try {
            httpUrl = new URL(url);
            HttpURLConnection conn = (HttpURLConnection) httpUrl.openConnection();
            conn.setConnectTimeout(6000);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            InputStream in = conn.getInputStream();
            bitmap = BitmapFactory.decodeStream(in);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bitmap;

    }
}
