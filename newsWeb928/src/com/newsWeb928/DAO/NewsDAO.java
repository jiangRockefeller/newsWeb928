package com.newsWeb928.DAO;

import java.util.List;

import com.newsWeb928.pojo.News;

public interface NewsDAO {
	public List<News> getNewsById(News news);
	public void merge(News news);
	public News get(Integer id);
}
