package com.newsWeb928.DAOImpl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Session;


import com.newsWeb928.DAO.GenericDAO;

public class GenericDAOImpl <T extends Serializable,PK extends Serializable> implements GenericDAO<T, PK>{

	private Class<T> entity;
	public Session session;
	
	public void getSession(){
		session=HibernateSessionFactory.getSession();
	}
	
	public GenericDAOImpl(){
		this.entity=null;
		Class c=this.getClass();
		System.out.println(c);
		Type t=c.getGenericSuperclass();
		System.out.println(t);
		Type[] p=((ParameterizedType) t).getActualTypeArguments();
		System.out.println((Class<T>)p[0]);		
		this.entity=(Class<T>)p[0];
	}
	
	public T get(PK id) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		this.getSession();
		return (T) session.get(entity, id);
	}

	public void delete(T entity){
		this.getSession();
		session.delete(entity);
	}

	public void merge(T entity) {
		// TODO Auto-generated method stub
		this.getSession();
		session.merge(entity);
	}




}
