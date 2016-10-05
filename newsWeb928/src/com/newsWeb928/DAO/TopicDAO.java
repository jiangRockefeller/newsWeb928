package com.newsWeb928.DAO;


import com.newsWeb928.pojo.Topic;

public interface TopicDAO extends GenericDAO<Topic,Integer>{

	public void delete(Topic topic);
}
