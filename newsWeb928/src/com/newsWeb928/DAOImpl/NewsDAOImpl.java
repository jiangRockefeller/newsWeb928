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
	
	//无参数查询
	public List<News> findNews(){
		//get session
		Session session=HibernateSessionFactory.getSession();
		//get Criteria
		Criteria criteria=session.createCriteria(News.class);
		
		//通过Restrictions加条件
		//注意参数类型
		
		//disjunction().add  后面的默认为全部处理条件加
		//criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "sport")));
		
		//查询
		//条件之间的处理默认为and
		//criteria.add(Restrictions.eq("nauthor", "sport"));
		//criteria.addOrder(Order.desc("nid"));		
		
		//like'%莫雷%' end结尾 start开始.EXACT精确查询，MatchMode.EXACT
		//criteria.add(Restrictions.like("ntitle", "2", MatchMode.EXACT));
		
		//找出没有评论的新闻
		criteria.add(Restrictions.isEmpty("comments"));		//unfinish
		
		//找出有n条评论的新闻
		//criteria.add(Restrictions.sizeEq("comments", 5));		//unfinish
		
		//criteria.add(Restrictions.isNull("npicpath"));
		
		//gt(great than)大于
		//criteria.add(Restrictions.gt("nid", 80));
		
		//lt(litter than)小于
		//criteria.add(Restrictions.lt("nid", 70));
		
		//disjunction 默认全部条件的处理方式是or
		//criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "sport")).add(Restrictions.gt("nid",70)));
//		criteria.add(Restrictions.disjunction().add(Restrictions.eq("nauthor", "news"))
//				.add(Restrictions.eq("nauthor", "out"))
//				.add(Restrictions.lt("nid", 60))
//				);
		
		//最新发布的一条新闻，根据id或time查询
		//排序再取第一个
		//criteria.addOrder(Order.desc("nid"));
		
		//投影author，相当于 select nAUTHOR FROM NEWS;
		//查询会被后面覆盖
		//criteria.setProjection(Property.forName("nauthor"));
		//criteria.setProjection(Property.forName("NTITLE"));
		
		//查询多个属性
		//返回属性为object，返回的属性个数为四个
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
	
	
	//有参数的动态查询
	public List<News> findNews(Map<String,Object> map){
		Session session=HibernateSessionFactory.getSession();
		//get Criteria
		Criteria criteria=session.createCriteria(News.class);
		
		//动态查询
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
		
		//利用criteria实现动态查询
		//条件，动态，客户决定，加参数
		
		List<News> list=criteria.list();
		return list;
	}


	



}
