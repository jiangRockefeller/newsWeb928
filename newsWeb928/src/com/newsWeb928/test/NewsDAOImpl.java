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

	//根据新闻板块获取对应的新闻						//1
	public List<News> getNewsByTid(Topic topic){
		Session session=HibernateSessionFactory.getSession();
		Query q=session.createQuery("from News news where news.topic.tid=:tid");
		q.setProperties(topic);
		List<News> list=q.list();
		return list;
	}
	
	//根据新闻板块获取对应的新闻(分页)
	public List<News> getNewsByTid(Topic topic,Integer page){
		Session session=HibernateSessionFactory.getSession();
		Query q=session.createQuery("from News news where news.topic.tid=:tid");
		q.setProperties(topic);
		//从第几条开始
		// limit 5,5 第二页的内容，显示5条
		// limit 10,5 第三页的内容，显示5条
		q.setFirstResult((page-1)*5);
		//显示多少条
		q.setMaxResults(5);
		List<News> list=q.list();
		return list;
	}
	
	//根据条件查询新闻
	public List<News> findNews(Map<String,Object> map){
	
		//获得session
		Session session=HibernateSessionFactory.getSession();
		//获得一个Criteria
		Criteria criteria=session.createCriteria(News.class);
		//通过Restrictions加各种各样的条件
		//select * from News where nauthor = 'sport' or nid>70
		//criteria.add(Restrictions.eq("nauthor", "sport"));
		//条件间的处理默认是and
		//criteria.add(Restrictions.gt("nid",70));
		//disjunction 默认全部条件的处理方式是or
		//criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "sport")).add(Restrictions.gt("nid",70)));
		//select * from News where ntitle like '莫雷%'
		//criteria.add(Restrictions.like("ntitle", "莫雷",MatchMode.ANYWHERE));
		//找出没有评论的新闻
		//criteria.add(Restrictions.isEmpty("comments"));
		//找出有n条评论的新闻
		//criteria.add(Restrictions.sizeEq("comments", 5));
		//criteria.add(Restrictions.isNull("npicpath"));
		//criteria.add(Restrictions.eq("npicpath", ""));
		
		//动态查询
		if(map.get("nauthor")!=null){
			criteria.add(Restrictions.eq("nauthor", map.get("nauthor")));
		}
		
		criteria.addOrder(Order.desc("nid"));
		//投影nauthor 相当于select nauthor from News
		criteria.setProjection(Projections.projectionList()
				.add(Property.forName("nauthor"))
				.add(Property.forName("ntitle")));
		
		//"nauthor","张三"
		//"ntitle","%中国%"
		
		//利用Criteria实现动态查询
		//条件，动态，客户决定，加参数
		
		List<News> list=criteria.list();
		return list;
	}
}
*/