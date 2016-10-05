package com.newsWeb928.test;

import com.newsWeb928.pojo.Users;
import com.newsWeb928.service.UsersService;
import com.newsWeb928.serviceImpl.UsersServiceImpl;

public class TestUsers {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		UsersService usersService=new UsersServiceImpl();
		Users users=new Users();
		users.setId(12);
		//users.setName("13");
		//users.setPassword(12);
		usersService.delete(users);
	}

}
