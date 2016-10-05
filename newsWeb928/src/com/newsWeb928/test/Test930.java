package com.newsWeb928.test;

import java.util.List;
import java.util.Set;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.newsWeb928.pojo.Comments;
import com.newsWeb928.pojo.News;

public class Test930 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Transaction tx=null;
		Session session=null;
		session=HibernateSessionFactory.getSession();
		tx=session.beginTransaction();
		
		try{
/*			News news=(News) session.get(News.class, 108);
			tx.commit();
						
			
			System.out.println("新闻评论"+news.getNtitle());
			
			Set<Comments> set=news.getCommentses();
			
			for(Comments comments:set){
				System.out.println(comments.getCcontent());
			}*/
			
			
			Query query=session.createQuery("from News");			//注意大小写
			query.setCacheable(true);
			List<News> list=query.list();
			//System.out.println(list.size());
			for(int i=0;i<list.size();i++){
				System.out.println(list.get(i).getNtitle());
				
				Set<Comments> set=list.get(i).getCommentses();
				
				for(Comments comments:set){
					System.out.println(comments.getCcontent());
				}
			}
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
		
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++++");
		
		
		session=HibernateSessionFactory.getSession();
		tx=session.beginTransaction();
		try{
/*			News news=(News) session.get(News.class, 108);
			System.out.println("新闻评论"+news.getNtitle());
			Set<Comments> set=news.getCommentses();
			
			for(Comments comments:set){
				System.out.println(comments.getCcontent());
			}*/
//			Query query=session.createQuery("from News");			//注意大小写
//			query.setCacheable(true);
//			List<News> list=query.list();
//			//System.out.println(list.size());
//			for(int i=0;i<list.size();i++){
//				System.out.println(list.get(i).getNtitle());
//				
//				Set<Comments> set=list.get(i).getCommentses();
//				
//				for(Comments comments:set){
//					System.out.println(comments.getCcontent());
//				}
//			}
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{
			session.close();
		}
	}

}
