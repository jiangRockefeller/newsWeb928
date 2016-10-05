package com.newsWeb928.DAO;

import com.newsWeb928.pojo.Users;

public interface UsersDAO {
	public Users get(Integer id);
	public void merge(Users user);
	public void delete(Users user);
}
