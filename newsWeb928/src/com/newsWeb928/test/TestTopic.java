package com.newsWeb928.test;

import java.util.Iterator;
import java.util.Set;
import com.newsWeb928.pojo.News;
import com.newsWeb928.pojo.Topic;
import com.newsWeb928.serviceImpl.TopicServiceImpl;

public class TestTopic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//get 	立刻查询 
		//load  延迟加载
		TopicServiceImpl topicService=new TopicServiceImpl();
		Topic topic1=topicService.get(1);
		System.out.println(topic1.getTname());
		//迭代器
//		Set set=topic1.getNewses();
//		Iterator<News> iterator=set.iterator();
//		while(iterator.hasNext()){
//			News news1=iterator.next();
//			System.out.println(news1.getNcontent());
//		}
		
		//增强for循环
		Set<News> set=topic1.getNewses();
//		//System.out.println(topic1.getTname());
//		for(News news1:set){
//			System.out.println(news1.getNtitle());
//		}
		
		System.out.println(set.size());
		
		for(News news1:set){
			System.out.println(news1.getNtitle());
		}
	}
		
	

}
