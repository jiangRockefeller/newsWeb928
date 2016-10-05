package com.newsWeb928.DAO;

import java.io.Serializable;

public interface GenericDAO<T extends Serializable,PK extends Serializable> {
	public T get(PK id);
	public void merge(T entity);
	public void delete(T entity);
	
}
