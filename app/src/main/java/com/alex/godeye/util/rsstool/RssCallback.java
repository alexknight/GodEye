package com.alex.godeye.util.rsstool;

import java.util.List;

public interface RssCallback {
	public void OnPreLoad();
	public void OnLoaded(List<Article> articleList);
	public void OnLoadFailed();
}