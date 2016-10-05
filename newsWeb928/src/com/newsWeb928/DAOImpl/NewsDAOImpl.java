package com.newsWeb928.DAOImpl;

import java.util.List;
import java.util.Map;

import newsWeb928.uitl.HibernateSessionFactory;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;
import org.hibernate.validator.Max;

import com.newsWeb928.DAO.NewsDAO;
import com.newsWeb928.pojo.News;

public class NewsDAOImpl extends GenericDAOImpl<News,Integer> implements NewsDAO {
	
	public News get(Integer id){
		
		return super.get(id);
		
	}
	
	public List<News> getNewsById(News news) {
		// TODO Auto-generated method stub
		Session session=HibernateSessionFactory.getSession();		
		return null;
	}
	
	public void merge(News news) {
		// TODO Auto-generated method stub
		super.merge(news);
	}
	
	//�޲�����ѯ
	public List<News> findNews(){
		//get session
		Session session=HibernateSessionFactory.getSession();
		//get Criteria
		Criteria criteria=session.createCriteria(News.class);
		
		//ͨ��Restrictions������
		//ע���������
		
		//disjunction().add  �����Ĭ��Ϊȫ������������
		//criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "sport")));
		
		//��ѯ
		//����֮��Ĵ���Ĭ��Ϊand
		//criteria.add(Restrictions.eq("nauthor", "sport"));
		//criteria.addOrder(Order.desc("nid"));		
		
		//like'%Ī��%' end��β start��ʼ.EXACT��ȷ��ѯ��MatchMode.EXACT
		//criteria.add(Restrictions.like("ntitle", "2", MatchMode.EXACT));
		
		//�ҳ�û�����۵�����
		criteria.add(Restrictions.isEmpty("comments"));		//unfinish
		
		//�ҳ���n�����۵�����
		//criteria.add(Restrictions.sizeEq("comments", 5));		//unfinish
		
		//criteria.add(Restrictions.isNull("npicpath"));
		
		//gt(great than)����
		//criteria.add(Restrictions.gt("nid", 80));
		
		//lt(litter than)С��
		//criteria.add(Restrictions.lt("nid", 70));
		
		//disjunction Ĭ��ȫ�������Ĵ���ʽ��or
		//criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "sport")).add(Restrictions.gt("nid",70)));
//		criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "news"))
//				.add(Restrictions.eq("nauthor", "out"))
//				.add(Restrictions.lt("nid", 60))
//				);
		
		//���·�����һ�����ţ�����id��time��ѯ
		//������ȡ��һ��
		//criteria.addOrder(Order.desc("nid"));
		
		//ͶӰauthor���൱�� select nAUTHOR FROM NEWS;
		//��ѯ�ᱻ���渲��
		//criteria.setProjection(Property.forName("nauthor"));
		//criteria.setProjection(Property.forName("NTITLE"));
		
		//��ѯ�������
		//��������Ϊobject�����ص����Ը���Ϊ�ĸ�
		/*criteria.setProjection(Projections.projectionList()
				.add(Property.forName("nauthor"))
				.add(Property.forName("ntitle"))
				.add(Property.forName("nid"))
				.add(Property.forName("ncreatedate"))
				);*/
		
//		criteria.setProjection(Projections.projectionList()
//				.add(Property.forName("nauthor"))
//				.add(Property.forName("ntitle")));	
		List<News> list=criteria.list();		
		return list;
	}
	
	
	//�в����Ķ�̬��ѯ
	public List<News> findNews(Map<String,Object> map){
		Session session=HibernateSessionFactory.getSession();
		//get Criteria
		Criteria criteria=session.createCriteria(News.class);
		
		//��̬��ѯ
		if(map.get("nauthor")!=null){
			criteria.add(Restrictions.eq("nauthor", map.get("nauthor")));
		}if(map.get("ntid")!=null){
			criteria.add(Restrictions.eq("topic", map.get("topic")));
		}if(map.get("topic")!=null){
			criteria.add(Restrictions.eq("nid", map.get("nid")));
		}
		criteria.addOrder(Order.desc("nid"));
		criteria.setProjection(Projections.projectionList()
				.add(Property.forName("nauthor"))
				//.add(Property.forName("topic"))
				.add(Property.forName("ntitle")));
		
		//"nauthor","lier"
		//"ntitle","%china%"
		
		//����criteriaʵ�ֶ�̬��ѯ
		//��������̬���ͻ��������Ӳ���
		
		List<News> list=criteria.list();
		return list;
	}


	



}
