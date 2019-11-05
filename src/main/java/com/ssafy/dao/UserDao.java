package com.ssafy.dao;

import com.ssafy.vo.User;

public interface UserDao {
	public int insertUser(User user);
	public int updateUser(User user);
	public User searchUser(String id);
	public int deleteUser(String id);
	
	
}
