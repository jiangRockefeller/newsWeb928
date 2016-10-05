package com.newsWeb928.serviceImpl;

import java.util.List;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newsWeb928.DAO.NewsDAO;
import com.newsWeb928.DAOImpl.NewsDAOImpl;
import com.newsWeb928.pojo.News;
import com.newsWeb928.service.NewsService;

public class NewsServiceImpl implements NewsService {
	NewsDAO newsDAO=new NewsDAOImpl();
	public void merge(News news) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try{
			newsDAO.merge(news);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		
	}
	public News get(Integer id) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		News news=null;
		try{
			news=newsDAO.get(id);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		return news;
	}

}
