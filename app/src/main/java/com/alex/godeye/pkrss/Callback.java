package com.alex.godeye.pkrss;

import com.alex.godeye.pkrss.Article;

import java.util.List;

public interface Callback {
	public void OnPreLoad();
	public void OnLoaded(List<Article> articleList);
	public void OnLoadFailed();
}