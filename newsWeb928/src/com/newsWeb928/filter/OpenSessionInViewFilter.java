package com.newsWeb928.filter;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import newsWeb928.uitl.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class OpenSessionInViewFilter implements Filter{
	public void destroy() {
		// TODO Auto-generated method stub		
	}

	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub		
		Transaction tx=null;
		Session session=null;
		try{
			session=HibernateSessionFactory.getSession();
			tx=session.beginTransaction();
			chain.doFilter(request, response);
			tx.commit();
		}catch(RuntimeException e){
			e.printStackTrace();
			tx.rollback();
		}finally{			
		}		
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub		
	}
}
