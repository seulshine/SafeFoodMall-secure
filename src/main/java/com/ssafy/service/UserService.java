package com.ssafy.service;

import com.ssafy.vo.User;

public interface UserService {
	public int insertUser(User user);
	public int updateUser(User user);
	public User searchUser(String id);
	public int deleteUser(String id);
}
