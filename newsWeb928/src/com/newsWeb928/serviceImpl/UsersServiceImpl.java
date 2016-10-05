package com.newsWeb928.serviceImpl;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newsWeb928.DAO.UsersDAO;
import com.newsWeb928.DAOImpl.UsersDAOImpl;
import com.newsWeb928.pojo.Users;
import com.newsWeb928.service.UsersService;

public class UsersServiceImpl implements UsersService {
	UsersDAO usersDAO=new UsersDAOImpl();
	public void merge(Users user) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		try{
			usersDAO.merge(user);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

	public void delete(Users user) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();
		Transaction tx=session.beginTransaction();
		//Users users1=null;
		
		try{
			Users users1=usersDAO.get(user.getId());
			usersDAO.delete(users1);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

}
