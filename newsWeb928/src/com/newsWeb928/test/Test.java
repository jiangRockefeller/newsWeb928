/*package com.bdqn.news.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bdqn.news.factory.HibernateSessionFactory;
import com.bdqn.news.pojo.News;
import com.bdqn.news.service.impl.NewsServiceImpl;

public class Test {
	public static void main(String[] args) {
		NewsServiceImpl newsServiceImpl=new NewsServiceImpl();
		Transaction transaction = null;
		Session session = null;
		List<News> list=new ArrayList<News>();
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("nauthor", "sport");
		map.put("ntitle", "�й�");
		try{
		session = HibernateSessionFactory.getSession();
		transaction = session.beginTransaction();
		list=newsServiceImpl.findNews(map);
		transaction.commit();
		}
		catch(RuntimeException e){
			e.printStackTrace();
			transaction.rollback();
		}
		finally{
			session.close();
		}
		//select id,name,password from News  ͶӰ
		for(Object obj:list){
			Object [] o=(Object[])obj;
			System.out.println(o[0]+"\t"+o[1]);
		}
		//������ ��ǿ��forѭ��	
//		for(News news:list){
//			System.out.println(news.getNid()+"\t"+news.getNtitle()+"\t"+news.getNauthor());
//		}
		
		//��̬��ѯ where xx=? and xxx=?  ˳��
	}
}
*/