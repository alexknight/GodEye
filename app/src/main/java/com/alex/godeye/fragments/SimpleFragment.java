package com.alex.godeye.fragments;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.alex.godeye.R;

/**
 * Project: GodEye
 *
 * @author : Alex(qingge)
 * @date : 2018/10/17 下午4:04
 */



public class SimpleFragment extends Fragment {
    private WebView webView;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.web_fragment, container, false);
        webView = view.findViewById(R.id.wv);
        initView();
        webView.loadUrl("http://www.coderlife.site/");
        webView.setWebViewClient(new WebViewClient());

        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
            }
        });

        return view;
    }


    @SuppressLint("SetJavaScriptEnabled")
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    private void initView() {
        WebSettings setting = webView.getSettings();
        setting.setJavaScriptEnabled(true);//支持Js
        setting.setCacheMode(WebSettings.LOAD_DEFAULT);//缓存模式
        //是否支持画面缩放，默认不支持
        setting.setBuiltInZoomControls(true);
        setting.setSupportZoom(true);
        //是否显示缩放图标，默认显示
        setting.setDisplayZoomControls(false);
        //设置网页内容自适应屏幕大小
        setting.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);//注意网上例程很多的是.SINGLE_COLUMN，但调试时发现移动版网站会错位，所以改成
    }
}