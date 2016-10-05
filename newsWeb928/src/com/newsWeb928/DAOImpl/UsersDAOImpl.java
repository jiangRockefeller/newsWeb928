package com.newsWeb928.DAOImpl;

import com.newsWeb928.DAO.UsersDAO;
import com.newsWeb928.pojo.Users;

public class UsersDAOImpl extends GenericDAOImpl<Users,Integer> implements UsersDAO {
	
	public void merge(Users user){
		super.merge(user);
	}
	public void delete(Users user){
		super.delete(user);
	}
	public Users get(Integer id){
		return super.get(id);
	}
}
