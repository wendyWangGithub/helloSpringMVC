package com.springdemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.mapper.UserMapper;
import com.springdemo.model.User;

@Service
public class UserService {

	@Autowired
	private UserMapper userMapper;
	
	public User queryById(Integer id) {
		User user = userMapper.getUser(id);
		return user;
	}
	
	public Integer add(User user) {
		userMapper.insertUser(user);
		return user.getId();
	}
	
}
