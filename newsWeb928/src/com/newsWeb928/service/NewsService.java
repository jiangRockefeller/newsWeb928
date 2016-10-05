package com.newsWeb928.service;

import com.newsWeb928.pojo.News;

public interface NewsService {
	public void merge(News news);
	public News get(Integer id);
}
