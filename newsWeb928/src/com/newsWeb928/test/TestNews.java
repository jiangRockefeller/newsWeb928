package com.newsWeb928.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newsWeb928.DAOImpl.NewsDAOImpl;
import com.newsWeb928.pojo.Comments;
import com.newsWeb928.pojo.News;

public class TestNews {
	
	public static void main(String[] args) {		
		NewsDAOImpl newsDAOImpl=new NewsDAOImpl();
		Transaction tx=null;
		Session session=null;
		session=HibernateSessionFactory.getSession();
		tx=session.beginTransaction();
		News news=new News();
		List<News> list=null;
		try{
			list=newsDAOImpl.findNews();
			
			tx.commit();
		}
		catch(RuntimeException e){
			e.printStackTrace();
			//tx.rollback();
		}finally{
			session.close();
		
	}
		//System.out.println(list.get(0).getNauthor());
		
		//增强for循环	 object类型，需要强行转换
		/*for(Object obj:list){		
			Object [] o=(Object[])obj;
			System.out.println(o[0]+"\t"+o[1]+"\t"+o[2]+"\t"+o[3]);
		}
		System.out.println(list.size());*/
		//增强for循环	实体类
		/*for(News ne:list){
				System.out.println(ne.getNauthor()+"\t"+ne.getNtitle());
		}*/
		
//		for(News ne:list){
//			System.out.println(ne.getNtitle()+"\t"+ne.getNauthor()+"\t"+ne.getNid());
//		}
		
		//动态查询 where xx=? and xxx=?		顺序	
		
		
/*		
		NewsDAOImpl newsDAOImpl=new NewsDAOImpl();
		Transaction tx=null;
		Session session=null;
		session=HibernateSessionFactory.getSession();
		tx=session.beginTransaction();
		//News news=new News();
		List<News> list=null;
		Map<String, Object> map=new HashMap<String, Object>();
		//map.put("nauthor", "sport");
		map.put("nid", 78);
 		try{
			list=newsDAOImpl.findNews(map);
			tx.commit();
		}
		catch(RuntimeException e){
			e.printStackTrace();
			//tx.rollback();
		}finally{
			session.close();
		
	}
		//System.out.println(list.get(0).getNauthor());
		
		for(Object obj:list){
			Object [] o=(Object[])obj;
			System.out.println(o[0]+"\t"+o[1]);
		}

//		for(News ne:list){
//			System.out.println(ne.getNtitle()+"\t"+ne.getNauthor()+"\t"+ne.getNid());
//		}
  	*/
	}
}
