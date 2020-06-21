package com.springdemo.mapper;

import com.springdemo.model.User;

public interface UserMapper {
	
	User getUser(Integer id);
	
	int insertUser(User user);
	
}
