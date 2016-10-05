/*package com.bdqn.news.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.bdqn.news.dao.NewsDAO;
import com.bdqn.news.factory.HibernateSessionFactory;
import com.bdqn.news.pojo.News;
import com.bdqn.news.pojo.Topic;

public class NewsDAOImpl extends GenericDAOImpl<News, Integer> implements NewsDAO {

	//�������Ű���ȡ��Ӧ������						//1
	public List<News> getNewsByTid(Topic topic){
		Session session=HibernateSessionFactory.getSession();
		Query q=session.createQuery("from News news where news.topic.tid=:tid");
		q.setProperties(topic);
		List<News> list=q.list();
		return list;
	}
	
	//�������Ű���ȡ��Ӧ������(��ҳ)
	public List<News> getNewsByTid(Topic topic,Integer page){
		Session session=HibernateSessionFactory.getSession();
		Query q=session.createQuery("from News news where news.topic.tid=:tid");
		q.setProperties(topic);
		//�ӵڼ�����ʼ
		// limit 5,5 �ڶ�ҳ�����ݣ���ʾ5��
		// limit 10,5 ����ҳ�����ݣ���ʾ5��
		q.setFirstResult((page-1)*5);
		//��ʾ������
		q.setMaxResults(5);
		List<News> list=q.list();
		return list;
	}
	
	//����������ѯ����
	public List<News> findNews(Map<String,Object> map){
	
		//���session
		Session session=HibernateSessionFactory.getSession();
		//���һ��Criteria
		Criteria criteria=session.createCriteria(News.class);
		//ͨ��Restrictions�Ӹ��ָ���������
		//select * from News where nauthor = 'sport' or nid>70
		//criteria.add(Restrictions.eq("nauthor", "sport"));
		//������Ĵ���Ĭ����and
		//criteria.add(Restrictions.gt("nid",70));
		//disjunction Ĭ��ȫ�������Ĵ���ʽ��or
		//criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "sport")).add(Restrictions.gt("nid",70)));
		//select * from News where ntitle like 'Ī��%'
		//criteria.add(Restrictions.like("ntitle", "Ī��",MatchMode.ANYWHERE));
		//�ҳ�û�����۵�����
		//criteria.add(Restrictions.isEmpty("comments"));
		//�ҳ���n�����۵�����
		//criteria.add(Restrictions.sizeEq("comments", 5));
		//criteria.add(Restrictions.isNull("npicpath"));
		//criteria.add(Restrictions.eq("npicpath", ""));
		
		//��̬��ѯ
		if(map.get("nauthor")!=null){
			criteria.add(Restrictions.eq("nauthor", map.get("nauthor")));
		}
		
		criteria.addOrder(Order.desc("nid"));
		//ͶӰnauthor �൱��select nauthor from News
		criteria.setProjection(Projections.projectionList()
				.add(Property.forName("nauthor"))
				.add(Property.forName("ntitle")));
		
		//"nauthor","����"
		//"ntitle","%�й�%"
		
		//����Criteriaʵ�ֶ�̬��ѯ
		//��������̬���ͻ��������Ӳ���
		
		List<News> list=criteria.list();
		return list;
	}
}
*/