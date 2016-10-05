package com.newsWeb928.DAOImpl;

import com.newsWeb928.DAOImpl.GenericDAOImpl;
import com.newsWeb928.DAO.TopicDAO;
import com.newsWeb928.pojo.Topic;

public class TopicDAOImpl extends GenericDAOImpl<Topic,Integer> implements TopicDAO {

	public void delete(Topic topic) {
		// TODO Auto-generated method stub
		super.delete(topic);
	}

	public Topic get(Integer id) {
		// TODO Auto-generated method stub
		Topic topic=super.get(id);
		return topic;
	}

}
