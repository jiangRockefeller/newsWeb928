package com.newsWeb928.serviceImpl;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.newsWeb928.DAO.TopicDAO;
import com.newsWeb928.DAOImpl.TopicDAOImpl;

import com.newsWeb928.pojo.Topic;
import com.newsWeb928.service.TopicService;

public class TopicServiceImpl implements TopicService {
	TopicDAO topicDAO=new TopicDAOImpl();
	
	public Topic get(Integer id) {
		// TODO Auto-generated method stub
			Topic newtopic=null;
			newtopic=topicDAO.get(id);		
			return newtopic;
	}
	
	public void delete(Topic topic) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try{
			Topic newtopic=topicDAO.get(topic.getTid());
			session.delete(newtopic);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}
	}

}
