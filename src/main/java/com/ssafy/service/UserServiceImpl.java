package com.ssafy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.dao.UserDao;
import com.ssafy.vo.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao repo;
	
	@Override
	public int insertUser(User user) {
		return repo.insertUser(user);
	}

	@Override
	public int updateUser(User user) {
		return repo.updateUser(user);
	}

	@Override
	public User searchUser(String id) {
		return repo.searchUser(id);
	}

	@Override
	public int deleteUser(String id) {
		return repo.deleteUser(id);
	}
	
}
