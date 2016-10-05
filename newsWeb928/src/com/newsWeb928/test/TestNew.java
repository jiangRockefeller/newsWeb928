package com.newsWeb928.test;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.newsWeb928.pojo.News;
import com.newsWeb928.service.NewsService;
import com.newsWeb928.serviceImpl.NewsServiceImpl;

public class TestNew {	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NewsService newsService=new NewsServiceImpl();
		News news=newsService.get(48);
		Set set= news.getCommentses();
		//System.out.println(news.getNtitle());
//		Iterator<News> iterator=set.iterator();
//		while(iterator.hasNext()){
//			News news1=iterator.next();
//			System.out.println(news1.getNtitle());
//		}
		
		//Set<News> set=news.getCommentses();
//		for(News news1:set){
//			System.out.println(news1.getNtitle());
//		
		//System.out.println(news.getNtitle());
		System.out.println(set.size());
	}

}
